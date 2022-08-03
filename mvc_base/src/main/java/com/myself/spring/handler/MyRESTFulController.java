package com.myself.spring.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 使用RESTFul风格的请求来实现对服务器资源的增删改查
 *      请求路径    请求方式   实际功能
 *      /user       get     获得所有用户信息
 *      /user/1     get     获得id为1的用户信息
 *      /user       post    新增用户信息
 *      /user/1     delete  删除id为1用户信息
 *      /user       PUT     更新指定用户信息
 */
@Controller
@RequestMapping("/RESTFul")
public class MyRESTFulController {

    @RequestMapping
    public String show(){
        return "RESTFulRequest";
    }

    @RequestMapping(value = "/user" ,method = RequestMethod.GET)
    public String getAllUser(){
        System.out.println("获得所有用户信息");
        return "success";
    }

    @RequestMapping(value = "/user/{id}" ,method = RequestMethod.GET)
    public String getUserById(@PathVariable String id){
        System.out.println("获得id为"+id+"的用户信息");
        return "success";
    }
    @RequestMapping(value = "/user" ,method = RequestMethod.POST)
    public String addUser(){
        System.out.println("新增用户信息");
        return "success";
    }
    @RequestMapping(value="/user/{id}",method = RequestMethod.DELETE)
    public String  deleteUserById(@PathVariable String id){
        System.out.println("删除id为"+id+"的用户信息");
        return "success";
    }

    @RequestMapping(value = "/user" ,method = RequestMethod.PUT)
    public String updateUser(){
        System.out.println("新增用户信息");
        return "success";
    }

}
