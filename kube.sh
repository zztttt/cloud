kubectl delete svc eureka
kubectl delete deployment eureka

kubectl create deployment eureka --image=docker.io/zztttt/eureka:latest --port=8761
kubectl expose deployment eureka --type=LoadBalancer --port=8761 --target-port=8761
