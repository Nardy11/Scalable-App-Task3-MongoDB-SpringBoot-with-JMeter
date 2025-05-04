# Scalable App Task 3: MongoDB Integration with Spring Boot and JMeter

## Overview
This repository contains the implementation of Task 3 for the *Architecture of Massively Scalable Applications* course at the German University in Cairo, Department of Computer Science, under Assoc. Prof. Mervat Abu El-Kheir, Spring 2025. The task focuses on designing and implementing a NoSQL database schema using MongoDB, integrating it with a Spring Boot application, and managing entities such as Users and Posts with embedded and referenced relationships.

## Project Description
The project includes:
- A MongoDB database schema with two main entities: **User** and **Post**.
- Relationships:
  - **Document Referencing**: Post references a User as its author.
  - **Document Embedding**: Post contains a list of embedded Comments.
- Custom repositories and service layer methods to handle CRUD operations and specific business logic.
- RESTful controllers to expose functionality via APIs.
- Dockerization with multiple services: application instances, MongoDB, Mongo Express, and Nginx.
- Load balancing using **Weighted Round Robin** with Nginx.
- Load testing using **JMeter** to evaluate system performance.

## Features

### Database Schema
- **User**: `id` (String), `username` (String), `email` (String).
- **Post**: `id` (String), `title` (String), `content` (String), `author` (User reference), `comments` (List of embedded Comments).
- **Comment** (embedded): `text` (String), `date` (String).

### Repositories
- **UserRepository**: Extends `MongoRepository` for User entity management.
- **PostRepository**: Extends `MongoRepository` for Post entity management.

### Services
- **UserService**:
  - Basic CRUD operations (pre-implemented).
  - Custom method: `updateUserUsername` – updates a user's username by ID with error handling.
- **PostService**:
  - Basic CRUD operations (pre-implemented).
  - `getPostsByAuthorID`: Retrieves posts by author ID with validation.
  - `addCommentToPost`: Adds a comment to a post by ID.

### Controllers
- **UserController**:
  - Basic CRUD handlers.
  - PUT `/updateUser` to update a user's username.
- **PostController**:
  - Basic CRUD handlers.
  - GET `/postsByUser/{id}` to get posts by author ID.
  - POST `/{postId}/comments` to add a comment.
- **MainController**:
  - Handles database seeding and instance testing.

### Dockerization
- Includes a `docker-compose.yml` with services:
  - Two Spring Boot app instances (named after your first and last name, e.g., `random`, `student`).
  - `mongo` for MongoDB.
  - `mongo-express` for MongoDB UI.
  - `nginx` as a load balancer.

### Load Balancer (Nginx)
- `nginx.conf` configured with:
  - Upstream: `YourName_52_1234`.
  - Weighted Round Robin: weights of `2` and `1` for the two app instances.

### Load Testing (JMeter)
- Test Plan: `YourName_20_52_1234.jmx`
  - 400 requests (last digit of ID × 100), 4 sec ramp-up.
  - Target: `localhost`, port `1234`.
  - Request: GET to `MainController`'s route.

### Testing
- Public API tests included and can be run with:
  ```bash
  mvn test

(Uncomment test code if needed.)

## Setup and Usage

### 1. Pre-Setup

* Ensure port `27017` is free for MongoDB.
* Follow CMS setup instructions if you're on Windows.

### 2. Configure Environment

* Edit `application.properties`:

  * `ID=52-1234`
  * `Name=YourName`
* Database name: `YourName_52_1234`.

### 3. Build and Run

```bash
mvn clean install
docker-compose up
```

* Seed the DB by hitting the seed endpoint via `MainController`.

### 5. API Endpoints

* `/users`: Basic CRUD
* `/users/updateUser`: PUT (update username)
* `/posts`: Basic CRUD
* `/posts/postsByUser/{id}`: GET posts by author
* `/posts/{postId}/comments`: POST comment to post

## Skills Demonstrated

* Proficient in **MongoDB** NoSQL schema design.
* Expertise in **Spring Boot** REST API development.
* Document embedding and referencing in MongoDB.
* **Docker Compose** for scalable, multi-service apps.
* Load balancing with **Nginx (Weighted Round Robin)**.
* Load testing with **JMeter**.
* Robust API design and **error handling** for production.

## Submission

* **Database Name**: `YourName_52_1234`
* **Port**: `1234` (based on ID `52-1234`)
