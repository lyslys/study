package com.learn.collection;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class TestMap {
    public static void main(String[] args) {
        Map map = new HashMap();
        System.out.println(map.isEmpty());
        map.put("a","9");
        System.out.println(map.put("a","6"));
        map.put("b","6");
        System.out.println(map);

        System.out.println("------------");

        System.out.println(map.containsKey("c"));
        System.out.println(map.containsKey("a"));

        System.out.println(map.containsValue("7"));
        System.out.println(map.containsValue("6"));

        System.out.println("------------");

        System.out.println(map.isEmpty());

        System.out.println(map.size());

        Map map2 =  new HashMap(map);

        map2.put("m","vv");
        System.out.println(map2);

        System.out.println("---------------------map3");
        Map map3 =  new HashMap();
        map3.put("m3",6);
        map3.putAll(map);
        System.out.println(map3);

        System.out.println(map2.isEmpty());

        map2.clear();

        System.out.println(map2.isEmpty());


        System.out.println("---------------------");

        if(map3.containsKey("m3")){
            int i = (Integer) map3.get("m3");
            System.out.println(i);
        }

        System.out.println("map6---------------------");

        Map<String,Integer> map6 = new TreeMap<String,Integer>();

        map6.put("kkk",new Integer(11));
        map6.put("CC",new Integer(985566));
        map6.put("AA",new Integer(52696));

        if(map6.containsKey("kkk")){
            int i = map6.get("kkk");
            System.out.println(i);
        }

        System.out.println(map6);

        Iterator it = map6.keySet().iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

        Map<String,Integer> map7 = new ConcurrentHashMap<String,Integer>();

        Map<String,Integer> map8 = new Hashtable<String,Integer>();

    }
}
