FROM openjdk:17-jdk

WORKDIR /app

COPY target/comicbooks-0.0.1-SNAPSHOT.jar /app/character-app.jar

EXPOSE 8080

CMD ["java", "-jar", "character-app.jar"]