package com.myself.spring.base.aop;



public class UserServiceImpl implements UserService {
    @Override
    public void add() {
        System.out.println("UserServiceImpl  原功能");
    }
}
