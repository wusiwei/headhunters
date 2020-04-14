package com.lietou.mapper;

import java.util.List;

import com.lietou.common.BaseMapper;
import com.lietou.dto.CustomContactDto;
import com.lietou.model.CustomContact;
import com.lietou.model.CustomContactRecord;
import com.lietou.model.ResetBO;
import com.lietou.vo.CustomContactVo;

public interface CustomContactMapper extends BaseMapper<CustomContact>{
	
	CustomContactDto getById(CustomContactVo vo);
	
	List<CustomContactDto> getList(CustomContactVo vo);
	
	int countList(CustomContactVo vo);
	
	int deleteByIds(CustomContactVo vo);
	
	int resetContactCount(ResetBO vo);
}