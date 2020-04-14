package com.lietou.mapper;

import com.lietou.common.BaseMapper;
import com.lietou.model.TalentEducation;
import com.lietou.vo.TalentVo;

public interface TalentEducationMapper extends BaseMapper<TalentEducation>{
    
	int batchAddEducation(TalentVo vo);
	
	int deleteByTalentId(Long talentId);
	
}