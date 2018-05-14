package com.troywang.biz.reader;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

/**
 * Created by troywang on 2018/5/14.
 */
public class EmptyReader implements ItemReader<Object> {

    @Override
    public Object read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        System.out.println("[empty reader] calling empty reader.....");
        return null;
    }
}
