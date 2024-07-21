#Image de base
FROM openjdk:22-slim

MAINTAINER it4innov.fr

ARG VERSION

USER root
RUN apt-get update && \
    apt-get install -y bash && \
    addgroup myasso && \
    useradd myasso --home /home/myasso/ --create-home -g myasso --shell /bin/bash && \
    chmod -R 755 /home/myasso \

USER myasso
WORKDIR /home/myasso

COPY myasso-association-service-${VERSION}.jar myasso-association-service.jar

#Executer l'application
ENTRYPOINT ["java", "-jar", "/home/myasso/myasso-association-service.jar"]


