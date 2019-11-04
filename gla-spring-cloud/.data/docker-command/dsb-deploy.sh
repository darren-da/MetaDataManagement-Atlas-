#关闭删除
#关闭dsb
docker stop dsb-eureka
docker rm dsb-eureka

docker stop dsb-config
docker rm dsb-config

docker stop dsb-gateway
docker rm dsb-gateway

docker stop  dsb-cache
docker rm dsb-cache

docker stop dsb-analysis
docker rm dsb-analysis

docker stop dsb-api
docker rm dsb-api

docker stop dsb-api-manager
docker rm dsb-api-manager

docker stop dsb-core
docker rm dsb-core

docker stop dsb-mdm
docker rm dsb-mdm

docker stop dsb-message
docker rm dsb-message

docker stop dsb-order
docker rm dsb-order

docker stop dsb-resource-catalog
docker rm dsb-resource-catalog

docker stop dsb-resource-catalog
docker rm dsb-resource-catalog

docker stop dsb-sys
docker rm dsb-sys

docker stop dsb-consumer
docker rm  dsb-consumer
echo 'all service stop over... '



echo 'service begin starting...'

docker run -d  -p 7001:7001 -v /opt/dsb-logs:/logs --add-host locahost:192.168.26.10  --name dsb-eureka --network host  dsb-eureka

sleep 35

docker run -d  -p 7006:7006 -v /opt/dsb-logs:/logs  --add-host locahost:192.168.26.10  --name dsb-config  --network host   dsb-config

sleep 120

docker run -d  -p 8100:8100 -v /opt/dsb-logs:/logs  --add-host locahost:192.168.26.10  --name dsb-gateway --network host dsb-gateway

sleep 35

docker run -d  -p 8300:8300  -v /opt/dsb-logs:/logs  --add-host locahost:192.168.26.10  --name dsb-cache --network host  dsb-cache 

docker run -d  -p 8007:8007  -v /opt/dsb-logs:/logs --add-host locahost:192.168.26.10  --name  dsb-analysis --network host  dsb-analysis 

docker run -d  -p 8010:8010  -v /opt/dsb-logs:/logs --add-host locahost:192.168.26.10  --name dsb-api  --network host  dsb-api

docker run -d  -p 8005:8005  -v /opt/dsb-logs:/logs  --add-host locahost:192.168.26.10  --name dsb-api-manager --network host  dsb-api-manager

docker run -d  -p 8006:8006  -v /opt/dsb-logs:/logs --add-host locahost:192.168.26.10  --name dsb-core  --network host  dsb-core

docker run -d  -p 9001:9001 -v /opt/dsb-logs:/logs  --add-host locahost:192.168.26.10  --name dsb-mdm  --network host  dsb-mdm

docker run -d  -p 8008:8008 -v /opt/dsb-logs:/logs  --add-host locahost:192.168.26.10  --name dsb-message --network host  dsb-message

docker run -d  -p 8004:8004 -v /opt/dsb-logs:/logs --add-host locahost:192.168.26.10  --name dsb-order --network host  dsb-order

docker run -d  -p 8012:8012 -v /opt/dsb-logs:/logs  --add-host locahost:192.168.26.10  --name dsb-resource-catalog --network host  dsb-resource-catalog

docker run -d  -p 8011:8011  -v /opt/dsb-logs:/logs --add-host locahost:192.168.26.10  --name dsb-sys --network host  dsb-sys

docker run -d  -p 8002:8002  -v /opt/dsb-logs:/logs --add-host locahost:192.168.26.10  --name dsb-consumer   --network host  dsb-consumer

echo '启动成功:welcome...'
