package com.troywang.biz.batch.partitioner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.troywang.base.util.JsonUtil;
import com.troywang.biz.enums.ScheduleStatusEnum;
import com.troywang.dal.dao.BatchScheduleDao;
import com.troywang.dal.dao.condition.BatchScheduleCondition;
import com.troywang.dal.entity.BatchScheduleDo;

/**
 * Created by troywang on 2018/5/16.
 */
public class FileProcessPartitioner implements Partitioner {

    private static final Logger logger = LoggerFactory.getLogger(FileProcessPartitioner.class);

    @Autowired
    private BatchScheduleDao batchScheduleDao;

    @Override
    public Map<String, ExecutionContext> partition(int gridSize) {
        BatchScheduleCondition condition = new BatchScheduleCondition();
        List<String> statusList = new ArrayList<String>();
        statusList.add(ScheduleStatusEnum.INITIAL.getStatus());
        condition.setScheduleStatus(statusList);
        List<BatchScheduleDo> batchScheduleDos = batchScheduleDao.queryByCondition(condition);

        logger.info("[file process partitioner] grid size={}, files={}", gridSize, batchScheduleDos.size());

        Map<String, ExecutionContext> map = new HashMap<String, ExecutionContext>();
        int i = 0;
        for (BatchScheduleDo batchScheduleDo : batchScheduleDos) {
            ExecutionContext context = new ExecutionContext();
            String file = JsonUtil.readJson2Map(batchScheduleDo.getExtension()).get("filePath");
            String itemId = JsonUtil.readJson2Map(batchScheduleDo.getExtension()).get("itemId");
            context.putString("file", file);
            context.putString("itemId", itemId);
            context.putString("scheduleNo", batchScheduleDo.getScheduleNo());
            map.put("partition" + i, context);
            i++;
        }
        return map;
    }
}
