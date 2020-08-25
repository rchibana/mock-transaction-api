FROM openjdk:8
WORKDIR /opt/application

ARG PROFILE

ENV PROFILE=${PROFILE}

EXPOSE 8080
COPY build/libs/mock-transaction-api-*.jar mock-transaction-api.jar

CMD java -jar mock-transaction-api.jar --spring.profiles.active=${PROFILE}
