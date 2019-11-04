#!/bin/sh

## java env
export JAVA_HOME=/opt/jdk1.8.0_171
export JRE_HOME=$JAVA_HOME/jre

#服务目录
SERVICE_DIR=/opt/datacenter/v1.0

## service name list 注册中心

SERVICE_NAME=datacenter-cloud-eureka-1.0-SNAPSHOT
JAR_NAME=$SERVICE_NAME\.jar
PID=$SERVICE_NAME\.pid
##coonfig 配置中心

SERVICE_NAME32=datacenter-config-server-1.0-SNAPSHOT
JAR_NAME32=$SERVICE_NAME32\.jar
PID32=$SERVICE_NAME32\.pid

##1-10 提供者
SERVICE_NAME1=datacenter-provider-order-1.0-SNAPSHOT
JAR_NAME1=$SERVICE_NAME1\.jar
PID1=$SERVICE_NAME1\.pid
##2
SERVICE_NAME2=datacenter-provider-core-1.0-SNAPSHOT
JAR_NAME2=$SERVICE_NAME2\.jar
PID2=$SERVICE_NAME2\.pid

##3
SERVICE_NAME3=datacenter-provider-analysis-1.0-SNAPSHOT
JAR_NAME3=$SERVICE_NAME3\.jar
PID3=$SERVICE_NAME3\.pid

##4
SERVICE_NAME4=datacenter-provider-api-1.0-SNAPSHOT
JAR_NAME4=$SERVICE_NAME4\.jar
PID4=$SERVICE_NAME4\.pid

##5
SERVICE_NAME5=datacenter-provider-api-manager-1.0-SNAPSHOT
JAR_NAME5=$SERVICE_NAME5\.jar
PID5=$SERVICE_NAME5\.pid

##6
SERVICE_NAME6=datacenter-provider-message-1.0-SNAPSHOT
JAR_NAME6=$SERVICE_NAME6\.jar
PID6=$SERVICE_NAME6\.pid

##7
SERVICE_NAME7=datacenter-sys-provider-1.0-SNAPSHOT
JAR_NAME7=$SERVICE_NAME7\.jar
PID7=$SERVICE_NAME7\.pid

##8
SERVICE_NAME8=datacenter-plug-cache-1.0-SNAPSHOT
JAR_NAME8=$SERVICE_NAME8\.jar
PID8=$SERVICE_NAME8\.pid


##30   #路由 消费和相关，提供者请放在最上面
SERVICE_NAME30=datacenter-cloud-zuul-gateway-1.0-SNAPSHOT
JAR_NAME30=$SERVICE_NAME30\.jar
PID30=$SERVICE_NAME30\.pid

#31
SERVICE_NAME31=datacenter-cloud-consumer-1.0-SNAPSHOT
JAR_NAME31=$SERVICE_NAME31\.jar
PID31=$SERVICE_NAME31\.pid


#######








cd $SERVICE_DIR

