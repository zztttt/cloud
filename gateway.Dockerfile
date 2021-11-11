FROM openjdk:8-jdk-alpine AS gateway
ARG GATEWAY_PATH=gateway/target/*.jar
COPY ${GATEWAY_PATH} tmp.jar
ENTRYPOINT ["java","-jar","/tmp.jar"]