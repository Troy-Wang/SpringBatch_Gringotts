package com.troywang.biz.enums;

/**
 * Created by troywang on 2018/5/15.
 */
public enum ScheduleStatusEnum {

    INITIAL("Initial", "初始化"),

    COMPLETE("Complete", "完成"),;

    private String status;
    private String desc;

    ScheduleStatusEnum(String status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
