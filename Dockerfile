# Use the official OpenJDK 17 image as the base image
FROM openjdk:17-jdk

# Copy the compiled Spring Boot JAR file into the container
ADD target/project.jar app.jar

# Expose the port on which your Spring Boot application runs (change the port if necessary)
EXPOSE 8080

# Define the command to run your Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
