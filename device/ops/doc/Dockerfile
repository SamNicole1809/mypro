FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG device
COPY device.war app.war
ENTRYPOINT ["java","-Djava.security.egdod=file:/dev/./urandom","-jar","/app.war"]