package com.troywang.biz.reader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

/**
 * Created by troywang on 2018/5/14.
 */
public class EmptyReader implements ItemReader<Object> {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(EmptyReader.class);

    @Override
    public Object read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        logger.info("[empty reader] calling empty reader.....");
        return null;
    }
}
