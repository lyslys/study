package com.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorUtil {

    private static final Pattern mobile_pattern = Pattern.compile("1\\d{10}");

    public static boolean isMobile(String src) {
        if (StringUtils.isEmpty(src)) {
            return false;
        }
        Matcher m = mobile_pattern.matcher(src);
        return m.matches();
    }

    public static void main(String[] args) {
        System.out.println(isMobile("18682121172"));
        System.out.println(isMobile("186821211729"));
        Date date = new Date();


        int a = 1;
        int b = 6;
        int c = 8;

//        c=b=a;
        a=b=c;
//        a=c;
//        b=c;

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);


    }
}
