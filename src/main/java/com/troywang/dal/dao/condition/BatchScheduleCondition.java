package com.troywang.dal.dao.condition;

import java.util.List;

/**
 * Created by troywang on 2018/5/15.
 */
public class BatchScheduleCondition {

    private List<String> scheduleStatus;

    public List<String> getScheduleStatus() {
        return scheduleStatus;
    }

    public void setScheduleStatus(List<String> scheduleStatus) {
        this.scheduleStatus = scheduleStatus;
    }

    @Override
    public String toString() {
        return "BatchScheduleCondition{" +
                "scheduleStatus=" + scheduleStatus +
                '}';
    }
}
