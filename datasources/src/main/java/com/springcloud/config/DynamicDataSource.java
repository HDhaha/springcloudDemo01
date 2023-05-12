package com.springcloud.config;

import com.springcloud.util.DataSourceUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author: HD
 * @create: 2023/5/12
 * @remark:
 */
@Slf4j
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        log.info("动态获取数据源——{}", DataSourceUtil.getDB());
        return DataSourceUtil.getDB();
    }
}
