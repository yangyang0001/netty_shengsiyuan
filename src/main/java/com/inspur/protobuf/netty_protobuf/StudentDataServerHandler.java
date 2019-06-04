package com.inspur.protobuf.netty_protobuf;

import com.inspur.protobuf.StudentData;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * User: YANG
 * Date: 2019/6/3-19:36
 * Description: No Description
 */
public class StudentDataServerHandler extends SimpleChannelInboundHandler<StudentData.Student> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, StudentData.Student msg) throws Exception {
        System.out.println("msg.getName    --------->:" + msg.getName());
        System.out.println("msg.getAge     --------->:" + msg.getAge());
        System.out.println("msg.getAddress --------->:" + msg.getAddress());

        StudentData.Student student = StudentData.Student.newBuilder()
                .mergeFrom(msg)
                .setName("YangJianwei0001")
                .build();

        ctx.writeAndFlush(student);

    }
}
