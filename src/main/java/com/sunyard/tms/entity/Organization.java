package com.sunyard.tms.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.List;

public class Organization implements Serializable {
    private String orgId;

    private String orgName;

    private String orgPid;

    private String orgLv;

    private String orgStatus;

    private String orgAddress;

    private String orgLinkman;

    private String orgTel;

    private String orgRemark;

    private String orgType;

    private String createdDatetime;

    private String updateDatetime;

    private String orgParentName;

    @JSONField(serialize=false)
    private String bak1;
    @JSONField(serialize=false)
    private String bak2;
    @JSONField(serialize=false)
    private String bak3;

    private String orgLvName;

    private String orgTypeName;

    private List<Organization> children;

    private static final long serialVersionUID = 1L;

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

    public String getOrgPid() {
        return orgPid;
    }

    public void setOrgPid(String orgPid) {
        this.orgPid = orgPid == null ? null : orgPid.trim();
    }

    public String getOrgLv() {
        return orgLv;
    }

    public void setOrgLv(String orgLv) {
        this.orgLv = orgLv == null ? null : orgLv.trim();
    }

    public String getOrgStatus() {
        return orgStatus;
    }

    public void setOrgStatus(String orgStatus) {
        this.orgStatus = orgStatus == null ? null : orgStatus.trim();
    }

    public String getOrgAddress() {
        return orgAddress;
    }

    public void setOrgAddress(String orgAddress) {
        this.orgAddress = orgAddress == null ? null : orgAddress.trim();
    }

    public String getOrgLinkman() {
        return orgLinkman;
    }

    public void setOrgLinkman(String orgLinkman) {
        this.orgLinkman = orgLinkman == null ? null : orgLinkman.trim();
    }

    public String getOrgTel() {
        return orgTel;
    }

    public void setOrgTel(String orgTel) {
        this.orgTel = orgTel == null ? null : orgTel.trim();
    }

    public String getOrgRemark() {
        return orgRemark;
    }

    public void setOrgRemark(String orgRemark) {
        this.orgRemark = orgRemark == null ? null : orgRemark.trim();
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

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType == null ? null : orgType.trim();
    }

    public String getOrgLvName() {
        if("0".equals(orgLv)){
            return "headquarters";
        }else if ("1".equals(orgLv)){
            return "branch";
        }else if("2".equals(orgLv)){
            return "subBranch";
        }else {
            return "office";
        }
    }

    public void setOrgLvName(String orgLvName) {
        this.orgLvName = orgLvName;
    }

    public String getOrgTypeName() {
        if("0".equals(orgType)){
            return "clearing agencies";
        }else {
            return "administrative agencies";
        }
    }

    public void setOrgTypeName(String orgTypeName) {
        this.orgTypeName = orgTypeName;
    }

    public List<Organization> getChildren() {
        return children;
    }

    public void setChildren(List<Organization> children) {
        this.children = children;
    }

    public String getOrgParentName() {
        return orgParentName;
    }

    public void setOrgParentName(String orgParentName) {
        this.orgParentName = orgParentName;
    }
}