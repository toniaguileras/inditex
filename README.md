# Inditex Prices Project

Welcome, and thank you for reviewing this project/Kata developed for **Paradigma Digital**.  
This document contains essential information regarding the structure and operation of the application.

The project follows a **hexagonal architecture**, divided into the following layers: **infrastructure**, **application**, and **domain**.

---

## 🏗️ Infrastructure

- The infrastructure layer is organized into two main packages:
  - One dedicated to the application **controllers**.
  - Another called **repository**, responsible for database access and data persistence.
- While the current size of the project does not necessitate deeper modularization, future scaling would benefit from organizing domain objects (e.g., `prices`, `products`, `users`) into dedicated sub-packages.

---

## 🚆 Application

- This layer adheres strictly to hexagonal architecture principles and does **not depend on infrastructure** components.
- If the application grows, domain-specific services and logic should be modularized into individual packages to improve maintainability.

---

## 🧬 Domain

- Java 21’s `record` feature is utilized to model **immutable data carriers**, in accordance with **Domain-Driven Design (DDD)** principles.
- The **product repository** is abstracted via an `interface`, enabling multiple database implementations within the infrastructure layer.

---

## ✨ Beyond the Code

- **Docker** is used to fully containerize the application.
- **MapStruct** is integrated to automate object mapping between domain models and DTOs, including support for mapping to primitive types using annotations and custom methods.
- The codebase adheres to **SOLID principles** and **clean code** standards.
- **Testing** has been implemented using **JUnit** and **Mockito**:
  - The five key test cases needed are provided.
  - Test responses are stored in the `resources` directory to improve readability.
  - Both **unit** and **acceptance tests** are included, organized into `application` and `infrastructure` subfolders within the `test` directory.
  - For future improvements, I consider creating a separate folder such as `integrationTest`.
- **Swagger** is configured to provide interactive API documentation.

---

## 🚀 API Usage

- **Swagger UI:** [http://localhost:8080/swagger-ui/index.html#/](http://localhost:8080/swagger-ui/index.html#/)
- To start the application:
  1. Execute `./gradlew build` (recommended).
  2.  Run the `InditexApplication` class.
  3. Use the following Docker command:
     ```bash
     docker-compose up --build
     ```
- The application runs with **Java 21** via `eclipse-temurin:21-jdk-alpine`.

### ✅ Example API Responses

- **200 OK**  
  [http://localhost:8080/v1/prices?applicationDate=2020-06-14T15%3A00%3A00&productId=35455&brandId=1](http://localhost:8080/v1/prices?applicationDate=2020-06-14T15%3A00%3A00&productId=35455&brandId=1)

- **404 NOT_FOUND**  
  [http://localhost:8080/v1/prices?applicationDate=2026-06-14T15%3A00%3A00&productId=35455&brandId=1](http://localhost:8080/v1/prices?applicationDate=2026-06-14T15%3A00%3A00&productId=35455&brandId=1)

- **400 BAD_REQUEST**  
  [http://localhost:8080/v1/prices?applicationDate=2020-06-14T15%3A00%3A00&productId=aab&brandId=1](http://localhost:8080/v1/prices?applicationDate=2020-06-14T15%3A00%3A00&productId=aab&brandId=1)

---

© 2025 - Developed for Paradigma Digital
