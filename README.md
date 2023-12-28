# SPRING MICROSERVICES FULL

### 1. Part-1 : Base service
- Init base service : Product Service, Order Service, Inventory Service

### 2. Part-2 : Communicate service
### 3. Part-3 : Service Discovery
### 4. Part-4 : Api gateway
### 5. Part-5 : Security keycloak

```shell
 docker run -p 8181:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:18.0.0 start-dev
```
- Truy cập url : localhost:8181
- Đăng nhập keycloack : admin/admin
![1](img_guide/1.png)
- Tạo realm:
![2](img_guide/2.png)
- Tạo client với tên : spring-cloud-client
  ![2](img_guide/3.png)
