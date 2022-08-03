package com.myself.spring.base.jdbcTemplate.service;

import com.myself.spring.base.jdbcTemplate.dao.BankAccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BankAccountService {
    @Autowired
    private BankAccountDao bankAccountDao;

    //无事务：转账人向被转账人转账amount元
    public void transferAccounts(String transferorId,String transferredPersonId,int amount){
        bankAccountDao.spendMoney(transferorId,amount);
        int i= 10/0;
        bankAccountDao.getMoney(transferredPersonId,amount);
        System.out.println("转账人账户："+bankAccountDao.findOne(transferorId));
        System.out.println("被转账人账户："+bankAccountDao.findOne(transferredPersonId));
    }

    @Transactional
    //有事务：转账人向被转账人转账amount元
    public void transferAccountsByTransaction(String transferorId,String transferredPersonId,int amount){
        bankAccountDao.spendMoney(transferorId,amount);
        int i= 10/0;
        bankAccountDao.getMoney(transferredPersonId,amount);
        System.out.println("转账人账户："+bankAccountDao.findOne(transferorId));
        System.out.println("被转账人账户："+bankAccountDao.findOne(transferredPersonId));
    }
}
