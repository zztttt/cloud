#! /bin/bash
#echo "run redis"
#docker run -d -p 6380:6379 --name=redis redis:latest
#
#echo "run mysql-master"
#docker run -d -p 3300:3306 --name=mysql-master -e MYSQL_ROOT_PASSWORD=123456 mysql:5.7
#
#echo "run mysql-slave1"
#docker run -d -p 3301:3306 --name=mysql-slave1 -e MYSQL_ROOT_PASSWORD=123456 mysql:5.7
#
#echo "run mysql-slave2"
#docker run -d -p 3302:3306 --name=mysql-slave2 -e MYSQL_ROOT_PASSWORD=123456 mysql:5.7
#
#sleep 10s

echo "run eureka"
docker run --name=eureka -d -p 8761:8761 eureka:latest

sleep 10s

echo "run app at port 8001"
docker run --net=host -e "SERVER_PORT=8001" --name=app1 -d -p 8001:8001 app:latest

echo "run app at port 8002"
docker run --net=host -e "SERVER_PORT=8002" --name=app2 -d -p 8002:8002 app:latest

echo "run app at port 8003"
docker run --net=host -e "SERVER_PORT=8003" --name=app3 -d -p 8003:8003 app:latest

echo "run gateway at port 8080"
docker run --net=host --name=gateway -d -p 8080:8080 gateway:latest




