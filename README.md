# Mock Transaction API

## Introduction
Project to mock responses of users' transactions. The main idea is that it could be used to
test even APIs' contracts and provide some facility to integration tests as well.

## Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

- Java 8
```
https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
```

- Postgresql
```
https://www.postgresql.org/download/
```

- Docker
```
https://docs.docker.com/get-docker/
```

NOTE: once you decide to use docker, it's not necessary to install the postgres database.

### Code:
- Cloning the project:

```
$ git clone https://github.com/rchibana/mock-transaction-api.git
```

### Database:
- Execute the following command to create the database:
```
CREATE DATABASE mock_transaction_api
```

### Migration
- Once you run the project for the very first time, all migrations will be executed automatically

### Running the project 
#### Using docker
- Execute the following command:

```
$ ./gradlew bootRun --args='--spring.profiles.active=dev'
```

#### Not using docker



After the execution of the command above(with or without docker), you must be able to see the swagger interface with 
some information of endpoints and examples.

```
http://localhost:8080/swagger-ui.html
```

## Built With
* [Spring](https://spring.io/projects) - The web framework used
* [Flyway](https://flywaydb.org/) - Migration plugin
* [MapStruct](https://mapstruct.org/) - Java beans mapping
* [Gradle](https://gradle.org/) - Dependency Management
* [Intellij](https://www.jetbrains.com/idea/) - IDE used to develop the project

## Author
* [Rodrigo Chibana](http://github.com/rchibana)
