FROM openjdk:17-alpine
EXPOSE 8080
WORKDIR /usr/src
ADD target/spring.jar /usr/src/spring.jar
ENTRYPOINT ["java", "-jar", "/usr/src/spring.jar"]
