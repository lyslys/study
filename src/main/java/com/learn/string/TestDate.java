package com.learn.string;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class TestDate {

    public static void main(String[] args) {

//        System.exit(0);

        //返回当前系统时间与计算机元年之间的毫秒差
        //1970-1-1 00:00:00
        System.out.println(System.currentTimeMillis());

        Date date1 = new Date(1566979025894L);
        Date date2 = new Date();
        System.out.println(date2);

        System.out.println(date1.before(date2));
        System.out.println(date1.after(date2));

        date1.setTime(1566979025895L);
        System.out.println(date1.getTime());

        //按照顺序比较 -1调用在前参数在后 1相反 0相等
        System.out.println(date1.compareTo(date2));


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(date1));


        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);
        calendar.set(Calendar.YEAR, 2016);
        System.out.println(calendar.after(date1));
        System.out.println(calendar.getTimeZone());
        System.out.println(calendar.getTime());
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH)); //从0开始
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println(calendar.getTimeInMillis());

        TimeZone timeZone = calendar.getTimeZone();
//        TimeZone.getDefault();

        System.out.println(timeZone.getID());
        System.out.println(timeZone.getDisplayName());
        System.out.println(timeZone);

    }
}
