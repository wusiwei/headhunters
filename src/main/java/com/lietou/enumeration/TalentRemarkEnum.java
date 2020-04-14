package com.lietou.enumeration;


public enum TalentRemarkEnum {
	
	candidateCall("candidateCall", "候选人电话"),
	candidateInterview("candidateInterview", "顾问面试"),
	candidateInterview2("candidateInterview2", "顾问面试 详细"),
	customCall("customCall", "客户电话"),
	customMeeting("customMeeting", "客户拜访"),
	other("other", "其他");
	
	private String code;
    private String label;
    
    private TalentRemarkEnum(String code, String label) {
        this.code = code;
        this.label = label;
    }
    public String code() {
        return code;
    }

    public String label() {
        return label;
    }
}
