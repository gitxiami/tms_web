package com.sunyard.tms.dto;

import java.util.List;

import com.sunyard.tms.entity.DeviceAppPara;
import com.sunyard.tms.entity.DeviceAppParaMchnt;
import com.sunyard.tms.entity.DeviceAppParaTpdu;

/**
 * @Description:参数信息整合实体类
 * @author:zhangbo
 * @date:2018年1月3日 下午2:17:11
 */
public class DeviceAppParaDto {
	private DeviceAppPara deviceAppPara;

	private List<DeviceAppParaTpdu> deviceAppParaTpdu;

	private List<DeviceAppParaMchnt> deviceAppParaMchnt;

	public DeviceAppPara getDeviceAppPara() {
		return deviceAppPara;
	}

	public void setDeviceAppPara(DeviceAppPara deviceAppPara) {
		this.deviceAppPara = deviceAppPara;
	}

	public List<DeviceAppParaTpdu> getDeviceAppParaTpdu() {
		return deviceAppParaTpdu;
	}

	public void setDeviceAppParaTpdu(List<DeviceAppParaTpdu> deviceAppParaTpdu) {
		this.deviceAppParaTpdu = deviceAppParaTpdu;
	}

	public List<DeviceAppParaMchnt> getDeviceAppParaMchnt() {
		return deviceAppParaMchnt;
	}

	public void setDeviceAppParaMchnt(List<DeviceAppParaMchnt> deviceAppParaMchnt) {
		this.deviceAppParaMchnt = deviceAppParaMchnt;
	}

}
