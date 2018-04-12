package com.el.dc.test;

import com.el.dc.api.common.HttpClientUtils;
import com.el.dc.api.entity.NodeInfo;
import org.junit.Test;

public class NodeInfoTest {

    @Test
    public void test(){
        NodeInfo nodeInfo = new NodeInfo();
        nodeInfo.setDeviceId("20180409");
        nodeInfo.setCompanyName("天府之国");
        nodeInfo.setHardwareVersion("1.3");
        nodeInfo.setManufacturer("富土康");
        nodeInfo.setType("13");
        nodeInfo.setProductionDate("20180405");
        nodeInfo.setSaleDate("20180409");
        nodeInfo.setSoftwareVersion("3.3.3");
        HttpClientUtils.sendHttpRequest("http://localhost:9001/dc/node_info_add", nodeInfo);
    }
}
