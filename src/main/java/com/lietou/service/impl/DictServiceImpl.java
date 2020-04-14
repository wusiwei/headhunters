package com.lietou.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.lietou.dto.DictAreaDto;
import com.lietou.dto.DictDto;
import com.lietou.mapper.DictAreaMapper;
import com.lietou.mapper.DictMapper;
import com.lietou.model.Dict;
import com.lietou.service.DictService;
import com.lietou.util.CacheKeyConstant;
import com.lietou.util.RedisUtil;
import com.lietou.util.ResultResponse;
import com.lietou.vo.DictVO;

@Service
public class DictServiceImpl implements DictService{
	
	@Autowired
	private DictMapper dictMapper;
	
	@Autowired
	private RedisUtil redisUtil;
	
	@Autowired
	private DictAreaMapper dictAreaMapper;
	
	@Override
	public ResultResponse<?> getBaseTreeByClassify(DictVO queryVO){
		ResultResponse<List<DictDto>> r=new ResultResponse<List<DictDto>>();
		List<DictDto> rList;
		String keyString = redisUtil.generateKey(CacheKeyConstant.DICT_CLASSIFY_TREE, queryVO.getClassify());
		String keyDtoString = redisUtil.getString(keyString);
		if(StringUtils.isBlank(keyDtoString)){
			rList=dictMapper.getBaseTreeByClassify(queryVO.getClassify());
			redisUtil.set(keyString, JSONObject.toJSONString(rList));
		}else{
			rList=JSONObject.parseArray(keyDtoString, DictDto.class);
		}
		r.setCode(ResultResponse.CODE_SUCCESS);
		r.setData(rList);
		return r;
	}
	
	@Override
	public ResultResponse<?> addBaseDict(DictVO queryVO){
		ResultResponse<Boolean> r=new ResultResponse<Boolean>();
		Dict record=new Dict();
		record.setCode(queryVO.getCode());
		record.setClassify(queryVO.getClassify());
		record.setdIndex(queryVO.getdIndex());
		record.setLabel(queryVO.getLabel());
		record.setRemark(queryVO.getRemark());
		record.setParentId(queryVO.getParentId());
		dictMapper.insertSelective(record);
		r.setCode(ResultResponse.CODE_SUCCESS);
		r.setData(true);
		return r;
	}
	
	@Override
	public ResultResponse<?> batchAddChildrenDict(DictVO queryVO){
		ResultResponse<Boolean> r=new ResultResponse<Boolean>();
		dictMapper.batchAddChildrenDict(queryVO);
		r.setCode(ResultResponse.CODE_SUCCESS);
		r.setData(true);
		return r;
	}
	
	@Override
	public ResultResponse<?> batchDeleteDict(DictVO queryVO){
		ResultResponse<Boolean> r=new ResultResponse<Boolean>();
		int a=dictMapper.countChildrenDictByIds(queryVO);
		if(a > 0){
			r.setCode("-1001");
			r.setData(false);
			r.setMessage("存在下级标签，请先删除下级标签");
			return r;
		}
		dictMapper.deleteByIds(queryVO);
		r.setCode(ResultResponse.CODE_SUCCESS);
		r.setData(true);
		return r;
	}
	
	@Override
	@Transactional
	public ResultResponse<?> adjustDIndex(DictVO queryVO){
		ResultResponse<Boolean> r=new ResultResponse<Boolean>();
		List<Dict> dictList=queryVO.getChildrenDictList();
		for(Dict dict : dictList){
			dictMapper.updateByPrimaryKeySelective(dict);
		}
		r.setCode(ResultResponse.CODE_SUCCESS);
		r.setData(true);
		return r;
	}
	
	@Override
	public ResultResponse<?> getProvincesAndCities(){
		ResultResponse<List<DictAreaDto>> r=new ResultResponse<List<DictAreaDto>>();
		List<DictAreaDto> rList;
		String keyDtoString = redisUtil.getString(CacheKeyConstant.MANAGE_PROVINCES_CITIES);
		if(StringUtils.isBlank(keyDtoString)){
			rList=dictAreaMapper.getProvincesAndCities();
			redisUtil.set(CacheKeyConstant.MANAGE_PROVINCES_CITIES, JSONObject.toJSONString(rList));
		}else{
			rList=JSONObject.parseArray(keyDtoString, DictAreaDto.class);
		}
		r.setCode(ResultResponse.CODE_SUCCESS);
		r.setData(rList);
		return r;
	}
	
	@Override
	public ResultResponse<?> getProvincesAndCitiesArea(){
		ResultResponse<List<DictAreaDto>> r=new ResultResponse<List<DictAreaDto>>();
		List<DictAreaDto> rList;
		String keyDtoString = redisUtil.getString(CacheKeyConstant.MANAGE_PROVINCES_CITIES_AREA);
		if(StringUtils.isBlank(keyDtoString)){
			rList=dictAreaMapper.getProvincesAndCitiesArea();
			redisUtil.set(CacheKeyConstant.MANAGE_PROVINCES_CITIES_AREA, JSONObject.toJSONString(rList));
		}else{
			rList=JSONObject.parseArray(keyDtoString, DictAreaDto.class);
		}
		r.setCode(ResultResponse.CODE_SUCCESS);
		r.setData(rList);
		return r;
	}
	
}
