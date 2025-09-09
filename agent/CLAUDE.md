# CLAUDE.md

## Purpose
Guidance for developing in the `agent` module of Infenia EasyMarry backend (Java 21, Spring Boot 3.5, WebFlux, R2DBC, DDD).

---

## Quick Start

```bash
# Build only this module
./gradlew :agent:build

# Run only agent module tests
./gradlew :agent:test

# Debug tests (agent)
./gradlew :agent:test --debug

# Test coverage (all, or just this module if configured)
./gradlew :agent:jacocoTestReport

# PMD static analysis
./gradlew :agent:pmdMain
./gradlew :agent:pmdTest

# Format code (Spotless)
./gradlew :agent:spotlessApply

# Check code formatting
./gradlew :agent:spotlessCheck

# Lint/checkstyle (if configured)
./gradlew :agent:check

# Dependency vulnerability scan
./gradlew :agent:dependencyCheckAnalyze

# List all available Gradle tasks for this module
./gradlew :agent:tasks
```

---

## Architecture & Coding Standards
- **Immutability:** Use Java `record` or final classes. No setters or mutable fields.
- **Reactive:** All code must be non-blocking (WebFlux, R2DBC). No `block()`, `subscribe()`, or blocking APIs.
- **Error Handling:** Propagate errors via Reactor. Use centralized exception mapping.
- **Domain-Driven:** Only shared agent logic/entities. No service-specific code.
- **Quality:**
- Must pass PMD, Spotless, and all tests.
- One return statement per method (PMD rule).
- No unused variables, dead code, or imperative loops in reactive flows.
- **Testing:**
- 100% coverage goal. Use JUnit 5, AssertJ, Mockito, StepVerifier.
- Use Testcontainers for R2DBC integration tests.
- **Security:** Validate and sanitize all input. No plain credentials.

---

## Troubleshooting & Best Practices
- If builds/tests fail, check for:
- Missing reactive return types (`Mono<T>`/`Flux<T>`)
- Blocking calls or state mutation
- PMD or Spotless errors (run `./gradlew check`)
- For DB issues, ensure R2DBC/Postgres is running (see Testcontainers setup).
- Use `Mono.defer` for lazy evaluation in conditional/complex logic.
- Log with structured logging (no `System.out.println`).
- Ask for code review if unsure about DDD boundaries or reactive flows.

---

## Agent Responsibility
Maintain **readability, scalability, and correctness** in every line of code. Strictly adhere to project coding, quality, and testing standards.
