## PRMS – Project Resource Management System

PRMS (Project Resource Management System) is a backend REST API built using Spring Boot to manage organizational resources efficiently. The application provides CRUD operations, database integration, and API documentation using Swagger.

## Overview

PRMS is designed as a backend service that allows users to create, retrieve, update, and delete resources through RESTful APIs. The system follows a layered architecture with clear separation between controller, service, and repository layers.

This project demonstrates backend development skills including REST API design, database integration, Swagger documentation, and structured application architecture.

## Features

- RESTful API architecture
- CRUD operations for resource management
- Layered architecture:
  - Controller layer
  - Service layer
  - Repository layer
- Spring Data JPA integration
- MySQL database connectivity
- Swagger API documentation
- Maven-based project structure

## Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Swagger (Springdoc OpenAPI)
- Maven

## Project Structure

src/main/java
├── controller
├── service
├── repository
├── model

Standard Maven directory structure:

- src/main/java      → Application source code
- src/test/java      → Test classes
- pom.xml            → Maven configuration

## API Endpoints

GET     /resources
GET     /resources/{id}
POST    /resources
PUT     /resources/{id}
DELETE  /resources/{id}

## Swagger Documentation

http://localhost:8080/swagger-ui/index.html

Swagger provides interactive API documentation to test endpoints directly from the browser.

## Database Configuration

This project uses MySQL.

Before running the application:

1. Create a MySQL database.
2. Update the 'application.properties' file with your database credentials.

## How to Run the Application

1. Clone the repository:

git clone https://github.com/aiswaryaasriganth/prms-springboot.git

2. Navigate to the project directory:

cd prms-springboot

3. Configure MySQL in 'application.properties'.

4. Run the application:

mvn spring-boot:run

The application will start at:
http://localhost:8080

You can test the APIs using:

* Swagger UI
* Postman
* Browser (for GET requests)

## Future Improvements

* Add JWT-based authentication
* Implement global exception handling
* Add validation annotations
* Add unit and integration tests
* Dockerize and deploy to cloud
* Add role-based access control

## Purpose

This project was developed to demonstrate backend API development using Spring Boot, RESTful services, MySQL integration, and Swagger API documentation following clean layered architecture principles.
