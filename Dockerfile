# Stage 1: Build the project with Gradle
FROM gradle:7.6.0-jdk17 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

# Stage 2: Run the app with Java 21
FROM openjdk:21-jdk
COPY --from=build /home/gradle/src/build/libs/trading-0.0.1-SNAPSHOT.jar /app/trading.jar
ENTRYPOINT ["java", "-jar", "/app/trading.jar"]