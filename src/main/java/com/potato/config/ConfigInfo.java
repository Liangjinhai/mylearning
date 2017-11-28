package com.potato.config;

import java.io.Serializable;

/**
 * Created by potato on 2017/10/10.
 */
public class ConfigInfo implements Serializable {

    private String user;
    private String psd;

    public ConfigInfo(String user, String psd) {
        this.user = user;
        this.psd = psd;
    }

    public ConfigInfo() {
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPsd() {
        return psd;
    }

    public void setPsd(String psd) {
        this.psd = psd;
    }

    @Override
    public String toString() {
        return "ConfigInfo{" +
                "user='" + user + '\'' +
                ", psd='" + psd + '\'' +
                '}';
    }
}
