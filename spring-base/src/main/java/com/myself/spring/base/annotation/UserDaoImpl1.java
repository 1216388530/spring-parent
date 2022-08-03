package com.myself.spring.base.annotation;

import org.springframework.stereotype.Repository;

 @Repository
public class UserDaoImpl1 implements UserDao{
    @Override
    public void add() {
        System.out.println("UserDaoImpl1   add  ");
    }
}
