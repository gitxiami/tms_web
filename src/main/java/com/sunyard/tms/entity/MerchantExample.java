package com.sunyard.tms.entity;

import java.util.ArrayList;
import java.util.List;

public class MerchantExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MerchantExample() {
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

        public Criteria andMchntIdIsNull() {
            addCriterion("MCHNT_ID is null");
            return (Criteria) this;
        }

        public Criteria andMchntIdIsNotNull() {
            addCriterion("MCHNT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andMchntIdEqualTo(String value) {
            addCriterion("MCHNT_ID =", value, "mchntId");
            return (Criteria) this;
        }

        public Criteria andMchntIdNotEqualTo(String value) {
            addCriterion("MCHNT_ID <>", value, "mchntId");
            return (Criteria) this;
        }

        public Criteria andMchntIdGreaterThan(String value) {
            addCriterion("MCHNT_ID >", value, "mchntId");
            return (Criteria) this;
        }

        public Criteria andMchntIdGreaterThanOrEqualTo(String value) {
            addCriterion("MCHNT_ID >=", value, "mchntId");
            return (Criteria) this;
        }

        public Criteria andMchntIdLessThan(String value) {
            addCriterion("MCHNT_ID <", value, "mchntId");
            return (Criteria) this;
        }

        public Criteria andMchntIdLessThanOrEqualTo(String value) {
            addCriterion("MCHNT_ID <=", value, "mchntId");
            return (Criteria) this;
        }

        public Criteria andMchntIdLike(String value) {
            addCriterion("MCHNT_ID like", value, "mchntId");
            return (Criteria) this;
        }

        public Criteria andMchntIdNotLike(String value) {
            addCriterion("MCHNT_ID not like", value, "mchntId");
            return (Criteria) this;
        }

        public Criteria andMchntIdIn(List<String> values) {
            addCriterion("MCHNT_ID in", values, "mchntId");
            return (Criteria) this;
        }

        public Criteria andMchntIdNotIn(List<String> values) {
            addCriterion("MCHNT_ID not in", values, "mchntId");
            return (Criteria) this;
        }

        public Criteria andMchntIdBetween(String value1, String value2) {
            addCriterion("MCHNT_ID between", value1, value2, "mchntId");
            return (Criteria) this;
        }

        public Criteria andMchntIdNotBetween(String value1, String value2) {
            addCriterion("MCHNT_ID not between", value1, value2, "mchntId");
            return (Criteria) this;
        }

        public Criteria andMchntUsernameIsNull() {
            addCriterion("MCHNT_USERNAME is null");
            return (Criteria) this;
        }

        public Criteria andMchntUsernameIsNotNull() {
            addCriterion("MCHNT_USERNAME is not null");
            return (Criteria) this;
        }

        public Criteria andMchntUsernameEqualTo(String value) {
            addCriterion("MCHNT_USERNAME =", value, "mchntUsername");
            return (Criteria) this;
        }

        public Criteria andMchntUsernameNotEqualTo(String value) {
            addCriterion("MCHNT_USERNAME <>", value, "mchntUsername");
            return (Criteria) this;
        }

        public Criteria andMchntUsernameGreaterThan(String value) {
            addCriterion("MCHNT_USERNAME >", value, "mchntUsername");
            return (Criteria) this;
        }

        public Criteria andMchntUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("MCHNT_USERNAME >=", value, "mchntUsername");
            return (Criteria) this;
        }

        public Criteria andMchntUsernameLessThan(String value) {
            addCriterion("MCHNT_USERNAME <", value, "mchntUsername");
            return (Criteria) this;
        }

        public Criteria andMchntUsernameLessThanOrEqualTo(String value) {
            addCriterion("MCHNT_USERNAME <=", value, "mchntUsername");
            return (Criteria) this;
        }

        public Criteria andMchntUsernameLike(String value) {
            addCriterion("MCHNT_USERNAME like", value, "mchntUsername");
            return (Criteria) this;
        }

        public Criteria andMchntUsernameNotLike(String value) {
            addCriterion("MCHNT_USERNAME not like", value, "mchntUsername");
            return (Criteria) this;
        }

        public Criteria andMchntUsernameIn(List<String> values) {
            addCriterion("MCHNT_USERNAME in", values, "mchntUsername");
            return (Criteria) this;
        }

        public Criteria andMchntUsernameNotIn(List<String> values) {
            addCriterion("MCHNT_USERNAME not in", values, "mchntUsername");
            return (Criteria) this;
        }

        public Criteria andMchntUsernameBetween(String value1, String value2) {
            addCriterion("MCHNT_USERNAME between", value1, value2, "mchntUsername");
            return (Criteria) this;
        }

        public Criteria andMchntUsernameNotBetween(String value1, String value2) {
            addCriterion("MCHNT_USERNAME not between", value1, value2, "mchntUsername");
            return (Criteria) this;
        }

        public Criteria andOrgIdIsNull() {
            addCriterion("ORG_ID is null");
            return (Criteria) this;
        }

