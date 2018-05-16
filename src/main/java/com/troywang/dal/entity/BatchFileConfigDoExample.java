package com.troywang.dal.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BatchFileConfigDoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected int startIndex;

    protected int pageSize;

    protected List<Criteria> oredCriteria;

    public BatchFileConfigDoExample() {
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

        public Criteria andScheduleFreqIsNull() {
            addCriterion("schedule_freq is null");
            return (Criteria) this;
        }

        public Criteria andScheduleFreqIsNotNull() {
            addCriterion("schedule_freq is not null");
            return (Criteria) this;
        }

        public Criteria andScheduleFreqEqualTo(String value) {
            addCriterion("schedule_freq =", value, "scheduleFreq");
            return (Criteria) this;
        }

        public Criteria andScheduleFreqNotEqualTo(String value) {
            addCriterion("schedule_freq <>", value, "scheduleFreq");
            return (Criteria) this;
        }

        public Criteria andScheduleFreqGreaterThan(String value) {
            addCriterion("schedule_freq >", value, "scheduleFreq");
            return (Criteria) this;
        }

        public Criteria andScheduleFreqGreaterThanOrEqualTo(String value) {
            addCriterion("schedule_freq >=", value, "scheduleFreq");
            return (Criteria) this;
        }

        public Criteria andScheduleFreqLessThan(String value) {
            addCriterion("schedule_freq <", value, "scheduleFreq");
            return (Criteria) this;
        }

        public Criteria andScheduleFreqLessThanOrEqualTo(String value) {
            addCriterion("schedule_freq <=", value, "scheduleFreq");
            return (Criteria) this;
        }

        public Criteria andScheduleFreqLike(String value) {
            addCriterion("schedule_freq like", value, "scheduleFreq");
            return (Criteria) this;
        }

        public Criteria andScheduleFreqNotLike(String value) {
            addCriterion("schedule_freq not like", value, "scheduleFreq");
            return (Criteria) this;
        }

        public Criteria andScheduleFreqIn(List<String> values) {
            addCriterion("schedule_freq in", values, "scheduleFreq");
            return (Criteria) this;
        }

        public Criteria andScheduleFreqNotIn(List<String> values) {
            addCriterion("schedule_freq not in", values, "scheduleFreq");
            return (Criteria) this;
        }

        public Criteria andScheduleFreqBetween(String value1, String value2) {
            addCriterion("schedule_freq between", value1, value2, "scheduleFreq");
            return (Criteria) this;
        }

        public Criteria andScheduleFreqNotBetween(String value1, String value2) {
            addCriterion("schedule_freq not between", value1, value2, "scheduleFreq");
            return (Criteria) this;
        }

        public Criteria andRemoteFilePathIsNull() {
            addCriterion("remote_file_path is null");
            return (Criteria) this;
        }

        public Criteria andRemoteFilePathIsNotNull() {
            addCriterion("remote_file_path is not null");
            return (Criteria) this;
        }

        public Criteria andRemoteFilePathEqualTo(String value) {
            addCriterion("remote_file_path =", value, "remoteFilePath");
            return (Criteria) this;
        }

        public Criteria andRemoteFilePathNotEqualTo(String value) {
            addCriterion("remote_file_path <>", value, "remoteFilePath");
            return (Criteria) this;
        }

        public Criteria andRemoteFilePathGreaterThan(String value) {
            addCriterion("remote_file_path >", value, "remoteFilePath");
            return (Criteria) this;
        }

        public Criteria andRemoteFilePathGreaterThanOrEqualTo(String value) {
            addCriterion("remote_file_path >=", value, "remoteFilePath");
            return (Criteria) this;
        }

        public Criteria andRemoteFilePathLessThan(String value) {
            addCriterion("remote_file_path <", value, "remoteFilePath");
            return (Criteria) this;
        }

        public Criteria andRemoteFilePathLessThanOrEqualTo(String value) {
            addCriterion("remote_file_path <=", value, "remoteFilePath");
            return (Criteria) this;
        }

        public Criteria andRemoteFilePathLike(String value) {
            addCriterion("remote_file_path like", value, "remoteFilePath");
            return (Criteria) this;
        }

        public Criteria andRemoteFilePathNotLike(String value) {
            addCriterion("remote_file_path not like", value, "remoteFilePath");
            return (Criteria) this;
        }

        public Criteria andRemoteFilePathIn(List<String> values) {
            addCriterion("remote_file_path in", values, "remoteFilePath");
            return (Criteria) this;
        }

        public Criteria andRemoteFilePathNotIn(List<String> values) {
            addCriterion("remote_file_path not in", values, "remoteFilePath");
            return (Criteria) this;
        }

        public Criteria andRemoteFilePathBetween(String value1, String value2) {
            addCriterion("remote_file_path between", value1, value2, "remoteFilePath");
            return (Criteria) this;
        }

        public Criteria andRemoteFilePathNotBetween(String value1, String value2) {
            addCriterion("remote_file_path not between", value1, value2, "remoteFilePath");
            return (Criteria) this;
        }

        public Criteria andLocalFilePathIsNull() {
            addCriterion("local_file_path is null");
            return (Criteria) this;
        }

        public Criteria andLocalFilePathIsNotNull() {
            addCriterion("local_file_path is not null");
            return (Criteria) this;
        }

        public Criteria andLocalFilePathEqualTo(String value) {
            addCriterion("local_file_path =", value, "localFilePath");
            return (Criteria) this;
        }

        public Criteria andLocalFilePathNotEqualTo(String value) {
            addCriterion("local_file_path <>", value, "localFilePath");
            return (Criteria) this;
        }

        public Criteria andLocalFilePathGreaterThan(String value) {
            addCriterion("local_file_path >", value, "localFilePath");
            return (Criteria) this;
        }

        public Criteria andLocalFilePathGreaterThanOrEqualTo(String value) {
            addCriterion("local_file_path >=", value, "localFilePath");
            return (Criteria) this;
        }

        public Criteria andLocalFilePathLessThan(String value) {
            addCriterion("local_file_path <", value, "localFilePath");
            return (Criteria) this;
        }

        public Criteria andLocalFilePathLessThanOrEqualTo(String value) {
            addCriterion("local_file_path <=", value, "localFilePath");
            return (Criteria) this;
        }

        public Criteria andLocalFilePathLike(String value) {
            addCriterion("local_file_path like", value, "localFilePath");
            return (Criteria) this;
        }

        public Criteria andLocalFilePathNotLike(String value) {
            addCriterion("local_file_path not like", value, "localFilePath");
            return (Criteria) this;
        }

        public Criteria andLocalFilePathIn(List<String> values) {
            addCriterion("local_file_path in", values, "localFilePath");
            return (Criteria) this;
        }

        public Criteria andLocalFilePathNotIn(List<String> values) {
            addCriterion("local_file_path not in", values, "localFilePath");
            return (Criteria) this;
        }

        public Criteria andLocalFilePathBetween(String value1, String value2) {
            addCriterion("local_file_path between", value1, value2, "localFilePath");
            return (Criteria) this;
        }

        public Criteria andLocalFilePathNotBetween(String value1, String value2) {
            addCriterion("local_file_path not between", value1, value2, "localFilePath");
            return (Criteria) this;
        }

        public Criteria andExpectTimeIsNull() {
            addCriterion("expect_time is null");
            return (Criteria) this;
        }

        public Criteria andExpectTimeIsNotNull() {
            addCriterion("expect_time is not null");
            return (Criteria) this;
        }

        public Criteria andExpectTimeEqualTo(Date value) {
            addCriterion("expect_time =", value, "expectTime");
            return (Criteria) this;
        }

        public Criteria andExpectTimeNotEqualTo(Date value) {
            addCriterion("expect_time <>", value, "expectTime");
            return (Criteria) this;
        }

        public Criteria andExpectTimeGreaterThan(Date value) {
            addCriterion("expect_time >", value, "expectTime");
            return (Criteria) this;
        }

        public Criteria andExpectTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("expect_time >=", value, "expectTime");
            return (Criteria) this;
        }

        public Criteria andExpectTimeLessThan(Date value) {
            addCriterion("expect_time <", value, "expectTime");
            return (Criteria) this;
        }

        public Criteria andExpectTimeLessThanOrEqualTo(Date value) {
            addCriterion("expect_time <=", value, "expectTime");
            return (Criteria) this;
        }

        public Criteria andExpectTimeIn(List<Date> values) {
            addCriterion("expect_time in", values, "expectTime");
            return (Criteria) this;
        }

        public Criteria andExpectTimeNotIn(List<Date> values) {
            addCriterion("expect_time not in", values, "expectTime");
            return (Criteria) this;
        }

        public Criteria andExpectTimeBetween(Date value1, Date value2) {
            addCriterion("expect_time between", value1, value2, "expectTime");
            return (Criteria) this;
        }

        public Criteria andExpectTimeNotBetween(Date value1, Date value2) {
            addCriterion("expect_time not between", value1, value2, "expectTime");
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

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
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