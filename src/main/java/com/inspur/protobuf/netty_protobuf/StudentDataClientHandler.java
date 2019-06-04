package com.inspur.protobuf.netty_protobuf;

import com.inspur.protobuf.StudentData;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * User: YANG
 * Date: 2019/6/3-19:36
 * Description: No Description
 */
public class StudentDataClientHandler extends SimpleChannelInboundHandler<StudentData.Student> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, StudentData.Student msg) throws Exception {
        System.out.println("msg.getName    --------->:" + msg.getName());
        System.out.println("msg.getAge     --------->:" + msg.getAge());
        System.out.println("msg.getAddress --------->:" + msg.getAddress());
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        StudentData.Student student =
                StudentData.Student.newBuilder()
                .setName("杨建伟")
                .setAge(22)
                .setAddress("北京郁花园一里602D")
                .build();
        ctx.writeAndFlush(student);
    }
}
