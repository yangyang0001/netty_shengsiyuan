package com.inspur.example_03;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * User: YANG
 * Date: 2019/6/3-11:15
 * Description: No Description
 * 这里要非常注意 Client 与 Server端进行交互的时候必须要 加上换行符 \r\n 否则发送不成功!
 */
public class MyChatServerHandler extends SimpleChannelInboundHandler<String> {

    private static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        Channel channel = ctx.channel();
        System.out.println("客户端:" + channel.remoteAddress() + " 说--->:" + msg);
        channels.stream().forEach(ch -> {
            if(channel == ch){

            } else {
                ch.writeAndFlush("客户端:" + channel.remoteAddress() + " 说--->:" + msg + "\r\n");
            }
        });
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channels.add(channel);
        channels.stream().forEach(ch -> {
            if(channel == ch){

            } else {
                ch.writeAndFlush(channel.remoteAddress() + "加入链接" + "\r\n");
            }
        });
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channels.stream().forEach(ch -> {
            if(channel == ch){
            } else {
                ch.writeAndFlush(channel.remoteAddress() + "退出链接");
            }
        });
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
