package com.el.dc.api.dao.impl;

import com.el.dc.api.database.dao.GenericDaoImpl;
import com.el.dc.api.entity.NodeInfo;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;

@Repository
public class NodeInfoDao  extends GenericDaoImpl<NodeInfo, Long> {
    @Override
    protected Class<NodeInfo> getDomainClass() {
        return NodeInfo.class;
    }

    public NodeInfo loadNodeInfoByDeviceId(String deviceId){
        try {
            return query("from NodeInfo where deleted = false and deviceId = ?1", deviceId).getSingleResult();
        }catch (NoResultException nre){
            return null;
        }
    }
}
