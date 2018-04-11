package com.el.dc.api.service;

import com.el.dc.api.dao.impl.NodeSensorDataDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class NodeSensorDataService {
    @Autowired
    NodeSensorDataDao nodeSensorDataDao;

    public void addNodeSensorData(String data){

    }
}
