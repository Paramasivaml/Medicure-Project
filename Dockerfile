FROM openjdk:11-jdk

WORKDIR /app

COPY target/medicure-0.0.1-SNAPSHOT.jar /app/medicure-app.jar

EXPOSE 8080

CMD ["java", "-jar", "medicure-app.jar"]
