kubectl apply -f k8s-deployment.yaml

kubectl apply -f k8s-service.yaml

kubectl port-forward service/my-pdf-svc 8080:8080
