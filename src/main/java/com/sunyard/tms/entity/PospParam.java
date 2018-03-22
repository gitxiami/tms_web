package com.sunyard.tms.entity;

import java.io.Serializable;

import com.sunyard.tms.utils.IPage;

public class PospParam extends PospParamKey implements Serializable {
    private String paramLen;

    private String paramVal;

    private String paramVer;

    private String createOprater;

    private String createDatetime;

    private String updateDatetime;

    private static final long serialVersionUID = 1L;
    
    // --以下字段为过程中使用---//
  	/**
  	 * 分页封装实体
  	 */
  	private IPage Page;

    public String getParamLen() {
        return paramLen;
    }

    public void setParamLen(String paramLen) {
        this.paramLen = paramLen == null ? null : paramLen.trim();
    }

    public String getParamVal() {
        return paramVal;
    }

    public void setParamVal(String paramVal) {
        this.paramVal = paramVal == null ? null : paramVal.trim();
    }

    public String getParamVer() {
        return paramVer;
    }

    public void setParamVer(String paramVer) {
        this.paramVer = paramVer == null ? null : paramVer.trim();
    }

    public String getCreateOprater() {
        return createOprater;
    }

    public void setCreateOprater(String createOprater) {
        this.createOprater = createOprater == null ? null : createOprater.trim();
    }

    public String getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(String createDatetime) {
        this.createDatetime = createDatetime == null ? null : createDatetime.trim();
    }

    public String getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(String updateDatetime) {
        this.updateDatetime = updateDatetime == null ? null : updateDatetime.trim();
    }

	public IPage getPage() {
		return Page;
	}

	public void setPage(IPage page) {
		Page = page;
	}
}