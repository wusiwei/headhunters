package com.lietou.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lietou.dto.InvoiceDto;
import com.lietou.factory.InvoiceActionFactory;
import com.lietou.mapper.InvoiceMapper;
import com.lietou.model.Invoice;
import com.lietou.model.ResetBO;
import com.lietou.service.InvoiceService;
import com.lietou.util.DateFormatUtil;
import com.lietou.util.Page;
import com.lietou.util.ResultResponse;
import com.lietou.vo.InvoiceVo;

@Service
public class InvoiceServiceImpl implements InvoiceService{
	
	private static final Logger log = LoggerFactory.getLogger(InvoiceServiceImpl.class);
	
	@Autowired
	private InvoiceMapper invoiceMapper;
	
	@Override
	public Page getList(InvoiceVo queryVO) {
		Page page = Page.getContext();
		int totalCount = invoiceMapper.countList(queryVO);
		queryVO.setTotalNum(totalCount);
		page.setCurrentPage(queryVO.getCurrentPage());
		page.setPageSize(queryVO.getPageSize());
		page.setTotalRows(totalCount);
		if (totalCount > 0) {
			List<InvoiceDto> dtoList= invoiceMapper.getList(queryVO);
			for(InvoiceDto dto : dtoList){
				dto.setInvoiceAction(InvoiceActionFactory.createDto(dto.getStatus()));
				dto.setStatusLabel(dto.getInvoiceAction().getStatusLabel());
			}
			page.setData(dtoList);
		} else {
			page.setData(new ArrayList<>());
		}
		return page;
	}
	
	@Override
	@Transactional
	public ResultResponse<?> add(Invoice record) {
		ResultResponse<Integer> result = new ResultResponse<Integer>();
		String nowStr=DateFormatUtil.date2String(new Date(), DateFormatUtil.FORMAT_YYYY_MM_DD_SS_NO_SPACE);
		record.setCreateTime(nowStr);
		record.setStatus(2);
		record.setUpdateTime(nowStr);
		result.setData(invoiceMapper.insertSelective(record));
		ResetBO bo=new ResetBO();
		bo.setBusinessId(record.getCustomerId());
		bo.setCId(record.getcId());
		invoiceMapper.resetInvoiceCount(bo);
		result.setCode("20000");
		result.setMessage("新建成功");
		return result;
	}
	
	@Override
	public ResultResponse<?> modify(Invoice record) {
		ResultResponse<Integer> result = new ResultResponse<Integer>();
		String nowStr=DateFormatUtil.date2String(new Date(), DateFormatUtil.FORMAT_YYYY_MM_DD_SS_NO_SPACE);
		record.setUpdateTime(nowStr);
		result.setData(invoiceMapper.midify(record));
		result.setCode("20000");
		result.setMessage("修改成功");
		return result;
	}
	
	@Override
	public ResultResponse<?> getById(InvoiceVo vo) {
		ResultResponse<Invoice> result = new ResultResponse<Invoice>();
		result.setData(invoiceMapper.getById(vo));
		result.setCode("20000");
		result.setMessage("获取明细成功");
		return result;
	}
	
	@Override
	@Transactional
	public ResultResponse<?> deleteByIds(InvoiceVo vo) {
		ResultResponse<Integer> result = new ResultResponse<Integer>();
		result.setData(invoiceMapper.deleteByIds(vo));
		ResetBO bo=new ResetBO();
		bo.setBusinessId(vo.getCustomerId());
		bo.setCId(vo.getCId());
		invoiceMapper.resetInvoiceCount(bo);
		result.setCode("20000");
		result.setMessage("删除成功");
		return result;
	}
	
}
