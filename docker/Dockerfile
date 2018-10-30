FROM openjdk:8-alpine

RUN apk update && apk add bash
RUN apk update && apk add curl
RUN mkdir -p /opt/app
RUN mkdir -p /opt/app/data/db

ENV PROJECT_HOME /opt/app
WORKDIR $PROJECT_HOME

COPY florence-backend-0.1.jar $PROJECT_HOME/web.jar

CMD ["java", "-jar","./web.jar"]