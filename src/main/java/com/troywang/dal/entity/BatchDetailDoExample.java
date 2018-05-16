package com.troywang.dal.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BatchDetailDoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected int startIndex;

    protected int pageSize;

    protected List<Criteria> oredCriteria;

    public BatchDetailDoExample() {
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

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageSize() {
        return pageSize;
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andEnabledIsNull() {
            addCriterion("enabled is null");
            return (Criteria) this;
        }

        public Criteria andEnabledIsNotNull() {
            addCriterion("enabled is not null");
            return (Criteria) this;
        }

        public Criteria andEnabledEqualTo(Byte value) {
            addCriterion("enabled =", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotEqualTo(Byte value) {
            addCriterion("enabled <>", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledGreaterThan(Byte value) {
            addCriterion("enabled >", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledGreaterThanOrEqualTo(Byte value) {
            addCriterion("enabled >=", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledLessThan(Byte value) {
            addCriterion("enabled <", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledLessThanOrEqualTo(Byte value) {
            addCriterion("enabled <=", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledIn(List<Byte> values) {
            addCriterion("enabled in", values, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotIn(List<Byte> values) {
            addCriterion("enabled not in", values, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledBetween(Byte value1, Byte value2) {
            addCriterion("enabled between", value1, value2, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotBetween(Byte value1, Byte value2) {
            addCriterion("enabled not between", value1, value2, "enabled");
            return (Criteria) this;
        }

        public Criteria andScheduleNoIsNull() {
            addCriterion("schedule_no is null");
            return (Criteria) this;
        }

        public Criteria andScheduleNoIsNotNull() {
            addCriterion("schedule_no is not null");
            return (Criteria) this;
        }

        public Criteria andScheduleNoEqualTo(String value) {
            addCriterion("schedule_no =", value, "scheduleNo");
            return (Criteria) this;
        }

        public Criteria andScheduleNoNotEqualTo(String value) {
            addCriterion("schedule_no <>", value, "scheduleNo");
            return (Criteria) this;
        }

        public Criteria andScheduleNoGreaterThan(String value) {
            addCriterion("schedule_no >", value, "scheduleNo");
            return (Criteria) this;
        }

        public Criteria andScheduleNoGreaterThanOrEqualTo(String value) {
            addCriterion("schedule_no >=", value, "scheduleNo");
            return (Criteria) this;
        }

        public Criteria andScheduleNoLessThan(String value) {
            addCriterion("schedule_no <", value, "scheduleNo");
            return (Criteria) this;
        }

        public Criteria andScheduleNoLessThanOrEqualTo(String value) {
            addCriterion("schedule_no <=", value, "scheduleNo");
            return (Criteria) this;
        }

        public Criteria andScheduleNoLike(String value) {
            addCriterion("schedule_no like", value, "scheduleNo");
            return (Criteria) this;
        }

        public Criteria andScheduleNoNotLike(String value) {
            addCriterion("schedule_no not like", value, "scheduleNo");
            return (Criteria) this;
        }

        public Criteria andScheduleNoIn(List<String> values) {
            addCriterion("schedule_no in", values, "scheduleNo");
            return (Criteria) this;
        }

        public Criteria andScheduleNoNotIn(List<String> values) {
            addCriterion("schedule_no not in", values, "scheduleNo");
            return (Criteria) this;
        }

        public Criteria andScheduleNoBetween(String value1, String value2) {
            addCriterion("schedule_no between", value1, value2, "scheduleNo");
            return (Criteria) this;
        }

        public Criteria andScheduleNoNotBetween(String value1, String value2) {
            addCriterion("schedule_no not between", value1, value2, "scheduleNo");
            return (Criteria) this;
        }

        public Criteria andRecordNoIsNull() {
            addCriterion("record_no is null");
            return (Criteria) this;
        }

        public Criteria andRecordNoIsNotNull() {
            addCriterion("record_no is not null");
            return (Criteria) this;
        }

        public Criteria andRecordNoEqualTo(String value) {
            addCriterion("record_no =", value, "recordNo");
            return (Criteria) this;
        }

        public Criteria andRecordNoNotEqualTo(String value) {
            addCriterion("record_no <>", value, "recordNo");
            return (Criteria) this;
        }

        public Criteria andRecordNoGreaterThan(String value) {
            addCriterion("record_no >", value, "recordNo");
            return (Criteria) this;
        }

        public Criteria andRecordNoGreaterThanOrEqualTo(String value) {
            addCriterion("record_no >=", value, "recordNo");
            return (Criteria) this;
        }

        public Criteria andRecordNoLessThan(String value) {
            addCriterion("record_no <", value, "recordNo");
            return (Criteria) this;
        }

        public Criteria andRecordNoLessThanOrEqualTo(String value) {
            addCriterion("record_no <=", value, "recordNo");
            return (Criteria) this;
        }

        public Criteria andRecordNoLike(String value) {
            addCriterion("record_no like", value, "recordNo");
            return (Criteria) this;
        }

        public Criteria andRecordNoNotLike(String value) {
            addCriterion("record_no not like", value, "recordNo");
            return (Criteria) this;
        }

        public Criteria andRecordNoIn(List<String> values) {
            addCriterion("record_no in", values, "recordNo");
            return (Criteria) this;
        }

        public Criteria andRecordNoNotIn(List<String> values) {
            addCriterion("record_no not in", values, "recordNo");
            return (Criteria) this;
        }

        public Criteria andRecordNoBetween(String value1, String value2) {
            addCriterion("record_no between", value1, value2, "recordNo");
            return (Criteria) this;
        }

        public Criteria andRecordNoNotBetween(String value1, String value2) {
            addCriterion("record_no not between", value1, value2, "recordNo");
            return (Criteria) this;
        }

        public Criteria andRecordTypeIsNull() {
            addCriterion("record_type is null");
            return (Criteria) this;
        }

        public Criteria andRecordTypeIsNotNull() {
            addCriterion("record_type is not null");
            return (Criteria) this;
        }

        public Criteria andRecordTypeEqualTo(String value) {
            addCriterion("record_type =", value, "recordType");
            return (Criteria) this;
        }

        public Criteria andRecordTypeNotEqualTo(String value) {
            addCriterion("record_type <>", value, "recordType");
            return (Criteria) this;
        }

        public Criteria andRecordTypeGreaterThan(String value) {
            addCriterion("record_type >", value, "recordType");
            return (Criteria) this;
        }

        public Criteria andRecordTypeGreaterThanOrEqualTo(String value) {
            addCriterion("record_type >=", value, "recordType");
            return (Criteria) this;
        }

        public Criteria andRecordTypeLessThan(String value) {
            addCriterion("record_type <", value, "recordType");
            return (Criteria) this;
        }

        public Criteria andRecordTypeLessThanOrEqualTo(String value) {
            addCriterion("record_type <=", value, "recordType");
            return (Criteria) this;
        }

        public Criteria andRecordTypeLike(String value) {
            addCriterion("record_type like", value, "recordType");
            return (Criteria) this;
        }

        public Criteria andRecordTypeNotLike(String value) {
            addCriterion("record_type not like", value, "recordType");
            return (Criteria) this;
        }

        public Criteria andRecordTypeIn(List<String> values) {
            addCriterion("record_type in", values, "recordType");
            return (Criteria) this;
        }

        public Criteria andRecordTypeNotIn(List<String> values) {
            addCriterion("record_type not in", values, "recordType");
            return (Criteria) this;
        }

        public Criteria andRecordTypeBetween(String value1, String value2) {
            addCriterion("record_type between", value1, value2, "recordType");
            return (Criteria) this;
        }

        public Criteria andRecordTypeNotBetween(String value1, String value2) {
            addCriterion("record_type not between", value1, value2, "recordType");
            return (Criteria) this;
        }

        public Criteria andItemIdIsNull() {
            addCriterion("item_id is null");
            return (Criteria) this;
        }

        public Criteria andItemIdIsNotNull() {
            addCriterion("item_id is not null");
            return (Criteria) this;
        }

        public Criteria andItemIdEqualTo(String value) {
            addCriterion("item_id =", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotEqualTo(String value) {
            addCriterion("item_id <>", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThan(String value) {
            addCriterion("item_id >", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThanOrEqualTo(String value) {
            addCriterion("item_id >=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThan(String value) {
            addCriterion("item_id <", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThanOrEqualTo(String value) {
            addCriterion("item_id <=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLike(String value) {
            addCriterion("item_id like", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotLike(String value) {
            addCriterion("item_id not like", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdIn(List<String> values) {
            addCriterion("item_id in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotIn(List<String> values) {
            addCriterion("item_id not in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdBetween(String value1, String value2) {
            addCriterion("item_id between", value1, value2, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotBetween(String value1, String value2) {
            addCriterion("item_id not between", value1, value2, "itemId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andRecordStateIsNull() {
            addCriterion("record_state is null");
            return (Criteria) this;
        }

        public Criteria andRecordStateIsNotNull() {
            addCriterion("record_state is not null");
            return (Criteria) this;
        }

        public Criteria andRecordStateEqualTo(String value) {
            addCriterion("record_state =", value, "recordState");
            return (Criteria) this;
        }

        public Criteria andRecordStateNotEqualTo(String value) {
            addCriterion("record_state <>", value, "recordState");
            return (Criteria) this;
        }

        public Criteria andRecordStateGreaterThan(String value) {
            addCriterion("record_state >", value, "recordState");
            return (Criteria) this;
        }

        public Criteria andRecordStateGreaterThanOrEqualTo(String value) {
            addCriterion("record_state >=", value, "recordState");
            return (Criteria) this;
        }

        public Criteria andRecordStateLessThan(String value) {
            addCriterion("record_state <", value, "recordState");
            return (Criteria) this;
        }

        public Criteria andRecordStateLessThanOrEqualTo(String value) {
            addCriterion("record_state <=", value, "recordState");
            return (Criteria) this;
        }

        public Criteria andRecordStateLike(String value) {
            addCriterion("record_state like", value, "recordState");
            return (Criteria) this;
        }

        public Criteria andRecordStateNotLike(String value) {
            addCriterion("record_state not like", value, "recordState");
            return (Criteria) this;
        }

        public Criteria andRecordStateIn(List<String> values) {
            addCriterion("record_state in", values, "recordState");
            return (Criteria) this;
        }

        public Criteria andRecordStateNotIn(List<String> values) {
            addCriterion("record_state not in", values, "recordState");
            return (Criteria) this;
        }

        public Criteria andRecordStateBetween(String value1, String value2) {
            addCriterion("record_state between", value1, value2, "recordState");
            return (Criteria) this;
        }

        public Criteria andRecordStateNotBetween(String value1, String value2) {
            addCriterion("record_state not between", value1, value2, "recordState");
            return (Criteria) this;
        }

        public Criteria andExtensionIsNull() {
            addCriterion("extension is null");
            return (Criteria) this;
        }

        public Criteria andExtensionIsNotNull() {
            addCriterion("extension is not null");
            return (Criteria) this;
        }

        public Criteria andExtensionEqualTo(String value) {
            addCriterion("extension =", value, "extension");
            return (Criteria) this;
        }

        public Criteria andExtensionNotEqualTo(String value) {
            addCriterion("extension <>", value, "extension");
            return (Criteria) this;
        }

        public Criteria andExtensionGreaterThan(String value) {
            addCriterion("extension >", value, "extension");
            return (Criteria) this;
        }

        public Criteria andExtensionGreaterThanOrEqualTo(String value) {
            addCriterion("extension >=", value, "extension");
            return (Criteria) this;
        }

        public Criteria andExtensionLessThan(String value) {
            addCriterion("extension <", value, "extension");
            return (Criteria) this;
        }

        public Criteria andExtensionLessThanOrEqualTo(String value) {
            addCriterion("extension <=", value, "extension");
            return (Criteria) this;
        }

        public Criteria andExtensionLike(String value) {
            addCriterion("extension like", value, "extension");
            return (Criteria) this;
        }

        public Criteria andExtensionNotLike(String value) {
            addCriterion("extension not like", value, "extension");
            return (Criteria) this;
        }

        public Criteria andExtensionIn(List<String> values) {
            addCriterion("extension in", values, "extension");
            return (Criteria) this;
        }

        public Criteria andExtensionNotIn(List<String> values) {
            addCriterion("extension not in", values, "extension");
            return (Criteria) this;
        }

        public Criteria andExtensionBetween(String value1, String value2) {
            addCriterion("extension between", value1, value2, "extension");
            return (Criteria) this;
        }

        public Criteria andExtensionNotBetween(String value1, String value2) {
            addCriterion("extension not between", value1, value2, "extension");
            return (Criteria) this;
        }

        public Criteria andMemoIsNull() {
            addCriterion("memo is null");
            return (Criteria) this;
        }

        public Criteria andMemoIsNotNull() {
            addCriterion("memo is not null");
            return (Criteria) this;
        }

        public Criteria andMemoEqualTo(String value) {
            addCriterion("memo =", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotEqualTo(String value) {
            addCriterion("memo <>", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoGreaterThan(String value) {
            addCriterion("memo >", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoGreaterThanOrEqualTo(String value) {
            addCriterion("memo >=", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLessThan(String value) {
            addCriterion("memo <", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLessThanOrEqualTo(String value) {
            addCriterion("memo <=", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLike(String value) {
            addCriterion("memo like", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotLike(String value) {
            addCriterion("memo not like", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoIn(List<String> values) {
            addCriterion("memo in", values, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotIn(List<String> values) {
            addCriterion("memo not in", values, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoBetween(String value1, String value2) {
            addCriterion("memo between", value1, value2, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotBetween(String value1, String value2) {
            addCriterion("memo not between", value1, value2, "memo");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNull() {
            addCriterion("modify_time is null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNotNull() {
            addCriterion("modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeEqualTo(Date value) {
            addCriterion("modify_time =", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotEqualTo(Date value) {
            addCriterion("modify_time <>", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThan(Date value) {
            addCriterion("modify_time >", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("modify_time >=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThan(Date value) {
            addCriterion("modify_time <", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("modify_time <=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIn(List<Date> values) {
            addCriterion("modify_time in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotIn(List<Date> values) {
            addCriterion("modify_time not in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeBetween(Date value1, Date value2) {
            addCriterion("modify_time between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("modify_time not between", value1, value2, "modifyTime");
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