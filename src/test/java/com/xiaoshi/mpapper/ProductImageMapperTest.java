package com.xiaoshi.mpapper;

import com.xiaoshi.mapper.ProductImageMapper;
import com.xiaoshi.Application;
import com.xiaoshi.domain.ProductImage;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.*;

@RunWith(SpringRunner. class )
@SpringBootTest(classes = {Application.class},webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Data
@Log4j2
public class ProductImageMapperTest {

    @Resource
    ProductImageMapper productImageMapper;

    @Test
    public void testInsertImage() {
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
        //ProductImage pi=new ProductImage(0,"木须肉",1,bos.toByteArray());
        //int i = productImageMapper.insertImage(pi);
    }
    @Test
    public void testGetImage(){
        ProductImage pi=productImageMapper.queryImageById(1);
    }
}
