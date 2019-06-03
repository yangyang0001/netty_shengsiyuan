package com.inspur.example_02;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.UUID;

/**
 * User: YANG
 * Date: 2019/6/2-21:13
 * Description: No Description
 */
public class WebSocketServerHandler extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println("remoteAddress --------->:" + ctx.channel().remoteAddress());
        System.out.println("msg  ------------------>:" + msg);

        String uuid = UUID.randomUUID().toString();
        ctx.writeAndFlush(uuid);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.channel().close();
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.channel().close();
    }
}
