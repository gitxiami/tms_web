package com.sunyard.tms.entity;

import java.util.ArrayList;
import java.util.List;

public class OrganizationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrganizationExample() {
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

        public Criteria andOrgPidIsNull() {
            addCriterion("ORG_PID is null");
            return (Criteria) this;
        }

        public Criteria andOrgPidIsNotNull() {
            addCriterion("ORG_PID is not null");
            return (Criteria) this;
        }

        public Criteria andOrgPidEqualTo(String value) {
            addCriterion("ORG_PID =", value, "orgPid");
            return (Criteria) this;
        }

        public Criteria andOrgPidNotEqualTo(String value) {
            addCriterion("ORG_PID <>", value, "orgPid");
            return (Criteria) this;
        }

        public Criteria andOrgPidGreaterThan(String value) {
            addCriterion("ORG_PID >", value, "orgPid");
            return (Criteria) this;
        }

        public Criteria andOrgPidGreaterThanOrEqualTo(String value) {
            addCriterion("ORG_PID >=", value, "orgPid");
            return (Criteria) this;
        }

        public Criteria andOrgPidLessThan(String value) {
            addCriterion("ORG_PID <", value, "orgPid");
            return (Criteria) this;
        }

        public Criteria andOrgPidLessThanOrEqualTo(String value) {
            addCriterion("ORG_PID <=", value, "orgPid");
            return (Criteria) this;
        }

        public Criteria andOrgPidLike(String value) {
            addCriterion("ORG_PID like", value, "orgPid");
            return (Criteria) this;
        }

        public Criteria andOrgPidNotLike(String value) {
            addCriterion("ORG_PID not like", value, "orgPid");
            return (Criteria) this;
        }

        public Criteria andOrgPidIn(List<String> values) {
            addCriterion("ORG_PID in", values, "orgPid");
            return (Criteria) this;
        }

        public Criteria andOrgPidNotIn(List<String> values) {
            addCriterion("ORG_PID not in", values, "orgPid");
            return (Criteria) this;
        }

        public Criteria andOrgPidBetween(String value1, String value2) {
            addCriterion("ORG_PID between", value1, value2, "orgPid");
            return (Criteria) this;
        }

        public Criteria andOrgPidNotBetween(String value1, String value2) {
            addCriterion("ORG_PID not between", value1, value2, "orgPid");
            return (Criteria) this;
        }

        public Criteria andOrgLvIsNull() {
            addCriterion("ORG_LV is null");
            return (Criteria) this;
        }

        public Criteria andOrgLvIsNotNull() {
            addCriterion("ORG_LV is not null");
            return (Criteria) this;
        }

        public Criteria andOrgLvEqualTo(String value) {
            addCriterion("ORG_LV =", value, "orgLv");
            return (Criteria) this;
        }

        public Criteria andOrgLvNotEqualTo(String value) {
            addCriterion("ORG_LV <>", value, "orgLv");
            return (Criteria) this;
        }

        public Criteria andOrgLvGreaterThan(String value) {
            addCriterion("ORG_LV >", value, "orgLv");
            return (Criteria) this;
        }

        public Criteria andOrgLvGreaterThanOrEqualTo(String value) {
            addCriterion("ORG_LV >=", value, "orgLv");
            return (Criteria) this;
        }

        public Criteria andOrgLvLessThan(String value) {
            addCriterion("ORG_LV <", value, "orgLv");
            return (Criteria) this;
        }

        public Criteria andOrgLvLessThanOrEqualTo(String value) {
            addCriterion("ORG_LV <=", value, "orgLv");
            return (Criteria) this;
        }

        public Criteria andOrgLvLike(String value) {
            addCriterion("ORG_LV like", value, "orgLv");
            return (Criteria) this;
        }

        public Criteria andOrgLvNotLike(String value) {
            addCriterion("ORG_LV not like", value, "orgLv");
            return (Criteria) this;
        }

        public Criteria andOrgLvIn(List<String> values) {
            addCriterion("ORG_LV in", values, "orgLv");
            return (Criteria) this;
        }

        public Criteria andOrgLvNotIn(List<String> values) {
            addCriterion("ORG_LV not in", values, "orgLv");
            return (Criteria) this;
        }

