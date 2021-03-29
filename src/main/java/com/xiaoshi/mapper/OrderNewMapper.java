package com.xiaoshi.mapper;

import com.xiaoshi.dto.OrderDTO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface OrderNewMapper {

    List<Map<String, Object>> queryOrder(OrderDTO orderDTO);

    int update(String user);
}
