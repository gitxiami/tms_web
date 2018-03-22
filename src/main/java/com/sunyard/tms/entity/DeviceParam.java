package com.sunyard.tms.entity;

import java.io.Serializable;
import java.util.List;

public class DeviceParam implements Serializable {
    private String paramId;

    private String deviceId;

    private String paramStatus;

    private String parameter;

    private String paramName;

    private String paramValue;

    private String createdDatetime;

    private String updateDatetime;

    private String memo;

    private String bak1;

    private String bak2;

    private String bak3;

    private static final long serialVersionUID = 1L;
    
    /**
     * 终端参数数组 批量删除用
     */
    private List<String> paramIds;
    
    /**
     * 公开/私有状态(0:公开 1:私有)
     */
    private String paramStatusName;

    public String getParamId() {
        return paramId;
    }

    public void setParamId(String paramId) {
        this.paramId = paramId == null ? null : paramId.trim();
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
    }

    public String getParamStatus() {
        return paramStatus;
    }

    public void setParamStatus(String paramStatus) {
        this.paramStatus = paramStatus == null ? null : paramStatus.trim();
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter == null ? null : parameter.trim();
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName == null ? null : paramName.trim();
    }

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue == null ? null : paramValue.trim();
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

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
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

	public List<String> getParamIds() {
		return paramIds;
	}

	public void setParamIds(List<String> paramIds) {
		this.paramIds = paramIds;
	}

	public String getParamStatusName() {
        if("0".equals(paramStatus)){
            return "public";
        }else if("1".equals(paramStatus)){
            return "private";
        }else{
            return paramStatusName;
        }
	}

	public void setParamStatusName(String paramStatusName) {
		this.paramStatusName = paramStatusName;
	}
}