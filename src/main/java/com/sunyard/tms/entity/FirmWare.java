package com.sunyard.tms.entity;

import java.io.Serializable;

public class FirmWare implements Serializable {
    private String firmId;

    private String firmName;

    private String firmDesc;

    private String firmStatus;

    private String firmStatusName;

    private String firmVer;

    private String firmDownloadFlag;

    private String firmFilePath;

    private String firmFolderPath;

    private String firmLen;

    private String createdDatetime;

    private String updateDatetime;

    private String bak1;

    private String bak2;

    private String bak3;

    private static final long serialVersionUID = 1L;

    public String getFirmId() {
        return firmId;
    }

    public void setFirmId(String firmId) {
        this.firmId = firmId == null ? null : firmId.trim();
    }

    public String getFirmName() {
        return firmName;
    }

    public void setFirmName(String firmName) {
        this.firmName = firmName == null ? null : firmName.trim();
    }

    public String getFirmDesc() {
        return firmDesc;
    }

    public void setFirmDesc(String firmDesc) {
        this.firmDesc = firmDesc == null ? null : firmDesc.trim();
    }

    public String getFirmStatus() {
        return firmStatus;
    }

    public void setFirmStatus(String firmStatus) {
        this.firmStatus = firmStatus == null ? null : firmStatus.trim();
    }

    public String getFirmVer() {
        return firmVer;
    }

    public void setFirmVer(String firmVer) {
        this.firmVer = firmVer == null ? null : firmVer.trim();
    }

    public String getFirmDownloadFlag() {
        return firmDownloadFlag;
    }

    public void setFirmDownloadFlag(String firmDownloadFlag) {
        this.firmDownloadFlag = firmDownloadFlag == null ? null : firmDownloadFlag.trim();
    }

    public String getFirmFilePath() {
        return firmFilePath;
    }

    public void setFirmFilePath(String firmFilePath) {
        this.firmFilePath = firmFilePath == null ? null : firmFilePath.trim();
    }

    public String getFirmFolderPath() {
        return firmFolderPath;
    }

    public void setFirmFolderPath(String firmFolderPath) {
        this.firmFolderPath = firmFolderPath == null ? null : firmFolderPath.trim();
    }

    public String getFirmLen() {
        return firmLen;
    }

    public void setFirmLen(String firmLen) {
        this.firmLen = firmLen == null ? null : firmLen.trim();
    }

    public String getCreatedDatetime() {
        return createdDatetime;
    }

    public void setCreatedDatetime(String createdDatetime) {
        this.createdDatetime = createdDatetime == null ? null : createdDatetime.trim();
    }

    public String getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(String updateDatetime) {
        this.updateDatetime = updateDatetime == null ? null : updateDatetime.trim();
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

    public String getFirmStatusName() {
        if ("0".equals(firmStatus)){
            return "ready";
        }else if ("1".equals(firmStatus)){
            return "online";
        }else {
            return "offline";
        }
    }

    public void setFirmStatusName(String firmStatusName) {
        this.firmStatusName = firmStatusName;
    }
}