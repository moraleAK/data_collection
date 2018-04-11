package com.el.dc.api.dao.impl;

import com.el.dc.api.database.dao.GenericDaoImpl;
import com.el.dc.api.entity.NodeInfo;
import org.springframework.stereotype.Repository;

@Repository
public class NodeInfoDao  extends GenericDaoImpl<NodeInfo, Long> {
    @Override
    protected Class<NodeInfo> getDomainClass() {
        return NodeInfo.class;
    }
}
