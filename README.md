# Employee Management

**Employee Management** is a Spring Boot REST API application that helps manage employee details efficiently. It supports creating, reading, updating, and deleting employee data, and includes **Swagger UI** for easy API documentation and testing.

## Access Control

* **`/api/employees/`** – Accessible **only by Admin**.
* **`/api/users/`** – Accessible by **both Admin and User** roles.

<img width="1460" height="825" alt="image" src="https://github.com/user-attachments/assets/bf1f734a-25c1-43a6-b0e7-9044056c7987" />


## Authentication & Authorization Steps

1. **Register a new user** – Send a `POST` request:

   ```bash
   curl -X POST http://localhost:8080/auth/register \
   -H "Content-Type: application/json" \
   -d '{
         "username": "john",
         "password": "password123",
         "role": "ADMIN"
       }'
   ```

2. **Generate a token** – Send a `POST` request:

   ```bash
   curl -X POST http://localhost:8080/auth/authenticate \
   -H "Content-Type: application/json" \
   -d '{
         "username": "john",
         "password": "password123"
       }'
   ```

   The response will include a **JWT token**.

3. **Use the token to access APIs** – Example for getting all employees:

   ```bash
   curl -X GET http://localhost:8080/api/employees \
   -H "Authorization: Bearer <your_token_here>"
   ```

---

