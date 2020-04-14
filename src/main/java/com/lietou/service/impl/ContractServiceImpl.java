package com.lietou.service.impl;

import java.util.ArrayList;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lietou.mapper.ContractMapper;
import com.lietou.model.Contract;
import com.lietou.model.ResetBO;
import com.lietou.service.ContractService;
import com.lietou.util.DateFormatUtil;
import com.lietou.util.Page;
import com.lietou.util.ResultResponse;
import com.lietou.vo.ContractVo;

@Service
public class ContractServiceImpl implements ContractService{
	
	private static final Logger log = LoggerFactory.getLogger(ContractServiceImpl.class);
	
	@Autowired
	private ContractMapper contractMapper;
	
	@Override
	public Page getList(ContractVo queryVO) {
		Page page = Page.getContext();
		int totalCount = contractMapper.countList(queryVO);
		queryVO.setTotalNum(totalCount);
		page.setCurrentPage(queryVO.getCurrentPage());
		page.setPageSize(queryVO.getPageSize());
		page.setTotalRows(totalCount);
		if (totalCount > 0) {
			page.setData(contractMapper.getList(queryVO));
		} else {
			page.setData(new ArrayList<>());
		}
		return page;
	}
	
	@Override
	@Transactional
	public ResultResponse<?> add(Contract contract) {
		ResultResponse<Integer> result = new ResultResponse<Integer>();
		String nowStr=DateFormatUtil.date2String(new Date(), DateFormatUtil.FORMAT_YYYY_MM_DD_SS_NO_SPACE);
		contract.setCreateTime(nowStr);
		result.setData(contractMapper.insertSelective(contract));
		ResetBO bo=new ResetBO();
		bo.setBusinessId(contract.getCustomerId());
		bo.setCId(contract.getcId());
		contractMapper.resetContractCount(bo);
		result.setCode("20000");
		result.setMessage("新建成功");
		return result;
	}
	
	@Override
	public ResultResponse<?> modify(Contract contract) {
		ResultResponse<Integer> result = new ResultResponse<Integer>();
		result.setData(contractMapper.updateByPrimaryKeySelective(contract));
		result.setCode("20000");
		result.setMessage("修改成功");
		return result;
	}
	
	@Override
	public ResultResponse<?> getById(ContractVo vo) {
		ResultResponse<Contract> result = new ResultResponse<Contract>();
		result.setData(contractMapper.getById(vo));
		result.setCode("20000");
		result.setMessage("获取明细成功");
		return result;
	}
	
	@Override
	@Transactional
	public ResultResponse<?> deleteByIds(ContractVo vo) {
		ResultResponse<Integer> result = new ResultResponse<Integer>();
		result.setData(contractMapper.deleteByIds(vo));
		ResetBO bo=new ResetBO();
		bo.setBusinessId(vo.getCustomerId());
		bo.setCId(vo.getCId());
		contractMapper.resetContractCount(bo);
		result.setCode("20000");
		result.setMessage("删除成功");
		return result;
	}
	
}
