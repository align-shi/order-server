package com.xiaoshi.service;

import com.xiaoshi.mapper.ProductImageMapper;
import com.xiaoshi.domain.ProductImage;
import com.xiaoshi.service.iface.ProductImageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProductImageServiceImpl  implements ProductImageService {

    @Resource
    ProductImageMapper productImageMapper;

    @Override
    public boolean addImage(ProductImage productImage) {
        boolean flag=false;
        if(productImageMapper.insertImage(productImage)==1){
            flag=true;
        }
        return flag;
    }

    @Override
    public ProductImage getImageById(int id) {
        return productImageMapper.queryImageById(id);
    }

}
