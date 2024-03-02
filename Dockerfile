FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/CarStore-0.0.1-SNAPSHOT.jar /app/CarStore-0.0.1-SNAPSHOT.jar

# Comando para executar o aplicativo quando o contêiner for iniciado
CMD ["java", "-jar", "CarStore-0.0.1-SNAPSHOT.jar"]
