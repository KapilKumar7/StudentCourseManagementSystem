# StudentCourseManagementSystem



<!-- ============================================  TITLE ======================================================  -->

# RestFul Webservice created for Student Management System.
* This project is an assignment recieved from Platoform Commons for hiring purpose.
* It is an individual project created to manage a student database and exposing API for various CRUD operation.



## Tech Stack

* Java
* Spring Framework
* Spring Boot
* Lombok
* Spring Data JPA
* Hibernate
* MySQL

![image](https://user-images.githubusercontent.com/100344844/208870009-9e828b04-7570-42ab-a98d-9ffa5575814d.png)


<!-- ============================================  MODULES ======================================================  -->

## Modules

* Address Module
* Admin Module
* Student Module
* Course Module


<!-- ============================================  INSTALLATION AND RUN ======================================================  -->

## Installation & Run

* Before running the API server, you should update the database config inside the [application.properties] file.
* Update the port number, username and password as per your local database config.

```
    #changing the server port
    server.port=9292
    #db specific properties
    spring.datasource.url=jdbc:mysql://127.0.0.1:3306/StudentManagementDb
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=root
    spring.datasource.password=rootkpil    
    #ORM s/w specific properties
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
