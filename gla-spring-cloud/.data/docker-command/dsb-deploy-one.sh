case "$1" in

dsb-eureka)
		#关闭dsb
docker stop dsb-eureka
docker rm dsb-eureka
echo 'service begin starting...'
docker run -d  -p 7001:7001 -v /opt/dsb-logs:/logs --add-host locahost:192.168.26.10  --name dsb-eureka --network host  dsb-eureka
;; 	
dsb-config)
docker stop dsb-config
docker rm dsb-config
docker run -d  -p 7006:7006 -v /opt/dsb-logs:/logs  --add-host locahost:192.168.26.10  --name dsb-config  --network host   dsb-config
;;
dsb-gateway)
docker stop dsb-gateway
docker rm dsb-gateway
docker run -d  -p 8100:8100 -v /opt/dsb-logs:/logs  --add-host locahost:192.168.26.10  --name dsb-gateway --network host dsb-gateway
;;
dsb-cache)
docker stop  dsb-cache
docker rm dsb-cache
docker run -d  -p 8300:8300  -v /opt/dsb-logs:/logs  --add-host locahost:192.168.26.10  --name dsb-cache --network host  dsb-cache
;;
dsb-analysis)
docker stop dsb-analysis
docker rm dsb-analysis
docker run -d  -p 8007:8007  -v /opt/dsb-logs:/logs --add-host locahost:192.168.26.10  --name  dsb-analysis --network host  dsb-analysis
;;
dsb-api)
docker stop dsb-api
docker rm dsb-api
docker run -d  -p 8010:8010  -v /opt/dsb-logs:/logs --add-host locahost:192.168.26.10  --name dsb-api  --network host  dsb-api
;;
dsb-api-manager)
docker stop dsb-api-manager
docker run -d  -p 8005:8005  -v /opt/dsb-logs:/logs  --add-host locahost:192.168.26.10  --name dsb-api-manager --network host  dsb-api-manager
;;
dsb-core)
docker stop dsb-core
docker rm dsb-core
docker run -d  -p 8006:8006  -v /opt/dsb-logs:/logs --add-host locahost:192.168.26.10  --name dsb-core  --network host  dsb-core
;;
dsb-mdm)
docker stop dsb-mdm
docker rm dsb-mdm
docker run -d  -p 9001:9001 -v /opt/dsb-logs:/logs  --add-host locahost:192.168.26.10  --name dsb-mdm  --network host  dsb-mdm
;;
dsb-message)
docker stop dsb-message
docker rm dsb-message
docker run -d  -p 8008:8008 -v /opt/dsb-logs:/logs  --add-host locahost:192.168.26.10  --name dsb-message --network host  dsb-message
;;
dsb-order)
docker stop dsb-order
docker rm dsb-order
docker run -d  -p 8004:8004 -v /opt/dsb-logs:/logs --add-host locahost:192.168.26.10  --name dsb-order --network host  dsb-order
;;
dsb-resource-catalog)
docker stop dsb-resource-catalog
docker rm dsb-resource-catalog
docker run -d  -p 8012:8012 -v /opt/dsb-logs:/logs  --add-host locahost:192.168.26.10  --name dsb-resource-catalog --network host  dsb-resource-catalog
;;
dsb-sys)
docker stop dsb-sys
docker rm dsb-sys
docker run -d  -p 8011:8011  -v /opt/dsb-logs:/logs --add-host locahost:192.168.26.10  --name dsb-sys --network host  dsb-sys
;;
dsb-consumer )
echo 'restart...'
docker stop dsb-consumer
docker rm  dsb-consumer
docker run -d  -p 8002:8002  -v /opt/dsb-logs:/logs --add-host locahost:192.168.26.10  --name dsb-consumer   --network host  dsb-consumer
echo 'all service stop over... '
;;
*)
echo 'input service name'
esac

