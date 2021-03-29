package com.xiaoshi.mapper;

import com.xiaoshi.domain.OrderDetail;

import java.util.List;
import java.util.Map;

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

    @Select("select * from of_order where id = #{id}")
    Map<String, Object> getOrderInfo(Integer id);

    @Select("select d.*,p.image_url from of_order_detail d " +
            "LEFT JOIN of_product p ON d.product_id = p.id where order_id = #{id}")
    List<OrderDetail> getOrderDetailById(Integer id);

    @Update("update of_order set pay_status = #{status} where id = #{id}")
    int updateOrderStatus(Integer id,Integer status);

    @Update("update of_order_detail set status = #{status}  where order_id = #{id}")
    int updateOrderDetailStatus(Integer id,Integer status);

    @Select("select * from of_order where create_user = #{username} and pay_status = #{status} order by create_time")
    List<Map<String, Object>> getOrderInfoByName(String username,Integer status);

    @Select("select * from of_order where create_user = #{username} order by create_time")
    List<Map<String, Object>> getOrderInfoByUser(String username);

}