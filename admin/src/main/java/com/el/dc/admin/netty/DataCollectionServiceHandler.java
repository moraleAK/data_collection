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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

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
        HashMap<String, Object> reqMap = new ObjectMapper().readValue((String) map.get(getKey(ctx,1)), HashMap.class);
        if(map.get(getKey(ctx,2)) != null){
            long len = Long.valueOf((Integer)reqMap.get("IPC_Len"));
            byte[] bytes = ((ByteArrayOutputStream)map.get(getKey(ctx,2))).toByteArray();
            if(bytes.length != len){
                LOG.info("图片信息不完整，舍弃！");
                return;
            }
            String picName = MD5Utils.md5(bytes) + ".jpg";
            // 图片存储
            FileUtils.fileWrite(bytes,MyPropertyPlaceholderConfigurer.getPropertiesMap().get(MyProperties.DC_PICTURE_PATH) + picName);
            reqMap.put("pictureName", picName);
            LOG.info("PIC SIZE :{}", bytes.length);
            map.remove(getKey(ctx,2));
        }
        HttpClientUtils.sendHttpRequest(MyPropertyPlaceholderConfigurer.getPropertiesMap().get(MyProperties.DC_HTTP_REQUEST_URL), reqMap);
        map.remove(getKey(ctx,1));
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
     * 若有图片传输则此方法至少触发两次
     * 第一次：接受数据信息
     * 之后次数：接受图片信息
     * 当客户端主动断开连接时触发 channelActive()
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
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                outputStream.write(con);
                map.put(getKey(ctx, 2),outputStream);
            }else {
               ((ByteArrayOutputStream)map.get(getKey(ctx, 2))).write(con);
            }
        }
    }

    /**
     * 功能：读取完毕客户端发送过来的数据之后的操作
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        LOG.info("data receive end !");
    }

    /**
     * 功能：服务端发生异常的操作
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        ctx.close();
        LOG.error(cause.getMessage(),cause);
    }

    private String getKey(ChannelHandlerContext ctx, int keyType){
        if(keyType == 1){
            return ctx.channel().id().toString()+ DATA;
        }else {
            return ctx.channel().id().toString() + PIC;
        }
    }
}
