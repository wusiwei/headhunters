package com.lietou.exception;

public class BusinessException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 31507499811275907L;

	/**
     * 异常信息
     */
    private String errorMsg;
    /**
     * 错误码
     */
    private String code;
    
	
	public BusinessException(String code,String errorMsg) {
		super();
		this.errorMsg = errorMsg;
		this.code = code;
	}
	
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
    
    
}
