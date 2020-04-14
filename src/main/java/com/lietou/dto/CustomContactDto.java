package com.lietou.dto;

import java.util.List;

import com.lietou.model.CustomContact;

import lombok.Data;

@Data
public class CustomContactDto extends CustomContact{
	private List<CustomContactRecordDto> contactRecordList;
}
