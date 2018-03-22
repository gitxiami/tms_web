package com.sunyard.tms.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;




/**     
 * @Description:日期转换工具类  
 * @author:zhangbin  
 * @date:2017年7月14日 上午11:28:11   
 */  
public class DateFormat {

    /**
     * 将日期转为yyyy-MM-dd
     * 
     * @param date
     * @return
     */
    public static String dateFormat1(Date date) {
        // 2011-09
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

    /**
     * 将日期转为yyyyMMdd
     * 
     * @param date
     * @return
     */
    public static String dateFormat(Date date) {
        // 2011-09
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.format(date);
    }

    /**
     * 将日期转为HH:mm:ss
     * 
     * @param date
     * @return
     */
    public static String datetimeFormat(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(date);
    }

    /**
     * 获取日期的年份
     * 
     * @param date
     * @return
     */
    public static String getYear(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        return sdf.format(date);
    }

    /**
     * 获取日期的月份
     * 
     * @param date
     * @return
     */
    public static String getMonth(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM");
        return sdf.format(date);
    }

    /**
     * 获取日期的日
     * 
     * @param date
     * @return
     */
    public static String getDay(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd");
        return sdf.format(date);
    }

    /**
     * 将日期转为yyyy-MM-dd HH:mm:ss输出
     * 
     * @param date
     * @return
     */
    public static String dateTimeFormat(Date date) {
        // 2011-09
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    /**
     * 将日期转为yyyyMMddHHmmss输出
     * 
     * @param date
     * @return
     */
    public static String dateTimeFormat1(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(date);
    }

    public static String dateTimeFormatSSS(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return sdf.format(date);
    }

    /**
     * 将yyyyMMddHHmmss转为yyyy-MM-dd HH:mm:ss格式输出
     * 
     * @param date
     * @return yyyy-MM-dd HH:mm:ss
     */
    public static String StringToDate1(String date) {
        String d = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddHHmmss");
        try {
            d = sdf.format(sdf1.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
            return date;
        }
        return d;
    }

    /**
     * 将yyyyMMdd转为yyyy-MM-dd 格式输出
     * 
     * @param date
     * @return yyyy-MM-dd
     */
    public static String StringToDate2(String date) {
        String d = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
        try {
            d = sdf.format(sdf1.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
            return date;
        }
        return d;
    }

    /**
     * 计算2个时间相差几秒
     * 
     * @param beginDate
     * @param endDate
     * @return
     */
    public static long comPareDate(String beginDate, String endDate) {
        SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long between = 0;
        Date begin;
        Date end;
        try {
            begin = dfs.parse(beginDate);
            end = dfs.parse(endDate);
            between = (end.getTime() - begin.getTime()) / 1000;// 除以1000是为了转换成秒
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return between;
    }

    /**
     * 计算2个时间相差几秒
     * 
     * @param beginDate
     * @param endDate
     * @return
     */
    public static long comPareDate(Date beginDate, Date endDate) {

        long between = (beginDate.getTime() - endDate.getTime()) / 1000;// 除以1000是为了转换成秒

        return between;
    }
    
    /**
     * 
     * @Title: getDate @Description: 根据指定格式以及时间构造Date @param @param
     *         format @param @param date @param @return @param @throws
     *         ParseException @return Date @throws
     */
    public static Date getDate(String format, String date) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.parse(date);
    }
}
