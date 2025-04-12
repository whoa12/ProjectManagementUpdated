Project Management App
Overview
The Project Management App is a robust and scalable web application designed to help teams efficiently manage and track their projects using a microservices architecture. Built with Spring Boot, this app implements key features like user management, project tracking, task assignment, and more, providing an intuitive and comprehensive platform for both small and large teams.
Features
User Management: Create, update, and delete user accounts. Users can be assigned different roles such as Admin or User.

Project Management: Create, update, and manage projects. Track project progress and milestones.

Task Assignment: Assign tasks to team members, set deadlines, and track completion.

Notifications: Receive alerts for updates on tasks, projects, and deadlines.

Authentication & Authorization: Secure login and role-based access control using Spring Security and JWT (JSON Web Tokens).

API Gateway: A centralized entry point for routing requests to appropriate microservices.

Service Discovery: Automatic detection and registration of microservices using Eureka.

Architecture
This app follows a microservices architecture consisting of several key services:

User Service: Handles user registration, login, and profile management.

Submission Service: Manages the creation, modification, and status tracking of projects.

Task Service: Responsible for task creation, assignment, and completion tracking.

API Gateway: Acts as the entry point for all client requests, routing them to the appropriate microservice.

Eureka Service: Provides service discovery and ensures the app’s scalability by managing all microservices.

Tech Stack
Spring Boot: Framework for building the microservices and the backend.

Spring Security: Handles authentication and authorization.

JWT (JSON Web Tokens): Secure authentication mechanism.

Eureka: Service discovery for microservices.

Databses: MySQL, PostgreSQL and MongoDB.

Maven: Dependency management and build tool.

RESTful APIs: Communication between microservices and external systems.

Docker: For externalizing microservices.
