# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.9/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.9/gradle-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.2.9/reference/htmlsingle/index.html#web)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

### Spring Boot Session 1
Add Dependency 
1. Spring Web: Spring Web is a module in the Spring Framework that provides a set of features for building web applications.Build web, including RESTful, applications using Spring MVC. Uses Apache Tomcat as the default embedded container. It includes support for:

- HTTP requests and responses: Spring Web provides a way to handle HTTP requests and responses, including support for HTTP methods (GET, POST, PUT, DELETE, etc.), request and response bodies, and HTTP headers.
- Request mapping: Spring Web allows you to map HTTP requests to specific controller methods using annotations such as @GetMapping, @PostMapping, @PutMapping, and @DeleteMapping.
- View resolution: Spring Web provides a way to resolve views, which are responsible for rendering the response to the client.
- Internationalization and localization: Spring Web provides support for internationalization and localization, including support for multiple languages and locales.
2. Lombok : Lombok is a Java library that automatically plugs into your compiler (Eclipse, Maven, Gradle, Ant, etc.) and allows you to reduce boilerplate code in your Java classes.

In a Spring Boot application, Lombok is often used to simplify the creation of Java classes by automatically generating:

- Getters and setters: Lombok can generate getters and setters for your class fields, eliminating the need to write them manually.
- Constructors: Lombok can generate constructors for your class, including constructors with parameters.
  ToString, Equals, and HashCode methods: Lombok can generate these methods for your class, which are often required for proper object comparison and hashing.

To use Lombok in a Spring Boot application, you need to add the Lombok dependency to your project. For example, in a Maven project, you would add the following dependency to your pom.xml file: