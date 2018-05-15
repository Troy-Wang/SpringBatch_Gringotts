package com.troywang.biz.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by troywang on 2018/5/15.
 */
public enum ScheduleTypeEnum {

    EVERYDAY("everyday", "everyday"),

    WORKDAY("workday", "only workday"),;

    private String type;
    private String desc;

    ScheduleTypeEnum(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static ScheduleTypeEnum getScheduleType(String type) {
        for (ScheduleTypeEnum scheduleTypeEnum : values()) {
            if (StringUtils.equals(scheduleTypeEnum.getType(), type)) {
                return scheduleTypeEnum;
            }
        }
        return null;
    }
}
