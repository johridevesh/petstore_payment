# Use Amazon Corretto 17 as the base image
FROM amazoncorretto:17

# Install shadow-utils and clean up cache
RUN yum install -y shadow-utils \
    && yum clean all \
    && useradd -m non_root_user

# Switch to the newly created non-root user
USER non_root_user

# Define /tmp as a volume
VOLUME /tmp

# Copy the application JAR file into the container
COPY target/*.jar app.jar

# Set the entry point to run the Java application
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]