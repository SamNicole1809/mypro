package com.sam.person.service.grpc;

import com.sam.lib.GrpcStringRequest;
import com.sam.lib.GrpcStringResponse;
import com.sam.lib.MyproRpcServiceGrpc;
import io.grpc.netty.shaded.io.netty.util.internal.StringUtil;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.UUID;

@GrpcService
public class PersonGrpcService extends MyproRpcServiceGrpc.MyproRpcServiceImplBase {
    @Override
    public void getUser(GrpcStringRequest request, StreamObserver<GrpcStringResponse> responseObserver) {
        String name = request.getStr();
        GrpcStringResponse response = GrpcStringResponse.newBuilder().setStr("").build();
        if (!StringUtil.isNullOrEmpty(name)) {
            String result = name + "--" + UUID.randomUUID().toString();
            response = GrpcStringResponse.newBuilder().setStr(result).build();
        }
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
