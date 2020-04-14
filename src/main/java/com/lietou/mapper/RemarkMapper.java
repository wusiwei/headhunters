package com.lietou.mapper;

import java.util.List;

import com.lietou.common.BaseMapper;
import com.lietou.dto.RemarkDto;
import com.lietou.model.Remark;
import com.lietou.vo.RemarkVo;

public interface RemarkMapper extends BaseMapper<Remark>{
	
	List<RemarkDto> getAllRemark(RemarkVo vo);
	
	RemarkDto getById(RemarkVo vo);
	
	int deleteByIds(RemarkVo vo);
	
	int modify(Remark r);
	
}