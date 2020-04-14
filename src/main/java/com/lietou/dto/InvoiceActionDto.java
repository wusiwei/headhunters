package com.lietou.dto;

import lombok.Data;

@Data
public class InvoiceActionDto{
	private String statusLabel;
	private Boolean edit;
	private Boolean approve; //审批
	private Boolean make; //开票
	private Boolean charge; //收款
	private Boolean refundinvoice; //退票
	private Boolean refundmoney; //退款
	private Boolean assign; //分配
	private Boolean grant; //发放
	private Boolean back; //回退
	
	public InvoiceActionDto(){
		
	}
	
	/**
	 * 
	 * @param edit
	 * @param approve 审批
	 * @param make 开票
	 * @param charge 收款
	 * @param refundinvoice 退票
	 * @param refundmoney 退款
	 * @param assign 分配
	 * @param grant 发放
	 * @param back 回退
	 */
	public InvoiceActionDto(String statusLabel,Boolean edit,Boolean approve,Boolean make,Boolean charge,Boolean refundinvoice
			,Boolean refundmoney,Boolean assign,Boolean grant,Boolean back){
		this.statusLabel=statusLabel;
		this.edit = edit;
		this.approve = approve; 
		this.make = make; 
		this.charge = charge; 
		this.refundinvoice = refundinvoice; 
		this.refundmoney = refundmoney; 
		this.assign = assign; 
		this.grant = grant; 
		this.back = back; 
	}
}
