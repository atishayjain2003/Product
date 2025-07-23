# Product

Hi Everyone,  
**Product** is a Java Spring Boot-based learning project created to understand the working and functioning of Spring Boot and REST services.

---

## Project Overview

In this project, endpoints have been defined for all REST operations related to `Product`:

1. Add Product  
2. Delete Product  
3. Get All Products  
4. Update Product  

> **Note:** No database has been used in this project so far.

---

## Architecture

We have used the typical **Model - Service - Controller** architecture.

- **Model**: Defines the `Product` class with getter and setter methods.
- **Service**: Contains the business logic to manipulate the product list.
- **Controller**: Handles incoming requests and maps them to appropriate service methods.

---

## Flow Understanding

As per my understanding:

1. A request through an endpoint is first intercepted by the **Dispatcher Servlet**, which acts as the **Front Controller**.
2. The request is then mapped to the corresponding method in the **Controller**.
3. The controller delegates business logic to the **Service** layer and returns the appropriate response.

---

## Logic and Implementation

### 1. Add Product
- **Request Type**: POST  
- **Endpoint**: `/addproduct`  
- **Input**: Product object in the request body  
- **Output**: Added Product object  
- **Logic**: The received product is added to an in-memory `ArrayList`.

### 2. Delete Product
- **Request Type**: DELETE  
- **Endpoint**: `/product/{productId}`  
- **Input**: Product ID as a path variable  
- **Output**: Success message or error if not found  
- **Logic**: The product ID is searched in the list; if found, the object is removed.

### 3. Get All Products
- **Request Type**: GET  
- **Endpoint**: `/allproducts`  
- **Output**: List of all stored products  
- **Logic**: Returns the current state of the `ArrayList` storing all products.

### 4. Update Product
- **Request Type**: PUT  
- **Endpoint**: `/product/updateProduct`  
- **Input**: Updated product object in the request body  
- **Output**: Modified product object or error if not found  
- **Logic**: Finds the existing product by ID and updates fields accordingly.

> Implementation support: **GitHub Copilot** was used to assist in writing the code.

---

## REST API URLs

| Operation       | Method | URL                                  |
|----------------|--------|--------------------------------------|
| Get All Products | GET    | `http://localhost:8080/allproducts` |
| Add Product      | POST   | `http://localhost:8080/addproduct`  |
| Delete Product   | DELETE | `http://localhost:8080/product/{productId}` |
| Update Product   | PUT    | `http://localhost:8080/product/updateProduct` |

---

## Technologies Used

- Java
- Spring Boot
- RESTful Web Services
- Maven 
- GitHub Copilot (for code assistance)

---




