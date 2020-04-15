package com.nemo.grpcstarterclient.controller;

import com.nemo.grpcstarterserver.HelloServiceGrpc;
import com.nemo.grpcstarterserver.StringRequest;
import com.nemo.grpcstarterserver.StringResponse;
import io.swagger.annotations.ApiOperation;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Nemo
 * @version 1.0
 * @date 2020/4/15
 */
@RestController
@RequestMapping("Test")
public class HelloController {

    @GrpcClient("server-service")
    private HelloServiceGrpc.HelloServiceBlockingStub helloServiceBlockingStub;

    @PostMapping("sayHelloWorld")
    @ApiOperation(value = "普通方式传输")
    public String sayHelloWorld(@RequestBody String name) {
        StringRequest request = StringRequest.newBuilder().setValue(name).build();
        StringResponse response = helloServiceBlockingStub.sayHelloWorld(request);
        return response.getValue();
    }
}
