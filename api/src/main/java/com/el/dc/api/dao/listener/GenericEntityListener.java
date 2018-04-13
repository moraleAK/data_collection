package com.el.dc.api.dao.listener;

import com.el.dc.api.entity.BaseEntity;
import org.springframework.stereotype.Component;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Component
public class GenericEntityListener {
    @PrePersist
    public void prePersist(BaseEntity entity) {
        entity.setCreateTime(System.currentTimeMillis());
        entity.setUpdateTime(entity.getCreateTime());
    }

    @PreUpdate
    public void preUpdate(BaseEntity entity) {
        entity.setUpdateTime(System.currentTimeMillis());
    }
}
