package com.troywang.dal.dao;

import com.troywang.dal.dao.condition.BatchFileConfigCondition;
import com.troywang.dal.entity.BatchFileConfigDo;

/**
 * Created by troywang on 2018/5/15.
 */
public interface BatchFileConfigDao {

    boolean updateByCondition(BatchFileConfigDo record, BatchFileConfigCondition condition);
}
