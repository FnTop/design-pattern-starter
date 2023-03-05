# 环境
FROM  williamyeh/java8:latest
# 作者信息
MAINTAINER david "3120338098@qq.com"
# 将本地文件tmp挂载到容器
VOLUME /tmp
# 拷贝jar
ADD luntron-design-pattern-apply.jar /luntron-design-pattern-apply.jar
# 设置暴露的端口号
#EXPOSE 8761
# 执行命令
ENTRYPOINT ["java","-jar","/luntron-design-pattern-apply.jar"]
