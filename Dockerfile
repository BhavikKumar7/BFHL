# Use lightweight Java image
FROM eclipse-temurin:17-jdk-jammy

# Create app directory
WORKDIR /app

# Copy project files
COPY . .

# Build the jar
RUN ./mvnw -q -DskipTests package || mvn -q -DskipTests package

# Expose port
EXPOSE 8080

# Run application
CMD ["java", "-jar", "target/bfhl-api-1.0.jar"]
