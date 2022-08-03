package com.myself.spring.handler;

import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/ajax")
public class AjaxController {


    @RequestMapping(value = "/user/{id}" ,method = RequestMethod.GET)
    @ResponseBody
    public User test(@PathVariable String id){
        System.out.println("id=" + id);
        User user = new User(18,"老龄");
        List<MyTool>  list = new ArrayList<>();
        list.add(new MyTool("电脑"));
        list.add(new MyTool("平板"));
        user.setTools(list);
        return user;
    }


    //手动的将对象转化为json字符串，这里会出现乱码问题
    @RequestMapping("/jsonToShow")
    @ResponseBody
    public String jsonToShow(){

        Gson gson = new Gson();
        User user = new User(18,"老龄");
        List<MyTool> list = new ArrayList<>();
        list.add(new MyTool("电脑"));
        list.add(new MyTool("平板"));
        user.setTools(list);
        String json = gson.toJson(user);
        System.out.println(json);
        return json;
    }
    //自动将对象转化为json字符串，这里不会出现乱码问题
    @RequestMapping("/autoJsonToShow")
    @ResponseBody
    public User autoJsonToShow(){
        User user = new User(18,"老龄");
        List<MyTool>  list = new ArrayList<>();
        list.add(new MyTool("电脑"));
        list.add(new MyTool("平板"));
        user.setTools(list);
        return user;
    }
}
