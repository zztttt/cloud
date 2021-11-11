FROM openjdk:8-jdk-alpine AS app
ARG APP_JAR_PATH=app/target/*.jar
COPY ${APP_JAR_PATH} tmp.jar
CMD java -jar /tmp.jar --server.port=$SERVER_PORT
#ENTRYPOINT ["java","-jar","/tmp.jar", "--server.port=8002"]