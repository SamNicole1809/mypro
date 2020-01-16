package com.sam.lib;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.26.0)",
    comments = "Source: mypro.proto")
public final class MyproRpcServiceGrpc {

  private MyproRpcServiceGrpc() {}

  public static final String SERVICE_NAME = "MyproRpcService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.sam.lib.GrpcStringRequest,
      com.sam.lib.GrpcStringResponse> getGetUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getUser",
      requestType = com.sam.lib.GrpcStringRequest.class,
      responseType = com.sam.lib.GrpcStringResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.sam.lib.GrpcStringRequest,
      com.sam.lib.GrpcStringResponse> getGetUserMethod() {
    io.grpc.MethodDescriptor<com.sam.lib.GrpcStringRequest, com.sam.lib.GrpcStringResponse> getGetUserMethod;
    if ((getGetUserMethod = MyproRpcServiceGrpc.getGetUserMethod) == null) {
      synchronized (MyproRpcServiceGrpc.class) {
        if ((getGetUserMethod = MyproRpcServiceGrpc.getGetUserMethod) == null) {
          MyproRpcServiceGrpc.getGetUserMethod = getGetUserMethod =
              io.grpc.MethodDescriptor.<com.sam.lib.GrpcStringRequest, com.sam.lib.GrpcStringResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sam.lib.GrpcStringRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sam.lib.GrpcStringResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MyproRpcServiceMethodDescriptorSupplier("getUser"))
              .build();
        }
      }
    }
    return getGetUserMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MyproRpcServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MyproRpcServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MyproRpcServiceStub>() {
        @java.lang.Override
        public MyproRpcServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MyproRpcServiceStub(channel, callOptions);
        }
      };
    return MyproRpcServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MyproRpcServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MyproRpcServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MyproRpcServiceBlockingStub>() {
        @java.lang.Override
        public MyproRpcServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MyproRpcServiceBlockingStub(channel, callOptions);
        }
      };
    return MyproRpcServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MyproRpcServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MyproRpcServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MyproRpcServiceFutureStub>() {
        @java.lang.Override
        public MyproRpcServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MyproRpcServiceFutureStub(channel, callOptions);
        }
      };
    return MyproRpcServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class MyproRpcServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getUser(com.sam.lib.GrpcStringRequest request,
        io.grpc.stub.StreamObserver<com.sam.lib.GrpcStringResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetUserMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetUserMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.sam.lib.GrpcStringRequest,
                com.sam.lib.GrpcStringResponse>(
                  this, METHODID_GET_USER)))
          .build();
    }
  }

  /**
   */
  public static final class MyproRpcServiceStub extends io.grpc.stub.AbstractAsyncStub<MyproRpcServiceStub> {
    private MyproRpcServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MyproRpcServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MyproRpcServiceStub(channel, callOptions);
    }

    /**
     */
    public void getUser(com.sam.lib.GrpcStringRequest request,
        io.grpc.stub.StreamObserver<com.sam.lib.GrpcStringResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetUserMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class MyproRpcServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<MyproRpcServiceBlockingStub> {
    private MyproRpcServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MyproRpcServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MyproRpcServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.sam.lib.GrpcStringResponse getUser(com.sam.lib.GrpcStringRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetUserMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class MyproRpcServiceFutureStub extends io.grpc.stub.AbstractFutureStub<MyproRpcServiceFutureStub> {
    private MyproRpcServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MyproRpcServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MyproRpcServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.sam.lib.GrpcStringResponse> getUser(
        com.sam.lib.GrpcStringRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetUserMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_USER = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MyproRpcServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(MyproRpcServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_USER:
          serviceImpl.getUser((com.sam.lib.GrpcStringRequest) request,
              (io.grpc.stub.StreamObserver<com.sam.lib.GrpcStringResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class MyproRpcServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MyproRpcServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.sam.lib.MyproRpcProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MyproRpcService");
    }
  }

  private static final class MyproRpcServiceFileDescriptorSupplier
      extends MyproRpcServiceBaseDescriptorSupplier {
    MyproRpcServiceFileDescriptorSupplier() {}
  }

  private static final class MyproRpcServiceMethodDescriptorSupplier
      extends MyproRpcServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MyproRpcServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (MyproRpcServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MyproRpcServiceFileDescriptorSupplier())
              .addMethod(getGetUserMethod())
              .build();
        }
      }
    }
    return result;
  }
}
