package com.learn.polymorphic;

public class TestFinal {

    public static void main(String[] args) {
        T t = new T();
   //     t.i=6;
        System.out.println(t.i);
    }

}

final class T{
    final int i;

    T(){
        i=10;
    }

    public  final  void m (final String j){
//        j = "9";
    }
}

class TT{
//    public void m (final String j){
////        j = "9";
//    }
}
