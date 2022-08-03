package com.myself.spring.mybatis.demo1.mapper;

import com.myself.spring.mybatis.demo1.pojo.User;

import java.util.List;

public interface UserMapper {
    /**
     * 添加用户信息
     * @return
     */
    int insertUser();

    /**
     * 查询一条用户记录
     */
    User getUserById();

    /**
     * 查询多条用户记录
     */
    List<User> getAllUser();
}
