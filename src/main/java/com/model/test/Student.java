package com.model.test;

import java.math.BigDecimal;

public class Student {

    private Integer id;

    private String name;

    private Integer age;

    private BigDecimal  high;

    private Integer clsId;

    private Classes cls;

    private Enum gender;

    public Classes getCls() {
        return cls;
    }

    public void setCls(Classes cls) {
        this.cls = cls;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public BigDecimal getHigh() {
        return high;
    }

    public void setHigh(BigDecimal high) {
        this.high = high;
    }

    public Integer getClsId() {
        return clsId;
    }

    public void setClsId(Integer clsId) {
        this.clsId = clsId;
    }

    public Enum getGender() {
        return gender;
    }

    public void setGender(Enum gender) {
        this.gender = gender;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", high=" + high +
                ", clsId=" + clsId +
                ", cls=" + cls +
                ", gender=" + gender +
                '}';
    }
}
