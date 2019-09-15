package com.learn.design.openclose;

public class DiscountCourse extends JavaCourse {

    public DiscountCourse(Integer id, String name, Double price) {
        super(id, name, price);
        System.out.println("子类");
    }

    static {
        System.out.println("子类静态");
    }


    public Double getOriginPrice() {
        return super.getPrice();
    }


    @Override
    public Double getPrice() {
        return super.getPrice()*0.8;
    }

}
