package com.sunyard.tms.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

public class TerminalKey implements Serializable {
    private String keyId;

    private String createTime;

    private String description;

    private String tmsCode;

    private String tmk;

    private String tak;

    private String tmkReferenceNo;

    private String checksum;

    private String filler;

    @JSONField(serialize=false)
    private String createdDatetime;
    @JSONField(serialize=false)
    private String updateDatetime;
    @JSONField(serialize=false)
    private String bak1;
    @JSONField(serialize=false)
    private String bak2;
    @JSONField(serialize=false)
    private String bak3;

    private String useFlag;

    private String useFlagName;

    private static final long serialVersionUID = 1L;

    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId == null ? null : keyId.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getTmsCode() {
        return tmsCode;
    }

    public void setTmsCode(String tmsCode) {
        this.tmsCode = tmsCode == null ? null : tmsCode.trim();
    }

    public String getTmk() {
        return tmk;
    }

    public void setTmk(String tmk) {
        this.tmk = tmk == null ? null : tmk.trim();
    }

    public String getTak() {
        return tak;
    }

    public void setTak(String tak) {
        this.tak = tak == null ? null : tak.trim();
    }

    public String getTmkReferenceNo() {
        return tmkReferenceNo;
    }

    public void setTmkReferenceNo(String tmkReferenceNo) {
        this.tmkReferenceNo = tmkReferenceNo == null ? null : tmkReferenceNo.trim();
    }

    public String getChecksum() {
        return checksum;
    }

    public void setChecksum(String checksum) {
        this.checksum = checksum == null ? null : checksum.trim();
    }

    public String getFiller() {
        return filler;
    }

    public void setFiller(String filler) {
        this.filler = filler == null ? null : filler.trim();
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

    public String getUseFlag() {
        return useFlag;
    }

    public void setUseFlag(String useFlag) {
        this.useFlag = useFlag == null ? null : useFlag.trim();
    }

    public String getUseFlagName() {
        if ("0".equals(useFlag)){
            return "in use";
        }else if ("1".equals(useFlag)){
            return "out of use";
        }
        return null;
    }

    public void setUseFlagName(String useFlagName) {
        this.useFlagName = useFlagName;
    }
}