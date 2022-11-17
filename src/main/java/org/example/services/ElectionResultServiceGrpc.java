package org.example.services;

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
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: services.proto")
public final class ElectionResultServiceGrpc {

  private ElectionResultServiceGrpc() {}

  public static final String SERVICE_NAME = "ElectionResultService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.example.data_types.ElectionResultDeclaration,
      com.google.protobuf.Empty> getDeclareResultMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "declareResult",
      requestType = org.example.data_types.ElectionResultDeclaration.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.example.data_types.ElectionResultDeclaration,
      com.google.protobuf.Empty> getDeclareResultMethod() {
    io.grpc.MethodDescriptor<org.example.data_types.ElectionResultDeclaration, com.google.protobuf.Empty> getDeclareResultMethod;
    if ((getDeclareResultMethod = ElectionResultServiceGrpc.getDeclareResultMethod) == null) {
      synchronized (ElectionResultServiceGrpc.class) {
        if ((getDeclareResultMethod = ElectionResultServiceGrpc.getDeclareResultMethod) == null) {
          ElectionResultServiceGrpc.getDeclareResultMethod = getDeclareResultMethod = 
              io.grpc.MethodDescriptor.<org.example.data_types.ElectionResultDeclaration, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ElectionResultService", "declareResult"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.data_types.ElectionResultDeclaration.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
                  .setSchemaDescriptor(new ElectionResultServiceMethodDescriptorSupplier("declareResult"))
                  .build();
          }
        }
     }
     return getDeclareResultMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ElectionResultServiceStub newStub(io.grpc.Channel channel) {
    return new ElectionResultServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ElectionResultServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ElectionResultServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ElectionResultServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ElectionResultServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class ElectionResultServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void declareResult(org.example.data_types.ElectionResultDeclaration request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeclareResultMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getDeclareResultMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.example.data_types.ElectionResultDeclaration,
                com.google.protobuf.Empty>(
                  this, METHODID_DECLARE_RESULT)))
          .build();
    }
  }

  /**
   */
  public static final class ElectionResultServiceStub extends io.grpc.stub.AbstractStub<ElectionResultServiceStub> {
    private ElectionResultServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ElectionResultServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ElectionResultServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ElectionResultServiceStub(channel, callOptions);
    }

    /**
     */
    public void declareResult(org.example.data_types.ElectionResultDeclaration request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeclareResultMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ElectionResultServiceBlockingStub extends io.grpc.stub.AbstractStub<ElectionResultServiceBlockingStub> {
    private ElectionResultServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ElectionResultServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ElectionResultServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ElectionResultServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.google.protobuf.Empty declareResult(org.example.data_types.ElectionResultDeclaration request) {
      return blockingUnaryCall(
          getChannel(), getDeclareResultMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ElectionResultServiceFutureStub extends io.grpc.stub.AbstractStub<ElectionResultServiceFutureStub> {
    private ElectionResultServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ElectionResultServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ElectionResultServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ElectionResultServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> declareResult(
        org.example.data_types.ElectionResultDeclaration request) {
      return futureUnaryCall(
          getChannel().newCall(getDeclareResultMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_DECLARE_RESULT = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ElectionResultServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ElectionResultServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_DECLARE_RESULT:
          serviceImpl.declareResult((org.example.data_types.ElectionResultDeclaration) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
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

  private static abstract class ElectionResultServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ElectionResultServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.example.services.Services.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ElectionResultService");
    }
  }

  private static final class ElectionResultServiceFileDescriptorSupplier
      extends ElectionResultServiceBaseDescriptorSupplier {
    ElectionResultServiceFileDescriptorSupplier() {}
  }

  private static final class ElectionResultServiceMethodDescriptorSupplier
      extends ElectionResultServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ElectionResultServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ElectionResultServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ElectionResultServiceFileDescriptorSupplier())
              .addMethod(getDeclareResultMethod())
              .build();
        }
      }
    }
    return result;
  }
}
