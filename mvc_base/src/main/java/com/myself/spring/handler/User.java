package com.myself.spring.handler;


import java.util.List;

public class User {
    private Integer age;
    private String name;
    private List<MyTool> tools;

    public User(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    public User() {
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MyTool> getTools() {
        return tools;
    }

    public void setTools(List<MyTool> tools) {
        this.tools = tools;
    }
}
