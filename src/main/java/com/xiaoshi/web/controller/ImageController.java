package com.xiaoshi.web.controller;

import com.xiaoshi.domain.ProductImage;
import com.xiaoshi.service.iface.ProductImageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;

@Controller
@RequestMapping("/api/v1/image")
public class ImageController {

    @Resource
    ProductImageService productImageService;

    @RequestMapping("/test")
    public String test(){
        return "/test/imageTest.html";
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public void getImage(@PathVariable String id, HttpServletResponse response) {
        ProductImage productImage = productImageService.getImageById(Integer.valueOf(id));
        OutputStream os = null;
        try {
            os = response.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ByteArrayInputStream in = new ByteArrayInputStream(productImage.getImage());
        int b;
        byte[] buffer = new byte[1024];
        while ((b = in.read(buffer, 0, 1024)) != -1) {
            try {
                os.write(buffer, 0, b);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
