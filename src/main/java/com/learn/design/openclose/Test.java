package com.learn.design.openclose;

public class Test {
    public static void main(String[] args) {

        ICourse iCourse = new DiscountCourse(97,"金瓶梅" ,66d);
        System.out.println("课程id："+iCourse.getId()+"    课程名称："+iCourse.getName()+"    课程优惠价格："+iCourse.getPrice()+"    课程原价:"+((DiscountCourse) iCourse).getOriginPrice());
    }
}
