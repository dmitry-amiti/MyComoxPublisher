#
# Build stage
#
FROM maven:3.3.9-jdk-8 AS build
COPY . .
RUN mvn package -DskipTests

#
# Package stage
#
FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/mycomox-publisher-1.0.jar demo.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","demo.jar"]
