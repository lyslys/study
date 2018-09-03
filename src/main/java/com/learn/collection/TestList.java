package com.learn.collection;

import com.model.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * ArrayList  读快改慢
 * Linked 改快读慢
 * Hash 两者之间
 */
public class TestList {

    public static void main(String[] args) {
        List list = new LinkedList();

        System.out.println(list.isEmpty());

        list.add("a66666");
        list.add("a33333");
        list.add("a688");
        list.add("a6667");
        list.add(1,"a22222");

        System.out.println(list.isEmpty());

        Collections.sort(list);

        System.out.println(list);

        System.out.println(list.set(1,"a77777"));
        System.out.println(list.indexOf("a66666"));
        System.out.println(list.lastIndexOf("a66666"));
        System.out.println(list);

//        list.remove(0);
//        System.out.println(list);


        Collections.sort(list);

        System.out.println(list);


        List list2 = new LinkedList();

        for (int i=0;i<=9;i++){
            list2.add("a"+i);
        }

        System.out.println("原始："+list2);

        Collections.shuffle(list2);

        System.out.println("随机："+list2);

        Collections.reverse(list2);

        System.out.println("逆序："+list2);

        Collections.sort(list2);

        System.out.println("排序："+list2);

        System.out.println(Collections.binarySearch(list2,"a6"));

        //-------------->

        System.out.println("-------------->");

        List<User> userList = new ArrayList<User>();
        User user = new User("Z张三","28");
        User user2 = new User("L梁六","27");
        User user3 = new User("Q齐七","13");
        userList.add(user);
        userList.add(user2);
        userList.add(user3);
        Collections.sort(userList);
        System.out.println(userList);

    }

}
