package com.troywang.biz.batch.writer;

import java.util.Date;
import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.troywang.base.enums.GringottsErrorCodeEnum;
import com.troywang.base.exception.GringottsRetryableException;
import com.troywang.base.util.DateUtil;
import com.troywang.dal.dao.BatchFileConfigDao;
import com.troywang.dal.dao.BatchScheduleDao;
import com.troywang.dal.dao.condition.BatchFileConfigCondition;
import com.troywang.dal.entity.BatchFileConfigDo;
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
        for (BatchScheduleDo request : list) {
            // insert a new batch_schedule record
            BatchScheduleDo batchScheduleDo = new BatchScheduleDo();
            batchScheduleDo.setScheduleStatus(request.getScheduleStatus());
            batchScheduleDo.setEnabled(request.getEnabled());
            batchScheduleDo.setModifyTime(request.getModifyTime());
            batchScheduleDo.setCreateTime(request.getCreateTime());
            batchScheduleDo.setConfigId(request.getId());
            batchScheduleDo.setScheduleNo(request.getScheduleNo());
            batchScheduleDo.setScheduleDate(request.getScheduleDate());
            batchScheduleDo.setExtension(request.getExtension());
            batchScheduleDo.setMemo("");
            handleRet(batchScheduleDao.insertSchedule(batchScheduleDo));

            // update expect_time of batch_file_config
            BatchFileConfigDo batchFileConfigDo = new BatchFileConfigDo();
            Date newExpectDate = DateUtil.addDays(DateUtil.parse(request.getScheduleDate(), DateUtil.SHORT_FORMAT), 1);
            batchFileConfigDo.setExpectTime(newExpectDate);
            batchFileConfigDo.setModifyTime(new Date());
            BatchFileConfigCondition batchFileConfigCondition = new BatchFileConfigCondition();
            batchFileConfigCondition.setId(request.getConfigId());
            handleRet(batchFileConfigDao.updateByCondition(batchFileConfigDo, batchFileConfigCondition));
        }
    }

    /**
     * handle the result of database operation
     *
     * @param ret
     */
    private void handleRet(boolean ret) {
        if (!ret) {
            throw new GringottsRetryableException(GringottsErrorCodeEnum.DATABASE_OPERATION_ERROR);
        }
    }
}
