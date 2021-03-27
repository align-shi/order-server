package com.xiaoshi.mapper;

import com.xiaoshi.domain.Order;

import org.apache.ibatis.annotations.*;

public interface OrderMapper {

    @Insert("insert into of_order(serial_number,desk_id,trade_status,pay_status,order_amount,create_time,create_user)" +
            " values(#{serialNumber},#{deskId},#{tradeStatus},#{payStatus},#{orderAmount},#{createTime},#{username})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    public int  insertOrder(Order order);
}