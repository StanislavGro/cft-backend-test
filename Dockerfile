FROM openjdk:8-jdk-alpine
COPY target/electronic-store-0.0.1-SNAPSHOT.jar electronic-store.jar
ENTRYPOINT ["java","-jar","electronic-store.jar"]