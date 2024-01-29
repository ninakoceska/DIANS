# Use a base image with OpenJDK
FROM openjdk:14

# Set the working directory in the container
WORKDIR C:/Users/Asus/Desktop/DIANS-main/DOMASNA3/backend

# Copy the JAR file into the container
COPY . .

# Expose the port your backend app runs on
EXPOSE 8080

# Command to run your Java application
CMD ["java", "-jar", "maven-wrapper.jar"]
