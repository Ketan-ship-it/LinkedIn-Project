# 🚀 LinkedIn Project

## ✅ Work Completed So Far

### 📝 Posts Service

* Using **PostgreSQL** as the database
* Created **Post Service** for making posts
* Added **like / dislike** functionality for posts
* Implemented feature to **fetch all posts by a specific user**
* Added **ContextHolder** to retrieve `userId` from request headers (instead of passing as path variables)

---

### 👤 User Service

* Using **PostgreSQL** as the database
* Implemented a basic **authentication service**
* Added **JWT token generation** for secure communication
* Provided **signup & login functionality**

---

### 🔗 Connection Service

* Added **ContextHolder** to extract `userId` from headers for seamless communication
* Integrated with **Post Service** using **OpenFeign**
* Helps manage user-to-user connections (friends/follows)

---

### 🌐 API Gateway

* Set up **API Gateway** to register all services
* All requests are routed through the gateway to other microservices
* Added **authentication at the API Gateway**
* Configured to act as a **single entry point** for all microservices
* Registers itself with **Eureka Server** for service discovery

---

### 🔗 Inter-Service Communication

* Added **OpenFeign** for communication between microservices
* Configured **interceptors** for request/response handling
* Added **ContextHolders** (for Post & Connection Services) to fetch `userId` from headers seamlessly

---

### 🔎 Discovery Server

* Integrated **Netflix Eureka Server** for service discovery
* Ensures microservices can **locate and communicate** with each other

---

## 🏗️ Architecture Diagram

```mermaid

    APIGateway[🌐 API Gateway]
    UserService[👤 User Service]
    PostService[📝 Post Service]
    ConnectionService[🔗 Connection Service]
    Eureka[🔎 Eureka Server]

    APIGateway --- UserService
    APIGateway --- PostService
    APIGateway --- ConnectionService
    APIGateway --- Eureka

    UserService --- PostService
    PostService --- ConnectionService
    ConnectionService --- UserService

    Eureka --- UserService
    Eureka --- PostService
    Eureka --- ConnectionService
    Eureka --- APIGateway
```

---

✨ This project is being developed as a **microservices-based LinkedIn clone** with focus on **authentication, scalability, and inter-service communication**.
