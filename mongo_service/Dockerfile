FROM amazoncorretto:11-alpine-jdk
ARG JAR_FILE=*.jar
COPY target/mongo_service-0.0.1-SNAPSHOT.jar mongo_service.jar
ENTRYPOINT ["java","-jar","/mongo_service.jar"]