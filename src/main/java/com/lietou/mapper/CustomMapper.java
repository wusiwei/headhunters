package com.lietou.mapper;

import java.util.List;

import com.lietou.common.BaseMapper;
import com.lietou.dto.CustomDto;
import com.lietou.model.Custom;
import com.lietou.model.ResetBO;
import com.lietou.vo.CustomVo;

public interface CustomMapper extends BaseMapper<Custom>{

    int voInsertSelective(CustomVo record);
    
    int voUpdateByPrimaryKeySelective(CustomVo record);

    int voUpdateByPrimaryKey(CustomVo record);
    
    List<CustomDto> getCustomList(CustomVo record);
    
    int countCustomList(CustomVo record);
    
    int modifyShortName(CustomVo record);
    
    int modifyFocusStr(CustomVo record);
    
    int unFocusStr(CustomVo record);
    
    CustomDto getById(CustomVo record);
    
    int resetRemarkCount(ResetBO bo);
}