package com.troywang.base.aggregator;

import java.io.UnsupportedEncodingException;
import java.util.Locale;

import org.springframework.batch.item.file.transform.ExtractorLineAggregator;
import org.springframework.util.Assert;

/**
 * A custom line aggregator with encoding-support. Can be used for Chinese character.
 * Created by troywang on 2018/5/14.
 */
public class FormatterByteLineAggregator<T> extends ExtractorLineAggregator<T> {

    private String format;
    private Locale locale = Locale.getDefault();
    private int maximumLength = 0;
    private int minimumLength = 0;
    private String encoding;

    public FormatterByteLineAggregator() {
    }

    public void setMinimumLength(int minimumLength) {
        this.minimumLength = minimumLength;
    }

    public void setMaximumLength(int maximumLength) {
        this.maximumLength = maximumLength;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    protected String doAggregate(Object[] fields) {
        Assert.notNull(this.format);
        String value = formatByByte(this.format, fields);
        if (this.maximumLength > 0) {
            Assert.state(value.length() <= this.maximumLength,
                    String.format("String overflowed in formatter - longer than %d characters: [%s",
                            new Object[] {Integer.valueOf(this.maximumLength), value}));
        }

        if (this.minimumLength > 0) {
            Assert.state(value.length() >= this.minimumLength,
                    String.format("String underflowed in formatter - shorter than %d characters: [%s",
                            new Object[] {Integer.valueOf(this.minimumLength), value}));
        }

        return value;
    }

    private String formatByByte(String format, Object[] fields) {
        try {
            for (int i = 0; i < fields.length; i++) {
                if (fields[i] instanceof String) {
                    fields[i] = new String(String.valueOf(fields[i]).getBytes(this.encoding), "ISO-8859-1");
                }
            }
            String strISO = String.format(this.locale, format, fields);
            return new String(strISO.getBytes("ISO-8859-1"), this.encoding);
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }
}
