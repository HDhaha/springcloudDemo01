package com.springcloud.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: HD
 * @create: 2023/5/12
 * @remark:
 */
@Configuration
//@MapperScan(basePackages = {"com.ganhuoshitang.multipledatasources.mapper.db1"}, sqlSessionFactoryRef = "sqlSessionFactory1")
public class DataSourceConfig {

    /**
     * 数据源1
     * spring.datasource.db1：application.properteis中对应属性的前缀
     * @return
     */
    @Bean(name = "db1")
    @ConfigurationProperties(prefix = "spring.datasource.db1")
    public DataSource dataSourceOne() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 数据源2
     * spring.datasource.db2：application.properteis中对应属性的前缀
     * @return
     */
    @Bean(name = "db2")
    @ConfigurationProperties(prefix = "spring.datasource.db2")
    public DataSource dataSourceTwo() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 动态数据源: 通过AOP在不同数据源之间动态切换
     * @return
     */
    @Bean(name = "dynamicDataSource")
    @Primary
    public DataSource dynamicDataSource(@Qualifier("db1") DataSource db1, @Qualifier("db2") DataSource db2) {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        // 默认数据源
        dynamicDataSource.setDefaultTargetDataSource(db1);
        // 配置多数据源
        Map<Object, Object> dsMap = new HashMap<>();
        dsMap.put("db1", db1);
        dsMap.put("db2", db2);

        dynamicDataSource.setTargetDataSources(dsMap);
        return dynamicDataSource;
    }

    /**
     * 配置@Transactional注解
     * @return
     */
    @Bean
    public PlatformTransactionManager transactionManager(@Qualifier("dynamicDataSource") DataSource dynamicDataSource) {
        return new DataSourceTransactionManager(dynamicDataSource);
    }
}