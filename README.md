# springcloud-app

## 系统介绍

- springcloud-app 是以spring-cloud为核心的权限管理框架，技术栈包括：spring-cloud,consul，gateway,hystrix，turbine，zipkin，mybatisPuls、spring-security、redis，业务模块包括：用户管理，角色管理、权限管理。

## 业务功能

- 1.用户管理：用户增删改查与角色关系
- 2.角色管理：角色增删改查与权限关系
- 3.菜单管理：菜单增删改查（树形结构）

## 技术栈

- springcloud 整合
- consul 注册中心
- gateway 路由中心
- turbine 断路器监控聚合
- zipkin 链路监控
- springBoot ioc，aop
- mybatisPuls ORM  
- springsecurity 会话
- redis 缓存

## 部署

- 1.导入数据库脚本springcloud-app.sql
- 2.启动redis
- 3.启动rabittmq
- 4.启动consul
- 5.启动配置中心config
- 6.启动权限中心system
- 7.启动调度中心schedule
- 8.启动网关中心gateway
- 9.访问端口http://127.0.0.1:1101/html/login.html

## 相关命令

- 1.注册中心启动
consul agent -dev

- 2.链路监控启动
java -jar zipkin-server-2.10.1-exec.jar --zipkin.collector.rabbitmq.addresses=localhost --zipkin.collector.rabbitmq.username=guest --zipkin.collector.rabbitmq.password=guest

- 3.断路器集群监控地址
http://localhost:8989/turbine.stream

- 4.配置中心刷新
curl -X POST http://localhost:8081/actuator/bus-refresh

## qq交流群

- 74745979
