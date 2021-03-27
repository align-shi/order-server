package com.xiaoshi.service.iface;

import com.xiaoshi.config.UnifyResponse;
import com.xiaoshi.domain.Order;
import org.springframework.web.bind.annotation.PathVariable;

public interface OrderService {

    public boolean addOrder(Order order);

    UnifyResponse<Object> getOrderInfo(Integer orderId);

    UnifyResponse<Object> updateOrder(Integer id,Integer status);

    UnifyResponse<Object> orderInfo(String username, Integer status);
}
