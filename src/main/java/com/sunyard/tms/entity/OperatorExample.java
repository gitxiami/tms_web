package com.sunyard.tms.entity;

import java.util.ArrayList;
import java.util.List;

public class OperatorExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OperatorExample() {
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

        public Criteria andOpUsernameIsNull() {
            addCriterion("OP_USERNAME is null");
            return (Criteria) this;
        }

        public Criteria andOpUsernameIsNotNull() {
            addCriterion("OP_USERNAME is not null");
            return (Criteria) this;
        }

        public Criteria andOpUsernameEqualTo(String value) {
            addCriterion("OP_USERNAME =", value, "opUsername");
            return (Criteria) this;
        }

        public Criteria andOpUsernameNotEqualTo(String value) {
            addCriterion("OP_USERNAME <>", value, "opUsername");
            return (Criteria) this;
        }

        public Criteria andOpUsernameGreaterThan(String value) {
            addCriterion("OP_USERNAME >", value, "opUsername");
            return (Criteria) this;
        }

        public Criteria andOpUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("OP_USERNAME >=", value, "opUsername");
            return (Criteria) this;
        }

        public Criteria andOpUsernameLessThan(String value) {
            addCriterion("OP_USERNAME <", value, "opUsername");
            return (Criteria) this;
        }

        public Criteria andOpUsernameLessThanOrEqualTo(String value) {
            addCriterion("OP_USERNAME <=", value, "opUsername");
            return (Criteria) this;
        }

        public Criteria andOpUsernameLike(String value) {
            addCriterion("OP_USERNAME like", value, "opUsername");
            return (Criteria) this;
        }

        public Criteria andOpUsernameNotLike(String value) {
            addCriterion("OP_USERNAME not like", value, "opUsername");
            return (Criteria) this;
        }

        public Criteria andOpUsernameIn(List<String> values) {
            addCriterion("OP_USERNAME in", values, "opUsername");
            return (Criteria) this;
        }

        public Criteria andOpUsernameNotIn(List<String> values) {
            addCriterion("OP_USERNAME not in", values, "opUsername");
            return (Criteria) this;
        }

        public Criteria andOpUsernameBetween(String value1, String value2) {
            addCriterion("OP_USERNAME between", value1, value2, "opUsername");
            return (Criteria) this;
        }

        public Criteria andOpUsernameNotBetween(String value1, String value2) {
            addCriterion("OP_USERNAME not between", value1, value2, "opUsername");
            return (Criteria) this;
        }

        public Criteria andOpPwdIsNull() {
            addCriterion("OP_PWD is null");
            return (Criteria) this;
        }

        public Criteria andOpPwdIsNotNull() {
            addCriterion("OP_PWD is not null");
            return (Criteria) this;
        }

        public Criteria andOpPwdEqualTo(String value) {
            addCriterion("OP_PWD =", value, "opPwd");
            return (Criteria) this;
        }

        public Criteria andOpPwdNotEqualTo(String value) {
            addCriterion("OP_PWD <>", value, "opPwd");
            return (Criteria) this;
        }

        public Criteria andOpPwdGreaterThan(String value) {
            addCriterion("OP_PWD >", value, "opPwd");
            return (Criteria) this;
        }

        public Criteria andOpPwdGreaterThanOrEqualTo(String value) {
            addCriterion("OP_PWD >=", value, "opPwd");
            return (Criteria) this;
        }

        public Criteria andOpPwdLessThan(String value) {
            addCriterion("OP_PWD <", value, "opPwd");
            return (Criteria) this;
        }

        public Criteria andOpPwdLessThanOrEqualTo(String value) {
            addCriterion("OP_PWD <=", value, "opPwd");
            return (Criteria) this;
        }

        public Criteria andOpPwdLike(String value) {
            addCriterion("OP_PWD like", value, "opPwd");
            return (Criteria) this;
        }

        public Criteria andOpPwdNotLike(String value) {
            addCriterion("OP_PWD not like", value, "opPwd");
            return (Criteria) this;
        }

        public Criteria andOpPwdIn(List<String> values) {
            addCriterion("OP_PWD in", values, "opPwd");
            return (Criteria) this;
        }

        public Criteria andOpPwdNotIn(List<String> values) {
            addCriterion("OP_PWD not in", values, "opPwd");
            return (Criteria) this;
        }

        public Criteria andOpPwdBetween(String value1, String value2) {
            addCriterion("OP_PWD between", value1, value2, "opPwd");
            return (Criteria) this;
        }

        public Criteria andOpPwdNotBetween(String value1, String value2) {
            addCriterion("OP_PWD not between", value1, value2, "opPwd");
            return (Criteria) this;
        }

        public Criteria andOpRealnameIsNull() {
            addCriterion("OP_REALNAME is null");
            return (Criteria) this;
        }

        public Criteria andOpRealnameIsNotNull() {
            addCriterion("OP_REALNAME is not null");
            return (Criteria) this;
        }

        public Criteria andOpRealnameEqualTo(String value) {
            addCriterion("OP_REALNAME =", value, "opRealname");
            return (Criteria) this;
        }

        public Criteria andOpRealnameNotEqualTo(String value) {
            addCriterion("OP_REALNAME <>", value, "opRealname");
            return (Criteria) this;
        }

        public Criteria andOpRealnameGreaterThan(String value) {
            addCriterion("OP_REALNAME >", value, "opRealname");
            return (Criteria) this;
        }

        public Criteria andOpRealnameGreaterThanOrEqualTo(String value) {
            addCriterion("OP_REALNAME >=", value, "opRealname");
            return (Criteria) this;
        }

        public Criteria andOpRealnameLessThan(String value) {
            addCriterion("OP_REALNAME <", value, "opRealname");
            return (Criteria) this;
        }

        public Criteria andOpRealnameLessThanOrEqualTo(String value) {
            addCriterion("OP_REALNAME <=", value, "opRealname");
            return (Criteria) this;
        }

        public Criteria andOpRealnameLike(String value) {
            addCriterion("OP_REALNAME like", value, "opRealname");
            return (Criteria) this;
        }

        public Criteria andOpRealnameNotLike(String value) {
            addCriterion("OP_REALNAME not like", value, "opRealname");
            return (Criteria) this;
        }

        public Criteria andOpRealnameIn(List<String> values) {
            addCriterion("OP_REALNAME in", values, "opRealname");
            return (Criteria) this;
        }

        public Criteria andOpRealnameNotIn(List<String> values) {
            addCriterion("OP_REALNAME not in", values, "opRealname");
            return (Criteria) this;
        }

        public Criteria andOpRealnameBetween(String value1, String value2) {
            addCriterion("OP_REALNAME between", value1, value2, "opRealname");
            return (Criteria) this;
        }

        public Criteria andOpRealnameNotBetween(String value1, String value2) {
            addCriterion("OP_REALNAME not between", value1, value2, "opRealname");
            return (Criteria) this;
        }

        public Criteria andOpStatusIsNull() {
            addCriterion("OP_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andOpStatusIsNotNull() {
            addCriterion("OP_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andOpStatusEqualTo(String value) {
            addCriterion("OP_STATUS =", value, "opStatus");
            return (Criteria) this;
        }

        public Criteria andOpStatusNotEqualTo(String value) {
            addCriterion("OP_STATUS <>", value, "opStatus");
            return (Criteria) this;
        }

        public Criteria andOpStatusGreaterThan(String value) {
            addCriterion("OP_STATUS >", value, "opStatus");
            return (Criteria) this;
        }

        public Criteria andOpStatusGreaterThanOrEqualTo(String value) {
            addCriterion("OP_STATUS >=", value, "opStatus");
            return (Criteria) this;
        }

        public Criteria andOpStatusLessThan(String value) {
            addCriterion("OP_STATUS <", value, "opStatus");
            return (Criteria) this;
        }

        public Criteria andOpStatusLessThanOrEqualTo(String value) {
            addCriterion("OP_STATUS <=", value, "opStatus");
            return (Criteria) this;
        }

        public Criteria andOpStatusLike(String value) {
            addCriterion("OP_STATUS like", value, "opStatus");
            return (Criteria) this;
        }

        public Criteria andOpStatusNotLike(String value) {
            addCriterion("OP_STATUS not like", value, "opStatus");
            return (Criteria) this;
        }

        public Criteria andOpStatusIn(List<String> values) {
            addCriterion("OP_STATUS in", values, "opStatus");
            return (Criteria) this;
        }

        public Criteria andOpStatusNotIn(List<String> values) {
            addCriterion("OP_STATUS not in", values, "opStatus");
            return (Criteria) this;
        }

        public Criteria andOpStatusBetween(String value1, String value2) {
            addCriterion("OP_STATUS between", value1, value2, "opStatus");
            return (Criteria) this;
        }

        public Criteria andOpStatusNotBetween(String value1, String value2) {
            addCriterion("OP_STATUS not between", value1, value2, "opStatus");
            return (Criteria) this;
        }

        public Criteria andOpTelIsNull() {
            addCriterion("OP_TEL is null");
            return (Criteria) this;
        }

        public Criteria andOpTelIsNotNull() {
            addCriterion("OP_TEL is not null");
            return (Criteria) this;
        }

        public Criteria andOpTelEqualTo(String value) {
            addCriterion("OP_TEL =", value, "opTel");
            return (Criteria) this;
        }

        public Criteria andOpTelNotEqualTo(String value) {
            addCriterion("OP_TEL <>", value, "opTel");
            return (Criteria) this;
        }

        public Criteria andOpTelGreaterThan(String value) {
            addCriterion("OP_TEL >", value, "opTel");
            return (Criteria) this;
        }

        public Criteria andOpTelGreaterThanOrEqualTo(String value) {
            addCriterion("OP_TEL >=", value, "opTel");
            return (Criteria) this;
        }

        public Criteria andOpTelLessThan(String value) {
            addCriterion("OP_TEL <", value, "opTel");
            return (Criteria) this;
        }

        public Criteria andOpTelLessThanOrEqualTo(String value) {
            addCriterion("OP_TEL <=", value, "opTel");
            return (Criteria) this;
        }

        public Criteria andOpTelLike(String value) {
            addCriterion("OP_TEL like", value, "opTel");
            return (Criteria) this;
        }

        public Criteria andOpTelNotLike(String value) {
            addCriterion("OP_TEL not like", value, "opTel");
            return (Criteria) this;
        }

        public Criteria andOpTelIn(List<String> values) {
            addCriterion("OP_TEL in", values, "opTel");
            return (Criteria) this;
        }

        public Criteria andOpTelNotIn(List<String> values) {
            addCriterion("OP_TEL not in", values, "opTel");
            return (Criteria) this;
        }

        public Criteria andOpTelBetween(String value1, String value2) {
            addCriterion("OP_TEL between", value1, value2, "opTel");
            return (Criteria) this;
        }

        public Criteria andOpTelNotBetween(String value1, String value2) {
            addCriterion("OP_TEL not between", value1, value2, "opTel");
            return (Criteria) this;
        }

        public Criteria andOpPwdErrnumIsNull() {
            addCriterion("OP_PWD_ERRNUM is null");
            return (Criteria) this;
        }

        public Criteria andOpPwdErrnumIsNotNull() {
            addCriterion("OP_PWD_ERRNUM is not null");
            return (Criteria) this;
        }

        public Criteria andOpPwdErrnumEqualTo(Integer value) {
            addCriterion("OP_PWD_ERRNUM =", value, "opPwdErrnum");
            return (Criteria) this;
        }

        public Criteria andOpPwdErrnumNotEqualTo(Integer value) {
            addCriterion("OP_PWD_ERRNUM <>", value, "opPwdErrnum");
            return (Criteria) this;
        }

        public Criteria andOpPwdErrnumGreaterThan(Integer value) {
            addCriterion("OP_PWD_ERRNUM >", value, "opPwdErrnum");
            return (Criteria) this;
        }

        public Criteria andOpPwdErrnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("OP_PWD_ERRNUM >=", value, "opPwdErrnum");
            return (Criteria) this;
        }

        public Criteria andOpPwdErrnumLessThan(Integer value) {
            addCriterion("OP_PWD_ERRNUM <", value, "opPwdErrnum");
            return (Criteria) this;
        }

        public Criteria andOpPwdErrnumLessThanOrEqualTo(Integer value) {
            addCriterion("OP_PWD_ERRNUM <=", value, "opPwdErrnum");
            return (Criteria) this;
        }

        public Criteria andOpPwdErrnumIn(List<Integer> values) {
            addCriterion("OP_PWD_ERRNUM in", values, "opPwdErrnum");
            return (Criteria) this;
        }

        public Criteria andOpPwdErrnumNotIn(List<Integer> values) {
            addCriterion("OP_PWD_ERRNUM not in", values, "opPwdErrnum");
            return (Criteria) this;
        }

        public Criteria andOpPwdErrnumBetween(Integer value1, Integer value2) {
            addCriterion("OP_PWD_ERRNUM between", value1, value2, "opPwdErrnum");
            return (Criteria) this;
        }

        public Criteria andOpPwdErrnumNotBetween(Integer value1, Integer value2) {
            addCriterion("OP_PWD_ERRNUM not between", value1, value2, "opPwdErrnum");
            return (Criteria) this;
        }

        public Criteria andOpRemarkIsNull() {
            addCriterion("OP_REMARK is null");
            return (Criteria) this;
        }

        public Criteria andOpRemarkIsNotNull() {
            addCriterion("OP_REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andOpRemarkEqualTo(String value) {
            addCriterion("OP_REMARK =", value, "opRemark");
            return (Criteria) this;
        }

        public Criteria andOpRemarkNotEqualTo(String value) {
            addCriterion("OP_REMARK <>", value, "opRemark");
            return (Criteria) this;
        }

        public Criteria andOpRemarkGreaterThan(String value) {
            addCriterion("OP_REMARK >", value, "opRemark");
            return (Criteria) this;
        }

        public Criteria andOpRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("OP_REMARK >=", value, "opRemark");
            return (Criteria) this;
        }

        public Criteria andOpRemarkLessThan(String value) {
            addCriterion("OP_REMARK <", value, "opRemark");
            return (Criteria) this;
        }

        public Criteria andOpRemarkLessThanOrEqualTo(String value) {
            addCriterion("OP_REMARK <=", value, "opRemark");
            return (Criteria) this;
        }

        public Criteria andOpRemarkLike(String value) {
            addCriterion("OP_REMARK like", value, "opRemark");
            return (Criteria) this;
        }

        public Criteria andOpRemarkNotLike(String value) {
            addCriterion("OP_REMARK not like", value, "opRemark");
            return (Criteria) this;
        }

        public Criteria andOpRemarkIn(List<String> values) {
            addCriterion("OP_REMARK in", values, "opRemark");
            return (Criteria) this;
        }

        public Criteria andOpRemarkNotIn(List<String> values) {
            addCriterion("OP_REMARK not in", values, "opRemark");
            return (Criteria) this;
        }

        public Criteria andOpRemarkBetween(String value1, String value2) {
            addCriterion("OP_REMARK between", value1, value2, "opRemark");
            return (Criteria) this;
        }

        public Criteria andOpRemarkNotBetween(String value1, String value2) {
            addCriterion("OP_REMARK not between", value1, value2, "opRemark");
            return (Criteria) this;
        }

        public Criteria andOpLastLoginTimeIsNull() {
            addCriterion("OP_LAST_LOGIN_TIME is null");
            return (Criteria) this;
        }

        public Criteria andOpLastLoginTimeIsNotNull() {
            addCriterion("OP_LAST_LOGIN_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andOpLastLoginTimeEqualTo(String value) {
            addCriterion("OP_LAST_LOGIN_TIME =", value, "opLastLoginTime");
            return (Criteria) this;
        }

        public Criteria andOpLastLoginTimeNotEqualTo(String value) {
            addCriterion("OP_LAST_LOGIN_TIME <>", value, "opLastLoginTime");
            return (Criteria) this;
        }

        public Criteria andOpLastLoginTimeGreaterThan(String value) {
            addCriterion("OP_LAST_LOGIN_TIME >", value, "opLastLoginTime");
            return (Criteria) this;
        }

        public Criteria andOpLastLoginTimeGreaterThanOrEqualTo(String value) {
            addCriterion("OP_LAST_LOGIN_TIME >=", value, "opLastLoginTime");
            return (Criteria) this;
        }

        public Criteria andOpLastLoginTimeLessThan(String value) {
            addCriterion("OP_LAST_LOGIN_TIME <", value, "opLastLoginTime");
            return (Criteria) this;
        }

        public Criteria andOpLastLoginTimeLessThanOrEqualTo(String value) {
            addCriterion("OP_LAST_LOGIN_TIME <=", value, "opLastLoginTime");
            return (Criteria) this;
        }

        public Criteria andOpLastLoginTimeLike(String value) {
            addCriterion("OP_LAST_LOGIN_TIME like", value, "opLastLoginTime");
            return (Criteria) this;
        }

        public Criteria andOpLastLoginTimeNotLike(String value) {
            addCriterion("OP_LAST_LOGIN_TIME not like", value, "opLastLoginTime");
            return (Criteria) this;
        }

        public Criteria andOpLastLoginTimeIn(List<String> values) {
            addCriterion("OP_LAST_LOGIN_TIME in", values, "opLastLoginTime");
            return (Criteria) this;
        }

        public Criteria andOpLastLoginTimeNotIn(List<String> values) {
            addCriterion("OP_LAST_LOGIN_TIME not in", values, "opLastLoginTime");
            return (Criteria) this;
        }

        public Criteria andOpLastLoginTimeBetween(String value1, String value2) {
            addCriterion("OP_LAST_LOGIN_TIME between", value1, value2, "opLastLoginTime");
            return (Criteria) this;
        }

        public Criteria andOpLastLoginTimeNotBetween(String value1, String value2) {
            addCriterion("OP_LAST_LOGIN_TIME not between", value1, value2, "opLastLoginTime");
            return (Criteria) this;
        }

        public Criteria andOpErrortimeIsNull() {
            addCriterion("OP_ERRORTIME is null");
            return (Criteria) this;
        }

        public Criteria andOpErrortimeIsNotNull() {
            addCriterion("OP_ERRORTIME is not null");
            return (Criteria) this;
        }

        public Criteria andOpErrortimeEqualTo(String value) {
            addCriterion("OP_ERRORTIME =", value, "opErrortime");
            return (Criteria) this;
        }

        public Criteria andOpErrortimeNotEqualTo(String value) {
            addCriterion("OP_ERRORTIME <>", value, "opErrortime");
            return (Criteria) this;
        }

        public Criteria andOpErrortimeGreaterThan(String value) {
            addCriterion("OP_ERRORTIME >", value, "opErrortime");
            return (Criteria) this;
        }

        public Criteria andOpErrortimeGreaterThanOrEqualTo(String value) {
            addCriterion("OP_ERRORTIME >=", value, "opErrortime");
            return (Criteria) this;
        }

        public Criteria andOpErrortimeLessThan(String value) {
            addCriterion("OP_ERRORTIME <", value, "opErrortime");
            return (Criteria) this;
        }

        public Criteria andOpErrortimeLessThanOrEqualTo(String value) {
            addCriterion("OP_ERRORTIME <=", value, "opErrortime");
            return (Criteria) this;
        }

        public Criteria andOpErrortimeLike(String value) {
            addCriterion("OP_ERRORTIME like", value, "opErrortime");
            return (Criteria) this;
        }

        public Criteria andOpErrortimeNotLike(String value) {
            addCriterion("OP_ERRORTIME not like", value, "opErrortime");
            return (Criteria) this;
        }

        public Criteria andOpErrortimeIn(List<String> values) {
            addCriterion("OP_ERRORTIME in", values, "opErrortime");
            return (Criteria) this;
        }

        public Criteria andOpErrortimeNotIn(List<String> values) {
            addCriterion("OP_ERRORTIME not in", values, "opErrortime");
            return (Criteria) this;
        }

        public Criteria andOpErrortimeBetween(String value1, String value2) {
            addCriterion("OP_ERRORTIME between", value1, value2, "opErrortime");
            return (Criteria) this;
        }

        public Criteria andOpErrortimeNotBetween(String value1, String value2) {
            addCriterion("OP_ERRORTIME not between", value1, value2, "opErrortime");
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