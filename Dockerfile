FROM openjdk:17
EXPOSE 8090
ARG JAR_FILE=target/*.jar
COPY $(JAR_FILE) demo-jenkins-docker.jar
ENTRYPOINT ["java","-jar","/demo-jenkins-docker.jar"]