package com.lietou.dto;

import java.util.List;

import com.lietou.model.Menu;

public class MenuDto extends Menu{
	
	private String label;
	
    private List<MenuDto> children;

	public List<MenuDto> getChildren() {
		return children;
	}

	public void setChildren(List<MenuDto> children) {
		this.children = children;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
    
}
