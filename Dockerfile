
FROM maven:3.8.1-jdk-11

WORKDIR /GesFormation

COPY . .

RUN mvn clean install -Dmaven.test.skip=true

CMD mvn spring-boot:run
