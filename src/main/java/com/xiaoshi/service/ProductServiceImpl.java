package com.xiaoshi.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaoshi.config.UnifyResponse;
import com.xiaoshi.domain.Product;
import com.xiaoshi.dto.ProductListDTO;
import com.xiaoshi.mapper.ProdecterMapper;
import com.xiaoshi.mapper.ProductImageMapper;
import com.xiaoshi.mapper.ProductMapper;
import com.xiaoshi.service.iface.ProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 * @author yuhf
 */
@Service
@Log4j2
public class ProductServiceImpl implements ProductService {
    @Resource
    ProductMapper productMapper;

    @Autowired
    private ProdecterMapper prodecterMapper;
    @Resource
    ProductImageMapper productImageMapper;

    @Value("${image.url}")
    private String imgUrl;

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
    public UnifyResponse<Object> updateProduct(Product product) {
        prodecterMapper.update(product);
        return UnifyResponse.success();
    }

    @Override
    public List<Map<String,Object>> getProductsAll() {
        List<Map<String, Object>> list = productMapper.queryProductsMap();
        list.forEach(map -> map.put("num",0));
        return list;
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
        List<Map<String,Object>> list=prodecterMapper.selectAll(productListDTO);
        list.forEach(map -> map.put("imgUrl", imgUrl + map.get("imageUrl")));
        return UnifyResponse.success(new PageInfo<>(list));
    }

    @Override
    public UnifyResponse<Object> uploadImage(MultipartFile photo) throws IOException {
        if(!photo.isEmpty()){

            //文件上传的地址
            String path = ResourceUtils.getURL("classpath:").getPath()+"static/upload";
            String realPath = path.replace('/', '\\').substring(1,path.length());
            //用于查看路径是否正确
            System.out.println(realPath);

            //获取文件的名称
            final String fileName = photo.getOriginalFilename();

            //限制文件上传的类型
            String contentType = photo.getContentType();
            if("image/jpeg".equals(contentType) || "image/jpg".equals(contentType) ){
                assert fileName != null;
                File file = new File(realPath,fileName);

                //完成文件的上传
                photo.transferTo(file);
                log.info("图片上传成功!");
                return UnifyResponse.success("upload/"+fileName);
            } else {
                return UnifyResponse.error("图片类型错误");
            }
        } else {
            return UnifyResponse.error("图片上传失败");
        }
    }

    @Override
    public UnifyResponse<Object> addOperation(Product product) {
        prodecterMapper.addOne(product);
        return UnifyResponse.success();
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
