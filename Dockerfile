# Use official OpenJDK image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy Maven wrapper and project files
COPY . .

# Make mvnw executable
RUN chmod +x mvnw

# Build the application
RUN ./mvnw clean package -DskipTests

# Set environment variable for dynamic port (Render sets PORT)
ENV PORT 8080

# Expose the port
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "target/SamsTrack-0.0.1-SNAPSHOT.jar"]
