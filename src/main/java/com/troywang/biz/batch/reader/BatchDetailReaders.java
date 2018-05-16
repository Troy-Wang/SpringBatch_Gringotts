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
import com.troywang.dal.entity.BatchDetailDo;

/**
 * readers for reading batch details
 * Created by troywang on 2018/5/16.
 */
@Configuration
public class BatchDetailReaders {

    private static final Logger logger = LoggerFactory.getLogger(BatchDetailReaders.class);

    @Bean
    @Scope(value = "step", proxyMode = ScopedProxyMode.INTERFACES)
    public ItemReader<BatchDetailDo> batchDetailReader(DataSource dataSource) {
        JdbcPagingItemReader<BatchDetailDo> batchDetailReader = new JdbcPagingItemReader<BatchDetailDo>();
        batchDetailReader.setDataSource(dataSource);
        batchDetailReader.setQueryProvider(batchDetailQueryProvider(null, null));
        batchDetailReader.setRowMapper(new BeanPropertyRowMapper<BatchDetailDo>(BatchDetailDo.class));
        batchDetailReader.setPageSize(10);
        return batchDetailReader;
    }

    @Bean
    @Scope(value = "step", proxyMode = ScopedProxyMode.INTERFACES)
    public PagingQueryProvider batchDetailQueryProvider(@Value("#{jobExecutionContext['jobCtx']}") JobContextModel
                                                                ctx, DataSource dataSource) {
        try {
            Map<String, Order> sortKeyMap = new HashMap<String, Order>();
            sortKeyMap.put("id", Order.ASCENDING);

            String whereClause =
                    String.format("where create_time<='%s'", DateUtil.format(new Date(), DateUtil.LONG_WEB_FORMAT));

            SqlPagingQueryProviderFactoryBean policyInfoQueryProvider = new SqlPagingQueryProviderFactoryBean();
            policyInfoQueryProvider.setDataSource(dataSource);
            policyInfoQueryProvider.setSelectClause("select *");
            policyInfoQueryProvider.setFromClause("from batch_detail");
            policyInfoQueryProvider.setWhereClause(whereClause);
            policyInfoQueryProvider.setSortKeys(sortKeyMap);
            return policyInfoQueryProvider.getObject();
        } catch (Exception e) {
            logger.error("[batch detail query provider] error creating queryProvider for Reader..", e);
            return null;
        }
    }
}
