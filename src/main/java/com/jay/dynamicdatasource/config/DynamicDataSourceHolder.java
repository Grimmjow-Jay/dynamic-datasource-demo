package com.jay.dynamicdatasource.config;

import org.springframework.core.NamedThreadLocal;

/**
 * @author Jay Yang
 * @date 2022/12/6
 */
public class DynamicDataSourceHolder {

    private static final ThreadLocal<String> currentDataSource =
            new NamedThreadLocal<>("Current data source");

    private DynamicDataSourceHolder() {
    }

    public static String getCurrentDataSource() {
        return currentDataSource.get();
    }

    public static void setCurrentDataSource(String profile) {
        currentDataSource.set(profile);
    }

    public static void remove() {
        currentDataSource.remove();
    }

}
