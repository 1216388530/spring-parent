package com.myself.spring.base.aop;



import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class UserServiceProxyHandler implements InvocationHandler {
    //被代理的对象
    private UserService target;
    public UserServiceProxyHandler(){

    }
    //赋值
    public UserServiceProxyHandler(UserService target){
        this.target=target;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println("原方法前增强");
        Object result = method.invoke(target, objects);//利用反射调用原方法
        System.out.println("原方法后增强");
        return result;
    }
}
