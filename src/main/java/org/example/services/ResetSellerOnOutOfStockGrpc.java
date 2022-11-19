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
public final class ResetSellerOnOutOfStockGrpc {

  private ResetSellerOnOutOfStockGrpc() {}

  public static final String SERVICE_NAME = "ResetSellerOnOutOfStock";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.example.data_types.SellerOutOfStockNotification,
      org.example.data_types.SellerOutOfStockNotificationReply> getResetSellerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "resetSeller",
      requestType = org.example.data_types.SellerOutOfStockNotification.class,
      responseType = org.example.data_types.SellerOutOfStockNotificationReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.example.data_types.SellerOutOfStockNotification,
      org.example.data_types.SellerOutOfStockNotificationReply> getResetSellerMethod() {
    io.grpc.MethodDescriptor<org.example.data_types.SellerOutOfStockNotification, org.example.data_types.SellerOutOfStockNotificationReply> getResetSellerMethod;
    if ((getResetSellerMethod = ResetSellerOnOutOfStockGrpc.getResetSellerMethod) == null) {
      synchronized (ResetSellerOnOutOfStockGrpc.class) {
        if ((getResetSellerMethod = ResetSellerOnOutOfStockGrpc.getResetSellerMethod) == null) {
          ResetSellerOnOutOfStockGrpc.getResetSellerMethod = getResetSellerMethod = 
              io.grpc.MethodDescriptor.<org.example.data_types.SellerOutOfStockNotification, org.example.data_types.SellerOutOfStockNotificationReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ResetSellerOnOutOfStock", "resetSeller"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.data_types.SellerOutOfStockNotification.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.data_types.SellerOutOfStockNotificationReply.getDefaultInstance()))
                  .setSchemaDescriptor(new ResetSellerOnOutOfStockMethodDescriptorSupplier("resetSeller"))
                  .build();
          }
        }
     }
     return getResetSellerMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ResetSellerOnOutOfStockStub newStub(io.grpc.Channel channel) {
    return new ResetSellerOnOutOfStockStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ResetSellerOnOutOfStockBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ResetSellerOnOutOfStockBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ResetSellerOnOutOfStockFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ResetSellerOnOutOfStockFutureStub(channel);
  }

  /**
   */
  public static abstract class ResetSellerOnOutOfStockImplBase implements io.grpc.BindableService {

    /**
     */
    public void resetSeller(org.example.data_types.SellerOutOfStockNotification request,
        io.grpc.stub.StreamObserver<org.example.data_types.SellerOutOfStockNotificationReply> responseObserver) {
      asyncUnimplementedUnaryCall(getResetSellerMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getResetSellerMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.example.data_types.SellerOutOfStockNotification,
                org.example.data_types.SellerOutOfStockNotificationReply>(
                  this, METHODID_RESET_SELLER)))
          .build();
    }
  }

  /**
   */
  public static final class ResetSellerOnOutOfStockStub extends io.grpc.stub.AbstractStub<ResetSellerOnOutOfStockStub> {
    private ResetSellerOnOutOfStockStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ResetSellerOnOutOfStockStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ResetSellerOnOutOfStockStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ResetSellerOnOutOfStockStub(channel, callOptions);
    }

    /**
     */
    public void resetSeller(org.example.data_types.SellerOutOfStockNotification request,
        io.grpc.stub.StreamObserver<org.example.data_types.SellerOutOfStockNotificationReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getResetSellerMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ResetSellerOnOutOfStockBlockingStub extends io.grpc.stub.AbstractStub<ResetSellerOnOutOfStockBlockingStub> {
    private ResetSellerOnOutOfStockBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ResetSellerOnOutOfStockBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ResetSellerOnOutOfStockBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ResetSellerOnOutOfStockBlockingStub(channel, callOptions);
    }

    /**
     */
    public org.example.data_types.SellerOutOfStockNotificationReply resetSeller(org.example.data_types.SellerOutOfStockNotification request) {
      return blockingUnaryCall(
          getChannel(), getResetSellerMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ResetSellerOnOutOfStockFutureStub extends io.grpc.stub.AbstractStub<ResetSellerOnOutOfStockFutureStub> {
    private ResetSellerOnOutOfStockFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ResetSellerOnOutOfStockFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ResetSellerOnOutOfStockFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ResetSellerOnOutOfStockFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.data_types.SellerOutOfStockNotificationReply> resetSeller(
        org.example.data_types.SellerOutOfStockNotification request) {
      return futureUnaryCall(
          getChannel().newCall(getResetSellerMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_RESET_SELLER = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ResetSellerOnOutOfStockImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ResetSellerOnOutOfStockImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_RESET_SELLER:
          serviceImpl.resetSeller((org.example.data_types.SellerOutOfStockNotification) request,
              (io.grpc.stub.StreamObserver<org.example.data_types.SellerOutOfStockNotificationReply>) responseObserver);
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

  private static abstract class ResetSellerOnOutOfStockBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ResetSellerOnOutOfStockBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.example.services.Services.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ResetSellerOnOutOfStock");
    }
  }

  private static final class ResetSellerOnOutOfStockFileDescriptorSupplier
      extends ResetSellerOnOutOfStockBaseDescriptorSupplier {
    ResetSellerOnOutOfStockFileDescriptorSupplier() {}
  }

  private static final class ResetSellerOnOutOfStockMethodDescriptorSupplier
      extends ResetSellerOnOutOfStockBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ResetSellerOnOutOfStockMethodDescriptorSupplier(String methodName) {
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
      synchronized (ResetSellerOnOutOfStockGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ResetSellerOnOutOfStockFileDescriptorSupplier())
              .addMethod(getResetSellerMethod())
              .build();
        }
      }
    }
    return result;
  }
}
