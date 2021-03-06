package com.xiaoshi.service.iface;

import com.github.pagehelper.PageInfo;
import com.xiaoshi.domain.Product;

import java.util.List;
import java.util.Map;

/**
 * @author yuhf
 */
public interface ProductService {
    public boolean insertProduct(Product product);
    public boolean deleteProducts(String ids);
    public boolean updateProduct(Product product);
    public List<Map<String,Object>> getProductsAll();
    public PageInfo<Map<String,Object>> getProductsAllByPage(int pageNum,int size);
    public Map<String,Object> getProductsByType(int typeId);
    public List<Product> getProductsByIds(Integer[] ids);
    public Map<String,Object> getProductById(int id);

}
