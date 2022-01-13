FROM openjdk:17

MAINTAINER Heinz Schlömer <heinz.schloemer@gmx.net>

ADD backend/target/backend-0.0.1-SNAPSHOT.jar backend.jar

CMD ["sh", "-c", "java -jar /backend.jar"]