FROM openjdk:17
EXPOSE 8080
ADD target/reactive_webflux_services-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
