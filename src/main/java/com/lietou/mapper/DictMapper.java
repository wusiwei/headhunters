package com.lietou.mapper;

import java.util.List;

import com.lietou.common.BaseMapper;
import com.lietou.dto.DictDto;
import com.lietou.model.Dict;
import com.lietou.vo.DictVO;

public interface DictMapper extends BaseMapper<Dict>{
	
	List<Dict> selectAllForIndustry(String classify);
    
    List<DictDto> getBaseTreeByClassify(String classify);
    
    int batchAddChildrenDict(DictVO vo);
    
    int countChildrenDictByIds(DictVO vo);
    
    int deleteByIds(DictVO vo);
}
