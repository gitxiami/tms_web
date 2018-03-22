/**
 * 
 */
package com.sunyard.tms.dto;

import java.io.Serializable;

import com.sunyard.tms.constant.StatusConstants;
/**
 * @Description:用户查询映射结果类
 * @author:zhangbin
 * @date:2017年7月14日 下午3:38:37
 */
public class OperatorDto  implements Serializable{
    private static final long serialVersionUID = 3312392663056606634L;
    // 用户Id,主键
    private String opId;
    // 用户名,登录号
    private String opUsername;
    // 真实姓名
    private String opRealname;
    // 联系电话
    private String opTel;
    // 所属机构
    private String orgName;
    private String orgId;
    private String roleId;
    // 所属角色
    private String roleName;

    private String opRemark;
    // 用户状态
    private String opStatus;
    // 状态名称
    private String opStatusName;

    public String getOpId() {
        return opId;
    }

    public void setOpId(String opId) {
        this.opId = opId;
    }

    public String getOpUsername() {
        return opUsername;
    }

    public void setOpUsername(String opUsername) {
        this.opUsername = opUsername;
    }

    public String getOpRealname() {
        return opRealname;
    }

    public void setOpRealname(String opRealname) {
        this.opRealname = opRealname;
    }


    public String getOpTel() {
        return opTel;
    }

    public void setOpTel(String opTel) {
        this.opTel = opTel;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getOpStatus() {
        return opStatus;
    }

    public void setOpStatus(String opStatus) {
        this.opStatus = opStatus;
    }

    /**
     * @return the orgId
     */
    public String getOrgId() {
        return orgId;
    }

    /**
     * @param orgId the orgId to set
     */
    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    /**
     * @return the roleId
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * @param roleId the roleId to set
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    /**
     * @return the opRemark
     */
    public String getOpRemark() {
        return opRemark;
    }

    /**
     * @param opRemark the opRemark to set
     */
    public void setOpRemark(String opRemark) {
        this.opRemark = opRemark;
    }

    /**
     * @return the opStatusName
     */
    public String getOpStatusName() {
        if (opStatus.equals(StatusConstants.OPERATPR_NORMAL)) {
            return "normal";
        } else if (opStatus.equals(StatusConstants.OPERATPR_LOCK)) {
            return "locked";
        } else {
            return "deleted";
        }
    }

    /**
     * @param opStatusName the opStatusName to set
     */
    public void setOpStatusName(String opStatusName) {
        this.opStatusName = opStatusName;
    }
    
}
