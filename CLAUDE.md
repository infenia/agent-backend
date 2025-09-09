# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is the **Infenia EasyMarry** backend, a reactive microservices-based matrimonial application built with Java 21, Spring Boot 3.x, and WebFlux. The system uses R2DBC for reactive database access and follows Domain-Driven Design principles.

## Key Development Commands

### Building and Running
```bash
# Build entire project
./gradlew clean build

# Run specific service (replace :user with desired service)
./gradlew :user:bootRun

# Build specific service
./gradlew :user:build
```

### Testing Commands
```bash
# Run tests for specific service
./gradlew :user:test

# Run domain-specific test suites (user service examples)
./gradlew :user:userTest
./gradlew :user:imageTest
./gradlew :user:adminControlTest
./gradlew :user:preferenceTest
./gradlew :user:professionTest

# Run layer-specific tests
./gradlew :user:serviceTest
./gradlew :user:controllerTest
./gradlew :user:integrationTest

# Run tests for all services
./gradlew test
```

### Code Quality
```bash
# Run PMD static analysis
./gradlew pmdMain

# Format code with Spotless
./gradlew spotlessApply

# Check code formatting
./gradlew spotlessCheck

# OWASP dependency check
./gradlew dependencyCheckAnalyze
```

## Architecture Overview

### Microservices Structure
- **Gateway**: API Gateway and routing service (port 8080) - Entry point for all requests
- **User**: User management, profiles, and authentication - Core user domain
- **Interaction**: User interactions, shortlists, interests, requests - User relationship management
- **Media**: Image, video, and document handling - File management service
- **Notification**: Push notifications and messaging - Communication service
- **Recommendation**: Matching algorithm and recommendations - Business logic service
- **Common**: Shared cross-cutting concerns (activity, notification-util, report)
- **Util**: Core utilities and base classes - Foundation layer with test utilities
- **Data**: C++ data processing service - High-performance data processing

### Technology Stack
- **Java 21** with Project Reactor for reactive programming
- **Spring Boot 3.x** with WebFlux (no Spring MVC)
- **R2DBC** for reactive database access with PostgreSQL
- **Keycloak** for identity and access management
- **Caffeine** for caching
- **MapStruct** for object mapping
- **Flyway** for database migrations

### Key Patterns and Conventions

#### Testing
- Use JUnit 5 with parameterized tests
- Domain-specific test tags for granular test execution (`@Tag("imageTest")`)
- Custom parameter resolvers for automatic test data injection (`@ExtendWith(UserServiceParameterResolver.class)`)
- Sophisticated test utilities: `CrudServiceTester`, `ControllerTester`, `IntegrationTester`
- Reactive testing with `StepVerifier`
- Service tests inherit from domain-specific testers in util module
- Verify `verifyNoMoreInteractions` in `@AfterEach`
- Test organization by domain AND layer (service, controller, integration)

#### Database
- All entities extend `BaseEntity` from util module
- Use R2DBC repositories extending custom base repositories
- Flyway migrations in `src/main/resources/db/migration/{service-name}/`
- Follow naming convention: `V{YYYY.MM.DD.HH.mm}__description.sql`

#### Caching
- Caffeine caching with domain-specific cache names
- Cache configuration in `application.yaml`
- Cache names follow pattern: `{domain}CacheName`

#### Error Handling
- Custom error messages in `messages/error.properties`
- Use reactive error handling patterns
- Database exceptions handled by `DatabaseExceptionHandler`

#### Code Style
- Google Java Style Guide enforced by Spotless
- PMD static analysis with custom rulesets per service
- Lombok for boilerplate reduction (config: `lombok.addLombokGeneratedAnnotation = true`)
- Records preferred over classes for immutable data

#### ⚠️ Side Effects in Reactor
- **Always wrap side-effecting code in `Mono.defer`** to defer execution until subscription time.
- This is especially critical in service and repository layers to avoid unexpected premature execution.

## Configuration Management

### Application Properties
- Service-specific configuration in `application.yaml`
- Test configuration in `application-test.yaml`
- Environment-specific overrides supported
- External service URLs configured via properties

### Key Configuration Areas
- Cache settings (Caffeine)
- Database connections (R2DBC)
- CORS configuration
- Keycloak IDP settings
- OpenTelemetry tracing
- Management endpoints

## Common Development Workflows

### Adding New Features
1. Create feature branch from `main`
2. Implement domain logic following DDD patterns (Controller → Service → Repository → Entity)
3. Add comprehensive tests with domain and layer tags (`@Tag("domainTest")` + `@ServiceTest`)
4. Use test utilities (`CrudServiceTester`, `ControllerTester`) instead of writing tests from scratch
5. Update database schema with Flyway migration
6. Run quality checks: `./gradlew spotlessCheck pmdMain`
7. Test domain-specific functionality: `./gradlew :service:domainTest`
8. Ensure all tests pass: `./gradlew test`

### Working with Tests
- Tests are organized by domain (user, image, admin, etc.) AND layer (service, controller, integration)
- Use domain-specific test execution for faster feedback: `./gradlew :user:imageTest`
- Use test utilities instead of writing tests from scratch:
  - `CrudServiceTester` for comprehensive service testing
  - `ControllerTester` for REST endpoint testing
  - `IntegrationTester` for full-stack testing
- Parameter resolvers available for automatic test data injection
- Always include both domain tags (`@Tag("imageTest")`) and layer annotations (`@ServiceTest`)
- Integration tests use embedded test database with cross-service migrations

### Database Changes
- Always create Flyway migration scripts
- Use descriptive names with timestamp prefix
- Test migrations with clean database
- Never modify existing migration files

## Important Notes

- All services are reactive - use `Mono` and `Flux` return types
- No blocking operations in reactive streams
- **Repository hierarchy**: Use `BaseRepository`, `SoftDeleteRepository`, or `SoftDeleteWithUserIdRepository`
- **Service hierarchy**: Extend appropriate CRUD service base classes for automatic functionality
- **Entity patterns**: All entities extend `BaseEntity` with soft delete capabilities
- Custom validation annotations in util module
- **BuildSrc conventions**: Use appropriate Gradle convention plugins for consistent builds
- Security handled via Keycloak integration
- Distributed tracing with OpenTelemetry
- Service-to-service communication via WebClient