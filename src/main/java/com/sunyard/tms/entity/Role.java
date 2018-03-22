package com.sunyard.tms.entity;

import java.io.Serializable;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.common.base.Strings;
import com.sunyard.tms.constant.StatusConstants;
import com.sunyard.tms.utils.IPage;

public class Role implements Serializable {
    private String roleId;

    private String roleName;
    @JSONField(serialize=false)
    private String roleType;

    private String roleRemark;
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

    private static final long serialVersionUID = 1L;
    
    // --以下字段为过程中使用---//
 	/**
 	 * 分页封装实体
 	 */
 	private IPage Page;
 	
 	/**
	 * 关联键 权限ID 前端传来的以,分隔的权限id
	 */
	private String popedomIds;
	private List<String> popedomIdList;
	
	/**
	 * 角色类型名称
	 */
	private String roleTypeName;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType == null ? null : roleType.trim();
    }

    public String getRoleRemark() {
        return roleRemark;
    }

    public void setRoleRemark(String roleRemark) {
        this.roleRemark = roleRemark == null ? null : roleRemark.trim();
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

	public String getPopedomIds() {
		return popedomIds;
	}

	public void setPopedomIds(String popedomIds) {
		this.popedomIds = popedomIds;
	}

	public List<String> getPopedomIdList() {
		return popedomIdList;
	}

	public void setPopedomIdList(List<String> popedomIdList) {
		this.popedomIdList = popedomIdList;
	}

	/**
	 * @Description:根据角色类型编号获取角色类型名称
	 * @return String
	 */
	public String getRoleTypeName() {
		if (!Strings.isNullOrEmpty(roleType)) {
			if(roleType.equals(StatusConstants.ROLE_BPS)){
	            return "业务";
	        }else if(roleType.equals(StatusConstants.ROLE_BMS)){
	            return "管理";
	        }else {
	            return "其他";
	        }  
		} else {
			return roleTypeName;
		}
	}

	public void setRoleTypeName(String roleTypeName) {
		this.roleTypeName = roleTypeName;
	}
}