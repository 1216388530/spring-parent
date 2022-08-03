package com.myself.spring.base;


import com.myself.spring.base.jdbcTemplate.entity.User;
import com.myself.spring.base.jdbcTemplate.service.BankAccountService;
import com.myself.spring.base.jdbcTemplate.service.UserService;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;


public class TestSpring5JdbcTemplate {
    //更新测试
    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean05-jdbcTemplate.xml");
        UserService userService = context.getBean("userService", UserService.class);
        User user = new User();
        user.setUsername("lili");
        user.setUserId(2);
        user.setStatus("ok");
        userService.addUser(user);
    }
    //查询聚合函数测试，返回单个值
    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean05-jdbcTemplate.xml");
        UserService userService = context.getBean("userService", UserService.class);
        System.out.println(userService.countUser());
    }
    //查询单条记录，并封装成对象
    @Test
    public void test3(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean05-jdbcTemplate.xml");
        UserService userService = context.getBean("userService", UserService.class);
        System.out.println(userService.findOne(1));
    }

    //查询多条记录，并封装成List<对象类型>
    @Test
    public void test4(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean05-jdbcTemplate.xml");
        UserService userService = context.getBean("userService", UserService.class);
        List<User> all = userService.findAll();
        for(User user:all)
            System.out.println(user);
    }

    //批量更新，添加
    @Test
    public void test5(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean05-jdbcTemplate.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.findAll();
        User user1 = new User();
        user1.setUsername("awd");
        user1.setUserId(5);
        user1.setStatus("ok");

        User user2 = new User();
        user2.setUsername("gr");
        user2.setUserId(6);
        user2.setStatus("ok");
        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        userService.batchAddUser(list);
    }

    //批量更新，删除
    @Test
    public void test6(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean05-jdbcTemplate.xml");
        UserService userService = context.getBean("userService", UserService.class);
        List<Object[]> list = new ArrayList<>();
        list.add(new Integer[]{1,2});
        list.add(new Integer[]{5,6});
        userService.batchDeleteUserById(list);
    }

    //无事务的情况下
    @Test
    public void test7(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean05-jdbcTemplate.xml");
        BankAccountService bankAccountService = context.getBean("bankAccountService", BankAccountService.class);
        bankAccountService.transferAccounts("1","2",100);
    }
    //有事务的情况下
    @Test
    public void test8(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean05-jdbcTemplate.xml");
        BankAccountService bankAccountService = context.getBean("bankAccountService", BankAccountService.class);
        bankAccountService.transferAccounts("1","2",100);
    }
}
