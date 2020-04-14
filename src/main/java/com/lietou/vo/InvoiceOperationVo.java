package com.lietou.vo;

import java.util.List;

import com.lietou.model.AssignDetail;

import lombok.Data;

@Data
public class InvoiceOperationVo {
	
	private Long id;

    private Long cId;
    
    private Long createrId;
    
    private Long invoiceId;
    
    private Integer version;
    
    private String remark;
    
    private Integer status;
    
    private String updateTime;
    
    private String expectTime;
    
    private String collectionDate;
    
    private Integer charged;
    
    private String refundMoneyType;
    
    private Integer refundMoney;
    
    private Integer assignMoney;
    
    private List<AssignDetail> assignDetailList;
    
    private Long assignId;
    
    private Integer feeCharge;
}
