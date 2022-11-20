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
public final class LeaderResignationNotificationServiceGrpc {

  private LeaderResignationNotificationServiceGrpc() {}

  public static final String SERVICE_NAME = "LeaderResignationNotificationService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.example.data_types.LeaderResignationNotification,
      com.google.protobuf.Empty> getResignLeaderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "resignLeader",
      requestType = org.example.data_types.LeaderResignationNotification.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.example.data_types.LeaderResignationNotification,
      com.google.protobuf.Empty> getResignLeaderMethod() {
    io.grpc.MethodDescriptor<org.example.data_types.LeaderResignationNotification, com.google.protobuf.Empty> getResignLeaderMethod;
    if ((getResignLeaderMethod = LeaderResignationNotificationServiceGrpc.getResignLeaderMethod) == null) {
      synchronized (LeaderResignationNotificationServiceGrpc.class) {
        if ((getResignLeaderMethod = LeaderResignationNotificationServiceGrpc.getResignLeaderMethod) == null) {
          LeaderResignationNotificationServiceGrpc.getResignLeaderMethod = getResignLeaderMethod = 
              io.grpc.MethodDescriptor.<org.example.data_types.LeaderResignationNotification, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "LeaderResignationNotificationService", "resignLeader"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.data_types.LeaderResignationNotification.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
                  .setSchemaDescriptor(new LeaderResignationNotificationServiceMethodDescriptorSupplier("resignLeader"))
                  .build();
          }
        }
     }
     return getResignLeaderMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LeaderResignationNotificationServiceStub newStub(io.grpc.Channel channel) {
    return new LeaderResignationNotificationServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LeaderResignationNotificationServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new LeaderResignationNotificationServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static LeaderResignationNotificationServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new LeaderResignationNotificationServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class LeaderResignationNotificationServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void resignLeader(org.example.data_types.LeaderResignationNotification request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getResignLeaderMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getResignLeaderMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.example.data_types.LeaderResignationNotification,
                com.google.protobuf.Empty>(
                  this, METHODID_RESIGN_LEADER)))
          .build();
    }
  }

  /**
   */
  public static final class LeaderResignationNotificationServiceStub extends io.grpc.stub.AbstractStub<LeaderResignationNotificationServiceStub> {
    private LeaderResignationNotificationServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LeaderResignationNotificationServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LeaderResignationNotificationServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LeaderResignationNotificationServiceStub(channel, callOptions);
    }

    /**
     */
    public void resignLeader(org.example.data_types.LeaderResignationNotification request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getResignLeaderMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class LeaderResignationNotificationServiceBlockingStub extends io.grpc.stub.AbstractStub<LeaderResignationNotificationServiceBlockingStub> {
    private LeaderResignationNotificationServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LeaderResignationNotificationServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LeaderResignationNotificationServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LeaderResignationNotificationServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.google.protobuf.Empty resignLeader(org.example.data_types.LeaderResignationNotification request) {
      return blockingUnaryCall(
          getChannel(), getResignLeaderMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class LeaderResignationNotificationServiceFutureStub extends io.grpc.stub.AbstractStub<LeaderResignationNotificationServiceFutureStub> {
    private LeaderResignationNotificationServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LeaderResignationNotificationServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LeaderResignationNotificationServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LeaderResignationNotificationServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> resignLeader(
        org.example.data_types.LeaderResignationNotification request) {
      return futureUnaryCall(
          getChannel().newCall(getResignLeaderMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_RESIGN_LEADER = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final LeaderResignationNotificationServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(LeaderResignationNotificationServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_RESIGN_LEADER:
          serviceImpl.resignLeader((org.example.data_types.LeaderResignationNotification) request,
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

  private static abstract class LeaderResignationNotificationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LeaderResignationNotificationServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.example.services.Services.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LeaderResignationNotificationService");
    }
  }

  private static final class LeaderResignationNotificationServiceFileDescriptorSupplier
      extends LeaderResignationNotificationServiceBaseDescriptorSupplier {
    LeaderResignationNotificationServiceFileDescriptorSupplier() {}
  }

  private static final class LeaderResignationNotificationServiceMethodDescriptorSupplier
      extends LeaderResignationNotificationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    LeaderResignationNotificationServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (LeaderResignationNotificationServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new LeaderResignationNotificationServiceFileDescriptorSupplier())
              .addMethod(getResignLeaderMethod())
              .build();
        }
      }
    }
    return result;
  }
}
