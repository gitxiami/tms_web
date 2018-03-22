package com.sunyard.tms.entity;

import java.util.ArrayList;
import java.util.List;

public class DeviceLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DeviceLogExample() {
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

        public Criteria andDeviceLogIdIsNull() {
            addCriterion("DEVICE_LOG_ID is null");
            return (Criteria) this;
        }

        public Criteria andDeviceLogIdIsNotNull() {
            addCriterion("DEVICE_LOG_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceLogIdEqualTo(String value) {
            addCriterion("DEVICE_LOG_ID =", value, "deviceLogId");
            return (Criteria) this;
        }

        public Criteria andDeviceLogIdNotEqualTo(String value) {
            addCriterion("DEVICE_LOG_ID <>", value, "deviceLogId");
            return (Criteria) this;
        }

        public Criteria andDeviceLogIdGreaterThan(String value) {
            addCriterion("DEVICE_LOG_ID >", value, "deviceLogId");
            return (Criteria) this;
        }

        public Criteria andDeviceLogIdGreaterThanOrEqualTo(String value) {
            addCriterion("DEVICE_LOG_ID >=", value, "deviceLogId");
            return (Criteria) this;
        }

        public Criteria andDeviceLogIdLessThan(String value) {
            addCriterion("DEVICE_LOG_ID <", value, "deviceLogId");
            return (Criteria) this;
        }

        public Criteria andDeviceLogIdLessThanOrEqualTo(String value) {
            addCriterion("DEVICE_LOG_ID <=", value, "deviceLogId");
            return (Criteria) this;
        }

        public Criteria andDeviceLogIdLike(String value) {
            addCriterion("DEVICE_LOG_ID like", value, "deviceLogId");
            return (Criteria) this;
        }

        public Criteria andDeviceLogIdNotLike(String value) {
            addCriterion("DEVICE_LOG_ID not like", value, "deviceLogId");
            return (Criteria) this;
        }

        public Criteria andDeviceLogIdIn(List<String> values) {
            addCriterion("DEVICE_LOG_ID in", values, "deviceLogId");
            return (Criteria) this;
        }

        public Criteria andDeviceLogIdNotIn(List<String> values) {
            addCriterion("DEVICE_LOG_ID not in", values, "deviceLogId");
            return (Criteria) this;
        }

        public Criteria andDeviceLogIdBetween(String value1, String value2) {
            addCriterion("DEVICE_LOG_ID between", value1, value2, "deviceLogId");
            return (Criteria) this;
        }

        public Criteria andDeviceLogIdNotBetween(String value1, String value2) {
            addCriterion("DEVICE_LOG_ID not between", value1, value2, "deviceLogId");
            return (Criteria) this;
        }

        public Criteria andDeviceSnIsNull() {
            addCriterion("DEVICE_SN is null");
            return (Criteria) this;
        }

        public Criteria andDeviceSnIsNotNull() {
            addCriterion("DEVICE_SN is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceSnEqualTo(String value) {
            addCriterion("DEVICE_SN =", value, "deviceSn");
            return (Criteria) this;
        }

        public Criteria andDeviceSnNotEqualTo(String value) {
            addCriterion("DEVICE_SN <>", value, "deviceSn");
            return (Criteria) this;
        }

        public Criteria andDeviceSnGreaterThan(String value) {
            addCriterion("DEVICE_SN >", value, "deviceSn");
            return (Criteria) this;
        }

        public Criteria andDeviceSnGreaterThanOrEqualTo(String value) {
            addCriterion("DEVICE_SN >=", value, "deviceSn");
            return (Criteria) this;
        }

        public Criteria andDeviceSnLessThan(String value) {
            addCriterion("DEVICE_SN <", value, "deviceSn");
            return (Criteria) this;
        }

        public Criteria andDeviceSnLessThanOrEqualTo(String value) {
            addCriterion("DEVICE_SN <=", value, "deviceSn");
            return (Criteria) this;
        }

        public Criteria andDeviceSnLike(String value) {
            addCriterion("DEVICE_SN like", value, "deviceSn");
            return (Criteria) this;
        }

        public Criteria andDeviceSnNotLike(String value) {
            addCriterion("DEVICE_SN not like", value, "deviceSn");
            return (Criteria) this;
        }

        public Criteria andDeviceSnIn(List<String> values) {
            addCriterion("DEVICE_SN in", values, "deviceSn");
            return (Criteria) this;
        }

        public Criteria andDeviceSnNotIn(List<String> values) {
            addCriterion("DEVICE_SN not in", values, "deviceSn");
            return (Criteria) this;
        }

        public Criteria andDeviceSnBetween(String value1, String value2) {
            addCriterion("DEVICE_SN between", value1, value2, "deviceSn");
            return (Criteria) this;
        }

        public Criteria andDeviceSnNotBetween(String value1, String value2) {
            addCriterion("DEVICE_SN not between", value1, value2, "deviceSn");
            return (Criteria) this;
        }

        public Criteria andDeviceLogFilePathIsNull() {
            addCriterion("DEVICE_LOG_FILE_PATH is null");
            return (Criteria) this;
        }

        public Criteria andDeviceLogFilePathIsNotNull() {
            addCriterion("DEVICE_LOG_FILE_PATH is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceLogFilePathEqualTo(String value) {
            addCriterion("DEVICE_LOG_FILE_PATH =", value, "deviceLogFilePath");
            return (Criteria) this;
        }

        public Criteria andDeviceLogFilePathNotEqualTo(String value) {
            addCriterion("DEVICE_LOG_FILE_PATH <>", value, "deviceLogFilePath");
            return (Criteria) this;
        }

        public Criteria andDeviceLogFilePathGreaterThan(String value) {
            addCriterion("DEVICE_LOG_FILE_PATH >", value, "deviceLogFilePath");
            return (Criteria) this;
        }

        public Criteria andDeviceLogFilePathGreaterThanOrEqualTo(String value) {
            addCriterion("DEVICE_LOG_FILE_PATH >=", value, "deviceLogFilePath");
            return (Criteria) this;
        }

        public Criteria andDeviceLogFilePathLessThan(String value) {
            addCriterion("DEVICE_LOG_FILE_PATH <", value, "deviceLogFilePath");
            return (Criteria) this;
        }

        public Criteria andDeviceLogFilePathLessThanOrEqualTo(String value) {
            addCriterion("DEVICE_LOG_FILE_PATH <=", value, "deviceLogFilePath");
            return (Criteria) this;
        }

        public Criteria andDeviceLogFilePathLike(String value) {
            addCriterion("DEVICE_LOG_FILE_PATH like", value, "deviceLogFilePath");
            return (Criteria) this;
        }

        public Criteria andDeviceLogFilePathNotLike(String value) {
            addCriterion("DEVICE_LOG_FILE_PATH not like", value, "deviceLogFilePath");
            return (Criteria) this;
        }

        public Criteria andDeviceLogFilePathIn(List<String> values) {
            addCriterion("DEVICE_LOG_FILE_PATH in", values, "deviceLogFilePath");
            return (Criteria) this;
        }

        public Criteria andDeviceLogFilePathNotIn(List<String> values) {
            addCriterion("DEVICE_LOG_FILE_PATH not in", values, "deviceLogFilePath");
            return (Criteria) this;
        }

        public Criteria andDeviceLogFilePathBetween(String value1, String value2) {
            addCriterion("DEVICE_LOG_FILE_PATH between", value1, value2, "deviceLogFilePath");
            return (Criteria) this;
        }

        public Criteria andDeviceLogFilePathNotBetween(String value1, String value2) {
            addCriterion("DEVICE_LOG_FILE_PATH not between", value1, value2, "deviceLogFilePath");
            return (Criteria) this;
        }

        public Criteria andDeviceLogFolderPathIsNull() {
            addCriterion("DEVICE_LOG_FOLDER_PATH is null");
            return (Criteria) this;
        }

        public Criteria andDeviceLogFolderPathIsNotNull() {
            addCriterion("DEVICE_LOG_FOLDER_PATH is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceLogFolderPathEqualTo(String value) {
            addCriterion("DEVICE_LOG_FOLDER_PATH =", value, "deviceLogFolderPath");
            return (Criteria) this;
        }

        public Criteria andDeviceLogFolderPathNotEqualTo(String value) {
            addCriterion("DEVICE_LOG_FOLDER_PATH <>", value, "deviceLogFolderPath");
            return (Criteria) this;
        }

        public Criteria andDeviceLogFolderPathGreaterThan(String value) {
            addCriterion("DEVICE_LOG_FOLDER_PATH >", value, "deviceLogFolderPath");
            return (Criteria) this;
        }

        public Criteria andDeviceLogFolderPathGreaterThanOrEqualTo(String value) {
            addCriterion("DEVICE_LOG_FOLDER_PATH >=", value, "deviceLogFolderPath");
            return (Criteria) this;
        }

        public Criteria andDeviceLogFolderPathLessThan(String value) {
            addCriterion("DEVICE_LOG_FOLDER_PATH <", value, "deviceLogFolderPath");
            return (Criteria) this;
        }

        public Criteria andDeviceLogFolderPathLessThanOrEqualTo(String value) {
            addCriterion("DEVICE_LOG_FOLDER_PATH <=", value, "deviceLogFolderPath");
            return (Criteria) this;
        }

        public Criteria andDeviceLogFolderPathLike(String value) {
            addCriterion("DEVICE_LOG_FOLDER_PATH like", value, "deviceLogFolderPath");
            return (Criteria) this;
        }

        public Criteria andDeviceLogFolderPathNotLike(String value) {
            addCriterion("DEVICE_LOG_FOLDER_PATH not like", value, "deviceLogFolderPath");
            return (Criteria) this;
        }

        public Criteria andDeviceLogFolderPathIn(List<String> values) {
            addCriterion("DEVICE_LOG_FOLDER_PATH in", values, "deviceLogFolderPath");
            return (Criteria) this;
        }

        public Criteria andDeviceLogFolderPathNotIn(List<String> values) {
            addCriterion("DEVICE_LOG_FOLDER_PATH not in", values, "deviceLogFolderPath");
            return (Criteria) this;
        }

        public Criteria andDeviceLogFolderPathBetween(String value1, String value2) {
            addCriterion("DEVICE_LOG_FOLDER_PATH between", value1, value2, "deviceLogFolderPath");
            return (Criteria) this;
        }

        public Criteria andDeviceLogFolderPathNotBetween(String value1, String value2) {
            addCriterion("DEVICE_LOG_FOLDER_PATH not between", value1, value2, "deviceLogFolderPath");
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