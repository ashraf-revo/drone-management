# Read Me First
The following was discovered as part of building this project:

* The original package name 'com.asrevo.drone-management' is invalid and this project uses 'com.asrevo.drone_management' instead.

# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/3.3.5/gradle-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.3.5/gradle-plugin/packaging-oci-image.html)
* [Spring Boot Testcontainers support](https://docs.spring.io/spring-boot/3.3.5/reference/testing/testcontainers.html#testing.testcontainers)
* [Testcontainers Postgres Module Reference Guide](https://java.testcontainers.org/modules/databases/postgres/)
* [Spring Web](https://docs.spring.io/spring-boot/3.3.5/reference/web/servlet.html)
* [Testcontainers](https://java.testcontainers.org/)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/3.3.5/reference/actuator/index.html)
* [Spring Data JDBC](https://docs.spring.io/spring-boot/3.3.5/reference/data/sql.html#data.sql.jdbc)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)
* [Using Spring Data JDBC](https://github.com/spring-projects/spring-data-examples/tree/master/jdbc/basics)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

### Testcontainers support

This project uses [Testcontainers at development time](https://docs.spring.io/spring-boot/3.3.5/reference/features/dev-services.html#features.dev-services.testcontainers).

Testcontainers has been configured to use the following Docker images:

* [`postgres:latest`](https://hub.docker.com/_/postgres)

Please review the tags of the used images and set them to the same as you're running in production.

