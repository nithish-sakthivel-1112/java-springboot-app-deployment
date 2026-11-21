# Task Manager — Spring Boot REST API

A small Java/Spring Boot application intended for practising the DevOps delivery workflow.

## Technology

- Java 21
- Spring Boot 3.5.7
- Maven
- JUnit 5 / Spring Boot Test
- Spring Boot Actuator

## Prerequisites

- JDK 21
- Maven 3.6.3 or newer (or use a Maven Wrapper if you add one)

Check your environment:

```bash
java -version
mvn -version
```

## Build and test

Run the test suite:

```bash
mvn test
```

Create a clean package:

```bash
mvn clean package
```

The executable JAR should be created under:

```text
target/task-manager-1.0.0.jar
```

## Run locally

```bash
java -jar target/task-manager-1.0.0.jar
```

The application listens on port 8080.

## API examples

List tasks:

```bash
curl http://localhost:8080/api/tasks
```

Get one task:

```bash
curl http://localhost:8080/api/tasks/1
```

Create a task:

```bash
curl -X POST http://localhost:8080/api/tasks \
  -H 'Content-Type: application/json' \
  -d '{"title":"Build my first Jenkins pipeline"}'
```

Delete a task:

```bash
curl -i -X DELETE http://localhost:8080/api/tasks/1
```

Health:

```bash
curl http://localhost:8080/actuator/health
```

## Notes

- Tasks are stored in memory. They reset when the application restarts.
- This is a learning application, not a production-ready task management system.
- No Dockerfile, Jenkinsfile, cloud configuration or deployment manifests are included intentionally. Those are the DevOps engineer's responsibility in this exercise.
