FROM openjdk:8-alpine

RUN mkdir -p /opt/app
RUN mkdir -p /opt/app/data/db

ENV PROJECT_HOME /opt/app
WORKDIR $PROJECT_HOME

COPY web.jar $PROJECT_HOME/web.jar

CMD ["java", "-jar","./web.jar"]


