package com.troywang.biz.batch.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.troywang.dal.dao.BatchFileConfigDao;
import com.troywang.dal.dao.BatchScheduleDao;
import com.troywang.dal.entity.BatchScheduleDo;

/**
 * Created by troywang on 2018/5/15.
 */
@Component
public class ScheduleCreateWriter implements ItemWriter<BatchScheduleDo> {

    @Autowired
    private BatchFileConfigDao batchFileConfigDao;

    @Autowired
    private BatchScheduleDao batchScheduleDao;

    @Override
    public void write(List<? extends BatchScheduleDo> list) throws Exception {

    }
}
