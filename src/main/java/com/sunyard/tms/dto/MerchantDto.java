package com.sunyard.tms.dto;

import com.sunyard.tms.constant.StatusConstants;

/**
 * @Description:
 * @author:zhangbin
 */
public class MerchantDto {
    //商户编号
    private String mchntId;
    //商户名称
    private String mchntName;
    //商户服务类型
    private String mchntSvcTp;
    //法人代表
    private String artifNm;
    //所属支行ID
    private String orgId;
    //所属支行名称
    private String orgName;
    //商户状态
    private String status;
    //商户状态名称
    private String statusName;

    public MerchantDto() {
        super();
    }

    public MerchantDto(String mchntId, String mchntName, String mchntSvcTp, String artifNm, String orgId, String orgName, String status, String statusName) {
        this.mchntId = mchntId;
        this.mchntName = mchntName;
        this.mchntSvcTp = mchntSvcTp;
        this.artifNm = artifNm;
        this.orgId = orgId;
        this.orgName = orgName;
        this.status = status;
        this.statusName = statusName;
    }

    public String getMchntId() {
        return mchntId;
    }

    public void setMchntId(String mchntId) {
        this.mchntId = mchntId;
    }

    public String getMchntName() {
        return mchntName;
    }

    public void setMchntName(String mchntName) {
        this.mchntName = mchntName;
    }

    public String getMchntSvcTp() {
        return mchntSvcTp;
    }

    public void setMchntSvcTp(String mchntSvcTp) {
        this.mchntSvcTp = mchntSvcTp;
    }

    public String getArtifNm() {
        return artifNm;
    }

    public void setArtifNm(String artifNm) {
        this.artifNm = artifNm;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 商户状态
     0-未启用状态
     1-启用状态
     2-停用状态
     3-注销状态
     4-锁定状态
     */
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
}
