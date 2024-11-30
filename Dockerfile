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
CMD ["java", "-jar", "/app/target/pic-store-backend-0.0.1-SNAPSHOT.jar"]