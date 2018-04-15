package com.el.dc.api.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 节点信息表
 */
@Table(name = "t_node_info")
@Entity
public class NodeInfo extends BaseEntity {
    // 设备Id
    @Column(name = "device_id", nullable = false, unique = true)
    private String deviceId;

    // 类型
    @Column(name = "type")
    private int type;

    // 硬件版本
    @Column(name = "hardware_version")
    private String hardwareVersion;

    // 软件版本
    @Column(name = "software_version")
    private String softwareVersion;

    // 所属单位名称
    @Column(name = "company_name")
    private String companyName;

    // 制造商
    @Column(name = "manufacturer")
    private String manufacturer;

    // 销售日期
    @Column(name = "sale_date")
    private String saleDate;

    // 生产日期
    @Column(name = "production_date")
    private String productionDate;

    // 上次接收到数据的时间
    @Column(name = "last_data_receive_timestamp",columnDefinition = "bigint(10) default 9999999999")
    private long lastDataReceiveTimestamp;

    public long getLastDataReceiveTimestamp() {
        return lastDataReceiveTimestamp;
    }

    public void setLastDataReceiveTimestamp(long lastDataReceiveTimestamp) {
        this.lastDataReceiveTimestamp = lastDataReceiveTimestamp;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getHardwareVersion() {
        return hardwareVersion;
    }

    public void setHardwareVersion(String hardwareVersion) {
        this.hardwareVersion = hardwareVersion;
    }

    public String getSoftwareVersion() {
        return softwareVersion;
    }

    public void setSoftwareVersion(String softwareVersion) {
        this.softwareVersion = softwareVersion;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    public String getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(String productionDate) {
        this.productionDate = productionDate;
    }
}
