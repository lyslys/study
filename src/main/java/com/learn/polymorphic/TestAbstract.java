package com.learn.polymorphic;

/**
 * 抽象类和接口的异同点
 *
 * 相同点：
 *       都是不断向上抽取而来的
 *
 * 不同点：
 *       1.抽象类需要被继承，而且只能单继承
 *         接口需要被实现，而且可以多实现
 *       2.抽象类中可以定义抽象方法和非抽象方法，子类继承后，可以直接使用非抽象方法
 *         接口中只能定义抽象方法，必须由子类去实现
 *       3.抽象类的继承，是is a 关系，在定义该体系的基本共性内容
 *         接口的实现是like a 关系，在定义体系额外功能
 */
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

    //计算周长
    public abstract double perimeter();

    //计算面积
    public abstract double area();

}

/**
 * 矩形
 */
class Rectangle extends Shape{

    private double sideLength;        //边长
    private double height;            //高

    Rectangle(double sideLength,double height){
        this.sideLength = sideLength;
        this.height = height;
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

}

/**
 * 圆形
 */
class Circle extends Shape{

    private double r; //声明半径
    private final double PI = 3.14;    //声明π

    Circle(double r){
        this.r = r;
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
