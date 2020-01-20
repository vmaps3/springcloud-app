# springcloud-app

## 系统介绍

- springcloud-app 是J2EE集群分布式基础开发平台，技术栈包括：springcloud，eureka，zuul，ribbon，feign，config，bus、hystrix，turbine，zipkin，MyBatis、springsecurity-oauth、redis，swagger，lombok，业务模块包括：用户管理，角色管理、权限管理，字典管理。
## 核心流程概要

- 用户->nginx->HTML->ZUUL(路由中心)->eureka(注册中心)->认证服务->资源服务->->REDIS/MYSQL
- 外部通信,方式HTTP,协议HTTP,权限SHIRO,注意ZUUL过滤器屏蔽内部接口（防止内部接口对外暴露）
- 内部通信,方式Feign,协议HTTP,权限eureka账号密码,注意springsecurity要开放内部接口

## 业务功能

- 1.用户管理：用户增删改查与角色关系
- 2.角色管理：角色增删改查与权限关系
- 3.菜单管理：菜单增删改查（树形结构）
- 4.字典管理：字典增删改查

## 技术栈

- springcloud 整合
- eureka 注册中心
- zuul 路由中心
- ribbon 通信
- feign 注解通信
- config 配置中心
- bus 实时配置中心功能
- hystrix 断路器监控
- turbine 断路器监控聚合
- zipkin 链路监控
- springBoot ioc，aop
- mybatis ORM  
- springsecurity-oauth 会话
- redis 缓存
- 连接池 druid
- swagger api
- lombok 代码优化


## 部署

- 1.导入数据库脚本springcloud.sql
- 2.启动redis
- 3.启动注册中心springcloud-app-eureka
- 4.启动配置中心springcloud-app-config
- 5.启动权限中心springcloud-app-system
- 6.启动调度中心springcloud-app-schedule
- 7.启动网关中心springcloud-app-zuul
- 8.访问端口http://127.0.0.1:1101/html/login.html

## qq交流群

- 74745979
