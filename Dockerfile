FROM openjdk:8-alpine

RUN mkdir /app
COPY target/*.jar /app

WORKDIR /app

CMD ["java", "-jar", "party_planner-0.7.1-SNAPSHOT.jar"]