package com.myself.spring.mybatis.mbg.pojo;

public class Department {

    private Integer did;


    private String deptName;

    @Override
    public String toString() {
        return "Department{" +
                "did=" + did +
                ", deptName='" + deptName + '\'' +
                '}';
    }

    public Integer getDid() {
        return did;
    }


    public void setDid(Integer did) {
        this.did = did;
    }


    public String getDeptName() {
        return deptName;
    }


    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }
}