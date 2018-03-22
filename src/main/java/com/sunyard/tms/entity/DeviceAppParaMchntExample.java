package com.sunyard.tms.entity;

import java.util.ArrayList;
import java.util.List;

public class DeviceAppParaMchntExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DeviceAppParaMchntExample() {
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

        public Criteria andParaIdIsNull() {
            addCriterion("PARA_ID is null");
            return (Criteria) this;
        }

        public Criteria andParaIdIsNotNull() {
            addCriterion("PARA_ID is not null");
            return (Criteria) this;
        }

        public Criteria andParaIdEqualTo(String value) {
            addCriterion("PARA_ID =", value, "paraId");
            return (Criteria) this;
        }

        public Criteria andParaIdNotEqualTo(String value) {
            addCriterion("PARA_ID <>", value, "paraId");
            return (Criteria) this;
        }

        public Criteria andParaIdGreaterThan(String value) {
            addCriterion("PARA_ID >", value, "paraId");
            return (Criteria) this;
        }

        public Criteria andParaIdGreaterThanOrEqualTo(String value) {
            addCriterion("PARA_ID >=", value, "paraId");
            return (Criteria) this;
        }

        public Criteria andParaIdLessThan(String value) {
            addCriterion("PARA_ID <", value, "paraId");
            return (Criteria) this;
        }

        public Criteria andParaIdLessThanOrEqualTo(String value) {
            addCriterion("PARA_ID <=", value, "paraId");
            return (Criteria) this;
        }

        public Criteria andParaIdLike(String value) {
            addCriterion("PARA_ID like", value, "paraId");
            return (Criteria) this;
        }

        public Criteria andParaIdNotLike(String value) {
            addCriterion("PARA_ID not like", value, "paraId");
            return (Criteria) this;
        }

        public Criteria andParaIdIn(List<String> values) {
            addCriterion("PARA_ID in", values, "paraId");
            return (Criteria) this;
        }

        public Criteria andParaIdNotIn(List<String> values) {
            addCriterion("PARA_ID not in", values, "paraId");
            return (Criteria) this;
        }

        public Criteria andParaIdBetween(String value1, String value2) {
            addCriterion("PARA_ID between", value1, value2, "paraId");
            return (Criteria) this;
        }

