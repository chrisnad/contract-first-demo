# contract-first-demo

## Generate Server Stubs With OpenAPI Generator CLI


```
openapi-generator generate -g spring --library spring-boot -i bike.yaml -o server
```

This will generate all the code for a working spring-boot application server out of the box. To start the server run:

### Run as Spring Application

Prerequisites:
- Maven 3.6.3 or higher
- Java 8 or higher

Then run spring-boot application : `mvn spring-boot:run`

You should see `Tomcat initialized with port(s): 8080 (http)`

Your application is accessible at `http://localhost:8080`


## Generate Client SDKs With OpenAPI Generator CLI

```
openapi-generator generate -g java --library resttemplate -i bike.yaml -o client
```

## Run Schemathesis tests

Prerequisites:
- Python3

Create a virtual environment with `python3 -m venv pocvenv`

Activate the virtual environment with `source pocvenv/bin/activate`

Install `schemathesis` with `pip install schemathesis`

Make sure your application is running with `mvn spring-boot:run`

Run Schemathesis tests with `schemathesis run src/main/resources/store.yaml --checks=all --base-url=http://localhost:8080/store/v1`
