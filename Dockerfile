FROM openjdk:11
EXPOSE 8089
COPY target/tpAchatProjectnv-1.0.jar tpAchatProjectnv.jar
ENTRYPOINT ["java","-jar","/tpAchatProject.jar"]