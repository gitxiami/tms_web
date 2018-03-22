package com.sunyard.tms.dto;

import com.sunyard.tms.entity.App;
import com.sunyard.tms.entity.AppPackage;

/**
 * @Description:
 * @author:zhangbin
 * @date:${date} ${time}
 */
public class AppDto extends App {
    private String BrandName;
    private String modelTypeId;
    private String ModelName;
    private String appStatusName;
    private String modelTypeName;
    private String orgName;
    
	public String getBrandName() {
        return BrandName;
    }

    public void setBrandName(String brandName) {
        BrandName = brandName;
    }

    public String getModelName() {
        return ModelName;
    }

    public void setModelName(String modelName) {
        ModelName = modelName;
    }

    public String getAppStatusName() {
        if ("0".equals(this.getAppStatus())){
            return "ready";
        }else if ("1".equals(this.getAppStatus())){
            return "online";
        }else {
            return "offline";
        }
    }

    public void setAppStatusName(String appStatusName) {
        this.appStatusName = appStatusName;
    }

    public String getModelTypeId() {
        return modelTypeId;
    }

    public void setModelTypeId(String modelTypeId) {
        this.modelTypeId = modelTypeId;
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

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
}
