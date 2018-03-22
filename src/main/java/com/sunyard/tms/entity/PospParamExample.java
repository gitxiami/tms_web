package com.sunyard.tms.entity;

import java.util.ArrayList;
import java.util.List;

public class PospParamExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PospParamExample() {
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

        public Criteria andParamTypeIsNull() {
            addCriterion("PARAM_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andParamTypeIsNotNull() {
            addCriterion("PARAM_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andParamTypeEqualTo(String value) {
            addCriterion("PARAM_TYPE =", value, "paramType");
            return (Criteria) this;
        }

        public Criteria andParamTypeNotEqualTo(String value) {
            addCriterion("PARAM_TYPE <>", value, "paramType");
            return (Criteria) this;
        }

        public Criteria andParamTypeGreaterThan(String value) {
            addCriterion("PARAM_TYPE >", value, "paramType");
            return (Criteria) this;
        }

        public Criteria andParamTypeGreaterThanOrEqualTo(String value) {
            addCriterion("PARAM_TYPE >=", value, "paramType");
            return (Criteria) this;
        }

        public Criteria andParamTypeLessThan(String value) {
            addCriterion("PARAM_TYPE <", value, "paramType");
            return (Criteria) this;
        }

        public Criteria andParamTypeLessThanOrEqualTo(String value) {
            addCriterion("PARAM_TYPE <=", value, "paramType");
            return (Criteria) this;
        }

        public Criteria andParamTypeLike(String value) {
            addCriterion("PARAM_TYPE like", value, "paramType");
            return (Criteria) this;
        }

        public Criteria andParamTypeNotLike(String value) {
            addCriterion("PARAM_TYPE not like", value, "paramType");
            return (Criteria) this;
        }

        public Criteria andParamTypeIn(List<String> values) {
            addCriterion("PARAM_TYPE in", values, "paramType");
            return (Criteria) this;
        }

        public Criteria andParamTypeNotIn(List<String> values) {
            addCriterion("PARAM_TYPE not in", values, "paramType");
            return (Criteria) this;
        }

        public Criteria andParamTypeBetween(String value1, String value2) {
            addCriterion("PARAM_TYPE between", value1, value2, "paramType");
            return (Criteria) this;
        }

        public Criteria andParamTypeNotBetween(String value1, String value2) {
            addCriterion("PARAM_TYPE not between", value1, value2, "paramType");
            return (Criteria) this;
        }

        public Criteria andParamNoIsNull() {
            addCriterion("PARAM_NO is null");
            return (Criteria) this;
        }

        public Criteria andParamNoIsNotNull() {
            addCriterion("PARAM_NO is not null");
            return (Criteria) this;
        }

        public Criteria andParamNoEqualTo(String value) {
            addCriterion("PARAM_NO =", value, "paramNo");
            return (Criteria) this;
        }

        public Criteria andParamNoNotEqualTo(String value) {
            addCriterion("PARAM_NO <>", value, "paramNo");
            return (Criteria) this;
        }

        public Criteria andParamNoGreaterThan(String value) {
            addCriterion("PARAM_NO >", value, "paramNo");
            return (Criteria) this;
        }

        public Criteria andParamNoGreaterThanOrEqualTo(String value) {
            addCriterion("PARAM_NO >=", value, "paramNo");
            return (Criteria) this;
        }

        public Criteria andParamNoLessThan(String value) {
            addCriterion("PARAM_NO <", value, "paramNo");
            return (Criteria) this;
        }

        public Criteria andParamNoLessThanOrEqualTo(String value) {
            addCriterion("PARAM_NO <=", value, "paramNo");
            return (Criteria) this;
        }

        public Criteria andParamNoLike(String value) {
            addCriterion("PARAM_NO like", value, "paramNo");
            return (Criteria) this;
        }

        public Criteria andParamNoNotLike(String value) {
            addCriterion("PARAM_NO not like", value, "paramNo");
            return (Criteria) this;
        }

        public Criteria andParamNoIn(List<String> values) {
            addCriterion("PARAM_NO in", values, "paramNo");
            return (Criteria) this;
        }

        public Criteria andParamNoNotIn(List<String> values) {
            addCriterion("PARAM_NO not in", values, "paramNo");
            return (Criteria) this;
        }

        public Criteria andParamNoBetween(String value1, String value2) {
            addCriterion("PARAM_NO between", value1, value2, "paramNo");
            return (Criteria) this;
        }

        public Criteria andParamNoNotBetween(String value1, String value2) {
            addCriterion("PARAM_NO not between", value1, value2, "paramNo");
            return (Criteria) this;
        }

        public Criteria andParamLenIsNull() {
            addCriterion("PARAM_LEN is null");
            return (Criteria) this;
        }

        public Criteria andParamLenIsNotNull() {
            addCriterion("PARAM_LEN is not null");
            return (Criteria) this;
        }

        public Criteria andParamLenEqualTo(String value) {
            addCriterion("PARAM_LEN =", value, "paramLen");
            return (Criteria) this;
        }

        public Criteria andParamLenNotEqualTo(String value) {
            addCriterion("PARAM_LEN <>", value, "paramLen");
            return (Criteria) this;
        }

        public Criteria andParamLenGreaterThan(String value) {
            addCriterion("PARAM_LEN >", value, "paramLen");
            return (Criteria) this;
        }

        public Criteria andParamLenGreaterThanOrEqualTo(String value) {
            addCriterion("PARAM_LEN >=", value, "paramLen");
            return (Criteria) this;
        }

        public Criteria andParamLenLessThan(String value) {
            addCriterion("PARAM_LEN <", value, "paramLen");
            return (Criteria) this;
        }

        public Criteria andParamLenLessThanOrEqualTo(String value) {
            addCriterion("PARAM_LEN <=", value, "paramLen");
            return (Criteria) this;
        }

        public Criteria andParamLenLike(String value) {
            addCriterion("PARAM_LEN like", value, "paramLen");
            return (Criteria) this;
        }

        public Criteria andParamLenNotLike(String value) {
            addCriterion("PARAM_LEN not like", value, "paramLen");
            return (Criteria) this;
        }

        public Criteria andParamLenIn(List<String> values) {
            addCriterion("PARAM_LEN in", values, "paramLen");
            return (Criteria) this;
        }

        public Criteria andParamLenNotIn(List<String> values) {
            addCriterion("PARAM_LEN not in", values, "paramLen");
            return (Criteria) this;
        }

        public Criteria andParamLenBetween(String value1, String value2) {
            addCriterion("PARAM_LEN between", value1, value2, "paramLen");
            return (Criteria) this;
        }

        public Criteria andParamLenNotBetween(String value1, String value2) {
            addCriterion("PARAM_LEN not between", value1, value2, "paramLen");
            return (Criteria) this;
        }

        public Criteria andParamValIsNull() {
            addCriterion("PARAM_VAL is null");
            return (Criteria) this;
        }

        public Criteria andParamValIsNotNull() {
            addCriterion("PARAM_VAL is not null");
            return (Criteria) this;
        }

        public Criteria andParamValEqualTo(String value) {
            addCriterion("PARAM_VAL =", value, "paramVal");
            return (Criteria) this;
        }

        public Criteria andParamValNotEqualTo(String value) {
            addCriterion("PARAM_VAL <>", value, "paramVal");
            return (Criteria) this;
        }

        public Criteria andParamValGreaterThan(String value) {
            addCriterion("PARAM_VAL >", value, "paramVal");
            return (Criteria) this;
        }

        public Criteria andParamValGreaterThanOrEqualTo(String value) {
            addCriterion("PARAM_VAL >=", value, "paramVal");
            return (Criteria) this;
        }

        public Criteria andParamValLessThan(String value) {
            addCriterion("PARAM_VAL <", value, "paramVal");
            return (Criteria) this;
        }

        public Criteria andParamValLessThanOrEqualTo(String value) {
            addCriterion("PARAM_VAL <=", value, "paramVal");
            return (Criteria) this;
        }

        public Criteria andParamValLike(String value) {
            addCriterion("PARAM_VAL like", value, "paramVal");
            return (Criteria) this;
        }

        public Criteria andParamValNotLike(String value) {
            addCriterion("PARAM_VAL not like", value, "paramVal");
            return (Criteria) this;
        }

        public Criteria andParamValIn(List<String> values) {
            addCriterion("PARAM_VAL in", values, "paramVal");
            return (Criteria) this;
        }

        public Criteria andParamValNotIn(List<String> values) {
            addCriterion("PARAM_VAL not in", values, "paramVal");
            return (Criteria) this;
        }

        public Criteria andParamValBetween(String value1, String value2) {
            addCriterion("PARAM_VAL between", value1, value2, "paramVal");
            return (Criteria) this;
        }

        public Criteria andParamValNotBetween(String value1, String value2) {
            addCriterion("PARAM_VAL not between", value1, value2, "paramVal");
            return (Criteria) this;
        }

        public Criteria andParamVerIsNull() {
            addCriterion("PARAM_VER is null");
            return (Criteria) this;
        }

        public Criteria andParamVerIsNotNull() {
            addCriterion("PARAM_VER is not null");
            return (Criteria) this;
        }

        public Criteria andParamVerEqualTo(String value) {
            addCriterion("PARAM_VER =", value, "paramVer");
            return (Criteria) this;
        }

        public Criteria andParamVerNotEqualTo(String value) {
            addCriterion("PARAM_VER <>", value, "paramVer");
            return (Criteria) this;
        }

        public Criteria andParamVerGreaterThan(String value) {
            addCriterion("PARAM_VER >", value, "paramVer");
            return (Criteria) this;
        }

        public Criteria andParamVerGreaterThanOrEqualTo(String value) {
            addCriterion("PARAM_VER >=", value, "paramVer");
            return (Criteria) this;
        }

        public Criteria andParamVerLessThan(String value) {
            addCriterion("PARAM_VER <", value, "paramVer");
            return (Criteria) this;
        }

        public Criteria andParamVerLessThanOrEqualTo(String value) {
            addCriterion("PARAM_VER <=", value, "paramVer");
            return (Criteria) this;
        }

        public Criteria andParamVerLike(String value) {
            addCriterion("PARAM_VER like", value, "paramVer");
            return (Criteria) this;
        }

        public Criteria andParamVerNotLike(String value) {
            addCriterion("PARAM_VER not like", value, "paramVer");
            return (Criteria) this;
        }

        public Criteria andParamVerIn(List<String> values) {
            addCriterion("PARAM_VER in", values, "paramVer");
            return (Criteria) this;
        }

        public Criteria andParamVerNotIn(List<String> values) {
            addCriterion("PARAM_VER not in", values, "paramVer");
            return (Criteria) this;
        }

        public Criteria andParamVerBetween(String value1, String value2) {
            addCriterion("PARAM_VER between", value1, value2, "paramVer");
            return (Criteria) this;
        }

        public Criteria andParamVerNotBetween(String value1, String value2) {
            addCriterion("PARAM_VER not between", value1, value2, "paramVer");
            return (Criteria) this;
        }

        public Criteria andCreateOpraterIsNull() {
            addCriterion("CREATE_OPRATER is null");
            return (Criteria) this;
        }

        public Criteria andCreateOpraterIsNotNull() {
            addCriterion("CREATE_OPRATER is not null");
            return (Criteria) this;
        }

        public Criteria andCreateOpraterEqualTo(String value) {
            addCriterion("CREATE_OPRATER =", value, "createOprater");
            return (Criteria) this;
        }

        public Criteria andCreateOpraterNotEqualTo(String value) {
            addCriterion("CREATE_OPRATER <>", value, "createOprater");
            return (Criteria) this;
        }

        public Criteria andCreateOpraterGreaterThan(String value) {
            addCriterion("CREATE_OPRATER >", value, "createOprater");
            return (Criteria) this;
        }

        public Criteria andCreateOpraterGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_OPRATER >=", value, "createOprater");
            return (Criteria) this;
        }

        public Criteria andCreateOpraterLessThan(String value) {
            addCriterion("CREATE_OPRATER <", value, "createOprater");
            return (Criteria) this;
        }

        public Criteria andCreateOpraterLessThanOrEqualTo(String value) {
            addCriterion("CREATE_OPRATER <=", value, "createOprater");
            return (Criteria) this;
        }

        public Criteria andCreateOpraterLike(String value) {
            addCriterion("CREATE_OPRATER like", value, "createOprater");
            return (Criteria) this;
        }

        public Criteria andCreateOpraterNotLike(String value) {
            addCriterion("CREATE_OPRATER not like", value, "createOprater");
            return (Criteria) this;
        }

        public Criteria andCreateOpraterIn(List<String> values) {
            addCriterion("CREATE_OPRATER in", values, "createOprater");
            return (Criteria) this;
        }

        public Criteria andCreateOpraterNotIn(List<String> values) {
            addCriterion("CREATE_OPRATER not in", values, "createOprater");
            return (Criteria) this;
        }

        public Criteria andCreateOpraterBetween(String value1, String value2) {
            addCriterion("CREATE_OPRATER between", value1, value2, "createOprater");
            return (Criteria) this;
        }

        public Criteria andCreateOpraterNotBetween(String value1, String value2) {
            addCriterion("CREATE_OPRATER not between", value1, value2, "createOprater");
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