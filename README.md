# Payment Service API

## Overview
The Payment Service API is a Java Spring Boot microservice designed for processing payments and managing billing. It provides endpoints to create, update, delete, and retrieve payment information.

## API Specification
- **Version**: 1.0.0
- **Base Path**: `/payments`

### Endpoints
- `GET /payments`: List all payments.
- `POST /payments`: Create a new payment.
- `GET /payments/{id}`: Get a payment by ID.
- `PUT /payments/{id}`: Update a payment.
- `DELETE /payments/{id}`: Delete a payment.

## Components
- **Payment**: Represents a payment with properties such as `id`, `order_id`, `amount`, `payment_date`, and `payment_method`.

## Prerequisites
- **MySQL Database**: Ensure you have Docker installed to run a MySQL container.
  - Run the following command to create the database:
    ```sql
    CREATE DATABASE IF NOT EXISTS payment_db;
    ```
  - To avoid errors with reserved keywords, execute:
    ```sql
    SET sql_mode = 'ANSI_QUOTES';
    ```

## Build Instructions
This is a Spring Boot application. Follow these steps to build the project:

1. **Clone the repository**:
   ```bash
   git clone <repository-url>
   cd payment-service
   ```

2. **Build the project**:
   ```bash
   mvn clean install
   ```

## Running the Application Locally
To run the application locally, use Docker Compose. This setup includes three components:

1. **MySQL Container**: A MySQL database instance.
2. **Build the JAR**: Execute `mvn clean install` to create the JAR file.
3. **Service Image**: The service image is created locally using the Dockerfile.

### Steps
1. **Run Docker Compose**:
   ```bash
   docker-compose up
   ```
   This command will start the MySQL container, build the JAR file, and run the service image.

> **Note**: Docker Compose handles the MySQL instance, so no pre-existing MySQL setup is required.

## Dependencies
- **Spring Boot**: For building the RESTful API.
- **Flyway**: For database migrations.
- **Docker**: For containerization.
- **Docker Compose**: For orchestrating multi-container Docker applications.

## Usage
Once the application is running, you can access the API at `http://localhost:<port>/payments`. Use tools like Postman or curl to interact with the endpoints.

## License
This project is licensed under the MIT License. See the LICENSE file for details.