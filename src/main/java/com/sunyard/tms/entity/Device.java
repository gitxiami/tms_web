package com.sunyard.tms.entity;

import com.sunyard.tms.utils.IPage;

import java.io.Serializable;

public class Device implements Serializable {
    private String deviceId;

    private String deviceSn;

    private String psamId;

    private String mchntId;

    private String batchNo;

    private String deviceTypeFlag;

    private String deviceStatus;

    private String deviceLimitStatus;

    private String appLoginPwd;

    private String devKeyAlgType;

    private String devTmkStatus;

    private String devTmkUpdateDatetime;

    private String keyOpId;

    private String devTmk;

    private String devTmkCheck;

    private String devSingInDatetime;

    private String devSignOutDatetime;

    private String devPik;

    private String devPikCheck;

    private String devMak;

    private String devMakCheck;

    private String devTk;

    private String devTkCheck;

    private String longitude;

    private String latitude;

    private String radius;

    private String version;

    private String devOnadd;

    private String busiType;

    private String scanCode;

    private String mscCode;

    private String touchIcRead;

    private String nonTouchIcRead;

    private String noCardPady;

    private String lyName;

    private String lyDate;

    private String devOpId;

    private String stampDatetime;

    private String createDatetime;

    private String updateDatetime;

    private String bak1;

    private String bak2;

    private String bak3;

    private String modelId;

    private String orgId;

    private String brandId;

    private String deviceHwVersion;

    private String deviceSwVersion;

    private String merchantName;

    // --以下字段为过程中使用---//
    /**
     * 分页封装实体
     */
    private IPage Page;

    /**
     * 关联字段 厂商名称
     */
    private String brandName;
    
    /**
     * 秘钥绑定状态
     */
    private String keyStatus;

    /**
     * 关联字段 型号名称
     */
    private String modelName;

    private String modelTypeName;

    private String deviceStatusName;

    private String modelTypeId;
    
    private String mchntName;
    
    private String groupId;

