# springcloud-app

## 部署

- 启动rabittmq(可选)
- 启动consul
- 启动config
- 启动system
- 启动order
- 启动gateway
- 访问http://127.0.0.1:1101/order/order/get?text=121

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
