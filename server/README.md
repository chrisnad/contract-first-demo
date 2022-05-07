# Generate Server Stubs With OpenAPI Generator CLI


```
openapi-generator generate -g spring --library spring-boot -i petstore.yaml -o app
```

This will generate all the code for a working spring-boot application server out of the box. To start the server run:

## Run as Spring Application

Prerequisites:
- Maven 3.6.3 or higher
- Java 8 or higher

Then run spring-boot application : `mvn spring-boot:run`

You should see `Tomcat initialized with port(s): 8080 (http)`

Your application is accessible at `http://localhost:8080`
