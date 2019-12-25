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

    public static void main(String[] args) {
        System.out.println(getRandomPassword(16));
        System.out.println((int)((Math.random()*9+1)*10000));
    }

}
