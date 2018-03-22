package com.sunyard.tms.entity;

import java.util.ArrayList;
import java.util.List;

public class BrandExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BrandExample() {
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

        public Criteria andBrandIdIsNull() {
            addCriterion("BRAND_ID is null");
            return (Criteria) this;
        }

        public Criteria andBrandIdIsNotNull() {
            addCriterion("BRAND_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBrandIdEqualTo(String value) {
            addCriterion("BRAND_ID =", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotEqualTo(String value) {
            addCriterion("BRAND_ID <>", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdGreaterThan(String value) {
            addCriterion("BRAND_ID >", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdGreaterThanOrEqualTo(String value) {
            addCriterion("BRAND_ID >=", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdLessThan(String value) {
            addCriterion("BRAND_ID <", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdLessThanOrEqualTo(String value) {
            addCriterion("BRAND_ID <=", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdLike(String value) {
            addCriterion("BRAND_ID like", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotLike(String value) {
            addCriterion("BRAND_ID not like", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdIn(List<String> values) {
            addCriterion("BRAND_ID in", values, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotIn(List<String> values) {
            addCriterion("BRAND_ID not in", values, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdBetween(String value1, String value2) {
            addCriterion("BRAND_ID between", value1, value2, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotBetween(String value1, String value2) {
            addCriterion("BRAND_ID not between", value1, value2, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandNameIsNull() {
            addCriterion("BRAND_NAME is null");
            return (Criteria) this;
        }

        public Criteria andBrandNameIsNotNull() {
            addCriterion("BRAND_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andBrandNameEqualTo(String value) {
            addCriterion("BRAND_NAME =", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotEqualTo(String value) {
            addCriterion("BRAND_NAME <>", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameGreaterThan(String value) {
            addCriterion("BRAND_NAME >", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameGreaterThanOrEqualTo(String value) {
            addCriterion("BRAND_NAME >=", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameLessThan(String value) {
            addCriterion("BRAND_NAME <", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameLessThanOrEqualTo(String value) {
            addCriterion("BRAND_NAME <=", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameLike(String value) {
            addCriterion("BRAND_NAME like", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotLike(String value) {
            addCriterion("BRAND_NAME not like", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameIn(List<String> values) {
            addCriterion("BRAND_NAME in", values, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotIn(List<String> values) {
            addCriterion("BRAND_NAME not in", values, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameBetween(String value1, String value2) {
            addCriterion("BRAND_NAME between", value1, value2, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotBetween(String value1, String value2) {
            addCriterion("BRAND_NAME not between", value1, value2, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandLinkmanIsNull() {
            addCriterion("BRAND_LINKMAN is null");
            return (Criteria) this;
        }

        public Criteria andBrandLinkmanIsNotNull() {
            addCriterion("BRAND_LINKMAN is not null");
            return (Criteria) this;
        }

        public Criteria andBrandLinkmanEqualTo(String value) {
            addCriterion("BRAND_LINKMAN =", value, "brandLinkman");
            return (Criteria) this;
        }

        public Criteria andBrandLinkmanNotEqualTo(String value) {
            addCriterion("BRAND_LINKMAN <>", value, "brandLinkman");
            return (Criteria) this;
        }

        public Criteria andBrandLinkmanGreaterThan(String value) {
            addCriterion("BRAND_LINKMAN >", value, "brandLinkman");
            return (Criteria) this;
        }

        public Criteria andBrandLinkmanGreaterThanOrEqualTo(String value) {
            addCriterion("BRAND_LINKMAN >=", value, "brandLinkman");
            return (Criteria) this;
        }

        public Criteria andBrandLinkmanLessThan(String value) {
            addCriterion("BRAND_LINKMAN <", value, "brandLinkman");
            return (Criteria) this;
        }

        public Criteria andBrandLinkmanLessThanOrEqualTo(String value) {
            addCriterion("BRAND_LINKMAN <=", value, "brandLinkman");
            return (Criteria) this;
        }

        public Criteria andBrandLinkmanLike(String value) {
            addCriterion("BRAND_LINKMAN like", value, "brandLinkman");
            return (Criteria) this;
        }

        public Criteria andBrandLinkmanNotLike(String value) {
            addCriterion("BRAND_LINKMAN not like", value, "brandLinkman");
            return (Criteria) this;
        }

        public Criteria andBrandLinkmanIn(List<String> values) {
            addCriterion("BRAND_LINKMAN in", values, "brandLinkman");
            return (Criteria) this;
        }

        public Criteria andBrandLinkmanNotIn(List<String> values) {
            addCriterion("BRAND_LINKMAN not in", values, "brandLinkman");
            return (Criteria) this;
        }

        public Criteria andBrandLinkmanBetween(String value1, String value2) {
            addCriterion("BRAND_LINKMAN between", value1, value2, "brandLinkman");
            return (Criteria) this;
        }

        public Criteria andBrandLinkmanNotBetween(String value1, String value2) {
            addCriterion("BRAND_LINKMAN not between", value1, value2, "brandLinkman");
            return (Criteria) this;
        }

        public Criteria andBrandTelIsNull() {
            addCriterion("BRAND_TEL is null");
            return (Criteria) this;
        }

        public Criteria andBrandTelIsNotNull() {
            addCriterion("BRAND_TEL is not null");
            return (Criteria) this;
        }

        public Criteria andBrandTelEqualTo(String value) {
            addCriterion("BRAND_TEL =", value, "brandTel");
            return (Criteria) this;
        }

        public Criteria andBrandTelNotEqualTo(String value) {
            addCriterion("BRAND_TEL <>", value, "brandTel");
            return (Criteria) this;
        }

        public Criteria andBrandTelGreaterThan(String value) {
            addCriterion("BRAND_TEL >", value, "brandTel");
            return (Criteria) this;
        }

        public Criteria andBrandTelGreaterThanOrEqualTo(String value) {
            addCriterion("BRAND_TEL >=", value, "brandTel");
            return (Criteria) this;
        }

        public Criteria andBrandTelLessThan(String value) {
            addCriterion("BRAND_TEL <", value, "brandTel");
            return (Criteria) this;
        }

        public Criteria andBrandTelLessThanOrEqualTo(String value) {
            addCriterion("BRAND_TEL <=", value, "brandTel");
            return (Criteria) this;
        }

        public Criteria andBrandTelLike(String value) {
            addCriterion("BRAND_TEL like", value, "brandTel");
            return (Criteria) this;
        }

        public Criteria andBrandTelNotLike(String value) {
            addCriterion("BRAND_TEL not like", value, "brandTel");
            return (Criteria) this;
        }

        public Criteria andBrandTelIn(List<String> values) {
            addCriterion("BRAND_TEL in", values, "brandTel");
            return (Criteria) this;
        }

        public Criteria andBrandTelNotIn(List<String> values) {
            addCriterion("BRAND_TEL not in", values, "brandTel");
            return (Criteria) this;
        }

        public Criteria andBrandTelBetween(String value1, String value2) {
            addCriterion("BRAND_TEL between", value1, value2, "brandTel");
            return (Criteria) this;
        }

        public Criteria andBrandTelNotBetween(String value1, String value2) {
            addCriterion("BRAND_TEL not between", value1, value2, "brandTel");
            return (Criteria) this;
        }

        public Criteria andTmsDynamicLibraryPathIsNull() {
            addCriterion("TMS_DYNAMIC_LIBRARY_PATH is null");
            return (Criteria) this;
        }

        public Criteria andTmsDynamicLibraryPathIsNotNull() {
            addCriterion("TMS_DYNAMIC_LIBRARY_PATH is not null");
            return (Criteria) this;
        }

        public Criteria andTmsDynamicLibraryPathEqualTo(String value) {
            addCriterion("TMS_DYNAMIC_LIBRARY_PATH =", value, "tmsDynamicLibraryPath");
            return (Criteria) this;
        }

        public Criteria andTmsDynamicLibraryPathNotEqualTo(String value) {
            addCriterion("TMS_DYNAMIC_LIBRARY_PATH <>", value, "tmsDynamicLibraryPath");
            return (Criteria) this;
        }

        public Criteria andTmsDynamicLibraryPathGreaterThan(String value) {
            addCriterion("TMS_DYNAMIC_LIBRARY_PATH >", value, "tmsDynamicLibraryPath");
            return (Criteria) this;
        }

        public Criteria andTmsDynamicLibraryPathGreaterThanOrEqualTo(String value) {
            addCriterion("TMS_DYNAMIC_LIBRARY_PATH >=", value, "tmsDynamicLibraryPath");
            return (Criteria) this;
        }

        public Criteria andTmsDynamicLibraryPathLessThan(String value) {
            addCriterion("TMS_DYNAMIC_LIBRARY_PATH <", value, "tmsDynamicLibraryPath");
            return (Criteria) this;
        }

        public Criteria andTmsDynamicLibraryPathLessThanOrEqualTo(String value) {
            addCriterion("TMS_DYNAMIC_LIBRARY_PATH <=", value, "tmsDynamicLibraryPath");
            return (Criteria) this;
        }

        public Criteria andTmsDynamicLibraryPathLike(String value) {
            addCriterion("TMS_DYNAMIC_LIBRARY_PATH like", value, "tmsDynamicLibraryPath");
            return (Criteria) this;
        }

        public Criteria andTmsDynamicLibraryPathNotLike(String value) {
            addCriterion("TMS_DYNAMIC_LIBRARY_PATH not like", value, "tmsDynamicLibraryPath");
            return (Criteria) this;
        }

        public Criteria andTmsDynamicLibraryPathIn(List<String> values) {
            addCriterion("TMS_DYNAMIC_LIBRARY_PATH in", values, "tmsDynamicLibraryPath");
            return (Criteria) this;
        }

        public Criteria andTmsDynamicLibraryPathNotIn(List<String> values) {
            addCriterion("TMS_DYNAMIC_LIBRARY_PATH not in", values, "tmsDynamicLibraryPath");
            return (Criteria) this;
        }

        public Criteria andTmsDynamicLibraryPathBetween(String value1, String value2) {
            addCriterion("TMS_DYNAMIC_LIBRARY_PATH between", value1, value2, "tmsDynamicLibraryPath");
            return (Criteria) this;
        }

        public Criteria andTmsDynamicLibraryPathNotBetween(String value1, String value2) {
            addCriterion("TMS_DYNAMIC_LIBRARY_PATH not between", value1, value2, "tmsDynamicLibraryPath");
            return (Criteria) this;
        }

        public Criteria andTmsRuleLibraryPathIsNull() {
            addCriterion("TMS_RULE_LIBRARY_PATH is null");
            return (Criteria) this;
        }

        public Criteria andTmsRuleLibraryPathIsNotNull() {
            addCriterion("TMS_RULE_LIBRARY_PATH is not null");
            return (Criteria) this;
        }

        public Criteria andTmsRuleLibraryPathEqualTo(String value) {
            addCriterion("TMS_RULE_LIBRARY_PATH =", value, "tmsRuleLibraryPath");
            return (Criteria) this;
        }

        public Criteria andTmsRuleLibraryPathNotEqualTo(String value) {
            addCriterion("TMS_RULE_LIBRARY_PATH <>", value, "tmsRuleLibraryPath");
            return (Criteria) this;
        }

        public Criteria andTmsRuleLibraryPathGreaterThan(String value) {
            addCriterion("TMS_RULE_LIBRARY_PATH >", value, "tmsRuleLibraryPath");
            return (Criteria) this;
        }

        public Criteria andTmsRuleLibraryPathGreaterThanOrEqualTo(String value) {
            addCriterion("TMS_RULE_LIBRARY_PATH >=", value, "tmsRuleLibraryPath");
            return (Criteria) this;
        }

        public Criteria andTmsRuleLibraryPathLessThan(String value) {
            addCriterion("TMS_RULE_LIBRARY_PATH <", value, "tmsRuleLibraryPath");
            return (Criteria) this;
        }

        public Criteria andTmsRuleLibraryPathLessThanOrEqualTo(String value) {
            addCriterion("TMS_RULE_LIBRARY_PATH <=", value, "tmsRuleLibraryPath");
            return (Criteria) this;
        }

        public Criteria andTmsRuleLibraryPathLike(String value) {
            addCriterion("TMS_RULE_LIBRARY_PATH like", value, "tmsRuleLibraryPath");
            return (Criteria) this;
        }

        public Criteria andTmsRuleLibraryPathNotLike(String value) {
            addCriterion("TMS_RULE_LIBRARY_PATH not like", value, "tmsRuleLibraryPath");
            return (Criteria) this;
        }

        public Criteria andTmsRuleLibraryPathIn(List<String> values) {
            addCriterion("TMS_RULE_LIBRARY_PATH in", values, "tmsRuleLibraryPath");
            return (Criteria) this;
        }

        public Criteria andTmsRuleLibraryPathNotIn(List<String> values) {
            addCriterion("TMS_RULE_LIBRARY_PATH not in", values, "tmsRuleLibraryPath");
            return (Criteria) this;
        }

        public Criteria andTmsRuleLibraryPathBetween(String value1, String value2) {
            addCriterion("TMS_RULE_LIBRARY_PATH between", value1, value2, "tmsRuleLibraryPath");
            return (Criteria) this;
        }

        public Criteria andTmsRuleLibraryPathNotBetween(String value1, String value2) {
            addCriterion("TMS_RULE_LIBRARY_PATH not between", value1, value2, "tmsRuleLibraryPath");
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