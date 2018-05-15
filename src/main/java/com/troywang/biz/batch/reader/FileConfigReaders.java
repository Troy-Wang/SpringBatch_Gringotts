package com.troywang.biz.batch.reader;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.Order;
import org.springframework.batch.item.database.PagingQueryProvider;
import org.springframework.batch.item.database.support.SqlPagingQueryProviderFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import com.troywang.base.util.DateUtil;
import com.troywang.biz.model.JobContextModel;
import com.troywang.dal.entity.BatchFileConfigDo;

/**
 * Created by troywang on 2018/5/15.
 */
@Configuration
public class FileConfigReaders {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(FileConfigReaders.class);

    @Bean
    @Scope(value = "step", proxyMode = ScopedProxyMode.INTERFACES)
    public ItemReader<BatchFileConfigDo> fileConfigReader(DataSource dataSource) {
        JdbcPagingItemReader<BatchFileConfigDo> fileConfigReader = new JdbcPagingItemReader<BatchFileConfigDo>();
        fileConfigReader.setDataSource(dataSource);
        fileConfigReader.setQueryProvider(fileConfigQueryProvider(null, null));
        fileConfigReader.setRowMapper(new BeanPropertyRowMapper<BatchFileConfigDo>(BatchFileConfigDo.class));
        fileConfigReader.setPageSize(10);
        return fileConfigReader;
    }

    @Bean
    @Scope(value = "step", proxyMode = ScopedProxyMode.INTERFACES)
    public PagingQueryProvider fileConfigQueryProvider(@Value("#{jobExecutionContext['jobCtx']}") JobContextModel
                                                               ctx, DataSource dataSource) {
        try {
            Map<String, Order> sortKeyMap = new HashMap<String, Order>();
            sortKeyMap.put("id", Order.ASCENDING);

            String whereClause =
                    String.format("where expect_time<='%s'", DateUtil.format(new Date(), DateUtil.LONG_WEB_FORMAT));

            SqlPagingQueryProviderFactoryBean policyInfoQueryProvider = new SqlPagingQueryProviderFactoryBean();
            policyInfoQueryProvider.setDataSource(dataSource);
            policyInfoQueryProvider.setSelectClause("select *");
            policyInfoQueryProvider.setFromClause("from batch_file_config");
            policyInfoQueryProvider.setWhereClause(whereClause);
            policyInfoQueryProvider.setSortKeys(sortKeyMap);
            return policyInfoQueryProvider.getObject();
        } catch (Exception e) {
            logger.error("[file config query provider] error creating queryProvider for Reader..", e);
            return null;
        }
    }
}
