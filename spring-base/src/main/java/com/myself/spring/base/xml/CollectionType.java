package com.myself.spring.base.xml;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionType {
    private DepartmentLeader[] array;
    private List<DepartmentLeader> list;
    private Set<String> set;
    private Map<String,DepartmentLeader> map;

    public DepartmentLeader[] getArray() {
        return array;
    }

    public void setArray(DepartmentLeader[] array) {
        this.array = array;
    }

    public List<DepartmentLeader> getList() {
        return list;
    }

    public void setList(List<DepartmentLeader> list) {
        this.list = list;
    }

    public Set<String> getSet() {
        return set;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public Map<String, DepartmentLeader> getMap() {
        return map;
    }

    public void setMap(Map<String, DepartmentLeader> map) {
        this.map = map;
    }
    public void print(){
        System.out.println("array:");
        for (DepartmentLeader leader: array)
            System.out.print(leader+" ");
        System.out.println();
        System.out.println("list:");
        for (DepartmentLeader leader: list)
            System.out.print(leader+" ");
        System.out.println();
        System.out.println("set:");
        for (String str: set)
            System.out.print(str+" ");
        System.out.println();
        System.out.println("map:");
        for (Map.Entry<String,DepartmentLeader> entry: map.entrySet())
            System.out.print(entry.getKey()+":"+entry.getValue()+" ");
        System.out.println();
    }
}
