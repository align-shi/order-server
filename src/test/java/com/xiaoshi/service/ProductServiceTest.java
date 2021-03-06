package com.xiaoshi.service;

import com.github.pagehelper.PageInfo;
import com.xiaoshi.Application;
import com.xiaoshi.service.iface.ProductService;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Map;

@RunWith(SpringRunner.class )
@SpringBootTest(classes = {Application.class},webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Data
@Log4j2
public class ProductServiceTest {
    @Resource
    ProductService productService;
    @Test
    public void testGetProductsAllByPage(){
        PageInfo<Map<String,Object>> pageInfo=productService.getProductsAllByPage(1,5);
        //pageInfo.getList().forEach(log::debug);
    }
}
