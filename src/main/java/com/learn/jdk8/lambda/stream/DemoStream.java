package com.learn.jdk8.lambda.stream;

import com.model.User;

import java.util.*;
import java.util.stream.Stream;

public class DemoStream<T> {

    private T t;

   public DemoStream(T t){
        this.t =t;
   }

    public T get(){
        return t;
    }

    public void dosomething(){
       if(t instanceof User){
           ((User) t).setName("马云");
           System.out.println(t);
       }else if(t instanceof Integer){
           System.out.println("---->"+t);
       }
    }

    public static void main(String[] args) {
        DemoStream demoStream = new DemoStream(123456);
        System.out.println(demoStream.get());
        DemoStream<User> demoStream2 = new DemoStream<User>(new User("18","张三"));
        demoStream.dosomething();
        demoStream2.dosomething();



//        List<String> list =  new ArrayList<>();
//        list.add("我在家");
//        list.add("吖吖6");
//        list.add("吖吖66");
//        list.add("吖吖666");
//        list.add("吖吖6666");
//        list.add("吖吖66666");
//        list.add("吖吖666666");

//        list.stream().filter(name->name.startsWith("我"))
//                .filter(name->name.length()==3)
//                .forEach(name->System.out.println(name));

//        list.forEach(System.out::println);
    }
}

class GetStream {

    public static void main(String[] args) {

        //map 转stream流
        Map<String,String> map = new HashMap<>();
        map.put("a", "vv");
        map.put("a2", "vv2");
        Set<Map.Entry<String,String>> entries = map.entrySet();
        Stream<Map.Entry<String,String>> stream = entries.stream();

        stream.forEach(en->System.out.println(en));

        Stream<Integer> stream1 = Stream.of(1,2,3);
        Integer[] arr = {7,8,9};
        Stream<Integer> stream2 = Stream.of(arr);

        //----
        Stream<String> stream3 = Stream.of("张三","梁少","梁少少");
        stream3.filter(name->name.startsWith("张"));
        stream3.forEach(name-> System.out.println(name));
        stream3.forEach(name-> System.out.println(name));

    }


}

/**
 * 数据类型转换
 */
class GetStreamMap {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("1","2","3");
        Stream<Integer> stream1 = stream.map(str->Integer.parseInt(str));
        stream1.forEach(i->System.out.println(i));
    }
}

/**
 * 计算总数Count
 */
class StreamCount {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("1","2","3");
        Stream<Integer> stream1 = stream.map(str->Integer.parseInt(str));
        System.out.println(stream1.count());
    }
}

/**
 * 取前几个
 */
class StreamLimit {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("1","2","3");
        Stream<Integer> stream1 = stream.map(str->Integer.parseInt(str)).limit(1);
        stream1.forEach(i->System.out.println(i));
    }
}

/**
 * 跳过
 */
class StreamSkip {
    public static void main(String[] args) {
//        Stream<String> stream = Stream.of("张三","梁少","梁少少").skip(4);
        Stream<String> stream = Stream.of("张三","梁少","梁少少");
        Stream<String> stream2 = Stream.of("1","2","3");
        Stream.concat(stream, stream2).forEach(i->System.out.println(i));
        Stream<String> concat = Stream.concat(stream, stream2);

    }
}

/*
    练习：集合元素处理（Stream方式）
    将上一题当中的传统for循环写法更换为Stream流式处理方式。
    两个集合的初始内容不变，Person类的定义也不变。
 */
class Demo02StreamTest {
    public static void main(String[] args) {
        //第一支队伍
        ArrayList<String> one = new ArrayList<>();
        one.add("迪丽热巴");
        one.add("宋远桥");
        one.add("苏星河");
        one.add("石破天");
        one.add("石中玉");
        one.add("老子");
        one.add("庄子");
        one.add("洪七公");
        //1. 第一个队伍只要名字为3个字的成员姓名；存储到一个新集合中。
        //2. 第一个队伍筛选之后只要前3个人；存储到一个新集合中。
        Stream<String> oneStream = one.stream().filter((name)->name.length()==3).limit(3);

        //第二支队伍
        ArrayList<String> two = new ArrayList<>();
        two.add("古力娜扎");
        two.add("张无忌");
        two.add("赵丽颖");
        two.add("张三丰");
        two.add("尼古拉斯赵四");
        two.add("张天爱");
        two.add("张二狗");
        //3. 第二个队伍只要姓张的成员姓名；存储到一个新集合中。
        //4. 第二个队伍筛选之后不要前2个人；存储到一个新集合中。
        Stream<String> twoStream =  two.stream().filter(name->name.startsWith("张")).skip(2);

        //5. 将两个队伍合并为一个队伍；存储到一个新集合中。
        //6. 根据姓名创建Person对象；存储到一个新集合中。
        //7. 打印整个队伍的Person对象信息。
        Stream.concat(oneStream, twoStream).map(name->new Person(name)).forEach(p->System.out.println(p));
    }
}

 class Person {

    private String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

