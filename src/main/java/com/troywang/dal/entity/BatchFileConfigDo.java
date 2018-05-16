package com.troywang.dal.entity;

import java.util.Date;

public class BatchFileConfigDo {
    private Long id;

    private Byte enabled;

    private String itemId;

    private String scheduleFreq;

    private String remoteFilePath;

    private String localFilePath;

    private Date expectTime;

    private String extension;

    private String description;

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

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId == null ? null : itemId.trim();
    }

    public String getScheduleFreq() {
        return scheduleFreq;
    }

    public void setScheduleFreq(String scheduleFreq) {
        this.scheduleFreq = scheduleFreq == null ? null : scheduleFreq.trim();
    }

    public String getRemoteFilePath() {
        return remoteFilePath;
    }

    public void setRemoteFilePath(String remoteFilePath) {
        this.remoteFilePath = remoteFilePath == null ? null : remoteFilePath.trim();
    }

    public String getLocalFilePath() {
        return localFilePath;
    }

    public void setLocalFilePath(String localFilePath) {
        this.localFilePath = localFilePath == null ? null : localFilePath.trim();
    }

    public Date getExpectTime() {
        return expectTime;
    }

    public void setExpectTime(Date expectTime) {
        this.expectTime = expectTime;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension == null ? null : extension.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
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