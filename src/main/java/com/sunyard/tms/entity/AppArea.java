package com.sunyard.tms.entity;

import java.io.Serializable;

public class AppArea implements Serializable {
    private String appAreaId;

    private String areaName;

    private static final long serialVersionUID = 1L;

    public String getAppAreaId() {
        return appAreaId;
    }

    public void setAppAreaId(String appAreaId) {
        this.appAreaId = appAreaId == null ? null : appAreaId.trim();
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName == null ? null : areaName.trim();
    }
}