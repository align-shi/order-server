package com.xiaoshi.wx.controller;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("wx/api/v1")
@Log4j2
public class WxTestController {

    @RequestMapping("/test")
    @ResponseBody
    public Map<String,Object> wxTest(){
        log.debug("into wx_test...");
        Map<String,Object> map=new HashMap<>();
        map.put("state","success");
        map.put("msg","测试成功");
        return map;
    }
}
