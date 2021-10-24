FROM openjdk:8-jdk-alpine
ARG APP_JAR=app/target/*.jar
ARG BOOKSTORE_JAR=bookstore/target/*.jar
ARG GATEWAY_JAR=bookstore/target/*.jar
COPY ${APP_JAR} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]