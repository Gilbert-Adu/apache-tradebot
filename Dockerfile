FROM openjdk:11-jdk AS build

WORKDIR /app

COPY gradlew /app/
COPY gradle /app/gradle
COPY build.gradle /app/
COPY settings.gradle /app/

RUN ./gradlew dependencies

COPY src /app/src

RUN ./gradlew build

FROM openjdk:17-jre

WORKDIR /app

COPY --from=build /app/build/libs/your-app.jar /app/your-app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/your-app.jar"]
