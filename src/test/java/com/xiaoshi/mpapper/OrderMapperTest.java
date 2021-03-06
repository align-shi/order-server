package com.xiaoshi.mpapper;

import com.xiaoshi.mapper.OrderMapper;
import com.xiaoshi.Application;
import com.xiaoshi.domain.Order;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RunWith(SpringRunner. class )
@SpringBootTest(classes = {Application.class},webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Data
@Log4j2
public class OrderMapperTest {

    @Resource
    OrderMapper orderMapper;
    @Test
    public void testInsertOrder(){
        LocalDateTime ldt=LocalDateTime.parse("2019-06-04 12:20:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Order order=new Order("123562367",2,0,0,new BigDecimal(32), ldt);
        int rowNumber=orderMapper.insertOrder(order);
        log.debug("rowNumber:"+rowNumber);
        log.debug("order.id:"+order.getId());
    }
}
