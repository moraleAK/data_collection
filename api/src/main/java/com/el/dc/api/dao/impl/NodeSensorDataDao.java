package com.el.dc.api.dao.impl;

import com.el.dc.api.database.dao.GenericDaoImpl;
import com.el.dc.api.entity.NodeSensorData;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class NodeSensorDataDao  extends GenericDaoImpl<NodeSensorData, Long> {

    public List<NodeSensorData> loadNodeSensorDatas() {
        return query("from NodeSensorData where deleted = false order by createTime desc")
                .setFirstResult(0).setMaxResults(30).getResultList();
    }

    @Override
    protected Class<NodeSensorData> getDomainClass() {
        return NodeSensorData.class;
    }
}
