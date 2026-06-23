# Customer Information Management API

A RESTful API built with Spring Boot, Spring Data JPA, MySQL, and Docker for managing customer information. This project provides CRUD operations to create, retrieve, update, and delete customer records.

## Features

* Add a new customer
* Get all customers
* Get customer by ID
* Update customer details
* Delete customer by ID
* MySQL database integration
* Dockerized application for easy deployment

## Tech Stack

* Java 21
* Spring Boot
* Spring Data JPA
* MySQL
* Lombok
* Maven
* Docker

## Project Structure

```text
src/main/java
├── controller
│   └── CustomerInfoController.java
├── service
│   └── CustomerInfoService.java
├── repository
│   └── CustomerInfoRepository.java
├── entity
│   └── CustomerInfo.java
```

## API Endpoints

### Add Customer

**POST**

```http
/customersinfo/addCustomer
```

Request Body

```json
{
  "name": "John Doe",
  "email": "john.doe@gmail.com",
  "phone": "9876543210",
  "address": "Hyderabad"
}
```

Response

```json
{
  "id": 1,
  "name": "John Doe",
  "email": "john.doe@gmail.com",
  "phone": "9876543210",
  "address": "Hyderabad",
  "createdDate": "2026-06-23T10:30:15"
}
```

---

### Get All Customers

**GET**

```http
/customersinfo/getAllCustomers
```

---

### Get Customer By ID

**GET**

```http
/customersinfo/getCustomer/{id}
```

Example

```http
/customersinfo/getCustomer/1
```

---

### Update Customer

**PUT**

```http
/customersinfo/updateCustomer
```

Request Body

```json
{
  "id": 1,
  "name": "John Updated",
  "email": "john.updated@gmail.com",
  "phone": "9999999999",
  "address": "Bangalore"
}
```

---

### Delete Customer

**DELETE**

```http
/customersinfo/deleteCustomerById/{id}
```

Example

```http
/customersinfo/deleteCustomerById/1
```

## Dummy Data for Testing

### Customer 1

```json
{
  "name": "John Doe",
  "email": "john.doe@gmail.com",
  "phone": "9876543210",
  "address": "Hyderabad"
}
```

### Customer 2

```json
{
  "name": "Alice Smith",
  "email": "alice.smith@gmail.com",
  "phone": "9123456789",
  "address": "Bangalore"
}
```

### Customer 3

```json
{
  "name": "Robert Johnson",
  "email": "robert.johnson@gmail.com",
  "phone": "9988776655",
  "address": "Chennai"
}
```

## Database Configuration

Configure your MySQL database in `application.properties`.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/customerdb
spring.datasource.username=root
spring.datasource.password=password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## Running the Application Locally

Clone the repository:

```bash
git clone https://github.com/<your-username>/<repository-name>.git
```

Navigate to the project directory:

```bash
cd <repository-name>
```

Build the project:

```bash
mvn clean install
```

Run the application:

```bash
mvn spring-boot:run
```

Application will start on:

```text
http://localhost:8080
```

## Docker Support

The application is available as a Docker image on Docker Hub.

### Pull Docker Image

```bash
docker pull siva2525/customerinfo:v1
```

### Run Docker Container

```bash
docker run -d -p 8080:8080 --name customerinfo-app siva2525/customerinfo:v1
```

### Verify Running Containers

```bash
docker ps
```

### Access Application

```text
http://localhost:8080
```

### Test API

```bash
curl http://localhost:8080/customersinfo/getAllCustomers
```

## Docker Hub

Docker Image:

```text
siva2525/customerinfo:v1
```

Repository:

```text
https://hub.docker.com/r/siva2525/customerinfo
```

