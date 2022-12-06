package com.jay.dynamicdatasource.service;

import com.jay.dynamicdatasource.entity.Order;

/**
 * @author Jay Yang
 * @date 2022/12/6
 */
public interface DevDataSourceService {

    Order findById(Long id);

}
