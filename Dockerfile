FROM maven:amazoncorretto as build1
WORKDIR /app
COPY --from=build1 ./war-web-project .
RUN mvn clean install

FROM adhig93/tomcat-conf
COPY --from=build1 /app/target/*.war /usr/local/tomcat/webapps/
