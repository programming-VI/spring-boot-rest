FROM openjdk:11
RUN mkdir -p /app
#COPY ./build/libs /app
COPY *.jar /app
WORKDIR /app
ENTRYPOINT ["java","-jar","spring-boot-rest-0.0.1-SNAPSHOT.jar"]

