package com.sunyard.tms.entity;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;
import com.sunyard.tms.utils.IPage;

public class DeviceAppPara extends DeviceAppParaKey implements Serializable {
    private String serverPara;

    private String serverParaBak1;

    private String serverParaBak2;

    private String mchntId;

    private String deviceId;

    private String paraId;

    private String createdDatetime;

    private String updateDatetime;
    @JSONField(serialize=false)
    private String bak1;
    @JSONField(serialize=false)
    private String bak2;
    @JSONField(serialize=false)
    private String bak3;

    private static final long serialVersionUID = 1L;
    
    // --以下字段为过程中使用---//
  	/**
  	 * 分页封装实体
  	 */
  	private IPage Page;

    public String getServerPara() {
        return serverPara;
    }

    public void setServerPara(String serverPara) {
        this.serverPara = serverPara == null ? null : serverPara.trim();
    }

    public String getServerParaBak1() {
        return serverParaBak1;
    }

    public void setServerParaBak1(String serverParaBak1) {
        this.serverParaBak1 = serverParaBak1 == null ? null : serverParaBak1.trim();
    }

    public String getServerParaBak2() {
        return serverParaBak2;
    }

    public void setServerParaBak2(String serverParaBak2) {
        this.serverParaBak2 = serverParaBak2 == null ? null : serverParaBak2.trim();
    }

    public String getMchntId() {
        return mchntId;
    }

    public void setMchntId(String mchntId) {
        this.mchntId = mchntId == null ? null : mchntId.trim();
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
    }

    public String getParaId() {
        return paraId;
    }

    public void setParaId(String paraId) {
        this.paraId = paraId == null ? null : paraId.trim();
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

	public IPage getPage() {
		return Page;
	}

	public void setPage(IPage page) {
		Page = page;
	}
}