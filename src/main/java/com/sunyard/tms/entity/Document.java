package com.sunyard.tms.entity;

import java.io.Serializable;

/**
 * @author zhangbin
 */
public class Document implements Serializable {
    private String docId;

    private String docName;

    private String docDesc;

    private String docFilePath;

    private String docFolderPath;

    private String docLen;

    private String createdDatetime;

    private String updateDatetime;

    private String bak1;

    private String bak2;

    private String bak3;

    private String docVer;

    private static final long serialVersionUID = 1L;

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId == null ? null : docId.trim();
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName == null ? null : docName.trim();
    }

    public String getDocDesc() {
        return docDesc;
    }

    public void setDocDesc(String docDesc) {
        this.docDesc = docDesc == null ? null : docDesc.trim();
    }

    public String getDocFilePath() {
        return docFilePath;
    }

    public void setDocFilePath(String docFilePath) {
        this.docFilePath = docFilePath == null ? null : docFilePath.trim();
    }

    public String getDocFolderPath() {
        return docFolderPath;
    }

    public void setDocFolderPath(String docFolderPath) {
        this.docFolderPath = docFolderPath == null ? null : docFolderPath.trim();
    }

    public String getDocLen() {
        return docLen;
    }

    public void setDocLen(String docLen) {
        this.docLen = docLen == null ? null : docLen.trim();
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

    public String getDocVer() {
        return docVer;
    }

    public void setDocVer(String docVer) {
        this.docVer = docVer == null ? null : docVer.trim();
    }
}