package com.longfei.multi_datasource.multi;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 数据源配置类
 * @author wei
 * @date 2020/9/5 10:00 下午
 */
@Configuration
public class DataSourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.remote")
    public DataSource remoteDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.local")
    public DataSource localDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name="dynamicDataSource")
    @Primary
    public DynamicDataSource dataSource(DataSource remoteDataSource, DataSource localDataSource){
        Map<Object, Object> targetDataSource = new HashMap<>(2);
        targetDataSource.put(DataSourceType.REMOTE.name(), remoteDataSource);
        targetDataSource.put(DataSourceType.LOCAL.name(), localDataSource);
        return new DynamicDataSource(localDataSource, targetDataSource);
    }
}
