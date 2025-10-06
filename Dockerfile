# Use a lightweight base image
FROM openjdk:24-jdk-slim

# Metadata
LABEL maintainer="SecInfra-Automation-Labs" \
      description="Spring Boot Docker image"

# Working directory
WORKDIR /app

# Copy built JAR
COPY target/*.jar app.jar

# Optional: install debugging tools
RUN apt update && apt install -y --no-install-recommends curl net-tools && apt clean

# Expose Spring Boot port
EXPOSE 8080

# Default environment
ENV SERVER_PORT=8080
ENV SERVER_ADDRESS=0.0.0.0

# Start the app
ENTRYPOINT ["java", "-jar", "app.jar"]
