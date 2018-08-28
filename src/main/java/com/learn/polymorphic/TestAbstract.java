package com.learn.polymorphic;

public class TestAbstract {

    public static void main(String[] args) {
        Shape shapeRectangle = new Rectangle(10,20);
        System.out.println("长为：10");
        System.out.println("高为：20");
        System.out.println("矩形周长："+shapeRectangle.perimeter());
        System.out.println("矩形面积："+shapeRectangle.area());

        Line lineRectangle = new Rectangle(10,20);
        lineRectangle.format();

        Color colorRectangle = new Rectangle(10,20);
        colorRectangle.paint();

        Line lineRectangle2 = shapeRectangle;
        lineRectangle2.format();

        Color c = (Color)lineRectangle;
        c.paint();

        System.out.println("------------->");

        Shape shapeCircle = new Circle(6);
        System.out.println("半径为：6 的圆形");
        System.out.println("周长："+shapeCircle.perimeter());
        System.out.println("面积："+shapeCircle.area());

        Line lineCircle = new Circle(66);
        lineCircle.format();

        Color colorCircle = new Circle(77);
        colorCircle.paint();
    }


}

interface Color{

    //画
    void paint();

}

/**
 * 线
 */
interface Line{

    //线的格式
    void format ();
}

/**
 * 图形类
 */
abstract class Shape implements Line,Color{

    private double sideLength;        //边长
    private double height;            //高

    private double r; //声明半径
    private final double PI = 3.14;    //声明π

    Shape(double sideLength,double height){
        this.sideLength = sideLength;
        this.height = height;
    }

    Shape(double r){
        this.r = r;
    }

    //计算周长
    public abstract double perimeter();

    //计算面积
    public abstract double area();


    public double getSideLength() {
        return sideLength;
    }

    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getPI() {
        return PI;
    }
}

/**
 * 矩形
 */
class Rectangle extends Shape{

    Rectangle(double sideLength, double height) {
        super(sideLength, height);
    }

    @Override
    public double perimeter() {
        return (getSideLength()+getHeight())*2;
    }

    @Override
    public double area() {
        return getSideLength()*getHeight();
    }

    @Override
    public void paint() {
        System.out.println("矩形画的是红色");
    }

    @Override
    public void format() {
        System.out.println("矩形用粗线画");
    }
}

/**
 * 圆形
 */
class Circle extends Shape{

    Circle(double r) {
        super(r);
    }

    @Override
    public double perimeter() {
        return 2*getPI()*getR();
    }

    @Override
    public double area() {
        return getPI()*Math.pow(getR(),2);
    }

    @Override
    public void paint() {
        System.out.println("圆形画的是蓝色");
    }

    @Override
    public void format() {
        System.out.println("圆形用细线画");
    }
}
