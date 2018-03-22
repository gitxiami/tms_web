package com.sunyard.tms.entity;

import java.io.Serializable;

public class DeviceLog implements Serializable {
    private String deviceLogId;

    private String deviceSn;

    private String deviceLogFilePath;

    private String deviceLogFolderPath;

    private String createdDatetime;

    private String bak1;

    private String bak2;

    private String bak3;

    private static final long serialVersionUID = 1L;

    public String getDeviceLogId() {
        return deviceLogId;
    }

    public void setDeviceLogId(String deviceLogId) {
        this.deviceLogId = deviceLogId == null ? null : deviceLogId.trim();
    }

    public String getDeviceSn() {
        return deviceSn;
    }

    public void setDeviceSn(String deviceSn) {
        this.deviceSn = deviceSn == null ? null : deviceSn.trim();
    }

    public String getDeviceLogFilePath() {
        return deviceLogFilePath;
    }

    public void setDeviceLogFilePath(String deviceLogFilePath) {
        this.deviceLogFilePath = deviceLogFilePath == null ? null : deviceLogFilePath.trim();
    }

    public String getDeviceLogFolderPath() {
        return deviceLogFolderPath;
    }

    public void setDeviceLogFolderPath(String deviceLogFolderPath) {
        this.deviceLogFolderPath = deviceLogFolderPath == null ? null : deviceLogFolderPath.trim();
    }

    public String getCreatedDatetime() {
        return createdDatetime;
    }

    public void setCreatedDatetime(String createdDatetime) {
        this.createdDatetime = createdDatetime == null ? null : createdDatetime.trim();
    }

    public String getBak1() {
        return bak1;
    }

    public void setBak1(String bak1) {
        this.bak1 = bak1 == null ? null : bak1.trim();
    }

    public String getBak2() {
        return bak2;
    }

    public void setBak2(String bak2) {
        this.bak2 = bak2 == null ? null : bak2.trim();
    }

    public String getBak3() {
        return bak3;
    }

    public void setBak3(String bak3) {
        this.bak3 = bak3 == null ? null : bak3.trim();
    }
}