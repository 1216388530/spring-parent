package com.myself.spring.mybatis;

import com.myself.spring.mybatis.demo1.mapper.UserMapper;
import com.myself.spring.mybatis.demo1.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Demo1Test {
    @Test
    public void testMybatis() throws IOException {
        //1.将配置文件数据变成输入流
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config-demo1.xml");
        //2.获取SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //3.利用SqlSessionFactoryBuilder，传入配置信息，获取sqlSessionFactory,数据库建立连接
        SqlSessionFactory  sqlSessionFactory = sqlSessionFactoryBuilder.build(resourceAsStream);
        //4.获取sqlSession，来和数据库进行会话,默认是false，表示DML操作不自动提交，设定为true后，会自动提交DML操作
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //5.根据核心配置文件中的映射配置文件信息，利用代理模式生成UserMapper对应的实现类，其内的方法代码是利用映射配置文件中的数据库操作元素生成的
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //6.调用
        int result = userMapper.insertUser();
        //7.提交事务
        //sqlSession.commit();
        System.out.println("result:"+result);
    }
    @Test
    public void testSelectOne() throws IOException {
        //1.将配置文件数据变成输入流
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config-demo1.xml");
        //2.获取SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //3.利用SqlSessionFactoryBuilder，传入配置信息，获取sqlSessionFactory,数据库建立连接
        SqlSessionFactory  sqlSessionFactory = sqlSessionFactoryBuilder.build(resourceAsStream);
        //4.获取sqlSession，来和数据库进行会话,默认是false，表示DML操作不自动提交，设定为true后，会自动提交DML操作
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //5.根据核心配置文件中的映射配置文件信息，利用代理模式生成UserMapper对应的实现类，其内的方法代码是利用映射配置文件中的数据库操作元素生成的
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //6.调用
        User userById = userMapper.getUserById();
        //7.提交事务
        //sqlSession.commit();
        System.out.println("result:"+userById);
    }
    @Test
    public void testSelectAll() throws IOException {
        //1.将配置文件数据变成输入流
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config-demo1.xml");
        //2.获取SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //3.利用SqlSessionFactoryBuilder，传入配置信息，获取sqlSessionFactory,数据库建立连接
        SqlSessionFactory  sqlSessionFactory = sqlSessionFactoryBuilder.build(resourceAsStream);
        //4.获取sqlSession，来和数据库进行会话,默认是false，表示DML操作不自动提交，设定为true后，会自动提交DML操作
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //5.根据核心配置文件中的映射配置文件信息，利用代理模式生成UserMapper对应的实现类，其内的方法代码是利用映射配置文件中的数据库操作元素生成的
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //6.调用
        List<User> allUser = userMapper.getAllUser();
        allUser.forEach(user -> System.out.println(user));
    }
}
