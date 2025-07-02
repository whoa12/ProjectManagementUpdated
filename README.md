#  Project Management App

A **robust, scalable** microservices-based web application designed to help teams manage users, projects, and tasks with ease.

Built with **Spring Boot**, **JWT Security**, **Eureka**, and **Docker**, this app brings together a modern architecture suited for both small teams and enterprise workflows.

---

##  Features

-  **User Management**  
  Create, update, delete users and assign roles (`Admin`, `User`) using JWT(Json Web Tokens)

-  **Project Management**  
  Create, manage projects; track progress and milestones

-  **Task Assignment**  
  Assign tasks, set deadlines, track completion

-  **Authentication & Authorization**  
  Spring Security + JWT for secure role-based access

-  **API Gateway**  
  Central routing entry point to all microservices

-  **Service Discovery**  
  Eureka-based microservice registration and discovery

---

## ⚙️ Tech Stack

| Technology        | Purpose                                  |
|-------------------|------------------------------------------|
| **Spring Boot**    | Backend framework for all microservices |
| **Spring Security**| Role-based authentication               |
| **JWT**            | Token-based security                    |
| **Eureka**         | Service registration/discovery          |
| **MySQL** / **PostgreSQL** / **MongoDB** | Databases        |
| **Docker**         | Containerization and service isolation  |
| **Maven**          | Build & dependency management           |
| **REST APIs**      | Inter-service communication             |

---

##  Dockerized Deployment

Each service can be run independently or all together using Docker Compose. You can scale horizontally with minimal configuration.


---

##  Services Overview

| Microservice      | Description                                |
|-------------------|--------------------------------------------|
| `Tas-User-Service` | Handles login, registration, user roles    |
| `TaskService`     | Assigns and manages tasks per user/project |
| `SubmissionService` | Manages projects and their status        |
| `Gateway`           | Routes requests to correct microservice    |
| `tsServiceRegistry` | Service discovery and health tracking      |
| `Config Server`    | Centralized configuration for all services |


---


---

##  Resilience, Fault Tolerance & Monitoring

This project includes essential patterns and tools to ensure fault-tolerant microservices communication:

###  Circuit Breaker (Resilience4j)
- Prevents cascading failures by **breaking circuits** when a downstream service is slow or unavailable.
- Automatically **recovers** when the downstream system becomes healthy again.

###  Fallbacks
- Graceful degradation of services by returning **default responses** or cached data if a microservice call fails.
- Ensures users don't see application crashes even if one microservice is down.

###  Retry & Timeout
- Automatically **retries failed requests** (like to an unstable service).
- Configurable **timeouts** prevent indefinite hangs.

###  Health Checks & Monitoring
- Exposed via **Spring Boot Actuator**
- Integrated into **Eureka** for smart service registration/deregistration
- Readiness and Liveness probes help ensure containers are healthy (supports Kubernetes)

###  Centralized Logs (Optional/Planned)
- Logs from each microservice can be forwarded to:
  - **ELK Stack (Elasticsearch, Logstash, Kibana)**
  - or **Prometheus + Grafana** for real-time metrics and dashboards

> Planned integrations for full observability

---

##  Future Enhancements (Planned or In Progress)

- [ ] Integrate **Hystrix Dashboard** or **Spring Cloud Dashboard**
- [ ] Add **distributed tracing** with **Zipkin** or **Jaeger**
- [ ] Real-time monitoring with **Prometheus + Grafana**
- [ ] Add Kafka for event-driven architecture
- [ ] API Rate Limiting & Throttling

---



