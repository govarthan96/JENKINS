FROM openjdk:17
EXPOSE 8090
ARG JAR_FILE=/var/lib/jenkins/workspace/jenkins-docker-image/target/*.jar
COPY $(JAR_FILE) demo-jenkins-docker.jar
ENTRYPOINT ["java","-jar","target/demo-jenkins-docker.jar"]