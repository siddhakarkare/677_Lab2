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
public final class ElectionRequestServiceGrpc {

  private ElectionRequestServiceGrpc() {}

  public static final String SERVICE_NAME = "ElectionRequestService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.example.data_types.ElectionRequest,
      org.example.data_types.ElectionReply> getElectLeaderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "electLeader",
      requestType = org.example.data_types.ElectionRequest.class,
      responseType = org.example.data_types.ElectionReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.example.data_types.ElectionRequest,
      org.example.data_types.ElectionReply> getElectLeaderMethod() {
    io.grpc.MethodDescriptor<org.example.data_types.ElectionRequest, org.example.data_types.ElectionReply> getElectLeaderMethod;
    if ((getElectLeaderMethod = ElectionRequestServiceGrpc.getElectLeaderMethod) == null) {
      synchronized (ElectionRequestServiceGrpc.class) {
        if ((getElectLeaderMethod = ElectionRequestServiceGrpc.getElectLeaderMethod) == null) {
          ElectionRequestServiceGrpc.getElectLeaderMethod = getElectLeaderMethod = 
              io.grpc.MethodDescriptor.<org.example.data_types.ElectionRequest, org.example.data_types.ElectionReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ElectionRequestService", "electLeader"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.data_types.ElectionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.data_types.ElectionReply.getDefaultInstance()))
                  .setSchemaDescriptor(new ElectionRequestServiceMethodDescriptorSupplier("electLeader"))
                  .build();
          }
        }
     }
     return getElectLeaderMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ElectionRequestServiceStub newStub(io.grpc.Channel channel) {
    return new ElectionRequestServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ElectionRequestServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ElectionRequestServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ElectionRequestServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ElectionRequestServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class ElectionRequestServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void electLeader(org.example.data_types.ElectionRequest request,
        io.grpc.stub.StreamObserver<org.example.data_types.ElectionReply> responseObserver) {
      asyncUnimplementedUnaryCall(getElectLeaderMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getElectLeaderMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.example.data_types.ElectionRequest,
                org.example.data_types.ElectionReply>(
                  this, METHODID_ELECT_LEADER)))
          .build();
    }
  }

  /**
   */
  public static final class ElectionRequestServiceStub extends io.grpc.stub.AbstractStub<ElectionRequestServiceStub> {
    private ElectionRequestServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ElectionRequestServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ElectionRequestServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ElectionRequestServiceStub(channel, callOptions);
    }

    /**
     */
    public void electLeader(org.example.data_types.ElectionRequest request,
        io.grpc.stub.StreamObserver<org.example.data_types.ElectionReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getElectLeaderMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ElectionRequestServiceBlockingStub extends io.grpc.stub.AbstractStub<ElectionRequestServiceBlockingStub> {
    private ElectionRequestServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ElectionRequestServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ElectionRequestServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ElectionRequestServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public org.example.data_types.ElectionReply electLeader(org.example.data_types.ElectionRequest request) {
      return blockingUnaryCall(
          getChannel(), getElectLeaderMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ElectionRequestServiceFutureStub extends io.grpc.stub.AbstractStub<ElectionRequestServiceFutureStub> {
    private ElectionRequestServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ElectionRequestServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ElectionRequestServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ElectionRequestServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.data_types.ElectionReply> electLeader(
        org.example.data_types.ElectionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getElectLeaderMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ELECT_LEADER = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ElectionRequestServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ElectionRequestServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ELECT_LEADER:
          serviceImpl.electLeader((org.example.data_types.ElectionRequest) request,
              (io.grpc.stub.StreamObserver<org.example.data_types.ElectionReply>) responseObserver);
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

  private static abstract class ElectionRequestServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ElectionRequestServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.example.services.Services.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ElectionRequestService");
    }
  }

  private static final class ElectionRequestServiceFileDescriptorSupplier
      extends ElectionRequestServiceBaseDescriptorSupplier {
    ElectionRequestServiceFileDescriptorSupplier() {}
  }

  private static final class ElectionRequestServiceMethodDescriptorSupplier
      extends ElectionRequestServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ElectionRequestServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ElectionRequestServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ElectionRequestServiceFileDescriptorSupplier())
              .addMethod(getElectLeaderMethod())
              .build();
        }
      }
    }
    return result;
  }
}
