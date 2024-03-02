FROM adoptopenjdk/openjdk17:alpine-jre

WORKDIR /app

COPY target/myapp.jar /app/myapp.jar

# Comando para executar o aplicativo quando o contêiner for iniciado
CMD ["java", "-jar", "myapp.jar"]
