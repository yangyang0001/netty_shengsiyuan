package com.inspur.example_01;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * User: YANG
 * Date: 2019/6/2-18:48
 * Description: No Description
 */
public class HttpServerHandler extends SimpleChannelInboundHandler<HttpObject> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {
        if(msg instanceof HttpRequest){
            HttpRequest request = (HttpRequest) msg;
            System.out.println("uri ------------------>:" + request.uri());
            System.out.println("methodName ----------->:" + request.method().name());
            getParam(request);
        }

        ByteBuf content = Unpooled.copiedBuffer("Hello World".getBytes(Charset.forName("UTF-8")));
        FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, content);
        response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain");
        response.headers().set(HttpHeaderNames.CONTENT_LENGTH, content.readableBytes());

        ctx.writeAndFlush(response);
        ctx.close();
    }

    private void getParam(HttpRequest request) {
        QueryStringDecoder queryStringDecoder = new QueryStringDecoder(request.uri());
        Map<String, List<String>> paramMap = queryStringDecoder.parameters();
        paramMap.forEach((key, list) -> {
            System.out.println("key ------>:" + key + ", value ------>:" + list.toString());
        });
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println("handlerAdded");
        super.handlerAdded(ctx);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println("handlerRemoved");
        super.handlerRemoved(ctx);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelActive");
        super.channelActive(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelInactive");
        super.channelInactive(ctx);
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelRegistered");
        super.channelRegistered(ctx);

    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelUnregistered");
        super.channelUnregistered(ctx);
    }

    public static void main(String[] args){
        List<String> firstList = Arrays.asList("1", "2", "3");
        List<String> secondList = Arrays.asList("2", "4", "6");
        List<List<String>> list = Arrays.asList(firstList, secondList);
        list.stream().flatMap((theList) -> theList.stream())
                .filter(item -> !(firstList.contains(item) && secondList.contains(item))).forEach(System.out::println);
    }
}
