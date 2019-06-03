package com.inspur.example_05;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * User: YANG
 * Date: 2019/6/3-15:41
 * Description: No Description
 */
public class TextWebSocketFrameInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline channelPipeline = ch.pipeline();

        channelPipeline.addLast(new HttpServerCodec());
        channelPipeline.addLast(new ChunkedWriteHandler());
        //必须加入 这个Handler HttpObjectAggregator 否则 会 编程 Http
        channelPipeline.addLast(new HttpObjectAggregator(8192));
        // 访问的 路径 以 /ws结尾
        channelPipeline.addLast(new WebSocketServerProtocolHandler("/ws"));

        channelPipeline.addLast(new TextWebSocketFrameHandler());

    }
}
