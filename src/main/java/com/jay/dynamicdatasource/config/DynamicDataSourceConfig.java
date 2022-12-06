package com.jay.dynamicdatasource.config;

import com.zaxxer.hikari.HikariDataSource;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jay Yang
 * @date 2022/12/6
 */
@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
public class DynamicDataSourceConfig {

    @Getter
    @Setter
    private Map<String, HikariDataSourceProperties> multiDataSources = new HashMap<>();

    @Bean("dataSource")
    public DynamicRoutingDataSource dataSource() {

        DynamicRoutingDataSource dataSource = new DynamicRoutingDataSource();

        Map<Object, Object> dataSourceMap = new HashMap<>();
        multiDataSources.forEach((profile, dataSourceProperties) -> {

            HikariDataSource hikariDataSource = dataSourceProperties
                    .initializeDataSourceBuilder()
                    .type(HikariDataSource.class)
                    .build();

            dataSourceMap.put(profile, hikariDataSource);

            if (dataSourceProperties.isPrimary()) {
                dataSource.setDefaultTargetDataSource(hikariDataSource);
            }
        });

        dataSource.setTargetDataSources(dataSourceMap);

        return dataSource;
    }

    @Data
    @EqualsAndHashCode(callSuper = false)
    public static class HikariDataSourceProperties extends DataSourceProperties {

        private boolean primary = false;
        private boolean readOnly = false;

    }

    public static class DynamicRoutingDataSource extends AbstractRoutingDataSource {

        @Override
        protected Object determineCurrentLookupKey() {
            String currentDataSource = DynamicDataSourceHolder.getCurrentDataSource();
            if (currentDataSource == null || currentDataSource.trim().length() == 0) {
                return null;
            }
            return currentDataSource;
        }
    }

}
