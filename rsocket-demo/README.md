# Getting Started

## What's this?

A Spring Boot 2.2 reactive application to be used as an RSocket demo, including the following features:

* Java RSocket server
* Java RSocket client
* Javascript RSocket client

The *Java backend* exposes the following **APIs**:

* **HTTP** [http://localhost:8080/socket/{author}](http://localhost:8080/socket/{author}) : the HTTP request triggers the **Java RSocket client** to pull data from the **Java RSocket server**
* **HTTP** [http://localhost:8080/tweets/{author}](http://localhost:8080/tweets/{author}) : the same API as above but without any socket interaction, pure **SSE over HTTP**
* **WS** `ws://localhost:8080/tweetsocket` - route: `tweets.by.author` : WebSocket transport employed by the **Javascript RSocket client** to pull data from the **Java RSocket server**

The *Javascript client* can be used by requesting [http://localhost:8080/index.html](http://localhost:8080/index.html)

**the possible* `{author}` *values are* `linustorvalds`*,* `robertmartin`*,* `martinfowler`*.*

## Quickstart

Spin up both the *backend* and the *frontend* by running: `mvn spring-boot:run`.

> **NOTE:** when started this way, the demo will try to run an Embedded Redis Server instance on the specified port.
If a Redis Server instance is already running on your machine you can either *a)* change the specified redis port in the [application.yml](src/main/resources/application.yml) file, or *b)* run the demo with the prod profile enabled, which disables the Embedded Redis Server (eg. `mvn spring-boot:run -Dspring-boot.run.profiles=prod`).

### Running with Docker

...or if you want, you can run the app within docker by running: `docker-compose up`

*(this will use a dockerized Redis server rather than embedded Redis!)*

## Reference Documentation
For further reference, please consider the following resources:

* [More about RSocket](http://rsocket.io/)
* [RSocket Java GitHub Repo](https://github.com/rsocket/rsocket-java)
* [RSocket Javascript GitHub Repo](https://github.com/rsocket/rsocket-js)

