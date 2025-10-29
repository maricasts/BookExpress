# Biblioteca - Spring Boot Example

Minimal Spring Boot application implementing the library system described.

Important notes:
- Uses Spring Data JPA and MySQL (configure credentials in `application.properties`).
- Passwords are hashed with BCrypt.
- This is a simple example focusing on correctness and clear structure, not production-ready security.
- To run: `mvn spring-boot:run` (requires Maven and MySQL running and database/schema created).
- The SQL schema file is at `src/main/resources/schema.sql`.
