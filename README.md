# Project 1 WebApp for a Custom ORM Framework

### By Art Weinstein and Alejandro Gomez

### A web application integrated with a custom ORM designed to let users register accounts.

## [ORM repository link](https://github.com/art-weinstein/gomez_weinstein_ORM)

## Technologies Used

* Java
* SQL
* JDBC
* PostgreSQL
* Maven
* AWS RDS
* AWS EC2
* AWS CodeBuild
* CodePipeline
* Elastic Beanstalk
* Mockito
* DevOps
* DBeaver
* Git
* XML

## Description

A custom object relational mapping (ORM) framework, written in Java, which allows for a simplified and SQL-free interaction with a relational data source. 
Low-level JDBC is completely abstracted away from the developer, allowing them to easily query and persist data to a data source. 
Makes heavy use of the Java Reflection API in order to support any entity objects as defined by the developer. 
Additionally, the framework offers connection pooling to support multi-threaded applications.




## Setup/Installation Requirements

1. [Clone](https://docs.github.com/en/github/creating-cloning-and-archiving-repositories/cloning-a-repository-from-github/cloning-a-repository) this repository.
2. Open the program in IntelliJ or similar software
3. In the Java directory, create a resources package.
4. Within the resources package, create a `connection.properties` file.
5. Enter the credentials for the database you wish to connect (this will require the endpoint, username and password)
7. Navigate to the target directory and copy the ProjectOneApp.war file: `ProjectApp/ProjectOneApp/`
8. Download Apache Tomcat, navigate to the bin directory and run the startup Batch file
9. Navigate to the Tomcat webapps directory and paste the ProjectOneApp.war file into it
10. To test your HTTP CRUD operations, use software such as Postman.


## License

* [MIT License](https://opensource.org/licenses/MIT)

Copyright (c) 2022 Art Weinstein, Alejandro Gomez

## Contact Information

* [Email](artur.weintsein@gmail.com)
