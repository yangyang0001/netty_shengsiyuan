package com.inspur.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;

/**
 * User: YANG
 * Date: 2019/6/3-19:02
 * Description: No Description
 * 1.首先构造一个对象
 * 2.将对象放入字节数组中
 * 3.将字节数组的数据还原出来
 */
public class StudentDataTest {

    public static void main(String[] args){

        //首先构造出来一个对象
        StudentData.Student student =
                StudentData.Student.newBuilder()
                .setName("Yang")
                .setAge(18)
                .setAddress("北京郁花园一里602D")
                .build();

        System.out.println("student.getName    ----------->:" + student.getName());
        System.out.println("student.getAge     ----------->:" + student.getAge());
        System.out.println("student.getAddress ----------->:" + student.getAddress());
        System.out.println("-------------------------------------------------------");

        //2.将对象放入自己数组中
        byte[] bytes = student.toByteArray();

        //3.将数组中的数据还原出来
        try {
            StudentData.Student student1 = StudentData.Student.parseFrom(bytes);
            System.out.println("student1.getName    ----------->:" + student1.getName());
            System.out.println("student1.getAge     ----------->:" + student1.getAge());
            System.out.println("student1.getAddress ----------->:" + student1.getAddress());
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }

    }
}
