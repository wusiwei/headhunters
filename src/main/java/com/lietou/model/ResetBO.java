package com.lietou.model;

import lombok.Data;

@Data
public class ResetBO {
	private Long businessId;
	
	private Long cId;
	
	private String nowTimeStr;
	
	private String businessType;
}
