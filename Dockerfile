FROM gradle:8-jdk21
WORKDIR /app
COPY . .
RUN gradle build -x test
EXPOSE 8080
CMD ["java", "-jar", "build/libs/wealth-tracker-0.0.1-SNAPSHOT.jar"]
