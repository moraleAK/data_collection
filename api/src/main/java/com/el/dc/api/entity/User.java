package com.el.dc.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * User Canno
 * Date 2018/4/9
 * Time 17:55
 */
@Entity
@Table
public class User extends BaseEntity{
    @Column(name = "login_name")
    private String loginName;

    @Column(name = "login_password")
    private String loginPassword;

    @Column(name = "phone_no")
    private String phoneNo;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