        public Criteria andParaIdNotBetween(String value1, String value2) {
            addCriterion("PARA_ID not between", value1, value2, "paraId");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("TYPE =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("TYPE <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("TYPE >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("TYPE >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("TYPE <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("TYPE <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("TYPE like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("TYPE not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("TYPE in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("TYPE not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("TYPE between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("TYPE not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andCurrencyIsNull() {
            addCriterion("CURRENCY is null");
            return (Criteria) this;
        }

        public Criteria andCurrencyIsNotNull() {
            addCriterion("CURRENCY is not null");
            return (Criteria) this;
        }

        public Criteria andCurrencyEqualTo(String value) {
            addCriterion("CURRENCY =", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotEqualTo(String value) {
            addCriterion("CURRENCY <>", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyGreaterThan(String value) {
            addCriterion("CURRENCY >", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyGreaterThanOrEqualTo(String value) {
            addCriterion("CURRENCY >=", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLessThan(String value) {
            addCriterion("CURRENCY <", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLessThanOrEqualTo(String value) {
            addCriterion("CURRENCY <=", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLike(String value) {
            addCriterion("CURRENCY like", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotLike(String value) {
            addCriterion("CURRENCY not like", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyIn(List<String> values) {
            addCriterion("CURRENCY in", values, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotIn(List<String> values) {
            addCriterion("CURRENCY not in", values, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyBetween(String value1, String value2) {
            addCriterion("CURRENCY between", value1, value2, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotBetween(String value1, String value2) {
            addCriterion("CURRENCY not between", value1, value2, "currency");
            return (Criteria) this;
        }

        public Criteria andMidIsNull() {
            addCriterion("MID is null");
            return (Criteria) this;
        }

        public Criteria andMidIsNotNull() {
            addCriterion("MID is not null");
            return (Criteria) this;
        }

        public Criteria andMidEqualTo(String value) {
            addCriterion("MID =", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotEqualTo(String value) {
            addCriterion("MID <>", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidGreaterThan(String value) {
            addCriterion("MID >", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidGreaterThanOrEqualTo(String value) {
            addCriterion("MID >=", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidLessThan(String value) {
            addCriterion("MID <", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidLessThanOrEqualTo(String value) {
            addCriterion("MID <=", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidLike(String value) {
            addCriterion("MID like", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotLike(String value) {
            addCriterion("MID not like", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidIn(List<String> values) {
            addCriterion("MID in", values, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotIn(List<String> values) {
            addCriterion("MID not in", values, "mid");
            return (Criteria) this;
        }

        public Criteria andMidBetween(String value1, String value2) {
            addCriterion("MID between", value1, value2, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotBetween(String value1, String value2) {
            addCriterion("MID not between", value1, value2, "mid");
            return (Criteria) this;
        }

        public Criteria andTidIsNull() {
            addCriterion("TID is null");
            return (Criteria) this;
        }

        public Criteria andTidIsNotNull() {
            addCriterion("TID is not null");
            return (Criteria) this;
        }

        public Criteria andTidEqualTo(String value) {
            addCriterion("TID =", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotEqualTo(String value) {
            addCriterion("TID <>", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThan(String value) {
            addCriterion("TID >", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThanOrEqualTo(String value) {
            addCriterion("TID >=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThan(String value) {
            addCriterion("TID <", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThanOrEqualTo(String value) {
            addCriterion("TID <=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLike(String value) {
            addCriterion("TID like", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotLike(String value) {
            addCriterion("TID not like", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidIn(List<String> values) {
            addCriterion("TID in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotIn(List<String> values) {
            addCriterion("TID not in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidBetween(String value1, String value2) {
            addCriterion("TID between", value1, value2, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotBetween(String value1, String value2) {
            addCriterion("TID not between", value1, value2, "tid");
            return (Criteria) this;
        }

        public Criteria andTransIsNull() {
            addCriterion("TRANS is null");
            return (Criteria) this;
        }

        public Criteria andTransIsNotNull() {
            addCriterion("TRANS is not null");
            return (Criteria) this;
        }

        public Criteria andTransEqualTo(String value) {
            addCriterion("TRANS =", value, "trans");
            return (Criteria) this;
        }

        public Criteria andTransNotEqualTo(String value) {
            addCriterion("TRANS <>", value, "trans");
            return (Criteria) this;
        }

        public Criteria andTransGreaterThan(String value) {
            addCriterion("TRANS >", value, "trans");
            return (Criteria) this;
        }

        public Criteria andTransGreaterThanOrEqualTo(String value) {
            addCriterion("TRANS >=", value, "trans");
            return (Criteria) this;
        }

        public Criteria andTransLessThan(String value) {
            addCriterion("TRANS <", value, "trans");
            return (Criteria) this;
        }

        public Criteria andTransLessThanOrEqualTo(String value) {
            addCriterion("TRANS <=", value, "trans");
            return (Criteria) this;
        }

        public Criteria andTransLike(String value) {
            addCriterion("TRANS like", value, "trans");
            return (Criteria) this;
        }

        public Criteria andTransNotLike(String value) {
            addCriterion("TRANS not like", value, "trans");
            return (Criteria) this;
        }

        public Criteria andTransIn(List<String> values) {
            addCriterion("TRANS in", values, "trans");
            return (Criteria) this;
        }

        public Criteria andTransNotIn(List<String> values) {
            addCriterion("TRANS not in", values, "trans");
            return (Criteria) this;
        }

        public Criteria andTransBetween(String value1, String value2) {
            addCriterion("TRANS between", value1, value2, "trans");
            return (Criteria) this;
        }

        public Criteria andTransNotBetween(String value1, String value2) {
            addCriterion("TRANS not between", value1, value2, "trans");
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