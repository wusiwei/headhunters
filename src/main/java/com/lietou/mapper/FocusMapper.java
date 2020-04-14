package com.lietou.mapper;

import com.lietou.common.BaseMapper;
import com.lietou.model.Focus;

public interface FocusMapper extends BaseMapper<Focus>{
	int checkFocus(Focus focus);
	
	int removeFocus(Focus focus);
}