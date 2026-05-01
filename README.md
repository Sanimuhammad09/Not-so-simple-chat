# Coffee Shop Application

A robust, feature-rich Coffee Shop backend application built with **Spring Boot 3** and **Java 17**. This project was designed as a comprehensive demonstration of advanced software engineering concepts, focusing heavily on integrating **Design Patterns**, handling **Multithreading** asynchronously, interacting with an **In-Memory Database**, and ensuring reliability through automated **Unit Testing**.

## 📖 Table of Contents
- [Project Overview](#project-overview)
- [Key Features](#key-features)
- [Design Patterns Implemented](#design-patterns-implemented)
- [Multithreading & Asynchronous Processing](#multithreading--asynchronous-processing)
- [Chat & Persistence Functionality](#chat--persistence-functionality)
- [Application Structure](#application-structure)
- [API Endpoints](#api-endpoints)
- [Getting Started](#getting-started)
- [Testing](#testing)

---

## ☕ Project Overview

The Coffee Shop application acts as the backend for a modern cafe. It allows customers to place coffee orders, tracks those orders in a thread-safe queue, and processes them asynchronously via a digital "Barista." Customers are notified when their drinks are ready. It also features a real-time chat service where customers can message the shop, with all conversation history persisted using Spring Data JPA.

## ✨ Key Features
1. **Design Pattern Rich:** Implements 10 classic Gang of Four (GoF) design patterns using Spring's powerful dependency injection.
2. **Concurrent Order Processing:** Non-blocking async preparation of orders utilizing thread-safe Java concurrency utilities and Spring's `@Async`.
3. **Database Integration:** Features an embedded H2 database with Spring Data JPA to store chat messages persistently during the application lifecycle.
4. **RESTful Architecture:** Exposes clean HTTP endpoints for ordering coffee and sending messages.
5. **Fully Tested:** Validates core logic using JUnit 5 and Mockito.

---

## 🏗️ Design Patterns Implemented

The application is heavily modularized using the following design patterns:

1. **Singleton Pattern (`CoffeeShop`)**
   - Implemented as a Spring `@Component`, this acts as the central global manager for incoming orders and shop operations, ensuring only one instance orchestrates the queue.
2. **Factory Method Pattern (`CoffeeFactory`)**
   - Dynamically produces various types of base coffees (e.g., Espresso, Cappuccino) without coupling the core logic to concrete implementations.
3. **Observer Pattern (`OrderReadyEvent`, `CustomerNotifier`)**
   - Uses Spring's `ApplicationEventPublisher`. When an order finishes, an event is published. Listeners automatically react and notify the customer.
4. **Strategy Pattern (`PricingStrategy`)**
   - Allows dynamic swapping of pricing algorithms (e.g., `RegularPricingStrategy` vs `LoyaltyPricingStrategy`) to calculate final costs at runtime.
5. **Decorator Pattern (`CoffeeDecorator`, `MilkDecorator`)**
   - Provides a flexible alternative to subclassing. Customers can dynamically add ingredients (milk, sugar) to their base coffee, extending its cost and description.
6. **Command Pattern (`PlaceOrderCommand`, `CommandInvoker`)**
   - Encapsulates an order request as an object, allowing requests to be queued, logged, or delayed by an invoker before passing to the Barista.
7. **Adapter Pattern (`PaymentAdapter`)**
   - Bridges an external legacy payment library (`StripePaymentService`) to our internal `PaymentService` interface, standardizing how payments are handled.
8. **Facade Pattern (`CoffeeShopFacade`)**
   - Provides a single, highly simplified interface for the `CoffeeShopController` to interact with, hiding the complex interactions between the factory, models, and singleton managers.
9. **Prototype Pattern (`CoffeeOrderPrototype`)**
   - Defined using Spring’s `@Scope("prototype")`. It allows cloning complex, customized coffee orders quickly for customers who want "another round of the exact same thing."
10. **Template Method Pattern (`CoffeePreparationTemplate`)**
    - Defines the structural skeleton of preparing a coffee (boil water, pour in cup) while allowing subclasses (`EspressoPreparation`) to provide specific implementations for certain steps (brewing grinds).

---

## ⚡ Multithreading & Asynchronous Processing

To handle a bustling cafe environment, the app must not block when receiving multiple orders at once:
- **`OrderQueue`:** Implements a `LinkedBlockingQueue` to safely handle multiple requests from concurrent REST threads without data corruption.
- **`Barista` Service:** Utilizing Spring's `@Async` annotation, the Barista simulates coffee preparation (via `Thread.sleep`) in a separate background thread pool, freeing up the main thread to immediately accept new customer orders.

---

## 💬 Chat & Persistence Functionality

The application includes a chat interface where customers can interact with the shop:
- **Entity:** `ChatMessage` maps directly to a relational table.
- **Repository:** `ChatRepository` extends `JpaRepository`, providing robust, boilerplate-free CRUD operations.
- **Database:** Uses an **H2 in-memory database**. Tables are auto-generated on startup via Hibernate (`ddl-auto=update`).

---

## 📂 Application Structure

```text
src/main/java/com/example/coffeeshop/
├── adapter/      # Payment Adapter logic
├── command/      # Command and Invoker objects
├── controller/   # REST API Controllers
├── decorator/    # Coffee additions (Milk, Sugar)
├── facade/       # Simplified entry points
├── factory/      # Coffee creation logic
├── model/        # Entities and POJOs (Order, Customer, ChatMessage)
├── observer/     # Notification events and listeners
├── prototype/    # Order cloning logic
├── repository/   # Spring Data JPA interfaces
├── service/      # Business logic (Barista, OrderQueue, ChatService)
├── singleton/    # Global state managers (CoffeeShop)
├── strategy/     # Pricing algorithms
└── template/     # Preparation algorithms
```

---

## 🚀 API Endpoints

### Order Management
- **Place an Order**
  - **URL:** `POST /api/orders`
  - **Params:** `customerName` (String), `coffeeType` (String - e.g., "Espresso" or "Cappuccino")
  - **Response:** Returns an Order ID. The Barista processes this asynchronously and fires a notification upon completion.

### Chat Interface
- **Send a Message**
  - **URL:** `POST /api/chat`
  - **Params:** `sender` (String), `message` (String)
  - **Response:** "Message sent!"
- **Retrieve Chat History**
  - **URL:** `GET /api/chat`
  - **Response:** JSON array containing the full chat history with timestamps.

---

## 🛠️ Getting Started

### Prerequisites
- **Java 17** or higher
- **Maven 3.8+**

### Installation and Running
1. Clone the repository or navigate to the project directory.
2. Compile and run using Maven:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```
3. The server will start locally at `http://localhost:8080`.

---

## 🧪 Testing

The project ensures reliability through automated testing using JUnit 5 and Mockito.
- Tests are located in `src/test/java/com/example/coffeeshop/`.
- **To run the tests:**
  ```bash
  mvn test
  ```
- **Test coverage includes:**
  - `OrderQueueTest`: Verifies thread-safe size and addition logic.
  - `ChatServiceTest`: Verifies the service interacts correctly with the mocked `ChatRepository`.
  - `CoffeeShopTest`: Ensures orders are correctly dispatched to the queue and the async Barista.
