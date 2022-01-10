FROM amazoncorretto:11-alpine-jdk
ARG JAR_FILE=*.jar
COPY target/kafka_service-0.0.1-SNAPSHOT.jar kafka_service.jar
ENTRYPOINT ["java","-jar","/kafka_service.jar"]