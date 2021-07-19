# Wishlist backend

## Requirements

- Java 11+
- Docker/docker-compose
- IntelliJ IDEA (optional)

## Setup

```
$ docker-compose -f ./docker-compose.yaml up -d    # starts required services, wait until PostgreSQL is ready
$ ./gradlew update    # migrates the database
```

or after importing the project to IntelliJ IDEA, start `Compose Deployment` and `Liquibase migration` configurations.

## Database migration

We use Liquibase for SQL migrations. To start the migration, run `./gradlew update` or IntelliJ
configuration `Liquibase migration`
