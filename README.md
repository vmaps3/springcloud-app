# springcloud-rbac

## 系统介绍

- spring-cloud-rbac 是以spring-cloud为核心的权限管理框架，技术栈包括：spring-cloud,consul，gateway,hystrix，turbine，zipkin，mybatis、spring-security、redis，业务模块包括：用户管理，角色管理、权限管理，字典管理。

## 业务功能

- 1.用户管理：用户增删改查与角色关系
- 2.角色管理：角色增删改查与权限关系
- 3.菜单管理：菜单增删改查（树形结构）
- 4.字典管理：字典增删改查

## 技术栈

- springcloud 整合
- consul 注册中心
- gateway 路由中心
- turbine 断路器监控聚合
- zipkin 链路监控
- springBoot ioc，aop
- mybatis ORM  
- springsecurity 会话
- redis 缓存

## 部署

- 1.导入数据库脚本springcloud.sql
- 2.启动redis
- 3.启动consul
- 4.启动配置中心springcloud-app-config
- 5.启动权限中心springcloud-app-system
- 6.启动调度中心springcloud-app-schedule
- 7.启动网关中心springcloud-app-gateway
- 8.访问端口http://127.0.0.1:1101/html/login.html

## qq交流群

- 74745979
