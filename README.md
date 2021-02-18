# spring-webmvc-jwt-sample

![build](https://github.com/hantsy/spring-webmvc-jwt-sample/workflows/build/badge.svg)

## What is this?

This is a sample project demos how to use JWT token based authentication to protect the RESTful APIs in a Spring WebMVC application.

> The original codes are written in Spring Boot 2.0, it is already updated to the latest Spring Boot 2.4.
> If you are looking for a variant of Spring WebFlux, check [spring-reactive-jwt-sample](https://github.com/hantsy/spring-reactive-jwt-sample/) for more details.

## Guide

Check the [detailed  step-by-step GUIDE](./GUIDE.md) to get the explanation of the code examples.  

## Prerequisites

Make sure you have installed the following software.

* Java 11
* Apache Maven 3.6.x
* Docker

## Build 

Clone the source codes from Github.

```bash
git clone https://github.com/hantsy/spring-webmvc-jwt-sample
```

Open a terminal, and switch to the root folder of the project, and run the following command to build the whole project.

```bash
docker-compose up postgres // to start up a postgres
mvn clean install // build the project
```

Run the application.

```bash
mvn spring-boot:run
// or from command line
java -jar target/xxx.jar
```


## Contribution

Any suggestions are welcome, filing an issue or submitting a PR is also highly recommend.  