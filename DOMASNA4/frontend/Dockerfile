# Use a base image with your preferred runtime
FROM node:20.11.0

# Set the working directory in the container
WORKDIR /app/frontend

# Install Angular CLI globally
RUN npm install -g @angular/cli

# Copy package.json and package-lock.json to install dependencies
COPY package*.json ./

# Install app dependencies
RUN npm install

# Copy the rest of the application code
COPY . .

# Expose the port your app runs on
EXPOSE 3000

# Command to run your application
CMD ["npm", "start"]
