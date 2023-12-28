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
- Đăng nhập keycloack
![1](img_guide/1.png)
- Tạo realm:
![2](img_guide/2.png)
- Tạo client với tên : spring-cloud-client
  ![2](img_guide/3.png)
- Setting client như sau:
  ![2](img_guide/4.png)
- Sau khi save setting client. Tại tab Credentials, copy giá trị secret: zF3mUlEVRk7FFIocet3py6u98R3TxGAi
  ![2](img_guide/5.png)
- Tại Realme settings, Tại mục endPoints, bấm vào link OpenID Endpoint Configuration
  ![2](img_guide/7.png)
- Copy giá trị issuer paste vào applications.properties của api-gateway
  ![2](img_guide/8.png)
```java
    spring.security.oauth2.resourceserver.jwt.issuer-uri=http://localhost:8181/realms/springboot-microservices-full-realm
```

- Test Authen của api:
   + Gọi api get all product thông qua api gateway:
     ![2](img_guide/9.png)
     Trong hình trên thì giá trị của accces-token-url là : http://localhost:8181/realms/springboot-microservices-full-realm/protocol/openid-connect/token
   +  Authen thành công:
      ![2](img_guide/10.png)
      ( Lưu ý : Khi bị Unauthorized(sau 300ms) thì bấm vào "Get new acccess token" Rồi sau đó "Use token" để refresh lại access_token để dùng lại )
   +  Một ví dụ khác, TEST api Create Order thông qua api-gateway
        + Trường hợp ko dùng authen:
          ![2](img_guide/11.png)
        +  Khi authen token, tạo order thành công:
           ![2](img_guide/12.png)