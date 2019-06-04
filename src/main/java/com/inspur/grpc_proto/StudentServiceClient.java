/*
 * Copyright 2015 The gRPC Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.inspur.grpc_proto;

import com.inspur.grpc.proto.MyRequest;
import com.inspur.grpc.proto.MyResponse;
import com.inspur.grpc.proto.StudentServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A simple client that requests a greeting from the {@link StudentServiceServer}.
 */
public class StudentServiceClient {
  private static final Logger logger = Logger.getLogger(StudentServiceClient.class.getName());

  private final ManagedChannel channel;
  private final StudentServiceGrpc.StudentServiceBlockingStub blockingStub;

  /** Construct client connecting to HelloWorld server at {@code host:port}. */
  public StudentServiceClient(String host, int port) {
    this(ManagedChannelBuilder.forAddress(host, port)
        // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
        // needing certificates.
        .usePlaintext()
        .build());
  }

  /** Construct client for accessing HelloWorld server using the existing channel. */
  StudentServiceClient(ManagedChannel channel) {
    this.channel = channel;
    blockingStub = StudentServiceGrpc.newBlockingStub(channel);
  }

  public void shutdown() throws InterruptedException {
    channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
  }

  /** Say hello to server. */
  public void getRealNameByUserName(String userName) {
    logger.info("Will try to getRealNameByUserName " + userName + " ...");
    MyRequest request = MyRequest.newBuilder().setUsername(userName).build();
    MyResponse response;
    try {
      response = blockingStub.getRealNameByUserName(request);
    } catch (StatusRuntimeException e) {
      logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
      return;
    }
    logger.info("getRealName: " + response.getRealname());
  }

  /**
   * Greet server. If provided, the first element of {@code args} is the name to use in the
   * greeting.
   */
  public static void main(String[] args) throws Exception {
    StudentServiceClient client = new StudentServiceClient("localhost", 8899);
    try {
      /* Access a service running on the local machine on port 8899 */
      String userName = "YangYang001";
      if (args.length > 0) {
        userName = args[0]; /* Use the arg as the name to greet if provided */
      }
      client.getRealNameByUserName(userName);

    } finally {
      client.shutdown();
    }
  }
}
