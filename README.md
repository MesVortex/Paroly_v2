# Paroly_v2

## Project Context

This project aims to develop a **REST API** for managing a music catalog, including **albums** and **songs**. The API
ensures secure access at different levels (USER/ADMIN) with **stateless authentication**. The technical architecture is
built using **Spring Boot** and integrates modern **DevOps practices**.

---

## Main Entities

- **Album**
    - `title` (String)
    - `artist` (String)
    - `year` (Integer)

- **Song**
    - `title` (String)
    - `duration` (Integer)
    - `trackNumber` (Integer)

- **User**
    - `login` (String)
    - `password` (String)
    - `active` (Boolean)
    - `roles` (Collection<String>)

---

## Features

### Album Management

#### User/ADMIN

- List albums with pagination.
- Search albums by title (with pagination and sorting).
- Search albums by artist.
- Filter albums by year (with pagination and sorting).

#### ADMIN Only

- Add a new album.
- Update an existing album.
- Delete an album.

**API Endpoints**

- `/api/user/albums/**`
- `/api/admin/albums/**`

### Song Management

#### User/ADMIN

- List songs with pagination.
- Search songs by title (with pagination and sorting).
- List songs in an album (with pagination and sorting).

#### ADMIN Only

- Add a new song.
- Update an existing song.
- Delete a song.

**API Endpoints**

- `/api/user/songs/**`
- `/api/admin/songs/**`

### User Management

- `POST /api/auth/login` - User authentication.
- `POST /api/auth/register` - Account creation.
- `GET /api/admin/users` - List all users (ADMIN only).
- `PUT /api/admin/users/{id}/roles` - Manage roles (ADMIN only).

---

## Security

- **Spring Security** with stateless authentication using **JWT**.
- **BCryptPasswordEncoder** (or other robust encoders) for password encryption.
- **Role-based URL access**:
    - `/api/admin/*` requires the ADMIN role.
    - `/api/user/*` requires the USER role.

### JWT Details

- Issued using `.withIssuer()`.
- Contains the client's identity via `.withSubject()`.
- Stores roles/permissions via `.withArrayClaim()` / `.withClaim()`.
- Limited validity via `.withExpiresAt()`.
- Signed securely using HMAC or RSA.

---

## Application Layers

- **Controller**
- **Service**
- **Repository**
- **DTO**
- **Mapper**
- **Exception Handling**
- **Validation**
- **Tests**

---

## Technologies and Concepts

- **Spring Boot**
- **REST API**
- **Spring Data**
- **MongoDB** (NoSQL database).
- **Exception Handling**
- **Validation**
- **DevOps Tools**:
    - **Jenkins** for CI/CD.
    - **Docker** for containerization (Dockerfile, startup scripts).
    - **DockerHub** to store generated Docker images.

---

## Technical Requirements

- **Profiles**: dev, prod.
- **Configuration**
- **Testing**
- **Design Patterns**: Repository, DTO, Mapper.
- **Validation**
- **Transactions Management**.
- **Java Features**:
    - Stream API, Lambda expressions, Java Time API, Optional, Collection API.

---

## Tools and Workflow

- **Version Control**: Git (with branches).
- **IDE**: IntelliJ IDEA
- **Project Management**: JIRA + Scrum.
- **Development Tools**: Lombok, Spring Boot DevTools, SonarLint.
- **Testing**: Postman, Swagger for API documentation.

---

## Getting Started

1. Clone the repository:

  ```bash
    git clone <repository-url>
  ```

2. Build the application: 

  ```bash
     ./mvnw clean install
  ```

3. Run the application: 

  ```bash
    ./mvnw spring-boot:run
  ```


4. Access Swagger for API documentation:  
   http://localhost:8080/swagger-ui/

---

## Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository.
2. Create a feature branch.
3. Commit changes.
4. Submit a pull request.

---

## Author

- **Meskine Mostafa**
    - Email: meskinemostafa4@gmail.com
    - GitHub: [Meskine Mostafa](https://github.com/MesVortex)  

