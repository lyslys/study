package com.learn.design.principle.dan_yi;

public class SingleResponsibility1 {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.run("摩托车");
        vehicle.run("骑车");
        vehicle.run("飞机");
    }
}

//交通工具类

/**
 * 1.在方式1的run方法中，违反了单一职责原则
 * 2.根据交通工具运行方法不同，分解成不同类即可
 */
class Vehicle{
    public void run(String vehicle){
        System.out.println(vehicle+"  在公路上运行...");
    }
}
