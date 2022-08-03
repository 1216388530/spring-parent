package com.myself.spring.base.xml;

public class OfficeArea {
    private String name;
    private double size;
    private Object objIsNull;

    public Object getObjIsNull() {
        return objIsNull;
    }

    public void setObjIsNull(Object objIsNull) {
        this.objIsNull = objIsNull;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "OfficeArea{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", objIsNull=" + objIsNull +
                '}';
    }
}
