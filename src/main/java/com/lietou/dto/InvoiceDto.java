package com.lietou.dto;

import java.util.List;

import com.lietou.model.Invoice;

import lombok.Data;

@Data
public class InvoiceDto extends Invoice{
	
	private String statusLabel;
	
	private List<InvoiceRecordDto> recordList;
	
	private InvoiceActionDto invoiceAction;
}
