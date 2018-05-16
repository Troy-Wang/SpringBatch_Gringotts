package com.troywang.biz.batch.callback;

import java.io.IOException;
import java.io.Writer;

import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.listener.StepExecutionListenerSupport;
import org.springframework.batch.item.file.FlatFileFooterCallback;

/**
 * Created by troywang on 2018/5/16.
 */
public class ExportFooterCallback extends StepExecutionListenerSupport implements FlatFileFooterCallback {

    private StepExecution stepExecution;

    @Override
    public void beforeStep(StepExecution stepExecution) {
        this.stepExecution = stepExecution;
    }

    @Override
    public void writeFooter(Writer writer) throws IOException {
        writer.write("Total:" + stepExecution.getWriteCount());
    }
}
