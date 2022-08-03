package com.myself.spring.base.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    //利用反射进行注入，不需要set/get
    @Value(value = "myself")
    private String name;

//    @Autowired  //类型注入,如果有多个bean匹配，会出错
//    private UserDao userDao1;

    //利用反射进行注入，不需要set/get
    @Qualifier(value = "userDaoImpl")
    @Autowired
    private UserDao userDao2;

//    @Resource  //类型注入,如果有多个bean匹配，会出错
//    private UserDao userDao3;

    @Resource(name="userDaoImpl1")  //名称注入
    private UserDao userDao4;

    public void add(){
        System.out.println(name+" "+userDao2);
        System.out.println("UserService  add");
        userDao2.add();
    }
}
