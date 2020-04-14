package com.lietou.mapper;

import com.lietou.common.BaseMapper;
import com.lietou.model.AssignDetail;
import com.lietou.vo.InvoiceOperationVo;

public interface AssignDetailMapper extends BaseMapper<AssignDetail>{
	
	int batchAddAssignDetail(InvoiceOperationVo vo);
	
	int batchUpdateAssignDetail(InvoiceOperationVo vo);
	
	int batchAddPerformance(InvoiceOperationVo vo);
	
	int batchUpdatePerformance(InvoiceOperationVo vo);
}