FROM gradle:8.12.1-jdk21-alpine AS build
WORKDIR /app
COPY build.gradle settings.gradle ./
COPY src ./src
RUN gradle build -x test

FROM openjdk:21 AS PROD
WORKDIR /app
COPY --from=build /app/build/libs/*SNAPSHOT.jar app.jar
LABEL author="Daniel Silva Marcelino"
LABEL description="Imagem do bootcamp \"Claro - Java com Spring Boot\" na DIO"
CMD ["java", "-jar", "app.jar"]