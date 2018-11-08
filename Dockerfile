FROM gradle:jdk11-slim as builder
COPY --chown=gradle . .
RUN gradle build

FROM openjdk:11-slim
COPY --from=builder /home/gradle/build/libs/*.jar app.jar
CMD ["java", "-jar", "app.jar"]
