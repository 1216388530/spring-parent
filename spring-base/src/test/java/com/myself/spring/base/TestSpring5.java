package com.myself.spring.base;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.myself.spring.base.annotation.SpringConfiguration;
import com.myself.spring.base.annotation.UserService;
import com.myself.spring.base.aop.MyProxyFactory;
import com.myself.spring.base.aop.UserServiceImpl;
import com.myself.spring.base.aop.UserServiceProxyHandler;
import com.myself.spring.base.xml.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TestSpring5 {
    @Test
    public void test01(){
        //第一步：获取配置文件对应的对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean01.xml");
        //第二步：利用配置文件中配置的类的对象，利用id，和class对象
        User user = applicationContext.getBean("user",User.class);
        //第三步：对象使用
        user.add();
    }
    //非集合类型注入
    @Test
    public void test02(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean01.xml");
        Department department = context.getBean("ministryOfPersonnel",Department.class);
        System.out.println(department);
        OfficeArea area = context.getBean("area01",OfficeArea.class);
        System.out.println(area);
    }
    //集合类型注入
    @Test
    public void test03(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean01.xml");
        CollectionType collectionType = context.getBean("collectionType",CollectionType.class);
        collectionType.print();
        System.out.println();
        List<String> list = context.getBean("stringList",List.class);
        for (String str:list){
            System.out.print(str+" ");
        }
    }

    @Test
    public void test04(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean02-externalFileImport.xml");
        List testList = context.getBean("testList",List.class);
        for (Object obj :testList)
            System.out.println(obj);
        DruidDataSource dataSource = context.getBean("dataSource",DruidDataSource.class);
        DruidPooledConnection connection =null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("select count(*) from person");
            ResultSet resultSet =statement.executeQuery();
            while (resultSet.next())
                System.out.println(resultSet.getInt(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(connection!=null)
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    @Test
    public void test05(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean03.xml");
        //注意这里的参数二是指获取的对象的class类型，不是bean元素中指定的class类型
        User user01 = context.getBean("userFactory", User.class);
        User user02 = context.getBean("userFactory", User.class);
        user01.add();
        //是为单例
        System.out.println(user01==user02);

        //设定为多例
        OfficeArea area01 = context.getBean("area", OfficeArea.class);
        OfficeArea area02 = context.getBean("area", OfficeArea.class);
        System.out.println(area01==area02);

    }

    @Test
    public void test06(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean03.xml");

        SpringBeanLife springBeanLife = context.getBean("springBeanLife", SpringBeanLife.class);
        System.out.println("4.获取bean对象，使用："+springBeanLife.toString());
        ((ClassPathXmlApplicationContext)context).close();
    }

    @Test
    public void test07(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean04-annotation.xml");
        com.myself.spring.base.annotation.User user = context.getBean("user", com.myself.spring.base.annotation.User.class);
        user.sayHello();
    }

    @Test
    public void test08(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean04-annotation.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
    }
    @Test
    public void test09(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
    }
    @Test
    public void test10(){
        com.myself.spring.base.aop.UserService userService = new UserServiceImpl();
        try {
            com.myself.spring.base.aop.UserService proxy = (com.myself.spring.base.aop.UserService) MyProxyFactory.getProxy(userService, UserServiceProxyHandler.class);
            proxy.add();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
