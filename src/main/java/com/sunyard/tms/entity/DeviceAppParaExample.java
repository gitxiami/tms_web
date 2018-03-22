package com.sunyard.tms.entity;

import java.util.ArrayList;
import java.util.List;

public class DeviceAppParaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DeviceAppParaExample() {
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

        public Criteria andParaVerIsNull() {
            addCriterion("PARA_VER is null");
            return (Criteria) this;
        }

        public Criteria andParaVerIsNotNull() {
            addCriterion("PARA_VER is not null");
            return (Criteria) this;
        }

        public Criteria andParaVerEqualTo(String value) {
            addCriterion("PARA_VER =", value, "paraVer");
            return (Criteria) this;
        }

        public Criteria andParaVerNotEqualTo(String value) {
            addCriterion("PARA_VER <>", value, "paraVer");
            return (Criteria) this;
        }

        public Criteria andParaVerGreaterThan(String value) {
            addCriterion("PARA_VER >", value, "paraVer");
            return (Criteria) this;
        }

        public Criteria andParaVerGreaterThanOrEqualTo(String value) {
            addCriterion("PARA_VER >=", value, "paraVer");
            return (Criteria) this;
        }

        public Criteria andParaVerLessThan(String value) {
            addCriterion("PARA_VER <", value, "paraVer");
            return (Criteria) this;
        }

        public Criteria andParaVerLessThanOrEqualTo(String value) {
            addCriterion("PARA_VER <=", value, "paraVer");
            return (Criteria) this;
        }

        public Criteria andParaVerLike(String value) {
            addCriterion("PARA_VER like", value, "paraVer");
            return (Criteria) this;
        }

        public Criteria andParaVerNotLike(String value) {
            addCriterion("PARA_VER not like", value, "paraVer");
            return (Criteria) this;
        }

        public Criteria andParaVerIn(List<String> values) {
            addCriterion("PARA_VER in", values, "paraVer");
            return (Criteria) this;
        }

        public Criteria andParaVerNotIn(List<String> values) {
            addCriterion("PARA_VER not in", values, "paraVer");
            return (Criteria) this;
        }

        public Criteria andParaVerBetween(String value1, String value2) {
            addCriterion("PARA_VER between", value1, value2, "paraVer");
            return (Criteria) this;
        }

        public Criteria andParaVerNotBetween(String value1, String value2) {
            addCriterion("PARA_VER not between", value1, value2, "paraVer");
            return (Criteria) this;
        }

        public Criteria andServerParaIsNull() {
            addCriterion("SERVER_PARA is null");
            return (Criteria) this;
        }

        public Criteria andServerParaIsNotNull() {
            addCriterion("SERVER_PARA is not null");
            return (Criteria) this;
        }

        public Criteria andServerParaEqualTo(String value) {
            addCriterion("SERVER_PARA =", value, "serverPara");
            return (Criteria) this;
        }

        public Criteria andServerParaNotEqualTo(String value) {
            addCriterion("SERVER_PARA <>", value, "serverPara");
            return (Criteria) this;
        }

        public Criteria andServerParaGreaterThan(String value) {
            addCriterion("SERVER_PARA >", value, "serverPara");
            return (Criteria) this;
        }

        public Criteria andServerParaGreaterThanOrEqualTo(String value) {
            addCriterion("SERVER_PARA >=", value, "serverPara");
            return (Criteria) this;
        }

        public Criteria andServerParaLessThan(String value) {
            addCriterion("SERVER_PARA <", value, "serverPara");
            return (Criteria) this;
        }

        public Criteria andServerParaLessThanOrEqualTo(String value) {
            addCriterion("SERVER_PARA <=", value, "serverPara");
            return (Criteria) this;
        }

        public Criteria andServerParaLike(String value) {
            addCriterion("SERVER_PARA like", value, "serverPara");
            return (Criteria) this;
        }

        public Criteria andServerParaNotLike(String value) {
            addCriterion("SERVER_PARA not like", value, "serverPara");
            return (Criteria) this;
        }

        public Criteria andServerParaIn(List<String> values) {
            addCriterion("SERVER_PARA in", values, "serverPara");
            return (Criteria) this;
        }

        public Criteria andServerParaNotIn(List<String> values) {
            addCriterion("SERVER_PARA not in", values, "serverPara");
            return (Criteria) this;
        }

        public Criteria andServerParaBetween(String value1, String value2) {
            addCriterion("SERVER_PARA between", value1, value2, "serverPara");
            return (Criteria) this;
        }

        public Criteria andServerParaNotBetween(String value1, String value2) {
            addCriterion("SERVER_PARA not between", value1, value2, "serverPara");
            return (Criteria) this;
        }

        public Criteria andServerParaBak1IsNull() {
            addCriterion("SERVER_PARA_BAK1 is null");
            return (Criteria) this;
        }

        public Criteria andServerParaBak1IsNotNull() {
            addCriterion("SERVER_PARA_BAK1 is not null");
            return (Criteria) this;
        }

