package com.myself.spring.base.aop;






import org.springframework.context.ApplicationContext;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

public class MyProxyFactory {
    /**
     * 获取增强后的代理对象
     * @param target  需要增强的对象
     * @param InvocationHandlerClass  功能增强处理器
     * @return
     * @throws ClassNotFoundException
     */
    public static Object getProxy(Object target,Class InvocationHandlerClass) throws ClassNotFoundException {
        Object proxy = null;
        try {
            //获取一个类加载器
            ClassLoader classLoader = ApplicationContext.class.getClassLoader();
            //利用类路径，获取被代理类的class对象
            Class targetClass = target.getClass();
            //获取被代理类实现的接口
            Class[] interfaces = targetClass.getInterfaces();
            //利用代理处理器的class对象，生成代理处理器对象
            Constructor constructor = InvocationHandlerClass.getDeclaredConstructor(interfaces[0]);
            Object o = constructor.newInstance(target);
            //利用Proxy的方法，生成代理对象
            proxy = Proxy.newProxyInstance(classLoader,interfaces, (InvocationHandler) o);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return proxy;
    }
}
