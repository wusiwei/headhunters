package com.lietou.util;

public class ResultResponse<E> {

    public final static String CODE_SUCCESS = "20000";
    public final static String CODE_ERROR = "500";

    public final static String ERROR_MES = "系统异常，重新操作，多次失败请联系IT！";

    private String code;

    private E data;

    private String message;
    
	public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
