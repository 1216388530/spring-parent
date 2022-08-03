package com.myself.spring.mybatis.demo2.mapper;

import com.myself.spring.mybatis.demo2.pojo.User;

import java.util.List;

public interface UserMapper {
    /**
     * 查询多条用户记录
     */
    List<User> getAllUser();
}
