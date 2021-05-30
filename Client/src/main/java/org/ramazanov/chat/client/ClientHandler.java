package org.ramazanov.chat.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ClientHandler extends SimpleChannelInboundHandler<String> {
    private Callback onMessageReceivedCallback;

    public ClientHandler(Callback onMessageReceivedCallback) {
        this.onMessageReceivedCallback = onMessageReceivedCallback;
    }


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String s) throws Exception {
        if (onMessageReceivedCallback != null){
            onMessageReceivedCallback.callback(s);
        }
    }
}
