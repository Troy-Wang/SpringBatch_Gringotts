package com.troywang.biz.batch.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.troywang.base.util.DateUtil;
import com.troywang.biz.model.BatchDetailExportModel;
import com.troywang.dal.entity.BatchDetailDo;

/**
 * Created by troywang on 2018/5/16.
 */
@Component
public class BatchDetailExportProcessor implements ItemProcessor<BatchDetailDo, BatchDetailExportModel> {

    private static final Logger logger = LoggerFactory.getLogger(BatchDetailExportProcessor.class);

    @Override
    public BatchDetailExportModel process(BatchDetailDo batchDetailDo) throws Exception {
        BatchDetailExportModel exportModel = new BatchDetailExportModel();
        exportModel.setCreateTime(DateUtil.format(batchDetailDo.getCreateTime(), DateUtil.LONG_FORMAT));
        exportModel.setRecordNo(batchDetailDo.getRecordNo());
        exportModel.setUserId(batchDetailDo.getUserId());
        exportModel.setRecordState(batchDetailDo.getRecordState());
        return exportModel;
    }
}
