package com.troywang.biz.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

/**
 * Created by troywang on 2018/5/14.
 */
@Component
public class EmptyProcessor implements ItemProcessor<Object, Object> {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(EmptyProcessor.class);

    @Override
    public Object process(Object o) throws Exception {
        logger.info("[empty processor] calling empty processor.....");
        return null;
    }
}
