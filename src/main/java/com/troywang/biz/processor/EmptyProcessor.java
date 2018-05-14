package com.troywang.biz.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

/**
 * Created by troywang on 2018/5/14.
 */
@Component
public class EmptyProcessor implements ItemProcessor<Object, Object> {

    @Override
    public Object process(Object o) throws Exception {
        System.out.println("[empty processor] calling empty processor.....");
        return null;
    }
}
