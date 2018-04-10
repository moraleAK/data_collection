package com.el.dc.api.to;

public class NodeInfoTO {
    // 设备Id
    private String deviceId;

    // 类型
    private String type;

    // 硬件版本
    private String hardwareVersion;

    // 软件版本
    private String softwareVersion;

    // 所属单位名称
    private String companyName;

    // 制造商
    private String manufacturer;

    // 销售日期
    private String saleDate;

    // 生产日期
    private String productionDate;

    public NodeInfoTO(String deviceId, String type, String hardwareVersion, String softwareVersion, String companyName, String manufacturer, String saleDate, String productionDate) {
        this.deviceId = deviceId;
        this.type = type;
        this.hardwareVersion = hardwareVersion;
        this.softwareVersion = softwareVersion;
        this.companyName = companyName;
        this.manufacturer = manufacturer;
        this.saleDate = saleDate;
        this.productionDate = productionDate;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
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
