package com.jay.dynamicdatasource.service;

import com.jay.dynamicdatasource.annotation.DataSourceSelect;
import com.jay.dynamicdatasource.entity.Order;
import com.jay.dynamicdatasource.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Jay Yang
 * @date 2022/12/6
 */
@Service
@RequiredArgsConstructor
public class DefaultDataSourceServiceImpl implements DefaultDataSourceService {

    private final OrderMapper orderMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    @DataSourceSelect("dev")
    public Order findById(Long id) {
        orderMapper.findById(id);

        return orderMapper.findById(id);
    }

}
