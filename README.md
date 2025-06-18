# spring-webmvc-jwt-sample

![build](https://github.com/hantsy/spring-webmvc-jwt-sample/workflows/build/badge.svg)

## What is this?

This is a sample project that demonstrates how to use JWT token-based authentication to protect RESTful APIs in a Spring Web MVC application.

>
> [!note]
>If you are interested in the new variant built with the Spring WebFlux stack, check [spring-reactive-jwt-sample](https://github.com/hantsy/spring-reactive-jwt-sample/) for more details.

## Guide

Please refer to the [step-by-step guide](./GUIDE.md) for a detailed explanation of the example codes.  

> The original code was written in Spring Boot 2.0.  There are some slight differences in the main/master branch due to the changes introduced in the latest Spring Boot 3.x.

## Prerequisites

Please ensure that you have installed the following software.

* Java 21
* Apache Maven 3.9.x/4.0.0+
* Docker

## Build

Clone the source code from GitHub.

```bash
git clone https://github.com/hantsy/spring-webmvc-jwt-sample
```

Open a terminal, switch to the project's root folder, and run the following command to build the entire project.

```bash
docker compose up postgres // start up a postgres
mvn clean install // build the project
```

Please proceed with executing the following command to run the application.

```bash
mvn spring-boot: run
// or from the command line after building
java -jar target/xxx.jar
```

## Contribution

Any suggestions are welcome, filing an issue or submitting a PR is also highly recommended.

