package com.el.dc.api.dao.impl;

import com.el.dc.api.database.dao.GenericDaoImpl;
import com.el.dc.api.entity.NodeSensorData;
import org.springframework.stereotype.Repository;

@Repository
public class NodeSensorDataDao  extends GenericDaoImpl<NodeSensorData, Long> {

    @Override
    protected Class<NodeSensorData> getDomainClass() {
        return NodeSensorData.class;
    }
}
