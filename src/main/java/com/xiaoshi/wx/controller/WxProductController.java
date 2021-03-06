package com.xiaoshi.wx.controller;

import com.xiaoshi.service.iface.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("wx/api/v1/product")
public class WxProductController {

    @Resource
    ProductService productService;

    @RequestMapping("/list")
    public List<Map<String,Object>> showProducts(){
        return productService.getProductsAll();
    }

    @GetMapping("/type/{typeId}")
    public Map<String,Object> showProductsByType(@PathVariable("typeId") String typeId){
        return productService.getProductsByType(Integer.valueOf(typeId));
    }
    @GetMapping("/{id}")
    public Map<String,Object> showProductsById(@PathVariable String id){
        return productService.getProductById(Integer.valueOf(id));
    }
}
