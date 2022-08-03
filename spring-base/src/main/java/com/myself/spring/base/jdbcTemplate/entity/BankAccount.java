package com.myself.spring.base.jdbcTemplate.entity;

public class BankAccount {
    private String id;
    private String username;
    private int money;

    @Override
    public String toString() {
        return "BankAccount{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", money=" + money +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
