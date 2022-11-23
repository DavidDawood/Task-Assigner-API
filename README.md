# Task-Assigner-API

# Images

!(General Structure)[./Images/1]

# Description

-   The project is simply a basic employee allocation backend, which allows for users to allocate employees to tasks which have start dates, end dates, names and descriptions

# How to setup

Simply go into the resource folder in the src, and by using either the template below or using the application.properties.example file, place the following into the resource folder.

```
spring.datasource.url=jdbc:mysql://localhost:3306/TaskAssigner?createDatabaseIfNotExist=true
spring.datasource.username= PLACE USERNAME HERE
spring.datasource.password= PLACE PASSWORD HERE

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5Dialect
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
```

## Personal thoughts

-   This project was simply a reminder on some fundamentals for spring as my previous project was purely with javascript and typescript with NestJS.
-   The project was not too difficult and allowed me to further my understanding with MYSQL too.
-   I didnt end up struggling too much but had a few run ins with infinite loops on the relationship part of the database which were quickly fixed
