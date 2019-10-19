package com.learn.jvm;

public class User {

    private int id;
    private String name;
    byte[] a = new byte[1024*100];

    public User() {
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
//        OOMTest.list.add(this);  进行GC root跟关联 自救
        System.out.println("关闭资源---user:"+id+"即将被回收");
    }

}
