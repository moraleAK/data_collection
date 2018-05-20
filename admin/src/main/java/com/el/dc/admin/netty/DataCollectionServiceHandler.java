package com.el.dc.admin.netty;

import com.el.dc.admin.properties.MyProperties;
import com.el.dc.admin.properties.MyPropertyPlaceholderConfigurer;
import com.el.dc.admin.util.FileUtils;
import com.el.dc.admin.util.MD5Utils;
import com.el.dc.api.common.HttpClientUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import javassist.bytecode.ByteArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class DataCollectionServiceHandler extends ChannelInboundHandlerAdapter {
    private Logger LOG = LoggerFactory.getLogger(this.getClass());
    private static HashMap<String, Object> map = new HashMap<>();
    private String DATA = "data";
    private String PIC = "pic";

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
        LOG.info("data info :{}",map.get(getKey(ctx, 1)));
        byte[] bytes = ((ByteArrayOutputStream)map.get(getKey(ctx,2))).toByteArray();

        // 图片存储
        FileUtils.fileWrite(bytes,"d:/data_collection_pic/" + MD5Utils.md5(bytes) + ".png");
        LOG.info("PIC SIZE :{}", bytes.length);
        map.remove(getKey(ctx,1));
        map.remove(getKey(ctx,2));
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
        // 第一次接收传感器信息 不超过 20KB
        if(map.get(getKey(ctx,1)) == null){
            map.put(getKey(ctx,1),getMessage((ByteBuf) msg));
            LOG.info("receive data:{}", map.get(getKey(ctx, 1)));
        }
        // 接收图片数据
        else {

            ByteBuf buf = (ByteBuf) msg;
            byte[] con = new byte[buf.readableBytes()];
            buf.readBytes(con);
            if(map.get(getKey(ctx, 2)) == null){
//                HashMap map = new ObjectMapper().readValue(getKey(ctx, 1).toString(),HashMap.class);
//                int len = (Integer) map.get("IPC_Len");
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                outputStream.write(con);
                map.put(getKey(ctx, 2),outputStream);
            }else {
               ((ByteArrayOutputStream)map.get(getKey(ctx, 2))).write(con);
            }

        }

        // 转发请求到本机 http 接口进行处理
//        HttpClientUtils.sendHttpRequest(
//                MyPropertyPlaceholderConfigurer.getPropertiesMap().get(MyProperties.DC_HTTP_REQUEST_URL), rev
//        );

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

    private String getKey(ChannelHandlerContext ctx, int keyType){
        if(keyType == 1){
            return ctx.channel().id().toString()+ DATA;
        }else {
            return ctx.channel().id().toString() + PIC;
        }
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
