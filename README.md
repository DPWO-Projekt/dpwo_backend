# DPWO Backend

This repository contains the backend for the DPWO project, a Spring Boot application with MongoDB.

## Prerequisites

- Docker and Docker Compose

No need to install Java, Maven, or MongoDB locally. Docker takes care of everything.

## Running the Application

1. Start the application:
   ```
   docker-compose up --build -d
   ```

2. The application will be available at http://localhost:8080

3. To stop the application:
   ```
   docker-compose down
   ```

4. View logs:
   ```
   docker-compose logs -f app
   ```

## Running Tests

Run the tests using Docker Compose:
```
docker-compose -f docker-compose.test.yml up --build
```


## Configuration

The application is fully configured through Docker environment variables. You don't need to modify any configuration files directly.

### Docker Environment Variables

All configuration is done through environment variables in the docker-compose files:

**Production (docker-compose.yml):**
- `SPRING_DATA_MONGODB_HOST=mongodb`: Points to the MongoDB service
- `SPRING_DATA_MONGODB_PORT=27017`: MongoDB port
- `SPRING_DATA_MONGODB_DATABASE=dpwo_db`: Database name

**Testing (docker-compose.test.yml):**
- `SPRING_DATA_MONGODB_HOST=mongodb-test`: Points to the test MongoDB service
- `SPRING_DATA_MONGODB_PORT=27017`: MongoDB port
- `SPRING_DATA_MONGODB_DATABASE=dpwo_test_db`: Test database name

## Development Workflow

1. Clone the repository
2. Make your code changes
3. Run tests: `docker-compose -f docker-compose.test.yml up --build`
4. Run the application: `docker-compose up --build -d`
5. Check the application at http://localhost:8080

No local Java, Maven, or MongoDB installation needed!