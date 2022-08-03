package com.myself.spring.base.jdbcTemplate.dao;

import com.myself.spring.base.jdbcTemplate.entity.BankAccount;
import com.myself.spring.base.jdbcTemplate.entity.User;

public interface BankAccountDao {
    void spendMoney(String id,int count);
    void getMoney(String id,int count);
    BankAccount findOne(String id);
}
