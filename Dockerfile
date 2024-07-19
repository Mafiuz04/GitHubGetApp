FROM amazoncorretto:21-alpine-jdk
COPY target/DepoGet-0.0.1-SNAPSHOT.jar DepoGet-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/DepoGet-0.0.1-SNAPSHOT.jar"]