#! /bin/bash
echo "pull redis:latest"
docker pull redis:latest

echo "pull mysql:5.7"
docker pull mysql:5.7

echo "build eureka"
docker build -f eureka.Dockerfile -t eureka:latest .

echo "build app"
docker build -f app.Dockerfile -t app:latest .

echo "build gateway"
docker build -f gateway.Dockerfile -t gateway:latest .
