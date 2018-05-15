package com.troywang.biz.batch.writer;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;

/**
 * Created by troywang on 2018/5/14.
 */
public class EmptyWriter implements ItemWriter<Object> {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(EmptyWriter.class);

    @Override
    public void write(List<?> items) throws Exception {
        logger.info("[empty writer] calling empty writer.....");
    }
}
