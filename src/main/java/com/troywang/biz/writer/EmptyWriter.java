package com.troywang.biz.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

/**
 * Created by troywang on 2018/5/14.
 */
public class EmptyWriter implements ItemWriter<Object> {

    @Override
    public void write(List<?> items) throws Exception {
        System.out.println("[empty writer] calling empty writer.....");
    }
}
