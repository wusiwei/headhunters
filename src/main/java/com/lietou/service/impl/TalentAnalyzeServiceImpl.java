package com.lietou.service.impl;

import com.lietou.queryvo.TalentQueryVo;
import com.lietou.service.TalentAnalyzeService;
import com.lietou.util.ResultResponse;
import com.lietou.vo.TalentVo;

public class TalentAnalyzeServiceImpl implements TalentAnalyzeService{
	
	
	@Override
	public ResultResponse<?> resumeDocAnalyze(TalentQueryVo queryVo) {
		ResultResponse<TalentVo> result = new ResultResponse<>();
		TalentVo vo =new TalentVo();
		result.setData(vo);
		result.setCode("20000");
		result.setMessage("解析成功");
		return result;
	}
	
	@Override
	public ResultResponse<?> resumeHtmAnalyze(TalentQueryVo queryVo) {
		ResultResponse<TalentVo> result = new ResultResponse<>();
		TalentVo vo =new TalentVo();
		result.setData(vo);
		result.setCode("20000");
		result.setMessage("解析成功");
		return result;
	}
}
