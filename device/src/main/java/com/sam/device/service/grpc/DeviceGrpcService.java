package com.sam.device.service.grpc;


import com.sam.lib.GrpcStringRequest;
import com.sam.lib.GrpcStringResponse;
import com.sam.lib.MyproRpcServiceGrpc;
import io.grpc.Channel;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class DeviceGrpcService {
    @GrpcClient("person")
    private Channel channel;

    private MyproRpcServiceGrpc.MyproRpcServiceBlockingStub stub;

    @PostConstruct
    public void init() {
        stub = MyproRpcServiceGrpc.newBlockingStub(channel);
    }

    public String getUser(String name) {
        GrpcStringResponse response = stub.getUser(GrpcStringRequest.newBuilder().setStr(name).build());
        return response.getStr();
    }

}
