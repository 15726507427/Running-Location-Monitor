# Running-Location-Monitor

The real-time running location simulation and monitoring system utilized Spring and Spring Boot based on Maven, JPA, Tomcat, RabbitMQ, MongoDB, MySQL and Docker. 

It effectively implemented server side REST APIs, such as running location update service, location distribution service, and location persistence service using MongoDB, Spring Data, Spring Boot and Spring Cloud. The back-end services are implemented based on Microservices architecture, Incorporated Netflix Eureka as service registration and discovery.

The application persists data to MongoDB and MySQL using Spring Data as Data Access Layer, and applied RabbitMQ as message queue to decouple back-end microservices.

Deployed applications to embedded Tomcat in automated fashion, and dockerize the system infrastructure in a Vagrant managed virtual machine.

