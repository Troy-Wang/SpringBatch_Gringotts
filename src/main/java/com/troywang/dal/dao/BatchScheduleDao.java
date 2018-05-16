package com.troywang.dal.dao;

import java.util.List;

import com.troywang.dal.dao.condition.BatchScheduleCondition;
import com.troywang.dal.entity.BatchScheduleDo;

/**
 * Created by troywang on 2018/5/15.
 */
public interface BatchScheduleDao {

    boolean insertSchedule(BatchScheduleDo record);

    List<BatchScheduleDo> queryByCondition(BatchScheduleCondition condition);

    boolean updateScheduleStatus(String scheduleNo, String toState, String memo);

    boolean updateByCondition(BatchScheduleDo batchScheduleDo, BatchScheduleCondition condition);
}
