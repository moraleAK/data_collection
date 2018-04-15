package com.el.dc.admin.netty;

import com.el.dc.admin.properties.MyProperties;
import com.el.dc.admin.properties.MyPropertyPlaceholderConfigurer;
import com.el.dc.api.common.HttpClientUtils;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;

public class DataCollectionServiceHandler extends ChannelInboundHandlerAdapter {
    private Logger LOG = LoggerFactory.getLogger(this.getClass());

    /*
 * channelAction
 *
 * channel 通道 action 活跃的
 *
 * 当客户端主动链接服务端的链接后，这个通道就是活跃的了。也就是客户端与服务端建立了通信通道并且可以传输数据
 *
 */
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        LOG.info(" {}通道已激活！", ctx.channel().localAddress().toString());
    }

    /*
     * channelInactive
     *
     * channel 通道 Inactive 不活跃的
     *
     * 当客户端主动断开服务端的链接后，这个通道就是不活跃的。也就是说客户端与服务端的关闭了通信通道并且不可以传输数据
     *
     */
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        LOG.info(" {}通道不活跃！", ctx.channel().localAddress().toString());
        // 关闭流

    }

    /**
     * 读取字符串信息
     *
     * @param buf
     * @return
     */
    private String getMessage(ByteBuf buf) {
        byte[] con = new byte[buf.readableBytes()];
        buf.readBytes(con);
        try {
            return new String(con, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 功能：读取服务器发送过来的信息
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // 第一种：接收字符串时的处理
        ByteBuf buf = (ByteBuf) msg;
        String rev = getMessage(buf);

        // 转发请求到本机 http 接口进行处理
        HttpClientUtils.sendHttpRequest(
                MyPropertyPlaceholderConfigurer.getPropertiesMap().get(MyProperties.DC_HTTP_REQUEST_URL), rev
        );
        LOG.info("receive data:{}", rev);

    }

    /**
     * 功能：读取完毕客户端发送过来的数据之后的操作
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        LOG.info("data receive end !");
        // 第一种方法：写一个空的buf，并刷新写出区域。完成后关闭sock channel连接。
//        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
        // ctx.flush();
        // ctx.flush(); //
        // 第二种方法：在client端关闭channel连接，这样的话，会触发两次channelReadComplete方法。
        // ctx.flush().close().sync(); // 第三种：改成这种写法也可以，但是这中写法，没有第一种方法的好。
    }

    /**
     * 功能：服务端发生异常的操作
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
        LOG.info("error：\r\n" + cause.getMessage());
    }
}
