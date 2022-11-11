#
# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml -DskipTests=true clean package

#
# Package stage
#
FROM openjdk:11-jre-slim
COPY --from=build /home/app/target/test-task-1.0.jar /target/test-task-1.0.jar
EXPOSE 80
ENTRYPOINT ["java","-jar","/target/test-task-1.0.jar"]