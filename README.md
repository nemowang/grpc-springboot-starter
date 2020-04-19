# grpc-spring-boot-starter-simple
Springboot整合gRpc项目框架.实现client服务对server服务远程调用.
- ---

## 特性
- 在 spring boot 应用中，通过 @GrpcService 自动配置并运行一个嵌入式的 gRPC 服务.
- 使用 @GrpcClient 自动创建和管理您的 gRPC Channels 和 stubs.
---

## 用法
### grpc服务端
使用以下命令添加Maven依赖项：
```
<dependency>
    <groupId>net.devh</groupId>
    <artifactId>grpc-server-spring-boot-starter</artifactId>
    <version>2.4.0.RELEASE</version>
</dependency>
```
在服务端接口实现类上添加 @GrpcService 注解：
```
@GrpcService
public class HelloGrpcServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {

    @Override
    public void sayHelloWorld(StringRequest request, StreamObserver<StringResponse> responseObserver) {
        String hello = request.getValue() + " says hello world";
        responseObserver.onNext(StringResponse.newBuilder().setValue(hello).build());
        responseObserver.onCompleted();
    }
}
```
默认情况下，Grpc 服务器将监听端口 9090. 端口的配置和其他设置可以通过SpringBoot的配置文件进行更改. 服务端的配置使用 grpc.server. 前缀.
```
grpc.server.address=127.0.0.1
grpc.server.port=9090
grpc.server.in-process-name=server-service
```
### gRPC客户端
使用以下命令添加Maven依赖项：
```
<dependency>
    <groupId>net.devh</groupId>
    <artifactId>grpc-client-spring-boot-starter</artifactId>
    <version>2.4.0.RELEASE</version>
</dependency>
```
在grpc 客户端的stub字段上添加 @GrpcClient(serverName) 注解：
- 请不要将 @GrpcClient 与 @Autowireed 或 @Inject 一起使用.
```
@GrpcClient("server-service")
private HelloServiceGrpc.HelloServiceBlockingStub helloServiceBlockingStub;
```
配置和其他设置可以通过SpringBoot的配置文件进行更改.
