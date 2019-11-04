#关闭gla-metadata-app
docker stop `docker ps -aq --filter name=gla-metadata-app`
# >/opt/docker-command/errr 2>&1
#echo $?
#ls -1 >/opt/docker-command/log
#echo $?

sleep 1

#删除容器
docker rm gla-metadata-app
#启动gla-metadata-app

docker run -d -p 9997:9997 --name gla-metadata-app gla-metadata-app

echo '启动gla-metadata-app成功，端口:9997'
