package com.model;

public class User implements Comparable<User> {

    private String age;

    private String sex;

    private String name;

    public String password;

    public User(){
    }

    public User(String name,String age){
        this.age = age;
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "User{" +
                "age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof User){
            User user = (User) obj;
            return (name.equals(user.getName()));
        }
        return super.equals(obj);
    }

    @Override
    public int compareTo(User o) {
        return age.compareTo(o.getAge());
    }
}

