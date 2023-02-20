FROM openjdk:17-alpine
EXPOSE 8081
ADD target/customer-server.jar customer-server.jar
ENTRYPOINT ["java","-jar","/customer-server.jar"]