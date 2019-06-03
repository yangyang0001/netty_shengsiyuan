package com.inspur.example_03;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.internal.StringUtil;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * User: YANG
 * Date: 2019/6/3-11:42
 * Description: No Description
 */
public class ChatClient {

    public static void main(String[] args){
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class)
                    .handler(new ChatClientInitializer());

            ChannelFuture channelFuture = bootstrap.connect("localhost", 8888).sync();

            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = null;
            while(true){
                if(!StringUtil.isNullOrEmpty(line = bufferedReader.readLine())){
                    //这里必须要 加上 \r\n 因为channelPipeline中 用的是 Delimiters.lineDelimiter
                    channelFuture.channel().writeAndFlush(line + "\n");
                }
            }
//          channelFuture.channel().closeFuture().sync();//因为是长连接,进行会话的所以这一行必须要注释掉
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            eventLoopGroup.shutdownGracefully();
        }


    }
}
