package com.sunyard.tms.entity;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;
import com.sunyard.tms.utils.IPage;

public class Model implements Serializable {
    private String modelId;
    private String modelName;
    private String brandId;
    private String modelTypeId;
    private String modelTypeName;
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
  	 * 关联字段 厂商名称
  	 */
  	private String brandName;

  	private String id;

  	private String name;

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId == null ? null : modelId.trim();
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName == null ? null : modelName.trim();
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId == null ? null : brandId.trim();
    }

    public String getModelTypeId() {
        return modelTypeId;
    }

    public void setModelTypeId(String modelTypeId) {
        this.modelTypeId = modelTypeId == null ? null : modelTypeId.trim();
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

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
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

    public String getId() {
        return modelId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return modelName;
    }

    public void setName(String name) {
        this.name = name;
    }
}