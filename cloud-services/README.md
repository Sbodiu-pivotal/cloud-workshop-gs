# Spring Cloud

Spring Cloud builds on Spring Boot by providing a bunch of libraries that enhance the behaviour of an application when added to the classpath.
You can take advantage of the basic default behaviour to get started really quickly, and then when you need to, you can configure or extend to create a custom solution.
Let's get started with Spring Cloud and Build our Cloud Native Application sample

## Spring Cloud  Starter

Spring Boot-style starter projects to ease dependency management for consumers of Spring Cloud.

1 Change to the lab directory
 
    $ cf cloud-services    
    
2 Inspect pom.xml    

    <parent>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-parent</artifactId>
        <version>1.0.2.RELEASE</version>
        <relativePath/>
    </parent>

3 Build the project:
    
    $ mvn package
    
## Spring Cloud Config 

Spring Cloud Config Server Features:
* HTTP, resource-based API for external configuration (name-value pairs, or equivalent YAML content)
* Encrypt and decrypt property values (symmetric or asymmetric)
* Embeddable easily in a Spring Boot application using @EnableConfigServer

Config Client features (for Spring applications):2
* Bind to the Config Server and initialize Spring Environment with remote property sources
* Encrypt and decrypt property values (symmetric or asymmetric)

1 Change to the cloud config directory
    
    $ cd configserver 

2 Run this project as a Spring Boot app, e.g. import into IDE and run main method, or use Maven:

    $ mvn spring-boot:run

3 It will start up on port 8888 and serve configuration data from "https://github.com/spring-cloud-samples/config-repo":

    $ http://localhost:8888/demo/default


Resources

Path	Description
/{app}/{profile}	Configuration data for app in Spring profile (comma-separated).
/{app}/{profile}/{label}	Add a git label

## Spring Cloud Service Discovery

Service Discovery is one of the key tenets of a microservice based architecture.
Trying to hand configure each client or some form of convention can be very difficult to do and can be very brittle. 
It's based on Eureka Netflix OSS product, Spring Cloud Netflix features:
                                   
* Service Discovery: Eureka instances can be registered and clients can discover the instances using Spring-managed beans
* Service Discovery: an embedded Eureka server can be created with declarative Java configuration

1 Change to the eureka directory

    $ cd eureka
     
2 Run this project as a Spring Boot app, e.g. import into IDE and run main method, or use Maven:

    $ mvn spring-boot:run
        
3 It will start up on port 8761 and serve the Eureka API from "/eureka".
 
    $ http://localhost:8761/

Resources

Path	Description
/	Home page (HTML UI) listing service registrations
/eureka/apps	Raw registration metadata

## Spring Cloud Circuit Breaker

It's based on Hystrix Netflix OSS product, Netflix has created a library called Hystrix that implements the circuit breaker pattern.
In a microservice architecture it is common to have multiple layers of service calls.
Having an open circuit stops cascading failures and allows overwhelmed or failing services time to heal.
The fallback can be another Hystrix protected call, static data or a sane empty value.

Spring Cloud Netflix features:

* Circuit Breaker: Hystrix clients can be built with a simple annotation-driven method decorator
* Circuit Breaker: embedded Hystrix dashboard with declarative Java configuration. Dashboard displays the health of each circuit breaker in an efficient manner.


1 Change to the hystrix directory

    $ cd hystrixdashboard
    
2 Run this project as a Spring Boot app, e.g. import into IDE and run main method, or use Maven:

    $ mvn spring-boot:run
    
3 If you run from this project it will be on port 7979 (per the application.yml).
On the home page is a form where you can enter the URL for an event stream to monitor: 

    $ http://localhost:7979

# REST based micro-services sample

- Three Spring Boot based Maven projects that are standalone applications:
  - Stores (MongoDB, exposing a few Starbucks shops across north america, geo-spatial functionality)
  - Customers (JPA)
  - Customers UI (Angular and Spring Boot CLI backend)
- The customers application tries to discover a search-by-location-resource and periodically verifying it's still available (see `StoreIntegration`).
- If the remote system is found the customers app includes a link to let clients follow to the remote system and thus find stores near the customer.
- Hystrix is used to monitor the availability of the remote system, so if it fails to connect 20 times in 5 seconds (by default) the circuit will open and no more attempts will be made until after a timeout.

## Running Instructions
- Before try to run the services, make sure you have Rabbitmq Server and MongoDB running on localhost.
- Make sure you have [Spring Boot for Groovy installed] (http://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#getting-started-gvm-cli-installation)
- Make sure [Spring Cloud CLI is installed] (https://github.com/spring-cloud/spring-cloud-cli)
- To run the services, just execute "mvn spring-boot:run" in each project subfolder, and "spring run app.groovy" for the UI.

To run it locally you can install mongo, rabbit and redis:

    brew install mongodb rabbitmq redis
    
To run the apps (each in a different terminal)

    $ rabbitmq-server
    $ mongod --config /usr/local/etc/mongod.conf
    $ redis-server /usr/local/etc/redis.conf
        
Run the apps:

    $ ./run.sh

You can kill the processes using `./kill.sh`, and both scripts know how to operate on individual apps or subsets, e.g. (the default):

    $ ./run.sh configserver eureka customers stores

To run the UI with the maps, get the Spring Boot CLI, and install the
platform CLI plugin, e.g. with GVM:

    $ gvm install springboot 1.2.0.RC1
    $ gvm use springboot 1.2.0.RC1

and finally install the Spring Cloud plugin:

    $ spring install org.springframework.cloud:spring-cloud-cli:1.0.0.BUILD-SNAPSHOT

Then run the app

    $ (cd customers-stores/customers-ui; spring run app.groovy)
    
## Running on Cloud Foundry

Pre-requisites: 

* Maven (3)
* Java (1.8)
* the `cf` CLI
* Cloud Foundry with Java buildpack version 2.5 or greater (for Java 1.8 support)

Clone the repository and initialize submodules:

```
$ git clone https://github.com/spring-cloud-samples/scripts
$ cd scripts
$ ./build.sh
$ ./services_deploy.sh
$ ./demo_deploy.sh
```    
