# DOCKER_BUILDKIT=1 docker build .

 # syntax=docker/dockerfile:1

FROM maven:3.8.2 AS maven
WORKDIR /home/lou/git/GesFormation
COPY . .
RUN Mvn package

FROM azul/zulu-openjdk-alpine:11
WORKDIR /home/lou/git/GesFormation/app
COPY --from=maven ./target/*.jar app.jar
CMD mvn spring-boot:run
ENTRYPOINT ["java","-jar","app.jar"]
