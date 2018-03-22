package com.sunyard.tms.entity;

import java.io.Serializable;
import java.util.List;

public class DeviceGroup implements Serializable {
    private String groupId;

    private String groupName;

    private String modelId;

    private String createOprater;

    private String createdDatetime;

    private String updateDatetime;

    private String memo;

    private String bak1;

    private String bak2;

    private String bak3;

    private static final long serialVersionUID = 1L;
    
 	/**
	 * 关联字段 设备型号名称
	 */
	private String modelName;
	
	/**
	 * 批量增删使用 设备编码
	 */
	private List<String> deviceIds;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId == null ? null : groupId.trim();
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId == null ? null : modelId.trim();
    }

    public String getCreateOprater() {
        return createOprater;
    }

    public void setCreateOprater(String createOprater) {
        this.createOprater = createOprater == null ? null : createOprater.trim();
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

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public List<String> getDeviceIds() {
		return deviceIds;
	}

	public void setDeviceIds(List<String> deviceIds) {
		this.deviceIds = deviceIds;
	}
}