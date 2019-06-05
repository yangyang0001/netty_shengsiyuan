package com.inspur.grpc_proto.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * User: YANG
 * Date: 2019/6/5-13:18
 * Description: No Description
 */
public class StudentServiceServer {

    private static final Logger logger = Logger.getLogger(StudentServiceServer.class.getName());

    private Server server;

    /**
     * 服务器启动方法
     */
    private void start() throws IOException {
    /* The port on which the server should run */
        int port = 8899;
        server = ServerBuilder.forPort(port)
                //添加服务的实现
                .addService(new StudentServiceImpl())
                .build()
                .start();
        logger.info("Server started, listening on " + port);
        //回调钩子
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                //一定要调用 这个 stop()方法！
                StudentServiceServer.this.stop();
                System.err.println("*** server shut down");
            }
        });
    }

    /**
     * 服务终止
     */
    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    /**
     * 服务阻塞到这,等待处理知道Shutdown
     * @throws InterruptedException
     */
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        final StudentServiceServer server = new StudentServiceServer();
        server.start();
        server.blockUntilShutdown();
    }
}
