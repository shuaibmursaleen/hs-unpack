FROM eclipse-temurin:21-jdk-alpine
VOLUME /tmp
COPY target/hscodes-0.0.1-SNAPSHOT.jar hs-unpack.jar
ENTRYPOINT ["java","-jar","/hs-unpack.jar"]