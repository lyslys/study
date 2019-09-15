package com.learn.design.principle.dan_yi;

public class SingleResponsibility2 {
    public static void main(String[] args) {
        RoadVehicle vehicle = new RoadVehicle();
        vehicle.run("摩托车");
        vehicle.run("骑车");
        AirVehicle airVehicle = new AirVehicle();
        airVehicle.run("飞机");
    }
}

//交通工具类

/**
 * 改动大 ，将类分解，同时修改客户端
 */
class RoadVehicle{
    public void run(String vehicle){
        System.out.println(vehicle+"  在公路上运行...");
    }
}

class AirVehicle{
    public void run(String vehicle){
        System.out.println(vehicle+"  在天空上运行...");
    }
}
class WaterVehicle{
    public void run(String vehicle){
        System.out.println(vehicle+"  在水上...");
    }
}
