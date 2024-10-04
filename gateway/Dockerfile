FROM amazoncorretto:21
LABEL authors="hayk.sargsyan"

ARG JAR_FILE=./gateway-*.jar
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]