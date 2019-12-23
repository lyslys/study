package com.utils;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 时间工具类
 *
 * @author liangyansheng
 *
 **/
public class DateUtils {

    /**
     * 2个日期的比较
     *
     * @param arrayDate
     * @return
     */
    public static String[] arraySort(String[] arrayDate) {
        String[] arrayDate1 = new String[]{"", ""};
        String dateBegin = arrayDate[0];
        String dateEnd = arrayDate[1];
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        try {
            c1.setTime(dateFormat.parse(dateBegin));
            c2.setTime(dateFormat.parse(dateEnd));
            int result = c1.compareTo(c2);
            if (result > 0) {
                arrayDate1[0] = dateEnd;
                arrayDate1[1] = dateBegin;
            }
            if (result < 0) {
                arrayDate1[1] = dateEnd;
                arrayDate1[0] = dateBegin;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayDate1;
    }

    /**
     * 判断2个时间段相差多少天
     * @param startDate
     * @param endDate
     * @return
     * @throws ParseException
     */
    public static int getDateInterval(String startDate, String endDate) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        Date date1, date2;
        try {
            date1 = formatter.parse(startDate);
            date2 = formatter.parse(endDate);
            cal1.setTime(date1);
            cal2.setTime(date2);
            return cal2.get(Calendar.DAY_OF_YEAR)
                    - cal1.get(Calendar.DAY_OF_YEAR);
        } catch (ParseException e) {
            e.printStackTrace();

        }
        return 0;
    }

    /**
     * 判断是否闰年
     * @param year
     * @return
     */
    public static boolean isLeapYear(int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, Calendar.DECEMBER, 31);
        if (cal.get(Calendar.DAY_OF_YEAR) == 366) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取 2018712192948 格式的时间
     * @param date
     * @return
     */
    public static String getDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String result = sdf.format(date);
        return result;
    }


