package com.lietou.vo;

import com.lietou.util.PageBaseModel;

import lombok.Data;

@Data
public class CustomVo extends PageBaseModel{
	private Long id;

    private String name;

    private String type;

    private Long industry;

    private Long industry1;

    private Long industry2;

    private Long city;

    private Long customFolder;

    private String fullName;

    private String shortName;

    private String invoiceStart;

    private String phone;

    private String webSite;

    private String address;

    private String email;

    private String financing;

    private String setUpTime;

    private String source;

    private String salaryStructure;

    private String product;

    private String scale;

    private String production;

    private String opponent;

    private String workday;

    private String welfare1;

    private String welfare2;

    private Boolean shareFlag;

    private String createTime;

    private Boolean deleteFlag;

    private String customerProfile;

    private String unnamedProfile;

    private String bdOr;

    private Integer customState;

    private String recentlyTime;

    private Integer contractCount;

    private Integer invoiceCount;

    private Integer jobCount;

    private Integer jobLievcount;

    private Integer remarkCount;

    private Integer attachmentCount;

    private Integer remindCount;

    private String focusStr;
    
    private Long createrId;

    private Long cId;
    
}
