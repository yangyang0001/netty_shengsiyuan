package com.inspur.example_04;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * User: YANG
 * Date: 2019/6/3-13:21
 * Description: No Description
 */
public class MyHeartServerHandler extends ChannelInboundHandlerAdapter {

    //重写这个方法来 模拟心跳检测的 测试! 使用 example_03中的客户端 链接来测试就OK了
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if(evt instanceof IdleStateEvent){
            IdleStateEvent event = (IdleStateEvent) evt;

            String eventType = null;
            switch (event.state()){
                case READER_IDLE:
                    eventType = "读空闲";
                    break;
                case WRITER_IDLE:
                    eventType = "写空闲";
                    break;
                case ALL_IDLE:
                    eventType = "读写空闲";
                    break;
            }
            System.out.println(ctx.channel().remoteAddress() + "超时事件:" + eventType);
            ctx.channel().close();
        }
    }
}