    /**
     * 将短时间格式时间转换为字符串 yyyy-MM-dd HH:mm:ss
     */
    public static String dateToStr(Date dateDate) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(dateDate);
    }

    /**
     * 将短时间格式时间转换为字符串 yyyy-MM-dd HH:mm:ss
     */
    public static String dateToStrTwo(Date dateDate) {
        return new SimpleDateFormat("yyyy/MM/dd HH:mm").format(dateDate);
    }

    /**
     * 时间戳转换成日期格式字符串  yyyy-MM-dd HH:mm:ss
     */
    public static String timesTampToStr(Timestamp dateTimestamp) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(dateTimestamp);
    }

    /**
     * Timestamp 转 Date
     */
    public static Date timestampToDate(Timestamp ts) {
        Date date = ts;
        date = new Date(ts.getTime());
        return  date;
    }

    /**
     * 小时转毫秒数
     */
    public static BigDecimal hoursToSeconds(BigDecimal hours) {
        return  hours.multiply(new BigDecimal(3600000));
    }

    /**
     * 将毫秒数转为*天*小时*分*秒
     * @param mss 要转换的毫秒数
     * @return 该毫秒数转换为 * days * hours * minutes * seconds 后的格式
     * @author fy.zhang
     */
    public static String formatDuring(long mss) {
        long days = mss / (1000 * 60 * 60 * 24);
        long hours = (mss % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
        long minutes = (mss % (1000 * 60 * 60)) / (1000 * 60);
        long seconds = (mss % (1000 * 60)) / 1000;

        String str = "";

        if(days>0){
            str+=days + "天";
        }
        if(hours>0){
            str+=hours + "时";
        }
        if(minutes>0){
            str+=minutes + "分";
        }
        if(seconds>0){
            str+=seconds + "秒";
        }

        return  str;

//        return days + "天" + hours + "时" + minutes + "分"
//                + seconds + "秒";
    }

    /**
     * 时间搓转字符串
     * @param time
     * @return
     */
    public static String convertLongToString(Long time){
        SimpleDateFormat sdf= new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        //前面的lSysTime是秒数，先乘1000得到毫秒数，再转为java.util.Date类型
        Date dt = new Date(time * 1000);
        String sDateTime = sdf.format(dt);  //得到精确到秒的表示：08/31/2006 21:08:00
        System.out.println(sDateTime);
        return  sDateTime;
    }

    /**
     *计算timestamp 间隔多少小时
     */
    public static BigDecimal timesTampApart(Timestamp startTimestamp, Timestamp endTimestamp) {
        return  new BigDecimal((endTimestamp.getTime() - startTimestamp.getTime())/(1000*60*60));
    }

    /**
     *计算 总超速 平均每小时的速度
     */
    public static BigDecimal averageSpeed(Double overSpeedMileage,Timestamp startTimestamp, Timestamp endTimestamp) {
        BigDecimal bigDecimal = timesTampApart(startTimestamp,endTimestamp);
        if(bigDecimal.intValue()==0){
            return new BigDecimal(0);
        }
        return  new BigDecimal(overSpeedMileage).divide(bigDecimal,2, RoundingMode.HALF_UP);
    }

    /**
     * 将秒数转换为时分秒，
     * @param second
     * @return
     */
    public static String secondToTime(long second){
       /* long days = second / 86400;            //转换天数
        second = second % 86400;            //剩余秒数*/
        long hours = second / 3600;            //转换小时
        second = second % 3600;                //剩余秒数
        long minutes = second /60;            //转换分钟
        second = second % 60;                //剩余秒数
        String result = hours + "小时" + minutes + "分" + second + "秒";
        System.err.println(result);
        return result;
    }

    /**
     * 日期转星期
     *
     * @param datetime
     * @return
     */
    public static String dateToWeek(String datetime) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
        Calendar cal = Calendar.getInstance(); // 获得一个日历
        Date datet = null;
        try {
            datet = f.parse(datetime);
            cal.setTime(datet);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1; // 指示一个星期中的某天。
        if (w < 0)
            w = 0;
        return weekDays[w];
    }

    public static void main(String[] args) throws Exception{

//        System.out.println(dateToWeek("2019-02-21"));

//        System.out.println((1533266141000L-1530414936000L)/(1000*60*60));
//            System.out.println(new BigDecimal(200).divide(new BigDecimal(792),2, RoundingMode.HALF_UP));
//        String  date = getDate(new Date());
//        System.out.println(date);\
        //    AgentBuilder.Listener.StreamWriting.toSystemOut( averageSpeed(200,new Timestamp(1530414936000),1533266141000));
      /*  108882000

        333351000*/
//        System.out.println(formatDuring(333351000L));

//        System.out.println(hoursToSeconds(new BigDecimal(0.5)));


        DateTimeFormat.main(args);

    }

    /**
     * 1.8
     */

    static class  DateTimeFormat {

        public static void main(String[] args) throws ParseException {

	/*java.time包内，有几个比较重要的组件，Instant（时间戳）；LocalDate（日期）；LocalDate（时间）；LocalDateTime（日期时间）；
	ZonedDateTime（带有区域信息的日期时间，比如中国默认使用的是东八区）。Period（如两个日期之间相差的天数）；Druation（两个日期时间之间间隔的秒和纳秒）。*/

            Instant now = Instant.now();
            System.out.println(now.toString());  // 2018-08-06T09:44:13.677Z  (utc时间格式，标准时间格式)
            System.out.println(now.get(ChronoField.MILLI_OF_SECOND)); //毫秒 677
            System.out.println(now.get(ChronoField.MICRO_OF_SECOND)); //微秒 677000
            System.out.println(now.get(ChronoField.NANO_OF_SECOND));  //纳秒 677000000
            System.out.println(ZoneId.systemDefault());  // Asia/Shanghai
            LocalDateTime localDateTime = LocalDateTime.ofInstant(now, ZoneId.systemDefault());
            LocalDate localDate = LocalDate.now();  //
            System.out.println(localDate);  //2018-08-06
            System.out.println(localDateTime); //2018-08-06T17:44:13.677

            // 获得当前日期
            LocalDate localDate1 = LocalDate.now();
            System.out.println(localDate1.toString());
            // 日期加上1天
            LocalDate localDate2 = localDate1.plusDays(1);
            System.out.println(localDate2.toString());
            // 日期加上一周
            LocalDate localDate3 = localDate1.plusWeeks(1);
            System.out.println(localDate3);
            // 计算当前年的第52天是几月几号
            System.out.println("今年的第52天 = " + localDate1.withDayOfYear(52));

            // 字符串转日期
            DateTimeFormatter strToDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            TemporalAccessor dateTemporal = strToDateFormatter.parse("2017-01-01 13:00:00");
            LocalDate date = LocalDate.from(dateTemporal);
            System.out.println(date);
            LocalDateTime dateTime = LocalDateTime.parse("2017-01-01 13:00:00", strToDateFormatter);
            System.out.println(dateTime.toString());



            // 格式化日期
            LocalDateTime localDateTime1 = LocalDateTime.now();
            DateTimeFormatter dateToStrFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String dateStr = dateToStrFormatter.format(localDateTime1);
            System.out.println("dateStr:"+dateStr);

            // 只处理时间
            LocalTime localTime = LocalTime.now();
            System.out.println("local time = " + localTime);
            System.out.println("plus 12 hours = " + localTime.plusHours(12));

            /**
             * Period代表的是两个日期之间的天、月、年数差值，当然，我们也可以直接使用日期中的until方法来完成同样的效果。
             */

            LocalDate startDate = LocalDate.now();
            LocalDate endDate = startDate.plusDays(1);

            Period period = Period.between(startDate, endDate);
            System.out.println("间隔的天数" + period.getDays());
            System.out.println("间隔的月数:" + period.getMonths());
            System.out.println("间隔的年数:" + period.getYears());

            // 直接使用日期类中的方法计算日期间隔
            long days = startDate.until(endDate, ChronoUnit.DAYS);
            System.out.println("间隔的天数:" + days);
            long weeks = startDate.until(endDate, ChronoUnit.WEEKS);
            System.out.println("间隔的周数:" + weeks);

            /*Duration表示的是两个日期时间间隔的秒以及纳秒数。*/
            LocalDateTime start = LocalDateTime.now();
            LocalDateTime end = start.plusDays(1);
            Duration duration = Duration.between(start, end);
            System.out.println("间隔的秒数:" + duration.get(ChronoUnit.SECONDS));
            //System.out.println("间隔的毫秒数:" + duration.get(ChronoUnit.MICROS));
            System.out.println("间隔的纳秒数:" + duration.get(ChronoUnit.NANOS));


            ///////////////////////////////
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            String dateTimeF = LocalDateTime.now().format(fmt); //将当前时间转换为  2017-10-19 10:25:36
            //将时间装换为long值      时间戳
            long currentTime = LocalDateTime.parse(dateTimeF,fmt).atZone(ZoneId.of("Asia/Shanghai")).toInstant().toEpochMilli();
            System.out.println("时间戳:"+currentTime);
            //将long转为格式化时间字符串
            String timeNow = fmt.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(currentTime),ZoneId.of("Asia/Shanghai")));
            System.out.println("时间:"+timeNow);

            /* Date转LocalDate：*/
            Date date11 = new Date();
            LocalDate localDate11 = date11.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            System.out.println(localDate11);
            /*  LocalDate 转 Date:*/
            LocalDateTime localDateTime22 = LocalDateTime.now();
            ZoneId zoneId = ZoneId.systemDefault();
            ZonedDateTime zdt = localDateTime22.atZone(zoneId);
            Date dateType = Date.from(zdt.toInstant());
            //Date dateType = Date.from(localDateTime22.atZone(ZoneId.systemDefault()).toInstant());
            System.out.println("LocalDateTime = " + localDateTime22);
            System.out.println("Date = " + dateType);

            //jdk 1.7
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat sdf2 = new SimpleDateFormat("MM/dd/yyyy");
            Date date33 = sdf.parse("2018-08-08");
            String aaa = sdf2.format(date33);
            System.out.println(aaa);
        }




        public static List<String> getDateArrayList(String startTime, String endTime) throws ParseException{

            List<String> dateArrayList = new ArrayList<String>();
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            long stime=sdf.parse(startTime).getTime();
            long etime=sdf.parse(endTime).getTime();
            while(stime<=etime){
                String time=sdf.format(new Date(stime));
                dateArrayList.add(time);
                stime += 24*60*60*1000;
            }
            return dateArrayList;
        }

    }

}