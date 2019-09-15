package com.learn.collection;

import com.model.User;

import java.util.*;

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

        Iterator it = list.iterator();

        while (it.hasNext()){
            System.out.println(it.next());
        }

        System.out.println("----------->"+list.contains("a22262"));

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
    //    Collections.sort(userList);
        System.out.println(userList);




        //---------------->
        Map<String,String> map = new HashMap<String, String>();
        map.put("6","9");
        map.put("66","99");
        Map<String,String> map1 = new HashMap<String, String>();
        map1.put("7","90");
        Map<String,String> map2 = new HashMap<String, String>();
        map2.put("8","19");

        list.add(map);
        list.add(map1);
        list.add(map2);

        List list66 = new LinkedList();
        Map<String,String> map3 = new HashMap<String, String>();
        map3.put("6","9");
        map3.put("66","99");
        list66.add(map3);


        System.out.println("------->开始");
        System.out.println(list);
        System.out.println(list.removeAll(list66));
        System.out.println(list66);
        System.out.println(list);

        List list7 = new Vector();
        list7.add("666");

        System.out.println(list7);

        System.out.println("----------------->");

        System.out.println(list);

        int size  =list.size();
        for (int i = 0; i < size ; i++) {
            list.remove(list.get(i));
        }

        list.clear();

        System.out.println(list);


    }

}


class Test01{

    public static int  test(){
        int i = 0;
        try{
            i++;
            System.out.println("try block, i = "+i);
            return i;
        }catch(Exception e){ //NumberFormatException
            i++;
            System.out.println("catch block i = "+i);
            return i;
        }finally{
            i++;
            System.out.println("finally block i = "+i);
        }

    }

    public static Collection  test1(){
        List<String> list = new ArrayList<String>();
        try{
            list.add("step try");
            System.out.println("try block");
            return list;
        }catch(Exception e){
            list.add("step catch");
            System.out.println("catch block");
            return list;
        }finally{
            list.add("step finally");
            System.out.println("finally block ");
        }
    }

    public static void main(String[] args) {
        System.out.println(test());
        System.out.println(test1().toString());


        final ArrayList list = new ArrayList();
        list.add("666");
        ArrayList var1 = list;
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        System.out.println(var1);


        int i = 0;
        int var2 = i;
        i++;
        System.out.println(var2);

        try {
            // do something System...
            System.out.println("step fourth:--->try running");
            System.exit(1);

        }finally {
            System.out.println("step fourth:--->finally run");
        }


        StringBuilder stringBuilder = new StringBuilder();
        StringBuffer stringBuffer = new StringBuffer();


        Random  random = new Random();
        random.nextInt();
        System.out.println(random.nextInt());


    }
}

class Test02 extends ClassLoader{

    public static int get(){
        int res = 0 ;
        int i = 10;

        try {
            res++;
            int j = i/(res-1);
            return res;
        }catch (RuntimeException e){
            e.printStackTrace();
            return i;
        }finally {
            res+=10000000;
            i=100;
//            return 100;
        }

    }

    public static void main(String[] args) {
//        System.out.println(get());

      Map map =  Collections.synchronizedMap(new HashMap<>());

    }

}
