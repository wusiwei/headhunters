package com.lietou.util;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import org.apache.commons.lang3.StringUtils;


public class EnAndDeCodeUtils {
	
	private static MessageDigest md5;
	
	private final static String[] hexDigits = {"0", "1", "2", "3", "4", "5", "6", "7",  
            "8", "9", "a", "b", "c", "d", "e", "f"};  
	
	static{
		try {
			md5=MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 将字符串使用base64加密
	 * @param str
	 * @return String
	 */
	public static String encodeByBase64(String str){
        if(StringUtils.isBlank(str)){
        	return "";
        }
        byte[] b=null;
        try {
			b=str.getBytes("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        String s="";
        if(b!=null){
        	s=Base64.getEncoder().encodeToString(b);
        }
        return s;
	}
	
	public static void main(String[] args) {
		try {
			System.out.println(java.net.URLEncoder.encode("sqlyog 注册码.txt", "utf-8"));
			System.out.println(java.net.URLDecoder.decode("sqlyog+%E6%B3%A8%E5%86%8C%E7%A0%81.txt", "utf-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 将字符串使用base64解密
	 * @param str
	 * @return String
	 */
	public static String decodeByBase64(String str){
        if(StringUtils.isBlank(str)){
        	return "";
        }
        byte[] b=Base64.getDecoder().decode(str);
        String s="";
		try {
			s = new String(b,"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        return s;
	}
	
    /** 
     * 转换字节数组为16进制字串 
     * @param b 字节数组 
     * @return 16进制字串 
     */  
    public static String byteArrayToHexString(byte[] b) {  
        StringBuilder resultSb = new StringBuilder();  
        for (byte aB : b) {  
            resultSb.append(byteToHexString(aB));  
        }  
        return resultSb.toString();  
    }  
  
    /** 
     * 转换byte到16进制 
     * @param b 要转换的byte 
     * @return 16进制格式 
     */  
    private static String byteToHexString(byte b) {  
        int n = b;  
        if (n < 0) {  
            n = 256 + n;  
        }  
        int d1 = n / 16;  
        int d2 = n % 16;  
        return hexDigits[d1] + hexDigits[d2];  
    }  
  
    /** 
     * MD5编码 
     * @param origin 原始字符串 
     * @return 经过MD5加密之后的结果 
     */  
    public static String MD5Encode(String origin) {  
        String resultString = null;  
        try {  
            resultString = origin;  
            resultString = byteArrayToHexString(md5.digest(resultString.getBytes("utf-8")));  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return resultString;  
    }  
	
	
	/**
	 * 将字符串使用md5和Base64加密
	 * @param str
	 * @return String
	 */
	public static String encodeByMd5AndBase64(String str){
		String s=null;
		byte[] b=null;
		if(str!=null){
			try {
				b=md5.digest(str.getBytes("utf-8"));
				s=Base64.getEncoder().encodeToString(b);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			
		}
		return s;
	}
	
}
