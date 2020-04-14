package com.lietou.mapper;

import java.util.List;

import com.lietou.common.BaseMapper;
import com.lietou.dto.InvoiceDto;
import com.lietou.model.Invoice;
import com.lietou.model.ResetBO;
import com.lietou.vo.InvoiceOperationVo;
import com.lietou.vo.InvoiceVo;

public interface InvoiceMapper extends BaseMapper<Invoice>{
	List<InvoiceDto> getList(InvoiceVo vo);
	
	int countList(InvoiceVo vo);
	
	Invoice getById(InvoiceVo vo);
	
	int deleteByIds(InvoiceVo vo);
	
	int resetInvoiceCount(ResetBO vo);
	
	int midify(Invoice record);
	
	Invoice getByIdAndVersion(InvoiceOperationVo vo);
	
	int invoiceOperation(Invoice record);
}