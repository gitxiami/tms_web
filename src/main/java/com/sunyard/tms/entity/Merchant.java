package com.sunyard.tms.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.sunyard.tms.constant.StatusConstants;

import java.io.Serializable;
import java.util.List;

public class Merchant implements Serializable {
    private String mchntId;
    @JSONField(serialize=false)
    private String mchntUsername;

    private String orgId;

    private String orgName;
    @JSONField(serialize=false)
    private String dvpBy;
    @JSONField(serialize=false)
    private String mchntSvcTp;
    @JSONField(serialize=false)
    private String agrMchntCd;
    @JSONField(serialize=false)
    private String agrMchntStatus;
    @JSONField(serialize=false)
    private String mccCd18;
    @JSONField(serialize=false)
    private String businessScope;

    private String mchntName;

    private String mchntAbbr;
    @JSONField(serialize=false)
    private String netMchntSvcTp;
    @JSONField(serialize=false)
    private String licNo;

    private String bussAddr;

    private String artifNm;
    
    private String artifCertifTp;
  
    private String artifCertifId;

    private String regAddr;
    @JSONField(serialize=false)
    private String settleNo;
    @JSONField(serialize=false)
    private String accountName;
    @JSONField(serialize=false)
    private String settleBank;
    @JSONField(serialize=false)
    private String settleBranchCode;
    @JSONField(serialize=false)
    private String t0Scope;
    @JSONField(serialize=false)
    private String etpsAttr;
    
    private String commAddr;
    @JSONField(serialize=false)
    private String phoneNo;

    private String mobileNo;
    @JSONField(serialize=false)
    private String longitude;
    @JSONField(serialize=false)
    private String latitude;
    @JSONField(serialize=false)
    private String radius;
    @JSONField(serialize=false)
    private String roleId;

    private String status;
    @JSONField(serialize=false)
    private String mchntLimitStatus;
    @JSONField(serialize=false)
    private String transStatus;
    @JSONField(serialize=false)
    private String mccApplRule;
    @JSONField(serialize=false)
    private String mchntFeeType;
    @JSONField(serialize=false)
    private String opId;
    @JSONField(serialize=false)
    private String createDatetime;
    @JSONField(serialize=false)
    private String registerDatetime;
    @JSONField(serialize=false)
    private String updateDatetime;
    @JSONField(serialize=false)
    private String bak1;
    @JSONField(serialize=false)
    private String bak2;
    @JSONField(serialize=false)
    private String bak3;
    @JSONField(serialize=false)
    private List<String> deviceIds;

    //商户状态名称
    private String statusName;

    private static final long serialVersionUID = 1L;

    public String getMchntId() {
        return mchntId;
    }

    public void setMchntId(String mchntId) {
        this.mchntId = mchntId == null ? null : mchntId.trim();
    }

    public String getMchntUsername() {
        return mchntUsername;
    }

