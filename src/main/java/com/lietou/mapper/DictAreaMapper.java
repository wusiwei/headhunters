package com.lietou.mapper;

import java.util.List;

import com.lietou.common.BaseMapper;
import com.lietou.dto.DictAreaDto;
import com.lietou.model.DictArea;

public interface DictAreaMapper extends BaseMapper<DictArea>{
	
	List<DictAreaDto> getProvincesAndCities();
    
    List<DictAreaDto> getProvincesAndCitiesArea();
}
