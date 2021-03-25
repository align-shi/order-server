package com.xiaoshi.mpapper;

import com.xiaoshi.mapper.OrderDetailMapper;
import com.xiaoshi.Application;
import com.xiaoshi.domain.OrderDetail;
import com.xiaoshi.domain.Product;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner. class )
@SpringBootTest(classes = {Application.class},webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Data
@Log4j2
public class OrderDetailMapperTest {

    @Resource
    OrderDetailMapper orderDetailMapper;
    @Test
    public void testGetOrderDetailByIds(){
        List<OrderDetail> list=orderDetailMapper.getOrderDetailByIds(new Integer[]{3,4});
        list.forEach(log::debug);
    }

    /*@Test
    public void testInsertOrderDetail(){
        Product product=Product.of("圣代",new BigDecimal(9),new BigDecimal(4),5,"冷饮",356,0,"圣代,是一种冰激凌甜点,传统的圣代会用一到两勺冰激凌,上面点缀一些果酱或糖浆,有的也在上面用一层糖霜、打发奶油、樱桃或其他水果(香蕉、菠萝)。");
        product.setNum(3);
        product.setId(9);
        product.setSubtotal(product.getRealPrice().multiply(new BigDecimal(product.getNum())));
        product.setOrderId(1);
        orderDetailMapper.insertOrderDetail(product);
    }*/
}
