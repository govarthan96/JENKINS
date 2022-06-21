FROM openjdk:17
EXPOSE 8090
ADD target/demo-jenkins-docker.jar demo-jenkins-docker.jar
ENTRYPOINT ["java","-jar","/demo-jenkins-docker.jar"]