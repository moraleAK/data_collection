package com.el.dc.api.entity;

import javax.persistence.*;

@Table(name = "t_node_sensor_data")
@Entity
public class NodeSensorData extends BaseEntity{
    // 设备ID
    @Column(name = "device_id")
    private String deviceId;

    // 文件ID
    @Column(name = "file_id")
    private String fileId;

    // 时间戳
    @Column(name = "timestamp")
    private long timestamp;

    // GPS经度
    @Column(name = "gps_longitude")
    private double gpsLongitude;

    // GPS纬度
    @Column(name = "gps_latitude")
    private double gpsLatitude;

    @Column(name = "ph")
    private double ph;
    @Column(name = "cod")
    private double cod;
    @Column(name = "dog")
    private double dog;
    @Column(name = "nhn")
    private double nhn;
    @Column(name = "temp")
    private double temp;
    @Column(name = "zs")
    private double zs;
    @Column(name = "error_code")
    private String errorCode;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public double getPh() {
        return ph;
    }

    public void setPh(double ph) {
        this.ph = ph;
    }

    public double getCod() {
        return cod;
    }

    public void setCod(double cod) {
        this.cod = cod;
    }

    public double getDog() {
        return dog;
    }

    public void setDog(double dog) {
        this.dog = dog;
    }

    public double getNhn() {
        return nhn;
    }

    public void setNhn(double nhn) {
        this.nhn = nhn;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getZs() {
        return zs;
    }

    public void setZs(double zs) {
        this.zs = zs;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public double getGpsLongitude() {
        return gpsLongitude;
    }

    public void setGpsLongitude(double gpsLongitude) {
        this.gpsLongitude = gpsLongitude;
    }

    public double getGpsLatitude() {
        return gpsLatitude;
    }

    public void setGpsLatitude(double gpsLatitude) {
        this.gpsLatitude = gpsLatitude;
    }
}
