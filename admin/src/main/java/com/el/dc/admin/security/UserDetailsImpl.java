package com.el.dc.admin.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * User: Rolandz
 * Date: 22/11/2016
 * Time: 8:30 PM
 */
public class UserDetailsImpl implements UserDetails {

    private long id;

    private String accountCode;

    private int status;

    private String companyName;

    private String lastLoginTime;

    private String password;

    private String username;

    private boolean accountNonExpired;

    private boolean CredentialsNonExpired;

    private boolean Enabled;

    private boolean AccountNonLocked;

    private boolean isMarket;

    private long marketId;

    private long pwdUpdateTime;

    private String safetyMessage;

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public boolean isMarket() {
        return isMarket;
    }

    public void setMarket(boolean market) {
        isMarket = market;
    }

    public long getMarketId() {
        return marketId;
    }

    public void setMarketId(long marketId) {
        this.marketId = marketId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        AccountNonLocked = accountNonLocked;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return AccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return CredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return Enabled;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        CredentialsNonExpired = credentialsNonExpired;
    }

    public void setEnabled(boolean enabled) {
        Enabled = enabled;
    }

    public long getPwdUpdateTime() {
        return pwdUpdateTime;
    }

    public void setPwdUpdateTime(long pwdUpdateTime) {
        this.pwdUpdateTime = pwdUpdateTime;
    }

    public String getSafetyMessage() {
        return safetyMessage;
    }

    public void setSafetyMessage(String safetyMessage) {
        this.safetyMessage = safetyMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDetailsImpl)) return false;

        UserDetailsImpl that = (UserDetailsImpl) o;

        if (getId() != that.getId()) return false;
        return getUsername().equals(that.getUsername());

    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + getUsername().hashCode();
        return result;
    }
}
