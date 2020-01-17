## 模块说明 

+ `eureka_demo`: 服务注册中心
+ `eureka_client_provide_demo`： 服务提供者（注册到`eureka`）
+ `eureka_client_comsumer_demo`：服务消费者（注册到`eureka`,其中包含`feign`，`hystrix`）
+ `zuul_demo`：路由 
  + 配置了访问以上两个服务的方式 
+ `config_demo`：配置中心 （包含`SpringCloud Bus`配置）
  + 访问：`ip:port/fileName`   例：`http://localhost:8005/user-dev.yml`
  + `SpringCloud Bus`可在不重启服务的情况下 更新配置
    + 需启动`rabbitMq`服务
    + 通过`post`提交`http://127.0.0.1:8005/actuator/bus-refresh`
+ `config_client_demo` ：通过配置中心获取微服务配置文件