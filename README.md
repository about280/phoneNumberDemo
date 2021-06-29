# Phonenumber Demo

### Demo Description

In our database, we are starting to store phone numbers associated to customers (1 customer: N phone numbers) and we will provide interfaces to manage them.

We need to provide the below capabilities:

* get all phone numbers
* get all phone numbers of a single customer
* activate a phone number

Challenge

* Provide interface specifications for the above functions/capabilities.
* Provide an implementation of the formulated specifications.
* You can assume the phone numbers as a static data structure that is initialised when your program runs.

### Design

Spring boot app generated from spring boot starter page:

* Spring jpa is used to save data to H2 in memory database.
* Unit test for the service and controllers are included, as well as an integration test

### Assumptions

* Phone numbers are loaded at startup and none are active
* Retrieving all phone numbers just returns the phone number, not the customer owning that number
* There is no need to de-activate a phone number using this api
* As this uses an in-memory database, any activations are lost on server restart 

### To build and execute
This is a maven based project.

Assuming maven is installed

* To package and run unit tests, "mvn clean package"
* To run from maven, "mvn spring-boot:run"

Server starts on port 8080 by default.

### To explore application apis

SwaggerUi is installed, so once the application is started, can go here:

http://localhost:8080/swagger-ui/

A copy of the swagger is also available at api-docs.json in the same folder as this readme.

### Test data

Customers with an id of 1,2,3 are auto-inserted at startup. The following phone numbers are also auto-inserted:

99991111
99992222
99993333
99994444
99995555
