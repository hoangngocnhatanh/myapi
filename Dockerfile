# Maven build container
#FROM maven:3.5.2-jdk-8-alpine AS maven_build
FROM maven:3.6.2-jdk-8 AS maven_build
WORKDIR /tmp/
COPY pom.xml /tmp/
RUN mvn dependency:go-offline
COPY src /tmp/src/
COPY glowroot /tmp/glowroot/
RUN mvn package

#pull base image
FROM openjdk:8u242-jdk-slim
EXPOSE 80
COPY --from=maven_build /tmp/glowroot/ ./glowroot/
ENTRYPOINT [ "sh", "-c", "java -jar /app.jar" ]
COPY --from=maven_build /tmp/target/*.jar /app.jar