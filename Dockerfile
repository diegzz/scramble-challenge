FROM openjdk:8-alpine

COPY target/uberjar/scramble-challenge.jar /scramble-challenge/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/scramble-challenge/app.jar"]
