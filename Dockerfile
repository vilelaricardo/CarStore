FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/CarStore-0.0.1-SNAPSHOT.jar /app/CarStore-0.0.1-SNAPSHOT.jar


CMD ["java", "-jar", "CarStore-0.0.1-SNAPSHOT.jar"]
