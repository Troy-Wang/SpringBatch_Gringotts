package com.troywang.biz.batch.writer;

import java.io.IOException;
import java.io.Writer;

import org.springframework.batch.core.StepExecution;
import org.springframework.batch.item.file.FlatFileFooterCallback;
import org.springframework.batch.item.file.FlatFileHeaderCallback;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.ResourceAwareItemWriterItemStream;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.io.FileSystemResource;

import com.troywang.base.aggregator.FormatterByteLineAggregator;
import com.troywang.base.util.ClassUtil;
import com.troywang.biz.model.BatchDetailExportModel;

/**
 * Created by troywang on 2018/5/16.
 */
@Configuration
public class FileWriters {

    @Bean
    @Scope(value = "step", proxyMode = ScopedProxyMode.INTERFACES)
    public ResourceAwareItemWriterItemStream<BatchDetailExportModel> batchDetailExportWriter(
            @Value("#{stepExecutionContext['file']}") String file) {
        FlatFileItemWriter<BatchDetailExportModel> writer = new FlatFileItemWriter<BatchDetailExportModel>();
        writer.setResource(new FileSystemResource(file));
        writer.setEncoding("utf-8");
        writer.setLineAggregator(batchDetailExportAggregator());
        writer.setShouldDeleteIfEmpty(false);
        writer.setShouldDeleteIfExists(true);
        writer.setHeaderCallback(exportHeaderCallback());
        writer.setFooterCallback(exportFooterCallback(null));
        return writer;
    }

    @Bean
    @Scope(value = "step", proxyMode = ScopedProxyMode.INTERFACES)
    public FlatFileHeaderCallback exportHeaderCallback() {
        return new FlatFileHeaderCallback() {
            @Override
            public void writeHeader(Writer writer) throws IOException {
                writer.write("START");
            }
        };
    }

    @Bean
    @Scope(value = "step", proxyMode = ScopedProxyMode.INTERFACES)
    public FlatFileFooterCallback exportFooterCallback(@Value("#{stepExecution}") final StepExecution context) {
        return new FlatFileFooterCallback() {
            @Override
            public void writeFooter(Writer writer) throws IOException {
                writer.append("count: ").append(String.valueOf(context.getWriteCount()));
            }
        };
    }

    @Bean
    public FormatterByteLineAggregator<BatchDetailExportModel> batchDetailExportAggregator() {
        BeanWrapperFieldExtractor<BatchDetailExportModel> fieldExtractor =
                new BeanWrapperFieldExtractor<BatchDetailExportModel>();
        fieldExtractor.setNames(ClassUtil.getClassMemberList(BatchDetailExportModel.class));

        FormatterByteLineAggregator<BatchDetailExportModel> aggregator =
                new FormatterByteLineAggregator<BatchDetailExportModel>();
        aggregator.setEncoding("utf-8");
        aggregator.setFieldExtractor(fieldExtractor);
        aggregator.setFormat("%-32s%-32s%-2s%-32s");
        aggregator.setEncoding("utf8");
        return aggregator;
    }

}
