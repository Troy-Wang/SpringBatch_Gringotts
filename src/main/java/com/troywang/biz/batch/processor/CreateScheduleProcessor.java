package com.troywang.biz.batch.processor;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.troywang.base.util.DateUtil;
import com.troywang.base.util.JsonUtil;
import com.troywang.biz.enums.ScheduleStatusEnum;
import com.troywang.dal.entity.BatchFileConfigDo;
import com.troywang.dal.entity.BatchScheduleDo;

/**
 * create a new schedule record
 * Created by troywang on 2018/5/15.
 */
@Component
public class CreateScheduleProcessor implements ItemProcessor<BatchFileConfigDo, BatchScheduleDo> {

    private static final Logger logger = LoggerFactory.getLogger(CreateScheduleProcessor.class);

    @Override
    public BatchScheduleDo process(BatchFileConfigDo item) throws Exception {
        BatchScheduleDo request = new BatchScheduleDo();
        String scheduleDate = DateUtil.format(item.getExpectTime(), DateUtil.SHORT_FORMAT);
        request.setScheduleDate(scheduleDate);
        request.setScheduleNo(item.getDescription() + scheduleDate);
        request.setConfigId(item.getId());
        request.setEnabled(new Byte("1"));
        request.setScheduleStatus(ScheduleStatusEnum.INITIAL.getStatus());
        request.setCreateTime(new Date());
        request.setModifyTime(new Date());
        Map<String, String> extensionMap = new HashMap<String, String>();
        String filePath = item.getLocalFilePath().replace("YYYYMMDD", scheduleDate);
        extensionMap.put("filePath", filePath);
        extensionMap.put("itemId", item.getItemId());
        request.setExtension(JsonUtil.writeMap2JsonString(extensionMap));
        logger.info("[create schedule processor] request={}", request);
        return request;
    }
}
