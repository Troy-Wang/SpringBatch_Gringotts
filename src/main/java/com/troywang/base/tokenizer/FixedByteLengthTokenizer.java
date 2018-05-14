package com.troywang.base.tokenizer;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.codec.binary.StringUtils;
import org.springframework.batch.item.file.transform.AbstractLineTokenizer;
import org.springframework.batch.item.file.transform.IncorrectLineLengthException;
import org.springframework.batch.item.file.transform.Range;

/**
 * A custom tokenizer with encoding-support. Can be used to tokenize Chinese characters.
 * Created by troywang on 2018/5/14.
 */
public class FixedByteLengthTokenizer extends AbstractLineTokenizer {
    private Range[] ranges;
    private int maxRange = 0;
    boolean open = false;
    private String encoding;

    public FixedByteLengthTokenizer() {
    }

    public void setColumns(Range[] ranges) {
        this.ranges = (Range[]) Arrays.asList(ranges).toArray(new Range[ranges.length]);
        this.calculateMaxRange(ranges);
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    private void calculateMaxRange(Range[] ranges) {
        if (ranges != null && ranges.length != 0) {
            this.open = false;
            this.maxRange = ranges[0].getMin();

            for (int i = 0; i < ranges.length; ++i) {
                int upperBound;
                if (ranges[i].hasMaxValue()) {
                    upperBound = ranges[i].getMax();
                } else {
                    upperBound = ranges[i].getMin();
                    if (upperBound > this.maxRange) {
                        this.open = true;
                    }
                }

                if (upperBound > this.maxRange) {
                    this.maxRange = upperBound;
                }
            }

        } else {
            this.maxRange = 0;
        }
    }

    protected List<String> doTokenize(String line) {
        ArrayList tokens = new ArrayList(this.ranges.length);
        int lineLength;
        try {
            lineLength = line.getBytes(this.encoding).length;
        } catch (Exception e) {
            return null;
        }
        if (lineLength < this.maxRange && this.isStrict()) {
            throw new IncorrectLineLengthException("FixedByteLengthTokenizer, Line is shorter than max range "
                    + this.maxRange, this.maxRange, lineLength, line);
        } else if (!this.open && lineLength > this.maxRange && this.isStrict()) {
            throw new IncorrectLineLengthException("FixedByteLengthTokenizer, Line is longer than max range "
                    + this.maxRange, this.maxRange, lineLength, line);
        } else {
            for (int i = 0; i < this.ranges.length; ++i) {
                int startPos = this.ranges[i].getMin() - 1;
                int endPos = this.ranges[i].getMax();
                String token;
                if (lineLength >= endPos) {
                    token = subStringByByte(line, startPos, endPos);
                } else if (lineLength >= startPos) {
                    token = subStringByByte(line, startPos, lineLength);
                } else {
                    token = "";
                }

                tokens.add(token);
            }

            return tokens;
        }
    }

    private String subStringByByte(String str, int start, int end) {
        try {
            return new String(Arrays.copyOfRange(StringUtils.getBytesUnchecked(str, this.encoding), start, end),
                    this.encoding);
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }
}
