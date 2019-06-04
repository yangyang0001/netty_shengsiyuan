package com.inspur.protobuf.netty_protobuf_manymessage;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * User: YANG
 * Date: 2019/6/3-19:36
 * Description: No Description
 */
public class StudentData2Client {

    public static void main(String[] args) {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class)
                    .handler(new StudentData2ClientInitializer());

            ChannelFuture channelFuture = bootstrap.connect("localhost", 9999).sync();
            channelFuture.channel().closeFuture().sync();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            eventLoopGroup.shutdownGracefully();
        }
    }
}
