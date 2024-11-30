FROM openjdk:17-jdk-alpine
ARG username
ARG password
ARG jwt-secret
RUN mkdir /app
WORKDIR /app
RUN apk update && apk add maven
COPY pom.xml .
RUN mvn install -DskipTests
COPY . .
RUN mvn clean package -DskipTests
COPY /app/target/*.jar /app/app.jar
CMD ["java", "-jar", "/app/app.jar"]