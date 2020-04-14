package com.lietou.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class RemarkBaseDto {
	private String category;
	
	private String categoryLabel;
	
	private List<RemarkDto> detailList;
	
	public RemarkBaseDto(){
	}
	
	public RemarkBaseDto(String category,String categoryLabel,int listSize){
		this.category=category;
		this.categoryLabel=categoryLabel;
		if(listSize > 0 ){
			this.detailList=new ArrayList<RemarkDto>(listSize);
		}
	}
}
