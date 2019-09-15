package com.learn.myenum;

public enum Day {

    monday("星期一",1),tuesday,wednesday,thursday,friday,saturday,sunday;

    private String name;
    private int index;

    Day() {
    }

    Day(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