        public Criteria andServerParaBak1EqualTo(String value) {
            addCriterion("SERVER_PARA_BAK1 =", value, "serverParaBak1");
            return (Criteria) this;
        }

        public Criteria andServerParaBak1NotEqualTo(String value) {
            addCriterion("SERVER_PARA_BAK1 <>", value, "serverParaBak1");
            return (Criteria) this;
        }

        public Criteria andServerParaBak1GreaterThan(String value) {
            addCriterion("SERVER_PARA_BAK1 >", value, "serverParaBak1");
            return (Criteria) this;
        }

        public Criteria andServerParaBak1GreaterThanOrEqualTo(String value) {
            addCriterion("SERVER_PARA_BAK1 >=", value, "serverParaBak1");
            return (Criteria) this;
        }

        public Criteria andServerParaBak1LessThan(String value) {
            addCriterion("SERVER_PARA_BAK1 <", value, "serverParaBak1");
            return (Criteria) this;
        }

        public Criteria andServerParaBak1LessThanOrEqualTo(String value) {
            addCriterion("SERVER_PARA_BAK1 <=", value, "serverParaBak1");
            return (Criteria) this;
        }

        public Criteria andServerParaBak1Like(String value) {
            addCriterion("SERVER_PARA_BAK1 like", value, "serverParaBak1");
            return (Criteria) this;
        }

        public Criteria andServerParaBak1NotLike(String value) {
            addCriterion("SERVER_PARA_BAK1 not like", value, "serverParaBak1");
            return (Criteria) this;
        }

        public Criteria andServerParaBak1In(List<String> values) {
            addCriterion("SERVER_PARA_BAK1 in", values, "serverParaBak1");
            return (Criteria) this;
        }

        public Criteria andServerParaBak1NotIn(List<String> values) {
            addCriterion("SERVER_PARA_BAK1 not in", values, "serverParaBak1");
            return (Criteria) this;
        }

        public Criteria andServerParaBak1Between(String value1, String value2) {
            addCriterion("SERVER_PARA_BAK1 between", value1, value2, "serverParaBak1");
            return (Criteria) this;
        }

        public Criteria andServerParaBak1NotBetween(String value1, String value2) {
            addCriterion("SERVER_PARA_BAK1 not between", value1, value2, "serverParaBak1");
            return (Criteria) this;
        }

        public Criteria andServerParaBak2IsNull() {
            addCriterion("SERVER_PARA_BAK2 is null");
            return (Criteria) this;
        }

        public Criteria andServerParaBak2IsNotNull() {
            addCriterion("SERVER_PARA_BAK2 is not null");
            return (Criteria) this;
        }

        public Criteria andServerParaBak2EqualTo(String value) {
            addCriterion("SERVER_PARA_BAK2 =", value, "serverParaBak2");
            return (Criteria) this;
        }

        public Criteria andServerParaBak2NotEqualTo(String value) {
            addCriterion("SERVER_PARA_BAK2 <>", value, "serverParaBak2");
            return (Criteria) this;
        }

        public Criteria andServerParaBak2GreaterThan(String value) {
            addCriterion("SERVER_PARA_BAK2 >", value, "serverParaBak2");
            return (Criteria) this;
        }

        public Criteria andServerParaBak2GreaterThanOrEqualTo(String value) {
            addCriterion("SERVER_PARA_BAK2 >=", value, "serverParaBak2");
            return (Criteria) this;
        }

        public Criteria andServerParaBak2LessThan(String value) {
            addCriterion("SERVER_PARA_BAK2 <", value, "serverParaBak2");
            return (Criteria) this;
        }

        public Criteria andServerParaBak2LessThanOrEqualTo(String value) {
            addCriterion("SERVER_PARA_BAK2 <=", value, "serverParaBak2");
            return (Criteria) this;
        }

        public Criteria andServerParaBak2Like(String value) {
            addCriterion("SERVER_PARA_BAK2 like", value, "serverParaBak2");
            return (Criteria) this;
        }

        public Criteria andServerParaBak2NotLike(String value) {
            addCriterion("SERVER_PARA_BAK2 not like", value, "serverParaBak2");
            return (Criteria) this;
        }

        public Criteria andServerParaBak2In(List<String> values) {
            addCriterion("SERVER_PARA_BAK2 in", values, "serverParaBak2");
            return (Criteria) this;
        }

        public Criteria andServerParaBak2NotIn(List<String> values) {
            addCriterion("SERVER_PARA_BAK2 not in", values, "serverParaBak2");
            return (Criteria) this;
        }

        public Criteria andServerParaBak2Between(String value1, String value2) {
            addCriterion("SERVER_PARA_BAK2 between", value1, value2, "serverParaBak2");
            return (Criteria) this;
        }

        public Criteria andServerParaBak2NotBetween(String value1, String value2) {
            addCriterion("SERVER_PARA_BAK2 not between", value1, value2, "serverParaBak2");
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