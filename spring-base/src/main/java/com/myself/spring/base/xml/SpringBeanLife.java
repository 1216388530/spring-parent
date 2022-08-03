package com.myself.spring.base.xml;

public class SpringBeanLife {
    private String property;

    @Override
    public String toString() {
        return "SpringBeanLife{" +
                "property='" + property + '\'' +
                '}';
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        System.out.println("2.set属性注入");
        this.property = property;
    }

    public SpringBeanLife(){
        System.out.println("1.无参构造器");
    }
    public void init(){
        System.out.println("3.自定义初始化方法");
    }
    public void destroy(){
        System.out.println("5.自定义初销毁方法");
    }
}
