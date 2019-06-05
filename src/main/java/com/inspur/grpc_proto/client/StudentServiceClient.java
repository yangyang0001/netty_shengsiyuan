package com.inspur.grpc_proto.client;

import com.inspur.grpc.proto.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * User: YANG
 * Date: 2019/6/5-13:25
 * Description: No Description
 */
public class StudentServiceClient {
    private static final Logger logger = Logger.getLogger(StudentServiceClient.class.getName());

    private final ManagedChannel channel;
    private final StudentServiceGrpc.StudentServiceBlockingStub blockingStub;
    //异步的stub
    private final StudentServiceGrpc.StudentServiceStub stub;

    /**
     * Construct client connecting to HelloWorld server at {@code host:port}.
     */
    public StudentServiceClient(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port)
                // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
                // needing certificates.
                .usePlaintext()
                .build());
    }

    /**
     * Construct client for accessing HelloWorld server using the existing channel.
     */
    StudentServiceClient(ManagedChannel channel) {
        this.channel = channel;
        blockingStub = StudentServiceGrpc.newBlockingStub(channel);
        stub = StudentServiceGrpc.newStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    /**
     * GetRealNameByUserName to server. 对应service中的第一个方法
     */
    public void getRealNameByUserName(String userName) {
        MyRequest request = MyRequest.newBuilder().setUsername(userName).build();
        MyResponse response;
        try {
            response = blockingStub.getRealNameByUserName(request);
        } catch (StatusRuntimeException e) {
            return;
        }
        System.out.println("getRealNameByUserName: " + response.getRealname());
    }

    /**
     * GetStudentByAge to server. 对应service中的第二个方法
     */
    public void getStudentByAge(int age){
        StudentRequest request = StudentRequest.newBuilder().setAge(age).build();
        Iterator<StudentResponse> iterator = blockingStub.getStudentByAge(request);
        while(iterator.hasNext()){
            StudentResponse response = iterator.next();
            System.out.println("username:" + response.getUsername() + ",age:" + response.getAge() + ",city:" + response.getCity());
        }
    }

    //和传统的方式是有区别的(整好相反,只是通过 onNext 处理接收到数据), 只要 client 以stream 的方式向 server端发送数据 进行请求 就是异步的!
    public void getStudentListByAge() throws InterruptedException {

        /**
         * 这个用来接收服务端 返回的数据
         */
        StreamObserver<StudentResponseList> responseStreamObserver = new StreamObserver<StudentResponseList>() {
            //用来接收 服务端 返回的数据的方法 onNext()
            @Override
            public void onNext(StudentResponseList value) {
                value.getStudentResponseList().stream().forEach(studentResponse -> {
                    System.out.println("username:" + studentResponse.getUsername() + ",age:" + studentResponse.getAge() + ",city:" + studentResponse.getCity());
                });
            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }
        };

        /**
         * 这个用来发送 数据 (这里的数据是写死的 ), stub 是异步的 (client端 发送 stream类型的数据向 server端的时候就是异步的)
         */
        StreamObserver<StudentRequest> requestStreamObserver = stub.getStudentListByAge(responseStreamObserver);
        StudentRequest request1 = StudentRequest.newBuilder().setAge(10).build();
        StudentRequest request2 = StudentRequest.newBuilder().setAge(12).build();
        StudentRequest request3 = StudentRequest.newBuilder().setAge(14).build();
        requestStreamObserver.onNext(request1);
        requestStreamObserver.onNext(request2);
        requestStreamObserver.onNext(request3);
        requestStreamObserver.onCompleted();

        Thread.sleep(5000);

    }

    /**
     * 双向stream的交互
     */
    public void binaryStreamTalk () throws InterruptedException {
        /**
         * 接收数据
         */
        StreamObserver<StreamResponse> responseStreamObserver = new StreamObserver<StreamResponse>() {
            @Override
            public void onNext(StreamResponse value) {
                System.out.println(value.getResponseParam());
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {

            }
        };

        /**
         * 发送数据
         */
        StreamObserver<StreamRequest> requestStreamObserver = stub.binaryStreamTalk(responseStreamObserver);
        for(int i = 0; i < 10; i++){
            requestStreamObserver.onNext(StreamRequest.newBuilder().setRequestParam(LocalDateTime.now().toString()).build());
            Thread.sleep(1000);
        }

    }




    /**
     * Greet server. If provided, the first element of {@code args} is the name to use in the
     * greeting.
     */
    public static void main(String[] args) throws Exception {
        StudentServiceClient client = new StudentServiceClient("localhost", 8899);
        //测试第一个 service类型的方法 rpc GetRealNameByUserName (MyRequest) returns (MyResponse) {}
//        String userName = "YangYang001";
//        client.getRealNameByUserName(userName);
//        System.out.println("----------------------------------------------------------------------------------");

        //测试第二个 service类型的方法 rpc GetStudentByAge(StudentRequest) returns (stream StudentResponse) {}
//        client.getStudentByAge(22);
//        System.out.println("----------------------------------------------------------------------------------");

        //测试第三个 service类型的方法 rpc GetStudentListByAge(stream StudentRequest) returns (StudentResponseList) {}
//        client.getStudentListByAge();

        client.binaryStreamTalk();

        client.shutdown();
    }
}
