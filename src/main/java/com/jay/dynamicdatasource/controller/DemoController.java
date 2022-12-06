package com.jay.dynamicdatasource.controller;

import com.jay.dynamicdatasource.entity.Order;
import com.jay.dynamicdatasource.service.DefaultDataSourceService;
import com.jay.dynamicdatasource.service.DevDataSourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jay Yang
 * @date 2022/12/6
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/demo")
public class DemoController {

    private final DefaultDataSourceService defaultDataSourceService;
    private final DevDataSourceService devDataSourceService;

    @GetMapping("/find-order-by-id")
    public Map<String, Order> findOrderById(Long orderId) {

        Order defaultOrder = defaultDataSourceService.findById(orderId);
        Order devOrder = devDataSourceService.findById(orderId);

        Map<String, Order> orderMap = new HashMap<>();
        orderMap.put("default", defaultOrder);
        orderMap.put("dev", devOrder);

        return orderMap;
    }

}
