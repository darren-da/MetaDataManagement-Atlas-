# Dockerfile
# 基于的镜像
FROM openjdk:8-jdk-alpine

VOLUME /opt/tmp

ADD datacenter-cloud-eureka-1.0-SNAPSHOT.jar app.jar

# -Djava.security.egd=file:/dev/./urandom 可解决tomcat可能启动慢的问题
# 具体可查看：https://www.cnblogs.com/mightyvincent/p/7685310.html
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]


# 对外端口
EXPOSE 7001