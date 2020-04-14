package com.lietou.service.impl;

import java.util.ArrayList;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.lietou.dto.CustomContactDto;
import com.lietou.mapper.CustomContactMapper;
import com.lietou.mapper.CustomContactRecordMapper;
import com.lietou.model.CustomContact;
import com.lietou.model.CustomContactRecord;
import com.lietou.model.ResetBO;
import com.lietou.service.CustomContactService;
import com.lietou.util.DateFormatUtil;
import com.lietou.util.Page;
import com.lietou.util.ResultResponse;
import com.lietou.vo.CustomContactVo;

@Service
public class CustomContactImpl implements CustomContactService{
	
	private static final Logger log = LoggerFactory.getLogger(CustomContactImpl.class);
	
	@Autowired
	private CustomContactMapper customContactMapper;
	
	@Autowired
	private CustomContactRecordMapper customContactRecordMapper;
	
	@Override
	public Page getList(CustomContactVo queryVO) {
		Page page = Page.getContext();
		int totalCount = customContactMapper.countList(queryVO);
		queryVO.setTotalNum(totalCount);
		page.setCurrentPage(queryVO.getCurrentPage());
		page.setPageSize(queryVO.getPageSize());
		page.setTotalRows(totalCount);
		if (totalCount > 0) {
			page.setData(customContactMapper.getList(queryVO));
		} else {
			page.setData(new ArrayList<>());
		}
		return page;
	}
	
	@Override
	@Transactional
	public ResultResponse<?> add(CustomContact customContact) {
		ResultResponse<Integer> result = new ResultResponse<>();
		customContact.setCreateTime(DateFormatUtil.date2String(new Date(), DateFormatUtil.FORMAT_YYYY_MM_DD_SS_NO_SPACE));
		result.setData(customContactMapper.insertSelective(customContact));
		ResetBO bo=new ResetBO();
		bo.setBusinessId(customContact.getCustomerId());
		bo.setCId(customContact.getcId());
		customContactMapper.resetContactCount(bo);
		result.setCode("20000");
		result.setMessage("新建成功");
		return result;
	}
	
	@Override
	public ResultResponse<?> modify(CustomContact customContact) {
		ResultResponse<Integer> result = new ResultResponse<>();
		customContact.setCreateTime(DateFormatUtil.date2String(new Date(), DateFormatUtil.FORMAT_YYYY_MM_DD_SS_NO_SPACE));
		result.setData(customContactMapper.updateByPrimaryKeySelective(customContact));
		result.setCode("20000");
		result.setMessage("修改成功");
		return result;
	}
	
	@Override
	public ResultResponse<?> getById(CustomContactVo vo) {
		ResultResponse<CustomContactDto> result = new ResultResponse<CustomContactDto>();
		result.setData(customContactMapper.getById(vo));
		result.setCode("20000");
		result.setMessage("获取明细成功");
		return result;
	}
	
	@Override
	@Transactional
	public ResultResponse<?> deleteByIds(CustomContactVo vo) {
		ResultResponse<Integer> result = new ResultResponse<>();
		result.setData(customContactMapper.deleteByIds(vo));
		ResetBO bo=new ResetBO();
		bo.setBusinessId(vo.getCustomerId());
		bo.setCId(vo.getCId());
		customContactMapper.resetContactCount(bo);
		result.setCode("20000");
		result.setMessage("删除成功");
		return result;
	}
	
	@Override
	public ResultResponse<?> addContactRecord(CustomContactRecord record) {
		ResultResponse<Integer> result = new ResultResponse<>();
		record.setCreateTime(DateFormatUtil.date2String(new Date(), DateFormatUtil.FORMAT_YYYY_MM_DD_SS_NO_SPACE));
		result.setData(customContactRecordMapper.insertSelective(record));
		result.setCode("20000");
		result.setMessage("新建成功");
		return result;
	}
	
	@Override
	public ResultResponse<?> modifyContactRecord(CustomContactRecord record) {
		ResultResponse<Integer> result = new ResultResponse<>();
		record.setCreateTime(DateFormatUtil.date2String(new Date(), DateFormatUtil.FORMAT_YYYY_MM_DD_SS_NO_SPACE));
		result.setData(customContactRecordMapper.updateByPrimaryKey(record));
		result.setCode("20000");
		result.setMessage("修改成功");
		return result;
	}
	
	@Override
	public ResultResponse<?> getRecordById(Long id) {
		ResultResponse<CustomContactRecord> result = new ResultResponse<CustomContactRecord>();
		result.setData(customContactRecordMapper.selectByPrimaryKey(id));
		result.setCode("20000");
		result.setMessage("获取明细成功");
		return result;
	}
	
}
