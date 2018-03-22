package com.sunyard.tms.entity;

import java.util.ArrayList;
import java.util.List;

public class FirmWareExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FirmWareExample() {
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

        public Criteria andFirmIdIsNull() {
            addCriterion("FIRM_ID is null");
            return (Criteria) this;
        }

        public Criteria andFirmIdIsNotNull() {
            addCriterion("FIRM_ID is not null");
            return (Criteria) this;
        }

        public Criteria andFirmIdEqualTo(String value) {
            addCriterion("FIRM_ID =", value, "firmId");
            return (Criteria) this;
        }

        public Criteria andFirmIdNotEqualTo(String value) {
            addCriterion("FIRM_ID <>", value, "firmId");
            return (Criteria) this;
        }

        public Criteria andFirmIdGreaterThan(String value) {
            addCriterion("FIRM_ID >", value, "firmId");
            return (Criteria) this;
        }

        public Criteria andFirmIdGreaterThanOrEqualTo(String value) {
            addCriterion("FIRM_ID >=", value, "firmId");
            return (Criteria) this;
        }

        public Criteria andFirmIdLessThan(String value) {
            addCriterion("FIRM_ID <", value, "firmId");
            return (Criteria) this;
        }

        public Criteria andFirmIdLessThanOrEqualTo(String value) {
            addCriterion("FIRM_ID <=", value, "firmId");
            return (Criteria) this;
        }

        public Criteria andFirmIdLike(String value) {
            addCriterion("FIRM_ID like", value, "firmId");
            return (Criteria) this;
        }

        public Criteria andFirmIdNotLike(String value) {
            addCriterion("FIRM_ID not like", value, "firmId");
            return (Criteria) this;
        }

        public Criteria andFirmIdIn(List<String> values) {
            addCriterion("FIRM_ID in", values, "firmId");
            return (Criteria) this;
        }

        public Criteria andFirmIdNotIn(List<String> values) {
            addCriterion("FIRM_ID not in", values, "firmId");
            return (Criteria) this;
        }

        public Criteria andFirmIdBetween(String value1, String value2) {
            addCriterion("FIRM_ID between", value1, value2, "firmId");
            return (Criteria) this;
        }

        public Criteria andFirmIdNotBetween(String value1, String value2) {
            addCriterion("FIRM_ID not between", value1, value2, "firmId");
            return (Criteria) this;
        }

        public Criteria andFirmNameIsNull() {
            addCriterion("FIRM_NAME is null");
            return (Criteria) this;
        }

