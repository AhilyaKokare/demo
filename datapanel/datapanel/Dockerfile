# Step 1: Use Maven with Java 17 to build the project
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

# Copy only the wrapper and pom.xml first (to cache dependencies)
COPY mvnw mvnw
COPY .mvn .mvn
COPY pom.xml .

# Make wrapper executable and resolve dependencies
RUN chmod +x mvnw
RUN ./mvnw dependency:resolve

# Copy the rest of the project files
COPY src ./src

# Build the Spring Boot app
RUN ./mvnw clean package -DskipTests

# Step 2: Use a smaller runtime image for deployment
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copy the built JAR from the previous stage
COPY --from=build /app/target/*.jar app.jar

# Expose port 8080
EXPOSE 8080

# Run the JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
