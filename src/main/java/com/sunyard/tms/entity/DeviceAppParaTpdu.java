package com.sunyard.tms.entity;

import java.io.Serializable;

public class DeviceAppParaTpdu implements Serializable {
    private String tpduId;

    private String paraId;

    private String code;

    private String val;

    private static final long serialVersionUID = 1L;

    public String getTpduId() {
        return tpduId;
    }

    public void setTpduId(String tpduId) {
        this.tpduId = tpduId == null ? null : tpduId.trim();
    }

    public String getParaId() {
        return paraId;
    }

    public void setParaId(String paraId) {
        this.paraId = paraId == null ? null : paraId.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val == null ? null : val.trim();
    }
}