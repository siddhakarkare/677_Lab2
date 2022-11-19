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
public final class ElectionReplyServiceGrpc {

  private ElectionReplyServiceGrpc() {}

  public static final String SERVICE_NAME = "ElectionReplyService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.example.data_types.ElectionReply,
      com.google.protobuf.Empty> getSendElectionReplyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "sendElectionReply",
      requestType = org.example.data_types.ElectionReply.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.example.data_types.ElectionReply,
      com.google.protobuf.Empty> getSendElectionReplyMethod() {
    io.grpc.MethodDescriptor<org.example.data_types.ElectionReply, com.google.protobuf.Empty> getSendElectionReplyMethod;
    if ((getSendElectionReplyMethod = ElectionReplyServiceGrpc.getSendElectionReplyMethod) == null) {
      synchronized (ElectionReplyServiceGrpc.class) {
        if ((getSendElectionReplyMethod = ElectionReplyServiceGrpc.getSendElectionReplyMethod) == null) {
          ElectionReplyServiceGrpc.getSendElectionReplyMethod = getSendElectionReplyMethod = 
              io.grpc.MethodDescriptor.<org.example.data_types.ElectionReply, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ElectionReplyService", "sendElectionReply"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.data_types.ElectionReply.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
                  .setSchemaDescriptor(new ElectionReplyServiceMethodDescriptorSupplier("sendElectionReply"))
                  .build();
          }
        }
     }
     return getSendElectionReplyMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ElectionReplyServiceStub newStub(io.grpc.Channel channel) {
    return new ElectionReplyServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ElectionReplyServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ElectionReplyServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ElectionReplyServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ElectionReplyServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class ElectionReplyServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void sendElectionReply(org.example.data_types.ElectionReply request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getSendElectionReplyMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSendElectionReplyMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.example.data_types.ElectionReply,
                com.google.protobuf.Empty>(
                  this, METHODID_SEND_ELECTION_REPLY)))
          .build();
    }
  }

  /**
   */
  public static final class ElectionReplyServiceStub extends io.grpc.stub.AbstractStub<ElectionReplyServiceStub> {
    private ElectionReplyServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ElectionReplyServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ElectionReplyServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ElectionReplyServiceStub(channel, callOptions);
    }

    /**
     */
    public void sendElectionReply(org.example.data_types.ElectionReply request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSendElectionReplyMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ElectionReplyServiceBlockingStub extends io.grpc.stub.AbstractStub<ElectionReplyServiceBlockingStub> {
    private ElectionReplyServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ElectionReplyServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ElectionReplyServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ElectionReplyServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.google.protobuf.Empty sendElectionReply(org.example.data_types.ElectionReply request) {
      return blockingUnaryCall(
          getChannel(), getSendElectionReplyMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ElectionReplyServiceFutureStub extends io.grpc.stub.AbstractStub<ElectionReplyServiceFutureStub> {
    private ElectionReplyServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ElectionReplyServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ElectionReplyServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ElectionReplyServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> sendElectionReply(
        org.example.data_types.ElectionReply request) {
      return futureUnaryCall(
          getChannel().newCall(getSendElectionReplyMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SEND_ELECTION_REPLY = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ElectionReplyServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ElectionReplyServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND_ELECTION_REPLY:
          serviceImpl.sendElectionReply((org.example.data_types.ElectionReply) request,
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

  private static abstract class ElectionReplyServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ElectionReplyServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.example.services.Services.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ElectionReplyService");
    }
  }

  private static final class ElectionReplyServiceFileDescriptorSupplier
      extends ElectionReplyServiceBaseDescriptorSupplier {
    ElectionReplyServiceFileDescriptorSupplier() {}
  }

  private static final class ElectionReplyServiceMethodDescriptorSupplier
      extends ElectionReplyServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ElectionReplyServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ElectionReplyServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ElectionReplyServiceFileDescriptorSupplier())
              .addMethod(getSendElectionReplyMethod())
              .build();
        }
      }
    }
    return result;
  }
}
