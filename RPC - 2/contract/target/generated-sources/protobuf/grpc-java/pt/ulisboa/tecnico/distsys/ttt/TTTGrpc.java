package pt.ulisboa.tecnico.distsys.ttt;

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
    value = "by gRPC proto compiler (version 1.28.0)",
    comments = "Source: tttgame.proto")
public final class TTTGrpc {

  private TTTGrpc() {}

  public static final String SERVICE_NAME = "pt.ulisboa.tecnico.distsys.ttt.TTT";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<pt.ulisboa.tecnico.distsys.ttt.CurrentBoardRequest,
      pt.ulisboa.tecnico.distsys.ttt.CurrentBoardResponse> getCurrentBoardMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CurrentBoard",
      requestType = pt.ulisboa.tecnico.distsys.ttt.CurrentBoardRequest.class,
      responseType = pt.ulisboa.tecnico.distsys.ttt.CurrentBoardResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<pt.ulisboa.tecnico.distsys.ttt.CurrentBoardRequest,
      pt.ulisboa.tecnico.distsys.ttt.CurrentBoardResponse> getCurrentBoardMethod() {
    io.grpc.MethodDescriptor<pt.ulisboa.tecnico.distsys.ttt.CurrentBoardRequest, pt.ulisboa.tecnico.distsys.ttt.CurrentBoardResponse> getCurrentBoardMethod;
    if ((getCurrentBoardMethod = TTTGrpc.getCurrentBoardMethod) == null) {
      synchronized (TTTGrpc.class) {
        if ((getCurrentBoardMethod = TTTGrpc.getCurrentBoardMethod) == null) {
          TTTGrpc.getCurrentBoardMethod = getCurrentBoardMethod =
              io.grpc.MethodDescriptor.<pt.ulisboa.tecnico.distsys.ttt.CurrentBoardRequest, pt.ulisboa.tecnico.distsys.ttt.CurrentBoardResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CurrentBoard"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pt.ulisboa.tecnico.distsys.ttt.CurrentBoardRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pt.ulisboa.tecnico.distsys.ttt.CurrentBoardResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TTTMethodDescriptorSupplier("CurrentBoard"))
              .build();
        }
      }
    }
    return getCurrentBoardMethod;
  }

  private static volatile io.grpc.MethodDescriptor<pt.ulisboa.tecnico.distsys.ttt.PlayRequest,
      pt.ulisboa.tecnico.distsys.ttt.PlayResponse> getPlayMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Play",
      requestType = pt.ulisboa.tecnico.distsys.ttt.PlayRequest.class,
      responseType = pt.ulisboa.tecnico.distsys.ttt.PlayResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<pt.ulisboa.tecnico.distsys.ttt.PlayRequest,
      pt.ulisboa.tecnico.distsys.ttt.PlayResponse> getPlayMethod() {
    io.grpc.MethodDescriptor<pt.ulisboa.tecnico.distsys.ttt.PlayRequest, pt.ulisboa.tecnico.distsys.ttt.PlayResponse> getPlayMethod;
    if ((getPlayMethod = TTTGrpc.getPlayMethod) == null) {
      synchronized (TTTGrpc.class) {
        if ((getPlayMethod = TTTGrpc.getPlayMethod) == null) {
          TTTGrpc.getPlayMethod = getPlayMethod =
              io.grpc.MethodDescriptor.<pt.ulisboa.tecnico.distsys.ttt.PlayRequest, pt.ulisboa.tecnico.distsys.ttt.PlayResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Play"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pt.ulisboa.tecnico.distsys.ttt.PlayRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pt.ulisboa.tecnico.distsys.ttt.PlayResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TTTMethodDescriptorSupplier("Play"))
              .build();
        }
      }
    }
    return getPlayMethod;
  }

