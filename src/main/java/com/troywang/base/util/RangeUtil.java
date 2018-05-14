package com.troywang.base.util;

import org.springframework.batch.item.file.transform.Range;

/**
 * generate ranges for spring-batch fixed-length readers
 * Created by troywang on 2018/5/14.
 */
public class RangeUtil {

    /**
     * @param fieldsLen e.g. 16,32,8
     *
     * @return
     */
    public static Range[] genRangesByFieldsLen(int[] fieldsLen) {
        Range[] ranges = new Range[fieldsLen.length];
        int current = 0;
        for (int i = 0; i < fieldsLen.length; i++) {
            ranges[i] = new Range(current + 1, current + fieldsLen[i]);
            current = current + fieldsLen[i];
        }
        return ranges;
    }
}
