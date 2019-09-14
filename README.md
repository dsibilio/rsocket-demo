# Getting Started

### What's this?

A Spring Boot 2.2 reactive application to be used as an RSocket demo, including the following features:

* Java RSocket server
* Java RSocket client
* Javascript RSocket client

The *Java backend* exposes the following **APIs**:

* **HTTP** [http://localhost:8080/socket/{author}](http://localhost:8080/socket/{author}) : the HTTP request triggers the **Java RSocket client** to pull data from the **Java RSocket server**
* **HTTP** [http://localhost:8080/tweets/{author}](http://localhost:8080/tweets/{author}) : the same API as above but without any socket interaction, pure **SSE over HTTP**
* **WS** `ws://localhost:8080/tweetsocket` - route: `tweets.by.author` : WebSocket transport employed by the **Javascript RSocket client** to pull data from the **Java RSocket server**

The *Javascript client* can be used by requesting [http://localhost/rsocket/index.html](http://localhost/rsocket/index.html)

**the possible* `{author}` *values are* `linustorvalds`*,* `robertmartin`*,* `martinfowler`*.*

### Quickstart

**1.** Spin up the *backend* by running: `mvn spring-boot:run`

**2.** Deploy the *front end* locally (steps for **nginx**):
- copy `js-client/index.html` and `js-client/app.js` to nginx root directory + `rsocket` (eg. `/usr/share/nginx/html/rsocket/`)
- start nginx: `systemctl start nginx`

### Reference Documentation
For further reference, please consider the following resources:

* [More about RSocket](http://rsocket.io/)
* [RSocket Java GitHub Repo](https://github.com/rsocket/rsocket-java)
* [RSocket Javascript GitHub Repo](https://github.com/rsocket/rsocket-js)

