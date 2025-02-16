# Spring Boot Microservices Project - Department and Employee Management
**Course**: ITS 4243 Microservices and Cloud Computing  
**Assignment 1**: February 17th, 2025

## Project Overview
This project implements a microservices architecture using Spring Boot to manage departments and employees. It consists of two separate services that demonstrate the basic principles of microservices design and REST API implementation.

## Services Implemented

### 1. Department Service (Port: 8080)
Manages department information with the following features:
- Create new departments
- Retrieve department details
- MySQL database integration
- RESTful API endpoints

### 2. Employee Service (Port: 8081)
Manages employee information with the following features:
- Create new employees
- Retrieve employee details
- MySQL database integration
- RESTful API endpoints

## Technical Stack
- **Framework**: Spring Boot 3.2.x
- **Build Tool**: Maven
- **Database**: MySQL
- **Language**: Java
- **IDE**: IntelliJ IDEA
- **API Testing**: Postman

## Project Structure
```
spring-microservices/
├── department-service/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/example/departmentservice/
│   │   │   │       ├── controller/
│   │   │   │       ├── entity/
│   │   │   │       └── repository/
│   │   │   └── resources/
│   │   │       └── application.properties
│   └── pom.xml
└── employee-service/
    ├── src/
    │   ├── main/
    │   │   ├── java/
    │   │   │   └── com/example/employeeservice/
    │   │   │       ├── controller/
    │   │   │       ├── entity/
    │   │   │       └── repository/
    │   │   └── resources/
    │   │       └── application.properties
    └── pom.xml
```

## Database Schema

### Department Database (department_db)
```sql
CREATE TABLE department (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    department_name VARCHAR(255),
    department_description VARCHAR(255),
    department_code VARCHAR(255)
);
```

### Employee Database (employee_db)
```sql
CREATE TABLE employee (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    email VARCHAR(255),
    department_id BIGINT
);
```

## API Endpoints

### Department Service
- POST `/api/departments` - Create a new department
- GET `/api/departments/{id}` - Retrieve a department by ID

### Employee Service
- POST `/api/employees` - Create a new employee
- GET `/api/employees/{id}` - Retrieve an employee by ID

## Setup Instructions

1. Database Setup:
```sql
CREATE DATABASE department_db;
CREATE DATABASE employee_db;
```

2. Configure application.properties:
- Update MySQL username and password in both services

3. Run the Applications:
- Start Department Service
- Start Employee Service

4. Test API Endpoints using Postman:
```json
// Department Creation
POST http://localhost:8080/api/departments
{
    "departmentName": "IT",
    "departmentDescription": "Information Technology",
    "departmentCode": "IT001"
}

// Employee Creation
POST http://localhost:8081/api/employees
{
    "firstName": "John",
    "lastName": "Doe",
    "email": "john.doe@example.com",
    "departmentId": 1
}
```

## Learning Outcomes
- Implementation of microservices architecture
- REST API development using Spring Boot
- Database integration with multiple services
- Basic service separation and management
- API testing and documentation

## References
- Spring Boot Documentation
- Spring Data JPA Documentation
- MySQL Documentation
- REST API Best Practices

---
*This project was developed as part of the ITS 4243 Microservices and Cloud Computing assignment.*
