FROM openjdk:8-jdk-alpine

MAINTAINER Antonio Martin

EXPOSE 8080

COPY build/libs/lib/*.jar build/libs/*.jar /usr/local/friends/

WORKDIR /usr/local/friends

CMD java -Xmx512m -cp "*" org.springframework.boot.loader.JarLauncher
