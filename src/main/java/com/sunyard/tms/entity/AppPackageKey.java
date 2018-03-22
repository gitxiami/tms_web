package com.sunyard.tms.entity;

import java.io.Serializable;

public class AppPackageKey implements Serializable {
    private String appId;

    private String appPkgVer;

    private static final long serialVersionUID = 1L;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    public String getAppPkgVer() {
        return appPkgVer;
    }

    public void setAppPkgVer(String appPkgVer) {
        this.appPkgVer = appPkgVer == null ? null : appPkgVer.trim();
    }
}