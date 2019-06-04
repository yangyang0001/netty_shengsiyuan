package com.inspur.protobuf.netty_protobuf_manymessage;

import com.inspur.protobuf.StudentData2;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;

/**
 * User: YANG
 * Date: 2019/6/3-19:36
 * Description: No Description
 */
public class StudentData2ClientInitializer extends ChannelInitializer<SocketChannel>{
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline channelPipeline = ch.pipeline();

        //解码器，通过Google Protocol Buffers序列化框架动态的切割接收到的ByteBuf
        channelPipeline.addLast(new ProtobufVarint32FrameDecoder());
        //服务器端接收的是客户端RequestUser对象，所以这边将接收对象进行解码生产实列
        channelPipeline.addLast(new ProtobufDecoder(StudentData2.StudentObject.getDefaultInstance()));
        //Google Protocol Buffers编码器
        channelPipeline.addLast(new ProtobufVarint32LengthFieldPrepender());
        //Google Protocol Buffers编码器
        channelPipeline.addLast(new ProtobufEncoder());

        channelPipeline.addLast(new StudentData2ClientHandler());
    }
}
