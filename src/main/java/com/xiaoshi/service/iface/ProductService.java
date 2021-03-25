package com.xiaoshi.service.iface;

import com.github.pagehelper.PageInfo;
import com.xiaoshi.config.UnifyResponse;
import com.xiaoshi.domain.Product;
import com.xiaoshi.dto.ProductListDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author yuhf
 */
public interface ProductService {
    public boolean insertProduct(Product product);

    /**
     * 查询产品列表
     * @return
     */
    UnifyResponse<Object> getProductList(ProductListDTO productListDTO);

    /**
     * 上传图片
     * @param file 图片
     * @return
     */
    UnifyResponse<Object> uploadImage(MultipartFile file) throws IOException;

    /**
     * 新增一个产品
     * @param product
     * @return
     */
    UnifyResponse<Object> addOperation(Product product);

    public boolean deleteProducts(String ids);
    UnifyResponse<Object>  updateProduct(Product product);
    public List<Map<String,Object>> getProductsAll();
    public PageInfo<Map<String,Object>> getProductsAllByPage(int pageNum,int size);
    public Map<String,Object> getProductsByType(int typeId);
    public List<Product> getProductsByIds(Integer[] ids);
    public Map<String,Object> getProductById(int id);

}
