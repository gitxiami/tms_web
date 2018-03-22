package com.sunyard.tms.entity;

import java.io.Serializable;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.sunyard.tms.dto.DeviceType;
import com.sunyard.tms.utils.IPage;

public class Brand implements Serializable {
    private String brandId;

    private String brandName;

    private String brandLinkman;

    private String brandTel;
    @JSONField(serialize=false)
    private String tmsDynamicLibraryPath;
    @JSONField(serialize=false)
    private String tmsRuleLibraryPath;
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

  	private String id;

  	private String name;

  	private List<DeviceType> children;

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId == null ? null : brandId.trim();
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName == null ? null : brandName.trim();
    }

    public String getBrandLinkman() {
        return brandLinkman;
    }

    public void setBrandLinkman(String brandLinkman) {
        this.brandLinkman = brandLinkman == null ? null : brandLinkman.trim();
    }

    public String getBrandTel() {
        return brandTel;
    }

    public void setBrandTel(String brandTel) {
        this.brandTel = brandTel == null ? null : brandTel.trim();
    }

    public String getTmsDynamicLibraryPath() {
        return tmsDynamicLibraryPath;
    }

    public void setTmsDynamicLibraryPath(String tmsDynamicLibraryPath) {
        this.tmsDynamicLibraryPath = tmsDynamicLibraryPath == null ? null : tmsDynamicLibraryPath.trim();
    }

    public String getTmsRuleLibraryPath() {
        return tmsRuleLibraryPath;
    }

    public void setTmsRuleLibraryPath(String tmsRuleLibraryPath) {
        this.tmsRuleLibraryPath = tmsRuleLibraryPath == null ? null : tmsRuleLibraryPath.trim();
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

    public String getId() {
        return brandId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return brandName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<DeviceType> getChildren() {
        return children;
    }

    public void setChildren(List<DeviceType> children) {
        this.children = children;
    }
}