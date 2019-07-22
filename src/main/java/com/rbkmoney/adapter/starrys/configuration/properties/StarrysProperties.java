package com.rbkmoney.adapter.starrys.configuration.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Validated
@Configuration
@ConfigurationProperties("starrys")
public class StarrysProperties {

    @NotEmpty
    private String url;

}
