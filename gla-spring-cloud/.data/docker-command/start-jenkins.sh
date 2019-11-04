#关闭gla-jenkins
docker stop `docker ps -aq --filter name=gla-jenkins`
# >/opt/docker-command/errr 2>&1
#echo $?
#ls -1 >/opt/docker-command/log
#echo $?

sleep 1

#启动gla-jenkins

docker start  gla-jenkins 

echo '启动jenkins成功，端口:8080'
