# multiverse
Small REST Interface for a mini Multiverse using Spring Boot and MySQL

Multiverse has Parallel Universes, Persons and Families. Families can span across parallel universes, Persons can have powers either positive or negative.

This project uses Spring Boot, Hibernate and MySQL. 

It follows the common Controller -> Service -> Repository -> DB flow.

It also exploses a CRUD Service which is built using Generics. You can check out AbstractCRUDController, AbstractCRUDService for this. We would just need to pass the Entity, Repository and the Service and it would handle all those endopoints.

Pending: Test cases using H2 db. 

To start the server: 
Clone the project and go to the root folder of this repo and run these two commands
`mvn clean install` 
`mvn spring-boot run`

The server would run on port 9042
