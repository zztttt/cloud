FROM openjdk:8-jdk-alpine AS eureka
ARG EUREKA_JAR_PATH=eureka/target/eureka-0.0.1-SNAPSHOT.jar
COPY ${EUREKA_JAR_PATH} tmp.jar
ENTRYPOINT ["java", "-jar", "/tmp.jar"]