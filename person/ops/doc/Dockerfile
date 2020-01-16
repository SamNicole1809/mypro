FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG person
COPY person.war app.war
ENTRYPOINT ["java","-Djava.security.egdod=file:/dev/./urandom","-jar","/app.war"]