    private static final long serialVersionUID = 1L;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
    }

    public String getDeviceSn() {
        return deviceSn;
    }

    public void setDeviceSn(String deviceSn) {
        this.deviceSn = deviceSn == null ? null : deviceSn.trim();
    }

    public String getPsamId() {
        return psamId;
    }

    public void setPsamId(String psamId) {
        this.psamId = psamId == null ? null : psamId.trim();
    }

    public String getMchntId() {
        return mchntId;
    }

    public void setMchntId(String mchntId) {
        this.mchntId = mchntId == null ? null : mchntId.trim();
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo == null ? null : batchNo.trim();
    }

    public String getDeviceTypeFlag() {
        return deviceTypeFlag;
    }

    public void setDeviceTypeFlag(String deviceTypeFlag) {
        this.deviceTypeFlag = deviceTypeFlag == null ? null : deviceTypeFlag.trim();
    }

    public String getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(String deviceStatus) {
        this.deviceStatus = deviceStatus == null ? null : deviceStatus.trim();
    }

    public String getDeviceLimitStatus() {
        return deviceLimitStatus;
    }

    public void setDeviceLimitStatus(String deviceLimitStatus) {
        this.deviceLimitStatus = deviceLimitStatus == null ? null : deviceLimitStatus.trim();
    }

    public String getAppLoginPwd() {
        return appLoginPwd;
    }

    public void setAppLoginPwd(String appLoginPwd) {
        this.appLoginPwd = appLoginPwd == null ? null : appLoginPwd.trim();
    }

    public String getDevKeyAlgType() {
        return devKeyAlgType;
    }

    public void setDevKeyAlgType(String devKeyAlgType) {
        this.devKeyAlgType = devKeyAlgType == null ? null : devKeyAlgType.trim();
    }

    public String getDevTmkStatus() {
        return devTmkStatus;
    }

    public void setDevTmkStatus(String devTmkStatus) {
        this.devTmkStatus = devTmkStatus == null ? null : devTmkStatus.trim();
    }

    public String getDevTmkUpdateDatetime() {
        return devTmkUpdateDatetime;
    }

    public void setDevTmkUpdateDatetime(String devTmkUpdateDatetime) {
        this.devTmkUpdateDatetime = devTmkUpdateDatetime == null ? null : devTmkUpdateDatetime.trim();
    }

    public String getKeyOpId() {
        return keyOpId;
    }

    public void setKeyOpId(String keyOpId) {
        this.keyOpId = keyOpId == null ? null : keyOpId.trim();
    }

    public String getDevTmk() {
        return devTmk;
    }

    public void setDevTmk(String devTmk) {
        this.devTmk = devTmk == null ? null : devTmk.trim();
    }

    public String getDevTmkCheck() {
        return devTmkCheck;
    }

    public void setDevTmkCheck(String devTmkCheck) {
        this.devTmkCheck = devTmkCheck == null ? null : devTmkCheck.trim();
    }

    public String getDevSingInDatetime() {
        return devSingInDatetime;
    }

    public void setDevSingInDatetime(String devSingInDatetime) {
        this.devSingInDatetime = devSingInDatetime == null ? null : devSingInDatetime.trim();
    }

    public String getDevSignOutDatetime() {
        return devSignOutDatetime;
    }

    public void setDevSignOutDatetime(String devSignOutDatetime) {
        this.devSignOutDatetime = devSignOutDatetime == null ? null : devSignOutDatetime.trim();
    }

    public String getDevPik() {
        return devPik;
    }

    public void setDevPik(String devPik) {
        this.devPik = devPik == null ? null : devPik.trim();
    }

    public String getDevPikCheck() {
        return devPikCheck;
    }

    public void setDevPikCheck(String devPikCheck) {
        this.devPikCheck = devPikCheck == null ? null : devPikCheck.trim();
    }

    public String getDevMak() {
        return devMak;
    }

    public void setDevMak(String devMak) {
        this.devMak = devMak == null ? null : devMak.trim();
    }

    public String getDevMakCheck() {
        return devMakCheck;
    }

    public void setDevMakCheck(String devMakCheck) {
        this.devMakCheck = devMakCheck == null ? null : devMakCheck.trim();
    }

    public String getDevTk() {
        return devTk;
    }

    public void setDevTk(String devTk) {
        this.devTk = devTk == null ? null : devTk.trim();
    }

    public String getDevTkCheck() {
        return devTkCheck;
    }

    public void setDevTkCheck(String devTkCheck) {
        this.devTkCheck = devTkCheck == null ? null : devTkCheck.trim();
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }

    public String getRadius() {
        return radius;
    }

    public void setRadius(String radius) {
        this.radius = radius == null ? null : radius.trim();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public String getDevOnadd() {
        return devOnadd;
    }

    public void setDevOnadd(String devOnadd) {
        this.devOnadd = devOnadd == null ? null : devOnadd.trim();
    }

    public String getBusiType() {
        return busiType;
    }

    public void setBusiType(String busiType) {
        this.busiType = busiType == null ? null : busiType.trim();
    }

    public String getScanCode() {
        return scanCode;
    }

    public void setScanCode(String scanCode) {
        this.scanCode = scanCode == null ? null : scanCode.trim();
    }

    public String getMscCode() {
        return mscCode;
    }

    public void setMscCode(String mscCode) {
        this.mscCode = mscCode == null ? null : mscCode.trim();
    }

    public String getTouchIcRead() {
        return touchIcRead;
    }

    public void setTouchIcRead(String touchIcRead) {
        this.touchIcRead = touchIcRead == null ? null : touchIcRead.trim();
    }

    public String getNonTouchIcRead() {
        return nonTouchIcRead;
    }

    public void setNonTouchIcRead(String nonTouchIcRead) {
        this.nonTouchIcRead = nonTouchIcRead == null ? null : nonTouchIcRead.trim();
    }

    public String getNoCardPady() {
        return noCardPady;
    }

    public void setNoCardPady(String noCardPady) {
        this.noCardPady = noCardPady == null ? null : noCardPady.trim();
    }

    public String getLyName() {
        return lyName;
    }

    public void setLyName(String lyName) {
        this.lyName = lyName == null ? null : lyName.trim();
    }

    public String getLyDate() {
        return lyDate;
    }

    public void setLyDate(String lyDate) {
        this.lyDate = lyDate == null ? null : lyDate.trim();
    }

    public String getDevOpId() {
        return devOpId;
    }

    public void setDevOpId(String devOpId) {
        this.devOpId = devOpId == null ? null : devOpId.trim();
    }

    public String getStampDatetime() {
        return stampDatetime;
    }

    public void setStampDatetime(String stampDatetime) {
        this.stampDatetime = stampDatetime == null ? null : stampDatetime.trim();
    }

    public String getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(String createDatetime) {
        this.createDatetime = createDatetime == null ? null : createDatetime.trim();
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

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId == null ? null : modelId.trim();
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId == null ? null : brandId.trim();
    }

    public String getDeviceHwVersion() {
        return deviceHwVersion;
    }

    public void setDeviceHwVersion(String deviceHwVersion) {
        this.deviceHwVersion = deviceHwVersion == null ? null : deviceHwVersion.trim();
    }

    public String getDeviceSwVersion() {
        return deviceSwVersion;
    }

    public void setDeviceSwVersion(String deviceSwVersion) {
        this.deviceSwVersion = deviceSwVersion == null ? null : deviceSwVersion.trim();
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName == null ? null : merchantName.trim();
    }

    public IPage getPage() {
        return Page;
    }

    public void setPage(IPage page) {
        Page = page;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getModelTypeName() {
        if("1".equals(modelTypeId)){
            return "Fixed POS";
        }else if("2".equals(modelTypeId)){
            return "Traditional POS";
        }else {
            return "Intelligent POS";
        }
    }

    public void setModelTypeName(String modelTypeName) {
        this.modelTypeName = modelTypeName;
    }

    public String getDeviceStatusName() {
        if("0".equals(deviceStatus)){
            return "disable";
        }else if("1".equals(deviceStatus)){
            return "enable";
        }else if("2".equals(deviceStatus)){
            return "stop";
        }else if("3".equals(deviceStatus)){
            return "deleted";
        }else{
            return null;
        }

    }

    public void setDeviceStatusName(String deviceStatusName) {
        this.deviceStatusName = deviceStatusName;
    }

    public String getModelTypeId() {
        return modelTypeId;
    }

    public void setModelTypeId(String modelTypeId) {
        this.modelTypeId = modelTypeId;
    }

    public String getKeyStatus() {
        if(devTmk==null){
            return "not bound";
        }else{
            return "bound";
        }
    }

    public void setKeyStatus(String keyStatus) {
        this.keyStatus = keyStatus;
    }

    /**
     * @return the mchntName
     */
    public String getMchntName() {
        return mchntName;
    }

    /**
     * @param mchntName the mchntName to set
     */
    public void setMchntName(String mchntName) {
        this.mchntName = mchntName;
    }

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
    
    
    
}