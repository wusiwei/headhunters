package com.lietou.mapper;

import java.util.List;

import com.lietou.common.BaseMapper;
import com.lietou.dto.TalentDto;
import com.lietou.model.ResetBO;
import com.lietou.model.Talent;
import com.lietou.queryvo.TalentQueryVo;
import com.lietou.vo.TalentVo;

public interface TalentMapper extends BaseMapper<Talent>{
	
    int voInsert(TalentVo vo);
    
    int voModify(TalentVo vo);
    
    TalentDto getDetailById(TalentQueryVo queryVo);
    
    List<TalentDto> getList(TalentQueryVo queryVo);
    
    int countList(TalentQueryVo queryVo);
    
    int updateStatus(TalentQueryVo queryVo);
    
    int modifyFocusStr(TalentQueryVo queryVo);
    
    int unFocusStr(TalentQueryVo queryVo);
    
    int resetRemarkCount(ResetBO bo);
    
    int updateTags(TalentQueryVo queryVo);
    
}