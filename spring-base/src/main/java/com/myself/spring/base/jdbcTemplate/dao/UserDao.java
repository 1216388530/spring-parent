package com.myself.spring.base.jdbcTemplate.dao;

import com.myself.spring.base.jdbcTemplate.entity.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);

    int countUser();

    User findOne(int id);

    List<User> findAll();

    void batchAddUser(List<User> users);

    void batchDeleteUserById(List<Object[]> integersList);
}
