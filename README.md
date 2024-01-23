# Lentra Assignment

Following are the steps followed to create the cluster, deploy prometheus and grafana and then finally deploy mysql and demo spring boot app as required by the assignment

Minikube on Windows has been used for K8s infrastructure as AWS Free Tier only allows t2.micro or t3.micro instance
Driver being used is HyperV as there were conflicts and tedious steps involved related to network config when Docker Deskop was used for provisioning Kubernestes cluster with multiple nodes.

- minikube version v1.32.0
- kubectl client version v1.28.2
- Kubernetes v1.28.3
- Docker 24.0.7
- Docker Desktop for Windows 4.26.1

# 1. Create Cluster

Run following commands to start k8s cluster with 3 nodes, Calico as default CNI provider, label nodes so as to deploy our application on worker nodes and start k8s Dashboard

```
docker context use default
minikube start --nodes 3 --cni calico --memory=2500
kubectl get nodes
kubectl label node minikube-m02 node-role.kubernetes.io/worker=worker
kubectl label node minikube-m03 node-role.kubernetes.io/worker=worker
kubectl label nodes minikube-m02 role=worker
kubectl label nodes minikube-m03 role=worker
minikube profile list
minikube addons enable metrics-server
minikube dashboard
```

Run following command to ensure prometheus and grafana runs well as there is a bug with PVC/PV on Minikube when used with multi-node cluster, as discussed in [this issue](https://github.com/kubernetes/minikube/issues/12360#issuecomment-1430243861)

```
minikube addons disable storage-provisioner
minikube addons disable default-storageclass
minikube addons enable volumesnapshots
minikube addons enable csi-hostpath-driver
kubectl patch storageclass csi-hostpath-sc -p '{\"metadata\": {\"annotations\":{\"storageclass.kubernetes.io/is-default-class\":\"true\"}}}'
```
