# [What Is Spring Boot?](https://www.baeldung.com/spring-vs-spring-boot)
Spring Boot is basically an extension of the Spring framework, which eliminates the boilerplate configurations required for setting up a Spring application.

Here are just a few of the features in Spring Boot:

- Opinionated ‘starter' dependencies to simplify the build and application configuration
- Embedded server to avoid complexity in application deployment
- Metrics, Health check, and externalized configuration
- Automatic config for Spring functionality – whenever possible
---
Spring Boot offers a fast way to build applications. 
It looks at your classpath and at the beans you have configured, makes reasonable assumptions about what you are missing, and adds those items. 
With Spring Boot, you can focus more on business features and less on infrastructure.

The following examples show what Spring Boot can do for you:

- Is Spring MVC on the classpath? There are several specific beans you almost always need, and Spring Boot adds them automatically. A Spring MVC application also needs a servlet container, so Spring Boot automatically configures embedded Tomcat.

- Is Jetty on the classpath? If so, you probably do NOT want Tomcat but instead want embedded Jetty. Spring Boot handles that for you.

- Is Thymeleaf on the classpath? If so, there are a few beans that must always be added to your application context. Spring Boot adds them for you.

https://github.com/spring-projects/spring-boot/tree/main/spring-boot-project


# [Spring Boot gradle plugin](https://docs.spring.io/spring-boot/docs/current/gradle-plugin/reference/htmlsingle/#introduction)

When you apply the io.spring.dependency-management plugin, Spring Boot’s plugin will automatically import the spring-boot-dependencies bom from the version of Spring Boot that you are using. This provides a similar dependency management experience to the one that’s enjoyed by Maven users. For example, it allows you to omit version numbers when declaring dependencies that are managed in the bom. To make use of this functionality, declare dependencies in the usual way but omit the version number:

