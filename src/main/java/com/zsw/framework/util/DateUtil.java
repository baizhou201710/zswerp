// Decompiled by DJ v3.7.7.81 Copyright 2004 Atanas Neshkov  Date: 2010/3/11 17:00:10
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   DateUtil.java

package com.zsw.framework.util;

import com.zsw.util.Empty;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;



 
/** 
* 2015-4-8 下午06:00:06
* author:himo
* mail:zhangyao0905@gmail.com
* descript:日期API操作类
*/ 
public class DateUtil{

    public DateUtil()
    {
    }
    public static Date lastDayOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.roll(Calendar.DAY_OF_MONTH, -1);
        return cal.getTime();
    }
    /**
     * 取得某天所在周的最后一天
     */
    public static Date getLastDayOfWeek(Date date) {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6);
        return c.getTime();
    } 
    
    /**
     * return yyyy-MM-dd
     * */
    public static String getCurrentDate()
    {
        return (new SimpleDateFormat("yyyy-MM-dd")).format(new Date());
    }
    
    /**
     * return yyyyMMdd
     * */
    public static String getCurrentDateSort()
    {
    	return (new SimpleDateFormat("yyyyMMdd")).format(new Date());
    }

    public static String getCurrentDate(String format)
    {
        SimpleDateFormat t = new SimpleDateFormat(format);
        return t.format(new Date());
    }

    /**
     * return HH:mm:ss
     * */
    public static String getCurrentTime()
    {
        return (new SimpleDateFormat("HH:mm:ss")).format(new Date());
    }

    public static String getCurrentTime(String format)
    {
        SimpleDateFormat t = new SimpleDateFormat(format);
        return t.format(new Date());
    }

    /**
     * return yyyy-MM-dd HH:mm:ss
     * */
    public static String getCurrentDateTime()
    {
        String format = "yyyy-MM-dd HH:mm:ss";
        return getCurrentDateTime(format);
    }

    public static int getDayOfWeek()
    {
        Calendar cal = Calendar.getInstance();
        return cal.get(7);
    }

    public static int getDayOfWeek(Date date)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(7);
    }

    public static int getDayOfMonth()
    {
        Calendar cal = Calendar.getInstance();
        return cal.get(5);
    }

    public static int getDayOfMonth(Date date)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(5);
    }

    public static int getMaxDayOfMonth(Date date)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.getActualMaximum(5);
    }

    public static String getFirstDayOfMonth(String date)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(parse(date));
        cal.set(5, 1);
        return (new SimpleDateFormat("yyyy-MM-dd")).format(cal.getTime());
    }

    public static int getDayOfYear()
    {
        Calendar cal = Calendar.getInstance();
        return cal.get(6);
    }

    public static int getDayOfYear(Date date)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(6);
    }

    public static int getDayOfWeek(String date)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(parse(date));
        return cal.get(7);
    }

    public static int getDayOfMonth(String date)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(parse(date));
        return cal.get(5);
    }

    public static int getDayOfYear(String date)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(parse(date));
        return cal.get(6);
    }

    public static String getCurrentDateTime(String format)
    {
        SimpleDateFormat t = new SimpleDateFormat(format);
        return t.format(new Date());
    }

    /**
     * return yyyy-MM-dd
     * */
    public static String toString(Date date)
    {
        if(date == null)
            return "";
        else
            return (new SimpleDateFormat("yyyy-MM-dd")).format(date);
    }

    /**
     * return yyyy-MM-dd HH:mm:ss
     * */
    public static String toDateTimeString(Date date)
    {
        if(date == null)
            return "";
        else
            return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(date);
    }

    public static String toString(Date date, String format)
    {
        SimpleDateFormat t = new SimpleDateFormat(format);
        return t.format(date);
    }

    /**
     * return HH:mm:ss
     * */
    public static String toTimeString(Date date)
    {
        if(date == null)
            return "";
        else
            return (new SimpleDateFormat("HH:mm:ss")).format(date);
    }
    
    /**
     * return yyyyMMddHHmmss
     * */
    public static String getCurrentDateTimeStr(){
    	return  getCurrentDateTime(Format_DateTime1);
    }

    public static int compare(String date1, String date2)
    {
        return compare(date1, date2, "yyyy-MM-dd");
    }

    public static int compareTime(String time1, String time2)
    {
        return compareTime(time1, time2, "HH:mm:ss");
    }

    public static int compare(String date1, String date2, String format)
    {
        Date d1 = parse(date1, format);
        Date d2 = parse(date2, format);
        return d1.compareTo(d2);
    }

    public static int compareTime(String time1, String time2, String format)
    {
        String arr1[] = time1.split(":");
        String arr2[] = time2.split(":");
        if(arr1.length < 2)
            throw new RuntimeException("\u9519\u8BEF\u7684\u65F6\u95F4\u503C:" + time1);
        if(arr2.length < 2)
            throw new RuntimeException("\u9519\u8BEF\u7684\u65F6\u95F4\u503C:" + time2);
        int h1 = Integer.parseInt(arr1[0]);
        int m1 = Integer.parseInt(arr1[1]);
        int h2 = Integer.parseInt(arr2[0]);
        int m2 = Integer.parseInt(arr2[1]);
        int s1 = 0;
        int s2 = 0;
        if(arr1.length == 3)
            s1 = Integer.parseInt(arr1[2]);
        if(arr2.length == 3)
            s2 = Integer.parseInt(arr2[2]);
        if(h1 < 0 || h1 > 23 || m1 < 0 || m1 > 59 || s1 < 0 || s1 > 59)
            throw new RuntimeException("\u9519\u8BEF\u7684\u65F6\u95F4\u503C:" + time1);
        if(h2 < 0 || h2 > 23 || m2 < 0 || m2 > 59 || s2 < 0 || s2 > 59)
            throw new RuntimeException("\u9519\u8BEF\u7684\u65F6\u95F4\u503C:" + time2);
        if(h1 != h2)
            return h1 <= h2 ? -1 : 1;
        if(m1 == m2)
        {
            if(s1 == s2)
                return 0;
            else
                return s1 <= s2 ? -1 : 1;
        } else
        {
            return m1 <= m2 ? -1 : 1;
        }
    }

    public static boolean isTime(String time)
    {
    	try{
	        String arr[];
	        arr = time.split(":");
	        if(arr.length < 2)
	            return false;
	        int h;
	        int m;
	        int s;
	        h = Integer.parseInt(arr[0]);
	        m = Integer.parseInt(arr[1]);
	        s = 0;
	        if(arr.length == 3)
	            s = Integer.parseInt(arr[2]);
	        return h >= 0 && h <= 23 && m >= 0 && m <= 59 && s >= 0 && s <= 59;
    	}catch( Exception e){
    		return false;
    	}
        
    }

    public static boolean isDate(String date)
    {
    	try{
	        String arr[];
	        arr = date.split("-");
	        if(arr.length < 3)
	            return false;
	        int y;
	        int m;
	        int d;
	        y = Integer.parseInt(arr[0]);
	        m = Integer.parseInt(arr[1]);
	        d = Integer.parseInt(arr[2]);
	        return y >= 0 && m <= 12 && m >= 0 && d >= 0 && d <= 31;
    	}catch(Exception e){
	    	 return false;
	    }
       
    }
    
    /**
     * 是否同一个月
     * @param date1
     * @param date2
     */
    public static boolean  isSameMonth(Date date1, Date date2){
        if (date1 == null || date2 == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        return (cal1.get(Calendar.ERA) == cal2.get(Calendar.ERA) &&
                cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
                cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH));
    }
    
    public static boolean isWeekend(Date date)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int t = cal.get(7);
        return t == 7 || t == 1;
    }

    public static boolean isWeekend(String str)
    {
        return isWeekend(parse(str));
    }
    
    /**
     * @Description: String类型毫秒数转换成日期
     * @param lo 毫秒数
     * @return String yyyy-MM-dd HH:mm:ss
     */
    public static String stringToDate(String lo){
        long time = Long.parseLong(lo);
        Date date = new Date(time);
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sd.format(date);
    }
    
    /**
     * @Description: long类型转换成日期
     *
     * @param lo 毫秒数
     * @return String yyyy-MM-dd HH:mm:ss
     */
    public static String longToDate(long lo){
        Date date = new Date(lo);
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sd.format(date);
    }
    
    /**
     * @Description: long类型生成没有符号的日期格式
     *
     * @param lo 日期毫秒数
     * @return String yyyyMMddHHmmss
     */
    public static String getLongToDate(long lo){
        Date date = new Date(lo);
        SimpleDateFormat sd = new SimpleDateFormat("yyyyMMddHHmmss");
        return sd.format(date);
    }
    
    /**
     * @Description: String类型生成没有符号的日期格式
     *
     * @param lo 日期毫秒数（字符串形式）
     * @return String yyyyMMddHHmmss
     */
    public static String getStringToDate(String lo){
        long time = Long.parseLong(lo);
        Date date = new Date(time);
        SimpleDateFormat sd = new SimpleDateFormat("yyyyMMddHHmmss");
        return sd.format(date);
    }
    
    /**
     * @Description: long类型转换成点形式的日期格式
     *
     * @param lo 日期毫秒数
     * @return String yyyy.MM.dd
     */
    public static String getLongPointDate(long lo){
        Date date = new Date(lo);
        SimpleDateFormat sd = new SimpleDateFormat("yyyy.MM.dd");
        return sd.format(date);
    }
    
    /**
     * @Description: String类型转换成点形式的日期格式
     *
     * @param lo String类型日期毫秒数
     * @return String yyyy.MM.dd
     */
    public static String getStringPointDate(String lo){
        long time = Long.parseLong(lo);
        Date date = new Date(time);
        SimpleDateFormat sd = new SimpleDateFormat("yyyy.MM.dd");
        return sd.format(date);
    }
    
    /**
     * @Description: long类型转成日期格式
     *
     * @param lo long类型日期好藐视
     * @return String yyyyMMdd
     */
    public static String getloToDate(long lo){
        Date date = new Date(lo);
        SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd");
        return sd.format(date);
    }
    
    /**
     * @Description: String类型转成日期格式
     *
     * @param lo String类型日期好藐视
     * @return String yyyyMMdd
     */
    public static String getStrToDate(String lo){
        long time = Long.parseLong(lo);
        Date date = new Date(time);
        SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd");
        return sd.format(date);
    }
    
    /**
     * @Description: long类型转换成点形式的日期格式
     *
     * @param lo 日期毫秒数
     * @return String yyyy.MM.dd  HH:mm:ss
     */
    public static String longPointDate(long lo){
        Date date = new Date(lo);
        SimpleDateFormat sd = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        return sd.format(date);
    }
    
    /**
     * @Description: String类型转换成点形式的日期格式
     * @param lo String类型日期毫秒数
     * @return String yyyy.MM.dd HH:mm:ss
     */
    public static String stringPointDate(String lo){
        long time = Long.parseLong(lo);
        Date date = new Date(time);
        SimpleDateFormat sd = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        return sd.format(date);
    }
    
    /**
     * return Date yyyy-MM-dd
     * */
    public static Date parse(String str)
    {
        if(Empty.isEmpty(str))
            return null;
        try{
        	return (new SimpleDateFormat("yyyy-MM-dd")).parse(str);
		}catch(ParseException e){
	   	 return null;
	   }
    }

    public static Date parse(String str, String format)
    {
        if(Empty.isEmpty(str))
            return null;
        try{
        	SimpleDateFormat t = new SimpleDateFormat(format);
        	return t.parse(str);
		}catch(ParseException e){
		   	 return null;
		   }
    }

    /**
     * return Date yyyy-MM-dd HH:mm:ss
     * */
    public static Date parseDateTime(String str)
    {
        if(Empty.isEmpty(str))
            return null;
        if(str.length() <= 10)
            return parse(str);
        try{
        	return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).parse(str);
		}catch(ParseException e){
		   	 return null;
		}
    }

    public static Date parseDateTime(String str, String format)
    {
        if(Empty.isEmpty(str))
            return null;
        try{
        	SimpleDateFormat t = new SimpleDateFormat(format);
        	return t.parse(str);
		}catch(ParseException e){
		   	 return null;
		}
    }

    public static Date addMinute(Date date, int count)
    {
        return new Date(date.getTime() + 60000L * (long)count);
    }

    public static Date addHour(Date date, int count)
    {
        return new Date(date.getTime() + 0x36ee80L * (long)count);
    }

    public static Date addDay(Date date, int count)
    {
        return new Date(date.getTime() + 0x5265c00L * (long)count);
    }

    public static Date addWeek(Date date, int count)
    {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(3, count);
        return c.getTime();
    }

    public static Date addMonth(Date date, int count)
    {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(2, count);
        return c.getTime();
    }

    public static Date addYear(Date date, int count)
    {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(1, count);
        return c.getTime();
    }

    public static String toDisplayDateTime(String date)
    {
        if(Empty.isEmpty(date))
            return null;
        if(isDate(date))
            return toDisplayDateTime(parse(date));
        try{
	        Date d;
	        SimpleDateFormat t = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        d = t.parse(date);
	        return toDisplayDateTime(d);
		}catch(ParseException e){
	        e.printStackTrace();
	        return "不是标准格式时间!";
		}
    }

    /**
     * return *分钟前 || *小时前 || *天前 like :2014-09-09|538天前
     * */
    public static String toDisplayDateTime(Date date)
    {
    	if(!Empty.isEmpty(date)){
    		long minite = (System.currentTimeMillis() - date.getTime()) / 60000L;
            if(minite < 60L)
                return  minite + "分钟前";
            if(minite < 1440L)
                return   minite / 60L + "小时前";
            else
                return toString(date, "yyyy-MM-dd") + " (" + minite / 1440L + "天前)";
    	}else{
    		return "暂无";
    	}
        
    }
    
    
    /**
     * return *秒前 || *分钟前 || *小时前 || *天前 || *月前 || *年前
     * */
    public static String getSpacingTimeStr(Date date){
    	if(Empty.isEmpty(date)){
    		return "暂无";
    	}
    	long delta = new Date().getTime() - date.getTime();
		if (delta < 1L * ONE_MINUTE) {
			long seconds = toSeconds(delta);
			return (seconds <= 0 ? 1 : seconds) + ONE_SECOND_AGO;
		}
		if (delta < 60L * ONE_MINUTE) {
			long minutes = toMinutes(delta);
			return (minutes <= 0 ? 1 : minutes) + ONE_MINUTE_AGO;
		}
		if (delta < 24L * ONE_HOUR) {
			long hours = toHours(delta);
			return (hours <= 0 ? 1 : hours) + ONE_HOUR_AGO;
		}
		if (delta < 48L * ONE_HOUR) {
			return "昨天";
		}
		if (delta < 30L * ONE_DAY) {
			long days = toDays(delta);
			return (days <= 0 ? 1 : days) + ONE_DAY_AGO;
		}
		if (delta < 12L * 4L * ONE_WEEK) {
			long months = toMonths(delta);
			return (months <= 0 ? 1 : months) + ONE_MONTH_AGO;
		} else {
			long years = toYears(delta);
			return (years <= 0 ? 1 : years) + ONE_YEAR_AGO;
		}
    }
    
    private static long toSeconds(long date) {
		return date / 1000L;
	}

	private static long toMinutes(long date) {
		return toSeconds(date) / 60L;
	}

	private static long toHours(long date) {
		return toMinutes(date) / 60L;
	}

	private static long toDays(long date) {
		return toHours(date) / 24L;
	}

	private static long toMonths(long date) {
		return toDays(date) / 30L;
	}

	private static long toYears(long date) {
		return toMonths(date) / 365L;
	}
    
    public  static void main(String[] args){
    	System.out.println(getCurrentDateTimeStr());
//    	Date date = DateFormatter.formatDate("2015-4-7 22:51:42",Format_DateTime);
//    	System.out.println(toDisplayDateTime(date));
//    	System.out.println(toDisplayDateTime("2015-4-7 22:51:42"));
//    	System.out.println(DateUtil.toDisplayDateTime(DateFormatter.formatDate("2015-4-7 22:51:42",DateFormatter.SIMPLE_LONG_DATE_SHOW)));
//    	System.out.println(getSpacingTimeStr(new Date()));
    }
    
    /**
	 * 按年月日创建文件夹
	 * */
    public static String getDatePath(){
    	Calendar date = Calendar.getInstance();
    	int day = date.get(Calendar.DAY_OF_MONTH);
    	int month = date.get(Calendar.MONTH) + 1;
    	int year = date.get(Calendar.YEAR);
    	return "/"+year+"/"+month+"/"+day;
    }
    
    private static final long ONE_MINUTE = 60000L;
	private static final long ONE_HOUR = 3600000L;
	private static final long ONE_DAY = 86400000L;
	private static final long ONE_WEEK = 604800000L;

	private static final String ONE_SECOND_AGO = "秒前";
	private static final String ONE_MINUTE_AGO = "分钟前";
	private static final String ONE_HOUR_AGO = "小时前";
	private static final String ONE_DAY_AGO = "天前";
	private static final String ONE_MONTH_AGO = "月前";
	private static final String ONE_YEAR_AGO = "年前";
    
    /**
     * return yyyy-MM-dd
     * */
    public static final String Format_Date = "yyyy-MM-dd";
    /**
     * return HH:mm:ss
     * */
    public static final String Format_Time = "HH:mm:ss";
    /**
     * return yyyy-MM-dd HH:mm:ss
     * */
    public static final String Format_DateTime = "yyyy-MM-dd HH:mm:ss";
    /**
     * return yyyyMMddHHmmss
     * */
    public static final String Format_DateTime1 = "yyyyMMddHHmmss";
    
    public static void mian(String[] args){
    	System.out.println(DateFormatter.formatDate(new Date(), Format_Date));
    }
}