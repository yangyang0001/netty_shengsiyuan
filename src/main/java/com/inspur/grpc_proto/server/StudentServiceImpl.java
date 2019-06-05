package com.inspur.grpc_proto.server;

import com.inspur.grpc.proto.*;
import com.inspur.grpc.proto.StudentServiceGrpc.StudentServiceImplBase;
import io.grpc.stub.StreamObserver;

import java.util.UUID;

/**
 * User: YANG
 * Date: 2019/6/5-13:13
 * Description: No Description
 */
public class StudentServiceImpl extends StudentServiceImplBase {

    /**
     * rpc GetRealNameByUserName (MyRequest) returns (MyResponse) {}
     * @param request
     * @param responseObserver
     */
    @Override
    public void getRealNameByUserName(MyRequest request, StreamObserver<MyResponse> responseObserver) {
        System.out.println("request param:" + request.getUsername());
        MyResponse response = MyResponse.newBuilder().setRealname(request.getUsername()).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    /**
     * rpc GetStudentByAge(StudentRequest) returns (stream StudentResponse) {} 展示的demo
     * stream就类似与List 在jdk8中的stream()一样!
     */
    @Override
    public void getStudentByAge(StudentRequest request, StreamObserver<StudentResponse> responseObserver) {
        StudentResponse response1 = StudentResponse.newBuilder().setUsername("张三").setAge(22).setCity("北京").build();
        StudentResponse response2 = StudentResponse.newBuilder().setUsername("李四").setAge(22).setCity("北京").build();
        StudentResponse response3 = StudentResponse.newBuilder().setUsername("王五").setAge(22).setCity("北京").build();
        StudentResponse response4 = StudentResponse.newBuilder().setUsername("赵六").setAge(22).setCity("北京").build();
        responseObserver.onNext(response1);
        responseObserver.onNext(response2);
        responseObserver.onNext(response3);
        responseObserver.onNext(response4);
        responseObserver.onCompleted();
    }

    /**
     * rpc GetStudentListByAge(stream StudentRequest) returns (StudentResponseList) {} 展示的demo
     * 返回stream类型的参数的时候就必须要重写StreamObserver
     * @param responseObserver
     * @return
     */
    @Override
    public StreamObserver<StudentRequest> getStudentListByAge(StreamObserver<StudentResponseList> responseObserver) {
        /**
         * 接收客户端的信息
         */
        return new StreamObserver<StudentRequest>() {
            @Override
            public void onNext(StudentRequest value) {
                System.out.println("onNext StudentRequest.getAge:" + value.getAge());
            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            //用这个方法去处理 返回客户端的信息!
            @Override
            public void onCompleted() {
                StudentResponse response1 = StudentResponse.newBuilder().setUsername("张三").setAge(22).setCity("北京").build();
                StudentResponse response2 = StudentResponse.newBuilder().setUsername("李四").setAge(22).setCity("北京").build();
                StudentResponse response3 = StudentResponse.newBuilder().setUsername("王五").setAge(22).setCity("北京").build();
                StudentResponse response4 = StudentResponse.newBuilder().setUsername("赵六").setAge(22).setCity("北京").build();

                //这里的构造方式 要特别小心
                StudentResponseList studentResponseList = StudentResponseList.newBuilder()
                        .addStudentResponse(response1)
                        .addStudentResponse(response2)
                        .addStudentResponse(response3)
                        .addStudentResponse(response4)
                        .build();

                responseObserver.onNext(studentResponseList);
                responseObserver.onCompleted();
            }
        };
    }

    @Override
    public StreamObserver<StreamRequest> binaryStreamTalk(StreamObserver<StreamResponse> responseObserver) {
        return new StreamObserver<StreamRequest>() {
            @Override
            public void onNext(StreamRequest value) {
                System.out.println("onNext StreamRequest.getRequestParam:" + value.getRequestParam());
                //接收到一条消息,返回一条消息(这里通过这种方式处理)
                responseObserver.onNext(StreamResponse.newBuilder().setResponseParam(UUID.randomUUID().toString()).build());
            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onCompleted() {
                //运行完上面的onNext()方法后 就直接 关闭response的 就OK了
                responseObserver.onCompleted();
            }
        };
    }
}
