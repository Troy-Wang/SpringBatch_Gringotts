package com.troywang.dal.dao.condition;

import java.util.List;

/**
 * Created by troywang on 2018/5/15.
 */
public class BatchScheduleCondition {

    private String scheduleNo;

    private List<String> scheduleStatus;

    public String getScheduleNo() {
        return scheduleNo;
    }

    public void setScheduleNo(String scheduleNo) {
        this.scheduleNo = scheduleNo;
    }

    public List<String> getScheduleStatus() {
        return scheduleStatus;
    }

    public void setScheduleStatus(List<String> scheduleStatus) {
        this.scheduleStatus = scheduleStatus;
    }

}
