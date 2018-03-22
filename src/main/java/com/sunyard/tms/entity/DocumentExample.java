package com.sunyard.tms.entity;

import java.util.ArrayList;
import java.util.List;

public class DocumentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DocumentExample() {
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

        public Criteria andDocIdIsNull() {
            addCriterion("DOC_ID is null");
            return (Criteria) this;
        }

        public Criteria andDocIdIsNotNull() {
            addCriterion("DOC_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDocIdEqualTo(String value) {
            addCriterion("DOC_ID =", value, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdNotEqualTo(String value) {
            addCriterion("DOC_ID <>", value, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdGreaterThan(String value) {
            addCriterion("DOC_ID >", value, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdGreaterThanOrEqualTo(String value) {
            addCriterion("DOC_ID >=", value, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdLessThan(String value) {
            addCriterion("DOC_ID <", value, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdLessThanOrEqualTo(String value) {
            addCriterion("DOC_ID <=", value, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdLike(String value) {
            addCriterion("DOC_ID like", value, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdNotLike(String value) {
            addCriterion("DOC_ID not like", value, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdIn(List<String> values) {
            addCriterion("DOC_ID in", values, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdNotIn(List<String> values) {
            addCriterion("DOC_ID not in", values, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdBetween(String value1, String value2) {
            addCriterion("DOC_ID between", value1, value2, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdNotBetween(String value1, String value2) {
            addCriterion("DOC_ID not between", value1, value2, "docId");
            return (Criteria) this;
        }

        public Criteria andDocNameIsNull() {
            addCriterion("DOC_NAME is null");
            return (Criteria) this;
        }

        public Criteria andDocNameIsNotNull() {
            addCriterion("DOC_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andDocNameEqualTo(String value) {
            addCriterion("DOC_NAME =", value, "docName");
            return (Criteria) this;
        }

        public Criteria andDocNameNotEqualTo(String value) {
            addCriterion("DOC_NAME <>", value, "docName");
            return (Criteria) this;
        }

        public Criteria andDocNameGreaterThan(String value) {
            addCriterion("DOC_NAME >", value, "docName");
            return (Criteria) this;
        }

        public Criteria andDocNameGreaterThanOrEqualTo(String value) {
            addCriterion("DOC_NAME >=", value, "docName");
            return (Criteria) this;
        }

        public Criteria andDocNameLessThan(String value) {
            addCriterion("DOC_NAME <", value, "docName");
            return (Criteria) this;
        }

        public Criteria andDocNameLessThanOrEqualTo(String value) {
            addCriterion("DOC_NAME <=", value, "docName");
            return (Criteria) this;
        }

        public Criteria andDocNameLike(String value) {
            addCriterion("DOC_NAME like", value, "docName");
            return (Criteria) this;
        }

        public Criteria andDocNameNotLike(String value) {
            addCriterion("DOC_NAME not like", value, "docName");
            return (Criteria) this;
        }

        public Criteria andDocNameIn(List<String> values) {
            addCriterion("DOC_NAME in", values, "docName");
            return (Criteria) this;
        }

        public Criteria andDocNameNotIn(List<String> values) {
            addCriterion("DOC_NAME not in", values, "docName");
            return (Criteria) this;
        }

        public Criteria andDocNameBetween(String value1, String value2) {
            addCriterion("DOC_NAME between", value1, value2, "docName");
            return (Criteria) this;
        }

        public Criteria andDocNameNotBetween(String value1, String value2) {
            addCriterion("DOC_NAME not between", value1, value2, "docName");
            return (Criteria) this;
        }

        public Criteria andDocDescIsNull() {
            addCriterion("DOC_DESC is null");
            return (Criteria) this;
        }

        public Criteria andDocDescIsNotNull() {
            addCriterion("DOC_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andDocDescEqualTo(String value) {
            addCriterion("DOC_DESC =", value, "docDesc");
            return (Criteria) this;
        }

        public Criteria andDocDescNotEqualTo(String value) {
            addCriterion("DOC_DESC <>", value, "docDesc");
            return (Criteria) this;
        }

        public Criteria andDocDescGreaterThan(String value) {
            addCriterion("DOC_DESC >", value, "docDesc");
            return (Criteria) this;
        }

        public Criteria andDocDescGreaterThanOrEqualTo(String value) {
            addCriterion("DOC_DESC >=", value, "docDesc");
            return (Criteria) this;
        }

        public Criteria andDocDescLessThan(String value) {
            addCriterion("DOC_DESC <", value, "docDesc");
            return (Criteria) this;
        }

        public Criteria andDocDescLessThanOrEqualTo(String value) {
            addCriterion("DOC_DESC <=", value, "docDesc");
            return (Criteria) this;
        }

        public Criteria andDocDescLike(String value) {
            addCriterion("DOC_DESC like", value, "docDesc");
            return (Criteria) this;
        }

        public Criteria andDocDescNotLike(String value) {
            addCriterion("DOC_DESC not like", value, "docDesc");
            return (Criteria) this;
        }

        public Criteria andDocDescIn(List<String> values) {
            addCriterion("DOC_DESC in", values, "docDesc");
            return (Criteria) this;
        }

        public Criteria andDocDescNotIn(List<String> values) {
            addCriterion("DOC_DESC not in", values, "docDesc");
            return (Criteria) this;
        }

        public Criteria andDocDescBetween(String value1, String value2) {
            addCriterion("DOC_DESC between", value1, value2, "docDesc");
            return (Criteria) this;
        }

        public Criteria andDocDescNotBetween(String value1, String value2) {
            addCriterion("DOC_DESC not between", value1, value2, "docDesc");
            return (Criteria) this;
        }

        public Criteria andDocFilePathIsNull() {
            addCriterion("DOC_FILE_PATH is null");
            return (Criteria) this;
        }

        public Criteria andDocFilePathIsNotNull() {
            addCriterion("DOC_FILE_PATH is not null");
            return (Criteria) this;
        }

        public Criteria andDocFilePathEqualTo(String value) {
            addCriterion("DOC_FILE_PATH =", value, "docFilePath");
            return (Criteria) this;
        }

        public Criteria andDocFilePathNotEqualTo(String value) {
            addCriterion("DOC_FILE_PATH <>", value, "docFilePath");
            return (Criteria) this;
        }

        public Criteria andDocFilePathGreaterThan(String value) {
            addCriterion("DOC_FILE_PATH >", value, "docFilePath");
            return (Criteria) this;
        }

        public Criteria andDocFilePathGreaterThanOrEqualTo(String value) {
            addCriterion("DOC_FILE_PATH >=", value, "docFilePath");
            return (Criteria) this;
        }

        public Criteria andDocFilePathLessThan(String value) {
            addCriterion("DOC_FILE_PATH <", value, "docFilePath");
            return (Criteria) this;
        }

        public Criteria andDocFilePathLessThanOrEqualTo(String value) {
            addCriterion("DOC_FILE_PATH <=", value, "docFilePath");
            return (Criteria) this;
        }

        public Criteria andDocFilePathLike(String value) {
            addCriterion("DOC_FILE_PATH like", value, "docFilePath");
            return (Criteria) this;
        }

        public Criteria andDocFilePathNotLike(String value) {
            addCriterion("DOC_FILE_PATH not like", value, "docFilePath");
            return (Criteria) this;
        }

        public Criteria andDocFilePathIn(List<String> values) {
            addCriterion("DOC_FILE_PATH in", values, "docFilePath");
            return (Criteria) this;
        }

        public Criteria andDocFilePathNotIn(List<String> values) {
            addCriterion("DOC_FILE_PATH not in", values, "docFilePath");
            return (Criteria) this;
        }

        public Criteria andDocFilePathBetween(String value1, String value2) {
            addCriterion("DOC_FILE_PATH between", value1, value2, "docFilePath");
            return (Criteria) this;
        }

        public Criteria andDocFilePathNotBetween(String value1, String value2) {
            addCriterion("DOC_FILE_PATH not between", value1, value2, "docFilePath");
            return (Criteria) this;
        }

        public Criteria andDocFolderPathIsNull() {
            addCriterion("DOC_FOLDER_PATH is null");
            return (Criteria) this;
        }

        public Criteria andDocFolderPathIsNotNull() {
            addCriterion("DOC_FOLDER_PATH is not null");
            return (Criteria) this;
        }

        public Criteria andDocFolderPathEqualTo(String value) {
            addCriterion("DOC_FOLDER_PATH =", value, "docFolderPath");
            return (Criteria) this;
        }

        public Criteria andDocFolderPathNotEqualTo(String value) {
            addCriterion("DOC_FOLDER_PATH <>", value, "docFolderPath");
            return (Criteria) this;
        }

        public Criteria andDocFolderPathGreaterThan(String value) {
            addCriterion("DOC_FOLDER_PATH >", value, "docFolderPath");
            return (Criteria) this;
        }

        public Criteria andDocFolderPathGreaterThanOrEqualTo(String value) {
            addCriterion("DOC_FOLDER_PATH >=", value, "docFolderPath");
            return (Criteria) this;
        }

        public Criteria andDocFolderPathLessThan(String value) {
            addCriterion("DOC_FOLDER_PATH <", value, "docFolderPath");
            return (Criteria) this;
        }

        public Criteria andDocFolderPathLessThanOrEqualTo(String value) {
            addCriterion("DOC_FOLDER_PATH <=", value, "docFolderPath");
            return (Criteria) this;
        }

        public Criteria andDocFolderPathLike(String value) {
            addCriterion("DOC_FOLDER_PATH like", value, "docFolderPath");
            return (Criteria) this;
        }

        public Criteria andDocFolderPathNotLike(String value) {
            addCriterion("DOC_FOLDER_PATH not like", value, "docFolderPath");
            return (Criteria) this;
        }

        public Criteria andDocFolderPathIn(List<String> values) {
            addCriterion("DOC_FOLDER_PATH in", values, "docFolderPath");
            return (Criteria) this;
        }

        public Criteria andDocFolderPathNotIn(List<String> values) {
            addCriterion("DOC_FOLDER_PATH not in", values, "docFolderPath");
            return (Criteria) this;
        }

        public Criteria andDocFolderPathBetween(String value1, String value2) {
            addCriterion("DOC_FOLDER_PATH between", value1, value2, "docFolderPath");
            return (Criteria) this;
        }

        public Criteria andDocFolderPathNotBetween(String value1, String value2) {
            addCriterion("DOC_FOLDER_PATH not between", value1, value2, "docFolderPath");
            return (Criteria) this;
        }

        public Criteria andDocLenIsNull() {
            addCriterion("DOC_LEN is null");
            return (Criteria) this;
        }

        public Criteria andDocLenIsNotNull() {
            addCriterion("DOC_LEN is not null");
            return (Criteria) this;
        }

        public Criteria andDocLenEqualTo(String value) {
            addCriterion("DOC_LEN =", value, "docLen");
            return (Criteria) this;
        }

        public Criteria andDocLenNotEqualTo(String value) {
            addCriterion("DOC_LEN <>", value, "docLen");
            return (Criteria) this;
        }

        public Criteria andDocLenGreaterThan(String value) {
            addCriterion("DOC_LEN >", value, "docLen");
            return (Criteria) this;
        }

        public Criteria andDocLenGreaterThanOrEqualTo(String value) {
            addCriterion("DOC_LEN >=", value, "docLen");
            return (Criteria) this;
        }

        public Criteria andDocLenLessThan(String value) {
            addCriterion("DOC_LEN <", value, "docLen");
            return (Criteria) this;
        }

        public Criteria andDocLenLessThanOrEqualTo(String value) {
            addCriterion("DOC_LEN <=", value, "docLen");
            return (Criteria) this;
        }

        public Criteria andDocLenLike(String value) {
            addCriterion("DOC_LEN like", value, "docLen");
            return (Criteria) this;
        }

        public Criteria andDocLenNotLike(String value) {
            addCriterion("DOC_LEN not like", value, "docLen");
            return (Criteria) this;
        }

        public Criteria andDocLenIn(List<String> values) {
            addCriterion("DOC_LEN in", values, "docLen");
            return (Criteria) this;
        }

        public Criteria andDocLenNotIn(List<String> values) {
            addCriterion("DOC_LEN not in", values, "docLen");
            return (Criteria) this;
        }

        public Criteria andDocLenBetween(String value1, String value2) {
            addCriterion("DOC_LEN between", value1, value2, "docLen");
            return (Criteria) this;
        }

        public Criteria andDocLenNotBetween(String value1, String value2) {
            addCriterion("DOC_LEN not between", value1, value2, "docLen");
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

        public Criteria andDocVerIsNull() {
            addCriterion("DOC_VER is null");
            return (Criteria) this;
        }

        public Criteria andDocVerIsNotNull() {
            addCriterion("DOC_VER is not null");
            return (Criteria) this;
        }

        public Criteria andDocVerEqualTo(String value) {
            addCriterion("DOC_VER =", value, "docVer");
            return (Criteria) this;
        }

        public Criteria andDocVerNotEqualTo(String value) {
            addCriterion("DOC_VER <>", value, "docVer");
            return (Criteria) this;
        }

        public Criteria andDocVerGreaterThan(String value) {
            addCriterion("DOC_VER >", value, "docVer");
            return (Criteria) this;
        }

        public Criteria andDocVerGreaterThanOrEqualTo(String value) {
            addCriterion("DOC_VER >=", value, "docVer");
            return (Criteria) this;
        }

        public Criteria andDocVerLessThan(String value) {
            addCriterion("DOC_VER <", value, "docVer");
            return (Criteria) this;
        }

        public Criteria andDocVerLessThanOrEqualTo(String value) {
            addCriterion("DOC_VER <=", value, "docVer");
            return (Criteria) this;
        }

        public Criteria andDocVerLike(String value) {
            addCriterion("DOC_VER like", value, "docVer");
            return (Criteria) this;
        }

        public Criteria andDocVerNotLike(String value) {
            addCriterion("DOC_VER not like", value, "docVer");
            return (Criteria) this;
        }

        public Criteria andDocVerIn(List<String> values) {
            addCriterion("DOC_VER in", values, "docVer");
            return (Criteria) this;
        }

        public Criteria andDocVerNotIn(List<String> values) {
            addCriterion("DOC_VER not in", values, "docVer");
            return (Criteria) this;
        }

        public Criteria andDocVerBetween(String value1, String value2) {
            addCriterion("DOC_VER between", value1, value2, "docVer");
            return (Criteria) this;
        }

        public Criteria andDocVerNotBetween(String value1, String value2) {
            addCriterion("DOC_VER not between", value1, value2, "docVer");
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