package com.myself.spring.mybatis;

import com.myself.spring.mybatis.demo2.mapper.UserMapper;
import com.myself.spring.mybatis.demo2.pojo.User;
import com.myself.spring.mybatis.util.SqlSessionUtils;
import org.apache.ibatis.binding.MapperMethod;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Demo2Test {
    @Test
    public void testSelectAll() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession("mybatis-config-demo2.xml");
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> allUser = userMapper.getAllUser();
        allUser.forEach(user -> System.out.println(user));

    }
}
