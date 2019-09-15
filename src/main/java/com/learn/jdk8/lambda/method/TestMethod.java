package com.learn.jdk8.lambda.method;

import java.util.Arrays;

/**
 * 函数式方法引用
 */
public class TestMethod {
    public static void dayinString(Printable p){
        p.dayin("HelloWorld");
    }

    public static void main(String[] args) {
        dayinString((s)->System.out.println(s));

        dayinString(System.out::println);
    }

}


@FunctionalInterface
interface Printable{
    void dayin(String s);
}

/**
 * 通过对象名引用成员方法
 */
class MethodRerObject{
    public void daYinChangeDaXie(String s){
        System.out.println(s.toUpperCase());
    }
}

class TestMethodRerObject{
    public static void dayin(Printable printable){
        printable.dayin("HelloWorld");
    }

    public static void main(String[] args) {
//        dayin((s)-> {
//            MethodRerObject obj = new MethodRerObject();
//            obj.daYinChangeDaXie(s);
//        });

        MethodRerObject obj = new MethodRerObject();
        dayin(obj::daYinChangeDaXie);
    }
}

/**
 * 通过对象名引用静态成员方法
 */
class StaticMethodRerObject{
    public static int m(int number,Calcable c,Integer... numbers){
        Arrays.stream(numbers).forEach(num -> {
            System.out.println(num++);
        });
        return  c.calsAbs(number);
    }
}

class TestStaticMethodRerObject{

    public static void main(String[] args) {
        int number =  StaticMethodRerObject.m(-10,(nn)-> {
            int j = StaticMethodRerObject.m(nn, Math::abs);
            return Math.abs(j);
        },6,9,999999,10000,88888);
        System.out.println(number);

        number = StaticMethodRerObject.m(-20,Math::abs);
        System.out.println(number);


    }
}

interface Calcable{
    int calsAbs(int number);
}


/**
 * -------- 引用父类的方法
 */
interface Greetable{
    void greet();
}

class Human{
    public void sayHello(){
        System.out.println("Hello 我是父类Human");
    }
}

class Man extends Human{
    @Override
    public void sayHello() {
        System.out.println("Hello 我是子类Man");
    }

    public void m (Greetable g){
            g.greet();
    }

    public void show(){
//        m(()->{
//            Human human = new Human();
//            human.sayHello();
//        });

//        m(()->super.sayHello());

        m(super::sayHello);
    }

    public static void main(String[] args) {
        new Man().show();
    }
}

/*
    使用this引用本类的成员方法
 */
 class Husband {
    //定义一个买房子的方法
    public void buyHouse(){
        System.out.println("北京二环内买一套四合院!");
    }

    //定义一个结婚的方法,参数传递Richable接口
    public void marry(Richable r){
        r.buy();
    }

    //定义一个非常高兴的方法
    public void soHappy(){
        //调用结婚的方法,方法的参数Richable是一个函数式接口,传递Lambda表达式
      /*  marry(()->{
            //使用this.成员方法,调用本类买房子的方法
            this.buyHouse();
        });*/

        /*
            使用方法引用优化Lambda表达式
            this是已经存在的
            本类的成员方法buyHouse也是已经存在的
            所以我们可以直接使用this引用本类的成员方法buyHouse
         */
        marry(this::buyHouse);
    }

    public static void main(String[] args) {
        new Husband().soHappy();
    }
}

@FunctionalInterface
interface Richable {
    //定义一个想买什么就买什么的方法
    void buy();
}

/*
    类的构造器(构造方法)引用
 */
class Person {
    private String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

/*
    定义一个创建Person对象的函数式接口
 */
@FunctionalInterface
interface PersonBuilder {
    //定义一个方法,根据传递的姓名,创建Person对象返回
    Person builderPerson(String name);
}

class Demo {
    //定义一个方法,参数传递姓名和PersonBuilder接口,方法中通过姓名创建Person对象
    public static void printName(String name,PersonBuilder pb){
        Person person = pb.builderPerson(name);
        System.out.println(person.getName());
    }

    public static void main(String[] args) {
        //调用printName方法,方法的参数PersonBuilder接口是一个函数式接口,可以传递Lambda
        printName("迪丽热巴",(String name)->{
            return new Person(name);
        });

        /*
            使用方法引用优化Lambda表达式
            构造方法new Person(String name) 已知
            创建对象已知 new
            就可以使用Person引用new创建对象
         */
        printName("古力娜扎",Person::new);//使用Person类的带参构造方法,通过传递的姓名创建对象
    }
}


/*
    定义一个创建数组的函数式接口
 */
@FunctionalInterface
 interface ArrayBuilder {
    //定义一个创建int类型数组的方法,参数传递数组的长度,返回创建好的int类型数组
    int[] builderArray(int length);
}


/*
    数组的构造器引用
 */
 class Demo1 {
    /*
        定义一个方法
        方法的参数传递创建数组的长度和ArrayBuilder接口
        方法内部根据传递的长度使用ArrayBuilder中的方法创建数组并返回
     */
    public static int[] createArray(int length, ArrayBuilder ab){
        return  ab.builderArray(length);
    }

    public static void main(String[] args) {
        //调用createArray方法,传递数组的长度和Lambda表达式
        int[] arr1 = createArray(10,(len)->{
            //根据数组的长度,创建数组并返回
            return new int[len];
        });
        System.out.println(arr1.length);//10

        /*
            使用方法引用优化Lambda表达式
            已知创建的就是int[]数组
            数组的长度也是已知的
            就可以使用方法引用
            int[]引用new,根据参数传递的长度来创建数组
         */
        int[] arr2 =createArray(10,int[]::new);
        System.out.println(Arrays.toString(arr2));
        System.out.println(arr2.length);//10
    }
}




