package com.jay.dynamicdatasource.mapper;

/**
 * @author Jay Yang
 * @date 2022/12/6
 */

import com.jay.dynamicdatasource.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface OrderMapper {

    @Select("select id, `number` from `order` where id = #{id}")
    Order findById(@Param("id") Long id);

}
