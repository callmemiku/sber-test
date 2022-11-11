FROM amazoncorretto:11-alpine-jdk
MAINTAINER miku
COPY target/test-task-1.0.jar test-task-1.0.jar
ENTRYPOINT ["java","-jar", "/test-task-1.0.jar"]