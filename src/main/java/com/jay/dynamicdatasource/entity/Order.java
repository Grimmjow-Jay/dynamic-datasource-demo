package com.jay.dynamicdatasource.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Jay Yang
 * @date 2022/12/6
 */
@Data
public class Order implements Serializable {

    private Long id;

    private String number;

}
