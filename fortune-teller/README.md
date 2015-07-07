# Fortune Teller

*Fortune Teller* is a very basic application composed of two services:

* [Fortune Services](fortune-service)link:fortune-teller-fortune-service[Fortune Service] - serves up random Chinese fortune cookie fortunes
* [Fortune UI](fortune-ui) - presents a UI that consumes the fortune service

It leverages libraries and services from Spring Cloud and Netflix OSS to compose the system.

1 Change to the fortune-service directory

    $ cd fortune-service
     
2 Run this project as a Spring Boot app, e.g. import into IDE and run main method, or use Maven:

    $ mvn spring-boot:run
        
3 It will start up on port 8080 and serve the Fortune API from "/fortunes".
 
    $ http://localhost:8080/fortunes

4 Change to the fortune-ui directory

    $ cd fortune-ui
    
5 Run this project as a Spring Boot app, e.g. import into IDE and run main method, or use Maven:

    $ mvn spring-boot:run
    
6 If you run from this project it will be on port 7979 (per the application.yml).
On the home page is a form where you can enter the URL for an event stream to monitor: 

    $ http://localhost:8081

## Deploy to Cloud Foundry
   
    Lab