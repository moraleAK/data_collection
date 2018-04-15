package com.el.dc.test;

import com.el.dc.api.common.HttpClientUtils;
import com.el.dc.api.entity.NodeInfo;
import com.el.dc.api.to.NodeSensorDataReqTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import socket.SocketRequestUtils;

import java.io.IOException;

public class NodeInfoTest {

    @Test
    public void test() {
        NodeInfo nodeInfo = new NodeInfo();
        nodeInfo.setDeviceId("20180429");
        nodeInfo.setCompanyName("天府之国");
        nodeInfo.setHardwareVersion("1.3");
        nodeInfo.setManufacturer("富土康");
        nodeInfo.setType(13);
        nodeInfo.setProductionDate("20180405");
        nodeInfo.setSaleDate("20180409");
        nodeInfo.setSoftwareVersion("3.3.3");
        HttpClientUtils.sendHttpRequest("http://118.178.57.153:8099/dc/node_info_add", nodeInfo);
    }

    @Test
    public void sendData() throws IOException, InterruptedException {
        String data =
                " {\"id\":\"20180405\",\"GPS_Lon\":233.234,\"GPS_Lat\":22.11,\"PH\":7.11,\"COD\":22.11,\"DOG\":33.22,\"NHN\":44.33,\"ZS\":55.44,\"TEMP\":66.55}";
        while (true) {
            new SocketRequestUtils("118.178.57.153", 9991).send(data);
            Thread.sleep(1000);
            System.out.println("success");
        }
    }

    final static ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void readTest() throws IOException {
        String data =
                "{\"id\":\"20180405\",\"GPS_Lon\":233.234,\"GPS_Lat\":22.11,\"PH\":7.11,\"COD\":22.11,\"DOG\":33.22,\"NHN\":44.33,\"ZS\":55.44,\"TEMP\":66.55}";
        NodeSensorDataReqTO reqTO = objectMapper.readValue(data, NodeSensorDataReqTO.class);
        System.out.println(objectMapper.writeValueAsString(reqTO));
    }
}
