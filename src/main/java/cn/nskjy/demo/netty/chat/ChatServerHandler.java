package cn.nskjy.demo.netty.chat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;


import java.text.SimpleDateFormat;
import java.util.Date;

public class ChatServerHandler extends SimpleChannelInboundHandler<String> {

    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush("[ 客户端 ]" + channel.remoteAddress() + " 上线了 " + sdf.format(new Date()) + "\n");
        // 将channel 加入到channelGroup
        channelGroup.add(channel);
        System.out.println(ctx.channel().remoteAddress() + " 上线了 " + "\n");
    }

    // 表示channel处于不活动状态，提示离线
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush("[ 客户端 ]" + channel.remoteAddress() + " 下线了 " + "\n");
        System.out.println(ctx.channel().remoteAddress() + " 下线了 " + "\n");
        System.out.println("channelGroup size=" + channelGroup.size());
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        // 获取当前channel
        Channel channel = ctx.channel();
        // 这是我们遍历 channelGroup，根据不同情况，回送不同消息
        channelGroup.forEach(ch -> {
            if (channel != ch) {
                ch.writeAndFlush(" [ 客户端 ] " + ch.remoteAddress() + " 发送了消息 ：" + msg + "\n");
            }else {
                ch.writeAndFlush(" [ 自己 ] 发送了消息：" + msg + "\n");
            }
        });

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        // 关闭通道
        ctx.close();
    }
}
