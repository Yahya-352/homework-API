# Todo App

A Spring Boot backend app built to practice Spring Boot, Spring Profiles,
Spring Data, and PostgreSQL.

## GitHub Repo

https://github.com/Yahya-352/homework-API.git

## Design Decisions

### Step 1 — Spring Boot Setup
- **Decision:** Building the project on Maven and using SpringBoot framework instead of raw java 
- **Why:** SpringBoot annotations automate everything which makes it easier to code and cleaner.

### Step 2 — Spring Profiles
- **Decision:** splitting dev specific config
- **Why:** a production level API requires different environments such as dev and production.

### Step 3 — Spring Data / PostgreSQL
- **Decision:** using jparepository
- **Why:** it works best at translating java basic camel case method names into sql queries and interacting with postgresql(or any) database.

## What Went Right

- The controller calling the Service And service interacting with the repository which interacts with the database , Its an easy structure that simplifies API creation process and offers separation of concerns.

## Challenges Faced

- dev environment not running as I wasn't referencing it in the default application.properties file

## Favorite Part

- the best part in the lab is when we test with postman and it works on the first try (incredible feeling). 

## Endpoints

| Method | URL | Description |
|--------|-----|-------------|
| GET | `/hello` | Returns "Hello World!" |
| GET | `/api/categories/` | Get all categories |
| POST | `/api/categories/` | Create a category |
| GET | `/api/categories/{categoryId}` | Get one category |

## Tech Stack

- Java
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven
