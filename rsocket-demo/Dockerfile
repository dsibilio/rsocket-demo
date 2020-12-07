FROM maven:3.5-jdk-8
COPY ./pom.xml ./pom.xml
RUN mvn -B dependency:resolve dependency:resolve-plugins
COPY ./src ./src
RUN mvn package -DskipTests
RUN mv ./target/rsocket-demo-*.jar ./target/rsocket-demo.jar
ENV SPRING_PROFILES_ACTIVE=prod
CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "./target/rsocket-demo.jar"]
