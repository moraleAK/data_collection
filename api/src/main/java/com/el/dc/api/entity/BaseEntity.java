package com.el.dc.api.entity;

import com.el.dc.api.dao.listener.GenericEntityListener;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * User: Rolandz
 * Date: 7/10/16
 * Time: 6:23 AM
 */
@MappedSuperclass
@EntityListeners(value = {GenericEntityListener.class})
public abstract class BaseEntity {
    @Id
    @GeneratedValue
    private long id;

    @JsonIgnore
    @Column(name = "is_deleted")
    private boolean deleted;

    @JsonIgnore
    @Version
    @Column(name = "version")
    private long version;
    @Column(name = "create_time")
    private long createTime;

    @JsonIgnore
    @Column(name = "update_time")
    private long updateTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseEntity)) return false;

        BaseEntity that = (BaseEntity) o;

        return getId() == that.getId();

    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public int hashCode() {
        return (int) (getId() ^ (getId() >>> 32));
    }
}
