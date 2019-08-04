package com.learn.jdk8.lambda.supplier;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TestSupplier {


    public static  String getString(Supplier<String> sup){
        return sup.get();
    }

    public static void main(String[] args) {
        String str = new StringBuilder(getString(()->"胡歌")).reverse().toString();

        String str2 = getString(()->{
            return "胡歌6";
        });

        System.out.println(str2);

    }

}

//---------------
class DemoConsumer{
    public static void m(String name, Consumer<String> consumer) {
        consumer.accept(name);
    }

    public static void main(String[] args) {
        m("张靓颖",(String name)->{
            String str = new StringBuffer(name).reverse().toString();
            System.out.println(str);
        });

        char c = '啊';
        System.out.println(c);
    }
}

//---------------

class DemoPredicate{
    public static boolean m(String name, Predicate<String> predicate) {
        return predicate.test(name);
    }

    public static void main(String[] args) {
        boolean b = m("A666666666", (str)->str.length()>5);
        System.out.println(b);
    }

}

class DemoFunction{
    public static void change(String name, Function<String,Integer> fun) {
        System.out.println(fun.apply(name));
    }

    public static void main(String[] args) {
        change("123",str->Integer.parseInt(str));
    }

}