        public Criteria andOrgIdIsNotNull() {
            addCriterion("ORG_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOrgIdEqualTo(String value) {
            addCriterion("ORG_ID =", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotEqualTo(String value) {
            addCriterion("ORG_ID <>", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThan(String value) {
            addCriterion("ORG_ID >", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThanOrEqualTo(String value) {
            addCriterion("ORG_ID >=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThan(String value) {
            addCriterion("ORG_ID <", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThanOrEqualTo(String value) {
            addCriterion("ORG_ID <=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLike(String value) {
            addCriterion("ORG_ID like", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotLike(String value) {
            addCriterion("ORG_ID not like", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdIn(List<String> values) {
            addCriterion("ORG_ID in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotIn(List<String> values) {
            addCriterion("ORG_ID not in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdBetween(String value1, String value2) {
            addCriterion("ORG_ID between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotBetween(String value1, String value2) {
            addCriterion("ORG_ID not between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgNameIsNull() {
            addCriterion("ORG_NAME is null");
            return (Criteria) this;
        }

        public Criteria andOrgNameIsNotNull() {
            addCriterion("ORG_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andOrgNameEqualTo(String value) {
            addCriterion("ORG_NAME =", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotEqualTo(String value) {
            addCriterion("ORG_NAME <>", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameGreaterThan(String value) {
            addCriterion("ORG_NAME >", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameGreaterThanOrEqualTo(String value) {
            addCriterion("ORG_NAME >=", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameLessThan(String value) {
            addCriterion("ORG_NAME <", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameLessThanOrEqualTo(String value) {
            addCriterion("ORG_NAME <=", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameLike(String value) {
            addCriterion("ORG_NAME like", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotLike(String value) {
            addCriterion("ORG_NAME not like", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameIn(List<String> values) {
            addCriterion("ORG_NAME in", values, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotIn(List<String> values) {
            addCriterion("ORG_NAME not in", values, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameBetween(String value1, String value2) {
            addCriterion("ORG_NAME between", value1, value2, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotBetween(String value1, String value2) {
            addCriterion("ORG_NAME not between", value1, value2, "orgName");
            return (Criteria) this;
        }

        public Criteria andDvpByIsNull() {
            addCriterion("DVP_BY is null");
            return (Criteria) this;
        }

        public Criteria andDvpByIsNotNull() {
            addCriterion("DVP_BY is not null");
            return (Criteria) this;
        }

        public Criteria andDvpByEqualTo(String value) {
            addCriterion("DVP_BY =", value, "dvpBy");
            return (Criteria) this;
        }

        public Criteria andDvpByNotEqualTo(String value) {
            addCriterion("DVP_BY <>", value, "dvpBy");
            return (Criteria) this;
        }

        public Criteria andDvpByGreaterThan(String value) {
            addCriterion("DVP_BY >", value, "dvpBy");
            return (Criteria) this;
        }

        public Criteria andDvpByGreaterThanOrEqualTo(String value) {
            addCriterion("DVP_BY >=", value, "dvpBy");
            return (Criteria) this;
        }

        public Criteria andDvpByLessThan(String value) {
            addCriterion("DVP_BY <", value, "dvpBy");
            return (Criteria) this;
        }

        public Criteria andDvpByLessThanOrEqualTo(String value) {
            addCriterion("DVP_BY <=", value, "dvpBy");
            return (Criteria) this;
        }

        public Criteria andDvpByLike(String value) {
            addCriterion("DVP_BY like", value, "dvpBy");
            return (Criteria) this;
        }

        public Criteria andDvpByNotLike(String value) {
            addCriterion("DVP_BY not like", value, "dvpBy");
            return (Criteria) this;
        }

        public Criteria andDvpByIn(List<String> values) {
            addCriterion("DVP_BY in", values, "dvpBy");
            return (Criteria) this;
        }

        public Criteria andDvpByNotIn(List<String> values) {
            addCriterion("DVP_BY not in", values, "dvpBy");
            return (Criteria) this;
        }

        public Criteria andDvpByBetween(String value1, String value2) {
            addCriterion("DVP_BY between", value1, value2, "dvpBy");
            return (Criteria) this;
        }

        public Criteria andDvpByNotBetween(String value1, String value2) {
            addCriterion("DVP_BY not between", value1, value2, "dvpBy");
            return (Criteria) this;
        }

        public Criteria andMchntSvcTpIsNull() {
            addCriterion("MCHNT_SVC_TP is null");
            return (Criteria) this;
        }

        public Criteria andMchntSvcTpIsNotNull() {
            addCriterion("MCHNT_SVC_TP is not null");
            return (Criteria) this;
        }

        public Criteria andMchntSvcTpEqualTo(String value) {
            addCriterion("MCHNT_SVC_TP =", value, "mchntSvcTp");
            return (Criteria) this;
        }

        public Criteria andMchntSvcTpNotEqualTo(String value) {
            addCriterion("MCHNT_SVC_TP <>", value, "mchntSvcTp");
            return (Criteria) this;
        }

        public Criteria andMchntSvcTpGreaterThan(String value) {
            addCriterion("MCHNT_SVC_TP >", value, "mchntSvcTp");
            return (Criteria) this;
        }

        public Criteria andMchntSvcTpGreaterThanOrEqualTo(String value) {
            addCriterion("MCHNT_SVC_TP >=", value, "mchntSvcTp");
            return (Criteria) this;
        }

        public Criteria andMchntSvcTpLessThan(String value) {
            addCriterion("MCHNT_SVC_TP <", value, "mchntSvcTp");
            return (Criteria) this;
        }

        public Criteria andMchntSvcTpLessThanOrEqualTo(String value) {
            addCriterion("MCHNT_SVC_TP <=", value, "mchntSvcTp");
            return (Criteria) this;
        }

        public Criteria andMchntSvcTpLike(String value) {
            addCriterion("MCHNT_SVC_TP like", value, "mchntSvcTp");
            return (Criteria) this;
        }

        public Criteria andMchntSvcTpNotLike(String value) {
            addCriterion("MCHNT_SVC_TP not like", value, "mchntSvcTp");
            return (Criteria) this;
        }

        public Criteria andMchntSvcTpIn(List<String> values) {
            addCriterion("MCHNT_SVC_TP in", values, "mchntSvcTp");
            return (Criteria) this;
        }

        public Criteria andMchntSvcTpNotIn(List<String> values) {
            addCriterion("MCHNT_SVC_TP not in", values, "mchntSvcTp");
            return (Criteria) this;
        }

        public Criteria andMchntSvcTpBetween(String value1, String value2) {
            addCriterion("MCHNT_SVC_TP between", value1, value2, "mchntSvcTp");
            return (Criteria) this;
        }

        public Criteria andMchntSvcTpNotBetween(String value1, String value2) {
            addCriterion("MCHNT_SVC_TP not between", value1, value2, "mchntSvcTp");
            return (Criteria) this;
        }

        public Criteria andAgrMchntCdIsNull() {
            addCriterion("AGR_MCHNT_CD is null");
            return (Criteria) this;
        }

        public Criteria andAgrMchntCdIsNotNull() {
            addCriterion("AGR_MCHNT_CD is not null");
            return (Criteria) this;
        }

        public Criteria andAgrMchntCdEqualTo(String value) {
            addCriterion("AGR_MCHNT_CD =", value, "agrMchntCd");
            return (Criteria) this;
        }

        public Criteria andAgrMchntCdNotEqualTo(String value) {
            addCriterion("AGR_MCHNT_CD <>", value, "agrMchntCd");
            return (Criteria) this;
        }

        public Criteria andAgrMchntCdGreaterThan(String value) {
            addCriterion("AGR_MCHNT_CD >", value, "agrMchntCd");
            return (Criteria) this;
        }

        public Criteria andAgrMchntCdGreaterThanOrEqualTo(String value) {
            addCriterion("AGR_MCHNT_CD >=", value, "agrMchntCd");
            return (Criteria) this;
        }

        public Criteria andAgrMchntCdLessThan(String value) {
            addCriterion("AGR_MCHNT_CD <", value, "agrMchntCd");
            return (Criteria) this;
        }

        public Criteria andAgrMchntCdLessThanOrEqualTo(String value) {
            addCriterion("AGR_MCHNT_CD <=", value, "agrMchntCd");
            return (Criteria) this;
        }

        public Criteria andAgrMchntCdLike(String value) {
            addCriterion("AGR_MCHNT_CD like", value, "agrMchntCd");
            return (Criteria) this;
        }

        public Criteria andAgrMchntCdNotLike(String value) {
            addCriterion("AGR_MCHNT_CD not like", value, "agrMchntCd");
            return (Criteria) this;
        }

        public Criteria andAgrMchntCdIn(List<String> values) {
            addCriterion("AGR_MCHNT_CD in", values, "agrMchntCd");
            return (Criteria) this;
        }

        public Criteria andAgrMchntCdNotIn(List<String> values) {
            addCriterion("AGR_MCHNT_CD not in", values, "agrMchntCd");
            return (Criteria) this;
        }

        public Criteria andAgrMchntCdBetween(String value1, String value2) {
            addCriterion("AGR_MCHNT_CD between", value1, value2, "agrMchntCd");
            return (Criteria) this;
        }

        public Criteria andAgrMchntCdNotBetween(String value1, String value2) {
            addCriterion("AGR_MCHNT_CD not between", value1, value2, "agrMchntCd");
            return (Criteria) this;
        }

        public Criteria andAgrMchntStatusIsNull() {
            addCriterion("AGR_MCHNT_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andAgrMchntStatusIsNotNull() {
            addCriterion("AGR_MCHNT_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andAgrMchntStatusEqualTo(String value) {
            addCriterion("AGR_MCHNT_STATUS =", value, "agrMchntStatus");
            return (Criteria) this;
        }

        public Criteria andAgrMchntStatusNotEqualTo(String value) {
            addCriterion("AGR_MCHNT_STATUS <>", value, "agrMchntStatus");
            return (Criteria) this;
        }

        public Criteria andAgrMchntStatusGreaterThan(String value) {
            addCriterion("AGR_MCHNT_STATUS >", value, "agrMchntStatus");
            return (Criteria) this;
        }

        public Criteria andAgrMchntStatusGreaterThanOrEqualTo(String value) {
            addCriterion("AGR_MCHNT_STATUS >=", value, "agrMchntStatus");
            return (Criteria) this;
        }

        public Criteria andAgrMchntStatusLessThan(String value) {
            addCriterion("AGR_MCHNT_STATUS <", value, "agrMchntStatus");
            return (Criteria) this;
        }

        public Criteria andAgrMchntStatusLessThanOrEqualTo(String value) {
            addCriterion("AGR_MCHNT_STATUS <=", value, "agrMchntStatus");
            return (Criteria) this;
        }

        public Criteria andAgrMchntStatusLike(String value) {
            addCriterion("AGR_MCHNT_STATUS like", value, "agrMchntStatus");
            return (Criteria) this;
        }

        public Criteria andAgrMchntStatusNotLike(String value) {
            addCriterion("AGR_MCHNT_STATUS not like", value, "agrMchntStatus");
            return (Criteria) this;
        }

        public Criteria andAgrMchntStatusIn(List<String> values) {
            addCriterion("AGR_MCHNT_STATUS in", values, "agrMchntStatus");
            return (Criteria) this;
        }

        public Criteria andAgrMchntStatusNotIn(List<String> values) {
            addCriterion("AGR_MCHNT_STATUS not in", values, "agrMchntStatus");
            return (Criteria) this;
        }

        public Criteria andAgrMchntStatusBetween(String value1, String value2) {
            addCriterion("AGR_MCHNT_STATUS between", value1, value2, "agrMchntStatus");
            return (Criteria) this;
        }

        public Criteria andAgrMchntStatusNotBetween(String value1, String value2) {
            addCriterion("AGR_MCHNT_STATUS not between", value1, value2, "agrMchntStatus");
            return (Criteria) this;
        }

        public Criteria andMccCd18IsNull() {
            addCriterion("MCC_CD_18 is null");
            return (Criteria) this;
        }

        public Criteria andMccCd18IsNotNull() {
            addCriterion("MCC_CD_18 is not null");
            return (Criteria) this;
        }

        public Criteria andMccCd18EqualTo(String value) {
            addCriterion("MCC_CD_18 =", value, "mccCd18");
            return (Criteria) this;
        }

        public Criteria andMccCd18NotEqualTo(String value) {
            addCriterion("MCC_CD_18 <>", value, "mccCd18");
            return (Criteria) this;
        }

        public Criteria andMccCd18GreaterThan(String value) {
            addCriterion("MCC_CD_18 >", value, "mccCd18");
            return (Criteria) this;
        }

        public Criteria andMccCd18GreaterThanOrEqualTo(String value) {
            addCriterion("MCC_CD_18 >=", value, "mccCd18");
            return (Criteria) this;
        }

        public Criteria andMccCd18LessThan(String value) {
            addCriterion("MCC_CD_18 <", value, "mccCd18");
            return (Criteria) this;
        }

        public Criteria andMccCd18LessThanOrEqualTo(String value) {
            addCriterion("MCC_CD_18 <=", value, "mccCd18");
            return (Criteria) this;
        }

        public Criteria andMccCd18Like(String value) {
            addCriterion("MCC_CD_18 like", value, "mccCd18");
            return (Criteria) this;
        }

        public Criteria andMccCd18NotLike(String value) {
            addCriterion("MCC_CD_18 not like", value, "mccCd18");
            return (Criteria) this;
        }

        public Criteria andMccCd18In(List<String> values) {
            addCriterion("MCC_CD_18 in", values, "mccCd18");
            return (Criteria) this;
        }

        public Criteria andMccCd18NotIn(List<String> values) {
            addCriterion("MCC_CD_18 not in", values, "mccCd18");
            return (Criteria) this;
        }

        public Criteria andMccCd18Between(String value1, String value2) {
            addCriterion("MCC_CD_18 between", value1, value2, "mccCd18");
            return (Criteria) this;
        }

        public Criteria andMccCd18NotBetween(String value1, String value2) {
            addCriterion("MCC_CD_18 not between", value1, value2, "mccCd18");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeIsNull() {
            addCriterion("BUSINESS_SCOPE is null");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeIsNotNull() {
            addCriterion("BUSINESS_SCOPE is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeEqualTo(String value) {
            addCriterion("BUSINESS_SCOPE =", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeNotEqualTo(String value) {
            addCriterion("BUSINESS_SCOPE <>", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeGreaterThan(String value) {
            addCriterion("BUSINESS_SCOPE >", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeGreaterThanOrEqualTo(String value) {
            addCriterion("BUSINESS_SCOPE >=", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeLessThan(String value) {
            addCriterion("BUSINESS_SCOPE <", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeLessThanOrEqualTo(String value) {
            addCriterion("BUSINESS_SCOPE <=", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeLike(String value) {
            addCriterion("BUSINESS_SCOPE like", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeNotLike(String value) {
            addCriterion("BUSINESS_SCOPE not like", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeIn(List<String> values) {
            addCriterion("BUSINESS_SCOPE in", values, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeNotIn(List<String> values) {
            addCriterion("BUSINESS_SCOPE not in", values, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeBetween(String value1, String value2) {
            addCriterion("BUSINESS_SCOPE between", value1, value2, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeNotBetween(String value1, String value2) {
            addCriterion("BUSINESS_SCOPE not between", value1, value2, "businessScope");
            return (Criteria) this;
        }

        public Criteria andMchntNameIsNull() {
            addCriterion("MCHNT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andMchntNameIsNotNull() {
            addCriterion("MCHNT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andMchntNameEqualTo(String value) {
            addCriterion("MCHNT_NAME =", value, "mchntName");
            return (Criteria) this;
        }

        public Criteria andMchntNameNotEqualTo(String value) {
            addCriterion("MCHNT_NAME <>", value, "mchntName");
            return (Criteria) this;
        }

        public Criteria andMchntNameGreaterThan(String value) {
            addCriterion("MCHNT_NAME >", value, "mchntName");
            return (Criteria) this;
        }

        public Criteria andMchntNameGreaterThanOrEqualTo(String value) {
            addCriterion("MCHNT_NAME >=", value, "mchntName");
            return (Criteria) this;
        }

        public Criteria andMchntNameLessThan(String value) {
            addCriterion("MCHNT_NAME <", value, "mchntName");
            return (Criteria) this;
        }

        public Criteria andMchntNameLessThanOrEqualTo(String value) {
            addCriterion("MCHNT_NAME <=", value, "mchntName");
            return (Criteria) this;
        }

        public Criteria andMchntNameLike(String value) {
            addCriterion("MCHNT_NAME like", value, "mchntName");
            return (Criteria) this;
        }

        public Criteria andMchntNameNotLike(String value) {
            addCriterion("MCHNT_NAME not like", value, "mchntName");
            return (Criteria) this;
        }

        public Criteria andMchntNameIn(List<String> values) {
            addCriterion("MCHNT_NAME in", values, "mchntName");
            return (Criteria) this;
        }

        public Criteria andMchntNameNotIn(List<String> values) {
            addCriterion("MCHNT_NAME not in", values, "mchntName");
            return (Criteria) this;
        }

        public Criteria andMchntNameBetween(String value1, String value2) {
            addCriterion("MCHNT_NAME between", value1, value2, "mchntName");
            return (Criteria) this;
        }

        public Criteria andMchntNameNotBetween(String value1, String value2) {
            addCriterion("MCHNT_NAME not between", value1, value2, "mchntName");
            return (Criteria) this;
        }

        public Criteria andMchntAbbrIsNull() {
            addCriterion("MCHNT_ABBR is null");
            return (Criteria) this;
        }

        public Criteria andMchntAbbrIsNotNull() {
            addCriterion("MCHNT_ABBR is not null");
            return (Criteria) this;
        }

        public Criteria andMchntAbbrEqualTo(String value) {
            addCriterion("MCHNT_ABBR =", value, "mchntAbbr");
            return (Criteria) this;
        }

        public Criteria andMchntAbbrNotEqualTo(String value) {
            addCriterion("MCHNT_ABBR <>", value, "mchntAbbr");
            return (Criteria) this;
        }

        public Criteria andMchntAbbrGreaterThan(String value) {
            addCriterion("MCHNT_ABBR >", value, "mchntAbbr");
            return (Criteria) this;
        }

        public Criteria andMchntAbbrGreaterThanOrEqualTo(String value) {
            addCriterion("MCHNT_ABBR >=", value, "mchntAbbr");
            return (Criteria) this;
        }

        public Criteria andMchntAbbrLessThan(String value) {
            addCriterion("MCHNT_ABBR <", value, "mchntAbbr");
            return (Criteria) this;
        }

        public Criteria andMchntAbbrLessThanOrEqualTo(String value) {
            addCriterion("MCHNT_ABBR <=", value, "mchntAbbr");
            return (Criteria) this;
        }

        public Criteria andMchntAbbrLike(String value) {
            addCriterion("MCHNT_ABBR like", value, "mchntAbbr");
            return (Criteria) this;
        }

        public Criteria andMchntAbbrNotLike(String value) {
            addCriterion("MCHNT_ABBR not like", value, "mchntAbbr");
            return (Criteria) this;
        }

        public Criteria andMchntAbbrIn(List<String> values) {
            addCriterion("MCHNT_ABBR in", values, "mchntAbbr");
            return (Criteria) this;
        }

        public Criteria andMchntAbbrNotIn(List<String> values) {
            addCriterion("MCHNT_ABBR not in", values, "mchntAbbr");
            return (Criteria) this;
        }

        public Criteria andMchntAbbrBetween(String value1, String value2) {
            addCriterion("MCHNT_ABBR between", value1, value2, "mchntAbbr");
            return (Criteria) this;
        }

        public Criteria andMchntAbbrNotBetween(String value1, String value2) {
            addCriterion("MCHNT_ABBR not between", value1, value2, "mchntAbbr");
            return (Criteria) this;
        }

        public Criteria andNetMchntSvcTpIsNull() {
            addCriterion("NET_MCHNT_SVC_TP is null");
            return (Criteria) this;
        }

        public Criteria andNetMchntSvcTpIsNotNull() {
            addCriterion("NET_MCHNT_SVC_TP is not null");
            return (Criteria) this;
        }

        public Criteria andNetMchntSvcTpEqualTo(String value) {
            addCriterion("NET_MCHNT_SVC_TP =", value, "netMchntSvcTp");
            return (Criteria) this;
        }

        public Criteria andNetMchntSvcTpNotEqualTo(String value) {
            addCriterion("NET_MCHNT_SVC_TP <>", value, "netMchntSvcTp");
            return (Criteria) this;
        }

        public Criteria andNetMchntSvcTpGreaterThan(String value) {
            addCriterion("NET_MCHNT_SVC_TP >", value, "netMchntSvcTp");
            return (Criteria) this;
        }

        public Criteria andNetMchntSvcTpGreaterThanOrEqualTo(String value) {
            addCriterion("NET_MCHNT_SVC_TP >=", value, "netMchntSvcTp");
            return (Criteria) this;
        }

        public Criteria andNetMchntSvcTpLessThan(String value) {
            addCriterion("NET_MCHNT_SVC_TP <", value, "netMchntSvcTp");
            return (Criteria) this;
        }

        public Criteria andNetMchntSvcTpLessThanOrEqualTo(String value) {
            addCriterion("NET_MCHNT_SVC_TP <=", value, "netMchntSvcTp");
            return (Criteria) this;
        }

        public Criteria andNetMchntSvcTpLike(String value) {
            addCriterion("NET_MCHNT_SVC_TP like", value, "netMchntSvcTp");
            return (Criteria) this;
        }

        public Criteria andNetMchntSvcTpNotLike(String value) {
            addCriterion("NET_MCHNT_SVC_TP not like", value, "netMchntSvcTp");
            return (Criteria) this;
        }

        public Criteria andNetMchntSvcTpIn(List<String> values) {
            addCriterion("NET_MCHNT_SVC_TP in", values, "netMchntSvcTp");
            return (Criteria) this;
        }

        public Criteria andNetMchntSvcTpNotIn(List<String> values) {
            addCriterion("NET_MCHNT_SVC_TP not in", values, "netMchntSvcTp");
            return (Criteria) this;
        }

        public Criteria andNetMchntSvcTpBetween(String value1, String value2) {
            addCriterion("NET_MCHNT_SVC_TP between", value1, value2, "netMchntSvcTp");
            return (Criteria) this;
        }

        public Criteria andNetMchntSvcTpNotBetween(String value1, String value2) {
            addCriterion("NET_MCHNT_SVC_TP not between", value1, value2, "netMchntSvcTp");
            return (Criteria) this;
        }

        public Criteria andLicNoIsNull() {
            addCriterion("LIC_NO is null");
            return (Criteria) this;
        }

        public Criteria andLicNoIsNotNull() {
            addCriterion("LIC_NO is not null");
            return (Criteria) this;
        }

        public Criteria andLicNoEqualTo(String value) {
            addCriterion("LIC_NO =", value, "licNo");
            return (Criteria) this;
        }

        public Criteria andLicNoNotEqualTo(String value) {
            addCriterion("LIC_NO <>", value, "licNo");
            return (Criteria) this;
        }

        public Criteria andLicNoGreaterThan(String value) {
            addCriterion("LIC_NO >", value, "licNo");
            return (Criteria) this;
        }

        public Criteria andLicNoGreaterThanOrEqualTo(String value) {
            addCriterion("LIC_NO >=", value, "licNo");
            return (Criteria) this;
        }

        public Criteria andLicNoLessThan(String value) {
            addCriterion("LIC_NO <", value, "licNo");
            return (Criteria) this;
        }

        public Criteria andLicNoLessThanOrEqualTo(String value) {
            addCriterion("LIC_NO <=", value, "licNo");
            return (Criteria) this;
        }

        public Criteria andLicNoLike(String value) {
            addCriterion("LIC_NO like", value, "licNo");
            return (Criteria) this;
        }

        public Criteria andLicNoNotLike(String value) {
            addCriterion("LIC_NO not like", value, "licNo");
            return (Criteria) this;
        }

        public Criteria andLicNoIn(List<String> values) {
            addCriterion("LIC_NO in", values, "licNo");
            return (Criteria) this;
        }

        public Criteria andLicNoNotIn(List<String> values) {
            addCriterion("LIC_NO not in", values, "licNo");
            return (Criteria) this;
        }

        public Criteria andLicNoBetween(String value1, String value2) {
            addCriterion("LIC_NO between", value1, value2, "licNo");
            return (Criteria) this;
        }

        public Criteria andLicNoNotBetween(String value1, String value2) {
            addCriterion("LIC_NO not between", value1, value2, "licNo");
            return (Criteria) this;
        }

        public Criteria andBussAddrIsNull() {
            addCriterion("BUSS_ADDR is null");
            return (Criteria) this;
        }

        public Criteria andBussAddrIsNotNull() {
            addCriterion("BUSS_ADDR is not null");
            return (Criteria) this;
        }

        public Criteria andBussAddrEqualTo(String value) {
            addCriterion("BUSS_ADDR =", value, "bussAddr");
            return (Criteria) this;
        }

        public Criteria andBussAddrNotEqualTo(String value) {
            addCriterion("BUSS_ADDR <>", value, "bussAddr");
            return (Criteria) this;
        }

        public Criteria andBussAddrGreaterThan(String value) {
            addCriterion("BUSS_ADDR >", value, "bussAddr");
            return (Criteria) this;
        }

        public Criteria andBussAddrGreaterThanOrEqualTo(String value) {
            addCriterion("BUSS_ADDR >=", value, "bussAddr");
            return (Criteria) this;
        }

        public Criteria andBussAddrLessThan(String value) {
            addCriterion("BUSS_ADDR <", value, "bussAddr");
            return (Criteria) this;
        }

        public Criteria andBussAddrLessThanOrEqualTo(String value) {
            addCriterion("BUSS_ADDR <=", value, "bussAddr");
            return (Criteria) this;
        }

        public Criteria andBussAddrLike(String value) {
            addCriterion("BUSS_ADDR like", value, "bussAddr");
            return (Criteria) this;
        }

        public Criteria andBussAddrNotLike(String value) {
            addCriterion("BUSS_ADDR not like", value, "bussAddr");
            return (Criteria) this;
        }

        public Criteria andBussAddrIn(List<String> values) {
            addCriterion("BUSS_ADDR in", values, "bussAddr");
            return (Criteria) this;
        }

        public Criteria andBussAddrNotIn(List<String> values) {
            addCriterion("BUSS_ADDR not in", values, "bussAddr");
            return (Criteria) this;
        }

        public Criteria andBussAddrBetween(String value1, String value2) {
            addCriterion("BUSS_ADDR between", value1, value2, "bussAddr");
            return (Criteria) this;
        }

        public Criteria andBussAddrNotBetween(String value1, String value2) {
            addCriterion("BUSS_ADDR not between", value1, value2, "bussAddr");
            return (Criteria) this;
        }

        public Criteria andArtifNmIsNull() {
            addCriterion("ARTIF_NM is null");
            return (Criteria) this;
        }

        public Criteria andArtifNmIsNotNull() {
            addCriterion("ARTIF_NM is not null");
            return (Criteria) this;
        }

        public Criteria andArtifNmEqualTo(String value) {
            addCriterion("ARTIF_NM =", value, "artifNm");
            return (Criteria) this;
        }

        public Criteria andArtifNmNotEqualTo(String value) {
            addCriterion("ARTIF_NM <>", value, "artifNm");
            return (Criteria) this;
        }

        public Criteria andArtifNmGreaterThan(String value) {
            addCriterion("ARTIF_NM >", value, "artifNm");
            return (Criteria) this;
        }

        public Criteria andArtifNmGreaterThanOrEqualTo(String value) {
            addCriterion("ARTIF_NM >=", value, "artifNm");
            return (Criteria) this;
        }

        public Criteria andArtifNmLessThan(String value) {
            addCriterion("ARTIF_NM <", value, "artifNm");
            return (Criteria) this;
        }

        public Criteria andArtifNmLessThanOrEqualTo(String value) {
            addCriterion("ARTIF_NM <=", value, "artifNm");
            return (Criteria) this;
        }

        public Criteria andArtifNmLike(String value) {
            addCriterion("ARTIF_NM like", value, "artifNm");
            return (Criteria) this;
        }

        public Criteria andArtifNmNotLike(String value) {
            addCriterion("ARTIF_NM not like", value, "artifNm");
            return (Criteria) this;
        }

        public Criteria andArtifNmIn(List<String> values) {
            addCriterion("ARTIF_NM in", values, "artifNm");
            return (Criteria) this;
        }

        public Criteria andArtifNmNotIn(List<String> values) {
            addCriterion("ARTIF_NM not in", values, "artifNm");
            return (Criteria) this;
        }

        public Criteria andArtifNmBetween(String value1, String value2) {
            addCriterion("ARTIF_NM between", value1, value2, "artifNm");
            return (Criteria) this;
        }

        public Criteria andArtifNmNotBetween(String value1, String value2) {
            addCriterion("ARTIF_NM not between", value1, value2, "artifNm");
            return (Criteria) this;
        }

        public Criteria andArtifCertifTpIsNull() {
            addCriterion("ARTIF_CERTIF_TP is null");
            return (Criteria) this;
        }

        public Criteria andArtifCertifTpIsNotNull() {
            addCriterion("ARTIF_CERTIF_TP is not null");
            return (Criteria) this;
        }

        public Criteria andArtifCertifTpEqualTo(String value) {
            addCriterion("ARTIF_CERTIF_TP =", value, "artifCertifTp");
            return (Criteria) this;
        }

        public Criteria andArtifCertifTpNotEqualTo(String value) {
            addCriterion("ARTIF_CERTIF_TP <>", value, "artifCertifTp");
            return (Criteria) this;
        }

        public Criteria andArtifCertifTpGreaterThan(String value) {
            addCriterion("ARTIF_CERTIF_TP >", value, "artifCertifTp");
            return (Criteria) this;
        }

        public Criteria andArtifCertifTpGreaterThanOrEqualTo(String value) {
            addCriterion("ARTIF_CERTIF_TP >=", value, "artifCertifTp");
            return (Criteria) this;
        }

        public Criteria andArtifCertifTpLessThan(String value) {
            addCriterion("ARTIF_CERTIF_TP <", value, "artifCertifTp");
            return (Criteria) this;
        }

        public Criteria andArtifCertifTpLessThanOrEqualTo(String value) {
            addCriterion("ARTIF_CERTIF_TP <=", value, "artifCertifTp");
            return (Criteria) this;
        }

        public Criteria andArtifCertifTpLike(String value) {
            addCriterion("ARTIF_CERTIF_TP like", value, "artifCertifTp");
            return (Criteria) this;
        }

        public Criteria andArtifCertifTpNotLike(String value) {
            addCriterion("ARTIF_CERTIF_TP not like", value, "artifCertifTp");
            return (Criteria) this;
        }

        public Criteria andArtifCertifTpIn(List<String> values) {
            addCriterion("ARTIF_CERTIF_TP in", values, "artifCertifTp");
            return (Criteria) this;
        }

        public Criteria andArtifCertifTpNotIn(List<String> values) {
            addCriterion("ARTIF_CERTIF_TP not in", values, "artifCertifTp");
            return (Criteria) this;
        }

        public Criteria andArtifCertifTpBetween(String value1, String value2) {
            addCriterion("ARTIF_CERTIF_TP between", value1, value2, "artifCertifTp");
            return (Criteria) this;
        }

        public Criteria andArtifCertifTpNotBetween(String value1, String value2) {
            addCriterion("ARTIF_CERTIF_TP not between", value1, value2, "artifCertifTp");
            return (Criteria) this;
        }

        public Criteria andArtifCertifIdIsNull() {
            addCriterion("ARTIF_CERTIF_ID is null");
            return (Criteria) this;
        }

        public Criteria andArtifCertifIdIsNotNull() {
            addCriterion("ARTIF_CERTIF_ID is not null");
            return (Criteria) this;
        }

        public Criteria andArtifCertifIdEqualTo(String value) {
            addCriterion("ARTIF_CERTIF_ID =", value, "artifCertifId");
            return (Criteria) this;
        }

        public Criteria andArtifCertifIdNotEqualTo(String value) {
            addCriterion("ARTIF_CERTIF_ID <>", value, "artifCertifId");
            return (Criteria) this;
        }

        public Criteria andArtifCertifIdGreaterThan(String value) {
            addCriterion("ARTIF_CERTIF_ID >", value, "artifCertifId");
            return (Criteria) this;
        }

        public Criteria andArtifCertifIdGreaterThanOrEqualTo(String value) {
            addCriterion("ARTIF_CERTIF_ID >=", value, "artifCertifId");
            return (Criteria) this;
        }

        public Criteria andArtifCertifIdLessThan(String value) {
            addCriterion("ARTIF_CERTIF_ID <", value, "artifCertifId");
            return (Criteria) this;
        }

        public Criteria andArtifCertifIdLessThanOrEqualTo(String value) {
            addCriterion("ARTIF_CERTIF_ID <=", value, "artifCertifId");
            return (Criteria) this;
        }

        public Criteria andArtifCertifIdLike(String value) {
            addCriterion("ARTIF_CERTIF_ID like", value, "artifCertifId");
            return (Criteria) this;
        }

        public Criteria andArtifCertifIdNotLike(String value) {
            addCriterion("ARTIF_CERTIF_ID not like", value, "artifCertifId");
            return (Criteria) this;
        }

        public Criteria andArtifCertifIdIn(List<String> values) {
            addCriterion("ARTIF_CERTIF_ID in", values, "artifCertifId");
            return (Criteria) this;
        }

        public Criteria andArtifCertifIdNotIn(List<String> values) {
            addCriterion("ARTIF_CERTIF_ID not in", values, "artifCertifId");
            return (Criteria) this;
        }

        public Criteria andArtifCertifIdBetween(String value1, String value2) {
            addCriterion("ARTIF_CERTIF_ID between", value1, value2, "artifCertifId");
            return (Criteria) this;
        }

        public Criteria andArtifCertifIdNotBetween(String value1, String value2) {
            addCriterion("ARTIF_CERTIF_ID not between", value1, value2, "artifCertifId");
            return (Criteria) this;
        }

        public Criteria andRegAddrIsNull() {
            addCriterion("REG_ADDR is null");
            return (Criteria) this;
        }

        public Criteria andRegAddrIsNotNull() {
            addCriterion("REG_ADDR is not null");
            return (Criteria) this;
        }

        public Criteria andRegAddrEqualTo(String value) {
            addCriterion("REG_ADDR =", value, "regAddr");
            return (Criteria) this;
        }

        public Criteria andRegAddrNotEqualTo(String value) {
            addCriterion("REG_ADDR <>", value, "regAddr");
            return (Criteria) this;
        }

        public Criteria andRegAddrGreaterThan(String value) {
            addCriterion("REG_ADDR >", value, "regAddr");
            return (Criteria) this;
        }

        public Criteria andRegAddrGreaterThanOrEqualTo(String value) {
            addCriterion("REG_ADDR >=", value, "regAddr");
            return (Criteria) this;
        }

        public Criteria andRegAddrLessThan(String value) {
            addCriterion("REG_ADDR <", value, "regAddr");
            return (Criteria) this;
        }

        public Criteria andRegAddrLessThanOrEqualTo(String value) {
            addCriterion("REG_ADDR <=", value, "regAddr");
            return (Criteria) this;
        }

        public Criteria andRegAddrLike(String value) {
            addCriterion("REG_ADDR like", value, "regAddr");
            return (Criteria) this;
        }

        public Criteria andRegAddrNotLike(String value) {
            addCriterion("REG_ADDR not like", value, "regAddr");
            return (Criteria) this;
        }

        public Criteria andRegAddrIn(List<String> values) {
            addCriterion("REG_ADDR in", values, "regAddr");
            return (Criteria) this;
        }

        public Criteria andRegAddrNotIn(List<String> values) {
            addCriterion("REG_ADDR not in", values, "regAddr");
            return (Criteria) this;
        }

        public Criteria andRegAddrBetween(String value1, String value2) {
            addCriterion("REG_ADDR between", value1, value2, "regAddr");
            return (Criteria) this;
        }

        public Criteria andRegAddrNotBetween(String value1, String value2) {
            addCriterion("REG_ADDR not between", value1, value2, "regAddr");
            return (Criteria) this;
        }

        public Criteria andSettleNoIsNull() {
            addCriterion("SETTLE_NO is null");
            return (Criteria) this;
        }

        public Criteria andSettleNoIsNotNull() {
            addCriterion("SETTLE_NO is not null");
            return (Criteria) this;
        }

        public Criteria andSettleNoEqualTo(String value) {
            addCriterion("SETTLE_NO =", value, "settleNo");
            return (Criteria) this;
        }

        public Criteria andSettleNoNotEqualTo(String value) {
            addCriterion("SETTLE_NO <>", value, "settleNo");
            return (Criteria) this;
        }

        public Criteria andSettleNoGreaterThan(String value) {
            addCriterion("SETTLE_NO >", value, "settleNo");
            return (Criteria) this;
        }

        public Criteria andSettleNoGreaterThanOrEqualTo(String value) {
            addCriterion("SETTLE_NO >=", value, "settleNo");
            return (Criteria) this;
        }

        public Criteria andSettleNoLessThan(String value) {
            addCriterion("SETTLE_NO <", value, "settleNo");
            return (Criteria) this;
        }

        public Criteria andSettleNoLessThanOrEqualTo(String value) {
            addCriterion("SETTLE_NO <=", value, "settleNo");
            return (Criteria) this;
        }

        public Criteria andSettleNoLike(String value) {
            addCriterion("SETTLE_NO like", value, "settleNo");
            return (Criteria) this;
        }

        public Criteria andSettleNoNotLike(String value) {
            addCriterion("SETTLE_NO not like", value, "settleNo");
            return (Criteria) this;
        }

        public Criteria andSettleNoIn(List<String> values) {
            addCriterion("SETTLE_NO in", values, "settleNo");
            return (Criteria) this;
        }

        public Criteria andSettleNoNotIn(List<String> values) {
            addCriterion("SETTLE_NO not in", values, "settleNo");
            return (Criteria) this;
        }

        public Criteria andSettleNoBetween(String value1, String value2) {
            addCriterion("SETTLE_NO between", value1, value2, "settleNo");
            return (Criteria) this;
        }

        public Criteria andSettleNoNotBetween(String value1, String value2) {
            addCriterion("SETTLE_NO not between", value1, value2, "settleNo");
            return (Criteria) this;
        }

        public Criteria andAccountNameIsNull() {
            addCriterion("ACCOUNT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andAccountNameIsNotNull() {
            addCriterion("ACCOUNT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andAccountNameEqualTo(String value) {
            addCriterion("ACCOUNT_NAME =", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameNotEqualTo(String value) {
            addCriterion("ACCOUNT_NAME <>", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameGreaterThan(String value) {
            addCriterion("ACCOUNT_NAME >", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameGreaterThanOrEqualTo(String value) {
            addCriterion("ACCOUNT_NAME >=", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameLessThan(String value) {
            addCriterion("ACCOUNT_NAME <", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameLessThanOrEqualTo(String value) {
            addCriterion("ACCOUNT_NAME <=", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameLike(String value) {
            addCriterion("ACCOUNT_NAME like", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameNotLike(String value) {
            addCriterion("ACCOUNT_NAME not like", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameIn(List<String> values) {
            addCriterion("ACCOUNT_NAME in", values, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameNotIn(List<String> values) {
            addCriterion("ACCOUNT_NAME not in", values, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameBetween(String value1, String value2) {
            addCriterion("ACCOUNT_NAME between", value1, value2, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameNotBetween(String value1, String value2) {
            addCriterion("ACCOUNT_NAME not between", value1, value2, "accountName");
            return (Criteria) this;
        }

        public Criteria andSettleBankIsNull() {
            addCriterion("SETTLE_BANK is null");
            return (Criteria) this;
        }

        public Criteria andSettleBankIsNotNull() {
            addCriterion("SETTLE_BANK is not null");
            return (Criteria) this;
        }

        public Criteria andSettleBankEqualTo(String value) {
            addCriterion("SETTLE_BANK =", value, "settleBank");
            return (Criteria) this;
        }

        public Criteria andSettleBankNotEqualTo(String value) {
            addCriterion("SETTLE_BANK <>", value, "settleBank");
            return (Criteria) this;
        }

        public Criteria andSettleBankGreaterThan(String value) {
            addCriterion("SETTLE_BANK >", value, "settleBank");
            return (Criteria) this;
        }

        public Criteria andSettleBankGreaterThanOrEqualTo(String value) {
            addCriterion("SETTLE_BANK >=", value, "settleBank");
            return (Criteria) this;
        }

        public Criteria andSettleBankLessThan(String value) {
            addCriterion("SETTLE_BANK <", value, "settleBank");
            return (Criteria) this;
        }

        public Criteria andSettleBankLessThanOrEqualTo(String value) {
            addCriterion("SETTLE_BANK <=", value, "settleBank");
            return (Criteria) this;
        }

        public Criteria andSettleBankLike(String value) {
            addCriterion("SETTLE_BANK like", value, "settleBank");
            return (Criteria) this;
        }

        public Criteria andSettleBankNotLike(String value) {
            addCriterion("SETTLE_BANK not like", value, "settleBank");
            return (Criteria) this;
        }

        public Criteria andSettleBankIn(List<String> values) {
            addCriterion("SETTLE_BANK in", values, "settleBank");
            return (Criteria) this;
        }

        public Criteria andSettleBankNotIn(List<String> values) {
            addCriterion("SETTLE_BANK not in", values, "settleBank");
            return (Criteria) this;
        }

        public Criteria andSettleBankBetween(String value1, String value2) {
            addCriterion("SETTLE_BANK between", value1, value2, "settleBank");
            return (Criteria) this;
        }

        public Criteria andSettleBankNotBetween(String value1, String value2) {
            addCriterion("SETTLE_BANK not between", value1, value2, "settleBank");
            return (Criteria) this;
        }

        public Criteria andSettleBranchCodeIsNull() {
            addCriterion("SETTLE_BRANCH_CODE is null");
            return (Criteria) this;
        }

        public Criteria andSettleBranchCodeIsNotNull() {
            addCriterion("SETTLE_BRANCH_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andSettleBranchCodeEqualTo(String value) {
            addCriterion("SETTLE_BRANCH_CODE =", value, "settleBranchCode");
            return (Criteria) this;
        }

        public Criteria andSettleBranchCodeNotEqualTo(String value) {
            addCriterion("SETTLE_BRANCH_CODE <>", value, "settleBranchCode");
            return (Criteria) this;
        }

        public Criteria andSettleBranchCodeGreaterThan(String value) {
            addCriterion("SETTLE_BRANCH_CODE >", value, "settleBranchCode");
            return (Criteria) this;
        }

        public Criteria andSettleBranchCodeGreaterThanOrEqualTo(String value) {
            addCriterion("SETTLE_BRANCH_CODE >=", value, "settleBranchCode");
            return (Criteria) this;
        }

        public Criteria andSettleBranchCodeLessThan(String value) {
            addCriterion("SETTLE_BRANCH_CODE <", value, "settleBranchCode");
            return (Criteria) this;
        }

        public Criteria andSettleBranchCodeLessThanOrEqualTo(String value) {
            addCriterion("SETTLE_BRANCH_CODE <=", value, "settleBranchCode");
            return (Criteria) this;
        }

        public Criteria andSettleBranchCodeLike(String value) {
            addCriterion("SETTLE_BRANCH_CODE like", value, "settleBranchCode");
            return (Criteria) this;
        }

        public Criteria andSettleBranchCodeNotLike(String value) {
            addCriterion("SETTLE_BRANCH_CODE not like", value, "settleBranchCode");
            return (Criteria) this;
        }

        public Criteria andSettleBranchCodeIn(List<String> values) {
            addCriterion("SETTLE_BRANCH_CODE in", values, "settleBranchCode");
            return (Criteria) this;
        }

        public Criteria andSettleBranchCodeNotIn(List<String> values) {
            addCriterion("SETTLE_BRANCH_CODE not in", values, "settleBranchCode");
            return (Criteria) this;
        }

        public Criteria andSettleBranchCodeBetween(String value1, String value2) {
            addCriterion("SETTLE_BRANCH_CODE between", value1, value2, "settleBranchCode");
            return (Criteria) this;
        }

        public Criteria andSettleBranchCodeNotBetween(String value1, String value2) {
            addCriterion("SETTLE_BRANCH_CODE not between", value1, value2, "settleBranchCode");
            return (Criteria) this;
        }

        public Criteria andT0ScopeIsNull() {
            addCriterion("T0_SCOPE is null");
            return (Criteria) this;
        }

        public Criteria andT0ScopeIsNotNull() {
            addCriterion("T0_SCOPE is not null");
            return (Criteria) this;
        }

        public Criteria andT0ScopeEqualTo(String value) {
            addCriterion("T0_SCOPE =", value, "t0Scope");
            return (Criteria) this;
        }

        public Criteria andT0ScopeNotEqualTo(String value) {
            addCriterion("T0_SCOPE <>", value, "t0Scope");
            return (Criteria) this;
        }

        public Criteria andT0ScopeGreaterThan(String value) {
            addCriterion("T0_SCOPE >", value, "t0Scope");
            return (Criteria) this;
        }

        public Criteria andT0ScopeGreaterThanOrEqualTo(String value) {
            addCriterion("T0_SCOPE >=", value, "t0Scope");
            return (Criteria) this;
        }

        public Criteria andT0ScopeLessThan(String value) {
            addCriterion("T0_SCOPE <", value, "t0Scope");
            return (Criteria) this;
        }

        public Criteria andT0ScopeLessThanOrEqualTo(String value) {
            addCriterion("T0_SCOPE <=", value, "t0Scope");
            return (Criteria) this;
        }

        public Criteria andT0ScopeLike(String value) {
            addCriterion("T0_SCOPE like", value, "t0Scope");
            return (Criteria) this;
        }

        public Criteria andT0ScopeNotLike(String value) {
            addCriterion("T0_SCOPE not like", value, "t0Scope");
            return (Criteria) this;
        }

        public Criteria andT0ScopeIn(List<String> values) {
            addCriterion("T0_SCOPE in", values, "t0Scope");
            return (Criteria) this;
        }

        public Criteria andT0ScopeNotIn(List<String> values) {
            addCriterion("T0_SCOPE not in", values, "t0Scope");
            return (Criteria) this;
        }

        public Criteria andT0ScopeBetween(String value1, String value2) {
            addCriterion("T0_SCOPE between", value1, value2, "t0Scope");
            return (Criteria) this;
        }

        public Criteria andT0ScopeNotBetween(String value1, String value2) {
            addCriterion("T0_SCOPE not between", value1, value2, "t0Scope");
            return (Criteria) this;
        }

        public Criteria andEtpsAttrIsNull() {
            addCriterion("ETPS_ATTR is null");
            return (Criteria) this;
        }

        public Criteria andEtpsAttrIsNotNull() {
            addCriterion("ETPS_ATTR is not null");
            return (Criteria) this;
        }

        public Criteria andEtpsAttrEqualTo(String value) {
            addCriterion("ETPS_ATTR =", value, "etpsAttr");
            return (Criteria) this;
        }

        public Criteria andEtpsAttrNotEqualTo(String value) {
            addCriterion("ETPS_ATTR <>", value, "etpsAttr");
            return (Criteria) this;
        }

        public Criteria andEtpsAttrGreaterThan(String value) {
            addCriterion("ETPS_ATTR >", value, "etpsAttr");
            return (Criteria) this;
        }

        public Criteria andEtpsAttrGreaterThanOrEqualTo(String value) {
            addCriterion("ETPS_ATTR >=", value, "etpsAttr");
            return (Criteria) this;
        }

        public Criteria andEtpsAttrLessThan(String value) {
            addCriterion("ETPS_ATTR <", value, "etpsAttr");
            return (Criteria) this;
        }

        public Criteria andEtpsAttrLessThanOrEqualTo(String value) {
            addCriterion("ETPS_ATTR <=", value, "etpsAttr");
            return (Criteria) this;
        }

        public Criteria andEtpsAttrLike(String value) {
            addCriterion("ETPS_ATTR like", value, "etpsAttr");
            return (Criteria) this;
        }

        public Criteria andEtpsAttrNotLike(String value) {
            addCriterion("ETPS_ATTR not like", value, "etpsAttr");
            return (Criteria) this;
        }

        public Criteria andEtpsAttrIn(List<String> values) {
            addCriterion("ETPS_ATTR in", values, "etpsAttr");
            return (Criteria) this;
        }

        public Criteria andEtpsAttrNotIn(List<String> values) {
            addCriterion("ETPS_ATTR not in", values, "etpsAttr");
            return (Criteria) this;
        }

        public Criteria andEtpsAttrBetween(String value1, String value2) {
            addCriterion("ETPS_ATTR between", value1, value2, "etpsAttr");
            return (Criteria) this;
        }

        public Criteria andEtpsAttrNotBetween(String value1, String value2) {
            addCriterion("ETPS_ATTR not between", value1, value2, "etpsAttr");
            return (Criteria) this;
        }

        public Criteria andCommAddrIsNull() {
            addCriterion("COMM_ADDR is null");
            return (Criteria) this;
        }

        public Criteria andCommAddrIsNotNull() {
            addCriterion("COMM_ADDR is not null");
            return (Criteria) this;
        }

        public Criteria andCommAddrEqualTo(String value) {
            addCriterion("COMM_ADDR =", value, "commAddr");
            return (Criteria) this;
        }

        public Criteria andCommAddrNotEqualTo(String value) {
            addCriterion("COMM_ADDR <>", value, "commAddr");
            return (Criteria) this;
        }

        public Criteria andCommAddrGreaterThan(String value) {
            addCriterion("COMM_ADDR >", value, "commAddr");
            return (Criteria) this;
        }

        public Criteria andCommAddrGreaterThanOrEqualTo(String value) {
            addCriterion("COMM_ADDR >=", value, "commAddr");
            return (Criteria) this;
        }

        public Criteria andCommAddrLessThan(String value) {
            addCriterion("COMM_ADDR <", value, "commAddr");
            return (Criteria) this;
        }

        public Criteria andCommAddrLessThanOrEqualTo(String value) {
            addCriterion("COMM_ADDR <=", value, "commAddr");
            return (Criteria) this;
        }

        public Criteria andCommAddrLike(String value) {
            addCriterion("COMM_ADDR like", value, "commAddr");
            return (Criteria) this;
        }

        public Criteria andCommAddrNotLike(String value) {
            addCriterion("COMM_ADDR not like", value, "commAddr");
            return (Criteria) this;
        }

        public Criteria andCommAddrIn(List<String> values) {
            addCriterion("COMM_ADDR in", values, "commAddr");
            return (Criteria) this;
        }

        public Criteria andCommAddrNotIn(List<String> values) {
            addCriterion("COMM_ADDR not in", values, "commAddr");
            return (Criteria) this;
        }

        public Criteria andCommAddrBetween(String value1, String value2) {
            addCriterion("COMM_ADDR between", value1, value2, "commAddr");
            return (Criteria) this;
        }

        public Criteria andCommAddrNotBetween(String value1, String value2) {
            addCriterion("COMM_ADDR not between", value1, value2, "commAddr");
            return (Criteria) this;
        }

        public Criteria andPhoneNoIsNull() {
            addCriterion("PHONE_NO is null");
            return (Criteria) this;
        }

        public Criteria andPhoneNoIsNotNull() {
            addCriterion("PHONE_NO is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneNoEqualTo(String value) {
            addCriterion("PHONE_NO =", value, "phoneNo");
            return (Criteria) this;
        }

        public Criteria andPhoneNoNotEqualTo(String value) {
            addCriterion("PHONE_NO <>", value, "phoneNo");
            return (Criteria) this;
        }

        public Criteria andPhoneNoGreaterThan(String value) {
            addCriterion("PHONE_NO >", value, "phoneNo");
            return (Criteria) this;
        }

        public Criteria andPhoneNoGreaterThanOrEqualTo(String value) {
            addCriterion("PHONE_NO >=", value, "phoneNo");
            return (Criteria) this;
        }

        public Criteria andPhoneNoLessThan(String value) {
            addCriterion("PHONE_NO <", value, "phoneNo");
            return (Criteria) this;
        }

        public Criteria andPhoneNoLessThanOrEqualTo(String value) {
            addCriterion("PHONE_NO <=", value, "phoneNo");
            return (Criteria) this;
        }

        public Criteria andPhoneNoLike(String value) {
            addCriterion("PHONE_NO like", value, "phoneNo");
            return (Criteria) this;
        }

        public Criteria andPhoneNoNotLike(String value) {
            addCriterion("PHONE_NO not like", value, "phoneNo");
            return (Criteria) this;
        }

        public Criteria andPhoneNoIn(List<String> values) {
            addCriterion("PHONE_NO in", values, "phoneNo");
            return (Criteria) this;
        }

        public Criteria andPhoneNoNotIn(List<String> values) {
            addCriterion("PHONE_NO not in", values, "phoneNo");
            return (Criteria) this;
        }

        public Criteria andPhoneNoBetween(String value1, String value2) {
            addCriterion("PHONE_NO between", value1, value2, "phoneNo");
            return (Criteria) this;
        }

        public Criteria andPhoneNoNotBetween(String value1, String value2) {
            addCriterion("PHONE_NO not between", value1, value2, "phoneNo");
            return (Criteria) this;
        }

        public Criteria andMobileNoIsNull() {
            addCriterion("MOBILE_NO is null");
            return (Criteria) this;
        }

        public Criteria andMobileNoIsNotNull() {
            addCriterion("MOBILE_NO is not null");
            return (Criteria) this;
        }

        public Criteria andMobileNoEqualTo(String value) {
            addCriterion("MOBILE_NO =", value, "mobileNo");
            return (Criteria) this;
        }

        public Criteria andMobileNoNotEqualTo(String value) {
            addCriterion("MOBILE_NO <>", value, "mobileNo");
            return (Criteria) this;
        }

        public Criteria andMobileNoGreaterThan(String value) {
            addCriterion("MOBILE_NO >", value, "mobileNo");
            return (Criteria) this;
        }

        public Criteria andMobileNoGreaterThanOrEqualTo(String value) {
            addCriterion("MOBILE_NO >=", value, "mobileNo");
            return (Criteria) this;
        }

        public Criteria andMobileNoLessThan(String value) {
            addCriterion("MOBILE_NO <", value, "mobileNo");
            return (Criteria) this;
        }

        public Criteria andMobileNoLessThanOrEqualTo(String value) {
            addCriterion("MOBILE_NO <=", value, "mobileNo");
            return (Criteria) this;
        }

        public Criteria andMobileNoLike(String value) {
            addCriterion("MOBILE_NO like", value, "mobileNo");
            return (Criteria) this;
        }

        public Criteria andMobileNoNotLike(String value) {
            addCriterion("MOBILE_NO not like", value, "mobileNo");
            return (Criteria) this;
        }

        public Criteria andMobileNoIn(List<String> values) {
            addCriterion("MOBILE_NO in", values, "mobileNo");
            return (Criteria) this;
        }

        public Criteria andMobileNoNotIn(List<String> values) {
            addCriterion("MOBILE_NO not in", values, "mobileNo");
            return (Criteria) this;
        }

        public Criteria andMobileNoBetween(String value1, String value2) {
            addCriterion("MOBILE_NO between", value1, value2, "mobileNo");
            return (Criteria) this;
        }

        public Criteria andMobileNoNotBetween(String value1, String value2) {
            addCriterion("MOBILE_NO not between", value1, value2, "mobileNo");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNull() {
            addCriterion("LONGITUDE is null");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNotNull() {
            addCriterion("LONGITUDE is not null");
            return (Criteria) this;
        }

        public Criteria andLongitudeEqualTo(String value) {
            addCriterion("LONGITUDE =", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotEqualTo(String value) {
            addCriterion("LONGITUDE <>", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThan(String value) {
            addCriterion("LONGITUDE >", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThanOrEqualTo(String value) {
            addCriterion("LONGITUDE >=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThan(String value) {
            addCriterion("LONGITUDE <", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThanOrEqualTo(String value) {
            addCriterion("LONGITUDE <=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLike(String value) {
            addCriterion("LONGITUDE like", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotLike(String value) {
            addCriterion("LONGITUDE not like", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIn(List<String> values) {
            addCriterion("LONGITUDE in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotIn(List<String> values) {
            addCriterion("LONGITUDE not in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeBetween(String value1, String value2) {
            addCriterion("LONGITUDE between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotBetween(String value1, String value2) {
            addCriterion("LONGITUDE not between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNull() {
            addCriterion("LATITUDE is null");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNotNull() {
            addCriterion("LATITUDE is not null");
            return (Criteria) this;
        }

        public Criteria andLatitudeEqualTo(String value) {
            addCriterion("LATITUDE =", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotEqualTo(String value) {
            addCriterion("LATITUDE <>", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThan(String value) {
            addCriterion("LATITUDE >", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThanOrEqualTo(String value) {
            addCriterion("LATITUDE >=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThan(String value) {
            addCriterion("LATITUDE <", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThanOrEqualTo(String value) {
            addCriterion("LATITUDE <=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLike(String value) {
            addCriterion("LATITUDE like", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotLike(String value) {
            addCriterion("LATITUDE not like", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIn(List<String> values) {
            addCriterion("LATITUDE in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotIn(List<String> values) {
            addCriterion("LATITUDE not in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeBetween(String value1, String value2) {
            addCriterion("LATITUDE between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotBetween(String value1, String value2) {
            addCriterion("LATITUDE not between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andRadiusIsNull() {
            addCriterion("RADIUS is null");
            return (Criteria) this;
        }

        public Criteria andRadiusIsNotNull() {
            addCriterion("RADIUS is not null");
            return (Criteria) this;
        }

        public Criteria andRadiusEqualTo(String value) {
            addCriterion("RADIUS =", value, "radius");
            return (Criteria) this;
        }

        public Criteria andRadiusNotEqualTo(String value) {
            addCriterion("RADIUS <>", value, "radius");
            return (Criteria) this;
        }

        public Criteria andRadiusGreaterThan(String value) {
            addCriterion("RADIUS >", value, "radius");
            return (Criteria) this;
        }

        public Criteria andRadiusGreaterThanOrEqualTo(String value) {
            addCriterion("RADIUS >=", value, "radius");
            return (Criteria) this;
        }

        public Criteria andRadiusLessThan(String value) {
            addCriterion("RADIUS <", value, "radius");
            return (Criteria) this;
        }

        public Criteria andRadiusLessThanOrEqualTo(String value) {
            addCriterion("RADIUS <=", value, "radius");
            return (Criteria) this;
        }

        public Criteria andRadiusLike(String value) {
            addCriterion("RADIUS like", value, "radius");
            return (Criteria) this;
        }

        public Criteria andRadiusNotLike(String value) {
            addCriterion("RADIUS not like", value, "radius");
            return (Criteria) this;
        }

        public Criteria andRadiusIn(List<String> values) {
            addCriterion("RADIUS in", values, "radius");
            return (Criteria) this;
        }

        public Criteria andRadiusNotIn(List<String> values) {
            addCriterion("RADIUS not in", values, "radius");
            return (Criteria) this;
        }

        public Criteria andRadiusBetween(String value1, String value2) {
            addCriterion("RADIUS between", value1, value2, "radius");
            return (Criteria) this;
        }

        public Criteria andRadiusNotBetween(String value1, String value2) {
            addCriterion("RADIUS not between", value1, value2, "radius");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNull() {
            addCriterion("ROLE_ID is null");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNotNull() {
            addCriterion("ROLE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRoleIdEqualTo(String value) {
            addCriterion("ROLE_ID =", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotEqualTo(String value) {
            addCriterion("ROLE_ID <>", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThan(String value) {
            addCriterion("ROLE_ID >", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThanOrEqualTo(String value) {
            addCriterion("ROLE_ID >=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThan(String value) {
            addCriterion("ROLE_ID <", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThanOrEqualTo(String value) {
            addCriterion("ROLE_ID <=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLike(String value) {
            addCriterion("ROLE_ID like", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotLike(String value) {
            addCriterion("ROLE_ID not like", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdIn(List<String> values) {
            addCriterion("ROLE_ID in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotIn(List<String> values) {
            addCriterion("ROLE_ID not in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdBetween(String value1, String value2) {
            addCriterion("ROLE_ID between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotBetween(String value1, String value2) {
            addCriterion("ROLE_ID not between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("STATUS like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("STATUS not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andMchntLimitStatusIsNull() {
            addCriterion("MCHNT_LIMIT_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andMchntLimitStatusIsNotNull() {
            addCriterion("MCHNT_LIMIT_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andMchntLimitStatusEqualTo(String value) {
            addCriterion("MCHNT_LIMIT_STATUS =", value, "mchntLimitStatus");
            return (Criteria) this;
        }

        public Criteria andMchntLimitStatusNotEqualTo(String value) {
            addCriterion("MCHNT_LIMIT_STATUS <>", value, "mchntLimitStatus");
            return (Criteria) this;
        }

        public Criteria andMchntLimitStatusGreaterThan(String value) {
            addCriterion("MCHNT_LIMIT_STATUS >", value, "mchntLimitStatus");
            return (Criteria) this;
        }

        public Criteria andMchntLimitStatusGreaterThanOrEqualTo(String value) {
            addCriterion("MCHNT_LIMIT_STATUS >=", value, "mchntLimitStatus");
            return (Criteria) this;
        }

        public Criteria andMchntLimitStatusLessThan(String value) {
            addCriterion("MCHNT_LIMIT_STATUS <", value, "mchntLimitStatus");
            return (Criteria) this;
        }

        public Criteria andMchntLimitStatusLessThanOrEqualTo(String value) {
            addCriterion("MCHNT_LIMIT_STATUS <=", value, "mchntLimitStatus");
            return (Criteria) this;
        }

        public Criteria andMchntLimitStatusLike(String value) {
            addCriterion("MCHNT_LIMIT_STATUS like", value, "mchntLimitStatus");
            return (Criteria) this;
        }

        public Criteria andMchntLimitStatusNotLike(String value) {
            addCriterion("MCHNT_LIMIT_STATUS not like", value, "mchntLimitStatus");
            return (Criteria) this;
        }

        public Criteria andMchntLimitStatusIn(List<String> values) {
            addCriterion("MCHNT_LIMIT_STATUS in", values, "mchntLimitStatus");
            return (Criteria) this;
        }

        public Criteria andMchntLimitStatusNotIn(List<String> values) {
            addCriterion("MCHNT_LIMIT_STATUS not in", values, "mchntLimitStatus");
            return (Criteria) this;
        }

        public Criteria andMchntLimitStatusBetween(String value1, String value2) {
            addCriterion("MCHNT_LIMIT_STATUS between", value1, value2, "mchntLimitStatus");
            return (Criteria) this;
        }

        public Criteria andMchntLimitStatusNotBetween(String value1, String value2) {
            addCriterion("MCHNT_LIMIT_STATUS not between", value1, value2, "mchntLimitStatus");
            return (Criteria) this;
        }

        public Criteria andTransStatusIsNull() {
            addCriterion("TRANS_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andTransStatusIsNotNull() {
            addCriterion("TRANS_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andTransStatusEqualTo(String value) {
            addCriterion("TRANS_STATUS =", value, "transStatus");
            return (Criteria) this;
        }

        public Criteria andTransStatusNotEqualTo(String value) {
            addCriterion("TRANS_STATUS <>", value, "transStatus");
            return (Criteria) this;
        }

        public Criteria andTransStatusGreaterThan(String value) {
            addCriterion("TRANS_STATUS >", value, "transStatus");
            return (Criteria) this;
        }

        public Criteria andTransStatusGreaterThanOrEqualTo(String value) {
            addCriterion("TRANS_STATUS >=", value, "transStatus");
            return (Criteria) this;
        }

        public Criteria andTransStatusLessThan(String value) {
            addCriterion("TRANS_STATUS <", value, "transStatus");
            return (Criteria) this;
        }

        public Criteria andTransStatusLessThanOrEqualTo(String value) {
            addCriterion("TRANS_STATUS <=", value, "transStatus");
            return (Criteria) this;
        }

        public Criteria andTransStatusLike(String value) {
            addCriterion("TRANS_STATUS like", value, "transStatus");
            return (Criteria) this;
        }

        public Criteria andTransStatusNotLike(String value) {
            addCriterion("TRANS_STATUS not like", value, "transStatus");
            return (Criteria) this;
        }

        public Criteria andTransStatusIn(List<String> values) {
            addCriterion("TRANS_STATUS in", values, "transStatus");
            return (Criteria) this;
        }

        public Criteria andTransStatusNotIn(List<String> values) {
            addCriterion("TRANS_STATUS not in", values, "transStatus");
            return (Criteria) this;
        }

        public Criteria andTransStatusBetween(String value1, String value2) {
            addCriterion("TRANS_STATUS between", value1, value2, "transStatus");
            return (Criteria) this;
        }

        public Criteria andTransStatusNotBetween(String value1, String value2) {
            addCriterion("TRANS_STATUS not between", value1, value2, "transStatus");
            return (Criteria) this;
        }

        public Criteria andMccApplRuleIsNull() {
            addCriterion("MCC_APPL_RULE is null");
            return (Criteria) this;
        }

        public Criteria andMccApplRuleIsNotNull() {
            addCriterion("MCC_APPL_RULE is not null");
            return (Criteria) this;
        }

        public Criteria andMccApplRuleEqualTo(String value) {
            addCriterion("MCC_APPL_RULE =", value, "mccApplRule");
            return (Criteria) this;
        }

        public Criteria andMccApplRuleNotEqualTo(String value) {
            addCriterion("MCC_APPL_RULE <>", value, "mccApplRule");
            return (Criteria) this;
        }

        public Criteria andMccApplRuleGreaterThan(String value) {
            addCriterion("MCC_APPL_RULE >", value, "mccApplRule");
            return (Criteria) this;
        }

        public Criteria andMccApplRuleGreaterThanOrEqualTo(String value) {
            addCriterion("MCC_APPL_RULE >=", value, "mccApplRule");
            return (Criteria) this;
        }

        public Criteria andMccApplRuleLessThan(String value) {
            addCriterion("MCC_APPL_RULE <", value, "mccApplRule");
            return (Criteria) this;
        }

        public Criteria andMccApplRuleLessThanOrEqualTo(String value) {
            addCriterion("MCC_APPL_RULE <=", value, "mccApplRule");
            return (Criteria) this;
        }

        public Criteria andMccApplRuleLike(String value) {
            addCriterion("MCC_APPL_RULE like", value, "mccApplRule");
            return (Criteria) this;
        }

        public Criteria andMccApplRuleNotLike(String value) {
            addCriterion("MCC_APPL_RULE not like", value, "mccApplRule");
            return (Criteria) this;
        }

        public Criteria andMccApplRuleIn(List<String> values) {
            addCriterion("MCC_APPL_RULE in", values, "mccApplRule");
            return (Criteria) this;
        }

        public Criteria andMccApplRuleNotIn(List<String> values) {
            addCriterion("MCC_APPL_RULE not in", values, "mccApplRule");
            return (Criteria) this;
        }

        public Criteria andMccApplRuleBetween(String value1, String value2) {
            addCriterion("MCC_APPL_RULE between", value1, value2, "mccApplRule");
            return (Criteria) this;
        }

        public Criteria andMccApplRuleNotBetween(String value1, String value2) {
            addCriterion("MCC_APPL_RULE not between", value1, value2, "mccApplRule");
            return (Criteria) this;
        }

        public Criteria andMchntFeeTypeIsNull() {
            addCriterion("MCHNT_FEE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andMchntFeeTypeIsNotNull() {
            addCriterion("MCHNT_FEE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andMchntFeeTypeEqualTo(String value) {
            addCriterion("MCHNT_FEE_TYPE =", value, "mchntFeeType");
            return (Criteria) this;
        }

        public Criteria andMchntFeeTypeNotEqualTo(String value) {
            addCriterion("MCHNT_FEE_TYPE <>", value, "mchntFeeType");
            return (Criteria) this;
        }

        public Criteria andMchntFeeTypeGreaterThan(String value) {
            addCriterion("MCHNT_FEE_TYPE >", value, "mchntFeeType");
            return (Criteria) this;
        }

        public Criteria andMchntFeeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("MCHNT_FEE_TYPE >=", value, "mchntFeeType");
            return (Criteria) this;
        }

        public Criteria andMchntFeeTypeLessThan(String value) {
            addCriterion("MCHNT_FEE_TYPE <", value, "mchntFeeType");
            return (Criteria) this;
        }

        public Criteria andMchntFeeTypeLessThanOrEqualTo(String value) {
            addCriterion("MCHNT_FEE_TYPE <=", value, "mchntFeeType");
            return (Criteria) this;
        }

        public Criteria andMchntFeeTypeLike(String value) {
            addCriterion("MCHNT_FEE_TYPE like", value, "mchntFeeType");
            return (Criteria) this;
        }

        public Criteria andMchntFeeTypeNotLike(String value) {
            addCriterion("MCHNT_FEE_TYPE not like", value, "mchntFeeType");
            return (Criteria) this;
        }

        public Criteria andMchntFeeTypeIn(List<String> values) {
            addCriterion("MCHNT_FEE_TYPE in", values, "mchntFeeType");
            return (Criteria) this;
        }

        public Criteria andMchntFeeTypeNotIn(List<String> values) {
            addCriterion("MCHNT_FEE_TYPE not in", values, "mchntFeeType");
            return (Criteria) this;
        }

        public Criteria andMchntFeeTypeBetween(String value1, String value2) {
            addCriterion("MCHNT_FEE_TYPE between", value1, value2, "mchntFeeType");
            return (Criteria) this;
        }

        public Criteria andMchntFeeTypeNotBetween(String value1, String value2) {
            addCriterion("MCHNT_FEE_TYPE not between", value1, value2, "mchntFeeType");
            return (Criteria) this;
        }

        public Criteria andOpIdIsNull() {
            addCriterion("OP_ID is null");
            return (Criteria) this;
        }

        public Criteria andOpIdIsNotNull() {
            addCriterion("OP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOpIdEqualTo(String value) {
            addCriterion("OP_ID =", value, "opId");
            return (Criteria) this;
        }

        public Criteria andOpIdNotEqualTo(String value) {
            addCriterion("OP_ID <>", value, "opId");
            return (Criteria) this;
        }

        public Criteria andOpIdGreaterThan(String value) {
            addCriterion("OP_ID >", value, "opId");
            return (Criteria) this;
        }

        public Criteria andOpIdGreaterThanOrEqualTo(String value) {
            addCriterion("OP_ID >=", value, "opId");
            return (Criteria) this;
        }

        public Criteria andOpIdLessThan(String value) {
            addCriterion("OP_ID <", value, "opId");
            return (Criteria) this;
        }

        public Criteria andOpIdLessThanOrEqualTo(String value) {
            addCriterion("OP_ID <=", value, "opId");
            return (Criteria) this;
        }

        public Criteria andOpIdLike(String value) {
            addCriterion("OP_ID like", value, "opId");
            return (Criteria) this;
        }

        public Criteria andOpIdNotLike(String value) {
            addCriterion("OP_ID not like", value, "opId");
            return (Criteria) this;
        }

        public Criteria andOpIdIn(List<String> values) {
            addCriterion("OP_ID in", values, "opId");
            return (Criteria) this;
        }

        public Criteria andOpIdNotIn(List<String> values) {
            addCriterion("OP_ID not in", values, "opId");
            return (Criteria) this;
        }

        public Criteria andOpIdBetween(String value1, String value2) {
            addCriterion("OP_ID between", value1, value2, "opId");
            return (Criteria) this;
        }

        public Criteria andOpIdNotBetween(String value1, String value2) {
            addCriterion("OP_ID not between", value1, value2, "opId");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeIsNull() {
            addCriterion("CREATE_DATETIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeIsNotNull() {
            addCriterion("CREATE_DATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeEqualTo(String value) {
            addCriterion("CREATE_DATETIME =", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeNotEqualTo(String value) {
            addCriterion("CREATE_DATETIME <>", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeGreaterThan(String value) {
            addCriterion("CREATE_DATETIME >", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_DATETIME >=", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeLessThan(String value) {
            addCriterion("CREATE_DATETIME <", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeLessThanOrEqualTo(String value) {
            addCriterion("CREATE_DATETIME <=", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeLike(String value) {
            addCriterion("CREATE_DATETIME like", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeNotLike(String value) {
            addCriterion("CREATE_DATETIME not like", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeIn(List<String> values) {
            addCriterion("CREATE_DATETIME in", values, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeNotIn(List<String> values) {
            addCriterion("CREATE_DATETIME not in", values, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeBetween(String value1, String value2) {
            addCriterion("CREATE_DATETIME between", value1, value2, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeNotBetween(String value1, String value2) {
            addCriterion("CREATE_DATETIME not between", value1, value2, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andRegisterDatetimeIsNull() {
            addCriterion("REGISTER_DATETIME is null");
            return (Criteria) this;
        }

        public Criteria andRegisterDatetimeIsNotNull() {
            addCriterion("REGISTER_DATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterDatetimeEqualTo(String value) {
            addCriterion("REGISTER_DATETIME =", value, "registerDatetime");
            return (Criteria) this;
        }

        public Criteria andRegisterDatetimeNotEqualTo(String value) {
            addCriterion("REGISTER_DATETIME <>", value, "registerDatetime");
            return (Criteria) this;
        }

        public Criteria andRegisterDatetimeGreaterThan(String value) {
            addCriterion("REGISTER_DATETIME >", value, "registerDatetime");
            return (Criteria) this;
        }

        public Criteria andRegisterDatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("REGISTER_DATETIME >=", value, "registerDatetime");
            return (Criteria) this;
        }

        public Criteria andRegisterDatetimeLessThan(String value) {
            addCriterion("REGISTER_DATETIME <", value, "registerDatetime");
            return (Criteria) this;
        }

        public Criteria andRegisterDatetimeLessThanOrEqualTo(String value) {
            addCriterion("REGISTER_DATETIME <=", value, "registerDatetime");
            return (Criteria) this;
        }

        public Criteria andRegisterDatetimeLike(String value) {
            addCriterion("REGISTER_DATETIME like", value, "registerDatetime");
            return (Criteria) this;
        }

        public Criteria andRegisterDatetimeNotLike(String value) {
            addCriterion("REGISTER_DATETIME not like", value, "registerDatetime");
            return (Criteria) this;
        }

        public Criteria andRegisterDatetimeIn(List<String> values) {
            addCriterion("REGISTER_DATETIME in", values, "registerDatetime");
            return (Criteria) this;
        }

        public Criteria andRegisterDatetimeNotIn(List<String> values) {
            addCriterion("REGISTER_DATETIME not in", values, "registerDatetime");
            return (Criteria) this;
        }

        public Criteria andRegisterDatetimeBetween(String value1, String value2) {
            addCriterion("REGISTER_DATETIME between", value1, value2, "registerDatetime");
            return (Criteria) this;
        }

        public Criteria andRegisterDatetimeNotBetween(String value1, String value2) {
            addCriterion("REGISTER_DATETIME not between", value1, value2, "registerDatetime");
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