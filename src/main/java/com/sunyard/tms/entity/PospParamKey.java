package com.sunyard.tms.entity;

import java.io.Serializable;

public class PospParamKey implements Serializable {
    private String paramType;

    private String paramNo;

    private static final long serialVersionUID = 1L;

    public String getParamType() {
        return paramType;
    }

    public void setParamType(String paramType) {
        this.paramType = paramType == null ? null : paramType.trim();
    }

    public String getParamNo() {
        return paramNo;
    }

    public void setParamNo(String paramNo) {
        this.paramNo = paramNo == null ? null : paramNo.trim();
    }
}