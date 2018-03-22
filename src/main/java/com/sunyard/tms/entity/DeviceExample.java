package com.sunyard.tms.entity;

import java.util.ArrayList;
import java.util.List;

public class DeviceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DeviceExample() {
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

        public Criteria andDeviceIdIsNull() {
            addCriterion("DEVICE_ID is null");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIsNotNull() {
            addCriterion("DEVICE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceIdEqualTo(String value) {
            addCriterion("DEVICE_ID =", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotEqualTo(String value) {
            addCriterion("DEVICE_ID <>", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdGreaterThan(String value) {
            addCriterion("DEVICE_ID >", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdGreaterThanOrEqualTo(String value) {
            addCriterion("DEVICE_ID >=", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLessThan(String value) {
            addCriterion("DEVICE_ID <", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLessThanOrEqualTo(String value) {
            addCriterion("DEVICE_ID <=", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLike(String value) {
            addCriterion("DEVICE_ID like", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotLike(String value) {
            addCriterion("DEVICE_ID not like", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIn(List<String> values) {
            addCriterion("DEVICE_ID in", values, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotIn(List<String> values) {
            addCriterion("DEVICE_ID not in", values, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdBetween(String value1, String value2) {
            addCriterion("DEVICE_ID between", value1, value2, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotBetween(String value1, String value2) {
            addCriterion("DEVICE_ID not between", value1, value2, "deviceId");
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

        public Criteria andPsamIdIsNull() {
            addCriterion("PSAM_ID is null");
            return (Criteria) this;
        }

        public Criteria andPsamIdIsNotNull() {
            addCriterion("PSAM_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPsamIdEqualTo(String value) {
            addCriterion("PSAM_ID =", value, "psamId");
            return (Criteria) this;
        }

        public Criteria andPsamIdNotEqualTo(String value) {
            addCriterion("PSAM_ID <>", value, "psamId");
            return (Criteria) this;
        }

        public Criteria andPsamIdGreaterThan(String value) {
            addCriterion("PSAM_ID >", value, "psamId");
            return (Criteria) this;
        }

        public Criteria andPsamIdGreaterThanOrEqualTo(String value) {
            addCriterion("PSAM_ID >=", value, "psamId");
            return (Criteria) this;
        }

        public Criteria andPsamIdLessThan(String value) {
            addCriterion("PSAM_ID <", value, "psamId");
            return (Criteria) this;
        }

        public Criteria andPsamIdLessThanOrEqualTo(String value) {
            addCriterion("PSAM_ID <=", value, "psamId");
            return (Criteria) this;
        }

        public Criteria andPsamIdLike(String value) {
            addCriterion("PSAM_ID like", value, "psamId");
            return (Criteria) this;
        }

        public Criteria andPsamIdNotLike(String value) {
            addCriterion("PSAM_ID not like", value, "psamId");
            return (Criteria) this;
        }

        public Criteria andPsamIdIn(List<String> values) {
            addCriterion("PSAM_ID in", values, "psamId");
            return (Criteria) this;
        }

        public Criteria andPsamIdNotIn(List<String> values) {
            addCriterion("PSAM_ID not in", values, "psamId");
            return (Criteria) this;
        }

        public Criteria andPsamIdBetween(String value1, String value2) {
            addCriterion("PSAM_ID between", value1, value2, "psamId");
            return (Criteria) this;
        }

        public Criteria andPsamIdNotBetween(String value1, String value2) {
            addCriterion("PSAM_ID not between", value1, value2, "psamId");
            return (Criteria) this;
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

        public Criteria andBatchNoIsNull() {
            addCriterion("BATCH_NO is null");
            return (Criteria) this;
        }

        public Criteria andBatchNoIsNotNull() {
            addCriterion("BATCH_NO is not null");
            return (Criteria) this;
        }

        public Criteria andBatchNoEqualTo(String value) {
            addCriterion("BATCH_NO =", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotEqualTo(String value) {
            addCriterion("BATCH_NO <>", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoGreaterThan(String value) {
            addCriterion("BATCH_NO >", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoGreaterThanOrEqualTo(String value) {
            addCriterion("BATCH_NO >=", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoLessThan(String value) {
            addCriterion("BATCH_NO <", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoLessThanOrEqualTo(String value) {
            addCriterion("BATCH_NO <=", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoLike(String value) {
            addCriterion("BATCH_NO like", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotLike(String value) {
            addCriterion("BATCH_NO not like", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoIn(List<String> values) {
            addCriterion("BATCH_NO in", values, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotIn(List<String> values) {
            addCriterion("BATCH_NO not in", values, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoBetween(String value1, String value2) {
            addCriterion("BATCH_NO between", value1, value2, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotBetween(String value1, String value2) {
            addCriterion("BATCH_NO not between", value1, value2, "batchNo");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeFlagIsNull() {
            addCriterion("DEVICE_TYPE_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeFlagIsNotNull() {
            addCriterion("DEVICE_TYPE_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeFlagEqualTo(String value) {
            addCriterion("DEVICE_TYPE_FLAG =", value, "deviceTypeFlag");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeFlagNotEqualTo(String value) {
            addCriterion("DEVICE_TYPE_FLAG <>", value, "deviceTypeFlag");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeFlagGreaterThan(String value) {
            addCriterion("DEVICE_TYPE_FLAG >", value, "deviceTypeFlag");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeFlagGreaterThanOrEqualTo(String value) {
            addCriterion("DEVICE_TYPE_FLAG >=", value, "deviceTypeFlag");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeFlagLessThan(String value) {
            addCriterion("DEVICE_TYPE_FLAG <", value, "deviceTypeFlag");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeFlagLessThanOrEqualTo(String value) {
            addCriterion("DEVICE_TYPE_FLAG <=", value, "deviceTypeFlag");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeFlagLike(String value) {
            addCriterion("DEVICE_TYPE_FLAG like", value, "deviceTypeFlag");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeFlagNotLike(String value) {
            addCriterion("DEVICE_TYPE_FLAG not like", value, "deviceTypeFlag");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeFlagIn(List<String> values) {
            addCriterion("DEVICE_TYPE_FLAG in", values, "deviceTypeFlag");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeFlagNotIn(List<String> values) {
            addCriterion("DEVICE_TYPE_FLAG not in", values, "deviceTypeFlag");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeFlagBetween(String value1, String value2) {
            addCriterion("DEVICE_TYPE_FLAG between", value1, value2, "deviceTypeFlag");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeFlagNotBetween(String value1, String value2) {
            addCriterion("DEVICE_TYPE_FLAG not between", value1, value2, "deviceTypeFlag");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusIsNull() {
            addCriterion("DEVICE_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusIsNotNull() {
            addCriterion("DEVICE_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusEqualTo(String value) {
            addCriterion("DEVICE_STATUS =", value, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusNotEqualTo(String value) {
            addCriterion("DEVICE_STATUS <>", value, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusGreaterThan(String value) {
            addCriterion("DEVICE_STATUS >", value, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusGreaterThanOrEqualTo(String value) {
            addCriterion("DEVICE_STATUS >=", value, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusLessThan(String value) {
            addCriterion("DEVICE_STATUS <", value, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusLessThanOrEqualTo(String value) {
            addCriterion("DEVICE_STATUS <=", value, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusLike(String value) {
            addCriterion("DEVICE_STATUS like", value, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusNotLike(String value) {
            addCriterion("DEVICE_STATUS not like", value, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusIn(List<String> values) {
            addCriterion("DEVICE_STATUS in", values, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusNotIn(List<String> values) {
            addCriterion("DEVICE_STATUS not in", values, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusBetween(String value1, String value2) {
            addCriterion("DEVICE_STATUS between", value1, value2, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusNotBetween(String value1, String value2) {
            addCriterion("DEVICE_STATUS not between", value1, value2, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceLimitStatusIsNull() {
            addCriterion("DEVICE_LIMIT_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andDeviceLimitStatusIsNotNull() {
            addCriterion("DEVICE_LIMIT_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceLimitStatusEqualTo(String value) {
            addCriterion("DEVICE_LIMIT_STATUS =", value, "deviceLimitStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceLimitStatusNotEqualTo(String value) {
            addCriterion("DEVICE_LIMIT_STATUS <>", value, "deviceLimitStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceLimitStatusGreaterThan(String value) {
            addCriterion("DEVICE_LIMIT_STATUS >", value, "deviceLimitStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceLimitStatusGreaterThanOrEqualTo(String value) {
            addCriterion("DEVICE_LIMIT_STATUS >=", value, "deviceLimitStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceLimitStatusLessThan(String value) {
            addCriterion("DEVICE_LIMIT_STATUS <", value, "deviceLimitStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceLimitStatusLessThanOrEqualTo(String value) {
            addCriterion("DEVICE_LIMIT_STATUS <=", value, "deviceLimitStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceLimitStatusLike(String value) {
            addCriterion("DEVICE_LIMIT_STATUS like", value, "deviceLimitStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceLimitStatusNotLike(String value) {
            addCriterion("DEVICE_LIMIT_STATUS not like", value, "deviceLimitStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceLimitStatusIn(List<String> values) {
            addCriterion("DEVICE_LIMIT_STATUS in", values, "deviceLimitStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceLimitStatusNotIn(List<String> values) {
            addCriterion("DEVICE_LIMIT_STATUS not in", values, "deviceLimitStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceLimitStatusBetween(String value1, String value2) {
            addCriterion("DEVICE_LIMIT_STATUS between", value1, value2, "deviceLimitStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceLimitStatusNotBetween(String value1, String value2) {
            addCriterion("DEVICE_LIMIT_STATUS not between", value1, value2, "deviceLimitStatus");
            return (Criteria) this;
        }

        public Criteria andAppLoginPwdIsNull() {
            addCriterion("APP_LOGIN_PWD is null");
            return (Criteria) this;
        }

        public Criteria andAppLoginPwdIsNotNull() {
            addCriterion("APP_LOGIN_PWD is not null");
            return (Criteria) this;
        }

        public Criteria andAppLoginPwdEqualTo(String value) {
            addCriterion("APP_LOGIN_PWD =", value, "appLoginPwd");
            return (Criteria) this;
        }

        public Criteria andAppLoginPwdNotEqualTo(String value) {
            addCriterion("APP_LOGIN_PWD <>", value, "appLoginPwd");
            return (Criteria) this;
        }

        public Criteria andAppLoginPwdGreaterThan(String value) {
            addCriterion("APP_LOGIN_PWD >", value, "appLoginPwd");
            return (Criteria) this;
        }

        public Criteria andAppLoginPwdGreaterThanOrEqualTo(String value) {
            addCriterion("APP_LOGIN_PWD >=", value, "appLoginPwd");
            return (Criteria) this;
        }

        public Criteria andAppLoginPwdLessThan(String value) {
            addCriterion("APP_LOGIN_PWD <", value, "appLoginPwd");
            return (Criteria) this;
        }

        public Criteria andAppLoginPwdLessThanOrEqualTo(String value) {
            addCriterion("APP_LOGIN_PWD <=", value, "appLoginPwd");
            return (Criteria) this;
        }

        public Criteria andAppLoginPwdLike(String value) {
            addCriterion("APP_LOGIN_PWD like", value, "appLoginPwd");
            return (Criteria) this;
        }

        public Criteria andAppLoginPwdNotLike(String value) {
            addCriterion("APP_LOGIN_PWD not like", value, "appLoginPwd");
            return (Criteria) this;
        }

        public Criteria andAppLoginPwdIn(List<String> values) {
            addCriterion("APP_LOGIN_PWD in", values, "appLoginPwd");
            return (Criteria) this;
        }

        public Criteria andAppLoginPwdNotIn(List<String> values) {
            addCriterion("APP_LOGIN_PWD not in", values, "appLoginPwd");
            return (Criteria) this;
        }

        public Criteria andAppLoginPwdBetween(String value1, String value2) {
            addCriterion("APP_LOGIN_PWD between", value1, value2, "appLoginPwd");
            return (Criteria) this;
        }

        public Criteria andAppLoginPwdNotBetween(String value1, String value2) {
            addCriterion("APP_LOGIN_PWD not between", value1, value2, "appLoginPwd");
            return (Criteria) this;
        }

        public Criteria andDevKeyAlgTypeIsNull() {
            addCriterion("DEV_KEY_ALG_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andDevKeyAlgTypeIsNotNull() {
            addCriterion("DEV_KEY_ALG_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andDevKeyAlgTypeEqualTo(String value) {
            addCriterion("DEV_KEY_ALG_TYPE =", value, "devKeyAlgType");
            return (Criteria) this;
        }

        public Criteria andDevKeyAlgTypeNotEqualTo(String value) {
            addCriterion("DEV_KEY_ALG_TYPE <>", value, "devKeyAlgType");
            return (Criteria) this;
        }

        public Criteria andDevKeyAlgTypeGreaterThan(String value) {
            addCriterion("DEV_KEY_ALG_TYPE >", value, "devKeyAlgType");
            return (Criteria) this;
        }

        public Criteria andDevKeyAlgTypeGreaterThanOrEqualTo(String value) {
            addCriterion("DEV_KEY_ALG_TYPE >=", value, "devKeyAlgType");
            return (Criteria) this;
        }

        public Criteria andDevKeyAlgTypeLessThan(String value) {
            addCriterion("DEV_KEY_ALG_TYPE <", value, "devKeyAlgType");
            return (Criteria) this;
        }

        public Criteria andDevKeyAlgTypeLessThanOrEqualTo(String value) {
            addCriterion("DEV_KEY_ALG_TYPE <=", value, "devKeyAlgType");
            return (Criteria) this;
        }

        public Criteria andDevKeyAlgTypeLike(String value) {
            addCriterion("DEV_KEY_ALG_TYPE like", value, "devKeyAlgType");
            return (Criteria) this;
        }

        public Criteria andDevKeyAlgTypeNotLike(String value) {
            addCriterion("DEV_KEY_ALG_TYPE not like", value, "devKeyAlgType");
            return (Criteria) this;
        }

        public Criteria andDevKeyAlgTypeIn(List<String> values) {
            addCriterion("DEV_KEY_ALG_TYPE in", values, "devKeyAlgType");
            return (Criteria) this;
        }

        public Criteria andDevKeyAlgTypeNotIn(List<String> values) {
            addCriterion("DEV_KEY_ALG_TYPE not in", values, "devKeyAlgType");
            return (Criteria) this;
        }

        public Criteria andDevKeyAlgTypeBetween(String value1, String value2) {
            addCriterion("DEV_KEY_ALG_TYPE between", value1, value2, "devKeyAlgType");
            return (Criteria) this;
        }

        public Criteria andDevKeyAlgTypeNotBetween(String value1, String value2) {
            addCriterion("DEV_KEY_ALG_TYPE not between", value1, value2, "devKeyAlgType");
            return (Criteria) this;
        }

        public Criteria andDevTmkStatusIsNull() {
            addCriterion("DEV_TMK_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andDevTmkStatusIsNotNull() {
            addCriterion("DEV_TMK_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andDevTmkStatusEqualTo(String value) {
            addCriterion("DEV_TMK_STATUS =", value, "devTmkStatus");
            return (Criteria) this;
        }

        public Criteria andDevTmkStatusNotEqualTo(String value) {
            addCriterion("DEV_TMK_STATUS <>", value, "devTmkStatus");
            return (Criteria) this;
        }

        public Criteria andDevTmkStatusGreaterThan(String value) {
            addCriterion("DEV_TMK_STATUS >", value, "devTmkStatus");
            return (Criteria) this;
        }

        public Criteria andDevTmkStatusGreaterThanOrEqualTo(String value) {
            addCriterion("DEV_TMK_STATUS >=", value, "devTmkStatus");
            return (Criteria) this;
        }

        public Criteria andDevTmkStatusLessThan(String value) {
            addCriterion("DEV_TMK_STATUS <", value, "devTmkStatus");
            return (Criteria) this;
        }

        public Criteria andDevTmkStatusLessThanOrEqualTo(String value) {
            addCriterion("DEV_TMK_STATUS <=", value, "devTmkStatus");
            return (Criteria) this;
        }

        public Criteria andDevTmkStatusLike(String value) {
            addCriterion("DEV_TMK_STATUS like", value, "devTmkStatus");
            return (Criteria) this;
        }

        public Criteria andDevTmkStatusNotLike(String value) {
            addCriterion("DEV_TMK_STATUS not like", value, "devTmkStatus");
            return (Criteria) this;
        }

        public Criteria andDevTmkStatusIn(List<String> values) {
            addCriterion("DEV_TMK_STATUS in", values, "devTmkStatus");
            return (Criteria) this;
        }

        public Criteria andDevTmkStatusNotIn(List<String> values) {
            addCriterion("DEV_TMK_STATUS not in", values, "devTmkStatus");
            return (Criteria) this;
        }

        public Criteria andDevTmkStatusBetween(String value1, String value2) {
            addCriterion("DEV_TMK_STATUS between", value1, value2, "devTmkStatus");
            return (Criteria) this;
        }

        public Criteria andDevTmkStatusNotBetween(String value1, String value2) {
            addCriterion("DEV_TMK_STATUS not between", value1, value2, "devTmkStatus");
            return (Criteria) this;
        }

        public Criteria andDevTmkUpdateDatetimeIsNull() {
            addCriterion("DEV_TMK_UPDATE_DATETIME is null");
            return (Criteria) this;
        }

        public Criteria andDevTmkUpdateDatetimeIsNotNull() {
            addCriterion("DEV_TMK_UPDATE_DATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andDevTmkUpdateDatetimeEqualTo(String value) {
            addCriterion("DEV_TMK_UPDATE_DATETIME =", value, "devTmkUpdateDatetime");
            return (Criteria) this;
        }

        public Criteria andDevTmkUpdateDatetimeNotEqualTo(String value) {
            addCriterion("DEV_TMK_UPDATE_DATETIME <>", value, "devTmkUpdateDatetime");
            return (Criteria) this;
        }

        public Criteria andDevTmkUpdateDatetimeGreaterThan(String value) {
            addCriterion("DEV_TMK_UPDATE_DATETIME >", value, "devTmkUpdateDatetime");
            return (Criteria) this;
        }

        public Criteria andDevTmkUpdateDatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("DEV_TMK_UPDATE_DATETIME >=", value, "devTmkUpdateDatetime");
            return (Criteria) this;
        }

        public Criteria andDevTmkUpdateDatetimeLessThan(String value) {
            addCriterion("DEV_TMK_UPDATE_DATETIME <", value, "devTmkUpdateDatetime");
            return (Criteria) this;
        }

        public Criteria andDevTmkUpdateDatetimeLessThanOrEqualTo(String value) {
            addCriterion("DEV_TMK_UPDATE_DATETIME <=", value, "devTmkUpdateDatetime");
            return (Criteria) this;
        }

        public Criteria andDevTmkUpdateDatetimeLike(String value) {
            addCriterion("DEV_TMK_UPDATE_DATETIME like", value, "devTmkUpdateDatetime");
            return (Criteria) this;
        }

        public Criteria andDevTmkUpdateDatetimeNotLike(String value) {
            addCriterion("DEV_TMK_UPDATE_DATETIME not like", value, "devTmkUpdateDatetime");
            return (Criteria) this;
        }

        public Criteria andDevTmkUpdateDatetimeIn(List<String> values) {
            addCriterion("DEV_TMK_UPDATE_DATETIME in", values, "devTmkUpdateDatetime");
            return (Criteria) this;
        }

        public Criteria andDevTmkUpdateDatetimeNotIn(List<String> values) {
            addCriterion("DEV_TMK_UPDATE_DATETIME not in", values, "devTmkUpdateDatetime");
            return (Criteria) this;
        }

        public Criteria andDevTmkUpdateDatetimeBetween(String value1, String value2) {
            addCriterion("DEV_TMK_UPDATE_DATETIME between", value1, value2, "devTmkUpdateDatetime");
            return (Criteria) this;
        }

        public Criteria andDevTmkUpdateDatetimeNotBetween(String value1, String value2) {
            addCriterion("DEV_TMK_UPDATE_DATETIME not between", value1, value2, "devTmkUpdateDatetime");
            return (Criteria) this;
        }

        public Criteria andKeyOpIdIsNull() {
            addCriterion("KEY_OP_ID is null");
            return (Criteria) this;
        }

        public Criteria andKeyOpIdIsNotNull() {
            addCriterion("KEY_OP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andKeyOpIdEqualTo(String value) {
            addCriterion("KEY_OP_ID =", value, "keyOpId");
            return (Criteria) this;
        }

        public Criteria andKeyOpIdNotEqualTo(String value) {
            addCriterion("KEY_OP_ID <>", value, "keyOpId");
            return (Criteria) this;
        }

        public Criteria andKeyOpIdGreaterThan(String value) {
            addCriterion("KEY_OP_ID >", value, "keyOpId");
            return (Criteria) this;
        }

        public Criteria andKeyOpIdGreaterThanOrEqualTo(String value) {
            addCriterion("KEY_OP_ID >=", value, "keyOpId");
            return (Criteria) this;
        }

        public Criteria andKeyOpIdLessThan(String value) {
            addCriterion("KEY_OP_ID <", value, "keyOpId");
            return (Criteria) this;
        }

        public Criteria andKeyOpIdLessThanOrEqualTo(String value) {
            addCriterion("KEY_OP_ID <=", value, "keyOpId");
            return (Criteria) this;
        }

        public Criteria andKeyOpIdLike(String value) {
            addCriterion("KEY_OP_ID like", value, "keyOpId");
            return (Criteria) this;
        }

        public Criteria andKeyOpIdNotLike(String value) {
            addCriterion("KEY_OP_ID not like", value, "keyOpId");
            return (Criteria) this;
        }

        public Criteria andKeyOpIdIn(List<String> values) {
            addCriterion("KEY_OP_ID in", values, "keyOpId");
            return (Criteria) this;
        }

        public Criteria andKeyOpIdNotIn(List<String> values) {
            addCriterion("KEY_OP_ID not in", values, "keyOpId");
            return (Criteria) this;
        }

        public Criteria andKeyOpIdBetween(String value1, String value2) {
            addCriterion("KEY_OP_ID between", value1, value2, "keyOpId");
            return (Criteria) this;
        }

        public Criteria andKeyOpIdNotBetween(String value1, String value2) {
            addCriterion("KEY_OP_ID not between", value1, value2, "keyOpId");
            return (Criteria) this;
        }

        public Criteria andDevTmkIsNull() {
            addCriterion("DEV_TMK is null");
            return (Criteria) this;
        }

        public Criteria andDevTmkIsNotNull() {
            addCriterion("DEV_TMK is not null");
            return (Criteria) this;
        }

        public Criteria andDevTmkEqualTo(String value) {
            addCriterion("DEV_TMK =", value, "devTmk");
            return (Criteria) this;
        }

        public Criteria andDevTmkNotEqualTo(String value) {
            addCriterion("DEV_TMK <>", value, "devTmk");
            return (Criteria) this;
        }

        public Criteria andDevTmkGreaterThan(String value) {
            addCriterion("DEV_TMK >", value, "devTmk");
            return (Criteria) this;
        }

        public Criteria andDevTmkGreaterThanOrEqualTo(String value) {
            addCriterion("DEV_TMK >=", value, "devTmk");
            return (Criteria) this;
        }

        public Criteria andDevTmkLessThan(String value) {
            addCriterion("DEV_TMK <", value, "devTmk");
            return (Criteria) this;
        }

        public Criteria andDevTmkLessThanOrEqualTo(String value) {
            addCriterion("DEV_TMK <=", value, "devTmk");
            return (Criteria) this;
        }

        public Criteria andDevTmkLike(String value) {
            addCriterion("DEV_TMK like", value, "devTmk");
            return (Criteria) this;
        }

        public Criteria andDevTmkNotLike(String value) {
            addCriterion("DEV_TMK not like", value, "devTmk");
            return (Criteria) this;
        }

        public Criteria andDevTmkIn(List<String> values) {
            addCriterion("DEV_TMK in", values, "devTmk");
            return (Criteria) this;
        }

        public Criteria andDevTmkNotIn(List<String> values) {
            addCriterion("DEV_TMK not in", values, "devTmk");
            return (Criteria) this;
        }

        public Criteria andDevTmkBetween(String value1, String value2) {
            addCriterion("DEV_TMK between", value1, value2, "devTmk");
            return (Criteria) this;
        }

        public Criteria andDevTmkNotBetween(String value1, String value2) {
            addCriterion("DEV_TMK not between", value1, value2, "devTmk");
            return (Criteria) this;
        }

        public Criteria andDevTmkCheckIsNull() {
            addCriterion("DEV_TMK_CHECK is null");
            return (Criteria) this;
        }

        public Criteria andDevTmkCheckIsNotNull() {
            addCriterion("DEV_TMK_CHECK is not null");
            return (Criteria) this;
        }

        public Criteria andDevTmkCheckEqualTo(String value) {
            addCriterion("DEV_TMK_CHECK =", value, "devTmkCheck");
            return (Criteria) this;
        }

        public Criteria andDevTmkCheckNotEqualTo(String value) {
            addCriterion("DEV_TMK_CHECK <>", value, "devTmkCheck");
            return (Criteria) this;
        }

        public Criteria andDevTmkCheckGreaterThan(String value) {
            addCriterion("DEV_TMK_CHECK >", value, "devTmkCheck");
            return (Criteria) this;
        }

        public Criteria andDevTmkCheckGreaterThanOrEqualTo(String value) {
            addCriterion("DEV_TMK_CHECK >=", value, "devTmkCheck");
            return (Criteria) this;
        }

        public Criteria andDevTmkCheckLessThan(String value) {
            addCriterion("DEV_TMK_CHECK <", value, "devTmkCheck");
            return (Criteria) this;
        }

        public Criteria andDevTmkCheckLessThanOrEqualTo(String value) {
            addCriterion("DEV_TMK_CHECK <=", value, "devTmkCheck");
            return (Criteria) this;
        }

        public Criteria andDevTmkCheckLike(String value) {
            addCriterion("DEV_TMK_CHECK like", value, "devTmkCheck");
            return (Criteria) this;
        }

        public Criteria andDevTmkCheckNotLike(String value) {
            addCriterion("DEV_TMK_CHECK not like", value, "devTmkCheck");
            return (Criteria) this;
        }

        public Criteria andDevTmkCheckIn(List<String> values) {
            addCriterion("DEV_TMK_CHECK in", values, "devTmkCheck");
            return (Criteria) this;
        }

        public Criteria andDevTmkCheckNotIn(List<String> values) {
            addCriterion("DEV_TMK_CHECK not in", values, "devTmkCheck");
            return (Criteria) this;
        }

        public Criteria andDevTmkCheckBetween(String value1, String value2) {
            addCriterion("DEV_TMK_CHECK between", value1, value2, "devTmkCheck");
            return (Criteria) this;
        }

        public Criteria andDevTmkCheckNotBetween(String value1, String value2) {
            addCriterion("DEV_TMK_CHECK not between", value1, value2, "devTmkCheck");
            return (Criteria) this;
        }

        public Criteria andDevSingInDatetimeIsNull() {
            addCriterion("DEV_SING_IN_DATETIME is null");
            return (Criteria) this;
        }

        public Criteria andDevSingInDatetimeIsNotNull() {
            addCriterion("DEV_SING_IN_DATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andDevSingInDatetimeEqualTo(String value) {
            addCriterion("DEV_SING_IN_DATETIME =", value, "devSingInDatetime");
            return (Criteria) this;
        }

        public Criteria andDevSingInDatetimeNotEqualTo(String value) {
            addCriterion("DEV_SING_IN_DATETIME <>", value, "devSingInDatetime");
            return (Criteria) this;
        }

        public Criteria andDevSingInDatetimeGreaterThan(String value) {
            addCriterion("DEV_SING_IN_DATETIME >", value, "devSingInDatetime");
            return (Criteria) this;
        }

        public Criteria andDevSingInDatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("DEV_SING_IN_DATETIME >=", value, "devSingInDatetime");
            return (Criteria) this;
        }

        public Criteria andDevSingInDatetimeLessThan(String value) {
            addCriterion("DEV_SING_IN_DATETIME <", value, "devSingInDatetime");
            return (Criteria) this;
        }

        public Criteria andDevSingInDatetimeLessThanOrEqualTo(String value) {
            addCriterion("DEV_SING_IN_DATETIME <=", value, "devSingInDatetime");
            return (Criteria) this;
        }

        public Criteria andDevSingInDatetimeLike(String value) {
            addCriterion("DEV_SING_IN_DATETIME like", value, "devSingInDatetime");
            return (Criteria) this;
        }

        public Criteria andDevSingInDatetimeNotLike(String value) {
            addCriterion("DEV_SING_IN_DATETIME not like", value, "devSingInDatetime");
            return (Criteria) this;
        }

        public Criteria andDevSingInDatetimeIn(List<String> values) {
            addCriterion("DEV_SING_IN_DATETIME in", values, "devSingInDatetime");
            return (Criteria) this;
        }

        public Criteria andDevSingInDatetimeNotIn(List<String> values) {
            addCriterion("DEV_SING_IN_DATETIME not in", values, "devSingInDatetime");
            return (Criteria) this;
        }

        public Criteria andDevSingInDatetimeBetween(String value1, String value2) {
            addCriterion("DEV_SING_IN_DATETIME between", value1, value2, "devSingInDatetime");
            return (Criteria) this;
        }

        public Criteria andDevSingInDatetimeNotBetween(String value1, String value2) {
            addCriterion("DEV_SING_IN_DATETIME not between", value1, value2, "devSingInDatetime");
            return (Criteria) this;
        }

        public Criteria andDevSignOutDatetimeIsNull() {
            addCriterion("DEV_SIGN_OUT_DATETIME is null");
            return (Criteria) this;
        }

        public Criteria andDevSignOutDatetimeIsNotNull() {
            addCriterion("DEV_SIGN_OUT_DATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andDevSignOutDatetimeEqualTo(String value) {
            addCriterion("DEV_SIGN_OUT_DATETIME =", value, "devSignOutDatetime");
            return (Criteria) this;
        }

        public Criteria andDevSignOutDatetimeNotEqualTo(String value) {
            addCriterion("DEV_SIGN_OUT_DATETIME <>", value, "devSignOutDatetime");
            return (Criteria) this;
        }

        public Criteria andDevSignOutDatetimeGreaterThan(String value) {
            addCriterion("DEV_SIGN_OUT_DATETIME >", value, "devSignOutDatetime");
            return (Criteria) this;
        }

        public Criteria andDevSignOutDatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("DEV_SIGN_OUT_DATETIME >=", value, "devSignOutDatetime");
            return (Criteria) this;
        }

        public Criteria andDevSignOutDatetimeLessThan(String value) {
            addCriterion("DEV_SIGN_OUT_DATETIME <", value, "devSignOutDatetime");
            return (Criteria) this;
        }

        public Criteria andDevSignOutDatetimeLessThanOrEqualTo(String value) {
            addCriterion("DEV_SIGN_OUT_DATETIME <=", value, "devSignOutDatetime");
            return (Criteria) this;
        }

        public Criteria andDevSignOutDatetimeLike(String value) {
            addCriterion("DEV_SIGN_OUT_DATETIME like", value, "devSignOutDatetime");
            return (Criteria) this;
        }

        public Criteria andDevSignOutDatetimeNotLike(String value) {
            addCriterion("DEV_SIGN_OUT_DATETIME not like", value, "devSignOutDatetime");
            return (Criteria) this;
        }

        public Criteria andDevSignOutDatetimeIn(List<String> values) {
            addCriterion("DEV_SIGN_OUT_DATETIME in", values, "devSignOutDatetime");
            return (Criteria) this;
        }

        public Criteria andDevSignOutDatetimeNotIn(List<String> values) {
            addCriterion("DEV_SIGN_OUT_DATETIME not in", values, "devSignOutDatetime");
            return (Criteria) this;
        }

        public Criteria andDevSignOutDatetimeBetween(String value1, String value2) {
            addCriterion("DEV_SIGN_OUT_DATETIME between", value1, value2, "devSignOutDatetime");
            return (Criteria) this;
        }

        public Criteria andDevSignOutDatetimeNotBetween(String value1, String value2) {
            addCriterion("DEV_SIGN_OUT_DATETIME not between", value1, value2, "devSignOutDatetime");
            return (Criteria) this;
        }

        public Criteria andDevPikIsNull() {
            addCriterion("DEV_PIK is null");
            return (Criteria) this;
        }

        public Criteria andDevPikIsNotNull() {
            addCriterion("DEV_PIK is not null");
            return (Criteria) this;
        }

        public Criteria andDevPikEqualTo(String value) {
            addCriterion("DEV_PIK =", value, "devPik");
            return (Criteria) this;
        }

        public Criteria andDevPikNotEqualTo(String value) {
            addCriterion("DEV_PIK <>", value, "devPik");
            return (Criteria) this;
        }

        public Criteria andDevPikGreaterThan(String value) {
            addCriterion("DEV_PIK >", value, "devPik");
            return (Criteria) this;
        }

        public Criteria andDevPikGreaterThanOrEqualTo(String value) {
            addCriterion("DEV_PIK >=", value, "devPik");
            return (Criteria) this;
        }

        public Criteria andDevPikLessThan(String value) {
            addCriterion("DEV_PIK <", value, "devPik");
            return (Criteria) this;
        }

        public Criteria andDevPikLessThanOrEqualTo(String value) {
            addCriterion("DEV_PIK <=", value, "devPik");
            return (Criteria) this;
        }

        public Criteria andDevPikLike(String value) {
            addCriterion("DEV_PIK like", value, "devPik");
            return (Criteria) this;
        }

        public Criteria andDevPikNotLike(String value) {
            addCriterion("DEV_PIK not like", value, "devPik");
            return (Criteria) this;
        }

        public Criteria andDevPikIn(List<String> values) {
            addCriterion("DEV_PIK in", values, "devPik");
            return (Criteria) this;
        }

        public Criteria andDevPikNotIn(List<String> values) {
            addCriterion("DEV_PIK not in", values, "devPik");
            return (Criteria) this;
        }

        public Criteria andDevPikBetween(String value1, String value2) {
            addCriterion("DEV_PIK between", value1, value2, "devPik");
            return (Criteria) this;
        }

        public Criteria andDevPikNotBetween(String value1, String value2) {
            addCriterion("DEV_PIK not between", value1, value2, "devPik");
            return (Criteria) this;
        }

        public Criteria andDevPikCheckIsNull() {
            addCriterion("DEV_PIK_CHECK is null");
            return (Criteria) this;
        }

        public Criteria andDevPikCheckIsNotNull() {
            addCriterion("DEV_PIK_CHECK is not null");
            return (Criteria) this;
        }

        public Criteria andDevPikCheckEqualTo(String value) {
            addCriterion("DEV_PIK_CHECK =", value, "devPikCheck");
            return (Criteria) this;
        }

        public Criteria andDevPikCheckNotEqualTo(String value) {
            addCriterion("DEV_PIK_CHECK <>", value, "devPikCheck");
            return (Criteria) this;
        }

        public Criteria andDevPikCheckGreaterThan(String value) {
            addCriterion("DEV_PIK_CHECK >", value, "devPikCheck");
            return (Criteria) this;
        }

        public Criteria andDevPikCheckGreaterThanOrEqualTo(String value) {
            addCriterion("DEV_PIK_CHECK >=", value, "devPikCheck");
            return (Criteria) this;
        }

        public Criteria andDevPikCheckLessThan(String value) {
            addCriterion("DEV_PIK_CHECK <", value, "devPikCheck");
            return (Criteria) this;
        }

        public Criteria andDevPikCheckLessThanOrEqualTo(String value) {
            addCriterion("DEV_PIK_CHECK <=", value, "devPikCheck");
            return (Criteria) this;
        }

        public Criteria andDevPikCheckLike(String value) {
            addCriterion("DEV_PIK_CHECK like", value, "devPikCheck");
            return (Criteria) this;
        }

        public Criteria andDevPikCheckNotLike(String value) {
            addCriterion("DEV_PIK_CHECK not like", value, "devPikCheck");
            return (Criteria) this;
        }

        public Criteria andDevPikCheckIn(List<String> values) {
            addCriterion("DEV_PIK_CHECK in", values, "devPikCheck");
            return (Criteria) this;
        }

        public Criteria andDevPikCheckNotIn(List<String> values) {
            addCriterion("DEV_PIK_CHECK not in", values, "devPikCheck");
            return (Criteria) this;
        }

        public Criteria andDevPikCheckBetween(String value1, String value2) {
            addCriterion("DEV_PIK_CHECK between", value1, value2, "devPikCheck");
            return (Criteria) this;
        }

        public Criteria andDevPikCheckNotBetween(String value1, String value2) {
            addCriterion("DEV_PIK_CHECK not between", value1, value2, "devPikCheck");
            return (Criteria) this;
        }

        public Criteria andDevMakIsNull() {
            addCriterion("DEV_MAK is null");
            return (Criteria) this;
        }

        public Criteria andDevMakIsNotNull() {
            addCriterion("DEV_MAK is not null");
            return (Criteria) this;
        }

        public Criteria andDevMakEqualTo(String value) {
            addCriterion("DEV_MAK =", value, "devMak");
            return (Criteria) this;
        }

        public Criteria andDevMakNotEqualTo(String value) {
            addCriterion("DEV_MAK <>", value, "devMak");
            return (Criteria) this;
        }

        public Criteria andDevMakGreaterThan(String value) {
            addCriterion("DEV_MAK >", value, "devMak");
            return (Criteria) this;
        }

        public Criteria andDevMakGreaterThanOrEqualTo(String value) {
            addCriterion("DEV_MAK >=", value, "devMak");
            return (Criteria) this;
        }

        public Criteria andDevMakLessThan(String value) {
            addCriterion("DEV_MAK <", value, "devMak");
            return (Criteria) this;
        }

        public Criteria andDevMakLessThanOrEqualTo(String value) {
            addCriterion("DEV_MAK <=", value, "devMak");
            return (Criteria) this;
        }

        public Criteria andDevMakLike(String value) {
            addCriterion("DEV_MAK like", value, "devMak");
            return (Criteria) this;
        }

        public Criteria andDevMakNotLike(String value) {
            addCriterion("DEV_MAK not like", value, "devMak");
            return (Criteria) this;
        }

        public Criteria andDevMakIn(List<String> values) {
            addCriterion("DEV_MAK in", values, "devMak");
            return (Criteria) this;
        }

        public Criteria andDevMakNotIn(List<String> values) {
            addCriterion("DEV_MAK not in", values, "devMak");
            return (Criteria) this;
        }

        public Criteria andDevMakBetween(String value1, String value2) {
            addCriterion("DEV_MAK between", value1, value2, "devMak");
            return (Criteria) this;
        }

        public Criteria andDevMakNotBetween(String value1, String value2) {
            addCriterion("DEV_MAK not between", value1, value2, "devMak");
            return (Criteria) this;
        }

        public Criteria andDevMakCheckIsNull() {
            addCriterion("DEV_MAK_CHECK is null");
            return (Criteria) this;
        }

        public Criteria andDevMakCheckIsNotNull() {
            addCriterion("DEV_MAK_CHECK is not null");
            return (Criteria) this;
        }

        public Criteria andDevMakCheckEqualTo(String value) {
            addCriterion("DEV_MAK_CHECK =", value, "devMakCheck");
            return (Criteria) this;
        }

        public Criteria andDevMakCheckNotEqualTo(String value) {
            addCriterion("DEV_MAK_CHECK <>", value, "devMakCheck");
            return (Criteria) this;
        }

        public Criteria andDevMakCheckGreaterThan(String value) {
            addCriterion("DEV_MAK_CHECK >", value, "devMakCheck");
            return (Criteria) this;
        }

        public Criteria andDevMakCheckGreaterThanOrEqualTo(String value) {
            addCriterion("DEV_MAK_CHECK >=", value, "devMakCheck");
            return (Criteria) this;
        }

        public Criteria andDevMakCheckLessThan(String value) {
            addCriterion("DEV_MAK_CHECK <", value, "devMakCheck");
            return (Criteria) this;
        }

        public Criteria andDevMakCheckLessThanOrEqualTo(String value) {
            addCriterion("DEV_MAK_CHECK <=", value, "devMakCheck");
            return (Criteria) this;
        }

        public Criteria andDevMakCheckLike(String value) {
            addCriterion("DEV_MAK_CHECK like", value, "devMakCheck");
            return (Criteria) this;
        }

        public Criteria andDevMakCheckNotLike(String value) {
            addCriterion("DEV_MAK_CHECK not like", value, "devMakCheck");
            return (Criteria) this;
        }

        public Criteria andDevMakCheckIn(List<String> values) {
            addCriterion("DEV_MAK_CHECK in", values, "devMakCheck");
            return (Criteria) this;
        }

        public Criteria andDevMakCheckNotIn(List<String> values) {
            addCriterion("DEV_MAK_CHECK not in", values, "devMakCheck");
            return (Criteria) this;
        }

        public Criteria andDevMakCheckBetween(String value1, String value2) {
            addCriterion("DEV_MAK_CHECK between", value1, value2, "devMakCheck");
            return (Criteria) this;
        }

        public Criteria andDevMakCheckNotBetween(String value1, String value2) {
            addCriterion("DEV_MAK_CHECK not between", value1, value2, "devMakCheck");
            return (Criteria) this;
        }

        public Criteria andDevTkIsNull() {
            addCriterion("DEV_TK is null");
            return (Criteria) this;
        }

        public Criteria andDevTkIsNotNull() {
            addCriterion("DEV_TK is not null");
            return (Criteria) this;
        }

        public Criteria andDevTkEqualTo(String value) {
            addCriterion("DEV_TK =", value, "devTk");
            return (Criteria) this;
        }

        public Criteria andDevTkNotEqualTo(String value) {
            addCriterion("DEV_TK <>", value, "devTk");
            return (Criteria) this;
        }

        public Criteria andDevTkGreaterThan(String value) {
            addCriterion("DEV_TK >", value, "devTk");
            return (Criteria) this;
        }

        public Criteria andDevTkGreaterThanOrEqualTo(String value) {
            addCriterion("DEV_TK >=", value, "devTk");
            return (Criteria) this;
        }

        public Criteria andDevTkLessThan(String value) {
            addCriterion("DEV_TK <", value, "devTk");
            return (Criteria) this;
        }

        public Criteria andDevTkLessThanOrEqualTo(String value) {
            addCriterion("DEV_TK <=", value, "devTk");
            return (Criteria) this;
        }

        public Criteria andDevTkLike(String value) {
            addCriterion("DEV_TK like", value, "devTk");
            return (Criteria) this;
        }

        public Criteria andDevTkNotLike(String value) {
            addCriterion("DEV_TK not like", value, "devTk");
            return (Criteria) this;
        }

        public Criteria andDevTkIn(List<String> values) {
            addCriterion("DEV_TK in", values, "devTk");
            return (Criteria) this;
        }

        public Criteria andDevTkNotIn(List<String> values) {
            addCriterion("DEV_TK not in", values, "devTk");
            return (Criteria) this;
        }

        public Criteria andDevTkBetween(String value1, String value2) {
            addCriterion("DEV_TK between", value1, value2, "devTk");
            return (Criteria) this;
        }

        public Criteria andDevTkNotBetween(String value1, String value2) {
            addCriterion("DEV_TK not between", value1, value2, "devTk");
            return (Criteria) this;
        }

        public Criteria andDevTkCheckIsNull() {
            addCriterion("DEV_TK_CHECK is null");
            return (Criteria) this;
        }

        public Criteria andDevTkCheckIsNotNull() {
            addCriterion("DEV_TK_CHECK is not null");
            return (Criteria) this;
        }

        public Criteria andDevTkCheckEqualTo(String value) {
            addCriterion("DEV_TK_CHECK =", value, "devTkCheck");
            return (Criteria) this;
        }

        public Criteria andDevTkCheckNotEqualTo(String value) {
            addCriterion("DEV_TK_CHECK <>", value, "devTkCheck");
            return (Criteria) this;
        }

        public Criteria andDevTkCheckGreaterThan(String value) {
            addCriterion("DEV_TK_CHECK >", value, "devTkCheck");
            return (Criteria) this;
        }

        public Criteria andDevTkCheckGreaterThanOrEqualTo(String value) {
            addCriterion("DEV_TK_CHECK >=", value, "devTkCheck");
            return (Criteria) this;
        }

        public Criteria andDevTkCheckLessThan(String value) {
            addCriterion("DEV_TK_CHECK <", value, "devTkCheck");
            return (Criteria) this;
        }

        public Criteria andDevTkCheckLessThanOrEqualTo(String value) {
            addCriterion("DEV_TK_CHECK <=", value, "devTkCheck");
            return (Criteria) this;
        }

        public Criteria andDevTkCheckLike(String value) {
            addCriterion("DEV_TK_CHECK like", value, "devTkCheck");
            return (Criteria) this;
        }

        public Criteria andDevTkCheckNotLike(String value) {
            addCriterion("DEV_TK_CHECK not like", value, "devTkCheck");
            return (Criteria) this;
        }

        public Criteria andDevTkCheckIn(List<String> values) {
            addCriterion("DEV_TK_CHECK in", values, "devTkCheck");
            return (Criteria) this;
        }

        public Criteria andDevTkCheckNotIn(List<String> values) {
            addCriterion("DEV_TK_CHECK not in", values, "devTkCheck");
            return (Criteria) this;
        }

        public Criteria andDevTkCheckBetween(String value1, String value2) {
            addCriterion("DEV_TK_CHECK between", value1, value2, "devTkCheck");
            return (Criteria) this;
        }

        public Criteria andDevTkCheckNotBetween(String value1, String value2) {
            addCriterion("DEV_TK_CHECK not between", value1, value2, "devTkCheck");
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

        public Criteria andVersionIsNull() {
            addCriterion("VERSION is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("VERSION is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(String value) {
            addCriterion("VERSION =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(String value) {
            addCriterion("VERSION <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(String value) {
            addCriterion("VERSION >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(String value) {
            addCriterion("VERSION >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(String value) {
            addCriterion("VERSION <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(String value) {
            addCriterion("VERSION <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLike(String value) {
            addCriterion("VERSION like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotLike(String value) {
            addCriterion("VERSION not like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<String> values) {
            addCriterion("VERSION in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<String> values) {
            addCriterion("VERSION not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(String value1, String value2) {
            addCriterion("VERSION between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(String value1, String value2) {
            addCriterion("VERSION not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andDevOnaddIsNull() {
            addCriterion("DEV_ONADD is null");
            return (Criteria) this;
        }

        public Criteria andDevOnaddIsNotNull() {
            addCriterion("DEV_ONADD is not null");
            return (Criteria) this;
        }

        public Criteria andDevOnaddEqualTo(String value) {
            addCriterion("DEV_ONADD =", value, "devOnadd");
            return (Criteria) this;
        }

        public Criteria andDevOnaddNotEqualTo(String value) {
            addCriterion("DEV_ONADD <>", value, "devOnadd");
            return (Criteria) this;
        }

        public Criteria andDevOnaddGreaterThan(String value) {
            addCriterion("DEV_ONADD >", value, "devOnadd");
            return (Criteria) this;
        }

        public Criteria andDevOnaddGreaterThanOrEqualTo(String value) {
            addCriterion("DEV_ONADD >=", value, "devOnadd");
            return (Criteria) this;
        }

        public Criteria andDevOnaddLessThan(String value) {
            addCriterion("DEV_ONADD <", value, "devOnadd");
            return (Criteria) this;
        }

        public Criteria andDevOnaddLessThanOrEqualTo(String value) {
            addCriterion("DEV_ONADD <=", value, "devOnadd");
            return (Criteria) this;
        }

        public Criteria andDevOnaddLike(String value) {
            addCriterion("DEV_ONADD like", value, "devOnadd");
            return (Criteria) this;
        }

        public Criteria andDevOnaddNotLike(String value) {
            addCriterion("DEV_ONADD not like", value, "devOnadd");
            return (Criteria) this;
        }

        public Criteria andDevOnaddIn(List<String> values) {
            addCriterion("DEV_ONADD in", values, "devOnadd");
            return (Criteria) this;
        }

        public Criteria andDevOnaddNotIn(List<String> values) {
            addCriterion("DEV_ONADD not in", values, "devOnadd");
            return (Criteria) this;
        }

        public Criteria andDevOnaddBetween(String value1, String value2) {
            addCriterion("DEV_ONADD between", value1, value2, "devOnadd");
            return (Criteria) this;
        }

        public Criteria andDevOnaddNotBetween(String value1, String value2) {
            addCriterion("DEV_ONADD not between", value1, value2, "devOnadd");
            return (Criteria) this;
        }

        public Criteria andBusiTypeIsNull() {
            addCriterion("BUSI_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andBusiTypeIsNotNull() {
            addCriterion("BUSI_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andBusiTypeEqualTo(String value) {
            addCriterion("BUSI_TYPE =", value, "busiType");
            return (Criteria) this;
        }

        public Criteria andBusiTypeNotEqualTo(String value) {
            addCriterion("BUSI_TYPE <>", value, "busiType");
            return (Criteria) this;
        }

        public Criteria andBusiTypeGreaterThan(String value) {
            addCriterion("BUSI_TYPE >", value, "busiType");
            return (Criteria) this;
        }

        public Criteria andBusiTypeGreaterThanOrEqualTo(String value) {
            addCriterion("BUSI_TYPE >=", value, "busiType");
            return (Criteria) this;
        }

        public Criteria andBusiTypeLessThan(String value) {
            addCriterion("BUSI_TYPE <", value, "busiType");
            return (Criteria) this;
        }

        public Criteria andBusiTypeLessThanOrEqualTo(String value) {
            addCriterion("BUSI_TYPE <=", value, "busiType");
            return (Criteria) this;
        }

        public Criteria andBusiTypeLike(String value) {
            addCriterion("BUSI_TYPE like", value, "busiType");
            return (Criteria) this;
        }

        public Criteria andBusiTypeNotLike(String value) {
            addCriterion("BUSI_TYPE not like", value, "busiType");
            return (Criteria) this;
        }

        public Criteria andBusiTypeIn(List<String> values) {
            addCriterion("BUSI_TYPE in", values, "busiType");
            return (Criteria) this;
        }

        public Criteria andBusiTypeNotIn(List<String> values) {
            addCriterion("BUSI_TYPE not in", values, "busiType");
            return (Criteria) this;
        }

        public Criteria andBusiTypeBetween(String value1, String value2) {
            addCriterion("BUSI_TYPE between", value1, value2, "busiType");
            return (Criteria) this;
        }

        public Criteria andBusiTypeNotBetween(String value1, String value2) {
            addCriterion("BUSI_TYPE not between", value1, value2, "busiType");
            return (Criteria) this;
        }

        public Criteria andScanCodeIsNull() {
            addCriterion("SCAN_CODE is null");
            return (Criteria) this;
        }

        public Criteria andScanCodeIsNotNull() {
            addCriterion("SCAN_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andScanCodeEqualTo(String value) {
            addCriterion("SCAN_CODE =", value, "scanCode");
            return (Criteria) this;
        }

        public Criteria andScanCodeNotEqualTo(String value) {
            addCriterion("SCAN_CODE <>", value, "scanCode");
            return (Criteria) this;
        }

        public Criteria andScanCodeGreaterThan(String value) {
            addCriterion("SCAN_CODE >", value, "scanCode");
            return (Criteria) this;
        }

        public Criteria andScanCodeGreaterThanOrEqualTo(String value) {
            addCriterion("SCAN_CODE >=", value, "scanCode");
            return (Criteria) this;
        }

        public Criteria andScanCodeLessThan(String value) {
            addCriterion("SCAN_CODE <", value, "scanCode");
            return (Criteria) this;
        }

        public Criteria andScanCodeLessThanOrEqualTo(String value) {
            addCriterion("SCAN_CODE <=", value, "scanCode");
            return (Criteria) this;
        }

        public Criteria andScanCodeLike(String value) {
            addCriterion("SCAN_CODE like", value, "scanCode");
            return (Criteria) this;
        }

        public Criteria andScanCodeNotLike(String value) {
            addCriterion("SCAN_CODE not like", value, "scanCode");
            return (Criteria) this;
        }

        public Criteria andScanCodeIn(List<String> values) {
            addCriterion("SCAN_CODE in", values, "scanCode");
            return (Criteria) this;
        }

        public Criteria andScanCodeNotIn(List<String> values) {
            addCriterion("SCAN_CODE not in", values, "scanCode");
            return (Criteria) this;
        }

        public Criteria andScanCodeBetween(String value1, String value2) {
            addCriterion("SCAN_CODE between", value1, value2, "scanCode");
            return (Criteria) this;
        }

        public Criteria andScanCodeNotBetween(String value1, String value2) {
            addCriterion("SCAN_CODE not between", value1, value2, "scanCode");
            return (Criteria) this;
        }

        public Criteria andMscCodeIsNull() {
            addCriterion("MSC_CODE is null");
            return (Criteria) this;
        }

        public Criteria andMscCodeIsNotNull() {
            addCriterion("MSC_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andMscCodeEqualTo(String value) {
            addCriterion("MSC_CODE =", value, "mscCode");
            return (Criteria) this;
        }

        public Criteria andMscCodeNotEqualTo(String value) {
            addCriterion("MSC_CODE <>", value, "mscCode");
            return (Criteria) this;
        }

        public Criteria andMscCodeGreaterThan(String value) {
            addCriterion("MSC_CODE >", value, "mscCode");
            return (Criteria) this;
        }

        public Criteria andMscCodeGreaterThanOrEqualTo(String value) {
            addCriterion("MSC_CODE >=", value, "mscCode");
            return (Criteria) this;
        }

        public Criteria andMscCodeLessThan(String value) {
            addCriterion("MSC_CODE <", value, "mscCode");
            return (Criteria) this;
        }

        public Criteria andMscCodeLessThanOrEqualTo(String value) {
            addCriterion("MSC_CODE <=", value, "mscCode");
            return (Criteria) this;
        }

        public Criteria andMscCodeLike(String value) {
            addCriterion("MSC_CODE like", value, "mscCode");
            return (Criteria) this;
        }

        public Criteria andMscCodeNotLike(String value) {
            addCriterion("MSC_CODE not like", value, "mscCode");
            return (Criteria) this;
        }

        public Criteria andMscCodeIn(List<String> values) {
            addCriterion("MSC_CODE in", values, "mscCode");
            return (Criteria) this;
        }

        public Criteria andMscCodeNotIn(List<String> values) {
            addCriterion("MSC_CODE not in", values, "mscCode");
            return (Criteria) this;
        }

        public Criteria andMscCodeBetween(String value1, String value2) {
            addCriterion("MSC_CODE between", value1, value2, "mscCode");
            return (Criteria) this;
        }

        public Criteria andMscCodeNotBetween(String value1, String value2) {
            addCriterion("MSC_CODE not between", value1, value2, "mscCode");
            return (Criteria) this;
        }

        public Criteria andTouchIcReadIsNull() {
            addCriterion("TOUCH_IC_READ is null");
            return (Criteria) this;
        }

        public Criteria andTouchIcReadIsNotNull() {
            addCriterion("TOUCH_IC_READ is not null");
            return (Criteria) this;
        }

        public Criteria andTouchIcReadEqualTo(String value) {
            addCriterion("TOUCH_IC_READ =", value, "touchIcRead");
            return (Criteria) this;
        }

        public Criteria andTouchIcReadNotEqualTo(String value) {
            addCriterion("TOUCH_IC_READ <>", value, "touchIcRead");
            return (Criteria) this;
        }

        public Criteria andTouchIcReadGreaterThan(String value) {
            addCriterion("TOUCH_IC_READ >", value, "touchIcRead");
            return (Criteria) this;
        }

        public Criteria andTouchIcReadGreaterThanOrEqualTo(String value) {
            addCriterion("TOUCH_IC_READ >=", value, "touchIcRead");
            return (Criteria) this;
        }

        public Criteria andTouchIcReadLessThan(String value) {
            addCriterion("TOUCH_IC_READ <", value, "touchIcRead");
            return (Criteria) this;
        }

        public Criteria andTouchIcReadLessThanOrEqualTo(String value) {
            addCriterion("TOUCH_IC_READ <=", value, "touchIcRead");
            return (Criteria) this;
        }

        public Criteria andTouchIcReadLike(String value) {
            addCriterion("TOUCH_IC_READ like", value, "touchIcRead");
            return (Criteria) this;
        }

        public Criteria andTouchIcReadNotLike(String value) {
            addCriterion("TOUCH_IC_READ not like", value, "touchIcRead");
            return (Criteria) this;
        }

        public Criteria andTouchIcReadIn(List<String> values) {
            addCriterion("TOUCH_IC_READ in", values, "touchIcRead");
            return (Criteria) this;
        }

        public Criteria andTouchIcReadNotIn(List<String> values) {
            addCriterion("TOUCH_IC_READ not in", values, "touchIcRead");
            return (Criteria) this;
        }

        public Criteria andTouchIcReadBetween(String value1, String value2) {
            addCriterion("TOUCH_IC_READ between", value1, value2, "touchIcRead");
            return (Criteria) this;
        }

        public Criteria andTouchIcReadNotBetween(String value1, String value2) {
            addCriterion("TOUCH_IC_READ not between", value1, value2, "touchIcRead");
            return (Criteria) this;
        }

        public Criteria andNonTouchIcReadIsNull() {
            addCriterion("NON_TOUCH_IC_READ is null");
            return (Criteria) this;
        }

        public Criteria andNonTouchIcReadIsNotNull() {
            addCriterion("NON_TOUCH_IC_READ is not null");
            return (Criteria) this;
        }

        public Criteria andNonTouchIcReadEqualTo(String value) {
            addCriterion("NON_TOUCH_IC_READ =", value, "nonTouchIcRead");
            return (Criteria) this;
        }

        public Criteria andNonTouchIcReadNotEqualTo(String value) {
            addCriterion("NON_TOUCH_IC_READ <>", value, "nonTouchIcRead");
            return (Criteria) this;
        }

        public Criteria andNonTouchIcReadGreaterThan(String value) {
            addCriterion("NON_TOUCH_IC_READ >", value, "nonTouchIcRead");
            return (Criteria) this;
        }

        public Criteria andNonTouchIcReadGreaterThanOrEqualTo(String value) {
            addCriterion("NON_TOUCH_IC_READ >=", value, "nonTouchIcRead");
            return (Criteria) this;
        }

        public Criteria andNonTouchIcReadLessThan(String value) {
            addCriterion("NON_TOUCH_IC_READ <", value, "nonTouchIcRead");
            return (Criteria) this;
        }

        public Criteria andNonTouchIcReadLessThanOrEqualTo(String value) {
            addCriterion("NON_TOUCH_IC_READ <=", value, "nonTouchIcRead");
            return (Criteria) this;
        }

        public Criteria andNonTouchIcReadLike(String value) {
            addCriterion("NON_TOUCH_IC_READ like", value, "nonTouchIcRead");
            return (Criteria) this;
        }

        public Criteria andNonTouchIcReadNotLike(String value) {
            addCriterion("NON_TOUCH_IC_READ not like", value, "nonTouchIcRead");
            return (Criteria) this;
        }

        public Criteria andNonTouchIcReadIn(List<String> values) {
            addCriterion("NON_TOUCH_IC_READ in", values, "nonTouchIcRead");
            return (Criteria) this;
        }

        public Criteria andNonTouchIcReadNotIn(List<String> values) {
            addCriterion("NON_TOUCH_IC_READ not in", values, "nonTouchIcRead");
            return (Criteria) this;
        }

        public Criteria andNonTouchIcReadBetween(String value1, String value2) {
            addCriterion("NON_TOUCH_IC_READ between", value1, value2, "nonTouchIcRead");
            return (Criteria) this;
        }

        public Criteria andNonTouchIcReadNotBetween(String value1, String value2) {
            addCriterion("NON_TOUCH_IC_READ not between", value1, value2, "nonTouchIcRead");
            return (Criteria) this;
        }

        public Criteria andNoCardPadyIsNull() {
            addCriterion("NO_CARD_PADY is null");
            return (Criteria) this;
        }

        public Criteria andNoCardPadyIsNotNull() {
            addCriterion("NO_CARD_PADY is not null");
            return (Criteria) this;
        }

        public Criteria andNoCardPadyEqualTo(String value) {
            addCriterion("NO_CARD_PADY =", value, "noCardPady");
            return (Criteria) this;
        }

        public Criteria andNoCardPadyNotEqualTo(String value) {
            addCriterion("NO_CARD_PADY <>", value, "noCardPady");
            return (Criteria) this;
        }

        public Criteria andNoCardPadyGreaterThan(String value) {
            addCriterion("NO_CARD_PADY >", value, "noCardPady");
            return (Criteria) this;
        }

        public Criteria andNoCardPadyGreaterThanOrEqualTo(String value) {
            addCriterion("NO_CARD_PADY >=", value, "noCardPady");
            return (Criteria) this;
        }

        public Criteria andNoCardPadyLessThan(String value) {
            addCriterion("NO_CARD_PADY <", value, "noCardPady");
            return (Criteria) this;
        }

        public Criteria andNoCardPadyLessThanOrEqualTo(String value) {
            addCriterion("NO_CARD_PADY <=", value, "noCardPady");
            return (Criteria) this;
        }

        public Criteria andNoCardPadyLike(String value) {
            addCriterion("NO_CARD_PADY like", value, "noCardPady");
            return (Criteria) this;
        }

        public Criteria andNoCardPadyNotLike(String value) {
            addCriterion("NO_CARD_PADY not like", value, "noCardPady");
            return (Criteria) this;
        }

        public Criteria andNoCardPadyIn(List<String> values) {
            addCriterion("NO_CARD_PADY in", values, "noCardPady");
            return (Criteria) this;
        }

        public Criteria andNoCardPadyNotIn(List<String> values) {
            addCriterion("NO_CARD_PADY not in", values, "noCardPady");
            return (Criteria) this;
        }

        public Criteria andNoCardPadyBetween(String value1, String value2) {
            addCriterion("NO_CARD_PADY between", value1, value2, "noCardPady");
            return (Criteria) this;
        }

        public Criteria andNoCardPadyNotBetween(String value1, String value2) {
            addCriterion("NO_CARD_PADY not between", value1, value2, "noCardPady");
            return (Criteria) this;
        }

        public Criteria andLyNameIsNull() {
            addCriterion("LY_NAME is null");
            return (Criteria) this;
        }

        public Criteria andLyNameIsNotNull() {
            addCriterion("LY_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andLyNameEqualTo(String value) {
            addCriterion("LY_NAME =", value, "lyName");
            return (Criteria) this;
        }

        public Criteria andLyNameNotEqualTo(String value) {
            addCriterion("LY_NAME <>", value, "lyName");
            return (Criteria) this;
        }

        public Criteria andLyNameGreaterThan(String value) {
            addCriterion("LY_NAME >", value, "lyName");
            return (Criteria) this;
        }

        public Criteria andLyNameGreaterThanOrEqualTo(String value) {
            addCriterion("LY_NAME >=", value, "lyName");
            return (Criteria) this;
        }

        public Criteria andLyNameLessThan(String value) {
            addCriterion("LY_NAME <", value, "lyName");
            return (Criteria) this;
        }

        public Criteria andLyNameLessThanOrEqualTo(String value) {
            addCriterion("LY_NAME <=", value, "lyName");
            return (Criteria) this;
        }

        public Criteria andLyNameLike(String value) {
            addCriterion("LY_NAME like", value, "lyName");
            return (Criteria) this;
        }

        public Criteria andLyNameNotLike(String value) {
            addCriterion("LY_NAME not like", value, "lyName");
            return (Criteria) this;
        }

        public Criteria andLyNameIn(List<String> values) {
            addCriterion("LY_NAME in", values, "lyName");
            return (Criteria) this;
        }

        public Criteria andLyNameNotIn(List<String> values) {
            addCriterion("LY_NAME not in", values, "lyName");
            return (Criteria) this;
        }

        public Criteria andLyNameBetween(String value1, String value2) {
            addCriterion("LY_NAME between", value1, value2, "lyName");
            return (Criteria) this;
        }

        public Criteria andLyNameNotBetween(String value1, String value2) {
            addCriterion("LY_NAME not between", value1, value2, "lyName");
            return (Criteria) this;
        }

        public Criteria andLyDateIsNull() {
            addCriterion("LY_DATE is null");
            return (Criteria) this;
        }

        public Criteria andLyDateIsNotNull() {
            addCriterion("LY_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andLyDateEqualTo(String value) {
            addCriterion("LY_DATE =", value, "lyDate");
            return (Criteria) this;
        }

        public Criteria andLyDateNotEqualTo(String value) {
            addCriterion("LY_DATE <>", value, "lyDate");
            return (Criteria) this;
        }

        public Criteria andLyDateGreaterThan(String value) {
            addCriterion("LY_DATE >", value, "lyDate");
            return (Criteria) this;
        }

        public Criteria andLyDateGreaterThanOrEqualTo(String value) {
            addCriterion("LY_DATE >=", value, "lyDate");
            return (Criteria) this;
        }

        public Criteria andLyDateLessThan(String value) {
            addCriterion("LY_DATE <", value, "lyDate");
            return (Criteria) this;
        }

        public Criteria andLyDateLessThanOrEqualTo(String value) {
            addCriterion("LY_DATE <=", value, "lyDate");
            return (Criteria) this;
        }

        public Criteria andLyDateLike(String value) {
            addCriterion("LY_DATE like", value, "lyDate");
            return (Criteria) this;
        }

        public Criteria andLyDateNotLike(String value) {
            addCriterion("LY_DATE not like", value, "lyDate");
            return (Criteria) this;
        }

        public Criteria andLyDateIn(List<String> values) {
            addCriterion("LY_DATE in", values, "lyDate");
            return (Criteria) this;
        }

        public Criteria andLyDateNotIn(List<String> values) {
            addCriterion("LY_DATE not in", values, "lyDate");
            return (Criteria) this;
        }

        public Criteria andLyDateBetween(String value1, String value2) {
            addCriterion("LY_DATE between", value1, value2, "lyDate");
            return (Criteria) this;
        }

        public Criteria andLyDateNotBetween(String value1, String value2) {
            addCriterion("LY_DATE not between", value1, value2, "lyDate");
            return (Criteria) this;
        }

        public Criteria andDevOpIdIsNull() {
            addCriterion("DEV_OP_ID is null");
            return (Criteria) this;
        }

        public Criteria andDevOpIdIsNotNull() {
            addCriterion("DEV_OP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDevOpIdEqualTo(String value) {
            addCriterion("DEV_OP_ID =", value, "devOpId");
            return (Criteria) this;
        }

        public Criteria andDevOpIdNotEqualTo(String value) {
            addCriterion("DEV_OP_ID <>", value, "devOpId");
            return (Criteria) this;
        }

        public Criteria andDevOpIdGreaterThan(String value) {
            addCriterion("DEV_OP_ID >", value, "devOpId");
            return (Criteria) this;
        }

        public Criteria andDevOpIdGreaterThanOrEqualTo(String value) {
            addCriterion("DEV_OP_ID >=", value, "devOpId");
            return (Criteria) this;
        }

        public Criteria andDevOpIdLessThan(String value) {
            addCriterion("DEV_OP_ID <", value, "devOpId");
            return (Criteria) this;
        }

        public Criteria andDevOpIdLessThanOrEqualTo(String value) {
            addCriterion("DEV_OP_ID <=", value, "devOpId");
            return (Criteria) this;
        }

        public Criteria andDevOpIdLike(String value) {
            addCriterion("DEV_OP_ID like", value, "devOpId");
            return (Criteria) this;
        }

        public Criteria andDevOpIdNotLike(String value) {
            addCriterion("DEV_OP_ID not like", value, "devOpId");
            return (Criteria) this;
        }

        public Criteria andDevOpIdIn(List<String> values) {
            addCriterion("DEV_OP_ID in", values, "devOpId");
            return (Criteria) this;
        }

        public Criteria andDevOpIdNotIn(List<String> values) {
            addCriterion("DEV_OP_ID not in", values, "devOpId");
            return (Criteria) this;
        }

        public Criteria andDevOpIdBetween(String value1, String value2) {
            addCriterion("DEV_OP_ID between", value1, value2, "devOpId");
            return (Criteria) this;
        }

        public Criteria andDevOpIdNotBetween(String value1, String value2) {
            addCriterion("DEV_OP_ID not between", value1, value2, "devOpId");
            return (Criteria) this;
        }

        public Criteria andStampDatetimeIsNull() {
            addCriterion("STAMP_DATETIME is null");
            return (Criteria) this;
        }

        public Criteria andStampDatetimeIsNotNull() {
            addCriterion("STAMP_DATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andStampDatetimeEqualTo(String value) {
            addCriterion("STAMP_DATETIME =", value, "stampDatetime");
            return (Criteria) this;
        }

        public Criteria andStampDatetimeNotEqualTo(String value) {
            addCriterion("STAMP_DATETIME <>", value, "stampDatetime");
            return (Criteria) this;
        }

        public Criteria andStampDatetimeGreaterThan(String value) {
            addCriterion("STAMP_DATETIME >", value, "stampDatetime");
            return (Criteria) this;
        }

        public Criteria andStampDatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("STAMP_DATETIME >=", value, "stampDatetime");
            return (Criteria) this;
        }

        public Criteria andStampDatetimeLessThan(String value) {
            addCriterion("STAMP_DATETIME <", value, "stampDatetime");
            return (Criteria) this;
        }

        public Criteria andStampDatetimeLessThanOrEqualTo(String value) {
            addCriterion("STAMP_DATETIME <=", value, "stampDatetime");
            return (Criteria) this;
        }

        public Criteria andStampDatetimeLike(String value) {
            addCriterion("STAMP_DATETIME like", value, "stampDatetime");
            return (Criteria) this;
        }

        public Criteria andStampDatetimeNotLike(String value) {
            addCriterion("STAMP_DATETIME not like", value, "stampDatetime");
            return (Criteria) this;
        }

        public Criteria andStampDatetimeIn(List<String> values) {
            addCriterion("STAMP_DATETIME in", values, "stampDatetime");
            return (Criteria) this;
        }

        public Criteria andStampDatetimeNotIn(List<String> values) {
            addCriterion("STAMP_DATETIME not in", values, "stampDatetime");
            return (Criteria) this;
        }

        public Criteria andStampDatetimeBetween(String value1, String value2) {
            addCriterion("STAMP_DATETIME between", value1, value2, "stampDatetime");
            return (Criteria) this;
        }

        public Criteria andStampDatetimeNotBetween(String value1, String value2) {
            addCriterion("STAMP_DATETIME not between", value1, value2, "stampDatetime");
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

        public Criteria andModelIdIsNull() {
            addCriterion("MODEL_ID is null");
            return (Criteria) this;
        }

        public Criteria andModelIdIsNotNull() {
            addCriterion("MODEL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andModelIdEqualTo(String value) {
            addCriterion("MODEL_ID =", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotEqualTo(String value) {
            addCriterion("MODEL_ID <>", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdGreaterThan(String value) {
            addCriterion("MODEL_ID >", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdGreaterThanOrEqualTo(String value) {
            addCriterion("MODEL_ID >=", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdLessThan(String value) {
            addCriterion("MODEL_ID <", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdLessThanOrEqualTo(String value) {
            addCriterion("MODEL_ID <=", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdLike(String value) {
            addCriterion("MODEL_ID like", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotLike(String value) {
            addCriterion("MODEL_ID not like", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdIn(List<String> values) {
            addCriterion("MODEL_ID in", values, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotIn(List<String> values) {
            addCriterion("MODEL_ID not in", values, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdBetween(String value1, String value2) {
            addCriterion("MODEL_ID between", value1, value2, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotBetween(String value1, String value2) {
            addCriterion("MODEL_ID not between", value1, value2, "modelId");
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

        public Criteria andDeviceHwVersionIsNull() {
            addCriterion("DEVICE_HW_VERSION is null");
            return (Criteria) this;
        }

        public Criteria andDeviceHwVersionIsNotNull() {
            addCriterion("DEVICE_HW_VERSION is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceHwVersionEqualTo(String value) {
            addCriterion("DEVICE_HW_VERSION =", value, "deviceHwVersion");
            return (Criteria) this;
        }

        public Criteria andDeviceHwVersionNotEqualTo(String value) {
            addCriterion("DEVICE_HW_VERSION <>", value, "deviceHwVersion");
            return (Criteria) this;
        }

        public Criteria andDeviceHwVersionGreaterThan(String value) {
            addCriterion("DEVICE_HW_VERSION >", value, "deviceHwVersion");
            return (Criteria) this;
        }

        public Criteria andDeviceHwVersionGreaterThanOrEqualTo(String value) {
            addCriterion("DEVICE_HW_VERSION >=", value, "deviceHwVersion");
            return (Criteria) this;
        }

        public Criteria andDeviceHwVersionLessThan(String value) {
            addCriterion("DEVICE_HW_VERSION <", value, "deviceHwVersion");
            return (Criteria) this;
        }

        public Criteria andDeviceHwVersionLessThanOrEqualTo(String value) {
            addCriterion("DEVICE_HW_VERSION <=", value, "deviceHwVersion");
            return (Criteria) this;
        }

        public Criteria andDeviceHwVersionLike(String value) {
            addCriterion("DEVICE_HW_VERSION like", value, "deviceHwVersion");
            return (Criteria) this;
        }

        public Criteria andDeviceHwVersionNotLike(String value) {
            addCriterion("DEVICE_HW_VERSION not like", value, "deviceHwVersion");
            return (Criteria) this;
        }

        public Criteria andDeviceHwVersionIn(List<String> values) {
            addCriterion("DEVICE_HW_VERSION in", values, "deviceHwVersion");
            return (Criteria) this;
        }

        public Criteria andDeviceHwVersionNotIn(List<String> values) {
            addCriterion("DEVICE_HW_VERSION not in", values, "deviceHwVersion");
            return (Criteria) this;
        }

        public Criteria andDeviceHwVersionBetween(String value1, String value2) {
            addCriterion("DEVICE_HW_VERSION between", value1, value2, "deviceHwVersion");
            return (Criteria) this;
        }

        public Criteria andDeviceHwVersionNotBetween(String value1, String value2) {
            addCriterion("DEVICE_HW_VERSION not between", value1, value2, "deviceHwVersion");
            return (Criteria) this;
        }

        public Criteria andDeviceSwVersionIsNull() {
            addCriterion("DEVICE_SW_VERSION is null");
            return (Criteria) this;
        }

        public Criteria andDeviceSwVersionIsNotNull() {
            addCriterion("DEVICE_SW_VERSION is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceSwVersionEqualTo(String value) {
            addCriterion("DEVICE_SW_VERSION =", value, "deviceSwVersion");
            return (Criteria) this;
        }

        public Criteria andDeviceSwVersionNotEqualTo(String value) {
            addCriterion("DEVICE_SW_VERSION <>", value, "deviceSwVersion");
            return (Criteria) this;
        }

        public Criteria andDeviceSwVersionGreaterThan(String value) {
            addCriterion("DEVICE_SW_VERSION >", value, "deviceSwVersion");
            return (Criteria) this;
        }

        public Criteria andDeviceSwVersionGreaterThanOrEqualTo(String value) {
            addCriterion("DEVICE_SW_VERSION >=", value, "deviceSwVersion");
            return (Criteria) this;
        }

        public Criteria andDeviceSwVersionLessThan(String value) {
            addCriterion("DEVICE_SW_VERSION <", value, "deviceSwVersion");
            return (Criteria) this;
        }

        public Criteria andDeviceSwVersionLessThanOrEqualTo(String value) {
            addCriterion("DEVICE_SW_VERSION <=", value, "deviceSwVersion");
            return (Criteria) this;
        }

        public Criteria andDeviceSwVersionLike(String value) {
            addCriterion("DEVICE_SW_VERSION like", value, "deviceSwVersion");
            return (Criteria) this;
        }

        public Criteria andDeviceSwVersionNotLike(String value) {
            addCriterion("DEVICE_SW_VERSION not like", value, "deviceSwVersion");
            return (Criteria) this;
        }

        public Criteria andDeviceSwVersionIn(List<String> values) {
            addCriterion("DEVICE_SW_VERSION in", values, "deviceSwVersion");
            return (Criteria) this;
        }

        public Criteria andDeviceSwVersionNotIn(List<String> values) {
            addCriterion("DEVICE_SW_VERSION not in", values, "deviceSwVersion");
            return (Criteria) this;
        }

        public Criteria andDeviceSwVersionBetween(String value1, String value2) {
            addCriterion("DEVICE_SW_VERSION between", value1, value2, "deviceSwVersion");
            return (Criteria) this;
        }

        public Criteria andDeviceSwVersionNotBetween(String value1, String value2) {
            addCriterion("DEVICE_SW_VERSION not between", value1, value2, "deviceSwVersion");
            return (Criteria) this;
        }

        public Criteria andMerchantNameIsNull() {
            addCriterion("MERCHANT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andMerchantNameIsNotNull() {
            addCriterion("MERCHANT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantNameEqualTo(String value) {
            addCriterion("MERCHANT_NAME =", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameNotEqualTo(String value) {
            addCriterion("MERCHANT_NAME <>", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameGreaterThan(String value) {
            addCriterion("MERCHANT_NAME >", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameGreaterThanOrEqualTo(String value) {
            addCriterion("MERCHANT_NAME >=", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameLessThan(String value) {
            addCriterion("MERCHANT_NAME <", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameLessThanOrEqualTo(String value) {
            addCriterion("MERCHANT_NAME <=", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameLike(String value) {
            addCriterion("MERCHANT_NAME like", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameNotLike(String value) {
            addCriterion("MERCHANT_NAME not like", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameIn(List<String> values) {
            addCriterion("MERCHANT_NAME in", values, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameNotIn(List<String> values) {
            addCriterion("MERCHANT_NAME not in", values, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameBetween(String value1, String value2) {
            addCriterion("MERCHANT_NAME between", value1, value2, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameNotBetween(String value1, String value2) {
            addCriterion("MERCHANT_NAME not between", value1, value2, "merchantName");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNull() {
            addCriterion("GROUP_ID is null");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNotNull() {
            addCriterion("GROUP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andGroupIdEqualTo(String value) {
            addCriterion("GROUP_ID =", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotEqualTo(String value) {
            addCriterion("GROUP_ID <>", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThan(String value) {
            addCriterion("GROUP_ID >", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThanOrEqualTo(String value) {
            addCriterion("GROUP_ID >=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThan(String value) {
            addCriterion("GROUP_ID <", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThanOrEqualTo(String value) {
            addCriterion("GROUP_ID <=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLike(String value) {
            addCriterion("GROUP_ID like", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotLike(String value) {
            addCriterion("GROUP_ID not like", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdIn(List<String> values) {
            addCriterion("GROUP_ID in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotIn(List<String> values) {
            addCriterion("GROUP_ID not in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdBetween(String value1, String value2) {
            addCriterion("GROUP_ID between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotBetween(String value1, String value2) {
            addCriterion("GROUP_ID not between", value1, value2, "groupId");
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