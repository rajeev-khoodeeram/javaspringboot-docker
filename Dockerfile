# Use official OpenJDK base image
FROM openjdk:24-jdk-slim

# Set environment variables
ENV APP_HOME=/app
WORKDIR $APP_HOME

# Copy the JAR file into the container (adjust path as needed)
COPY target/*.jar app.jar

# Expose port (change to your Spring Boot server.port if needed)
EXPOSE 8080

# Run the Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]
