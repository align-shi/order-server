package com.xiaoshi.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaoshi.config.UnifyResponse;
import com.xiaoshi.domain.Product;
import com.xiaoshi.dto.ProductListDTO;
import com.xiaoshi.mapper.ProductImageMapper;
import com.xiaoshi.mapper.ProductMapper;
import com.xiaoshi.service.iface.ProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author yuhf
 */
@Service
@Log4j2
public class ProductServiceImpl implements ProductService {
    @Resource
    ProductMapper productMapper;
    @Resource
    ProductImageMapper productImageMapper;

    @Override
    public boolean insertProduct(Product product) {
        boolean flag=false;
        if(productMapper.insertProduct(product)==1){
            flag=true;
        }
        return flag;
    }
    @Override
    public boolean deleteProducts(String ids) {
        boolean flag=false;
        String[] strArrays=ids.split(",");
        if(null!=strArrays&&strArrays.length!=0){
            int[] intArrays= Arrays.asList(strArrays).stream().mapToInt(Integer::parseInt).toArray();
            int count=productMapper.deleteProducts(intArrays);
            if(count>0){
                flag=true;
            }
        }
        return flag;
    }

    @Override
    public boolean updateProduct(Product product) {
        boolean flag=false;
        if(productMapper.updateProduct(product)==1){
            flag=true;
        }
        return flag;
    }

    @Override
    public List<Map<String,Object>> getProductsAll() {
        return productMapper.queryProductsMap();
    }

    @Override
    public PageInfo<Map<String,Object>> getProductsAllByPage(int pageNum,int size) {
        PageHelper.startPage(pageNum,size);
        List<Map<String,Object>> list=productMapper.queryProductsMap();
        return new PageInfo<>(list);
    }

    @Override
    public UnifyResponse<Object> getProductList(ProductListDTO productListDTO) {
        PageHelper.startPage(productListDTO.getPageNo(), productListDTO.getPageSize());
        PageHelper.startPage(productListDTO.getPageNo(), productListDTO.getPageSize());
        List<Map<String,Object>> list=productMapper.queryProductsMap();
        return UnifyResponse.success(new PageInfo<>(list));
    }

    @Override
    public Map<String,Object> getProductsByType(int typeId) {
        Map<String,Object> map=new HashMap<>();
        List<Map<String,Object>> products=productMapper.queryProductsByTypeId(typeId);
        map.put("products",products);
        return map;
    }

    @Override
    public List<Product> getProductsByIds(Integer[] ids) {
        return productMapper.getProductsByIds(ids);
    }

    @Override
    public Map<String,Object> getProductById(int id) {
        Map<String,Object> map=productMapper.queryProductsById(id);
        return map;
    }
}
