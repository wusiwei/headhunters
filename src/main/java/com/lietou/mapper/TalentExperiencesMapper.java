package com.lietou.mapper;

import com.lietou.common.BaseMapper;
import com.lietou.model.TalentExperiences;
import com.lietou.vo.TalentVo;

public interface TalentExperiencesMapper extends BaseMapper<TalentExperiences>{
	
	int batchAddExperiences(TalentVo vo);
	
	int deleteByTalentId(Long talentId);
}