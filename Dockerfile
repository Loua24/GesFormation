FROM openjdk:11 
EXPOSE 8080
ADD target/GesF-1.2-SNAPSHOT.jar GesF-1.2-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/GesF-1.2-SNAPSHOT.jar"]