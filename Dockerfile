# Use lightweight Java 17 image
FROM eclipse-temurin:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy project files
COPY . .

# Build the JAR (skip tests for speed)
RUN ./mvnw clean package -DskipTests

# Expose port (Render will inject PORT automatically)
EXPOSE 8082

# Run the built JAR
ENTRYPOINT ["java", "-jar", "target/contact-service-0.0.1-SNAPSHOT.jar"]
