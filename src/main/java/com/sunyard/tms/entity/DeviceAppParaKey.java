package com.sunyard.tms.entity;

import java.io.Serializable;

public class DeviceAppParaKey implements Serializable {
    private String deviceSn;

    private String paraVer;

    private static final long serialVersionUID = 1L;

    public String getDeviceSn() {
        return deviceSn;
    }

    public void setDeviceSn(String deviceSn) {
        this.deviceSn = deviceSn == null ? null : deviceSn.trim();
    }

    public String getParaVer() {
        return paraVer;
    }

    public void setParaVer(String paraVer) {
        this.paraVer = paraVer == null ? null : paraVer.trim();
    }
}