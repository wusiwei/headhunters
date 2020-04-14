package com.lietou.mapper;

import com.lietou.common.BaseMapper;
import com.lietou.dto.AssignDto;
import com.lietou.model.Assign;
import com.lietou.vo.AssignVo;

public interface AssignMapper extends BaseMapper<Assign>{
	
	int updateSendFlag(AssignVo vo);
	
	AssignDto getAssignById(AssignVo vo);
}