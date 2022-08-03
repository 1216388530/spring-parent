package com.myself.spring.base.xml;

import org.springframework.beans.factory.FactoryBean;

public class UserFactory implements FactoryBean<User> {

    @Override
    public User getObject() throws Exception {
        //创建、初始化。。自定义吧
        return new User();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }

    //选择是否单例生成，true为单例
    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}
