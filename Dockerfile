From openjdk:8
EXPOSE 8083
ADD target/Springawsdemo-0.0.1-SNAPSHOT.war  Springawsdemo-0.0.1-SNAPSHOT.war
ENTRYPOINT [ "java","-jar","/Springawsdemo-0.0.1-SNAPSHOT.war" ]

