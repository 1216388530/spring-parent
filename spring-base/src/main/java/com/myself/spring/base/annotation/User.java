package com.myself.spring.base.annotation;

import org.springframework.stereotype.Component;
//里面的value键值对也可以不写，默认会生成，默认value = "类名，但首字母小写"
@Component(value = "user")  //相当于<bean id="user" class="..."></bean>
public class User {
    public void sayHello(){
        System.out.println("user hello");
    }
}
