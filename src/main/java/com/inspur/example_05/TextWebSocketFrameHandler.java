package com.inspur.example_05;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

import java.time.LocalDateTime;

/**
 * User: YANG
 * Date: 2019/6/3-15:41
 * Description: No Description
 */
public class TextWebSocketFrameHandler extends SimpleChannelInboundHandler<TextWebSocketFrame>{
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        System.out.println("msg.text -------->:" + msg.text());
        ctx.writeAndFlush(new TextWebSocketFrame(LocalDateTime.now().toString()));
    }
}
