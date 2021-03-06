package com.xiaoshi.mapper;

import com.xiaoshi.domain.OrderDetail;

import java.util.List;

import com.xiaoshi.domain.Product;
import org.apache.ibatis.annotations.*;

public interface OrderDetailMapper {

    @Select("<script>" +
            "select * from of_order_detail where id in"+
            "<foreach collection='array' item='id' open='(' separator=',' close=')'>#{id}</foreach>"+
            "</script>")
    public List<OrderDetail> getOrderDetailByIds(Integer[] ids);

    @Insert("insert into of_order_detail(order_id,product_id,product_name,product_price,product_number,subtotal)" +
            " values(#{orderId},#{id},#{name},#{realPrice},#{num},#{subtotal})")
    public int insertOrderDetail(Product product);
}