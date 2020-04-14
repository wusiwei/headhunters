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

import com.lietou.bo.FavoritesBusinessBo;
import com.lietou.dto.RemarkBaseDto;
import com.lietou.dto.RemarkDto;
import com.lietou.dto.TalentDto;
import com.lietou.enumeration.TalentRemarkEnum;
import com.lietou.mapper.FocusMapper;
import com.lietou.mapper.RemarkMapper;
import com.lietou.mapper.TalentEducationMapper;
import com.lietou.mapper.TalentExperiencesMapper;
import com.lietou.mapper.TalentMapper;
import com.lietou.model.Focus;
import com.lietou.model.Remark;
import com.lietou.model.ResetBO;
import com.lietou.queryvo.TalentQueryVo;
import com.lietou.service.TalentService;
import com.lietou.util.DateFormatUtil;
import com.lietou.util.Page;
import com.lietou.util.ResultResponse;
import com.lietou.vo.RemarkVo;
import com.lietou.vo.TalentVo;

@Service
public class TalentServiceImpl implements TalentService{
	
	private static final Logger log = LoggerFactory.getLogger(TalentServiceImpl.class);
	
	@Autowired
	private TalentMapper talentMapper;
	
	@Autowired
	private TalentExperiencesMapper talentExperiencesMapper;
	
	@Autowired
	private TalentEducationMapper talentEducationMapper;
	
	@Autowired
	private FocusMapper focusMapper;
	
	@Autowired
	private RemarkMapper remarkMapper;
	
	@Override
	public Page getList(TalentQueryVo queryVO) {
		Page page = Page.getContext();
		int totalCount = talentMapper.countList(queryVO);
		queryVO.setTotalNum(totalCount);
		page.setCurrentPage(queryVO.getCurrentPage());
		page.setPageSize(queryVO.getPageSize());
		page.setTotalRows(totalCount);
		if (totalCount > 0) {
			List<TalentDto> dtoList=talentMapper.getList(queryVO);
			String createrId=queryVO.getCreaterId()+",";
			for(TalentDto dto : dtoList){
				dto.setFocusFlag(StringUtils.contains(dto.getFocusStr(), createrId));
			}
			page.setData(dtoList);
		} else {
			page.setData(new ArrayList<>());
		}
		return page;
	}
	
	@Override
	public ResultResponse<?> getById(TalentQueryVo vo) {
		ResultResponse<TalentDto> result = new ResultResponse<TalentDto>();
		TalentDto dto=talentMapper.getDetailById(vo);
		dto.setFocusFlag(StringUtils.contains(dto.getFocusStr(), vo.getCreaterId()+","));
		result.setData(dto);
		result.setCode("20000");
		result.setMessage("获取明细成功");
		return result;
	}
	
	@Override
	@Transactional
	public ResultResponse<?> add(TalentVo vo) {
		ResultResponse<Integer> result = new ResultResponse<>();
		String nowStr=DateFormatUtil.date2String(new Date(), DateFormatUtil.FORMAT_YYYY_MM_DD_SS_NO_SPACE);
		vo.setCreateTime(nowStr);
		vo.setUpdateTime(nowStr);
		vo.setStatus("NoStatus");
		vo.setFocusStr("");
		talentMapper.voInsert(vo);
		talentExperiencesMapper.batchAddExperiences(vo);
		talentEducationMapper.batchAddEducation(vo);
		result.setCode("20000");
		result.setMessage("新建成功");
		return result;
	}
	
	@Override
	@Transactional
	public ResultResponse<?> modify(TalentVo vo) {
		ResultResponse<Integer> result = new ResultResponse<>();
		String nowStr=DateFormatUtil.date2String(new Date(), DateFormatUtil.FORMAT_YYYY_MM_DD_SS_NO_SPACE);
		vo.setUpdateTime(nowStr);
		int a=talentMapper.voModify(vo);
		if(a < 1){
			result.setCode("30401");
			result.setMessage("人才简历修改失败");
			return result;
		}
		talentExperiencesMapper.deleteByTalentId(vo.getId());
		talentEducationMapper.deleteByTalentId(vo.getId());
		talentExperiencesMapper.batchAddExperiences(vo);
		talentEducationMapper.batchAddEducation(vo);
		result.setCode("20000");
		result.setMessage("修改成功");
		return result;
	}
	
	@Override
	public ResultResponse<?> updateStatus(TalentQueryVo vo) {
		ResultResponse<Integer> result = new ResultResponse<>();
		result.setData(talentMapper.updateStatus(vo));
		result.setCode("20000");
		result.setMessage("更新状态成功");
		return result;
	}
	
