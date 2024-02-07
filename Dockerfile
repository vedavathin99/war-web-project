FROM ubuntu as build1
RUN apt update -y && apt install git -y


FROM maven:amazoncorretto as build2
WORKDIR /app
COPY --from=build1 ./war-web-project .
RUN mvn clean install

FROM adhig93/tomcat-conf
COPY --from=build2 /app/target/*.war /usr/local/tomcat/webapps/

