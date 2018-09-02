package com.learn.collection;

import com.model.User;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestSet {

    public static void main(String[] args) {
        Collection c = new HashSet();
        c.add(new User("张三","27"));
        c.add(new Long(1000));
        c.add(new Long(1000));
        c.add("hello");
        c.add("hello");
        c.add(new User("梁","27"));
        c.add(new User("少","27"));
        c.add(new User("少","27"));
//        c.remove("hello");
//        c.remove(new Long(1000));
//        System.out.println(c.remove(new User("张三","27")));

        Iterator  iterator = c.iterator();
        while (iterator.hasNext()){

            Object obj = iterator.next();

            if(obj instanceof User){
                User user = (User)obj;
                if("少".equals(user.getName())){
                    iterator.remove();
                    //              c.remove(user);
                }
//            System.out.println(user.getName());
            }

        }

        System.out.println(c.toString());
        System.out.println("bl------------------>");

        for(Iterator iterator1 = c.iterator();iterator1.hasNext();){
            System.out.println(iterator1.next());
        }

        System.out.println("bl------------------>");

        //------------------>

        Set s1 = new HashSet();
        s1.add("a");
        s1.add("b");
        s1.add("c");
        Set s2 = new HashSet();
        s2.add("d");
        s2.add("a");
        s2.add("n");

        Set sn = new HashSet(s1);
        sn.retainAll(s2);
        Set su = new HashSet(s1);
        su.addAll(s2);

        s1.addAll(s2);

        System.out.println(sn);

        System.out.println(s1);
        System.out.println(su);

    }
}
