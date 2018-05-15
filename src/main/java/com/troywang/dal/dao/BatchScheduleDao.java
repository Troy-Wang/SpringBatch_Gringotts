package com.troywang.dal.dao;

import com.troywang.dal.dao.condition.BatchScheduleCondition;
import com.troywang.dal.entity.BatchScheduleDo;

/**
 * Created by troywang on 2018/5/15.
 */
public interface BatchScheduleDao {

    boolean insertSchedule(BatchScheduleDo record);

    boolean updateByCondition(BatchScheduleDo batchScheduleDo, BatchScheduleCondition condition);
}