  private static volatile io.grpc.MethodDescriptor<pt.ulisboa.tecnico.distsys.ttt.CheckWinnerRequest,
      pt.ulisboa.tecnico.distsys.ttt.CheckWinnerResponse> getCheckWinnerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CheckWinner",
      requestType = pt.ulisboa.tecnico.distsys.ttt.CheckWinnerRequest.class,
      responseType = pt.ulisboa.tecnico.distsys.ttt.CheckWinnerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<pt.ulisboa.tecnico.distsys.ttt.CheckWinnerRequest,
      pt.ulisboa.tecnico.distsys.ttt.CheckWinnerResponse> getCheckWinnerMethod() {
    io.grpc.MethodDescriptor<pt.ulisboa.tecnico.distsys.ttt.CheckWinnerRequest, pt.ulisboa.tecnico.distsys.ttt.CheckWinnerResponse> getCheckWinnerMethod;
    if ((getCheckWinnerMethod = TTTGrpc.getCheckWinnerMethod) == null) {
      synchronized (TTTGrpc.class) {
        if ((getCheckWinnerMethod = TTTGrpc.getCheckWinnerMethod) == null) {
          TTTGrpc.getCheckWinnerMethod = getCheckWinnerMethod =
              io.grpc.MethodDescriptor.<pt.ulisboa.tecnico.distsys.ttt.CheckWinnerRequest, pt.ulisboa.tecnico.distsys.ttt.CheckWinnerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CheckWinner"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pt.ulisboa.tecnico.distsys.ttt.CheckWinnerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pt.ulisboa.tecnico.distsys.ttt.CheckWinnerResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TTTMethodDescriptorSupplier("CheckWinner"))
              .build();
        }
      }
    }
    return getCheckWinnerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<pt.ulisboa.tecnico.distsys.ttt.InfoRequest,
      pt.ulisboa.tecnico.distsys.ttt.InfoResponse> getInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Info",
      requestType = pt.ulisboa.tecnico.distsys.ttt.InfoRequest.class,
      responseType = pt.ulisboa.tecnico.distsys.ttt.InfoResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<pt.ulisboa.tecnico.distsys.ttt.InfoRequest,
      pt.ulisboa.tecnico.distsys.ttt.InfoResponse> getInfoMethod() {
    io.grpc.MethodDescriptor<pt.ulisboa.tecnico.distsys.ttt.InfoRequest, pt.ulisboa.tecnico.distsys.ttt.InfoResponse> getInfoMethod;
    if ((getInfoMethod = TTTGrpc.getInfoMethod) == null) {
      synchronized (TTTGrpc.class) {
        if ((getInfoMethod = TTTGrpc.getInfoMethod) == null) {
          TTTGrpc.getInfoMethod = getInfoMethod =
              io.grpc.MethodDescriptor.<pt.ulisboa.tecnico.distsys.ttt.InfoRequest, pt.ulisboa.tecnico.distsys.ttt.InfoResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Info"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pt.ulisboa.tecnico.distsys.ttt.InfoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pt.ulisboa.tecnico.distsys.ttt.InfoResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TTTMethodDescriptorSupplier("Info"))
              .build();
        }
      }
    }
    return getInfoMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TTTStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TTTStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TTTStub>() {
        @java.lang.Override
        public TTTStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TTTStub(channel, callOptions);
        }
      };
    return TTTStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TTTBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TTTBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TTTBlockingStub>() {
        @java.lang.Override
        public TTTBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TTTBlockingStub(channel, callOptions);
        }
      };
    return TTTBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TTTFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TTTFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TTTFutureStub>() {
        @java.lang.Override
        public TTTFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TTTFutureStub(channel, callOptions);
        }
      };
    return TTTFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class TTTImplBase implements io.grpc.BindableService {

    /**
     */
    public void currentBoard(pt.ulisboa.tecnico.distsys.ttt.CurrentBoardRequest request,
        io.grpc.stub.StreamObserver<pt.ulisboa.tecnico.distsys.ttt.CurrentBoardResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCurrentBoardMethod(), responseObserver);
    }

    /**
     */
    public void play(pt.ulisboa.tecnico.distsys.ttt.PlayRequest request,
        io.grpc.stub.StreamObserver<pt.ulisboa.tecnico.distsys.ttt.PlayResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getPlayMethod(), responseObserver);
    }

    /**
     */
    public void checkWinner(pt.ulisboa.tecnico.distsys.ttt.CheckWinnerRequest request,
        io.grpc.stub.StreamObserver<pt.ulisboa.tecnico.distsys.ttt.CheckWinnerResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCheckWinnerMethod(), responseObserver);
    }

    /**
     */
    public void info(pt.ulisboa.tecnico.distsys.ttt.InfoRequest request,
        io.grpc.stub.StreamObserver<pt.ulisboa.tecnico.distsys.ttt.InfoResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getInfoMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCurrentBoardMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                pt.ulisboa.tecnico.distsys.ttt.CurrentBoardRequest,
                pt.ulisboa.tecnico.distsys.ttt.CurrentBoardResponse>(
                  this, METHODID_CURRENT_BOARD)))
          .addMethod(
            getPlayMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                pt.ulisboa.tecnico.distsys.ttt.PlayRequest,
                pt.ulisboa.tecnico.distsys.ttt.PlayResponse>(
                  this, METHODID_PLAY)))
          .addMethod(
            getCheckWinnerMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                pt.ulisboa.tecnico.distsys.ttt.CheckWinnerRequest,
                pt.ulisboa.tecnico.distsys.ttt.CheckWinnerResponse>(
                  this, METHODID_CHECK_WINNER)))
          .addMethod(
            getInfoMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                pt.ulisboa.tecnico.distsys.ttt.InfoRequest,
                pt.ulisboa.tecnico.distsys.ttt.InfoResponse>(
                  this, METHODID_INFO)))
          .build();
    }
  }

  /**
   */
  public static final class TTTStub extends io.grpc.stub.AbstractAsyncStub<TTTStub> {
    private TTTStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TTTStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TTTStub(channel, callOptions);
    }

    /**
     */
    public void currentBoard(pt.ulisboa.tecnico.distsys.ttt.CurrentBoardRequest request,
        io.grpc.stub.StreamObserver<pt.ulisboa.tecnico.distsys.ttt.CurrentBoardResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCurrentBoardMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void play(pt.ulisboa.tecnico.distsys.ttt.PlayRequest request,
        io.grpc.stub.StreamObserver<pt.ulisboa.tecnico.distsys.ttt.PlayResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPlayMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void checkWinner(pt.ulisboa.tecnico.distsys.ttt.CheckWinnerRequest request,
        io.grpc.stub.StreamObserver<pt.ulisboa.tecnico.distsys.ttt.CheckWinnerResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCheckWinnerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void info(pt.ulisboa.tecnico.distsys.ttt.InfoRequest request,
        io.grpc.stub.StreamObserver<pt.ulisboa.tecnico.distsys.ttt.InfoResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getInfoMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class TTTBlockingStub extends io.grpc.stub.AbstractBlockingStub<TTTBlockingStub> {
    private TTTBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TTTBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TTTBlockingStub(channel, callOptions);
    }

    /**
     */
    public pt.ulisboa.tecnico.distsys.ttt.CurrentBoardResponse currentBoard(pt.ulisboa.tecnico.distsys.ttt.CurrentBoardRequest request) {
      return blockingUnaryCall(
          getChannel(), getCurrentBoardMethod(), getCallOptions(), request);
    }

    /**
     */
    public pt.ulisboa.tecnico.distsys.ttt.PlayResponse play(pt.ulisboa.tecnico.distsys.ttt.PlayRequest request) {
      return blockingUnaryCall(
          getChannel(), getPlayMethod(), getCallOptions(), request);
    }

    /**
     */
    public pt.ulisboa.tecnico.distsys.ttt.CheckWinnerResponse checkWinner(pt.ulisboa.tecnico.distsys.ttt.CheckWinnerRequest request) {
      return blockingUnaryCall(
          getChannel(), getCheckWinnerMethod(), getCallOptions(), request);
    }

    /**
     */
    public pt.ulisboa.tecnico.distsys.ttt.InfoResponse info(pt.ulisboa.tecnico.distsys.ttt.InfoRequest request) {
      return blockingUnaryCall(
          getChannel(), getInfoMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class TTTFutureStub extends io.grpc.stub.AbstractFutureStub<TTTFutureStub> {
    private TTTFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TTTFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TTTFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<pt.ulisboa.tecnico.distsys.ttt.CurrentBoardResponse> currentBoard(
        pt.ulisboa.tecnico.distsys.ttt.CurrentBoardRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCurrentBoardMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<pt.ulisboa.tecnico.distsys.ttt.PlayResponse> play(
        pt.ulisboa.tecnico.distsys.ttt.PlayRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getPlayMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<pt.ulisboa.tecnico.distsys.ttt.CheckWinnerResponse> checkWinner(
        pt.ulisboa.tecnico.distsys.ttt.CheckWinnerRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCheckWinnerMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<pt.ulisboa.tecnico.distsys.ttt.InfoResponse> info(
        pt.ulisboa.tecnico.distsys.ttt.InfoRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getInfoMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CURRENT_BOARD = 0;
  private static final int METHODID_PLAY = 1;
  private static final int METHODID_CHECK_WINNER = 2;
  private static final int METHODID_INFO = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TTTImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TTTImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CURRENT_BOARD:
          serviceImpl.currentBoard((pt.ulisboa.tecnico.distsys.ttt.CurrentBoardRequest) request,
              (io.grpc.stub.StreamObserver<pt.ulisboa.tecnico.distsys.ttt.CurrentBoardResponse>) responseObserver);
          break;
        case METHODID_PLAY:
          serviceImpl.play((pt.ulisboa.tecnico.distsys.ttt.PlayRequest) request,
              (io.grpc.stub.StreamObserver<pt.ulisboa.tecnico.distsys.ttt.PlayResponse>) responseObserver);
          break;
        case METHODID_CHECK_WINNER:
          serviceImpl.checkWinner((pt.ulisboa.tecnico.distsys.ttt.CheckWinnerRequest) request,
              (io.grpc.stub.StreamObserver<pt.ulisboa.tecnico.distsys.ttt.CheckWinnerResponse>) responseObserver);
          break;
        case METHODID_INFO:
          serviceImpl.info((pt.ulisboa.tecnico.distsys.ttt.InfoRequest) request,
              (io.grpc.stub.StreamObserver<pt.ulisboa.tecnico.distsys.ttt.InfoResponse>) responseObserver);
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

  private static abstract class TTTBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TTTBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return pt.ulisboa.tecnico.distsys.ttt.Tttgame.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TTT");
    }
  }

  private static final class TTTFileDescriptorSupplier
      extends TTTBaseDescriptorSupplier {
    TTTFileDescriptorSupplier() {}
  }

  private static final class TTTMethodDescriptorSupplier
      extends TTTBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TTTMethodDescriptorSupplier(String methodName) {
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
      synchronized (TTTGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TTTFileDescriptorSupplier())
              .addMethod(getCurrentBoardMethod())
              .addMethod(getPlayMethod())
              .addMethod(getCheckWinnerMethod())
              .addMethod(getInfoMethod())
              .build();
        }
      }
    }
    return result;
  }
}
