package com.lietou.service;

import com.lietou.model.Invoice;
import com.lietou.util.Page;
import com.lietou.util.ResultResponse;
import com.lietou.vo.InvoiceVo;

public interface InvoiceService {

	ResultResponse<?> add(Invoice record);

	ResultResponse<?> modify(Invoice record);

	Page getList(InvoiceVo queryVO);

	ResultResponse<?> getById(InvoiceVo vo);

	ResultResponse<?> deleteByIds(InvoiceVo vo);

}
