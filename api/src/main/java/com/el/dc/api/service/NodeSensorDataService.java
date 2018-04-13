package com.el.dc.api.service;

import com.el.dc.api.dao.impl.NodeInfoDao;
import com.el.dc.api.dao.impl.NodeSensorDataDao;
import com.el.dc.api.entity.NodeInfo;
import com.el.dc.api.entity.NodeSensorData;
import com.el.dc.api.to.NodeSensorDataReqTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service
@Transactional
public class NodeSensorDataService {
    @Autowired
    NodeSensorDataDao nodeSensorDataDao;
    @Autowired
    NodeInfoDao nodeInfoDao;

    ObjectMapper objectMapper = new ObjectMapper();


    public void addNodeSensorData(String data) throws IOException {
//        "id":20180409,"GPS_Lon":233.234,"GPS_Lat":22.11,"PH":7.9.11,"COD":22.11,"DOG":33.22,"NHN":44.33,"ZS":55.44,"TEMP":66.55,
        data = data.replace("7.9.11", "7.9");
        data = data.substring(0, data.length() - 2);
        data = "{" + data + "}";
        System.out.println(data);
        NodeSensorDataReqTO reqTO  = objectMapper.readValue(data, NodeSensorDataReqTO.class);

        NodeInfo nodeInfo = nodeInfoDao.loadNodeInfoByDeviceId(reqTO.getId() + "");
        if(nodeInfo == null){
            throw new RuntimeException("非法数据，该设备ID不存在");
        }

        NodeSensorData nodeSensorData = new NodeSensorData();
        nodeSensorData.setCod(reqTO.getCod());
        nodeSensorData.setDog(reqTO.getDog());
        nodeSensorData.setDeviceId(String.valueOf(reqTO.getId()));
        nodeSensorData.setGpsLatitude(reqTO.getGpsLat());
        nodeSensorData.setGpsLongitude(reqTO.getGpsLon());
        nodeSensorData.setNhn(reqTO.getNhn());
        nodeSensorData.setTemp(reqTO.getTemp());
        nodeSensorData.setTimestamp(System.currentTimeMillis() + "");
        nodeSensorData.setZs(reqTO.getZs());
        nodeSensorDataDao.persist(nodeSensorData);
    }

    public static void main(String[] args) throws IOException {
        String data =
                "\"id\":20180409,\"GPS_Lon\":233.234,\"GPS_Lat\":22.11,\"PH\":7.9.11,\"COD\":22.11,\"DOG\":33.22,\"NHN\":44.33,\"ZS\":55.44,\"TEMP\":66.55,\n"
                ;
        NodeSensorDataService dataService = new NodeSensorDataService();
        dataService.addNodeSensorData(data);
        int start = data.indexOf("");
    }
}
