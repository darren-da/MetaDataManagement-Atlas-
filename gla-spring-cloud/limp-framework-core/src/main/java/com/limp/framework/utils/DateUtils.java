package com.limp.framework.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: zzh
 * Date: 16-7-18
 * Time: 下午9:29
 * To change this template use File | Settings | File Templates.
 */
public class DateUtils {
    /**
     * 获得当前时间
     * @param format yyyy-MM-dd HH:mm:ss 24小时进制  hh
     * @return
     */
    public static String getFormatDate(String format){
        Date date = new Date();
        if (format == null || "".equals(format.trim())) {
            return "";
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.format(date);
        } catch (Exception e) {
        }
        return "";
    }
    public static String getFormatDate(String format,Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(date);
    }

    public static Integer getBeforeDay(Date autoExp,Date today){
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(autoExp);
        Integer autoDay=calendar.get(Calendar.DAY_OF_YEAR);
        int y1 = calendar.get(Calendar.YEAR);//过期年份
        calendar.setTime(today);
        Integer nowDay=calendar.get(Calendar.DAY_OF_YEAR);

        int y2 = calendar.get(Calendar.YEAR); //现在年份
        if(y1>y2){
            return DateUtils.getCompDay(autoExp,today);
        }
        System.out.println(y1+":"+y2);

        return autoDay-nowDay;
    }
    public static Integer getCompDay(Date autoExp,Date today){
        Calendar cal = Calendar.getInstance();
        cal.setTime(autoExp);
        long time1 = cal.getTimeInMillis();
        cal.setTime(today);
        long time2 = cal.getTimeInMillis();
        long betweenDays=(time1-time2)/(1000*3600*24);
       return Integer.parseInt(String.valueOf(betweenDays));
    }

        public static Date getDateByString(String dateStr,String format){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = simpleDateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return date;
    }

    public static Date getEndTime(Date date){
        Calendar end = Calendar.getInstance();
        end.setTime(date);
        end.set(Calendar.HOUR_OF_DAY,23);
        end.set( Calendar.MINUTE,59);
        end.set(Calendar.SECOND,59);
        return end.getTime();
    }

    /**
     *
     * 功能描述: 根据日期获取当月天数
     *
     * @param: 
     * @param date
     * @return: int
     * @author: zhangbo
     * @date: 2019/1/3 12:25
     */
    public static int getDayByMonth(Date date){
        Calendar dayDate = Calendar.getInstance();
        dayDate.setTime(date);
        dayDate.set(Calendar.DATE, 1);
        dayDate.roll(Calendar.DATE, -1);
        int maxDate = dayDate.get(Calendar.DATE);
        return maxDate;
    }

    /**
     *
     * 功能描述: 获得当前时间 Timestamp yyyy-MM-dd HH:mm:ss
     *
     * @param:
     * @return: Timestamp
     * @author: zhangbo
     * @date: 2019/3/13 14:49
     */
    public static Timestamp getTimestamp(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Timestamp nowTime = Timestamp.valueOf(sdf.format(new Date()));
        return nowTime;
    }

    public static void main(String[] args) {
        //System.out.println(DateUtils.getFormatDate("yyyy-MM-dd HH:mm:ss"));
        System.out.println(DateUtils.getBeforeDay(DateUtils.getDateByString("2019-09-20","yyyy-MM-dd"),new Date()));
    }
}
