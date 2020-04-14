package com.lietou.util;

/**
 * 定义缓存KEY
 *
 * @author wusiwei
 */
public class CacheKeyConstant {
	
	/**
	 * 用户菜单相关
	 * 公司id:用户id
	 */
    public static final String USER_MENU_VUENAME = "USER:MENU:VUENAME:%s:%s";
    
	/**
	 * 假期缓存
	 */
    public static final String ADS_ATTENDANCE_HOLIDAYS = "ADS:ATTENDANCE:HOLIDAYS:%s:%s";

    /**
	 * 每人考勤打卡记录
	 * 日期:公司id:用户id
	 */
    public static final String ADS_ATTENDANCE_CLOCK_RECORD = "ADS:ATTENDANCE:CLOCK:%s:%s:%s";
    
    /**
	 * 每人考勤打卡记录
	 * 用户id:部门id:日期
	 */
    public static final String PERSONAL_COMPANY_JOIN = "PERSONAL:COMPANY:JOIN";
    
    /**
	 * 用户菜单相关
	 * 用户id:部门id
	 */
    public static final String USER_MENU = "USER:MENU:%s:%s";
    
    /**
	 * 用户菜单相关
	 * 用户id:部门id
	 */
    public static final String USER_ALLMENU = "USER:ALLMENU:%s:%s";
    
    /**
	 * 用户顶部公共菜单相关
	 */
    public static final String USER_ALLMENU_PUBLICTOPMEMU = "USER:ALLMENU:PUBLICTOPMEMU";
    
    /**
	 * 发送注册验证码
	 */
    public static final String SMS_VCODE_REGISTER = "SMS:VCODE:REGISTER:%s";
    
    /**
	 * 发送重置密码验证码
	 */
    public static final String SMS_VCODE_RESETPASSWORD = "SMS:VCODE:RESETPASSWORD:%s";
    
    /**
	 * 安装包code缓存
	 */
    public static final String MANAGE_PACKAGE_CODE = "MANAGE:PACKAGE:CODE:%s";
    
    /**
	 * 轮播code缓存
	 */
    public static final String MANAGE_CAROUSEL_CODE = "MANAGE:CAROUSEL:CODE:%s";
    
    /**
	 * 省市缓存
	 */
    public static final String MANAGE_PROVINCES_CITIES = "MANAGE:PROVINCES:CITIES";
    
    /**
	 * 省市区缓存
	 */
    public static final String MANAGE_PROVINCES_CITIES_AREA = "MANAGE:PROVINCES:CITIES:AREA";


    
    /**
	 * 公司连接服务器配置
	 */
    public static final String COMPANY_SERVER_CONFIG = "COMPANY:SERVER:CONFIG:%s";
    
    /**
	 * 应用通知的订阅通道
	 */
    public static final String APPLICATION_NOTICE_CHANNEL = "APPLICATION:NOTICE:CHANNEL";
    
    /**
	 * 系统配置
	 */
    public static final String ADMIN_SERVER_CONFIG = "ADMIN:SERVER:CONFIG";
    
    /**
	 * 字典表根据类别缓存
	 */
    public static final String DICT_CLASSIFY_TREE = "DICT:CLASSIFY:TREE:%s";
}
