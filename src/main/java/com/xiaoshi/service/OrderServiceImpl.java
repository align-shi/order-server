package com.xiaoshi.service;

import com.xiaoshi.config.UnifyResponse;
import com.xiaoshi.domain.Order;
import com.xiaoshi.domain.OrderDetail;
import com.xiaoshi.mapper.OrderDetailMapper;
import com.xiaoshi.mapper.OrderMapper;
import com.xiaoshi.service.iface.OrderService;
import com.xiaoshi.service.iface.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private OrderDetailMapper orderDetailMapper;

    @Resource
    private ProductService productService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addOrder(Order order) {
        boolean flag=false;
        //格式id数据，并通过id数据查询相关的菜品信息
        //String[] temp=order.getIds();
        //List<Integer> ids= Arrays.stream(temp).map(Integer::valueOf).collect(Collectors.toList());
        //List<Product> list=productService.getProductsByIds(ids.stream().toArray(Integer[]::new));   //查询商品准备写入订单详情表
        //写入订单信息
        if(orderMapper.insertOrder(order)==1){
            order.getShoppingCart().forEach(product->{
                product.setOrderId(order.getId());
                product.setSubtotal(product.getRealPrice().multiply(new BigDecimal(product.getNum())));
                //写入详单详情表
                orderDetailMapper.insertOrderDetail(product);
            });
            flag=true;
        }
        return flag;
    }

    @Override
    public UnifyResponse<Object> getOrderInfo(Integer orderId) {
        Map<String, Object> orderInfo = orderDetailMapper.getOrderInfo(orderId);
        List<OrderDetail> orderDetailById = orderDetailMapper.getOrderDetailById(orderId);
        DateFormat df = new SimpleDateFormat("yyyy-MM dd-HH-mm-ss");
        Timestamp time = (Timestamp) orderInfo.get("create_time");
        orderInfo.put("create_time",df.format(time));
        orderInfo.put("detail", orderDetailById);
        return UnifyResponse.success(orderInfo);
    }

    @Override
    public UnifyResponse<Object> updateOrder(Integer id,Integer status) {
        orderDetailMapper.updateOrderStatus(id,status);
        orderDetailMapper.updateOrderDetailStatus(id,status);
        return UnifyResponse.success();
    }

    @Override
    public UnifyResponse<Object> orderInfo(String username, Integer status) {
        List<Map<String, Object>> orderInfoByName = orderDetailMapper.getOrderInfoByName(username, status);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        orderInfoByName.forEach(map ->{
            Timestamp time = (Timestamp) map.get("create_time");
            map.put("create_time",df.format(time));
            List<OrderDetail> id = orderDetailMapper.getOrderDetailById((Integer) map.get("id"));
            map.put("detail", id);
        });
        return UnifyResponse.success(orderInfoByName);
    }
}
