FROM eclipse-temurin:21-jdk
LABEL maintainer="SivaReddy"
WORKDIR /app
COPY target/customerInfo.jar app.jar
EXPOSE 9095
ENTRYPOINT ["java","-jar","app.jar"]