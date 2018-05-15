package com.troywang.dal.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.troywang.dal.dao.BatchScheduleDao;
import com.troywang.dal.dao.condition.BatchScheduleCondition;
import com.troywang.dal.entity.BatchScheduleDo;
import com.troywang.dal.mapper.BatchScheduleDoMapper;

/**
 * Created by troywang on 2018/5/15.
 */
@Repository
public class BatchScheduleDaoImpl implements BatchScheduleDao {

    @Autowired
    private BatchScheduleDoMapper batchScheduleDoMapper;

    @Override
    public boolean insertSchedule(BatchScheduleDo record) {
        return 1 == batchScheduleDoMapper.insertSelective(record);
    }

    @Override
    public boolean updateByCondition(BatchScheduleDo batchScheduleDo, BatchScheduleCondition condition) {
        return false;
    }
}
