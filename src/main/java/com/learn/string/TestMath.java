package com.learn.string;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.UUID;

public class TestMath {

    public static void main(String[] args) {

        test_random();

//        test_bigInteger();

//        test_bigDecimal();


    }


    public void test_math(){

        //向上取整
        System.out.println(Math.ceil(1.2));

        //向下取整
        System.out.println(Math.floor(1.2));

        //临近的整数 如果两边距离一样 则返回偶数
        System.out.println(Math.rint(1.4));

        //临近的整数 四舍五入
        System.out.println(Math.round(1.2));

        //选择最小的
        System.out.println(Math.min(66, 77));

        //a的b次方
        System.out.println(Math.pow(2, 3));

        //获取给定参数的平方根
        System.out.println(Math.sqrt(9));

        //随机数 [0.0 -- 1.0)
        System.out.println(Math.random()*10);

        System.out.println((Math.random()*6));

    }

    public static void test_random(){

        Random random = new Random();

        //随机产生 int取值范围的整数  有正有负
        System.out.println(random.nextInt());

        //随机  [0-10)  负数会报IllegalArgumentException 非法参数
        System.out.println(random.nextInt(10));

        //[0.0-1.0)
        System.out.println(random.nextFloat());

        //5.0--10.9范围
        System.out.println(random.nextInt(6)+5+random.nextFloat());

        //随机产生一个boolean值  true false
        System.out.println(random.nextBoolean());

        //产生一个32位的随机元素 每一个位置是一个16进制的数字
        System.out.println(UUID.randomUUID());

    }

    public static void test_bigInteger(){

        BigInteger bi1 = new BigInteger("123");
        BigInteger bi2 = new BigInteger("678");
        System.out.println( bi1.add(bi2));
        System.out.println(bi1.subtract(bi2));
        System.out.println(bi1.multiply(bi2));
        System.out.println(bi1.divide(bi2));

        System.out.println(bi1.abs());
        System.out.println(bi1.pow(2));

    }

    public static void test_bigDecimal(){

        BigDecimal decimal1 = new BigDecimal("123.6");
        BigDecimal decimal2 = new BigDecimal("678.77999");

        System.out.println(decimal2.setScale(2, BigDecimal.ROUND_FLOOR));

        System.out.println(decimal2);

        System.out.println("---------->");

        System.out.println(decimal1.add(decimal2));
        System.out.println(decimal1.subtract(decimal2));
        System.out.println(decimal1.multiply(decimal2));
        System.out.println(decimal1.divide(decimal2,2,BigDecimal.ROUND_FLOOR));

        System.out.println(decimal1.abs());
        System.out.println(decimal1.pow(2));


        //0 表示必须存在  #表示可有可无
        DecimalFormat  decimalFormat = new DecimalFormat("0000.###");
        System.out.println(decimalFormat.format(123.66));

    }


}
