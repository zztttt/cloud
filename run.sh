#! /bin/bash
echo "run eureka"
docker run -d -p 8761:8761 eureka:latest

sleep 10s

echo "run app at port 8001"
docker run --net=host -e "SERVER_PORT=8001" -d -p 8001:8001 app:latest

echo "run app at port 8002"
docker run --net=host -e "SERVER_PORT=8002" -d -p 8002:8002 app:latest

echo "run app at port 8003"
docker run --net=host -e "SERVER_PORT=8003" -d -p 8003:8003 app:latest

echo "run gateway at port 8080"
docker run --net=host -d -p 8080:8080 gateway:latest




