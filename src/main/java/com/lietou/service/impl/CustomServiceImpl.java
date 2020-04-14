package com.lietou.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.lietou.dto.CustomDto;
import com.lietou.dto.RemarkBaseDto;
import com.lietou.dto.RemarkDto;
import com.lietou.dto.TalentDto;
import com.lietou.mapper.CustomMapper;
import com.lietou.mapper.FocusMapper;
import com.lietou.mapper.RemarkMapper;
import com.lietou.model.Focus;
import com.lietou.model.Remark;
import com.lietou.model.ResetBO;
import com.lietou.service.CustomService;
import com.lietou.util.DateFormatUtil;
import com.lietou.util.Page;
import com.lietou.util.ResultResponse;
import com.lietou.vo.CustomVo;
import com.lietou.vo.RemarkVo;

@Service
public class CustomServiceImpl implements CustomService{
	
	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private CustomMapper customMapper;
	
	@Autowired
	private FocusMapper focusMapper;
	
	@Autowired
	private RemarkMapper remarkMapper;
	
	@Override
	public ResultResponse<?> add(CustomVo customVo) {
		ResultResponse<Integer> result = new ResultResponse<Integer>();
		String nowStr=DateFormatUtil.date2String(new Date(), DateFormatUtil.FORMAT_YYYY_MM_DD_SS_NO_SPACE);
		customVo.setCreateTime(nowStr);
		customVo.setRecentlyTime(nowStr);
		customVo.setCustomState(2);
		customVo.setFocusStr("");
		result.setData(customMapper.voInsertSelective(customVo));
		result.setCode("20000");
		result.setMessage("新建成功");
		return result;
	}
	
	@Override
	public ResultResponse<?> modify(CustomVo customVo) {
		ResultResponse<Integer> result = new ResultResponse<Integer>();
		result.setData(customMapper.voUpdateByPrimaryKeySelective(customVo));
		result.setCode("20000");
		result.setMessage("修改成功");
		return result;
	}
	
	@Override
	public Page getCustomList(CustomVo queryVO) {
		Page page = Page.getContext();
		int totalCount = customMapper.countCustomList(queryVO);
		queryVO.setTotalNum(totalCount);
		page.setCurrentPage(queryVO.getCurrentPage());
		page.setPageSize(queryVO.getPageSize());
		page.setTotalRows(totalCount);
		if (totalCount > 0) {
			List<CustomDto> dtoList=customMapper.getCustomList(queryVO);
			String createrId=queryVO.getCreaterId()+",";
			for(CustomDto dto : dtoList){
				dto.setFocusFlag(StringUtils.contains(dto.getFocusStr(), createrId));
			}
			page.setData(dtoList);
		} else {
			page.setData(new ArrayList<>());
		}
		return page;
	}
	
	@Override
	public ResultResponse<?> modifyShortName(CustomVo customVo) {
		ResultResponse<Integer> result = new ResultResponse<>();
		result.setData(customMapper.modifyShortName(customVo));
		result.setCode("20000");
		result.setMessage("别名修改成功");
		return result;
	}
	
	@Override
	@Transactional
	public ResultResponse<?> focus(CustomVo customVo) {
		ResultResponse<Integer> result = new ResultResponse<>();
		Focus focus=new Focus();
		focus.setBusinessId(customVo.getId());
		focus.setBusinessType("custom");
		focus.setCreaterId(customVo.getCreaterId());
		int a=focusMapper.checkFocus(focus);
		if(a == 0){
			focus.setCreateTime(DateFormatUtil.date2String(new Date(), DateFormatUtil.FORMAT_YYYY_MM_DD_SS_NO_SPACE));
			focusMapper.insertSelective(focus);
			customVo.setFocusStr(customVo.getCreaterId()+",");
			customMapper.modifyFocusStr(customVo);
		}
		result.setCode("20000");
		result.setMessage("关注成功");
		return result;
	}
	
	@Override
	@Transactional
	public ResultResponse<?> unFocus(CustomVo customVo) {
		ResultResponse<Integer> result = new ResultResponse<>();
		Focus focus=new Focus();
		focus.setBusinessId(customVo.getId());
		focus.setBusinessType("custom");
		focus.setCreaterId(customVo.getCreaterId());
		focusMapper.removeFocus(focus);
		customVo.setFocusStr(customVo.getCreaterId()+",");
		customMapper.unFocusStr(customVo);
		result.setCode("20000");
		result.setMessage("取消关注成功");
		return result;
	}
	
