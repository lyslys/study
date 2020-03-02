package com.learn.tuling.designpattern.factory;

public class FactoryMethodTest {

    public static void main(String[] args) {
//        Application application = new ConcreteProductA();
        Application application = new ConcreteProductB();
        application.init();
        application.process();
    }

}



interface Product{
    void method1();
}

class ProductA implements Product{
    @Override
    public void method1() {
        System.out.println("ProductA.method1 executed.");
    }
}

class ProductB implements Product{
    @Override
    public void method1() {
        System.out.println("ProductB.method1 executed.");
    }
}


abstract class Application{

    private Product product;

    abstract Product createProduct();

    public void init(){
        product = createProduct();
    }

    public void process(){
        product.method1();
    }

}

class ConcreteProductA extends Application{

    @Override
    Product createProduct() {
        return new ProductA();
    }
}

class ConcreteProductB extends Application{

    @Override
    Product createProduct() {
        return new ProductB();
    }

}