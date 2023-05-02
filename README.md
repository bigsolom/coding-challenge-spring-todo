# coding-challenge-spring-todo


## Task Description

The task is to provide a simple Todo backend with REST endpoints using Spring Boot and version it on GitHub. The backend should have the following functionality:

Accept a new Todo item with a title and status.
Be able to display all Todo items.
Be able to update a Todo item.
The items should be stored in a MongoDB.

Tests would be great as well.


## Setup

`docker run --name mongodb -d -p 27017:27017 -v $(pwd)/mongo_data:/data/db mongodb/mongodb-community-server:6.0.5-ubi8`

`docker cp src/main/resources/db/mongodb-init.js mongodb:/tmp/`

`docker exec -it mongodb mongosh`

`.load /tmp/mongodb-init.js`

## Running locally

Setup the environment variables `DATABASE_USER`, `DATABASE_PASSSWORD`, `DATABASE_HOST`

`./gradlew bootRun`