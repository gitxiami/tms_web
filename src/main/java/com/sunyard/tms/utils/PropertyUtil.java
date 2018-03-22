package com.sunyard.tms.utils;
  
import com.sunyard.tms.constant.ConfigConstants;

import java.io.IOException;
import java.util.Properties;  
  
/** 
 *  
 * 读取properties文件的工具类 
 * 
 *
 */  
public class PropertyUtil {
    //错误提示信息
    private static Properties p = new Properties();
    //系统参数
    private static Properties params = new Properties();
  
    /** 
     * 读取properties配置文件信息 
     */  
    static{  
        try {
            p.load(PropertyUtil.class.getClassLoader().getResourceAsStream(ConfigConstants.SYSTEM_MSG));
            params.load(PropertyUtil.class.getClassLoader().getResourceAsStream(ConfigConstants.SYSTEM_CONFIG));
        } catch (IOException e) {  
            e.printStackTrace();   
        }  
    }  
    /** 
     * 根据key得到value的值 
     */  
    public static String getValue(String key)  
    {  
        return p.getProperty(key);  
    }

    public static String getParam(String key){return params.getProperty(key);}
} 