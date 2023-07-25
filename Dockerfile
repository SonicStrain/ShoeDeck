# Use the official OpenJDK 17 image as the base image
FROM openjdk:17-jdk

# Set the working directory inside the container
WORKDIR /app

# Copy the compiled Spring Boot JAR file into the container
COPY target/project.jar app.jar

# Expose the port on which your Spring Boot application runs (change the port if necessary)
EXPOSE 80

# Define the command to run your Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
