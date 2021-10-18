FROM openjdk:13-alpine3.10
EXPOSE 8080
ADD target/Autorization-0.0.1-SNAPSHOT.jar autrzApp.jar
ENTRYPOINT ["java", "-jar", "autrzApp.jar"]

