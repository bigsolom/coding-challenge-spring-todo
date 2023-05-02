# coding-challenge-spring-todo


## Task Description

The task is to provide a simple Todo backend with REST endpoints using Spring Boot and version it on GitHub. The backend should have the following functionality:

Accept a new Todo item with a title and status.
Be able to display all Todo items.
Be able to update a Todo item.
The items should be stored in a MongoDB.

Tests would be great as well.


## Setup

To start a `mongodb` instance locally using Docker, make sure that Docker is [installed](https://docs.docker.com/get-docker/) and running then execute:

`docker run --name mongodb -d -p 27017:27017 mongodb/mongodb-community-server:6.0.5-ubi8`

Create default users on the local MongoDB to authenticate the app while connecting to it

1. Copy `mongodb-init.js` from the host to the docker container

`docker cp src/main/resources/db/mongodb-init.js mongodb:/tmp/`

2. Execute `mongosh` on the docker container

`docker exec -it mongodb mongosh`

3. Finally load the `mongodb-init.js` script that was copied

`.load /tmp/mongodb-init.js`

## Running locally

Setup the environment variables `DATABASE_USER`, `DATABASE_PASSSWORD`, `DATABASE_HOST`. If you used the `mongodb-init.js` file then those would be:

```bash
export DATABASE_PASSWORD=test
export DATABASE_USER=test
export DATABASE_HOST=localhost
```

To run the project locally, make sure that a MongoDB is started then execute:

`./gradlew bootRun`

## Available APIs

_Note: can be moved to an API documentation tool like Swagger later_

```agsl
GET /todos
POST /todos
PUT /todos/{id}
```