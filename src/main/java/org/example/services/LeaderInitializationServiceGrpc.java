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
public final class LeaderInitializationServiceGrpc {

  private LeaderInitializationServiceGrpc() {}

  public static final String SERVICE_NAME = "LeaderInitializationService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.example.data_types.LeaderInitializationRequest,
      com.google.protobuf.Empty> getInitiateLeaderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "initiateLeader",
      requestType = org.example.data_types.LeaderInitializationRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.example.data_types.LeaderInitializationRequest,
      com.google.protobuf.Empty> getInitiateLeaderMethod() {
    io.grpc.MethodDescriptor<org.example.data_types.LeaderInitializationRequest, com.google.protobuf.Empty> getInitiateLeaderMethod;
    if ((getInitiateLeaderMethod = LeaderInitializationServiceGrpc.getInitiateLeaderMethod) == null) {
      synchronized (LeaderInitializationServiceGrpc.class) {
        if ((getInitiateLeaderMethod = LeaderInitializationServiceGrpc.getInitiateLeaderMethod) == null) {
          LeaderInitializationServiceGrpc.getInitiateLeaderMethod = getInitiateLeaderMethod = 
              io.grpc.MethodDescriptor.<org.example.data_types.LeaderInitializationRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "LeaderInitializationService", "initiateLeader"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.data_types.LeaderInitializationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
                  .setSchemaDescriptor(new LeaderInitializationServiceMethodDescriptorSupplier("initiateLeader"))
                  .build();
          }
        }
     }
     return getInitiateLeaderMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LeaderInitializationServiceStub newStub(io.grpc.Channel channel) {
    return new LeaderInitializationServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LeaderInitializationServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new LeaderInitializationServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static LeaderInitializationServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new LeaderInitializationServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class LeaderInitializationServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void initiateLeader(org.example.data_types.LeaderInitializationRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getInitiateLeaderMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getInitiateLeaderMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.example.data_types.LeaderInitializationRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_INITIATE_LEADER)))
          .build();
    }
  }

  /**
   */
  public static final class LeaderInitializationServiceStub extends io.grpc.stub.AbstractStub<LeaderInitializationServiceStub> {
    private LeaderInitializationServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LeaderInitializationServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LeaderInitializationServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LeaderInitializationServiceStub(channel, callOptions);
    }

    /**
     */
    public void initiateLeader(org.example.data_types.LeaderInitializationRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getInitiateLeaderMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class LeaderInitializationServiceBlockingStub extends io.grpc.stub.AbstractStub<LeaderInitializationServiceBlockingStub> {
    private LeaderInitializationServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LeaderInitializationServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LeaderInitializationServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LeaderInitializationServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.google.protobuf.Empty initiateLeader(org.example.data_types.LeaderInitializationRequest request) {
      return blockingUnaryCall(
          getChannel(), getInitiateLeaderMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class LeaderInitializationServiceFutureStub extends io.grpc.stub.AbstractStub<LeaderInitializationServiceFutureStub> {
    private LeaderInitializationServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LeaderInitializationServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LeaderInitializationServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LeaderInitializationServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> initiateLeader(
        org.example.data_types.LeaderInitializationRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getInitiateLeaderMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_INITIATE_LEADER = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final LeaderInitializationServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(LeaderInitializationServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_INITIATE_LEADER:
          serviceImpl.initiateLeader((org.example.data_types.LeaderInitializationRequest) request,
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

  private static abstract class LeaderInitializationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LeaderInitializationServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.example.services.Services.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LeaderInitializationService");
    }
  }

  private static final class LeaderInitializationServiceFileDescriptorSupplier
      extends LeaderInitializationServiceBaseDescriptorSupplier {
    LeaderInitializationServiceFileDescriptorSupplier() {}
  }

  private static final class LeaderInitializationServiceMethodDescriptorSupplier
      extends LeaderInitializationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    LeaderInitializationServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (LeaderInitializationServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new LeaderInitializationServiceFileDescriptorSupplier())
              .addMethod(getInitiateLeaderMethod())
              .build();
        }
      }
    }
    return result;
  }
}
