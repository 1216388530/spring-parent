package com.myself.spring.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
//    @RequestMapping("/")
//    public String index(){
//        return "index";
//    }
    @RequestMapping("/success")
    public String success(){
        return "success";
    }
}
