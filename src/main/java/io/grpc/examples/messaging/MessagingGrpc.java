package io.grpc.examples.messaging;

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
    comments = "Source: messaging.proto")
public final class MessagingGrpc {

  private MessagingGrpc() {}

  public static final String SERVICE_NAME = "messaging.Messaging";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<io.grpc.examples.messaging.MessageRequest,
      io.grpc.examples.messaging.MessageResponse> getSendMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendMessage",
      requestType = io.grpc.examples.messaging.MessageRequest.class,
      responseType = io.grpc.examples.messaging.MessageResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.grpc.examples.messaging.MessageRequest,
      io.grpc.examples.messaging.MessageResponse> getSendMessageMethod() {
    io.grpc.MethodDescriptor<io.grpc.examples.messaging.MessageRequest, io.grpc.examples.messaging.MessageResponse> getSendMessageMethod;
    if ((getSendMessageMethod = MessagingGrpc.getSendMessageMethod) == null) {
      synchronized (MessagingGrpc.class) {
        if ((getSendMessageMethod = MessagingGrpc.getSendMessageMethod) == null) {
          MessagingGrpc.getSendMessageMethod = getSendMessageMethod = 
              io.grpc.MethodDescriptor.<io.grpc.examples.messaging.MessageRequest, io.grpc.examples.messaging.MessageResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "messaging.Messaging", "SendMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.examples.messaging.MessageRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.examples.messaging.MessageResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new MessagingMethodDescriptorSupplier("SendMessage"))
                  .build();
          }
        }
     }
     return getSendMessageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.grpc.examples.messaging.MessageRequest,
      io.grpc.examples.messaging.MessageResponse> getSendReceiveMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendReceiveMessage",
      requestType = io.grpc.examples.messaging.MessageRequest.class,
      responseType = io.grpc.examples.messaging.MessageResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<io.grpc.examples.messaging.MessageRequest,
      io.grpc.examples.messaging.MessageResponse> getSendReceiveMessageMethod() {
    io.grpc.MethodDescriptor<io.grpc.examples.messaging.MessageRequest, io.grpc.examples.messaging.MessageResponse> getSendReceiveMessageMethod;
    if ((getSendReceiveMessageMethod = MessagingGrpc.getSendReceiveMessageMethod) == null) {
      synchronized (MessagingGrpc.class) {
        if ((getSendReceiveMessageMethod = MessagingGrpc.getSendReceiveMessageMethod) == null) {
          MessagingGrpc.getSendReceiveMessageMethod = getSendReceiveMessageMethod = 
              io.grpc.MethodDescriptor.<io.grpc.examples.messaging.MessageRequest, io.grpc.examples.messaging.MessageResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "messaging.Messaging", "SendReceiveMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.examples.messaging.MessageRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.examples.messaging.MessageResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new MessagingMethodDescriptorSupplier("SendReceiveMessage"))
                  .build();
          }
        }
     }
     return getSendReceiveMessageMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MessagingStub newStub(io.grpc.Channel channel) {
    return new MessagingStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MessagingBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new MessagingBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MessagingFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new MessagingFutureStub(channel);
  }

  /**
   */
  public static abstract class MessagingImplBase implements io.grpc.BindableService {

    /**
     */
    public void sendMessage(io.grpc.examples.messaging.MessageRequest request,
        io.grpc.stub.StreamObserver<io.grpc.examples.messaging.MessageResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSendMessageMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<io.grpc.examples.messaging.MessageRequest> sendReceiveMessage(
        io.grpc.stub.StreamObserver<io.grpc.examples.messaging.MessageResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getSendReceiveMessageMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSendMessageMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                io.grpc.examples.messaging.MessageRequest,
                io.grpc.examples.messaging.MessageResponse>(
                  this, METHODID_SEND_MESSAGE)))
          .addMethod(
            getSendReceiveMessageMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                io.grpc.examples.messaging.MessageRequest,
                io.grpc.examples.messaging.MessageResponse>(
                  this, METHODID_SEND_RECEIVE_MESSAGE)))
          .build();
    }
  }

  /**
   */
  public static final class MessagingStub extends io.grpc.stub.AbstractStub<MessagingStub> {
    private MessagingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MessagingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MessagingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MessagingStub(channel, callOptions);
    }

    /**
     */
    public void sendMessage(io.grpc.examples.messaging.MessageRequest request,
        io.grpc.stub.StreamObserver<io.grpc.examples.messaging.MessageResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSendMessageMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<io.grpc.examples.messaging.MessageRequest> sendReceiveMessage(
        io.grpc.stub.StreamObserver<io.grpc.examples.messaging.MessageResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getSendReceiveMessageMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class MessagingBlockingStub extends io.grpc.stub.AbstractStub<MessagingBlockingStub> {
    private MessagingBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MessagingBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MessagingBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MessagingBlockingStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.examples.messaging.MessageResponse sendMessage(io.grpc.examples.messaging.MessageRequest request) {
      return blockingUnaryCall(
          getChannel(), getSendMessageMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class MessagingFutureStub extends io.grpc.stub.AbstractStub<MessagingFutureStub> {
    private MessagingFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MessagingFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MessagingFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MessagingFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.examples.messaging.MessageResponse> sendMessage(
        io.grpc.examples.messaging.MessageRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSendMessageMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SEND_MESSAGE = 0;
  private static final int METHODID_SEND_RECEIVE_MESSAGE = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MessagingImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(MessagingImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND_MESSAGE:
          serviceImpl.sendMessage((io.grpc.examples.messaging.MessageRequest) request,
              (io.grpc.stub.StreamObserver<io.grpc.examples.messaging.MessageResponse>) responseObserver);
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
        case METHODID_SEND_RECEIVE_MESSAGE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.sendReceiveMessage(
              (io.grpc.stub.StreamObserver<io.grpc.examples.messaging.MessageResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class MessagingBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MessagingBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return io.grpc.examples.messaging.Messages.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Messaging");
    }
  }

  private static final class MessagingFileDescriptorSupplier
      extends MessagingBaseDescriptorSupplier {
    MessagingFileDescriptorSupplier() {}
  }

  private static final class MessagingMethodDescriptorSupplier
      extends MessagingBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MessagingMethodDescriptorSupplier(String methodName) {
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
      synchronized (MessagingGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MessagingFileDescriptorSupplier())
              .addMethod(getSendMessageMethod())
              .addMethod(getSendReceiveMessageMethod())
              .build();
        }
      }
    }
    return result;
  }
}
