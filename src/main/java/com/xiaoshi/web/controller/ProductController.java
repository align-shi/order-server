package com.xiaoshi.web.controller;

import com.github.pagehelper.PageInfo;
import com.xiaoshi.Constants;
import com.xiaoshi.config.UnifyResponse;
import com.xiaoshi.domain.Product;
import com.xiaoshi.dto.ProductListDTO;
import com.xiaoshi.service.iface.ProductService;
import com.xiaoshi.service.iface.TypeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@RestController
@RequestMapping("product")
@Log4j2
public class ProductController {

    @Resource
    ProductService productService;
    @Resource
    TypeService typeService;

    @RequestMapping("/list/{pageNumber}")
    public ModelAndView productList(@PathVariable String pageNumber){
        PageInfo<Map<String,Object>> page =productService.getProductsAllByPage(Integer.parseInt(pageNumber), Constants.PAGE_NUMBER);
        ModelAndView mav=new ModelAndView("views/product");
        mav.addObject("page",page);
        mav.addObject("types",typeService.getTypesAll());
        return mav;
    }

    @GetMapping("/list")
    public UnifyResponse<Object> getProductList(ProductListDTO productListDTO){

        return productService.getProductList(productListDTO);
    }

    @RequestMapping("/search/{id}")
    public @ResponseBody Map<String,Object> searchType(@PathVariable int id){
        Map<String,Object> map=productService.getProductById(id);
        return map;
    }

    /*@RequestMapping("/update")
    public void updateType(Product product,HttpServletResponse response) throws IOException {
        PrintWriter out=response.getWriter();
        if(productService.updateProduct(product)){
            out.println("<script>alert('修改数据成功！');window.location.href='/api/v1/product/list/1'</script>");
        }else{
            out.println("<script>alert('修改数据失败！请稍候再试');window.location.href='/api/v1/product/list/1'</script>");
        }
        out.flush();
        out.close();
    }*/

    @PostMapping("/update")
    public UnifyResponse<Object> updateType(@RequestBody Product product){
        return productService.updateProduct(product);
    }

    @PostMapping("/add")
    public void addOperation(HttpServletResponse response, Product product) throws IOException {
        PrintWriter out=response.getWriter();
        if(productService.insertProduct(product)){
            out.println("<script>alert('新增数据成功！');window.location.href='/api/v1/product/list/1'</script>");
        }else{
            out.println("<script>alert('新增数据失败！请稍候再试');window.location.href='/api/v1/product/list/1'</script>");
        }
        out.flush();
        out.close();
    }
    @GetMapping("/{id}")
    public @ResponseBody Map<String,Object> getProduct(@PathVariable String id){
        Map<String,Object> product=productService.getProductById(Integer.valueOf(id));
        return product;
    }

    @GetMapping("/delete/{ids}")
    public void deleteOperation(@PathVariable String ids,HttpServletResponse response) throws IOException {
        PrintWriter out=response.getWriter();
        if(productService.deleteProducts(ids)){
            out.println("<script>alert('删除数据成功！');window.location.href='/api/v1/type/list/1'</script>");
        }else{
            out.println("<script>alert('删除数据失败！请稍候再试');window.location.href='/api/v1/type/list/1'</script>");
        }
        out.flush();
        out.close();
    }
}
