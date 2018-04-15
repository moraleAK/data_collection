package com.el.dc.api.service;

import com.el.dc.api.dao.impl.NodeInfoDao;
import com.el.dc.api.entity.NodeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NodeInfoService {
    @Autowired
    NodeInfoDao nodeInfoDao;

    public void nodeInfoAdd(NodeInfo nodeInfo){
        nodeInfoDao.persist(nodeInfo);
    }

    public List<NodeInfo> loadNodeInfos(){
        return nodeInfoDao.loadNodeInfos();
    }
}
