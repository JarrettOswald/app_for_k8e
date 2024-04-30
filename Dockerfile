FROM openjdk:17.0.1-jdk-slim
COPY /target/app-*.jar /usr/local/lib/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/app.jar"]