package com.learn.collection;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class TestMap {


    /**
     * The maximum capacity, used if a higher value is implicitly specified
     * by either of the constructors with arguments.
     * MUST be a power of two <= 1<<30.
     */
    static final int MAXIMUM_CAPACITY = 1 << 30;

    interface C {
        static void aa(){
            System.out.println("aa");
        }
    }

    abstract class G  implements C{
        private  void aa(){
            System.out.println("aa");
        }
    }

    class TT implements Map.Entry{

        @Override
        public Object getKey() {
            return null;
        }

        @Override
        public Object getValue() {
            return null;
        }

        @Override
        public Object setValue(Object value) {
            return null;
        }

    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    public static void main(String[] args) {

        System.out.println(tableSizeFor(7));

        System.out.println(Float.isNaN(0.0f / 0.0f));
        float f = 0.0f / 0.0f;
        float x = f;
        System.out.println(x);
        System.out.println(f);

        HashMap map = new HashMap();
        System.out.println(map.isEmpty());
        map.put("a","9");
        System.out.println(map.put("a","6"));
        map.put("b","6");
        System.out.println(map);

        map.forEach((key, value) -> {System.out.println(key + "：" + value);});

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

        Map c = new ConcurrentHashMap();

//        BitSet
    }
}
