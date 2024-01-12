From openjdk:8
EXPOSE 8083
ADD target/SpringAngularConnection-0.0.1-SNAPSHOT.war  SpringAngularConnection-0.0.1-SNAPSHOT.war
ENTRYPOINT [ "java","-jar","/SpringAngularConnection-0.0.1-SNAPSHOT.war" ]

