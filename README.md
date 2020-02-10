# Spring Boot Application
 ![](https://i.imgur.com/qgRaRlub.jpg)
 
## Built With
* [Maven](https://maven.apache.org/) - Dependency Management
* [JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - Java™ Platform, Standard       Edition Development Kit 
* [Spring Boot](https://spring.io/projects/spring-boot) - Framework to ease the bootstrapping and development of new Spring   A pplications
* [MySQL](https://dev.mysql.com/) - Open-Source Relational Database Management System
* [Git](https://git-scm.com/) - Free and Open-Source distributed version control system  
* [H2](https://www.h2database.com/html/main.html) - H2 in-memory database as a data source for tests

## Packages
- [x] Spring Boot
- [x] Spring Devtools
- [x] Spring Data
- [x] Spring Data Jpa
- [x] MySQL(Database)
- [x] Spring Web
- [x] H2

```
.
├── Spring Elements
├── src
│   └── main
│       └── java
│           ├── br.com.fiord        
│           ├── br.com.fiord.controller             
│           ├── br.com.fiord.entity
│           ├── br.com.fiord.exception
│           ├── br.com.fiord.repository
│           └── br.com.fiord.service
├── src
│   └── main
│       └── resources
│           └── static              
│           ├── templates            
│           ├── application.properties
│            
├── src
│   └── test
│       └── java
|        └── br.com.fiord.test
|        
├── JRE System Library
├── Maven Dependencies
├── bin
├── logs
│   └── application.log
├── src
├── target
│   └──application-0.0.1-SNAPSHOT
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

## Packages
- `entity` — to hold our entities;
- `repositorie` — to communicate with the database;
- `service` —  to hold our business logic;
- `controller` — to listen to the restaurant;
- `exception` — to listen to the restaurant;
- `resources/` - Contains all the static resources, templates and property files.
- `resources/static` - contains static resources such as css, js and images.
- `resources/templates` - contains server-side templates which are rendered by Spring.
- `resources/application.properties` - It contains application-wide properties. 
  Spring reads the properties defined in this file to configure your application. 
  You can define server’s default port, server’s context path, database URLs etc, in this file.
- `test/` - contains unit and integration tests
- `pom.xml` - contains all the project dependencies
 
## Running the application locally
mvn spring-boot:run

