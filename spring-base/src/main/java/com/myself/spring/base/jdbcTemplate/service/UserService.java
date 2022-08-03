package com.myself.spring.base.jdbcTemplate.service;

import com.myself.spring.base.jdbcTemplate.dao.UserDao;
import com.myself.spring.base.jdbcTemplate.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    //更新数据
    public void addUser(User user){
        userDao.addUser(user);
    }
    //查询聚合函数值
    public int countUser(){
        return userDao.countUser();
    }
    //查询单条记录
    public User findOne(int id){
        return userDao.findOne(id);
    }
    //查询多条记录
    public List<User> findAll(){
        return userDao.findAll();
    }
    //批量添加多条记录,批量更新
    public void batchAddUser(List<User> users){
        userDao.batchAddUser(users);
    }
    //批量删除多条记录,批量更新
    public void batchDeleteUserById(List<Object[]> integersList){
        userDao.batchDeleteUserById(integersList);
    }
}
