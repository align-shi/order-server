package com.xiaoshi.wx.controller;

import com.xiaoshi.config.UnifyResponse;
import com.xiaoshi.domain.Order;
import com.xiaoshi.service.iface.OrderService;
import com.xiaoshi.service.iface.ProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yuhf
 */
@RestController
@Log4j2
@RequestMapping("wx/api/v1")
public class WxOrderController {

    @Resource
    OrderService orderService;
    @Resource
    ProductService produceService;

    @PostMapping(value="/order")
    public Map<String,Object> addOrder(@RequestBody Order order){
        //存入订单信息，同时根据id查询相关的菜品数据，并将这些数据一起写入订单详情表中
        orderService.addOrder(order);
        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("result","ok");
        resultMap.put("orderId",order.getId());
        return resultMap;
    }

    @GetMapping("/order/{id}")
    public UnifyResponse<Object> getOrderInfo(@PathVariable(name = "id") Integer orderId) {
        return orderService.getOrderInfo(orderId);
    }

    @GetMapping("/update/{id}/{status}")
    public UnifyResponse<Object> updateOrder(@PathVariable(name = "id") Integer id,
                                             @PathVariable(name = "status") Integer status) {
        return orderService.updateOrder(id,status);
    }

    @GetMapping("/order/list/{username}/{status}")
    public UnifyResponse<Object> orderInfo(@PathVariable(name = "username") String username,
                                           @PathVariable(name = "status") Integer status) {
        log.info("{}请求订单列表",username);
        return orderService.orderInfo(username, status);
    }
}
