# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.0.0/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.0.0/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.0.0/reference/htmlsingle/#web)

### Guides

The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

### TYPESCRIPT STUB GENERATION

### [Thanks to stefanwille - A Guide to OpenAPI Code Generation for TypeScript](https://www.stefanwille.com/2021/05/2021-05-30-openapi-code-generator-for-typescript)

- Following command will generate ts object

| Command                                                                                                                                                                | Description                                                                                                                     |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------|
| **openapi-generator-cli generate -i model.yaml -o ../ts/model -g typescript-fetch --additional-properties=supportsES6=true,npmVersion=9.2.0,typescriptThreePlus=true** | Generate Stubs for typescript using openapi command - -i to specify the specification file - -o to specify the output directory |
| -i                                                                                                                                                                     | to specify the specification file                                                                                               |
| -o                                                                                                                                                                     | to specify the output directory                                                                                                 |
| -g                                                                                                                                                                     | to select the desired output format (TypeScript and fetch())                                                                    |
|                                                                                                                                                                        | --additional-properties to select some options specific to the selected output format.                                          |