	@Override
	public ResultResponse<?> getById(CustomVo customVo) {
		ResultResponse<CustomDto> result = new ResultResponse<>();
		CustomDto dto=customMapper.getById(customVo);
		dto.setFocusFlag(StringUtils.contains(dto.getFocusStr(), customVo.getCreaterId()+","));
		result.setData(dto);
		result.setCode("20000");
		result.setMessage("查询明细成功");
		return result;
	}
	
	@Override
	@Transactional
	public ResultResponse<?> addRemark(Remark remark) {
		ResultResponse<Integer> result = new ResultResponse<Integer>();
		String nowStr=DateFormatUtil.date2String(new Date(), DateFormatUtil.FORMAT_YYYY_MM_DD_SS_NO_SPACE);
		remark.setCreateTime(nowStr);
		remark.setBusinessType("custom");
		result.setData(remarkMapper.insertSelective(remark));
		ResetBO bo =new ResetBO();
		bo.setBusinessId(remark.getBusinessId());
		bo.setBusinessType("custom");
		bo.setCId(remark.getcId());
		customMapper.resetRemarkCount(bo);
		result.setCode("20000");
		result.setMessage("新建备注成功");
		return result;
	}
	
	@Override
	public ResultResponse<?> modifyRemark(Remark remark) {
		ResultResponse<Integer> result = new ResultResponse<Integer>();
		remark.setBusinessType("custom");
		result.setData(remarkMapper.modify(remark));
		result.setMessage("修改备注成功");
		return result;
	}
	
	@Override
	@Transactional
	public ResultResponse<?> deleteRemark(RemarkVo vo) {
		ResultResponse<Integer> result = new ResultResponse<Integer>();
		vo.setBusinessType("custom");
		result.setData(remarkMapper.deleteByIds(vo));
		ResetBO bo =new ResetBO();
		bo.setBusinessId(vo.getBusinessId());
		bo.setBusinessType("custom");
		bo.setCId(vo.getCId());
		customMapper.resetRemarkCount(bo);
		result.setCode("20000");
		result.setMessage("删除备注成功");
		return result;
	}
	
	@Override
	public ResultResponse<?> getRemarkById(RemarkVo vo) {
		ResultResponse<RemarkDto> result = new ResultResponse<>();
		result.setData(remarkMapper.getById(vo));
		result.setCode("20000");
		result.setMessage("查询明细成功");
		return result;
	}
	
	@Override
	public ResultResponse<?> getAllRemark(RemarkVo vo) {
		ResultResponse<List<RemarkBaseDto>> result = new ResultResponse<List<RemarkBaseDto>>();
		vo.setBusinessType("custom");
		List<RemarkDto> remarkDtoList=remarkMapper.getAllRemark(vo);
		List<RemarkBaseDto> rList=new ArrayList<RemarkBaseDto>(7);
		
		boolean indexFlag=CollectionUtils.isNotEmpty(remarkDtoList);
		int baseSize = indexFlag ? 8 : 0;
		RemarkBaseDto allDto=new RemarkBaseDto("all","所有项目",indexFlag ? remarkDtoList.size() : 0 );
		RemarkBaseDto basicDto=new RemarkBaseDto("basic","基本情况",baseSize);
		RemarkBaseDto generalDto=new RemarkBaseDto("general","公司概况",baseSize);
		RemarkBaseDto productDto=new RemarkBaseDto("product","产品情况",baseSize);
		RemarkBaseDto salaryDto=new RemarkBaseDto("salary","薪资福利",baseSize);
		RemarkBaseDto satisfactionDto=new RemarkBaseDto("satisfaction","满意调查度",baseSize);
		RemarkBaseDto remarkDto=new RemarkBaseDto("remark","备注",baseSize);
		
		if(indexFlag){
			Map<String, RemarkBaseDto> dtoMap=new HashMap<String, RemarkBaseDto>(6);
			dtoMap.put("basic", basicDto);
			dtoMap.put("general", generalDto);
			dtoMap.put("product", productDto);
			dtoMap.put("salary", salaryDto);
			dtoMap.put("satisfaction", satisfactionDto);
			dtoMap.put("remark", remarkDto);
			for(RemarkDto dto : remarkDtoList){
				allDto.getDetailList().add(dto);
				dtoMap.get(dto.getCategory()).getDetailList().add(dto);
			}
		}
		rList.add(allDto);
		rList.add(basicDto);
		rList.add(generalDto);
		rList.add(productDto);
		rList.add(salaryDto);
		rList.add(satisfactionDto);
		rList.add(remarkDto);
		result.setData(rList);
		result.setCode("20000");
		result.setMessage("查询明细成功");
		return result;
	}
}
