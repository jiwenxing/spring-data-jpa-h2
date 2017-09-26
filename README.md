## spring-data-jpa-h2
Here is a in-memory database H2 database example using Hibernate(spring data jpa) and Spring Boot.

## Using Embedded Database
It’s often convenient to develop applications using an in-memory embedded database. Obviously, in-memory databases do not provide persistent storage; you will need to populate your database when your application starts and be prepared to throw away data when your application ends.

Spring Boot can auto-configure embedded H2, HSQL and Derby databases. You don’t need to provide any connection URLs, simply include a build dependency to the embedded database that you want to use. That means you dont need to provide any H2 specific configurations in your spring boot application. Include the required dependencies and spring boot will take care of other things.

## Initialize a database using Hibernate

A file named import.sql in the root of the classpath will be executed on startup if Hibernate creates the schema from scratch (that is if the ddl-auto property is set to create or create-drop). This can be useful for demos and for testing if you are careful, but probably not something you want to be on the classpath in production. **It is a Hibernate feature (nothing to do with Spring)**.

## References

- [spring-boot-features-sql](https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-sql.html#boot-features-embedded-database-support)
- [Database initialization](https://docs.spring.io/spring-boot/docs/current/reference/html/howto-database-initialization.html)
