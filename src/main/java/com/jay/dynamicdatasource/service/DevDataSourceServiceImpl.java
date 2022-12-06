package com.jay.dynamicdatasource.service;

import com.jay.dynamicdatasource.annotation.DataSourceSelect;
import com.jay.dynamicdatasource.entity.Order;
import com.jay.dynamicdatasource.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Jay Yang
 * @date 2022/12/6
 */
@Service
@RequiredArgsConstructor
public class DevDataSourceServiceImpl implements DevDataSourceService {

    private final OrderMapper orderMapper;

    @Override
    @DataSourceSelect("default")
    public Order findById(Long id) {
        return orderMapper.findById(id);
    }

}
