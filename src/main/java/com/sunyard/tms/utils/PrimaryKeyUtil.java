package com.sunyard.tms.utils;

import java.util.Date;
import java.util.UUID;

/**     
 * @Description:主键生成工具类  
 * @author:zhangbin  
 * @date:2017年8月3日 上午8:52:24   
 */  
public class PrimaryKeyUtil {
    public static String getPrimaryKey(String mid) {
        Date date = new Date();
        String first = DateFormat.dateTimeFormat1(date);
        String thrid = UUID.randomUUID().toString().toLowerCase().replace("-", "");
        return first + mid.toUpperCase() + thrid.substring(0, 32 - first.length() - mid.length());
    }
}
