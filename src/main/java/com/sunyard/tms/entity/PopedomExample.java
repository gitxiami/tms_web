package com.sunyard.tms.entity;

import java.util.ArrayList;
import java.util.List;

public class PopedomExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PopedomExample() {
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

        public Criteria andPopedomIdIsNull() {
            addCriterion("POPEDOM_ID is null");
            return (Criteria) this;
        }

        public Criteria andPopedomIdIsNotNull() {
            addCriterion("POPEDOM_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPopedomIdEqualTo(String value) {
            addCriterion("POPEDOM_ID =", value, "popedomId");
            return (Criteria) this;
        }

        public Criteria andPopedomIdNotEqualTo(String value) {
            addCriterion("POPEDOM_ID <>", value, "popedomId");
            return (Criteria) this;
        }

        public Criteria andPopedomIdGreaterThan(String value) {
            addCriterion("POPEDOM_ID >", value, "popedomId");
            return (Criteria) this;
        }

        public Criteria andPopedomIdGreaterThanOrEqualTo(String value) {
            addCriterion("POPEDOM_ID >=", value, "popedomId");
            return (Criteria) this;
        }

        public Criteria andPopedomIdLessThan(String value) {
            addCriterion("POPEDOM_ID <", value, "popedomId");
            return (Criteria) this;
        }

        public Criteria andPopedomIdLessThanOrEqualTo(String value) {
            addCriterion("POPEDOM_ID <=", value, "popedomId");
            return (Criteria) this;
        }

        public Criteria andPopedomIdLike(String value) {
            addCriterion("POPEDOM_ID like", value, "popedomId");
            return (Criteria) this;
        }

        public Criteria andPopedomIdNotLike(String value) {
            addCriterion("POPEDOM_ID not like", value, "popedomId");
            return (Criteria) this;
        }

        public Criteria andPopedomIdIn(List<String> values) {
            addCriterion("POPEDOM_ID in", values, "popedomId");
            return (Criteria) this;
        }

        public Criteria andPopedomIdNotIn(List<String> values) {
            addCriterion("POPEDOM_ID not in", values, "popedomId");
            return (Criteria) this;
        }

        public Criteria andPopedomIdBetween(String value1, String value2) {
            addCriterion("POPEDOM_ID between", value1, value2, "popedomId");
            return (Criteria) this;
        }

        public Criteria andPopedomIdNotBetween(String value1, String value2) {
            addCriterion("POPEDOM_ID not between", value1, value2, "popedomId");
            return (Criteria) this;
        }

        public Criteria andPopedomNameIsNull() {
            addCriterion("POPEDOM_NAME is null");
            return (Criteria) this;
        }

        public Criteria andPopedomNameIsNotNull() {
            addCriterion("POPEDOM_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andPopedomNameEqualTo(String value) {
            addCriterion("POPEDOM_NAME =", value, "popedomName");
            return (Criteria) this;
        }

        public Criteria andPopedomNameNotEqualTo(String value) {
            addCriterion("POPEDOM_NAME <>", value, "popedomName");
            return (Criteria) this;
        }

        public Criteria andPopedomNameGreaterThan(String value) {
            addCriterion("POPEDOM_NAME >", value, "popedomName");
            return (Criteria) this;
        }

        public Criteria andPopedomNameGreaterThanOrEqualTo(String value) {
            addCriterion("POPEDOM_NAME >=", value, "popedomName");
            return (Criteria) this;
        }

        public Criteria andPopedomNameLessThan(String value) {
            addCriterion("POPEDOM_NAME <", value, "popedomName");
            return (Criteria) this;
        }

        public Criteria andPopedomNameLessThanOrEqualTo(String value) {
            addCriterion("POPEDOM_NAME <=", value, "popedomName");
            return (Criteria) this;
        }

        public Criteria andPopedomNameLike(String value) {
            addCriterion("POPEDOM_NAME like", value, "popedomName");
            return (Criteria) this;
        }

        public Criteria andPopedomNameNotLike(String value) {
            addCriterion("POPEDOM_NAME not like", value, "popedomName");
            return (Criteria) this;
        }

        public Criteria andPopedomNameIn(List<String> values) {
            addCriterion("POPEDOM_NAME in", values, "popedomName");
            return (Criteria) this;
        }

        public Criteria andPopedomNameNotIn(List<String> values) {
            addCriterion("POPEDOM_NAME not in", values, "popedomName");
            return (Criteria) this;
        }

        public Criteria andPopedomNameBetween(String value1, String value2) {
            addCriterion("POPEDOM_NAME between", value1, value2, "popedomName");
            return (Criteria) this;
        }

        public Criteria andPopedomNameNotBetween(String value1, String value2) {
            addCriterion("POPEDOM_NAME not between", value1, value2, "popedomName");
            return (Criteria) this;
        }

        public Criteria andPopedomActionIsNull() {
            addCriterion("POPEDOM_ACTION is null");
            return (Criteria) this;
        }

        public Criteria andPopedomActionIsNotNull() {
            addCriterion("POPEDOM_ACTION is not null");
            return (Criteria) this;
        }

        public Criteria andPopedomActionEqualTo(String value) {
            addCriterion("POPEDOM_ACTION =", value, "popedomAction");
            return (Criteria) this;
        }

        public Criteria andPopedomActionNotEqualTo(String value) {
            addCriterion("POPEDOM_ACTION <>", value, "popedomAction");
            return (Criteria) this;
        }

        public Criteria andPopedomActionGreaterThan(String value) {
            addCriterion("POPEDOM_ACTION >", value, "popedomAction");
            return (Criteria) this;
        }

        public Criteria andPopedomActionGreaterThanOrEqualTo(String value) {
            addCriterion("POPEDOM_ACTION >=", value, "popedomAction");
            return (Criteria) this;
        }

        public Criteria andPopedomActionLessThan(String value) {
            addCriterion("POPEDOM_ACTION <", value, "popedomAction");
            return (Criteria) this;
        }

        public Criteria andPopedomActionLessThanOrEqualTo(String value) {
            addCriterion("POPEDOM_ACTION <=", value, "popedomAction");
            return (Criteria) this;
        }

        public Criteria andPopedomActionLike(String value) {
            addCriterion("POPEDOM_ACTION like", value, "popedomAction");
            return (Criteria) this;
        }

        public Criteria andPopedomActionNotLike(String value) {
            addCriterion("POPEDOM_ACTION not like", value, "popedomAction");
            return (Criteria) this;
        }

        public Criteria andPopedomActionIn(List<String> values) {
            addCriterion("POPEDOM_ACTION in", values, "popedomAction");
            return (Criteria) this;
        }

        public Criteria andPopedomActionNotIn(List<String> values) {
            addCriterion("POPEDOM_ACTION not in", values, "popedomAction");
            return (Criteria) this;
        }

        public Criteria andPopedomActionBetween(String value1, String value2) {
            addCriterion("POPEDOM_ACTION between", value1, value2, "popedomAction");
            return (Criteria) this;
        }

        public Criteria andPopedomActionNotBetween(String value1, String value2) {
            addCriterion("POPEDOM_ACTION not between", value1, value2, "popedomAction");
            return (Criteria) this;
        }

        public Criteria andPopedomTypeIsNull() {
            addCriterion("POPEDOM_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andPopedomTypeIsNotNull() {
            addCriterion("POPEDOM_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andPopedomTypeEqualTo(String value) {
            addCriterion("POPEDOM_TYPE =", value, "popedomType");
            return (Criteria) this;
        }

        public Criteria andPopedomTypeNotEqualTo(String value) {
            addCriterion("POPEDOM_TYPE <>", value, "popedomType");
            return (Criteria) this;
        }

        public Criteria andPopedomTypeGreaterThan(String value) {
            addCriterion("POPEDOM_TYPE >", value, "popedomType");
            return (Criteria) this;
        }

        public Criteria andPopedomTypeGreaterThanOrEqualTo(String value) {
            addCriterion("POPEDOM_TYPE >=", value, "popedomType");
            return (Criteria) this;
        }

        public Criteria andPopedomTypeLessThan(String value) {
            addCriterion("POPEDOM_TYPE <", value, "popedomType");
            return (Criteria) this;
        }

        public Criteria andPopedomTypeLessThanOrEqualTo(String value) {
            addCriterion("POPEDOM_TYPE <=", value, "popedomType");
            return (Criteria) this;
        }

        public Criteria andPopedomTypeLike(String value) {
            addCriterion("POPEDOM_TYPE like", value, "popedomType");
            return (Criteria) this;
        }

        public Criteria andPopedomTypeNotLike(String value) {
            addCriterion("POPEDOM_TYPE not like", value, "popedomType");
            return (Criteria) this;
        }

        public Criteria andPopedomTypeIn(List<String> values) {
            addCriterion("POPEDOM_TYPE in", values, "popedomType");
            return (Criteria) this;
        }

        public Criteria andPopedomTypeNotIn(List<String> values) {
            addCriterion("POPEDOM_TYPE not in", values, "popedomType");
            return (Criteria) this;
        }

        public Criteria andPopedomTypeBetween(String value1, String value2) {
            addCriterion("POPEDOM_TYPE between", value1, value2, "popedomType");
            return (Criteria) this;
        }

        public Criteria andPopedomTypeNotBetween(String value1, String value2) {
            addCriterion("POPEDOM_TYPE not between", value1, value2, "popedomType");
            return (Criteria) this;
        }

        public Criteria andPopedomRemarkIsNull() {
            addCriterion("POPEDOM_REMARK is null");
            return (Criteria) this;
        }

        public Criteria andPopedomRemarkIsNotNull() {
            addCriterion("POPEDOM_REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andPopedomRemarkEqualTo(String value) {
            addCriterion("POPEDOM_REMARK =", value, "popedomRemark");
            return (Criteria) this;
        }

        public Criteria andPopedomRemarkNotEqualTo(String value) {
            addCriterion("POPEDOM_REMARK <>", value, "popedomRemark");
            return (Criteria) this;
        }

        public Criteria andPopedomRemarkGreaterThan(String value) {
            addCriterion("POPEDOM_REMARK >", value, "popedomRemark");
            return (Criteria) this;
        }

        public Criteria andPopedomRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("POPEDOM_REMARK >=", value, "popedomRemark");
            return (Criteria) this;
        }

        public Criteria andPopedomRemarkLessThan(String value) {
            addCriterion("POPEDOM_REMARK <", value, "popedomRemark");
            return (Criteria) this;
        }

        public Criteria andPopedomRemarkLessThanOrEqualTo(String value) {
            addCriterion("POPEDOM_REMARK <=", value, "popedomRemark");
            return (Criteria) this;
        }

        public Criteria andPopedomRemarkLike(String value) {
            addCriterion("POPEDOM_REMARK like", value, "popedomRemark");
            return (Criteria) this;
        }

        public Criteria andPopedomRemarkNotLike(String value) {
            addCriterion("POPEDOM_REMARK not like", value, "popedomRemark");
            return (Criteria) this;
        }

        public Criteria andPopedomRemarkIn(List<String> values) {
            addCriterion("POPEDOM_REMARK in", values, "popedomRemark");
            return (Criteria) this;
        }

        public Criteria andPopedomRemarkNotIn(List<String> values) {
            addCriterion("POPEDOM_REMARK not in", values, "popedomRemark");
            return (Criteria) this;
        }

        public Criteria andPopedomRemarkBetween(String value1, String value2) {
            addCriterion("POPEDOM_REMARK between", value1, value2, "popedomRemark");
            return (Criteria) this;
        }

        public Criteria andPopedomRemarkNotBetween(String value1, String value2) {
            addCriterion("POPEDOM_REMARK not between", value1, value2, "popedomRemark");
            return (Criteria) this;
        }

        public Criteria andPopedomPidIsNull() {
            addCriterion("POPEDOM_PID is null");
            return (Criteria) this;
        }

        public Criteria andPopedomPidIsNotNull() {
            addCriterion("POPEDOM_PID is not null");
            return (Criteria) this;
        }

        public Criteria andPopedomPidEqualTo(String value) {
            addCriterion("POPEDOM_PID =", value, "popedomPid");
            return (Criteria) this;
        }

        public Criteria andPopedomPidNotEqualTo(String value) {
            addCriterion("POPEDOM_PID <>", value, "popedomPid");
            return (Criteria) this;
        }

        public Criteria andPopedomPidGreaterThan(String value) {
            addCriterion("POPEDOM_PID >", value, "popedomPid");
            return (Criteria) this;
        }

        public Criteria andPopedomPidGreaterThanOrEqualTo(String value) {
            addCriterion("POPEDOM_PID >=", value, "popedomPid");
            return (Criteria) this;
        }

        public Criteria andPopedomPidLessThan(String value) {
            addCriterion("POPEDOM_PID <", value, "popedomPid");
            return (Criteria) this;
        }

        public Criteria andPopedomPidLessThanOrEqualTo(String value) {
            addCriterion("POPEDOM_PID <=", value, "popedomPid");
            return (Criteria) this;
        }

        public Criteria andPopedomPidLike(String value) {
            addCriterion("POPEDOM_PID like", value, "popedomPid");
            return (Criteria) this;
        }

        public Criteria andPopedomPidNotLike(String value) {
            addCriterion("POPEDOM_PID not like", value, "popedomPid");
            return (Criteria) this;
        }

        public Criteria andPopedomPidIn(List<String> values) {
            addCriterion("POPEDOM_PID in", values, "popedomPid");
            return (Criteria) this;
        }

        public Criteria andPopedomPidNotIn(List<String> values) {
            addCriterion("POPEDOM_PID not in", values, "popedomPid");
            return (Criteria) this;
        }

        public Criteria andPopedomPidBetween(String value1, String value2) {
            addCriterion("POPEDOM_PID between", value1, value2, "popedomPid");
            return (Criteria) this;
        }

        public Criteria andPopedomPidNotBetween(String value1, String value2) {
            addCriterion("POPEDOM_PID not between", value1, value2, "popedomPid");
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

        public Criteria andPopedomLinkIsNull() {
            addCriterion("POPEDOM_LINK is null");
            return (Criteria) this;
        }

        public Criteria andPopedomLinkIsNotNull() {
            addCriterion("POPEDOM_LINK is not null");
            return (Criteria) this;
        }

        public Criteria andPopedomLinkEqualTo(String value) {
            addCriterion("POPEDOM_LINK =", value, "popedomLink");
            return (Criteria) this;
        }

        public Criteria andPopedomLinkNotEqualTo(String value) {
            addCriterion("POPEDOM_LINK <>", value, "popedomLink");
            return (Criteria) this;
        }

        public Criteria andPopedomLinkGreaterThan(String value) {
            addCriterion("POPEDOM_LINK >", value, "popedomLink");
            return (Criteria) this;
        }

        public Criteria andPopedomLinkGreaterThanOrEqualTo(String value) {
            addCriterion("POPEDOM_LINK >=", value, "popedomLink");
            return (Criteria) this;
        }

        public Criteria andPopedomLinkLessThan(String value) {
            addCriterion("POPEDOM_LINK <", value, "popedomLink");
            return (Criteria) this;
        }

        public Criteria andPopedomLinkLessThanOrEqualTo(String value) {
            addCriterion("POPEDOM_LINK <=", value, "popedomLink");
            return (Criteria) this;
        }

        public Criteria andPopedomLinkLike(String value) {
            addCriterion("POPEDOM_LINK like", value, "popedomLink");
            return (Criteria) this;
        }

        public Criteria andPopedomLinkNotLike(String value) {
            addCriterion("POPEDOM_LINK not like", value, "popedomLink");
            return (Criteria) this;
        }

        public Criteria andPopedomLinkIn(List<String> values) {
            addCriterion("POPEDOM_LINK in", values, "popedomLink");
            return (Criteria) this;
        }

        public Criteria andPopedomLinkNotIn(List<String> values) {
            addCriterion("POPEDOM_LINK not in", values, "popedomLink");
            return (Criteria) this;
        }

        public Criteria andPopedomLinkBetween(String value1, String value2) {
            addCriterion("POPEDOM_LINK between", value1, value2, "popedomLink");
            return (Criteria) this;
        }

        public Criteria andPopedomLinkNotBetween(String value1, String value2) {
            addCriterion("POPEDOM_LINK not between", value1, value2, "popedomLink");
            return (Criteria) this;
        }

        public Criteria andPopedomIconclsIsNull() {
            addCriterion("POPEDOM_ICONCLS is null");
            return (Criteria) this;
        }

        public Criteria andPopedomIconclsIsNotNull() {
            addCriterion("POPEDOM_ICONCLS is not null");
            return (Criteria) this;
        }

        public Criteria andPopedomIconclsEqualTo(String value) {
            addCriterion("POPEDOM_ICONCLS =", value, "popedomIconcls");
            return (Criteria) this;
        }

        public Criteria andPopedomIconclsNotEqualTo(String value) {
            addCriterion("POPEDOM_ICONCLS <>", value, "popedomIconcls");
            return (Criteria) this;
        }

        public Criteria andPopedomIconclsGreaterThan(String value) {
            addCriterion("POPEDOM_ICONCLS >", value, "popedomIconcls");
            return (Criteria) this;
        }

        public Criteria andPopedomIconclsGreaterThanOrEqualTo(String value) {
            addCriterion("POPEDOM_ICONCLS >=", value, "popedomIconcls");
            return (Criteria) this;
        }

        public Criteria andPopedomIconclsLessThan(String value) {
            addCriterion("POPEDOM_ICONCLS <", value, "popedomIconcls");
            return (Criteria) this;
        }

        public Criteria andPopedomIconclsLessThanOrEqualTo(String value) {
            addCriterion("POPEDOM_ICONCLS <=", value, "popedomIconcls");
            return (Criteria) this;
        }

        public Criteria andPopedomIconclsLike(String value) {
            addCriterion("POPEDOM_ICONCLS like", value, "popedomIconcls");
            return (Criteria) this;
        }

        public Criteria andPopedomIconclsNotLike(String value) {
            addCriterion("POPEDOM_ICONCLS not like", value, "popedomIconcls");
            return (Criteria) this;
        }

        public Criteria andPopedomIconclsIn(List<String> values) {
            addCriterion("POPEDOM_ICONCLS in", values, "popedomIconcls");
            return (Criteria) this;
        }

        public Criteria andPopedomIconclsNotIn(List<String> values) {
            addCriterion("POPEDOM_ICONCLS not in", values, "popedomIconcls");
            return (Criteria) this;
        }

        public Criteria andPopedomIconclsBetween(String value1, String value2) {
            addCriterion("POPEDOM_ICONCLS between", value1, value2, "popedomIconcls");
            return (Criteria) this;
        }

        public Criteria andPopedomIconclsNotBetween(String value1, String value2) {
            addCriterion("POPEDOM_ICONCLS not between", value1, value2, "popedomIconcls");
            return (Criteria) this;
        }

        public Criteria andPopedomOriginIsNull() {
            addCriterion("POPEDOM_ORIGIN is null");
            return (Criteria) this;
        }

        public Criteria andPopedomOriginIsNotNull() {
            addCriterion("POPEDOM_ORIGIN is not null");
            return (Criteria) this;
        }

        public Criteria andPopedomOriginEqualTo(String value) {
            addCriterion("POPEDOM_ORIGIN =", value, "popedomOrigin");
            return (Criteria) this;
        }

        public Criteria andPopedomOriginNotEqualTo(String value) {
            addCriterion("POPEDOM_ORIGIN <>", value, "popedomOrigin");
            return (Criteria) this;
        }

        public Criteria andPopedomOriginGreaterThan(String value) {
            addCriterion("POPEDOM_ORIGIN >", value, "popedomOrigin");
            return (Criteria) this;
        }

        public Criteria andPopedomOriginGreaterThanOrEqualTo(String value) {
            addCriterion("POPEDOM_ORIGIN >=", value, "popedomOrigin");
            return (Criteria) this;
        }

        public Criteria andPopedomOriginLessThan(String value) {
            addCriterion("POPEDOM_ORIGIN <", value, "popedomOrigin");
            return (Criteria) this;
        }

        public Criteria andPopedomOriginLessThanOrEqualTo(String value) {
            addCriterion("POPEDOM_ORIGIN <=", value, "popedomOrigin");
            return (Criteria) this;
        }

        public Criteria andPopedomOriginLike(String value) {
            addCriterion("POPEDOM_ORIGIN like", value, "popedomOrigin");
            return (Criteria) this;
        }

        public Criteria andPopedomOriginNotLike(String value) {
            addCriterion("POPEDOM_ORIGIN not like", value, "popedomOrigin");
            return (Criteria) this;
        }

        public Criteria andPopedomOriginIn(List<String> values) {
            addCriterion("POPEDOM_ORIGIN in", values, "popedomOrigin");
            return (Criteria) this;
        }

        public Criteria andPopedomOriginNotIn(List<String> values) {
            addCriterion("POPEDOM_ORIGIN not in", values, "popedomOrigin");
            return (Criteria) this;
        }

        public Criteria andPopedomOriginBetween(String value1, String value2) {
            addCriterion("POPEDOM_ORIGIN between", value1, value2, "popedomOrigin");
            return (Criteria) this;
        }

        public Criteria andPopedomOriginNotBetween(String value1, String value2) {
            addCriterion("POPEDOM_ORIGIN not between", value1, value2, "popedomOrigin");
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