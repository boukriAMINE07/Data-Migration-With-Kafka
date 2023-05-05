FROM khipu/openjdk17-alpine

# Set the working directory to /app
WORKDIR /app

# Copy the application jar file to the container
COPY target/*.jar secondecommerce.jar

# Expose port 8082 for the container
EXPOSE 8082
# Run the jar file when the container launches
ENTRYPOINT ["java", "-jar", "secondecommerce.jar"]