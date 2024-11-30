FROM openjdk:17-jdk-alpine
ARG USERNAME
ARG PASSWORD
ARG JWT_SECRET
RUN mkdir /app
WORKDIR /app
COPY target/*.jar /app/app.jar
CMD ["java", "-jar", "/app/app.jar"]