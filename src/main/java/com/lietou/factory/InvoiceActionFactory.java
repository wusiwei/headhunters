package com.lietou.factory;

import com.lietou.dto.InvoiceActionDto;

public class InvoiceActionFactory {
	
	public static InvoiceActionDto createDto(int actionType){
		switch (actionType) {
			case 0: return new InvoiceActionDto("审批驳回",true,false,false,false,false,false,false,false,false);//已拒绝
			case 2: return new InvoiceActionDto("申请中",true,true,true,false,false,false,false,false,true);//申请中
			case 3: return new InvoiceActionDto("待收款",false,false,false,true,true,false,false,false,true);//待收款
			case 4: return new InvoiceActionDto("收到付款",false,false,false,false,false,true,true,false,true);//收到付款
			case 5: return new InvoiceActionDto("分配",false,false,false,false,false,true,false,true,true);//分配
			case 6: return new InvoiceActionDto("已发放",false,false,false,false,false,true,false,false,true);//已发放
			case 10: return new InvoiceActionDto("发票退回",false,false,false,false,false,false,false,false,true);//发票退回
			case 11: return new InvoiceActionDto("部分退款",false,false,false,false,false,false,false,false,true);//部分退款  收到付款
			case 12: return new InvoiceActionDto("全部退款",false,false,false,false,false,false,false,false,true);//全部退款  收到付款
			case 13: return new InvoiceActionDto("部分退款",false,false,false,false,false,false,false,false,true);//部分退款  分配
			case 14: return new InvoiceActionDto("全部退款",false,false,false,false,false,false,false,false,true);//全部退款  分配
			case 15: return new InvoiceActionDto("部分退款",false,false,false,false,false,false,false,false,true);//部分退款  已发放
			case 16: return new InvoiceActionDto("全部退款",false,false,false,false,false,false,false,false,true);//全部退款  已发放
			default: return new InvoiceActionDto("审批驳回",true,false,false,false,false,false,false,false,false);
		}
	}
	
}
