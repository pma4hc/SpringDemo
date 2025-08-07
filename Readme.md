# Spring Boot Application Demo

This repository contains a Spring Boot application with the following APIs and features.

---

## APIs (Default Profile)

- **GET** `/demo/hello?name=${text}`
  Sleeps for 10 seconds, then returns: `Hello ${text}!`

- **GET** `/demo/setting`
  Returns the value of the property `demo_setting`.

- **GET** `/demo/secret`
  Returns the value of the property `demo_secret`.

- **GET** `/demo/call`
  Calls an external API using the `GET` method. The full endpoint is the value of the property `api_test`.

---

## Enable SQL Profile ("sql")

To enable Azure SQL features, set the following environment variables:
```bash
SPRING_PROFILES_ACTIVE=sql
connection_string=${your connection string}
```

- **GET** `/sql/check`
  return success if profile "sql" was enabled successful

- **GET** `/sql/insert`
  insert a record to integrated Azure SQL database - todo table

- **GET** `/sql/get`
  get all records in todo table


## Enable Key Vault Profile ("keyvault")
if the profile is enabled, you can add environment variables to your app service to integrate with this app:
DEMO_SECRET=@Microsoft.KeyVault(SecretUri=https://${your-keyvault-name}.vault.azure.net/secrets/demo-secret/)
value of property demo_secret will be retrieved from Azure Key Vault and return to api /keyvault/secret
```bash
SPRING_PROFILES_ACTIVE=sql,keyvault
DEMO_SECRET=${your keyvault secret link as above template}
```

- **GET** `/keyvault/secret`
  return value of DEMO_SECRET, if we integrated the app with Azure Key vault successfully, it will return value of the Key vault secret




## Enable H2 Profile ("h2")

Can not enable together with "sql" profile
The APIs are the same with "sql" profile but data stored in RAM
To enable Azure SQL features, set the following environment variables:
```bash
SPRING_PROFILES_ACTIVE=h2
```



## Steps to build docker image and push it to ACR
mvn clean package
docker build -t pma4acr.azurecr.io/springdemo:latest .
az account set --subscription BD-XDV-Learning-Sandbox
az acr login --name pma4acr
docker login pma4acr.azurecr.io
docker push pma4acr.azurecr.io/springdemo:latest
az acr repository list --name pma4acr --output table

az aks get-credentials --resource-group pma4hc --name pma4aks