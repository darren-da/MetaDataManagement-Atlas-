#启动plug-6379
#docker pull redis:4.0.6   #下载redis
docker stop plug-redis
docker rm plug-redis

docker run -d  --name  plug-redis  -p 6379:6379 -v /opt/data:/data  redis:4.0.6  --requirepass "datacenter"
echo '启动redis成功，端口:6379'
