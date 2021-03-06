package com.xiaoshi.mpapper;

import com.xiaoshi.Application;
import com.xiaoshi.domain.Product;
import com.xiaoshi.mapper.ProductMapper;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class )
@SpringBootTest(classes = {Application.class},webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Data
@Log4j2
public class ProductMapperTest {

    @Resource
    ProductMapper productMapper;

    @Test
    public void testInsertProduct(){
        Product product=Product.of("圣代",new BigDecimal(9),new BigDecimal(4),4,"冷饮",356,0,"圣代,是一种冰激凌甜点,传统的圣代会用一到两勺冰激凌,上面点缀一些果酱或糖浆,有的也在上面用一层糖霜、打发奶油、樱桃或其他水果(香蕉、菠萝)。");
        int rowNumber=productMapper.insertProduct(product);
        log.debug("rowNumber:"+rowNumber);
        log.debug("product object id is:"+product.getId());
    }

    @Test
    public void testGetProductsByIds(){
        List<Product> list=productMapper.getProductsByIds(new Integer[]{3,4});
        list.forEach(log::debug);
    }

    @Test
    public void testQueryProductsByMap(){
        List<Map<String,Object>> list=productMapper.queryProductsMap();
        list.forEach((element)->{
            element.forEach((k,v)->{
                System.out.println(k+","+v);
            });
        });
    }

    @Test
    public void testUpdateImage(){
        Product product=new Product();
        product.setId(1);
        File file=new File("d:\\mxr.jpg");
        Byte[] byt=null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            FileInputStream fis =new FileInputStream(file);
            byte [] buff= new byte [( int ) file.length()];
            int n;
            while ((n = fis.read(buff)) != -1) {
                bos.write(buff, 0, n);
            }
            fis.close();
            bos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        product.setImage(bos.toByteArray());
        Integer rowNumber=productMapper.updateImage(product);
        log.debug("rowNumber:"+rowNumber);
    }
    @Test
    public void testQueryProducts(){
        List<Product> list=productMapper.queryProducts();
        list.forEach(System.out::println);
    }
}