        public Criteria andOrgLvBetween(String value1, String value2) {
            addCriterion("ORG_LV between", value1, value2, "orgLv");
            return (Criteria) this;
        }

        public Criteria andOrgLvNotBetween(String value1, String value2) {
            addCriterion("ORG_LV not between", value1, value2, "orgLv");
            return (Criteria) this;
        }

        public Criteria andOrgStatusIsNull() {
            addCriterion("ORG_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andOrgStatusIsNotNull() {
            addCriterion("ORG_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andOrgStatusEqualTo(String value) {
            addCriterion("ORG_STATUS =", value, "orgStatus");
            return (Criteria) this;
        }

        public Criteria andOrgStatusNotEqualTo(String value) {
            addCriterion("ORG_STATUS <>", value, "orgStatus");
            return (Criteria) this;
        }

        public Criteria andOrgStatusGreaterThan(String value) {
            addCriterion("ORG_STATUS >", value, "orgStatus");
            return (Criteria) this;
        }

        public Criteria andOrgStatusGreaterThanOrEqualTo(String value) {
            addCriterion("ORG_STATUS >=", value, "orgStatus");
            return (Criteria) this;
        }

        public Criteria andOrgStatusLessThan(String value) {
            addCriterion("ORG_STATUS <", value, "orgStatus");
            return (Criteria) this;
        }

        public Criteria andOrgStatusLessThanOrEqualTo(String value) {
            addCriterion("ORG_STATUS <=", value, "orgStatus");
            return (Criteria) this;
        }

        public Criteria andOrgStatusLike(String value) {
            addCriterion("ORG_STATUS like", value, "orgStatus");
            return (Criteria) this;
        }

        public Criteria andOrgStatusNotLike(String value) {
            addCriterion("ORG_STATUS not like", value, "orgStatus");
            return (Criteria) this;
        }

        public Criteria andOrgStatusIn(List<String> values) {
            addCriterion("ORG_STATUS in", values, "orgStatus");
            return (Criteria) this;
        }

        public Criteria andOrgStatusNotIn(List<String> values) {
            addCriterion("ORG_STATUS not in", values, "orgStatus");
            return (Criteria) this;
        }

        public Criteria andOrgStatusBetween(String value1, String value2) {
            addCriterion("ORG_STATUS between", value1, value2, "orgStatus");
            return (Criteria) this;
        }

        public Criteria andOrgStatusNotBetween(String value1, String value2) {
            addCriterion("ORG_STATUS not between", value1, value2, "orgStatus");
            return (Criteria) this;
        }

        public Criteria andOrgAddressIsNull() {
            addCriterion("ORG_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andOrgAddressIsNotNull() {
            addCriterion("ORG_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andOrgAddressEqualTo(String value) {
            addCriterion("ORG_ADDRESS =", value, "orgAddress");
            return (Criteria) this;
        }

        public Criteria andOrgAddressNotEqualTo(String value) {
            addCriterion("ORG_ADDRESS <>", value, "orgAddress");
            return (Criteria) this;
        }

        public Criteria andOrgAddressGreaterThan(String value) {
            addCriterion("ORG_ADDRESS >", value, "orgAddress");
            return (Criteria) this;
        }

        public Criteria andOrgAddressGreaterThanOrEqualTo(String value) {
            addCriterion("ORG_ADDRESS >=", value, "orgAddress");
            return (Criteria) this;
        }

        public Criteria andOrgAddressLessThan(String value) {
            addCriterion("ORG_ADDRESS <", value, "orgAddress");
            return (Criteria) this;
        }

        public Criteria andOrgAddressLessThanOrEqualTo(String value) {
            addCriterion("ORG_ADDRESS <=", value, "orgAddress");
            return (Criteria) this;
        }

        public Criteria andOrgAddressLike(String value) {
            addCriterion("ORG_ADDRESS like", value, "orgAddress");
            return (Criteria) this;
        }

        public Criteria andOrgAddressNotLike(String value) {
            addCriterion("ORG_ADDRESS not like", value, "orgAddress");
            return (Criteria) this;
        }

        public Criteria andOrgAddressIn(List<String> values) {
            addCriterion("ORG_ADDRESS in", values, "orgAddress");
            return (Criteria) this;
        }

        public Criteria andOrgAddressNotIn(List<String> values) {
            addCriterion("ORG_ADDRESS not in", values, "orgAddress");
            return (Criteria) this;
        }

        public Criteria andOrgAddressBetween(String value1, String value2) {
            addCriterion("ORG_ADDRESS between", value1, value2, "orgAddress");
            return (Criteria) this;
        }

        public Criteria andOrgAddressNotBetween(String value1, String value2) {
            addCriterion("ORG_ADDRESS not between", value1, value2, "orgAddress");
            return (Criteria) this;
        }

        public Criteria andOrgLinkmanIsNull() {
            addCriterion("ORG_LINKMAN is null");
            return (Criteria) this;
        }

        public Criteria andOrgLinkmanIsNotNull() {
            addCriterion("ORG_LINKMAN is not null");
            return (Criteria) this;
        }

        public Criteria andOrgLinkmanEqualTo(String value) {
            addCriterion("ORG_LINKMAN =", value, "orgLinkman");
            return (Criteria) this;
        }

        public Criteria andOrgLinkmanNotEqualTo(String value) {
            addCriterion("ORG_LINKMAN <>", value, "orgLinkman");
            return (Criteria) this;
        }

        public Criteria andOrgLinkmanGreaterThan(String value) {
            addCriterion("ORG_LINKMAN >", value, "orgLinkman");
            return (Criteria) this;
        }

        public Criteria andOrgLinkmanGreaterThanOrEqualTo(String value) {
            addCriterion("ORG_LINKMAN >=", value, "orgLinkman");
            return (Criteria) this;
        }

        public Criteria andOrgLinkmanLessThan(String value) {
            addCriterion("ORG_LINKMAN <", value, "orgLinkman");
            return (Criteria) this;
        }

        public Criteria andOrgLinkmanLessThanOrEqualTo(String value) {
            addCriterion("ORG_LINKMAN <=", value, "orgLinkman");
            return (Criteria) this;
        }

        public Criteria andOrgLinkmanLike(String value) {
            addCriterion("ORG_LINKMAN like", value, "orgLinkman");
            return (Criteria) this;
        }

        public Criteria andOrgLinkmanNotLike(String value) {
            addCriterion("ORG_LINKMAN not like", value, "orgLinkman");
            return (Criteria) this;
        }

        public Criteria andOrgLinkmanIn(List<String> values) {
            addCriterion("ORG_LINKMAN in", values, "orgLinkman");
            return (Criteria) this;
        }

        public Criteria andOrgLinkmanNotIn(List<String> values) {
            addCriterion("ORG_LINKMAN not in", values, "orgLinkman");
            return (Criteria) this;
        }

        public Criteria andOrgLinkmanBetween(String value1, String value2) {
            addCriterion("ORG_LINKMAN between", value1, value2, "orgLinkman");
            return (Criteria) this;
        }

        public Criteria andOrgLinkmanNotBetween(String value1, String value2) {
            addCriterion("ORG_LINKMAN not between", value1, value2, "orgLinkman");
            return (Criteria) this;
        }

        public Criteria andOrgTelIsNull() {
            addCriterion("ORG_TEL is null");
            return (Criteria) this;
        }

        public Criteria andOrgTelIsNotNull() {
            addCriterion("ORG_TEL is not null");
            return (Criteria) this;
        }

        public Criteria andOrgTelEqualTo(String value) {
            addCriterion("ORG_TEL =", value, "orgTel");
            return (Criteria) this;
        }

        public Criteria andOrgTelNotEqualTo(String value) {
            addCriterion("ORG_TEL <>", value, "orgTel");
            return (Criteria) this;
        }

        public Criteria andOrgTelGreaterThan(String value) {
            addCriterion("ORG_TEL >", value, "orgTel");
            return (Criteria) this;
        }

        public Criteria andOrgTelGreaterThanOrEqualTo(String value) {
            addCriterion("ORG_TEL >=", value, "orgTel");
            return (Criteria) this;
        }

        public Criteria andOrgTelLessThan(String value) {
            addCriterion("ORG_TEL <", value, "orgTel");
            return (Criteria) this;
        }

        public Criteria andOrgTelLessThanOrEqualTo(String value) {
            addCriterion("ORG_TEL <=", value, "orgTel");
            return (Criteria) this;
        }

        public Criteria andOrgTelLike(String value) {
            addCriterion("ORG_TEL like", value, "orgTel");
            return (Criteria) this;
        }

        public Criteria andOrgTelNotLike(String value) {
            addCriterion("ORG_TEL not like", value, "orgTel");
            return (Criteria) this;
        }

        public Criteria andOrgTelIn(List<String> values) {
            addCriterion("ORG_TEL in", values, "orgTel");
            return (Criteria) this;
        }

        public Criteria andOrgTelNotIn(List<String> values) {
            addCriterion("ORG_TEL not in", values, "orgTel");
            return (Criteria) this;
        }

        public Criteria andOrgTelBetween(String value1, String value2) {
            addCriterion("ORG_TEL between", value1, value2, "orgTel");
            return (Criteria) this;
        }

        public Criteria andOrgTelNotBetween(String value1, String value2) {
            addCriterion("ORG_TEL not between", value1, value2, "orgTel");
            return (Criteria) this;
        }

        public Criteria andOrgRemarkIsNull() {
            addCriterion("ORG_REMARK is null");
            return (Criteria) this;
        }

        public Criteria andOrgRemarkIsNotNull() {
            addCriterion("ORG_REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andOrgRemarkEqualTo(String value) {
            addCriterion("ORG_REMARK =", value, "orgRemark");
            return (Criteria) this;
        }

        public Criteria andOrgRemarkNotEqualTo(String value) {
            addCriterion("ORG_REMARK <>", value, "orgRemark");
            return (Criteria) this;
        }

        public Criteria andOrgRemarkGreaterThan(String value) {
            addCriterion("ORG_REMARK >", value, "orgRemark");
            return (Criteria) this;
        }

        public Criteria andOrgRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("ORG_REMARK >=", value, "orgRemark");
            return (Criteria) this;
        }

        public Criteria andOrgRemarkLessThan(String value) {
            addCriterion("ORG_REMARK <", value, "orgRemark");
            return (Criteria) this;
        }

        public Criteria andOrgRemarkLessThanOrEqualTo(String value) {
            addCriterion("ORG_REMARK <=", value, "orgRemark");
            return (Criteria) this;
        }

        public Criteria andOrgRemarkLike(String value) {
            addCriterion("ORG_REMARK like", value, "orgRemark");
            return (Criteria) this;
        }

        public Criteria andOrgRemarkNotLike(String value) {
            addCriterion("ORG_REMARK not like", value, "orgRemark");
            return (Criteria) this;
        }

        public Criteria andOrgRemarkIn(List<String> values) {
            addCriterion("ORG_REMARK in", values, "orgRemark");
            return (Criteria) this;
        }

        public Criteria andOrgRemarkNotIn(List<String> values) {
            addCriterion("ORG_REMARK not in", values, "orgRemark");
            return (Criteria) this;
        }

        public Criteria andOrgRemarkBetween(String value1, String value2) {
            addCriterion("ORG_REMARK between", value1, value2, "orgRemark");
            return (Criteria) this;
        }

        public Criteria andOrgRemarkNotBetween(String value1, String value2) {
            addCriterion("ORG_REMARK not between", value1, value2, "orgRemark");
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

        public Criteria andOrgTypeIsNull() {
            addCriterion("ORG_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andOrgTypeIsNotNull() {
            addCriterion("ORG_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andOrgTypeEqualTo(String value) {
            addCriterion("ORG_TYPE =", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeNotEqualTo(String value) {
            addCriterion("ORG_TYPE <>", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeGreaterThan(String value) {
            addCriterion("ORG_TYPE >", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeGreaterThanOrEqualTo(String value) {
            addCriterion("ORG_TYPE >=", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeLessThan(String value) {
            addCriterion("ORG_TYPE <", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeLessThanOrEqualTo(String value) {
            addCriterion("ORG_TYPE <=", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeLike(String value) {
            addCriterion("ORG_TYPE like", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeNotLike(String value) {
            addCriterion("ORG_TYPE not like", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeIn(List<String> values) {
            addCriterion("ORG_TYPE in", values, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeNotIn(List<String> values) {
            addCriterion("ORG_TYPE not in", values, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeBetween(String value1, String value2) {
            addCriterion("ORG_TYPE between", value1, value2, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeNotBetween(String value1, String value2) {
            addCriterion("ORG_TYPE not between", value1, value2, "orgType");
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