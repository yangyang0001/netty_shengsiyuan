package com.inspur.protobuf.netty_protobuf_manymessage;

import com.inspur.protobuf.StudentData2;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Random;

/**
 * User: YANG
 * Date: 2019/6/3-19:36
 * Description: No Description
 */
public class StudentData2ClientHandler extends SimpleChannelInboundHandler<StudentData2.StudentObject> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, StudentData2.StudentObject msg) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Random random = new Random();
        for(int i = 0; i < 10; i++){
            int index = random.nextInt(10);
            System.out.println(index);
            if(index % 2 == 0){
                StudentData2.Student2 student2 =
                        StudentData2.Student2.newBuilder()
                                .setName("YangJianWei0002")
                                .setAge(18)
                                .setPassword("19900106")
                                .build();

                StudentData2.StudentObject studentObject =
                        StudentData2.StudentObject.newBuilder()
                                .setStudentType(StudentData2.StudentType.StudentType2)
                                .setStudent2(student2)
                                .build();
                ctx.writeAndFlush(studentObject);
            } else {
                StudentData2.Student student =
                        StudentData2.Student.newBuilder()
                                .setName("YangJianWei0001")
                                .setAge(18)
                                .setAddress("郁花园一里602D")
                                .build();

                StudentData2.StudentObject studentObject =
                        StudentData2.StudentObject.newBuilder()
                                .setStudentType(StudentData2.StudentType.StudentType1)
                                .setStudent(student)
                                .build();
                ctx.writeAndFlush(studentObject);
            }
        }

        ctx.flush();
        ctx.close();
    }

}
