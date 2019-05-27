package com.zyjg.adtech.bigscreen.utils;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


public class DateUtil {


    /**
     * 格式化日期
     *
     * @param str 2014-1-4类型
     * @return date类型
     * @author xch
     * 日期：2014-1-4
     */
    public static Date formatDate(String str) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            return format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 格式化日期
     *
     * @param 无，自动取当前日期
     * @return 字符串类型 2014-04-22
     * @author xch
     * 日期：2014-1-4
     */
    public static String formatDate() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(new Date());
    }

    /**
     * 格式化日期
     *
     * @param date类型
     * @return 字符串类型 2014-04-22
     * @author xch
     * 日期：2014-1-4
     */
    public static String formatDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }

    /**
     * 格式化时间
     *
     * @param date
     * @return
     * @throws ParseException
     * @author xch
     * 日期：2013-12-13
     */
    public static Date getDate(Date date) {
        try {
            if (null == date)
                date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return format.parse(format.format(date));
        } catch (Exception e) {
            e.printStackTrace();
            return new Date();
        }
    }

    /**
     * 格式化时间
     *
     * @param date
     * @return
     * @throws ParseException
     * @author xch
     * 日期：2013-11-21
     */
    public static Date getDate() {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return format.parse(format.format(new Date()));
        } catch (Exception e) {
            e.printStackTrace();
            return new Date();
        }
    }

    /**
     * 获得时间字符串
     *
     * @return
     */
    public static String getTime() {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return format.format(new Date());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取昨天日期格式为20190401
     *
     * @return
     */
    public static String yesterday() {
        try {
            Date yesterday = new Date(new Date().getTime() - 86400000L);//86400000L，它的意思是说1天的时间=24小时 x 60分钟 x 60秒 x 1000毫秒 单位是L。
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
            return format.format(yesterday);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 获取本月
     * 201808
     *
     * @return
     */
    public static String getMoth() {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
            return format.format(new Date());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 获取当年日期
     * yyyyMMdd
     *
     * @return
     */
    public static String getThisDay() {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        return format.format(new Date());
    }

    /**
     * 获取上一年 yyyy
     *
     * @return
     */
    public static String getLastYear() {
        Calendar c = Calendar.getInstance();
        return String.valueOf(c.get(Calendar.YEAR) - 1);
    }

    /**
     * 获取这一年 yyyy
     *
     * @return
     */
    public static String getThisYear() {
        Calendar c = Calendar.getInstance();
        return String.valueOf(c.get(Calendar.YEAR));
    }

    /**
     * 2      * <li>功能描述：时间相减得到天数
     * 3      * @param beginDateStr
     * 4      * @param endDateStr
     * 5      * @return
     * 6      * long
     * 7      * @author Administrator
     * 8
     */
    public static long getDaySub(String beginDateStr, String endDateStr) {
        long day = 0;
        SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");
        Date beginDate;
        Date endDate;
        try {
            beginDate = format.parse(beginDateStr);
            endDate = format.parse(endDateStr);
            day = (endDate.getTime() - beginDate.getTime()) / (24 * 60 * 60 * 1000);
            //System.out.println("相隔的天数="+day);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return day;
    }


    public static void main(String args[]) {
        System.out.println(yesterday());
    }

}