        public Criteria andFirmNameIsNotNull() {
            addCriterion("FIRM_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andFirmNameEqualTo(String value) {
            addCriterion("FIRM_NAME =", value, "firmName");
            return (Criteria) this;
        }

        public Criteria andFirmNameNotEqualTo(String value) {
            addCriterion("FIRM_NAME <>", value, "firmName");
            return (Criteria) this;
        }

        public Criteria andFirmNameGreaterThan(String value) {
            addCriterion("FIRM_NAME >", value, "firmName");
            return (Criteria) this;
        }

        public Criteria andFirmNameGreaterThanOrEqualTo(String value) {
            addCriterion("FIRM_NAME >=", value, "firmName");
            return (Criteria) this;
        }

        public Criteria andFirmNameLessThan(String value) {
            addCriterion("FIRM_NAME <", value, "firmName");
            return (Criteria) this;
        }

        public Criteria andFirmNameLessThanOrEqualTo(String value) {
            addCriterion("FIRM_NAME <=", value, "firmName");
            return (Criteria) this;
        }

        public Criteria andFirmNameLike(String value) {
            addCriterion("FIRM_NAME like", value, "firmName");
            return (Criteria) this;
        }

        public Criteria andFirmNameNotLike(String value) {
            addCriterion("FIRM_NAME not like", value, "firmName");
            return (Criteria) this;
        }

        public Criteria andFirmNameIn(List<String> values) {
            addCriterion("FIRM_NAME in", values, "firmName");
            return (Criteria) this;
        }

        public Criteria andFirmNameNotIn(List<String> values) {
            addCriterion("FIRM_NAME not in", values, "firmName");
            return (Criteria) this;
        }

        public Criteria andFirmNameBetween(String value1, String value2) {
            addCriterion("FIRM_NAME between", value1, value2, "firmName");
            return (Criteria) this;
        }

        public Criteria andFirmNameNotBetween(String value1, String value2) {
            addCriterion("FIRM_NAME not between", value1, value2, "firmName");
            return (Criteria) this;
        }

        public Criteria andFirmDescIsNull() {
            addCriterion("FIRM_DESC is null");
            return (Criteria) this;
        }

        public Criteria andFirmDescIsNotNull() {
            addCriterion("FIRM_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andFirmDescEqualTo(String value) {
            addCriterion("FIRM_DESC =", value, "firmDesc");
            return (Criteria) this;
        }

        public Criteria andFirmDescNotEqualTo(String value) {
            addCriterion("FIRM_DESC <>", value, "firmDesc");
            return (Criteria) this;
        }

        public Criteria andFirmDescGreaterThan(String value) {
            addCriterion("FIRM_DESC >", value, "firmDesc");
            return (Criteria) this;
        }

        public Criteria andFirmDescGreaterThanOrEqualTo(String value) {
            addCriterion("FIRM_DESC >=", value, "firmDesc");
            return (Criteria) this;
        }

        public Criteria andFirmDescLessThan(String value) {
            addCriterion("FIRM_DESC <", value, "firmDesc");
            return (Criteria) this;
        }

        public Criteria andFirmDescLessThanOrEqualTo(String value) {
            addCriterion("FIRM_DESC <=", value, "firmDesc");
            return (Criteria) this;
        }

        public Criteria andFirmDescLike(String value) {
            addCriterion("FIRM_DESC like", value, "firmDesc");
            return (Criteria) this;
        }

        public Criteria andFirmDescNotLike(String value) {
            addCriterion("FIRM_DESC not like", value, "firmDesc");
            return (Criteria) this;
        }

        public Criteria andFirmDescIn(List<String> values) {
            addCriterion("FIRM_DESC in", values, "firmDesc");
            return (Criteria) this;
        }

        public Criteria andFirmDescNotIn(List<String> values) {
            addCriterion("FIRM_DESC not in", values, "firmDesc");
            return (Criteria) this;
        }

        public Criteria andFirmDescBetween(String value1, String value2) {
            addCriterion("FIRM_DESC between", value1, value2, "firmDesc");
            return (Criteria) this;
        }

        public Criteria andFirmDescNotBetween(String value1, String value2) {
            addCriterion("FIRM_DESC not between", value1, value2, "firmDesc");
            return (Criteria) this;
        }

        public Criteria andFirmStatusIsNull() {
            addCriterion("FIRM_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andFirmStatusIsNotNull() {
            addCriterion("FIRM_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andFirmStatusEqualTo(String value) {
            addCriterion("FIRM_STATUS =", value, "firmStatus");
            return (Criteria) this;
        }

        public Criteria andFirmStatusNotEqualTo(String value) {
            addCriterion("FIRM_STATUS <>", value, "firmStatus");
            return (Criteria) this;
        }

        public Criteria andFirmStatusGreaterThan(String value) {
            addCriterion("FIRM_STATUS >", value, "firmStatus");
            return (Criteria) this;
        }

        public Criteria andFirmStatusGreaterThanOrEqualTo(String value) {
            addCriterion("FIRM_STATUS >=", value, "firmStatus");
            return (Criteria) this;
        }

        public Criteria andFirmStatusLessThan(String value) {
            addCriterion("FIRM_STATUS <", value, "firmStatus");
            return (Criteria) this;
        }

        public Criteria andFirmStatusLessThanOrEqualTo(String value) {
            addCriterion("FIRM_STATUS <=", value, "firmStatus");
            return (Criteria) this;
        }

        public Criteria andFirmStatusLike(String value) {
            addCriterion("FIRM_STATUS like", value, "firmStatus");
            return (Criteria) this;
        }

        public Criteria andFirmStatusNotLike(String value) {
            addCriterion("FIRM_STATUS not like", value, "firmStatus");
            return (Criteria) this;
        }

        public Criteria andFirmStatusIn(List<String> values) {
            addCriterion("FIRM_STATUS in", values, "firmStatus");
            return (Criteria) this;
        }

        public Criteria andFirmStatusNotIn(List<String> values) {
            addCriterion("FIRM_STATUS not in", values, "firmStatus");
            return (Criteria) this;
        }

        public Criteria andFirmStatusBetween(String value1, String value2) {
            addCriterion("FIRM_STATUS between", value1, value2, "firmStatus");
            return (Criteria) this;
        }

        public Criteria andFirmStatusNotBetween(String value1, String value2) {
            addCriterion("FIRM_STATUS not between", value1, value2, "firmStatus");
            return (Criteria) this;
        }

        public Criteria andFirmVerIsNull() {
            addCriterion("FIRM_VER is null");
            return (Criteria) this;
        }

        public Criteria andFirmVerIsNotNull() {
            addCriterion("FIRM_VER is not null");
            return (Criteria) this;
        }

        public Criteria andFirmVerEqualTo(String value) {
            addCriterion("FIRM_VER =", value, "firmVer");
            return (Criteria) this;
        }

        public Criteria andFirmVerNotEqualTo(String value) {
            addCriterion("FIRM_VER <>", value, "firmVer");
            return (Criteria) this;
        }

        public Criteria andFirmVerGreaterThan(String value) {
            addCriterion("FIRM_VER >", value, "firmVer");
            return (Criteria) this;
        }

        public Criteria andFirmVerGreaterThanOrEqualTo(String value) {
            addCriterion("FIRM_VER >=", value, "firmVer");
            return (Criteria) this;
        }

        public Criteria andFirmVerLessThan(String value) {
            addCriterion("FIRM_VER <", value, "firmVer");
            return (Criteria) this;
        }

        public Criteria andFirmVerLessThanOrEqualTo(String value) {
            addCriterion("FIRM_VER <=", value, "firmVer");
            return (Criteria) this;
        }

        public Criteria andFirmVerLike(String value) {
            addCriterion("FIRM_VER like", value, "firmVer");
            return (Criteria) this;
        }

        public Criteria andFirmVerNotLike(String value) {
            addCriterion("FIRM_VER not like", value, "firmVer");
            return (Criteria) this;
        }

        public Criteria andFirmVerIn(List<String> values) {
            addCriterion("FIRM_VER in", values, "firmVer");
            return (Criteria) this;
        }

        public Criteria andFirmVerNotIn(List<String> values) {
            addCriterion("FIRM_VER not in", values, "firmVer");
            return (Criteria) this;
        }

        public Criteria andFirmVerBetween(String value1, String value2) {
            addCriterion("FIRM_VER between", value1, value2, "firmVer");
            return (Criteria) this;
        }

        public Criteria andFirmVerNotBetween(String value1, String value2) {
            addCriterion("FIRM_VER not between", value1, value2, "firmVer");
            return (Criteria) this;
        }

        public Criteria andFirmDownloadFlagIsNull() {
            addCriterion("FIRM_DOWNLOAD_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andFirmDownloadFlagIsNotNull() {
            addCriterion("FIRM_DOWNLOAD_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andFirmDownloadFlagEqualTo(String value) {
            addCriterion("FIRM_DOWNLOAD_FLAG =", value, "firmDownloadFlag");
            return (Criteria) this;
        }

        public Criteria andFirmDownloadFlagNotEqualTo(String value) {
            addCriterion("FIRM_DOWNLOAD_FLAG <>", value, "firmDownloadFlag");
            return (Criteria) this;
        }

        public Criteria andFirmDownloadFlagGreaterThan(String value) {
            addCriterion("FIRM_DOWNLOAD_FLAG >", value, "firmDownloadFlag");
            return (Criteria) this;
        }

        public Criteria andFirmDownloadFlagGreaterThanOrEqualTo(String value) {
            addCriterion("FIRM_DOWNLOAD_FLAG >=", value, "firmDownloadFlag");
            return (Criteria) this;
        }

        public Criteria andFirmDownloadFlagLessThan(String value) {
            addCriterion("FIRM_DOWNLOAD_FLAG <", value, "firmDownloadFlag");
            return (Criteria) this;
        }

        public Criteria andFirmDownloadFlagLessThanOrEqualTo(String value) {
            addCriterion("FIRM_DOWNLOAD_FLAG <=", value, "firmDownloadFlag");
            return (Criteria) this;
        }

        public Criteria andFirmDownloadFlagLike(String value) {
            addCriterion("FIRM_DOWNLOAD_FLAG like", value, "firmDownloadFlag");
            return (Criteria) this;
        }

        public Criteria andFirmDownloadFlagNotLike(String value) {
            addCriterion("FIRM_DOWNLOAD_FLAG not like", value, "firmDownloadFlag");
            return (Criteria) this;
        }

        public Criteria andFirmDownloadFlagIn(List<String> values) {
            addCriterion("FIRM_DOWNLOAD_FLAG in", values, "firmDownloadFlag");
            return (Criteria) this;
        }

        public Criteria andFirmDownloadFlagNotIn(List<String> values) {
            addCriterion("FIRM_DOWNLOAD_FLAG not in", values, "firmDownloadFlag");
            return (Criteria) this;
        }

        public Criteria andFirmDownloadFlagBetween(String value1, String value2) {
            addCriterion("FIRM_DOWNLOAD_FLAG between", value1, value2, "firmDownloadFlag");
            return (Criteria) this;
        }

        public Criteria andFirmDownloadFlagNotBetween(String value1, String value2) {
            addCriterion("FIRM_DOWNLOAD_FLAG not between", value1, value2, "firmDownloadFlag");
            return (Criteria) this;
        }

        public Criteria andFirmFilePathIsNull() {
            addCriterion("FIRM_FILE_PATH is null");
            return (Criteria) this;
        }

        public Criteria andFirmFilePathIsNotNull() {
            addCriterion("FIRM_FILE_PATH is not null");
            return (Criteria) this;
        }

        public Criteria andFirmFilePathEqualTo(String value) {
            addCriterion("FIRM_FILE_PATH =", value, "firmFilePath");
            return (Criteria) this;
        }

        public Criteria andFirmFilePathNotEqualTo(String value) {
            addCriterion("FIRM_FILE_PATH <>", value, "firmFilePath");
            return (Criteria) this;
        }

        public Criteria andFirmFilePathGreaterThan(String value) {
            addCriterion("FIRM_FILE_PATH >", value, "firmFilePath");
            return (Criteria) this;
        }

        public Criteria andFirmFilePathGreaterThanOrEqualTo(String value) {
            addCriterion("FIRM_FILE_PATH >=", value, "firmFilePath");
            return (Criteria) this;
        }

        public Criteria andFirmFilePathLessThan(String value) {
            addCriterion("FIRM_FILE_PATH <", value, "firmFilePath");
            return (Criteria) this;
        }

        public Criteria andFirmFilePathLessThanOrEqualTo(String value) {
            addCriterion("FIRM_FILE_PATH <=", value, "firmFilePath");
            return (Criteria) this;
        }

        public Criteria andFirmFilePathLike(String value) {
            addCriterion("FIRM_FILE_PATH like", value, "firmFilePath");
            return (Criteria) this;
        }

        public Criteria andFirmFilePathNotLike(String value) {
            addCriterion("FIRM_FILE_PATH not like", value, "firmFilePath");
            return (Criteria) this;
        }

        public Criteria andFirmFilePathIn(List<String> values) {
            addCriterion("FIRM_FILE_PATH in", values, "firmFilePath");
            return (Criteria) this;
        }

        public Criteria andFirmFilePathNotIn(List<String> values) {
            addCriterion("FIRM_FILE_PATH not in", values, "firmFilePath");
            return (Criteria) this;
        }

        public Criteria andFirmFilePathBetween(String value1, String value2) {
            addCriterion("FIRM_FILE_PATH between", value1, value2, "firmFilePath");
            return (Criteria) this;
        }

        public Criteria andFirmFilePathNotBetween(String value1, String value2) {
            addCriterion("FIRM_FILE_PATH not between", value1, value2, "firmFilePath");
            return (Criteria) this;
        }

        public Criteria andFirmFolderPathIsNull() {
            addCriterion("FIRM_FOLDER_PATH is null");
            return (Criteria) this;
        }

        public Criteria andFirmFolderPathIsNotNull() {
            addCriterion("FIRM_FOLDER_PATH is not null");
            return (Criteria) this;
        }

        public Criteria andFirmFolderPathEqualTo(String value) {
            addCriterion("FIRM_FOLDER_PATH =", value, "firmFolderPath");
            return (Criteria) this;
        }

        public Criteria andFirmFolderPathNotEqualTo(String value) {
            addCriterion("FIRM_FOLDER_PATH <>", value, "firmFolderPath");
            return (Criteria) this;
        }

        public Criteria andFirmFolderPathGreaterThan(String value) {
            addCriterion("FIRM_FOLDER_PATH >", value, "firmFolderPath");
            return (Criteria) this;
        }

        public Criteria andFirmFolderPathGreaterThanOrEqualTo(String value) {
            addCriterion("FIRM_FOLDER_PATH >=", value, "firmFolderPath");
            return (Criteria) this;
        }

        public Criteria andFirmFolderPathLessThan(String value) {
            addCriterion("FIRM_FOLDER_PATH <", value, "firmFolderPath");
            return (Criteria) this;
        }

        public Criteria andFirmFolderPathLessThanOrEqualTo(String value) {
            addCriterion("FIRM_FOLDER_PATH <=", value, "firmFolderPath");
            return (Criteria) this;
        }

        public Criteria andFirmFolderPathLike(String value) {
            addCriterion("FIRM_FOLDER_PATH like", value, "firmFolderPath");
            return (Criteria) this;
        }

        public Criteria andFirmFolderPathNotLike(String value) {
            addCriterion("FIRM_FOLDER_PATH not like", value, "firmFolderPath");
            return (Criteria) this;
        }

        public Criteria andFirmFolderPathIn(List<String> values) {
            addCriterion("FIRM_FOLDER_PATH in", values, "firmFolderPath");
            return (Criteria) this;
        }

        public Criteria andFirmFolderPathNotIn(List<String> values) {
            addCriterion("FIRM_FOLDER_PATH not in", values, "firmFolderPath");
            return (Criteria) this;
        }

        public Criteria andFirmFolderPathBetween(String value1, String value2) {
            addCriterion("FIRM_FOLDER_PATH between", value1, value2, "firmFolderPath");
            return (Criteria) this;
        }

        public Criteria andFirmFolderPathNotBetween(String value1, String value2) {
            addCriterion("FIRM_FOLDER_PATH not between", value1, value2, "firmFolderPath");
            return (Criteria) this;
        }

        public Criteria andFirmLenIsNull() {
            addCriterion("FIRM_LEN is null");
            return (Criteria) this;
        }

        public Criteria andFirmLenIsNotNull() {
            addCriterion("FIRM_LEN is not null");
            return (Criteria) this;
        }

        public Criteria andFirmLenEqualTo(String value) {
            addCriterion("FIRM_LEN =", value, "firmLen");
            return (Criteria) this;
        }

        public Criteria andFirmLenNotEqualTo(String value) {
            addCriterion("FIRM_LEN <>", value, "firmLen");
            return (Criteria) this;
        }

        public Criteria andFirmLenGreaterThan(String value) {
            addCriterion("FIRM_LEN >", value, "firmLen");
            return (Criteria) this;
        }

        public Criteria andFirmLenGreaterThanOrEqualTo(String value) {
            addCriterion("FIRM_LEN >=", value, "firmLen");
            return (Criteria) this;
        }

        public Criteria andFirmLenLessThan(String value) {
            addCriterion("FIRM_LEN <", value, "firmLen");
            return (Criteria) this;
        }

        public Criteria andFirmLenLessThanOrEqualTo(String value) {
            addCriterion("FIRM_LEN <=", value, "firmLen");
            return (Criteria) this;
        }

        public Criteria andFirmLenLike(String value) {
            addCriterion("FIRM_LEN like", value, "firmLen");
            return (Criteria) this;
        }

        public Criteria andFirmLenNotLike(String value) {
            addCriterion("FIRM_LEN not like", value, "firmLen");
            return (Criteria) this;
        }

        public Criteria andFirmLenIn(List<String> values) {
            addCriterion("FIRM_LEN in", values, "firmLen");
            return (Criteria) this;
        }

        public Criteria andFirmLenNotIn(List<String> values) {
            addCriterion("FIRM_LEN not in", values, "firmLen");
            return (Criteria) this;
        }

        public Criteria andFirmLenBetween(String value1, String value2) {
            addCriterion("FIRM_LEN between", value1, value2, "firmLen");
            return (Criteria) this;
        }

        public Criteria andFirmLenNotBetween(String value1, String value2) {
            addCriterion("FIRM_LEN not between", value1, value2, "firmLen");
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