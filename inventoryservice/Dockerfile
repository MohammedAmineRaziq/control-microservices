FROM openjdk:17-alpine
EXPOSE 8082
ADD target/inventory-server.jar inventory-server
ENTRYPOINT ["java","-jar","/inventory-server"]