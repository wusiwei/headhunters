package com.lietou.enumeration;


public enum TalentStatusEnum {
	
	Active("Active", "想看机会"),
	Inactive("Inactive", "现状稳定"),
	NeedContact("NeedContact", "需要联系"),
	Shortlist("Shortlist", "加入项目"),
	Recommend("Recommend", "推荐客户"),
	Interview("Interview", "客户面试"),
	Successful("Successful", "成功Offer"),
	Onboard("Onboard", "保证期中"),
	Formal("Formal", "过保证期"),
	Eliminate("Eliminate", "项目淘汰"),
	NotConsider("NotConsider", "人选不考虑"),
	Black("Black", "黑名单"),
	Unconnected("Unconnected", "未接通"),
	Follow("Follow", "跟进"),
	Empty("Empty", "空号"),
	NoStatus("NoStatus", "无状态");
	
	private String code;
    private String label;
    
    private TalentStatusEnum(String code, String label) {
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
