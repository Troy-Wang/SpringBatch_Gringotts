package com.troywang.biz.model;

/**
 * Created by troywang on 2018/5/16.
 */
public class BatchDetailExportModel {

    private String userId;

    private String recordNo;

    private String recordState;

    private String createTime;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRecordNo() {
        return recordNo;
    }

    public void setRecordNo(String recordNo) {
        this.recordNo = recordNo;
    }

    public String getRecordState() {
        return recordState;
    }

    public void setRecordState(String recordState) {
        this.recordState = recordState;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "BatchDetailExportModel{" +
                "userId='" + userId + '\'' +
                ", recordNo='" + recordNo + '\'' +
                ", recordState='" + recordState + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
