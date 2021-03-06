package com.el.dc.api.to;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NodeSensorDataReqTO {
    @JsonProperty(value = "id")
    String deviceId;
    @JsonProperty(value = "GPS_Lon")
    double gpsLon;
    @JsonProperty(value = "GPS_Lat")
    double gpsLat;
    @JsonProperty(value = "PH")
    double ph;
    @JsonProperty(value = "COD")
    double cod;
    @JsonProperty(value = "DOG")
    double dog;
    @JsonProperty(value = "NHN")
    double nhn;
    @JsonProperty(value = "ZS")
    double zs;

    @JsonProperty(value = "TEMP")
    double temp;
    @JsonProperty(value = "ERRCODE")
    String errorCode;

    @JsonProperty(value = "pictureName")
    String pictureName;

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }


    public double getGpsLon() {
        return gpsLon;
    }

    public void setGpsLon(double gpsLon) {
        this.gpsLon = gpsLon;
    }

    public double getGpsLat() {
        return gpsLat;
    }

    public void setGpsLat(double gpsLat) {
        this.gpsLat = gpsLat;
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

    public double getZs() {
        return zs;
    }

    public void setZs(double zs) {
        this.zs = zs;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }
}
