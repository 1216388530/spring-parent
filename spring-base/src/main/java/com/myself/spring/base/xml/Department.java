package com.myself.spring.base.xml;

/**
 * 一个部门，拥有一个部门领导，拥有一个办公区域
 */
public class Department {
    private String name;
    private OfficeArea area;
    private DepartmentLeader leader;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OfficeArea getArea() {
        return area;
    }

    public void setArea(OfficeArea area) {
        this.area = area;
    }

    public DepartmentLeader getLeader() {
        return leader;
    }

    public void setLeader(DepartmentLeader leader) {
        this.leader = leader;
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", area=" + area +
                ", leader=" + leader +
                '}';
    }
}