	@Override
	public ResultResponse<?> updateTags(TalentQueryVo vo) {
		ResultResponse<Integer> result = new ResultResponse<>();
		result.setData(talentMapper.updateTags(vo));
		result.setCode("20000");
		result.setMessage("更新标签成功");
		return result;
	}
	
	@Override
	@Transactional
	public ResultResponse<?> focus(TalentQueryVo queryVo) {
		ResultResponse<Integer> result = new ResultResponse<>();
		Focus focus=new Focus();
		focus.setBusinessId(queryVo.getId());
		focus.setBusinessType("talent");
		focus.setCreaterId(queryVo.getCreaterId());
		int a=focusMapper.checkFocus(focus);
		if(a == 0){
			focus.setCreateTime(DateFormatUtil.date2String(new Date(), DateFormatUtil.FORMAT_YYYY_MM_DD_SS_NO_SPACE));
			focusMapper.insertSelective(focus);
			queryVo.setFocusStr(queryVo.getCreaterId()+",");
			talentMapper.modifyFocusStr(queryVo);
		}
		result.setCode("20000");
		result.setMessage("关注成功");
		return result;
	}
	
	@Override
	@Transactional
	public ResultResponse<?> unFocus(TalentQueryVo queryVo) {
		ResultResponse<Integer> result = new ResultResponse<>();
		Focus focus=new Focus();
		focus.setBusinessId(queryVo.getId());
		focus.setBusinessType("talent");
		focus.setCreaterId(queryVo.getCreaterId());
		focusMapper.removeFocus(focus);
		queryVo.setFocusStr(queryVo.getCreaterId()+",");
		talentMapper.unFocusStr(queryVo);
		result.setCode("20000");
		result.setMessage("取消关注成功");
		return result;
	}
	
	@Override
	@Transactional
	public ResultResponse<?> addRemark(Remark remark) {
		ResultResponse<Integer> result = new ResultResponse<Integer>();
		String nowStr=DateFormatUtil.date2String(new Date(), DateFormatUtil.FORMAT_YYYY_MM_DD_SS_NO_SPACE);
		remark.setCreateTime(nowStr);
		remark.setBusinessType("talent");
		result.setData(remarkMapper.insertSelective(remark));
		ResetBO bo =new ResetBO();
		bo.setBusinessId(remark.getBusinessId());
		bo.setBusinessType("talent");
		bo.setCId(remark.getcId());
		talentMapper.resetRemarkCount(bo);
		result.setCode("20000");
		result.setMessage("新建备注成功");
		return result;
	}
	
	@Override
	public ResultResponse<?> modifyRemark(Remark remark) {
		ResultResponse<Integer> result = new ResultResponse<Integer>();
		remark.setBusinessType("talent");
		result.setData(remarkMapper.modify(remark));
		result.setMessage("修改备注成功");
		return result;
	}
	
	@Override
	@Transactional
	public ResultResponse<?> deleteRemark(RemarkVo vo) {
		ResultResponse<Integer> result = new ResultResponse<Integer>();
		vo.setBusinessType("talent");
		result.setData(remarkMapper.deleteByIds(vo));
		ResetBO bo =new ResetBO();
		bo.setBusinessId(vo.getBusinessId());
		bo.setBusinessType("talent");
		bo.setCId(vo.getCId());
		talentMapper.resetRemarkCount(bo);
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
		vo.setBusinessType("talent");
		List<RemarkDto> remarkDtoList=remarkMapper.getAllRemark(vo);
		List<RemarkBaseDto> rList=new ArrayList<RemarkBaseDto>(7);
		
		boolean indexFlag=CollectionUtils.isNotEmpty(remarkDtoList);
		int baseSize = indexFlag ? 8 : 0;
		RemarkBaseDto allDto=new RemarkBaseDto("all","所有项目",indexFlag ? remarkDtoList.size() : 0 );
		
		rList.add(allDto);
		Map<String, RemarkBaseDto> dtoMap=new HashMap<String, RemarkBaseDto>(TalentRemarkEnum.values().length);
		TalentRemarkEnum.values();
		for(TalentRemarkEnum talentRemarkEnum:TalentRemarkEnum.values()){
			RemarkBaseDto dto=new RemarkBaseDto(talentRemarkEnum.code(),talentRemarkEnum.label(),baseSize);
			dtoMap.put(talentRemarkEnum.code(), dto);
			rList.add(dto);
		}
		
		if(indexFlag){
			for(RemarkDto dto : remarkDtoList){
				allDto.getDetailList().add(dto);
				dtoMap.get(dto.getCategory()).getDetailList().add(dto);
			}
		}
		
		result.setData(rList);
		result.setCode("20000");
		result.setMessage("查询明细成功");
		return result;
	}
	
}
