# User Authentication and Management System

## Overview

This project consists of three main services:

1. **Authentication Service**: Handles user authentication and JWT token generation.
2. **User Service**: Manages user data, allowing for CRUD operations.
3. **API Gateway**: Routes requests to the appropriate service and handles JWT authentication.

## Services

### 1. Authentication Service

**Purpose**: To authenticate users and generate JWT tokens for secure access.

**Endpoints**:
- **POST http://localhost:8888/authservice/v1/login**
    - **Request Body**:
      ```json
      {
        "email": "string",
        "password": "string"
      }
      ```
    - **Response**:
      ```json
      {
        "jwt": "string"
      }
      ```
    - **Description**: Authenticates the user and returns a JWT token.

* Note: Initially there is a user with this credentials
* {
  "email": "admin@gmial.com",
  "password": "adminPass"
  }


### 2. User Service

* NOTE: All these endpoints are protected, make sure to pass bearer token.

**Purpose**: To manage user data with the ability to create, read, update, and delete users.

**Endpoints**:
- **GET http://localhost:8888/userservice/v1/user**
    - **Response**:
      ```json
      [
        {
          "id": "long",
          "username": "string",
          "email": "string"
        }
      ]
      ```
    - **Description**: Retrieves a list of all users.

- **GET http://localhost:8888/userservice/v1/user/{id}**
    - **Response**:
      ```json
      {
        "id": "long",
        "firstName": "string",
        "lastName": "string",
        "email": "string",
        "role": "string"
      }
      ```
    - **Description**: Retrieves a user by their ID.

- **POST http://localhost:8888/userservice/v1/user**
    - **Request Body**:
      ```json
      {
        "firstName": "string",
        "lastName": "string",
        "email": "string",
        "password": "string",
        "role": "string"
      }
      ```
    - **Response**:
      ```json
      {
        "id": "long",
        "firstName": "string",
        "lastName": "string",
        "email": "string",
        "role": "string"
      }
      ```
    - **Description**: Creates a new user.

- **PUT http://localhost:8888/userservice/v1/user/{id}**
    - **Request Body**:
      ```json
      {
        "firstName": "string",
        "lastName": "string",
        "email": "string",
        "password": "string",
        "role": "string"
      }
      ```
    - **Response**:
      ```json
      {
        "id": "long",
        "firstName": "string",
        "lastName": "string",
        "email": "string",
        "role": "string"
      }
      ```
    - **Description**: Updates an existing user by ID.

- **DELETE http://localhost:8888/userservice/v1/user/{id}**
    - **Description**: Deletes a user by their ID.

### 3. API Gateway

**Purpose**: Acts as a single entry point for the client to access the services, handling routing and authentication.

- Routes requests to the respective service based on the URL path.
- Performs JWT validation for secure access to the User Service.

## Running the Application

To run the application using Docker Compose, follow these steps:

1. **Clone the repository**:
2. **Enter the directory**:
2. **Run with docker compose**
   ```bash
    docker-compose -f ./docker-compose.yml up
