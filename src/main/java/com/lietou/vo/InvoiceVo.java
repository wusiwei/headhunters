package com.lietou.vo;

import com.lietou.util.PageBaseModel;

import lombok.Data;

@Data
public class InvoiceVo extends PageBaseModel{
	private Long id;

    private Long cId;
    
    private Long customerId;
    
    private Long[] ids;
}