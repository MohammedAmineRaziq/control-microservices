FROM openjdk:17-alpine
EXPOSE 8083
ADD target/billing-server.jar billing-server
ENTRYPOINT ["java","-jar","/billing-server"]