package com.troywang.biz.batch.partitioner;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ExecutionContext;

/**
 * Created by troywang on 2018/5/16.
 */
public class FileProcessPartitioner implements Partitioner {

    private static final Logger logger = LoggerFactory.getLogger(FileProcessPartitioner.class);

    @Override
    public Map<String, ExecutionContext> partition(int i) {
        return null;
    }
}
