FROM openjdk:11
EXPOSE 8086
ADD target/analytics-server.jar analytics-server
ENTRYPOINT ["java","-jar","/analytics-server"]