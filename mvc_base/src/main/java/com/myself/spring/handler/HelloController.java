package com.myself.spring.handler;

import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }
    @RequestMapping("/target")
    public String target(String name, HttpServletRequest request){
        System.out.println(name);
        request.setAttribute("name",name);

        return "target";
    }


}
