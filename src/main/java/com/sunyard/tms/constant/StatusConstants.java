package com.sunyard.tms.constant;

/**
 * 
 * @ClassName: UserConstants
 * @Description: 用户常量类
 * @author jiaq.zheng
 * @date 2016年6月12日
 *
 */
/**     
 * @Description:TODO  
 * @author:zhangbin  
 * @date:2017年8月16日 上午9:43:29   
 */  
public class StatusConstants {

    /**
     * 用户状态：正常
     */
    public static final String OPERATPR_NORMAL = "0";

    /**
     * 用户状态：注销
     */
    public static final String OPERATPR_LOGOFF = "1";

    /**
     * 用户状态：锁定
     */
    public static final String OPERATPR_LOCK = "2";

    /**
     * 机构的两种状态
     */
    public static final String ORG_NORMAL = "1";
    public static final String ORG_DELETE = "2";
    /**
     * 机构等级
     */
    public static final String ORG_LV_MASTER = "0";
    public static final String ORG_LV_BRANCH = "1";
    public static final String ORG_LV_SUBBRANCH = "2";

    /**
     * 角色的两种状态
     */
    public static final String ROLE_BPS = "1";
    public static final String ROLE_BMS = "2";

    /**
     * 权限类型
     */
    public static final String POPEDOM_LIST = "1";
    public static final String POPEDOM_BUTTON = "2";
    
    /**
     * 权限来源
     */
    public static final String POPEDOM_BPS = "1";
    public static final String POPEDOM_BMS = "0";

    /**
     * 设备领用状态
     */
    public static final String DEVFLAG_LIBRARY = "1";//未领用
    public static final String DEVFLAG_USE = "2";//已领用
    public static final String DEVFLAG_WAY = "";//在途（设备调拨功能已废弃）
    
    /**
     * 领用记录中的设备领用状态
     */
    public static final String CONSINFO_USE = "1";//未归还
    public static final String CONSINFO_RTN = "2";//已归还

    /**
     * 设备状态
     */
    public static final String DEVSTATUS_STORAGE = "0";//入库
    public static final String DEVSTATUS_ENABLE = "1";//启用
    public static final String DEVSTATUS_DISABLE = "2";//停用
    public static final String DEVSTATUS_CANCLE = "3";//注销

    /**
     * 设备类型
     */
    public static final String DEVTYPE_PAD = "1";
    public static final String DEVTYPE_CLIP = "2";

    /**
     * 终端主密钥状态
     */
    public static final String TMK_UNISSUED = "1";
    public static final String TMK_ISSUED = "2";
    public static final String TMK_EXPORT = "3";
    
    /**
     * 设备报修状态
     */
    public static final String DEVREPSTATUS_REPAIR = "1";
    public static final String DEVREPSTATUS_RECOVERY = "2";
    public static final String DEVREPSTATUS_REJECT = "3";
    
    /**
     * 调拨类型
     */
    public static final String BATCHTYPE_ISSUE = "1";//下发
    public static final String BATCHTYPE_RESUE = "2";//上缴
    
    /**
     * 批次状态
     */
    public static final String BATCHSTATUS_UNTREATED = "0";//未处理
    public static final String BATCHSTATUS_PROCESSED = "1";//已接收
    
    /**
     * App应用状态应用状态：0-未上线1-上线2-下线3-删除
     */
    public static final String APP_NOTONLINE = "0";
    public static final String APP_ONLINE = "1";
    public static final String APP_OFFLINE = "2";
    public static final String APP_DELETE = "3";
    /**
     * App类型 01-android应用 02-ios应用
     */
    public static final String APP_ANDROID="1";
    public static final String APP_IOS="2";
    /**
     * App应用包状态 0-未发布，1-已发布
     */
    public static final String APP_PACKAGE_NO_PUBLISH="0";
    public static final String APP_PACKAGE_PUBLISH="1";
    
    /**
     * 固件状态：0-未上线1-上线2-下线3-删除
     */
    public static final String FIRM_NOTONLINE = "0";
    public static final String FIRM_ONLINE = "1";
    public static final String FIRM_OFFLINE = "2";
    public static final String FIRM_DELETE = "3";
    
    /**
     * 操作日志状态
     */
    public static final String LOG_SUCCESS="1";
    public static final String LOG_FAIL="0";
    
    /**
     * 审核状态
     */
    public static final String AUDIT_DOING = "0";
    public static final String AUDIT_PASS = "1";
    public static final String AUDIT_FAIL = "2";
    
    /**
     * 产品类型 1产品 2目录
     */
    public static final String PRODUCT_PRODUCT = "1";
    public static final String PRODUCT_CATALOG = "2";
    
    /**
     * 产品删除状态 1正常 2已删除
     */
    public static final String PRODUCT_NORMAL = "1";
    public static final String PRODUCT_DELETED = "2";
    
    /**
     * 卡种收取年费 1不收取 2收取
     */
    public static final String ANNUAL_FEE_UNABLE = "1";
    public static final String ANNUAL_FEE_ABLE = "2";
    
    /**
     * 交易状态 1成功 2失败 3未决
     */
    public static final String TRADE_FLAG_SUC = "1";
    public static final String TRADE_FLAG_FAIL = "2";
    public static final String TRADE_FLAG_OUTSTD = "3";
    
    /**
     * 操作员状态
     */
    public static final String OP_STATUS_NORMAL = "0";//正常
    public static final String OP_STATUS_CANCEL = "1";//注销
    public static final String OP_STATUS_LOCKED = "2";//锁定

    /**
     * 商户状态
     */
    public static final String MERCHAT_NOTENABLED = "0";//未启用
    public static final String MERCHAT_ENABLED = "1";//启用
    public static final String MERCHAT_STOP = "2";//停用
    public static final String MERCHAT_DEL = "3";//注销
    public static final String MERCHAT_LOCK = "4";//锁定
    
    /**
     * 操作员状态
     */
    public static final String MODEL_TYPE_HOLD = "1";   // 手持POS
    public static final String MODEL_TYPE_CLOUD = "2";  // 云POS
    public static final String MODEL_TYPE_FINANCE = "3";// 金融POS
    public static final String MODEL_TYPE_MOBILE = "4"; // 移动手机POS
    public static final String MODEL_TYPE_M = "5";      // MPOS
    public static final String MODEL_TYPE_TEL = "6";    // 电话POS
    
    /**
     * 终端主密钥使用状态
     */
    public static final String USE_FLAG_ISUSED = "0";// 已使用
    public static final String USE_FLAG_UNUSED = "1";// 未使用
}
