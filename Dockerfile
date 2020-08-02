FROM openjdk:8-alpine

RUN mkdir /app
RUN mkdir /app/libs
COPY target/*.jar /app
COPY target/libs /app/libs

WORKDIR /app

CMD ["java", "-jar", "party_planner-0.7.1-SNAPSHOT.jar"]