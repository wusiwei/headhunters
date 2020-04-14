package com.lietou.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lietou.enumeration.TalentRemarkEnum;
import com.lietou.queryvo.OptionsQueryVo;
import com.lietou.service.SelectOptionsService;
import com.lietou.util.ResultResponse;

@Service
public class SelectOptionsServiceImpl implements SelectOptionsService{
	
	private static final Logger log = LoggerFactory.getLogger(SelectOptionsServiceImpl.class);
	
	@Override
	public ResultResponse<?> getSelectOptions(OptionsQueryVo queryVo){
		ResultResponse<Object> result = new ResultResponse<Object>();
		result.setData(TalentRemarkEnum.values());
		result.setCode("20000");
		result.setMessage("新建成功");
		return result;
	}
}
