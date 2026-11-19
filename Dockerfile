# ---------- Stage 1: Build ----------
# Maven + JDK 21 bauen das JAR (Tests laufen schon in der Pipeline, darum -DskipTests)
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app

# Zuerst nur pom.xml kopieren -> Dependencies werden als eigener Layer gecacht
COPY pom.xml .
RUN mvn -B -q dependency:go-offline

# Dann den Quellcode kopieren und das JAR bauen
COPY src ./src
RUN mvn -B -q package -DskipTests

# ---------- Stage 2: Runtime ----------
# Schlankes Image nur mit JRE (kein Maven, kein Quellcode)
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# App nicht als root laufen lassen
RUN addgroup -S spring && adduser -S spring -G spring
USER spring

COPY --from=build /app/target/app-refcard-01-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
