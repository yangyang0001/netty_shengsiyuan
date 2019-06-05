package com.inspur.grpc.proto;

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
    value = "by gRPC proto compiler (version 1.21.0)",
    comments = "Source: Student.proto")
public final class StudentServiceGrpc {

  private StudentServiceGrpc() {}

  public static final String SERVICE_NAME = "grpc_proto.StudentService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.inspur.grpc.proto.MyRequest,
      com.inspur.grpc.proto.MyResponse> getGetRealNameByUserNameMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRealNameByUserName",
      requestType = com.inspur.grpc.proto.MyRequest.class,
      responseType = com.inspur.grpc.proto.MyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.inspur.grpc.proto.MyRequest,
      com.inspur.grpc.proto.MyResponse> getGetRealNameByUserNameMethod() {
    io.grpc.MethodDescriptor<com.inspur.grpc.proto.MyRequest, com.inspur.grpc.proto.MyResponse> getGetRealNameByUserNameMethod;
    if ((getGetRealNameByUserNameMethod = StudentServiceGrpc.getGetRealNameByUserNameMethod) == null) {
      synchronized (StudentServiceGrpc.class) {
        if ((getGetRealNameByUserNameMethod = StudentServiceGrpc.getGetRealNameByUserNameMethod) == null) {
          StudentServiceGrpc.getGetRealNameByUserNameMethod = getGetRealNameByUserNameMethod = 
              io.grpc.MethodDescriptor.<com.inspur.grpc.proto.MyRequest, com.inspur.grpc.proto.MyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "grpc_proto.StudentService", "GetRealNameByUserName"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.inspur.grpc.proto.MyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.inspur.grpc.proto.MyResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StudentServiceMethodDescriptorSupplier("GetRealNameByUserName"))
                  .build();
          }
        }
     }
     return getGetRealNameByUserNameMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.inspur.grpc.proto.StudentRequest,
      com.inspur.grpc.proto.StudentResponse> getGetStudentByAgeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetStudentByAge",
      requestType = com.inspur.grpc.proto.StudentRequest.class,
      responseType = com.inspur.grpc.proto.StudentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.inspur.grpc.proto.StudentRequest,
      com.inspur.grpc.proto.StudentResponse> getGetStudentByAgeMethod() {
    io.grpc.MethodDescriptor<com.inspur.grpc.proto.StudentRequest, com.inspur.grpc.proto.StudentResponse> getGetStudentByAgeMethod;
    if ((getGetStudentByAgeMethod = StudentServiceGrpc.getGetStudentByAgeMethod) == null) {
      synchronized (StudentServiceGrpc.class) {
        if ((getGetStudentByAgeMethod = StudentServiceGrpc.getGetStudentByAgeMethod) == null) {
          StudentServiceGrpc.getGetStudentByAgeMethod = getGetStudentByAgeMethod = 
              io.grpc.MethodDescriptor.<com.inspur.grpc.proto.StudentRequest, com.inspur.grpc.proto.StudentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "grpc_proto.StudentService", "GetStudentByAge"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.inspur.grpc.proto.StudentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.inspur.grpc.proto.StudentResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StudentServiceMethodDescriptorSupplier("GetStudentByAge"))
                  .build();
          }
        }
     }
     return getGetStudentByAgeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.inspur.grpc.proto.StudentRequest,
      com.inspur.grpc.proto.StudentResponseList> getGetStudentListByAgeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetStudentListByAge",
      requestType = com.inspur.grpc.proto.StudentRequest.class,
      responseType = com.inspur.grpc.proto.StudentResponseList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.inspur.grpc.proto.StudentRequest,
      com.inspur.grpc.proto.StudentResponseList> getGetStudentListByAgeMethod() {
    io.grpc.MethodDescriptor<com.inspur.grpc.proto.StudentRequest, com.inspur.grpc.proto.StudentResponseList> getGetStudentListByAgeMethod;
    if ((getGetStudentListByAgeMethod = StudentServiceGrpc.getGetStudentListByAgeMethod) == null) {
      synchronized (StudentServiceGrpc.class) {
        if ((getGetStudentListByAgeMethod = StudentServiceGrpc.getGetStudentListByAgeMethod) == null) {
          StudentServiceGrpc.getGetStudentListByAgeMethod = getGetStudentListByAgeMethod = 
              io.grpc.MethodDescriptor.<com.inspur.grpc.proto.StudentRequest, com.inspur.grpc.proto.StudentResponseList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "grpc_proto.StudentService", "GetStudentListByAge"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.inspur.grpc.proto.StudentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.inspur.grpc.proto.StudentResponseList.getDefaultInstance()))
                  .setSchemaDescriptor(new StudentServiceMethodDescriptorSupplier("GetStudentListByAge"))
                  .build();
          }
        }
     }
     return getGetStudentListByAgeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.inspur.grpc.proto.StreamRequest,
      com.inspur.grpc.proto.StreamResponse> getBinaryStreamTalkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BinaryStreamTalk",
      requestType = com.inspur.grpc.proto.StreamRequest.class,
      responseType = com.inspur.grpc.proto.StreamResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.inspur.grpc.proto.StreamRequest,
      com.inspur.grpc.proto.StreamResponse> getBinaryStreamTalkMethod() {
    io.grpc.MethodDescriptor<com.inspur.grpc.proto.StreamRequest, com.inspur.grpc.proto.StreamResponse> getBinaryStreamTalkMethod;
    if ((getBinaryStreamTalkMethod = StudentServiceGrpc.getBinaryStreamTalkMethod) == null) {
      synchronized (StudentServiceGrpc.class) {
        if ((getBinaryStreamTalkMethod = StudentServiceGrpc.getBinaryStreamTalkMethod) == null) {
          StudentServiceGrpc.getBinaryStreamTalkMethod = getBinaryStreamTalkMethod = 
              io.grpc.MethodDescriptor.<com.inspur.grpc.proto.StreamRequest, com.inspur.grpc.proto.StreamResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "grpc_proto.StudentService", "BinaryStreamTalk"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.inspur.grpc.proto.StreamRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.inspur.grpc.proto.StreamResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StudentServiceMethodDescriptorSupplier("BinaryStreamTalk"))
                  .build();
          }
        }
     }
     return getBinaryStreamTalkMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static StudentServiceStub newStub(io.grpc.Channel channel) {
    return new StudentServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static StudentServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new StudentServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static StudentServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new StudentServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class StudentServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getRealNameByUserName(com.inspur.grpc.proto.MyRequest request,
        io.grpc.stub.StreamObserver<com.inspur.grpc.proto.MyResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetRealNameByUserNameMethod(), responseObserver);
    }

    /**
     * <pre>
     * 展示 stream 的 使用和 传递简单的 入参
     * 在grpc 中的 参数必须是 message类型的 ,grpc 请求和相依必须是 message类型的
     * 这里的int32 会抛出异常(编译的时候):
     * rpc GetStudentByAge(int32) returns (stream StudentResponse) {}
     * 这个 thrift 的设计理念是完全不同的
     * </pre>
     */
    public void getStudentByAge(com.inspur.grpc.proto.StudentRequest request,
        io.grpc.stub.StreamObserver<com.inspur.grpc.proto.StudentResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetStudentByAgeMethod(), responseObserver);
    }

    /**
     * <pre>
     * 请求参数为stream 返回为 message(这里为集合的方式)
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.inspur.grpc.proto.StudentRequest> getStudentListByAge(
        io.grpc.stub.StreamObserver<com.inspur.grpc.proto.StudentResponseList> responseObserver) {
      return asyncUnimplementedStreamingCall(getGetStudentListByAgeMethod(), responseObserver);
    }

    /**
     * <pre>
     * 请求参数为stream 返回为 stream
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.inspur.grpc.proto.StreamRequest> binaryStreamTalk(
        io.grpc.stub.StreamObserver<com.inspur.grpc.proto.StreamResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getBinaryStreamTalkMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetRealNameByUserNameMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.inspur.grpc.proto.MyRequest,
                com.inspur.grpc.proto.MyResponse>(
                  this, METHODID_GET_REAL_NAME_BY_USER_NAME)))
          .addMethod(
            getGetStudentByAgeMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.inspur.grpc.proto.StudentRequest,
                com.inspur.grpc.proto.StudentResponse>(
                  this, METHODID_GET_STUDENT_BY_AGE)))
          .addMethod(
            getGetStudentListByAgeMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                com.inspur.grpc.proto.StudentRequest,
                com.inspur.grpc.proto.StudentResponseList>(
                  this, METHODID_GET_STUDENT_LIST_BY_AGE)))
          .addMethod(
            getBinaryStreamTalkMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.inspur.grpc.proto.StreamRequest,
                com.inspur.grpc.proto.StreamResponse>(
                  this, METHODID_BINARY_STREAM_TALK)))
          .build();
    }
  }

  /**
   */
  public static final class StudentServiceStub extends io.grpc.stub.AbstractStub<StudentServiceStub> {
    private StudentServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StudentServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StudentServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StudentServiceStub(channel, callOptions);
    }

    /**
     */
    public void getRealNameByUserName(com.inspur.grpc.proto.MyRequest request,
        io.grpc.stub.StreamObserver<com.inspur.grpc.proto.MyResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetRealNameByUserNameMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 展示 stream 的 使用和 传递简单的 入参
     * 在grpc 中的 参数必须是 message类型的 ,grpc 请求和相依必须是 message类型的
     * 这里的int32 会抛出异常(编译的时候):
     * rpc GetStudentByAge(int32) returns (stream StudentResponse) {}
     * 这个 thrift 的设计理念是完全不同的
     * </pre>
     */
    public void getStudentByAge(com.inspur.grpc.proto.StudentRequest request,
        io.grpc.stub.StreamObserver<com.inspur.grpc.proto.StudentResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetStudentByAgeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 请求参数为stream 返回为 message(这里为集合的方式)
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.inspur.grpc.proto.StudentRequest> getStudentListByAge(
        io.grpc.stub.StreamObserver<com.inspur.grpc.proto.StudentResponseList> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getGetStudentListByAgeMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * 请求参数为stream 返回为 stream
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.inspur.grpc.proto.StreamRequest> binaryStreamTalk(
        io.grpc.stub.StreamObserver<com.inspur.grpc.proto.StreamResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getBinaryStreamTalkMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class StudentServiceBlockingStub extends io.grpc.stub.AbstractStub<StudentServiceBlockingStub> {
    private StudentServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StudentServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StudentServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StudentServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.inspur.grpc.proto.MyResponse getRealNameByUserName(com.inspur.grpc.proto.MyRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetRealNameByUserNameMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * 展示 stream 的 使用和 传递简单的 入参
     * 在grpc 中的 参数必须是 message类型的 ,grpc 请求和相依必须是 message类型的
     * 这里的int32 会抛出异常(编译的时候):
     * rpc GetStudentByAge(int32) returns (stream StudentResponse) {}
     * 这个 thrift 的设计理念是完全不同的
     * </pre>
     */
    public java.util.Iterator<com.inspur.grpc.proto.StudentResponse> getStudentByAge(
        com.inspur.grpc.proto.StudentRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetStudentByAgeMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class StudentServiceFutureStub extends io.grpc.stub.AbstractStub<StudentServiceFutureStub> {
    private StudentServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StudentServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StudentServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StudentServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.inspur.grpc.proto.MyResponse> getRealNameByUserName(
        com.inspur.grpc.proto.MyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetRealNameByUserNameMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_REAL_NAME_BY_USER_NAME = 0;
  private static final int METHODID_GET_STUDENT_BY_AGE = 1;
  private static final int METHODID_GET_STUDENT_LIST_BY_AGE = 2;
  private static final int METHODID_BINARY_STREAM_TALK = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final StudentServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(StudentServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_REAL_NAME_BY_USER_NAME:
          serviceImpl.getRealNameByUserName((com.inspur.grpc.proto.MyRequest) request,
              (io.grpc.stub.StreamObserver<com.inspur.grpc.proto.MyResponse>) responseObserver);
          break;
        case METHODID_GET_STUDENT_BY_AGE:
          serviceImpl.getStudentByAge((com.inspur.grpc.proto.StudentRequest) request,
              (io.grpc.stub.StreamObserver<com.inspur.grpc.proto.StudentResponse>) responseObserver);
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
        case METHODID_GET_STUDENT_LIST_BY_AGE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getStudentListByAge(
              (io.grpc.stub.StreamObserver<com.inspur.grpc.proto.StudentResponseList>) responseObserver);
        case METHODID_BINARY_STREAM_TALK:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.binaryStreamTalk(
              (io.grpc.stub.StreamObserver<com.inspur.grpc.proto.StreamResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class StudentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    StudentServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.inspur.grpc.proto.StudentProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("StudentService");
    }
  }

  private static final class StudentServiceFileDescriptorSupplier
      extends StudentServiceBaseDescriptorSupplier {
    StudentServiceFileDescriptorSupplier() {}
  }

  private static final class StudentServiceMethodDescriptorSupplier
      extends StudentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    StudentServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (StudentServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new StudentServiceFileDescriptorSupplier())
              .addMethod(getGetRealNameByUserNameMethod())
              .addMethod(getGetStudentByAgeMethod())
              .addMethod(getGetStudentListByAgeMethod())
              .addMethod(getBinaryStreamTalkMethod())
              .build();
        }
      }
    }
    return result;
  }
}
