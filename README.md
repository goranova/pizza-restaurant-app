# pizza-restaurant-app

The application uses java 17, Spring Boot, PostgreSQL. The database is running on Docker.
The configuration file is docker-compose.yml

The application uses flyway: the scripts are in : src/main/resources/db/migration/V1__create_tables.sql
src/main/resources/db/migration/V2__insert_data.sql

The application requests an order via POST Request, the end point is: /order

It checks if the ordered items (pizza and drinks) exist in the db and returns the bill.
If they don't exist, it throws custom exception.
The exception is handled by GlobalExceptionHandler.java

The examples files for request and response are in : src/main/resources/static/RequestBody.json
src/main/resources/static/ResponseBody.json

