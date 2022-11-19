package org.example.services;

import io.grpc.stub.StreamObserver;
import org.example.data_types.SellerOutOfStockNotification;
import org.example.data_types.SellerOutOfStockNotificationReply;

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
public final class TransactionServiceGrpc {

  private TransactionServiceGrpc() {}

  public static final String SERVICE_NAME = "TransactionService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.example.data_types.TransactionRequest,
      org.example.data_types.TransactionReply> getTransactMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "transact",
      requestType = org.example.data_types.TransactionRequest.class,
      responseType = org.example.data_types.TransactionReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.example.data_types.TransactionRequest,
      org.example.data_types.TransactionReply> getTransactMethod() {
    io.grpc.MethodDescriptor<org.example.data_types.TransactionRequest, org.example.data_types.TransactionReply> getTransactMethod;
    if ((getTransactMethod = TransactionServiceGrpc.getTransactMethod) == null) {
      synchronized (TransactionServiceGrpc.class) {
        if ((getTransactMethod = TransactionServiceGrpc.getTransactMethod) == null) {
          TransactionServiceGrpc.getTransactMethod = getTransactMethod = 
              io.grpc.MethodDescriptor.<org.example.data_types.TransactionRequest, org.example.data_types.TransactionReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "TransactionService", "transact"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.data_types.TransactionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.data_types.TransactionReply.getDefaultInstance()))
                  .setSchemaDescriptor(new TransactionServiceMethodDescriptorSupplier("transact"))
                  .build();
          }
        }
     }
     return getTransactMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TransactionServiceStub newStub(io.grpc.Channel channel) {
    return new TransactionServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TransactionServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new TransactionServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TransactionServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new TransactionServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class TransactionServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void transact(org.example.data_types.TransactionRequest request,
        io.grpc.stub.StreamObserver<org.example.data_types.TransactionReply> responseObserver) {
      asyncUnimplementedUnaryCall(getTransactMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getTransactMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.example.data_types.TransactionRequest,
                org.example.data_types.TransactionReply>(
                  this, METHODID_TRANSACT)))
          .build();
    }
  }

  /**
   */
  public static final class TransactionServiceStub extends io.grpc.stub.AbstractStub<TransactionServiceStub> {
    private TransactionServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TransactionServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TransactionServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TransactionServiceStub(channel, callOptions);
    }

    /**
     */
    public void transact(org.example.data_types.TransactionRequest request,
        io.grpc.stub.StreamObserver<org.example.data_types.TransactionReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getTransactMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class TransactionServiceBlockingStub extends io.grpc.stub.AbstractStub<TransactionServiceBlockingStub> {
    private TransactionServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TransactionServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TransactionServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TransactionServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public org.example.data_types.TransactionReply transact(org.example.data_types.TransactionRequest request) {
      return blockingUnaryCall(
          getChannel(), getTransactMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class TransactionServiceFutureStub extends io.grpc.stub.AbstractStub<TransactionServiceFutureStub> {
    private TransactionServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TransactionServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TransactionServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TransactionServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.data_types.TransactionReply> transact(
        org.example.data_types.TransactionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getTransactMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_TRANSACT = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TransactionServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TransactionServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_TRANSACT:
          serviceImpl.transact((org.example.data_types.TransactionRequest) request,
              (io.grpc.stub.StreamObserver<org.example.data_types.TransactionReply>) responseObserver);
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

  private static abstract class TransactionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TransactionServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.example.services.Services.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TransactionService");
    }
  }

  private static final class TransactionServiceFileDescriptorSupplier
      extends TransactionServiceBaseDescriptorSupplier {
    TransactionServiceFileDescriptorSupplier() {}
  }

  private static final class TransactionServiceMethodDescriptorSupplier
      extends TransactionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TransactionServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (TransactionServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TransactionServiceFileDescriptorSupplier())
              .addMethod(getTransactMethod())
              .build();
        }
      }
    }
    return result;
  }
}
