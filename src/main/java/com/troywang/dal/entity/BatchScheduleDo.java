package com.troywang.dal.entity;

import java.util.Date;

public class BatchScheduleDo {
    private Long id;

    private Byte enabled;

    private Long configId;

    private String scheduleNo;

    private String scheduleDate;

    private String scheduleStatus;

    private String memo;

    private Long totalCount;

    private Long excpCount;

    private String extension;

    private Date createTime;

    private Date modifyTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Byte getEnabled() {
        return enabled;
    }

    public void setEnabled(Byte enabled) {
        this.enabled = enabled;
    }

    public Long getConfigId() {
        return configId;
    }

    public void setConfigId(Long configId) {
        this.configId = configId;
    }

    public String getScheduleNo() {
        return scheduleNo;
    }

    public void setScheduleNo(String scheduleNo) {
        this.scheduleNo = scheduleNo == null ? null : scheduleNo.trim();
    }

    public String getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(String scheduleDate) {
        this.scheduleDate = scheduleDate == null ? null : scheduleDate.trim();
    }

    public String getScheduleStatus() {
        return scheduleStatus;
    }

    public void setScheduleStatus(String scheduleStatus) {
        this.scheduleStatus = scheduleStatus == null ? null : scheduleStatus.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public Long getExcpCount() {
        return excpCount;
    }

    public void setExcpCount(Long excpCount) {
        this.excpCount = excpCount;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension == null ? null : extension.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}