FROM gradle:8-jdk21 AS build
WORKDIR /app
COPY . .
RUN gradle build -x test --no-daemon -Dorg.gradle.jvmargs="-Xmx256m"

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/build/libs/wealth-tracker-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
