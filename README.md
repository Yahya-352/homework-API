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

| Method | URL | Access | Description |
|--------|-----|--------|-------------|
| POST | `/users/register` | Public | Register a new user |
| POST | `/users/login` | Public | Log in and receive a JWT |
| GET | `/hello` | Private | Returns "Hello World!" |
| GET | `/api/categories/` | Private | Get all categories |
| POST | `/api/categories/` | Private | Create a category |
| GET | `/api/categories/{categoryId}` | Private | Get one category |
| PUT | `/categories/update/{id}` | Private | Update a category |
| DELETE | `/categories/delete/{id}` | Private | Delete a category |
| POST | `/items/create/{categoryId}` | Private | Create an item under a category |
| GET | `/items/` | Private | Get all items |
| GET | `/items/{categoryId}` | Private | Get all items for a category |
| PUT | `/items/update/{itemId}` | Private | Update an item |
| DELETE | `/items/delete/{itemId}` | Private | Delete an item |

> **Public** endpoints need no token. **Private** endpoints require the header `Authorization: Bearer <token>`.

## Tech Stack

- Java
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven
