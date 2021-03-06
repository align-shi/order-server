package com.xiaoshi.service;

import com.xiaoshi.domain.Order;
import com.xiaoshi.mapper.OrderDetailMapper;
import com.xiaoshi.mapper.OrderMapper;
import com.xiaoshi.service.iface.OrderService;
import com.xiaoshi.service.iface.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;

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
}
