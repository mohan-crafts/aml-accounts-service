
FROM openjdk:17-jdk-slim
COPY target/accounts-service-0.0.1-SNAPSHOT.jar accounts-service.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "/accounts-service.jar"]

