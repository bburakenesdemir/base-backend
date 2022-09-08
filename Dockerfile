FROM eclipse-temurin:18.0.2.1_1-jdk-focal as builder
RUN mkdir -p /app/source
COPY . /app/source
WORKDIR /app/source
RUN ./gradlew clean build -x test

FROM builder
COPY --from=builder /app/source/build/libs/*.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]