    public void setMchntUsername(String mchntUsername) {
        this.mchntUsername = mchntUsername == null ? null : mchntUsername.trim();
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    public String getDvpBy() {
        return dvpBy;
    }

    public void setDvpBy(String dvpBy) {
        this.dvpBy = dvpBy == null ? null : dvpBy.trim();
    }

    public String getMchntSvcTp() {
        return mchntSvcTp;
    }

    public void setMchntSvcTp(String mchntSvcTp) {
        this.mchntSvcTp = mchntSvcTp == null ? null : mchntSvcTp.trim();
    }

    public String getAgrMchntCd() {
        return agrMchntCd;
    }

    public void setAgrMchntCd(String agrMchntCd) {
        this.agrMchntCd = agrMchntCd == null ? null : agrMchntCd.trim();
    }

    public String getAgrMchntStatus() {
        return agrMchntStatus;
    }

    public void setAgrMchntStatus(String agrMchntStatus) {
        this.agrMchntStatus = agrMchntStatus == null ? null : agrMchntStatus.trim();
    }

    public String getMccCd18() {
        return mccCd18;
    }

    public void setMccCd18(String mccCd18) {
        this.mccCd18 = mccCd18 == null ? null : mccCd18.trim();
    }

    public String getBusinessScope() {
        return businessScope;
    }

    public void setBusinessScope(String businessScope) {
        this.businessScope = businessScope == null ? null : businessScope.trim();
    }

    public String getMchntName() {
        return mchntName;
    }

    public void setMchntName(String mchntName) {
        this.mchntName = mchntName == null ? null : mchntName.trim();
    }

    public String getMchntAbbr() {
        return mchntAbbr;
    }

    public void setMchntAbbr(String mchntAbbr) {
        this.mchntAbbr = mchntAbbr == null ? null : mchntAbbr.trim();
    }

    public String getNetMchntSvcTp() {
        return netMchntSvcTp;
    }

    public void setNetMchntSvcTp(String netMchntSvcTp) {
        this.netMchntSvcTp = netMchntSvcTp == null ? null : netMchntSvcTp.trim();
    }

    public String getLicNo() {
        return licNo;
    }

    public void setLicNo(String licNo) {
        this.licNo = licNo == null ? null : licNo.trim();
    }

    public String getBussAddr() {
        return bussAddr;
    }

    public void setBussAddr(String bussAddr) {
        this.bussAddr = bussAddr == null ? null : bussAddr.trim();
    }

    public String getArtifNm() {
        return artifNm;
    }

    public void setArtifNm(String artifNm) {
        this.artifNm = artifNm == null ? null : artifNm.trim();
    }

    public String getArtifCertifTp() {
        return artifCertifTp;
    }

    public void setArtifCertifTp(String artifCertifTp) {
        this.artifCertifTp = artifCertifTp == null ? null : artifCertifTp.trim();
    }

    public String getArtifCertifId() {
        return artifCertifId;
    }

    public void setArtifCertifId(String artifCertifId) {
        this.artifCertifId = artifCertifId == null ? null : artifCertifId.trim();
    }

    public String getRegAddr() {
        return regAddr;
    }

    public void setRegAddr(String regAddr) {
        this.regAddr = regAddr == null ? null : regAddr.trim();
    }

    public String getSettleNo() {
        return settleNo;
    }

    public void setSettleNo(String settleNo) {
        this.settleNo = settleNo == null ? null : settleNo.trim();
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName == null ? null : accountName.trim();
    }

    public String getSettleBank() {
        return settleBank;
    }

    public void setSettleBank(String settleBank) {
        this.settleBank = settleBank == null ? null : settleBank.trim();
    }

    public String getSettleBranchCode() {
        return settleBranchCode;
    }

    public void setSettleBranchCode(String settleBranchCode) {
        this.settleBranchCode = settleBranchCode == null ? null : settleBranchCode.trim();
    }

    public String getT0Scope() {
        return t0Scope;
    }

    public void setT0Scope(String t0Scope) {
        this.t0Scope = t0Scope == null ? null : t0Scope.trim();
    }

    public String getEtpsAttr() {
        return etpsAttr;
    }

    public void setEtpsAttr(String etpsAttr) {
        this.etpsAttr = etpsAttr == null ? null : etpsAttr.trim();
    }

    public String getCommAddr() {
        return commAddr;
    }

    public void setCommAddr(String commAddr) {
        this.commAddr = commAddr == null ? null : commAddr.trim();
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo == null ? null : phoneNo.trim();
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo == null ? null : mobileNo.trim();
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

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getMchntLimitStatus() {
        return mchntLimitStatus;
    }

    public void setMchntLimitStatus(String mchntLimitStatus) {
        this.mchntLimitStatus = mchntLimitStatus == null ? null : mchntLimitStatus.trim();
    }

    public String getTransStatus() {
        return transStatus;
    }

    public void setTransStatus(String transStatus) {
        this.transStatus = transStatus == null ? null : transStatus.trim();
    }

    public String getMccApplRule() {
        return mccApplRule;
    }

    public void setMccApplRule(String mccApplRule) {
        this.mccApplRule = mccApplRule == null ? null : mccApplRule.trim();
    }

    public String getMchntFeeType() {
        return mchntFeeType;
    }

    public void setMchntFeeType(String mchntFeeType) {
        this.mchntFeeType = mchntFeeType == null ? null : mchntFeeType.trim();
    }

    public String getOpId() {
        return opId;
    }

    public void setOpId(String opId) {
        this.opId = opId == null ? null : opId.trim();
    }

    public String getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(String createDatetime) {
        this.createDatetime = createDatetime == null ? null : createDatetime.trim();
    }

    public String getRegisterDatetime() {
        return registerDatetime;
    }

    public void setRegisterDatetime(String registerDatetime) {
        this.registerDatetime = registerDatetime == null ? null : registerDatetime.trim();
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

    public String getStatusName() {
        if(StatusConstants.MERCHAT_NOTENABLED.equals(status)){
            return "disable";
        }else if(StatusConstants.MERCHAT_ENABLED.equals(status)){
            return "enable";
        }else if (StatusConstants.MERCHAT_STOP.equals(status)){
            return "stop";
        }else if(StatusConstants.MERCHAT_DEL.equals(status)){
            return "deleted";
        }else{
            return "locked";
        }
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public List<String> getDeviceIds() {
        return deviceIds;
    }

    public void setDeviceIds(List<String> deviceIds) {
        this.deviceIds = deviceIds;
    }
}