case "$1" in

    start)
        nohup $JRE_HOME/bin/java -Xms512m -Xmx1024m -jar $JAR_NAME >/dev/null 2>&1 &
        echo $! > $SERVICE_DIR/$PID
        echo "=== start $SERVICE_NAME"

	sleep 5

	nohup $JRE_HOME/bin/java -Xms512m -Xmx1024m -jar $JAR_NAME32 >/dev/null 2>&1 &
        echo $! > $SERVICE_DIR/$PID32
        echo "=== start $SERVICE_NAME32"

	sleep 120


	nohup $JRE_HOME/bin/java -Xms512m -Xmx1024m -jar $JAR_NAME1 >/dev/null 2>&1 &
        echo $! > $SERVICE_DIR/$PID1
        echo "=== start $SERVICE_NAME1"

	sleep 3


	nohup $JRE_HOME/bin/java -Xms512m -Xmx1024m -jar $JAR_NAME2 >/dev/null 2>&1 &
        echo $! > $SERVICE_DIR/$PID2
        echo "=== start $SERVICE_NAME2"

	sleep 1


	nohup $JRE_HOME/bin/java -Xms512m -Xmx1024m -jar $JAR_NAME3 >/dev/null 2>&1 &
        echo $! > $SERVICE_DIR/$PID3
        echo "=== start $SERVICE_NAME3"

	sleep 1

	nohup $JRE_HOME/bin/java -Xms512m -Xmx1024m -jar $JAR_NAME4 >/dev/null 2>&1 &
        echo $! > $SERVICE_DIR/$PID4
        echo "=== start $SERVICE_NAME4"

	sleep 1

	nohup $JRE_HOME/bin/java -Xms512m -Xmx1024m -jar $JAR_NAME5 >/dev/null 2>&1 &
        echo $! > $SERVICE_DIR/$PID5
        echo "=== start $SERVICE_NAME5"

	sleep 1

	nohup $JRE_HOME/bin/java -Xms512m -Xmx1024m -jar $JAR_NAME6 >/dev/null 2>&1 &
        echo $! > $SERVICE_DIR/$PID6
        echo "=== start $SERVICE_NAME6"

	sleep 1

	nohup $JRE_HOME/bin/java -Xms512m -Xmx1024m -jar $JAR_NAME7 >/dev/null 2>&1 &
        echo $! > $SERVICE_DIR/$PID7
        echo "=== start $SERVICE_NAME7"

	sleep 1

	nohup $JRE_HOME/bin/java -Xms512m -Xmx1024m -jar $JAR_NAME8 >/dev/null 2>&1 &
        echo $! > $SERVICE_DIR/$PID8
        echo "=== start $SERVICE_NAME8"

	sleep 1

	nohup $JRE_HOME/bin/java -Xms512m -Xmx1024m -jar $JAR_NAME30 >/dev/null 2>&1 &
        echo $! > $SERVICE_DIR/$PID30
        echo "=== start $SERVICE_NAME30"

	sleep 5

	nohup $JRE_HOME/bin/java -Xms512m -Xmx1024m -jar $JAR_NAME31 >/dev/null 2>&1 &
        echo $! > $SERVICE_DIR/$PID31
        echo "=== start $SERVICE_NAME31"

        ;;

    stop)
        kill `cat $SERVICE_DIR/$PID`
        rm -rf $SERVICE_DIR/$PID
        echo "=== stop $SERVICE_NAME"

        sleep 5
		##
		## boss-service-aa.jar
		## boss-service-aa-bb.jar
        P_ID=`ps -ef | grep -w "$SERVICE_NAME" | grep -v "grep" | awk '{print $2}'`
        if [ "$P_ID" == "" ]; then
            echo "=== $SERVICE_NAME process not exists or stop success"
        else
            echo "=== $SERVICE_NAME process pid is:$P_ID"
            echo "=== begin kill $SERVICE_NAME process, pid is:$P_ID"
            kill -9 $P_ID
        fi

	##

	kill `cat $SERVICE_DIR/$PID1`
        rm -rf $SERVICE_DIR/$PID1
        echo "=== stop $SERVICE_NAME1"

        sleep 5

        P_ID=`ps -ef | grep -w "$SERVICE_NAME1" | grep -v "grep" | awk '{print $2}'`
        if [ "$P_ID" == "" ]; then
            echo "=== $SERVICE_NAME1 process not exists or stop success"
        else
            echo "=== $SERVICE_NAME1 process pid is:$P_ID"
            echo "=== begin kill $SERVICE_NAME1 process, pid is:$P_ID"
            kill -9 $P_ID
        fi

	##

	kill `cat $SERVICE_DIR/$PID2`
        rm -rf $SERVICE_DIR/$PID2
        echo "=== stop $SERVICE_NAME2"

        sleep 5

        P_ID=`ps -ef | grep -w "$SERVICE_NAME2" | grep -v "grep" | awk '{print $2}'`
        if [ "$P_ID" == "" ]; then
            echo "=== $SERVICE_NAME2 process not exists or stop success"
        else
            echo "=== $SERVICE_NAME2 process pid is:$P_ID"
            echo "=== begin kill $SERVICE_NAME2 process, pid is:$P_ID"
            kill -9 $P_ID
        fi
	##

	kill `cat $SERVICE_DIR/$PID3`
        rm -rf $SERVICE_DIR/$PID3
        echo "=== stop $SERVICE_NAME3"

        sleep 5

        P_ID=`ps -ef | grep -w "$SERVICE_NAME3" | grep -v "grep" | awk '{print $2}'`
        if [ "$P_ID" == "" ]; then
            echo "=== $SERVICE_NAME3 process not exists or stop success"
        else
            echo "=== $SERVICE_NAME3 process pid is:$P_ID"
            echo "=== begin kill $SERVICE_NAME3 process, pid is:$P_ID"
            kill -9 $P_ID
        fi
	##
	kill `cat $SERVICE_DIR/$PID4`
        rm -rf $SERVICE_DIR/$PID4
        echo "=== stop $SERVICE_NAME4"

        sleep 5

        P_ID=`ps -ef | grep -w "$SERVICE_NAME4" | grep -v "grep" | awk '{print $2}'`
        if [ "$P_ID" == "" ]; then
            echo "=== $SERVICE_NAME4 process not exists or stop success"
        else
            echo "=== $SERVICE_NAME4 process pid is:$P_ID"
            echo "=== begin kill $SERVICE_NAME4 process, pid is:$P_ID"
            kill -9 $P_ID
        fi
	##

	kill `cat $SERVICE_DIR/$PID5`
        rm -rf $SERVICE_DIR/$PID5
        echo "=== stop $SERVICE_NAME5"

        sleep 5

        P_ID=`ps -ef | grep -w "$SERVICE_NAME5" | grep -v "grep" | awk '{print $2}'`
        if [ "$P_ID" == "" ]; then
            echo "=== $SERVICE_NAME5 process not exists or stop success"
        else
            echo "=== $SERVICE_NAME5 process pid is:$P_ID"
            echo "=== begin kill $SERVICE_NAME5 process, pid is:$P_ID"
            kill -9 $P_ID
        fi
	##

	kill `cat $SERVICE_DIR/$PID6`
        rm -rf $SERVICE_DIR/$PID6
        echo "=== stop $SERVICE_NAME6"

        sleep 5

        P_ID=`ps -ef | grep -w "$SERVICE_NAME6" | grep -v "grep" | awk '{print $2}'`
        if [ "$P_ID" == "" ]; then
            echo "=== $SERVICE_NAME6 process not exists or stop success"
        else
            echo "=== $SERVICE_NAME6 process pid is:$P_ID"
            echo "=== begin kill $SERVICE_NAME6 process, pid is:$P_ID"
            kill -9 $P_ID
        fi
	##

	kill `cat $SERVICE_DIR/$PID7`
        rm -rf $SERVICE_DIR/$PID7
        echo "=== stop $SERVICE_NAME7"

        sleep 5

        P_ID=`ps -ef | grep -w "$SERVICE_NAME7" | grep -v "grep" | awk '{print $2}'`
        if [ "$P_ID" == "" ]; then
            echo "=== $SERVICE_NAME7 process not exists or stop success"
        else
            echo "=== $SERVICE_NAME7 process pid is:$P_ID"
            echo "=== begin kill $SERVICE_NAME7 process, pid is:$P_ID"
            kill -9 $P_ID
        fi
	##

	kill `cat $SERVICE_DIR/$PID8`
        rm -rf $SERVICE_DIR/$PID8
        echo "=== stop $SERVICE_NAME8"

        sleep 5

        P_ID=`ps -ef | grep -w "$SERVICE_NAME8" | grep -v "grep" | awk '{print $2}'`
        if [ "$P_ID" == "" ]; then
            echo "=== $SERVICE_NAME8 process not exists or stop success"
        else
            echo "=== $SERVICE_NAME8 process pid is:$P_ID"
            echo "=== begin kill $SERVICE_NAME8 process, pid is:$P_ID"
            kill -9 $P_ID
        fi
	##

	kill `cat $SERVICE_DIR/$PID30`
        rm -rf $SERVICE_DIR/$PID30
        echo "=== stop $SERVICE_NAME30"

        sleep 5

        P_ID=`ps -ef | grep -w "$SERVICE_NAME30" | grep -v "grep" | awk '{print $2}'`
        if [ "$P_ID" == "" ]; then
            echo "=== $SERVICE_NAME30 process not exists or stop success"
        else
            echo "=== $SERVICE_NAME30 process pid is:$P_ID"
            echo "=== begin kill $SERVICE_NAME30 process, pid is:$P_ID"
            kill -9 $P_ID
        fi
	##

	kill `cat $SERVICE_DIR/$PID31`
        rm -rf $SERVICE_DIR/$PID31
        echo "=== stop $SERVICE_NAME31"

        sleep 5

        P_ID=`ps -ef | grep -w "$SERVICE_NAME31" | grep -v "grep" | awk '{print $2}'`
        if [ "$P_ID" == "" ]; then
            echo "=== $SERVICE_NAME31 process not exists or stop success"
        else
            echo "=== $SERVICE_NAME31 process pid is:$P_ID"
            echo "=== begin kill $SERVICE_NAME31 process, pid is:$P_ID"
            kill -9 $P_ID
        fi
	##

	kill `cat $SERVICE_DIR/$PID32`
        rm -rf $SERVICE_DIR/$PID32
        echo "=== stop $SERVICE_NAME32"

        sleep 5

        P_ID=`ps -ef | grep -w "$SERVICE_NAME32" | grep -v "grep" | awk '{print $2}'`
        if [ "$P_ID" == "" ]; then
            echo "=== $SERVICE_NAME32 process not exists or stop success"
        else
            echo "=== $SERVICE_NAME32 process pid is:$P_ID"
            echo "=== begin kill $SERVICE_NAME32 process, pid is:$P_ID"
            kill -9 $P_ID
        fi

        ;;

    restart)
        $0 stop
        sleep 2
        $0 start
        echo "=== restart $SERVICE_NAME"
        ;;

    *)
        ## restart
        $0 stop
        sleep 2
        $0 start
        ;;

esac
exit 0

