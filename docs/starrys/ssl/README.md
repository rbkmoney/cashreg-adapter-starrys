# Сертификат

Данные для работы с сертификатом


##### Проверка запроса в тестовой среде:
```
curl -vk -d @test.txt --key private.key --cert rbkmoney.crt https://fce.starrys.ru:4443/fr/api/v2/Complex | jq
```
ps файл можно взять в папке `benchmark/starrys`



##### Чтение содержимого сертификата:

```
openssl x509 -in rbkmoney.crt -text -noout
```


##### Чтение содержимое приватного ключа:
```
openssl rsa -in private.key -noout -text
```


##### Перевод в формат p12
```
openssl pkcs12 -export -out certificate.p12 -inkey private.key -in rbkmoney.crt 
```
