package com.sunyard.tms.entity;

import java.io.Serializable;

public class AppPackage extends AppPackageKey implements Serializable {
    private String appDownloadFlag;

    private String appDownloadFlagName;

    private String appPkgLen;

    private String appPkgDesc;

    private String appPkgStatus;

    private String appPkgFilePath;

    private String appPkgFolderPath;

    private String createdDatetime;

    private String updateDatetime;

    private String bak1;

    private String bak2;

    private String bak3;

    private String AppName;

    private static final long serialVersionUID = 1L;

    public String getAppDownloadFlag() {
        return appDownloadFlag;
    }

    public void setAppDownloadFlag(String appDownloadFlag) {
        this.appDownloadFlag = appDownloadFlag == null ? null : appDownloadFlag.trim();
    }

    public String getAppPkgLen() {
        return appPkgLen;
    }

    public void setAppPkgLen(String appPkgLen) {
        this.appPkgLen = appPkgLen == null ? null : appPkgLen.trim();
    }

    public String getAppPkgDesc() {
        return appPkgDesc;
    }

    public void setAppPkgDesc(String appPkgDesc) {
        this.appPkgDesc = appPkgDesc == null ? null : appPkgDesc.trim();
    }

    public String getAppPkgStatus() {
        return appPkgStatus;
    }

    public void setAppPkgStatus(String appPkgStatus) {
        this.appPkgStatus = appPkgStatus == null ? null : appPkgStatus.trim();
    }

    public String getAppPkgFilePath() {
        return appPkgFilePath;
    }

    public void setAppPkgFilePath(String appPkgFilePath) {
        this.appPkgFilePath = appPkgFilePath == null ? null : appPkgFilePath.trim();
    }

    public String getAppPkgFolderPath() {
        return appPkgFolderPath;
    }

    public void setAppPkgFolderPath(String appPkgFolderPath) {
        this.appPkgFolderPath = appPkgFolderPath == null ? null : appPkgFolderPath.trim();
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

    public String getAppName() {
        return AppName;
    }

    public void setAppName(String appName) {
        AppName = appName;
    }

    public String getAppDownloadFlagName() {
        if ("0".equals(appDownloadFlag)){
            return "forced to download";
        }else{
            return "not forced to download";
        }
    }

    public void setAppDownloadFlagName(String appDownloadFlagName) {
        this.appDownloadFlagName = appDownloadFlagName;
    }
}