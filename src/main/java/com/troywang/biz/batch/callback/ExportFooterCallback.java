package com.troywang.biz.batch.callback;

import java.io.IOException;
import java.io.Writer;

import org.springframework.batch.item.file.FlatFileFooterCallback;

/**
 * Created by troywang on 2018/5/16.
 */
public class ExportFooterCallback implements FlatFileFooterCallback {

    @Override
    public void writeFooter(Writer writer) throws IOException {
        writer.write("END");
    }
}
