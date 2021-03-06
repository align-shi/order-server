package com.xiaoshi.wx.controller;

import com.xiaoshi.domain.Type;
import com.xiaoshi.service.iface.TypeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("wx/api/v1/type")
public class WxTypeController {

    @Resource
    TypeService typeService;
    @RequestMapping("/list")
    public List<Type> showType(){
        List<Type> list = typeService.getTypesAll();
        return list;
    }
}
