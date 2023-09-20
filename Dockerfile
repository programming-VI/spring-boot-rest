FROM openjdk:11
COPY ./build/libs /app
WORKDIR /app
ENTRYPOINT ["java","-jar","spring-boot-rest-0.0.1-SNAPSHOT.jar"]

