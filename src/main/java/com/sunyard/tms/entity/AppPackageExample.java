package com.sunyard.tms.entity;

import java.util.ArrayList;
import java.util.List;

public class AppPackageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AppPackageExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andAppIdIsNull() {
            addCriterion("APP_ID is null");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNotNull() {
            addCriterion("APP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAppIdEqualTo(String value) {
            addCriterion("APP_ID =", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotEqualTo(String value) {
            addCriterion("APP_ID <>", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThan(String value) {
            addCriterion("APP_ID >", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThanOrEqualTo(String value) {
            addCriterion("APP_ID >=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThan(String value) {
            addCriterion("APP_ID <", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThanOrEqualTo(String value) {
            addCriterion("APP_ID <=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLike(String value) {
            addCriterion("APP_ID like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotLike(String value) {
            addCriterion("APP_ID not like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdIn(List<String> values) {
            addCriterion("APP_ID in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotIn(List<String> values) {
            addCriterion("APP_ID not in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdBetween(String value1, String value2) {
            addCriterion("APP_ID between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotBetween(String value1, String value2) {
            addCriterion("APP_ID not between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andAppPkgVerIsNull() {
            addCriterion("APP_PKG_VER is null");
            return (Criteria) this;
        }

        public Criteria andAppPkgVerIsNotNull() {
            addCriterion("APP_PKG_VER is not null");
            return (Criteria) this;
        }

        public Criteria andAppPkgVerEqualTo(String value) {
            addCriterion("APP_PKG_VER =", value, "appPkgVer");
            return (Criteria) this;
        }

        public Criteria andAppPkgVerNotEqualTo(String value) {
            addCriterion("APP_PKG_VER <>", value, "appPkgVer");
            return (Criteria) this;
        }

        public Criteria andAppPkgVerGreaterThan(String value) {
            addCriterion("APP_PKG_VER >", value, "appPkgVer");
            return (Criteria) this;
        }

        public Criteria andAppPkgVerGreaterThanOrEqualTo(String value) {
            addCriterion("APP_PKG_VER >=", value, "appPkgVer");
            return (Criteria) this;
        }

        public Criteria andAppPkgVerLessThan(String value) {
            addCriterion("APP_PKG_VER <", value, "appPkgVer");
            return (Criteria) this;
        }

        public Criteria andAppPkgVerLessThanOrEqualTo(String value) {
            addCriterion("APP_PKG_VER <=", value, "appPkgVer");
            return (Criteria) this;
        }

        public Criteria andAppPkgVerLike(String value) {
            addCriterion("APP_PKG_VER like", value, "appPkgVer");
            return (Criteria) this;
        }

        public Criteria andAppPkgVerNotLike(String value) {
            addCriterion("APP_PKG_VER not like", value, "appPkgVer");
            return (Criteria) this;
        }

        public Criteria andAppPkgVerIn(List<String> values) {
            addCriterion("APP_PKG_VER in", values, "appPkgVer");
            return (Criteria) this;
        }

        public Criteria andAppPkgVerNotIn(List<String> values) {
            addCriterion("APP_PKG_VER not in", values, "appPkgVer");
            return (Criteria) this;
        }

        public Criteria andAppPkgVerBetween(String value1, String value2) {
            addCriterion("APP_PKG_VER between", value1, value2, "appPkgVer");
            return (Criteria) this;
        }

        public Criteria andAppPkgVerNotBetween(String value1, String value2) {
            addCriterion("APP_PKG_VER not between", value1, value2, "appPkgVer");
            return (Criteria) this;
        }

        public Criteria andAppDownloadFlagIsNull() {
            addCriterion("APP_DOWNLOAD_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andAppDownloadFlagIsNotNull() {
            addCriterion("APP_DOWNLOAD_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andAppDownloadFlagEqualTo(String value) {
            addCriterion("APP_DOWNLOAD_FLAG =", value, "appDownloadFlag");
            return (Criteria) this;
        }

        public Criteria andAppDownloadFlagNotEqualTo(String value) {
            addCriterion("APP_DOWNLOAD_FLAG <>", value, "appDownloadFlag");
            return (Criteria) this;
        }

        public Criteria andAppDownloadFlagGreaterThan(String value) {
            addCriterion("APP_DOWNLOAD_FLAG >", value, "appDownloadFlag");
            return (Criteria) this;
        }

        public Criteria andAppDownloadFlagGreaterThanOrEqualTo(String value) {
            addCriterion("APP_DOWNLOAD_FLAG >=", value, "appDownloadFlag");
            return (Criteria) this;
        }

        public Criteria andAppDownloadFlagLessThan(String value) {
            addCriterion("APP_DOWNLOAD_FLAG <", value, "appDownloadFlag");
            return (Criteria) this;
        }

        public Criteria andAppDownloadFlagLessThanOrEqualTo(String value) {
            addCriterion("APP_DOWNLOAD_FLAG <=", value, "appDownloadFlag");
            return (Criteria) this;
        }

        public Criteria andAppDownloadFlagLike(String value) {
            addCriterion("APP_DOWNLOAD_FLAG like", value, "appDownloadFlag");
            return (Criteria) this;
        }

        public Criteria andAppDownloadFlagNotLike(String value) {
            addCriterion("APP_DOWNLOAD_FLAG not like", value, "appDownloadFlag");
            return (Criteria) this;
        }

        public Criteria andAppDownloadFlagIn(List<String> values) {
            addCriterion("APP_DOWNLOAD_FLAG in", values, "appDownloadFlag");
            return (Criteria) this;
        }

        public Criteria andAppDownloadFlagNotIn(List<String> values) {
            addCriterion("APP_DOWNLOAD_FLAG not in", values, "appDownloadFlag");
            return (Criteria) this;
        }

        public Criteria andAppDownloadFlagBetween(String value1, String value2) {
            addCriterion("APP_DOWNLOAD_FLAG between", value1, value2, "appDownloadFlag");
            return (Criteria) this;
        }

        public Criteria andAppDownloadFlagNotBetween(String value1, String value2) {
            addCriterion("APP_DOWNLOAD_FLAG not between", value1, value2, "appDownloadFlag");
            return (Criteria) this;
        }

        public Criteria andAppPkgLenIsNull() {
            addCriterion("APP_PKG_LEN is null");
            return (Criteria) this;
        }

        public Criteria andAppPkgLenIsNotNull() {
            addCriterion("APP_PKG_LEN is not null");
            return (Criteria) this;
        }

        public Criteria andAppPkgLenEqualTo(String value) {
            addCriterion("APP_PKG_LEN =", value, "appPkgLen");
            return (Criteria) this;
        }

        public Criteria andAppPkgLenNotEqualTo(String value) {
            addCriterion("APP_PKG_LEN <>", value, "appPkgLen");
            return (Criteria) this;
        }

        public Criteria andAppPkgLenGreaterThan(String value) {
            addCriterion("APP_PKG_LEN >", value, "appPkgLen");
            return (Criteria) this;
        }

        public Criteria andAppPkgLenGreaterThanOrEqualTo(String value) {
            addCriterion("APP_PKG_LEN >=", value, "appPkgLen");
            return (Criteria) this;
        }

        public Criteria andAppPkgLenLessThan(String value) {
            addCriterion("APP_PKG_LEN <", value, "appPkgLen");
            return (Criteria) this;
        }

        public Criteria andAppPkgLenLessThanOrEqualTo(String value) {
            addCriterion("APP_PKG_LEN <=", value, "appPkgLen");
            return (Criteria) this;
        }

        public Criteria andAppPkgLenLike(String value) {
            addCriterion("APP_PKG_LEN like", value, "appPkgLen");
            return (Criteria) this;
        }

        public Criteria andAppPkgLenNotLike(String value) {
            addCriterion("APP_PKG_LEN not like", value, "appPkgLen");
            return (Criteria) this;
        }

        public Criteria andAppPkgLenIn(List<String> values) {
            addCriterion("APP_PKG_LEN in", values, "appPkgLen");
            return (Criteria) this;
        }

        public Criteria andAppPkgLenNotIn(List<String> values) {
            addCriterion("APP_PKG_LEN not in", values, "appPkgLen");
            return (Criteria) this;
        }

        public Criteria andAppPkgLenBetween(String value1, String value2) {
            addCriterion("APP_PKG_LEN between", value1, value2, "appPkgLen");
            return (Criteria) this;
        }

        public Criteria andAppPkgLenNotBetween(String value1, String value2) {
            addCriterion("APP_PKG_LEN not between", value1, value2, "appPkgLen");
            return (Criteria) this;
        }

        public Criteria andAppPkgDescIsNull() {
            addCriterion("APP_PKG_DESC is null");
            return (Criteria) this;
        }

        public Criteria andAppPkgDescIsNotNull() {
            addCriterion("APP_PKG_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andAppPkgDescEqualTo(String value) {
            addCriterion("APP_PKG_DESC =", value, "appPkgDesc");
            return (Criteria) this;
        }

        public Criteria andAppPkgDescNotEqualTo(String value) {
            addCriterion("APP_PKG_DESC <>", value, "appPkgDesc");
            return (Criteria) this;
        }

        public Criteria andAppPkgDescGreaterThan(String value) {
            addCriterion("APP_PKG_DESC >", value, "appPkgDesc");
            return (Criteria) this;
        }

        public Criteria andAppPkgDescGreaterThanOrEqualTo(String value) {
            addCriterion("APP_PKG_DESC >=", value, "appPkgDesc");
            return (Criteria) this;
        }

        public Criteria andAppPkgDescLessThan(String value) {
            addCriterion("APP_PKG_DESC <", value, "appPkgDesc");
            return (Criteria) this;
        }

        public Criteria andAppPkgDescLessThanOrEqualTo(String value) {
            addCriterion("APP_PKG_DESC <=", value, "appPkgDesc");
            return (Criteria) this;
        }

        public Criteria andAppPkgDescLike(String value) {
            addCriterion("APP_PKG_DESC like", value, "appPkgDesc");
            return (Criteria) this;
        }

        public Criteria andAppPkgDescNotLike(String value) {
            addCriterion("APP_PKG_DESC not like", value, "appPkgDesc");
            return (Criteria) this;
        }

        public Criteria andAppPkgDescIn(List<String> values) {
            addCriterion("APP_PKG_DESC in", values, "appPkgDesc");
            return (Criteria) this;
        }

        public Criteria andAppPkgDescNotIn(List<String> values) {
            addCriterion("APP_PKG_DESC not in", values, "appPkgDesc");
            return (Criteria) this;
        }

        public Criteria andAppPkgDescBetween(String value1, String value2) {
            addCriterion("APP_PKG_DESC between", value1, value2, "appPkgDesc");
            return (Criteria) this;
        }

        public Criteria andAppPkgDescNotBetween(String value1, String value2) {
            addCriterion("APP_PKG_DESC not between", value1, value2, "appPkgDesc");
            return (Criteria) this;
        }

        public Criteria andAppPkgStatusIsNull() {
            addCriterion("APP_PKG_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andAppPkgStatusIsNotNull() {
            addCriterion("APP_PKG_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andAppPkgStatusEqualTo(String value) {
            addCriterion("APP_PKG_STATUS =", value, "appPkgStatus");
            return (Criteria) this;
        }

        public Criteria andAppPkgStatusNotEqualTo(String value) {
            addCriterion("APP_PKG_STATUS <>", value, "appPkgStatus");
            return (Criteria) this;
        }

        public Criteria andAppPkgStatusGreaterThan(String value) {
            addCriterion("APP_PKG_STATUS >", value, "appPkgStatus");
            return (Criteria) this;
        }

        public Criteria andAppPkgStatusGreaterThanOrEqualTo(String value) {
            addCriterion("APP_PKG_STATUS >=", value, "appPkgStatus");
            return (Criteria) this;
        }

        public Criteria andAppPkgStatusLessThan(String value) {
            addCriterion("APP_PKG_STATUS <", value, "appPkgStatus");
            return (Criteria) this;
        }

        public Criteria andAppPkgStatusLessThanOrEqualTo(String value) {
            addCriterion("APP_PKG_STATUS <=", value, "appPkgStatus");
            return (Criteria) this;
        }

        public Criteria andAppPkgStatusLike(String value) {
            addCriterion("APP_PKG_STATUS like", value, "appPkgStatus");
            return (Criteria) this;
        }

        public Criteria andAppPkgStatusNotLike(String value) {
            addCriterion("APP_PKG_STATUS not like", value, "appPkgStatus");
            return (Criteria) this;
        }

        public Criteria andAppPkgStatusIn(List<String> values) {
            addCriterion("APP_PKG_STATUS in", values, "appPkgStatus");
            return (Criteria) this;
        }

        public Criteria andAppPkgStatusNotIn(List<String> values) {
            addCriterion("APP_PKG_STATUS not in", values, "appPkgStatus");
            return (Criteria) this;
        }

        public Criteria andAppPkgStatusBetween(String value1, String value2) {
            addCriterion("APP_PKG_STATUS between", value1, value2, "appPkgStatus");
            return (Criteria) this;
        }

        public Criteria andAppPkgStatusNotBetween(String value1, String value2) {
            addCriterion("APP_PKG_STATUS not between", value1, value2, "appPkgStatus");
            return (Criteria) this;
        }

        public Criteria andAppPkgFilePathIsNull() {
            addCriterion("APP_PKG_FILE_PATH is null");
            return (Criteria) this;
        }

        public Criteria andAppPkgFilePathIsNotNull() {
            addCriterion("APP_PKG_FILE_PATH is not null");
            return (Criteria) this;
        }

        public Criteria andAppPkgFilePathEqualTo(String value) {
            addCriterion("APP_PKG_FILE_PATH =", value, "appPkgFilePath");
            return (Criteria) this;
        }

        public Criteria andAppPkgFilePathNotEqualTo(String value) {
            addCriterion("APP_PKG_FILE_PATH <>", value, "appPkgFilePath");
            return (Criteria) this;
        }

        public Criteria andAppPkgFilePathGreaterThan(String value) {
            addCriterion("APP_PKG_FILE_PATH >", value, "appPkgFilePath");
            return (Criteria) this;
        }

        public Criteria andAppPkgFilePathGreaterThanOrEqualTo(String value) {
            addCriterion("APP_PKG_FILE_PATH >=", value, "appPkgFilePath");
            return (Criteria) this;
        }

        public Criteria andAppPkgFilePathLessThan(String value) {
            addCriterion("APP_PKG_FILE_PATH <", value, "appPkgFilePath");
            return (Criteria) this;
        }

        public Criteria andAppPkgFilePathLessThanOrEqualTo(String value) {
            addCriterion("APP_PKG_FILE_PATH <=", value, "appPkgFilePath");
            return (Criteria) this;
        }

        public Criteria andAppPkgFilePathLike(String value) {
            addCriterion("APP_PKG_FILE_PATH like", value, "appPkgFilePath");
            return (Criteria) this;
        }

        public Criteria andAppPkgFilePathNotLike(String value) {
            addCriterion("APP_PKG_FILE_PATH not like", value, "appPkgFilePath");
            return (Criteria) this;
        }

        public Criteria andAppPkgFilePathIn(List<String> values) {
            addCriterion("APP_PKG_FILE_PATH in", values, "appPkgFilePath");
            return (Criteria) this;
        }

        public Criteria andAppPkgFilePathNotIn(List<String> values) {
            addCriterion("APP_PKG_FILE_PATH not in", values, "appPkgFilePath");
            return (Criteria) this;
        }

        public Criteria andAppPkgFilePathBetween(String value1, String value2) {
            addCriterion("APP_PKG_FILE_PATH between", value1, value2, "appPkgFilePath");
            return (Criteria) this;
        }

        public Criteria andAppPkgFilePathNotBetween(String value1, String value2) {
            addCriterion("APP_PKG_FILE_PATH not between", value1, value2, "appPkgFilePath");
            return (Criteria) this;
        }

        public Criteria andAppPkgFolderPathIsNull() {
            addCriterion("APP_PKG_FOLDER_PATH is null");
            return (Criteria) this;
        }

        public Criteria andAppPkgFolderPathIsNotNull() {
            addCriterion("APP_PKG_FOLDER_PATH is not null");
            return (Criteria) this;
        }

        public Criteria andAppPkgFolderPathEqualTo(String value) {
            addCriterion("APP_PKG_FOLDER_PATH =", value, "appPkgFolderPath");
            return (Criteria) this;
        }

        public Criteria andAppPkgFolderPathNotEqualTo(String value) {
            addCriterion("APP_PKG_FOLDER_PATH <>", value, "appPkgFolderPath");
            return (Criteria) this;
        }

        public Criteria andAppPkgFolderPathGreaterThan(String value) {
            addCriterion("APP_PKG_FOLDER_PATH >", value, "appPkgFolderPath");
            return (Criteria) this;
        }

        public Criteria andAppPkgFolderPathGreaterThanOrEqualTo(String value) {
            addCriterion("APP_PKG_FOLDER_PATH >=", value, "appPkgFolderPath");
            return (Criteria) this;
        }

        public Criteria andAppPkgFolderPathLessThan(String value) {
            addCriterion("APP_PKG_FOLDER_PATH <", value, "appPkgFolderPath");
            return (Criteria) this;
        }

        public Criteria andAppPkgFolderPathLessThanOrEqualTo(String value) {
            addCriterion("APP_PKG_FOLDER_PATH <=", value, "appPkgFolderPath");
            return (Criteria) this;
        }

        public Criteria andAppPkgFolderPathLike(String value) {
            addCriterion("APP_PKG_FOLDER_PATH like", value, "appPkgFolderPath");
            return (Criteria) this;
        }

        public Criteria andAppPkgFolderPathNotLike(String value) {
            addCriterion("APP_PKG_FOLDER_PATH not like", value, "appPkgFolderPath");
            return (Criteria) this;
        }

        public Criteria andAppPkgFolderPathIn(List<String> values) {
            addCriterion("APP_PKG_FOLDER_PATH in", values, "appPkgFolderPath");
            return (Criteria) this;
        }

        public Criteria andAppPkgFolderPathNotIn(List<String> values) {
            addCriterion("APP_PKG_FOLDER_PATH not in", values, "appPkgFolderPath");
            return (Criteria) this;
        }

        public Criteria andAppPkgFolderPathBetween(String value1, String value2) {
            addCriterion("APP_PKG_FOLDER_PATH between", value1, value2, "appPkgFolderPath");
            return (Criteria) this;
        }

        public Criteria andAppPkgFolderPathNotBetween(String value1, String value2) {
            addCriterion("APP_PKG_FOLDER_PATH not between", value1, value2, "appPkgFolderPath");
            return (Criteria) this;
        }

        public Criteria andCreatedDatetimeIsNull() {
            addCriterion("CREATED_DATETIME is null");
            return (Criteria) this;
        }

        public Criteria andCreatedDatetimeIsNotNull() {
            addCriterion("CREATED_DATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedDatetimeEqualTo(String value) {
            addCriterion("CREATED_DATETIME =", value, "createdDatetime");
            return (Criteria) this;
        }

        public Criteria andCreatedDatetimeNotEqualTo(String value) {
            addCriterion("CREATED_DATETIME <>", value, "createdDatetime");
            return (Criteria) this;
        }

        public Criteria andCreatedDatetimeGreaterThan(String value) {
            addCriterion("CREATED_DATETIME >", value, "createdDatetime");
            return (Criteria) this;
        }

        public Criteria andCreatedDatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("CREATED_DATETIME >=", value, "createdDatetime");
            return (Criteria) this;
        }

        public Criteria andCreatedDatetimeLessThan(String value) {
            addCriterion("CREATED_DATETIME <", value, "createdDatetime");
            return (Criteria) this;
        }

        public Criteria andCreatedDatetimeLessThanOrEqualTo(String value) {
            addCriterion("CREATED_DATETIME <=", value, "createdDatetime");
            return (Criteria) this;
        }

        public Criteria andCreatedDatetimeLike(String value) {
            addCriterion("CREATED_DATETIME like", value, "createdDatetime");
            return (Criteria) this;
        }

        public Criteria andCreatedDatetimeNotLike(String value) {
            addCriterion("CREATED_DATETIME not like", value, "createdDatetime");
            return (Criteria) this;
        }

        public Criteria andCreatedDatetimeIn(List<String> values) {
            addCriterion("CREATED_DATETIME in", values, "createdDatetime");
            return (Criteria) this;
        }

        public Criteria andCreatedDatetimeNotIn(List<String> values) {
            addCriterion("CREATED_DATETIME not in", values, "createdDatetime");
            return (Criteria) this;
        }

        public Criteria andCreatedDatetimeBetween(String value1, String value2) {
            addCriterion("CREATED_DATETIME between", value1, value2, "createdDatetime");
            return (Criteria) this;
        }

        public Criteria andCreatedDatetimeNotBetween(String value1, String value2) {
            addCriterion("CREATED_DATETIME not between", value1, value2, "createdDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeIsNull() {
            addCriterion("UPDATE_DATETIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeIsNotNull() {
            addCriterion("UPDATE_DATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeEqualTo(String value) {
            addCriterion("UPDATE_DATETIME =", value, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeNotEqualTo(String value) {
            addCriterion("UPDATE_DATETIME <>", value, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeGreaterThan(String value) {
            addCriterion("UPDATE_DATETIME >", value, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATE_DATETIME >=", value, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeLessThan(String value) {
            addCriterion("UPDATE_DATETIME <", value, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeLessThanOrEqualTo(String value) {
            addCriterion("UPDATE_DATETIME <=", value, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeLike(String value) {
            addCriterion("UPDATE_DATETIME like", value, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeNotLike(String value) {
            addCriterion("UPDATE_DATETIME not like", value, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeIn(List<String> values) {
            addCriterion("UPDATE_DATETIME in", values, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeNotIn(List<String> values) {
            addCriterion("UPDATE_DATETIME not in", values, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeBetween(String value1, String value2) {
            addCriterion("UPDATE_DATETIME between", value1, value2, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeNotBetween(String value1, String value2) {
            addCriterion("UPDATE_DATETIME not between", value1, value2, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andBak1IsNull() {
            addCriterion("BAK1 is null");
            return (Criteria) this;
        }

        public Criteria andBak1IsNotNull() {
            addCriterion("BAK1 is not null");
            return (Criteria) this;
        }

        public Criteria andBak1EqualTo(String value) {
            addCriterion("BAK1 =", value, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1NotEqualTo(String value) {
            addCriterion("BAK1 <>", value, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1GreaterThan(String value) {
            addCriterion("BAK1 >", value, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1GreaterThanOrEqualTo(String value) {
            addCriterion("BAK1 >=", value, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1LessThan(String value) {
            addCriterion("BAK1 <", value, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1LessThanOrEqualTo(String value) {
            addCriterion("BAK1 <=", value, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1Like(String value) {
            addCriterion("BAK1 like", value, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1NotLike(String value) {
            addCriterion("BAK1 not like", value, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1In(List<String> values) {
            addCriterion("BAK1 in", values, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1NotIn(List<String> values) {
            addCriterion("BAK1 not in", values, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1Between(String value1, String value2) {
            addCriterion("BAK1 between", value1, value2, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1NotBetween(String value1, String value2) {
            addCriterion("BAK1 not between", value1, value2, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak2IsNull() {
            addCriterion("BAK2 is null");
            return (Criteria) this;
        }

        public Criteria andBak2IsNotNull() {
            addCriterion("BAK2 is not null");
            return (Criteria) this;
        }

        public Criteria andBak2EqualTo(String value) {
            addCriterion("BAK2 =", value, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2NotEqualTo(String value) {
            addCriterion("BAK2 <>", value, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2GreaterThan(String value) {
            addCriterion("BAK2 >", value, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2GreaterThanOrEqualTo(String value) {
            addCriterion("BAK2 >=", value, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2LessThan(String value) {
            addCriterion("BAK2 <", value, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2LessThanOrEqualTo(String value) {
            addCriterion("BAK2 <=", value, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2Like(String value) {
            addCriterion("BAK2 like", value, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2NotLike(String value) {
            addCriterion("BAK2 not like", value, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2In(List<String> values) {
            addCriterion("BAK2 in", values, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2NotIn(List<String> values) {
            addCriterion("BAK2 not in", values, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2Between(String value1, String value2) {
            addCriterion("BAK2 between", value1, value2, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2NotBetween(String value1, String value2) {
            addCriterion("BAK2 not between", value1, value2, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak3IsNull() {
            addCriterion("BAK3 is null");
            return (Criteria) this;
        }

        public Criteria andBak3IsNotNull() {
            addCriterion("BAK3 is not null");
            return (Criteria) this;
        }

        public Criteria andBak3EqualTo(String value) {
            addCriterion("BAK3 =", value, "bak3");
            return (Criteria) this;
        }

        public Criteria andBak3NotEqualTo(String value) {
            addCriterion("BAK3 <>", value, "bak3");
            return (Criteria) this;
        }

        public Criteria andBak3GreaterThan(String value) {
            addCriterion("BAK3 >", value, "bak3");
            return (Criteria) this;
        }

        public Criteria andBak3GreaterThanOrEqualTo(String value) {
            addCriterion("BAK3 >=", value, "bak3");
            return (Criteria) this;
        }

        public Criteria andBak3LessThan(String value) {
            addCriterion("BAK3 <", value, "bak3");
            return (Criteria) this;
        }

        public Criteria andBak3LessThanOrEqualTo(String value) {
            addCriterion("BAK3 <=", value, "bak3");
            return (Criteria) this;
        }

        public Criteria andBak3Like(String value) {
            addCriterion("BAK3 like", value, "bak3");
            return (Criteria) this;
        }

        public Criteria andBak3NotLike(String value) {
            addCriterion("BAK3 not like", value, "bak3");
            return (Criteria) this;
        }

        public Criteria andBak3In(List<String> values) {
            addCriterion("BAK3 in", values, "bak3");
            return (Criteria) this;
        }

        public Criteria andBak3NotIn(List<String> values) {
            addCriterion("BAK3 not in", values, "bak3");
            return (Criteria) this;
        }

        public Criteria andBak3Between(String value1, String value2) {
            addCriterion("BAK3 between", value1, value2, "bak3");
            return (Criteria) this;
        }

        public Criteria andBak3NotBetween(String value1, String value2) {
            addCriterion("BAK3 not between", value1, value2, "bak3");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}