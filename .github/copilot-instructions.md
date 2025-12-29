# Copilot Instructions for Demo Spring Boot Project

## Project Overview
This is a **Spring Boot 3.5.9** REST API project with Java 21 that manages student records. It uses:
- **Framework**: Spring Boot with Spring Web (REST endpoints) and Spring Data JPA
- **Database**: SQL Server 1433 (school database) via mssql-jdbc driver
- **Build Tool**: Maven with Spring Boot Maven Plugin
- **Server Port**: 8888

## Architecture & Data Flow

### MVC Structure
```
DemoApplication (main entry point + REST endpoints)
  ├── StudentController (REST endpoints for /api/students)
  ├── StudentRepository (JPA interface for Student entity)
  └── Student (JPA entity mapped to 'students' table)
```

**Key Pattern**: 
- `@RestController` on `StudentController` and `DemoApplication` serves HTTP endpoints
- `StudentRepository` extends `JpaRepository<Student, Integer>` for automatic CRUD operations
- `Student` entity uses Jakarta Persistence (jakarta.persistence) with `@Entity` and `@Table` annotations
- Dependency injection via `@Autowired` on repository fields

### Database Connection
- **SQL Server Connection**: `jdbc:sqlserver://localhost:1433;databaseName=school`
- **DDL Mode**: `ddl-auto=none` (schema managed manually, not auto-generated)
- **Hibernate Dialect**: `org.hibernate.dialect.SQLServerDialect`

## Critical Developer Workflows

### Building
```bash
# Maven build
./mvnw clean package

# Windows
mvnw.cmd clean package
```

### Running the Application
```bash
# Via Maven
./mvnw spring-boot:run

# Via compiled JAR
java -jar target/demo-0.0.1-SNAPSHOT.jar
```

### Testing
```bash
# Run all tests
./mvnw test

# Single test class
./mvnw test -Dtest=DemoApplicationTests
```

### Database Setup
- Ensure SQL Server instance is running on localhost:1433
- Create/configure `school` database manually before running
- Use SQL Server credentials: username=`sa`, password=`123123`
- JPA will NOT auto-create tables (ddl-auto=none); provide schema separately

## Project Conventions & Patterns

### Package Structure
- **Controllers**: `com.example.demo.controller.*` - REST endpoints
- **Models**: `com.example.demo.model.*` - JPA entities
- **Repositories**: `com.example.demo.repository.*` - Data access layer

### REST Endpoint Patterns
- Base path: `/api` 
- Controllers use `@RestController`, `@RequestMapping("/api")`, `@GetMapping`, etc.
- Example endpoints:
  - `GET /api/hello` → simple greeting
  - `GET /api/greet?name=John` → parameterized response
  - `GET /api/students` → fetch all students

### Entity Design
- Use Jakarta Persistence annotations (`jakarta.persistence.*`)
- Map entity class to database table with `@Entity` and `@Table(name="...")`
- Include standard getters/setters for all fields
- Primary key field should be mapped correctly (Student uses `id`)

### Repository Layer
- Extend `JpaRepository<Entity, PrimaryKeyType>` for automatic CRUD
- No custom SQL needed for basic operations
- Use Spring Data method naming conventions for custom queries (e.g., `findByName()`)

## Cross-Component Communication & Dependencies

### Spring Boot Dependency Injection
- Use `@Autowired` to inject repositories into controllers
- Example: `StudentRepository repository` in `StudentController`

### Common Integration Points
1. **REST → Controller → Repository → Database**
   - HTTP request → `StudentController.getAll()` → `StudentRepository.findAll()` → SQL Server query
2. **Configuration**: `application.properties` contains all environment-specific settings
3. **Error Handling**: Use Spring's default exception handling (not yet custom-implemented)

## Important Notes for AI Agents

- **SQL Server Required**: This app WILL NOT RUN without a configured SQL Server instance
- **No Auto-DDL**: Tables must exist before application startup (ddl-auto=none)
- **Logging**: Enable `spring.jpa.show-sql=true` to debug JPA/Hibernate queries
- **Port Conflict**: Application runs on port 8888 (non-standard); check for conflicts
- **Java 21**: Project targets Java 21; ensure JDK 21 is installed and configured

## File References for Key Patterns
- [DemoApplication.java](src/main/java/com/example/demo/DemoApplication.java) - Main entry point & example endpoints
- [StudentController.java](src/main/java/com/example/demo/controller/StudentController.java) - REST controller pattern
- [Student.java](src/main/java/com/example/demo/model/Student.java) - JPA entity pattern
- [StudentRepository.java](src/main/java/com/example/demo/repository/StudentRepository.java) - Data access layer
- [pom.xml](pom.xml) - Dependencies and build configuration
- [application.properties](src/main/resources/application.properties) - Database & server configuration
