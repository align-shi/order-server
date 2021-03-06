package com.xiaoshi.web.controller;

import com.xiaoshi.config.UnifyResponse;
import com.xiaoshi.dto.UserLoginDTO;
import com.xiaoshi.service.iface.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("user")
@Log4j2
public class UserController {

    @Resource
    UserService userService;

    @GetMapping("/login")
    public ModelAndView userLogin(@RequestParam String username,@RequestParam String password){
        ModelAndView mav=new ModelAndView();
        if(userService.checkUserNameAndPassword(username,password)){
            mav.setViewName("views/main");
        }else{
            mav.addObject("message","用户名或密码错误！");
            mav.setViewName("login");
        }
        return mav;
    }

    @PostMapping("/doLogin")
    public UnifyResponse<Object> doLogin(@RequestBody UserLoginDTO userLoginDTO) {
        try {
            if (userService.checkUserNameAndPassword(userLoginDTO.getUsername(), userLoginDTO.getPassword())) {
                return UnifyResponse.success();
            }
        } catch (Exception e) {
            log.error("报错", e);
        }
        return UnifyResponse.error("用户名密码错误!!!");
    }

}
