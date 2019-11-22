package com.rbkmoney.adapter.starrys.configuration;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.metrics.web.client.MetricsRestTemplateCustomizer;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.time.Duration;


@Configuration
public class RestTemplateConfiguration {

    @Value("${restTemplate.maxTotalPooling}")
    private int maxTotalPooling;

    @Value("${restTemplate.defaultMaxPerRoute}")
    private int defaultMaxPerRoute;

    @Value("${restTemplate.requestTimeout}")
    private int requestTimeout;

    @Value("${restTemplate.poolTimeout}")
    private int poolTimeout;

    @Value("${restTemplate.connectionTimeout}")
    private int connectionTimeout;

    @Bean
    public PoolingHttpClientConnectionManager poolingHttpClientConnectionManager() {
        PoolingHttpClientConnectionManager result = new PoolingHttpClientConnectionManager();
        result.setMaxTotal(maxTotalPooling);
        result.setDefaultMaxPerRoute(defaultMaxPerRoute);
        return result;
    }

    @Bean
    public RequestConfig requestConfig() {
        return RequestConfig.custom()
                .setConnectionRequestTimeout(poolTimeout)
                .setConnectTimeout(connectionTimeout)
                .setSocketTimeout(requestTimeout)
                .build();
    }

    @Bean
    public SSLContext sslContext() throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
        return new SSLContextBuilder()
                .loadTrustMaterial(null, (x509Certificates, s) -> true)
                .build();
    }

    @Bean
    public CloseableHttpClient httpClient(
            PoolingHttpClientConnectionManager manager,
            RequestConfig requestConfig,
            SSLContext sslContext) {
        return HttpClients.custom()
                .setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE)
                .setSSLContext(sslContext)
                .setConnectionManager(manager)
                .setDefaultRequestConfig(requestConfig)
                .disableAutomaticRetries()
                .setConnectionManagerShared(true)
                .build();
    }


    @Bean
    public HttpComponentsClientHttpRequestFactory requestFactory(CloseableHttpClient httpClient) {
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setHttpClient(httpClient);
        return requestFactory;
    }

    @Bean
    public RestTemplateBuilder restTemplateBuilder(HttpComponentsClientHttpRequestFactory requestFactory,
                                                   MetricsRestTemplateCustomizer metricsRestTemplateCustomizer) {
        return new RestTemplateBuilder()
                .requestFactory(() -> requestFactory)
                .additionalCustomizers(metricsRestTemplateCustomizer);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        RestTemplate restTemplate = restTemplateBuilder
                .setConnectTimeout(Duration.ofMillis(connectionTimeout))
                .setReadTimeout(Duration.ofMillis(requestTimeout))
                .build();
        restTemplate.setErrorHandler(getDefaultResponseErrorHandler());
        setMessageConverter(restTemplate);
        return restTemplate;
    }

    private void setMessageConverter(RestTemplate restTemplate) {
        for (HttpMessageConverter converter : restTemplate.getMessageConverters()) {
            if (converter instanceof StringHttpMessageConverter) {
                ((StringHttpMessageConverter) converter).setWriteAcceptCharset(false);
            }
        }
    }

    private DefaultResponseErrorHandler getDefaultResponseErrorHandler() {
        return new DefaultResponseErrorHandler() {
            @Override
            protected boolean hasError(HttpStatus statusCode) {
                return false;
            }
        };
    }

}
