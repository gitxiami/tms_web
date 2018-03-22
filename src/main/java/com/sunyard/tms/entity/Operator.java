package com.sunyard.tms.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.List;

public class Operator implements Serializable {
    private String opId;

    private String opUsername;

    private String opPwd;

    private String opRealname;

    private String opStatus;

    private String opTel;

    private Integer opPwdErrnum;

    private String opRemark;

    private String opLastLoginTime;

    private String opErrortime;

    private String roleId;

    private String orgId;

    private String createdDatetime;

    private String updateDatetime;
    @JSONField(serialize=false)
    private String bak1;
    @JSONField(serialize=false)
    private String bak2;
    @JSONField(serialize=false)
    private String bak3;
    @JSONField(serialize=false)
    private String message;
    @JSONField(serialize=false)
    private List<String> orgIds;

    private static final long serialVersionUID = 1L;

    public String getOpId() {
        return opId;
    }

    public void setOpId(String opId) {
        this.opId = opId == null ? null : opId.trim();
    }

    public String getOpUsername() {
        return opUsername;
    }

    public void setOpUsername(String opUsername) {
        this.opUsername = opUsername == null ? null : opUsername.trim();
    }

    public String getOpPwd() {
        return opPwd;
    }

    public void setOpPwd(String opPwd) {
        this.opPwd = opPwd == null ? null : opPwd.trim();
    }

    public String getOpRealname() {
        return opRealname;
    }

    public void setOpRealname(String opRealname) {
        this.opRealname = opRealname == null ? null : opRealname.trim();
    }

    public String getOpStatus() {
        return opStatus;
    }

    public void setOpStatus(String opStatus) {
        this.opStatus = opStatus == null ? null : opStatus.trim();
    }

    public String getOpTel() {
        return opTel;
    }

    public void setOpTel(String opTel) {
        this.opTel = opTel == null ? null : opTel.trim();
    }

    public Integer getOpPwdErrnum() {
        return opPwdErrnum;
    }

    public void setOpPwdErrnum(Integer opPwdErrnum) {
        this.opPwdErrnum = opPwdErrnum;
    }

    public String getOpRemark() {
        return opRemark;
    }

    public void setOpRemark(String opRemark) {
        this.opRemark = opRemark == null ? null : opRemark.trim();
    }

    public String getOpLastLoginTime() {
        return opLastLoginTime;
    }

    public void setOpLastLoginTime(String opLastLoginTime) {
        this.opLastLoginTime = opLastLoginTime == null ? null : opLastLoginTime.trim();
    }

    public String getOpErrortime() {
        return opErrortime;
    }

    public void setOpErrortime(String opErrortime) {
        this.opErrortime = opErrortime == null ? null : opErrortime.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getOrgIds() {
        return orgIds;
    }

    public void setOrgIds(List<String> orgIds) {
        this.orgIds = orgIds;
    }
}