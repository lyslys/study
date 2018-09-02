package com.learn.collection;

import java.util.*;

public class Test {

    public static void main(String[] args) {

        Collection collection = new LinkedList();

        collection.add("hello");
        int i = 6;
        collection.add(i);
        System.out.println(collection.size());
        System.out.println(collection);

        ArrayList collection2 = new ArrayList();
        collection2.add("ccc");
        System.out.println(collection2.size());
        System.out.println(collection2);

    }
}
