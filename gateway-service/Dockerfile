FROM openjdk:17-alpine
EXPOSE 8889
ADD target/gateway-server.jar gateway-server
ENTRYPOINT ["java","-jar","/gateway-server"]