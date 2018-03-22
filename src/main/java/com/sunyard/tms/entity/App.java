package com.sunyard.tms.entity;

import java.io.Serializable;

import com.sunyard.tms.utils.IPage;

public class App implements Serializable {
    private String appId;

    private String appName;

    private String brandId;

    private String appDesc;

    private String appContact;

    private String appStatus;

    private String modelId;

    private String appType;

    private String createdDatetime;

    private String updateDatetime;

    private String bak1;

    private String bak2;

    private String bak3;

    private String appIconType;

    private String appIcon;

    private static final long serialVersionUID = 1L;
    
    // --以下字段为过程中使用---//
    /**
	 * 应用版本号
	 */
	private String appPkgVer;
	
	/**
	 * 应用下载标志0-强制下载1-非强制下载
	 */
	private String appDownloadFlag;
	
	/**
	 * 应用包大小
	 */
	private String appPkgLen;
	
	/**
	 * 应用包描述
	 */
	private String appPkgDesc;
	
    public String getAppPkgVer() {
		return appPkgVer;
	}

	public void setAppPkgVer(String appPkgVer) {
		this.appPkgVer = appPkgVer;
	}

	public String getAppDownloadFlag() {
		return appDownloadFlag;
	}

	public void setAppDownloadFlag(String appDownloadFlag) {
		this.appDownloadFlag = appDownloadFlag;
	}

	public String getAppPkgLen() {
		return appPkgLen;
	}

	public void setAppPkgLen(String appPkgLen) {
		this.appPkgLen = appPkgLen;
	}

	public String getAppPkgDesc() {
		return appPkgDesc;
	}

	public void setAppPkgDesc(String appPkgDesc) {
		this.appPkgDesc = appPkgDesc;
	}

	public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName == null ? null : appName.trim();
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId == null ? null : brandId.trim();
    }

    public String getAppDesc() {
        return appDesc;
    }

    public void setAppDesc(String appDesc) {
        this.appDesc = appDesc == null ? null : appDesc.trim();
    }

    public String getAppContact() {
        return appContact;
    }

    public void setAppContact(String appContact) {
        this.appContact = appContact == null ? null : appContact.trim();
    }

    public String getAppStatus() {
        return appStatus;
    }

    public void setAppStatus(String appStatus) {
        this.appStatus = appStatus == null ? null : appStatus.trim();
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId == null ? null : modelId.trim();
    }

    public String getAppType() {
        return appType;
    }

    public void setAppType(String appType) {
        this.appType = appType == null ? null : appType.trim();
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

    public String getAppIconType() {
        return appIconType;
    }

    public void setAppIconType(String appIconType) {
        this.appIconType = appIconType == null ? null : appIconType.trim();
    }

    public String getAppIcon() {
        return appIcon;
    }

    public void setAppIcon(String appIcon) {
        this.appIcon = appIcon;
    }
}