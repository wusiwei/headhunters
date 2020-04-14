package com.lietou.dto;

import java.util.List;

import com.lietou.model.DictArea;

public class DictAreaDto extends DictArea{
    
    private List<DictAreaDto> children;

	public List<DictAreaDto> getChildren() {
		return children;
	}

	public void setChildren(List<DictAreaDto> children) {
		this.children = children;
	}
    
}
