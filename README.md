# Running-Location-Monitor

The real-time running location simulation and monitoring system utilized Spring and Spring Boot based on Maven, JPA, Tomcat, RabbitMQ, MongoDB, MySQL and Docker. 

It effectively implemented server side REST APIs, such as running location update service, location distribution service, and location persistence service using MongoDB, Spring Data, Spring Boot and Spring Cloud. The back-end services are implemented based on Microservices architecture, Incorporated Netflix Eureka as service registration and discovery.

The application persists data to MongoDB and MySQL using Spring Data as Data Access Layer, and applied RabbitMQ as message queue to decouple back-end microservices.

Deployed applications to embedded Tomcat in automated fashion, and dockerize the system infrastructure in a Vagrant managed virtual machine.

**This is a _prototype of project Real-Time Fitness Tracking System_, with a naive frontend single web page written by Html/CSS and javascript, and a simulator that help for testing.**

## Service Description

### Running Location Service
Communication with h2/MySQL database: upload and store pre-defined locations and running status. Get location detail according to runningId or status, send to frontend with Rest API.

### Running Location Simulator
A predefined service that can simulate a running path and set of locations, scheduled to run for unit test and integration test.

### Running Distribution Service
Decoupled service that send message (new current location from simulator) to message queue.

### Running Location Updater
Consume message from the queue, and setup webSocket connection with Frontend/Client side

### Supply Location Service
Store and retrieve supply locations. Supply can be flexible defined in the MongoDB database. For instance, medical supply.

## Testing on Local
The Spring boot application was developed based on maven. It can be tested on local by:

```bash
mvn clean install
java -jar ./target/<service-name>.jar
```
