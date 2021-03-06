package com.xiaoshi.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/v1/")
public class InitController {

    @RequestMapping("init")
    public String init(){
        return "login";
    }

    @RequestMapping("main/init")
    public String mainInit(){return "views/welcome";}
}
