FROM amazoncorretto:21
LABEL authors="hayk.sargsyan"

ARG JAR_FILE=./build/libs/gateway-0.0.1.jar
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]