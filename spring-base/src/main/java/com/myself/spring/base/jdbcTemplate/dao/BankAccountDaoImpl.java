package com.myself.spring.base.jdbcTemplate.dao;

import com.myself.spring.base.jdbcTemplate.entity.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BankAccountDaoImpl implements BankAccountDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void spendMoney(String id, int count) {
        String sql = "update bank_account set money=money-? where id = ? ";
        jdbcTemplate.update(sql,count,id);
    }

    @Override
    public void getMoney(String id, int count) {
        String sql = "update bank_account set money=money+? where id = ? ";
        jdbcTemplate.update(sql,count,id);
    }

    @Override
    public BankAccount findOne(String id) {
        String sql = "select * from bank_account  where id = ? ";
        BankAccount bankAccount = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(BankAccount.class), id);
        return bankAccount;
    }

}
