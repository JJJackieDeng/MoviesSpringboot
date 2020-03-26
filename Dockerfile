# 指定基础镜像
FROM openjdk:8-jre-alpine
# 重命名
ADD *.jar movie-backend.jar
# 对外暴露端口号
EXPOSE 8081
# 运行
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/movie-backend.jar"]
