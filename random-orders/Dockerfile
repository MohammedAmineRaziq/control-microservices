FROM openjdk:17-alpine
EXPOSE 8084
ADD target/randomOrder-server.jar randomOrder-server
ENTRYPOINT ["java","-jar","/randomOrder-server"]