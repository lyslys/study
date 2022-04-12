package com.utils;

import java.util.Random;

public class CreatePasswd {

    public static String getRandomPassword(int len) {
        String result = null;
        while (len >= 6) {
            result = makeRandomPassword(len);
            if (result.matches(".*[a-z]{1,}.*") && result.matches(".*[A-Z]{1,}.*") && result.matches(".*\\d{1,}.*") && result.matches(".*[~!@#$%^&*\\.?]{1,}.*")) {
                return result;
            }
        }
        return "长度不得少于6位!";
    }

    public static  String makeRandomPassword(int len) {
        char charr[] = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890~!@#$%^&*.?".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        for (int x = 0; x < len; ++x) {
            sb.append(charr[r.nextInt(charr.length)]);
        }
        return sb.toString();
    }

    //生成随机用户名，数字和字母组成,
    public static String getRandomString(int length) {

        String val = "";
        Random random = new Random();

        //参数length，表示生成几位随机数
        for (int i = 0; i < length; i++) {

            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            //输出字母还是数字
            if ("char".equalsIgnoreCase(charOrNum)) {
                //输出是大写字母还是小写字母
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char) (random.nextInt(26) + temp);
            } else {
                int n;
                do{
                   n =  random.nextInt(10);
                }while (n == 4);
                val += String.valueOf(n);
            }
        }
        return val;
    }

    public static void main(String[] args) {
        System.out.println(getRandomPassword(8));
        System.out.println((int)((Math.random()*9+1)*10000));
        System.out.println(getRandomString(6));
    }

}
