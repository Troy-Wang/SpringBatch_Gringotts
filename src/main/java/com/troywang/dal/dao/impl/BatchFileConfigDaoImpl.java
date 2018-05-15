package com.troywang.dal.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.troywang.dal.dao.BatchFileConfigDao;
import com.troywang.dal.dao.condition.BatchFileConfigCondition;
import com.troywang.dal.entity.BatchFileConfigDo;
import com.troywang.dal.entity.BatchFileConfigDoExample;
import com.troywang.dal.mapper.BatchFileConfigDoMapper;

/**
 * Created by troywang on 2018/5/15.
 */
@Repository
public class BatchFileConfigDaoImpl implements BatchFileConfigDao {

    @Autowired
    private BatchFileConfigDoMapper batchFileConfigDoMapper;

    @Override
    public boolean updateByCondition(BatchFileConfigDo record, BatchFileConfigCondition condition) {
        return 1 <= batchFileConfigDoMapper.updateByExampleSelective(record, prepareExample(condition));
    }

    private BatchFileConfigDoExample prepareExample(BatchFileConfigCondition condition) {
        BatchFileConfigDoExample example = new BatchFileConfigDoExample();
        BatchFileConfigDoExample.Criteria criteria = example.createCriteria();
        if (condition.getId() != null) {
            criteria.andIdEqualTo(condition.getId());
        }
        return example;
    }
}
