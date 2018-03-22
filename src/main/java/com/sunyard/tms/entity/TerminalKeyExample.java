package com.sunyard.tms.entity;

import java.util.ArrayList;
import java.util.List;

public class TerminalKeyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TerminalKeyExample() {
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

        public Criteria andKeyIdIsNull() {
            addCriterion("KEY_ID is null");
            return (Criteria) this;
        }

        public Criteria andKeyIdIsNotNull() {
            addCriterion("KEY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andKeyIdEqualTo(String value) {
            addCriterion("KEY_ID =", value, "keyId");
            return (Criteria) this;
        }

        public Criteria andKeyIdNotEqualTo(String value) {
            addCriterion("KEY_ID <>", value, "keyId");
            return (Criteria) this;
        }

        public Criteria andKeyIdGreaterThan(String value) {
            addCriterion("KEY_ID >", value, "keyId");
            return (Criteria) this;
        }

        public Criteria andKeyIdGreaterThanOrEqualTo(String value) {
            addCriterion("KEY_ID >=", value, "keyId");
            return (Criteria) this;
        }

        public Criteria andKeyIdLessThan(String value) {
            addCriterion("KEY_ID <", value, "keyId");
            return (Criteria) this;
        }

        public Criteria andKeyIdLessThanOrEqualTo(String value) {
            addCriterion("KEY_ID <=", value, "keyId");
            return (Criteria) this;
        }

        public Criteria andKeyIdLike(String value) {
            addCriterion("KEY_ID like", value, "keyId");
            return (Criteria) this;
        }

        public Criteria andKeyIdNotLike(String value) {
            addCriterion("KEY_ID not like", value, "keyId");
            return (Criteria) this;
        }

        public Criteria andKeyIdIn(List<String> values) {
            addCriterion("KEY_ID in", values, "keyId");
            return (Criteria) this;
        }

        public Criteria andKeyIdNotIn(List<String> values) {
            addCriterion("KEY_ID not in", values, "keyId");
            return (Criteria) this;
        }

        public Criteria andKeyIdBetween(String value1, String value2) {
            addCriterion("KEY_ID between", value1, value2, "keyId");
            return (Criteria) this;
        }

        public Criteria andKeyIdNotBetween(String value1, String value2) {
            addCriterion("KEY_ID not between", value1, value2, "keyId");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(String value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(String value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(String value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(String value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(String value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLike(String value) {
            addCriterion("CREATE_TIME like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotLike(String value) {
            addCriterion("CREATE_TIME not like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<String> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<String> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(String value1, String value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(String value1, String value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("DESCRIPTION is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("DESCRIPTION is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("DESCRIPTION =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("DESCRIPTION <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("DESCRIPTION >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("DESCRIPTION >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("DESCRIPTION <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("DESCRIPTION <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("DESCRIPTION like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("DESCRIPTION not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("DESCRIPTION in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("DESCRIPTION not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("DESCRIPTION between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("DESCRIPTION not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andTmsCodeIsNull() {
            addCriterion("TMS_CODE is null");
            return (Criteria) this;
        }

        public Criteria andTmsCodeIsNotNull() {
            addCriterion("TMS_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andTmsCodeEqualTo(String value) {
            addCriterion("TMS_CODE =", value, "tmsCode");
            return (Criteria) this;
        }

        public Criteria andTmsCodeNotEqualTo(String value) {
            addCriterion("TMS_CODE <>", value, "tmsCode");
            return (Criteria) this;
        }

        public Criteria andTmsCodeGreaterThan(String value) {
            addCriterion("TMS_CODE >", value, "tmsCode");
            return (Criteria) this;
        }

        public Criteria andTmsCodeGreaterThanOrEqualTo(String value) {
            addCriterion("TMS_CODE >=", value, "tmsCode");
            return (Criteria) this;
        }

        public Criteria andTmsCodeLessThan(String value) {
            addCriterion("TMS_CODE <", value, "tmsCode");
            return (Criteria) this;
        }

        public Criteria andTmsCodeLessThanOrEqualTo(String value) {
            addCriterion("TMS_CODE <=", value, "tmsCode");
            return (Criteria) this;
        }

        public Criteria andTmsCodeLike(String value) {
            addCriterion("TMS_CODE like", value, "tmsCode");
            return (Criteria) this;
        }

        public Criteria andTmsCodeNotLike(String value) {
            addCriterion("TMS_CODE not like", value, "tmsCode");
            return (Criteria) this;
        }

        public Criteria andTmsCodeIn(List<String> values) {
            addCriterion("TMS_CODE in", values, "tmsCode");
            return (Criteria) this;
        }

        public Criteria andTmsCodeNotIn(List<String> values) {
            addCriterion("TMS_CODE not in", values, "tmsCode");
            return (Criteria) this;
        }

        public Criteria andTmsCodeBetween(String value1, String value2) {
            addCriterion("TMS_CODE between", value1, value2, "tmsCode");
            return (Criteria) this;
        }

        public Criteria andTmsCodeNotBetween(String value1, String value2) {
            addCriterion("TMS_CODE not between", value1, value2, "tmsCode");
            return (Criteria) this;
        }

        public Criteria andTmkIsNull() {
            addCriterion("TMK is null");
            return (Criteria) this;
        }

        public Criteria andTmkIsNotNull() {
            addCriterion("TMK is not null");
            return (Criteria) this;
        }

        public Criteria andTmkEqualTo(String value) {
            addCriterion("TMK =", value, "tmk");
            return (Criteria) this;
        }

        public Criteria andTmkNotEqualTo(String value) {
            addCriterion("TMK <>", value, "tmk");
            return (Criteria) this;
        }

        public Criteria andTmkGreaterThan(String value) {
            addCriterion("TMK >", value, "tmk");
            return (Criteria) this;
        }

        public Criteria andTmkGreaterThanOrEqualTo(String value) {
            addCriterion("TMK >=", value, "tmk");
            return (Criteria) this;
        }

        public Criteria andTmkLessThan(String value) {
            addCriterion("TMK <", value, "tmk");
            return (Criteria) this;
        }

        public Criteria andTmkLessThanOrEqualTo(String value) {
            addCriterion("TMK <=", value, "tmk");
            return (Criteria) this;
        }

        public Criteria andTmkLike(String value) {
            addCriterion("TMK like", value, "tmk");
            return (Criteria) this;
        }

        public Criteria andTmkNotLike(String value) {
            addCriterion("TMK not like", value, "tmk");
            return (Criteria) this;
        }

        public Criteria andTmkIn(List<String> values) {
            addCriterion("TMK in", values, "tmk");
            return (Criteria) this;
        }

        public Criteria andTmkNotIn(List<String> values) {
            addCriterion("TMK not in", values, "tmk");
            return (Criteria) this;
        }

        public Criteria andTmkBetween(String value1, String value2) {
            addCriterion("TMK between", value1, value2, "tmk");
            return (Criteria) this;
        }

        public Criteria andTmkNotBetween(String value1, String value2) {
            addCriterion("TMK not between", value1, value2, "tmk");
            return (Criteria) this;
        }

        public Criteria andTakIsNull() {
            addCriterion("TAK is null");
            return (Criteria) this;
        }

        public Criteria andTakIsNotNull() {
            addCriterion("TAK is not null");
            return (Criteria) this;
        }

        public Criteria andTakEqualTo(String value) {
            addCriterion("TAK =", value, "tak");
            return (Criteria) this;
        }

        public Criteria andTakNotEqualTo(String value) {
            addCriterion("TAK <>", value, "tak");
            return (Criteria) this;
        }

        public Criteria andTakGreaterThan(String value) {
            addCriterion("TAK >", value, "tak");
            return (Criteria) this;
        }

        public Criteria andTakGreaterThanOrEqualTo(String value) {
            addCriterion("TAK >=", value, "tak");
            return (Criteria) this;
        }

        public Criteria andTakLessThan(String value) {
            addCriterion("TAK <", value, "tak");
            return (Criteria) this;
        }

        public Criteria andTakLessThanOrEqualTo(String value) {
            addCriterion("TAK <=", value, "tak");
            return (Criteria) this;
        }

        public Criteria andTakLike(String value) {
            addCriterion("TAK like", value, "tak");
            return (Criteria) this;
        }

        public Criteria andTakNotLike(String value) {
            addCriterion("TAK not like", value, "tak");
            return (Criteria) this;
        }

        public Criteria andTakIn(List<String> values) {
            addCriterion("TAK in", values, "tak");
            return (Criteria) this;
        }

        public Criteria andTakNotIn(List<String> values) {
            addCriterion("TAK not in", values, "tak");
            return (Criteria) this;
        }

        public Criteria andTakBetween(String value1, String value2) {
            addCriterion("TAK between", value1, value2, "tak");
            return (Criteria) this;
        }

        public Criteria andTakNotBetween(String value1, String value2) {
            addCriterion("TAK not between", value1, value2, "tak");
            return (Criteria) this;
        }

        public Criteria andTmkReferenceNoIsNull() {
            addCriterion("TMK_REFERENCE_NO is null");
            return (Criteria) this;
        }

        public Criteria andTmkReferenceNoIsNotNull() {
            addCriterion("TMK_REFERENCE_NO is not null");
            return (Criteria) this;
        }

        public Criteria andTmkReferenceNoEqualTo(String value) {
            addCriterion("TMK_REFERENCE_NO =", value, "tmkReferenceNo");
            return (Criteria) this;
        }

        public Criteria andTmkReferenceNoNotEqualTo(String value) {
            addCriterion("TMK_REFERENCE_NO <>", value, "tmkReferenceNo");
            return (Criteria) this;
        }

        public Criteria andTmkReferenceNoGreaterThan(String value) {
            addCriterion("TMK_REFERENCE_NO >", value, "tmkReferenceNo");
            return (Criteria) this;
        }

        public Criteria andTmkReferenceNoGreaterThanOrEqualTo(String value) {
            addCriterion("TMK_REFERENCE_NO >=", value, "tmkReferenceNo");
            return (Criteria) this;
        }

        public Criteria andTmkReferenceNoLessThan(String value) {
            addCriterion("TMK_REFERENCE_NO <", value, "tmkReferenceNo");
            return (Criteria) this;
        }

        public Criteria andTmkReferenceNoLessThanOrEqualTo(String value) {
            addCriterion("TMK_REFERENCE_NO <=", value, "tmkReferenceNo");
            return (Criteria) this;
        }

        public Criteria andTmkReferenceNoLike(String value) {
            addCriterion("TMK_REFERENCE_NO like", value, "tmkReferenceNo");
            return (Criteria) this;
        }

        public Criteria andTmkReferenceNoNotLike(String value) {
            addCriterion("TMK_REFERENCE_NO not like", value, "tmkReferenceNo");
            return (Criteria) this;
        }

        public Criteria andTmkReferenceNoIn(List<String> values) {
            addCriterion("TMK_REFERENCE_NO in", values, "tmkReferenceNo");
            return (Criteria) this;
        }

        public Criteria andTmkReferenceNoNotIn(List<String> values) {
            addCriterion("TMK_REFERENCE_NO not in", values, "tmkReferenceNo");
            return (Criteria) this;
        }

        public Criteria andTmkReferenceNoBetween(String value1, String value2) {
            addCriterion("TMK_REFERENCE_NO between", value1, value2, "tmkReferenceNo");
            return (Criteria) this;
        }

        public Criteria andTmkReferenceNoNotBetween(String value1, String value2) {
            addCriterion("TMK_REFERENCE_NO not between", value1, value2, "tmkReferenceNo");
            return (Criteria) this;
        }

        public Criteria andChecksumIsNull() {
            addCriterion("CHECKSUM is null");
            return (Criteria) this;
        }

        public Criteria andChecksumIsNotNull() {
            addCriterion("CHECKSUM is not null");
            return (Criteria) this;
        }

        public Criteria andChecksumEqualTo(String value) {
            addCriterion("CHECKSUM =", value, "checksum");
            return (Criteria) this;
        }

        public Criteria andChecksumNotEqualTo(String value) {
            addCriterion("CHECKSUM <>", value, "checksum");
            return (Criteria) this;
        }

        public Criteria andChecksumGreaterThan(String value) {
            addCriterion("CHECKSUM >", value, "checksum");
            return (Criteria) this;
        }

        public Criteria andChecksumGreaterThanOrEqualTo(String value) {
            addCriterion("CHECKSUM >=", value, "checksum");
            return (Criteria) this;
        }

        public Criteria andChecksumLessThan(String value) {
            addCriterion("CHECKSUM <", value, "checksum");
            return (Criteria) this;
        }

        public Criteria andChecksumLessThanOrEqualTo(String value) {
            addCriterion("CHECKSUM <=", value, "checksum");
            return (Criteria) this;
        }

        public Criteria andChecksumLike(String value) {
            addCriterion("CHECKSUM like", value, "checksum");
            return (Criteria) this;
        }

        public Criteria andChecksumNotLike(String value) {
            addCriterion("CHECKSUM not like", value, "checksum");
            return (Criteria) this;
        }

        public Criteria andChecksumIn(List<String> values) {
            addCriterion("CHECKSUM in", values, "checksum");
            return (Criteria) this;
        }

        public Criteria andChecksumNotIn(List<String> values) {
            addCriterion("CHECKSUM not in", values, "checksum");
            return (Criteria) this;
        }

        public Criteria andChecksumBetween(String value1, String value2) {
            addCriterion("CHECKSUM between", value1, value2, "checksum");
            return (Criteria) this;
        }

        public Criteria andChecksumNotBetween(String value1, String value2) {
            addCriterion("CHECKSUM not between", value1, value2, "checksum");
            return (Criteria) this;
        }

        public Criteria andFillerIsNull() {
            addCriterion("FILLER is null");
            return (Criteria) this;
        }

        public Criteria andFillerIsNotNull() {
            addCriterion("FILLER is not null");
            return (Criteria) this;
        }

        public Criteria andFillerEqualTo(String value) {
            addCriterion("FILLER =", value, "filler");
            return (Criteria) this;
        }

        public Criteria andFillerNotEqualTo(String value) {
            addCriterion("FILLER <>", value, "filler");
            return (Criteria) this;
        }

        public Criteria andFillerGreaterThan(String value) {
            addCriterion("FILLER >", value, "filler");
            return (Criteria) this;
        }

        public Criteria andFillerGreaterThanOrEqualTo(String value) {
            addCriterion("FILLER >=", value, "filler");
            return (Criteria) this;
        }

        public Criteria andFillerLessThan(String value) {
            addCriterion("FILLER <", value, "filler");
            return (Criteria) this;
        }

        public Criteria andFillerLessThanOrEqualTo(String value) {
            addCriterion("FILLER <=", value, "filler");
            return (Criteria) this;
        }

        public Criteria andFillerLike(String value) {
            addCriterion("FILLER like", value, "filler");
            return (Criteria) this;
        }

        public Criteria andFillerNotLike(String value) {
            addCriterion("FILLER not like", value, "filler");
            return (Criteria) this;
        }

        public Criteria andFillerIn(List<String> values) {
            addCriterion("FILLER in", values, "filler");
            return (Criteria) this;
        }

        public Criteria andFillerNotIn(List<String> values) {
            addCriterion("FILLER not in", values, "filler");
            return (Criteria) this;
        }

        public Criteria andFillerBetween(String value1, String value2) {
            addCriterion("FILLER between", value1, value2, "filler");
            return (Criteria) this;
        }

        public Criteria andFillerNotBetween(String value1, String value2) {
            addCriterion("FILLER not between", value1, value2, "filler");
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

        public Criteria andUseFlagIsNull() {
            addCriterion("USE_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andUseFlagIsNotNull() {
            addCriterion("USE_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andUseFlagEqualTo(String value) {
            addCriterion("USE_FLAG =", value, "useFlag");
            return (Criteria) this;
        }

        public Criteria andUseFlagNotEqualTo(String value) {
            addCriterion("USE_FLAG <>", value, "useFlag");
            return (Criteria) this;
        }

        public Criteria andUseFlagGreaterThan(String value) {
            addCriterion("USE_FLAG >", value, "useFlag");
            return (Criteria) this;
        }

        public Criteria andUseFlagGreaterThanOrEqualTo(String value) {
            addCriterion("USE_FLAG >=", value, "useFlag");
            return (Criteria) this;
        }

        public Criteria andUseFlagLessThan(String value) {
            addCriterion("USE_FLAG <", value, "useFlag");
            return (Criteria) this;
        }

        public Criteria andUseFlagLessThanOrEqualTo(String value) {
            addCriterion("USE_FLAG <=", value, "useFlag");
            return (Criteria) this;
        }

        public Criteria andUseFlagLike(String value) {
            addCriterion("USE_FLAG like", value, "useFlag");
            return (Criteria) this;
        }

        public Criteria andUseFlagNotLike(String value) {
            addCriterion("USE_FLAG not like", value, "useFlag");
            return (Criteria) this;
        }

        public Criteria andUseFlagIn(List<String> values) {
            addCriterion("USE_FLAG in", values, "useFlag");
            return (Criteria) this;
        }

        public Criteria andUseFlagNotIn(List<String> values) {
            addCriterion("USE_FLAG not in", values, "useFlag");
            return (Criteria) this;
        }

        public Criteria andUseFlagBetween(String value1, String value2) {
            addCriterion("USE_FLAG between", value1, value2, "useFlag");
            return (Criteria) this;
        }

        public Criteria andUseFlagNotBetween(String value1, String value2) {
            addCriterion("USE_FLAG not between", value1, value2, "useFlag");
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