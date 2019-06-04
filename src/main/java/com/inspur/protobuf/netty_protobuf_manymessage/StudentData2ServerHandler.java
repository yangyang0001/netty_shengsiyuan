package com.inspur.protobuf.netty_protobuf_manymessage;

import com.inspur.protobuf.StudentData2;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * User: YANG
 * Date: 2019/6/3-19:36
 * Description: No Description
 */
public class StudentData2ServerHandler extends SimpleChannelInboundHandler<StudentData2.StudentObject> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, StudentData2.StudentObject msg) throws Exception {
        if(msg.getStudentType() == StudentData2.StudentType.StudentType1){
            System.out.println(msg.getStudentType());
            StudentData2.Student student = msg.getStudent();
            System.out.println("student.getName    ---------->:" + student.getName());
            System.out.println("student.getAge     ---------->:" + student.getAge());
            System.out.println("student.getAddress ---------->:" + student.getAddress());
        } else {
            System.out.println(msg.getStudentType());
            StudentData2.Student2 student2 = msg.getStudent2();
            System.out.println("student2.getName     ---------------->:" + student2.getName());
            System.out.println("student2.getAge      ---------------->:" + student2.getAge());
            System.out.println("student2.getPassword ---------------->:" + student2.getPassword());
        }
    }
}
