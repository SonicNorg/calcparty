FROM openjdk:8-alpine

RUN mkdir /app
RUN mkdir /app/libs
COPY target/*.jar /app
COPY target/libs /app/libs
# cannot find resources without it
COPY src /src

WORKDIR /

CMD ["java", "-Dfile.encoding=UTF-8", "-jar", "/app/party_planner-0.7.1-SNAPSHOT.jar"]