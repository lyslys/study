package com.learn.polymorphic;

public class Transportation {

    public void way(int num){
        System.out.println("运算方式............");
    }

}

class Bus extends Transportation{

    @Override
    public void way(int num) {
        System.out.println("陆运............."+num);
    }

}

class Ship extends Transportation{

    @Override
    public void way(int num) {
        System.out.println("海运............."+num);
    }

}

class Aircraft extends Transportation{

    @Override
    public void way(int num) {
        System.out.println("空运............."+num);
    }

}

class TestTransportation{
    public static void main(String[] args) {
        Transportation transportation = new Aircraft();
        transportation.way(300);
        Transportation bus = new Bus();
        bus.way(40);
        Transportation ship = new Ship();
        ship.way(200);
    }
}