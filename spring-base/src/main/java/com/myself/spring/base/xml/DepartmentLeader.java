package com.myself.spring.base.xml;

import org.springframework.beans.factory.config.BeanPostProcessor;

public class DepartmentLeader {
    private String name;

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DepartmentLeader{" +
                "name='" + name + '\'' +
                '}';
    }
}
