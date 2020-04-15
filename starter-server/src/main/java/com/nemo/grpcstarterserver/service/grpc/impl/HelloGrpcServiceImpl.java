package com.nemo.grpcstarterserver.service.grpc.impl;

import com.nemo.grpcstarterserver.HelloServiceGrpc;
import com.nemo.grpcstarterserver.StringRequest;
import com.nemo.grpcstarterserver.StringResponse;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

/**
 * @author Nemo
 * @version 1.0
 * @date 2020/4/15
 */
@Slf4j
@GrpcService
public class HelloGrpcServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {

    @Override
    public void sayHelloWorld(StringRequest request, StreamObserver<StringResponse> responseObserver) {
        String hello = request.getValue() + " says hello world";
        responseObserver.onNext(StringResponse.newBuilder().setValue(hello).build());
        responseObserver.onCompleted();
    }
}
