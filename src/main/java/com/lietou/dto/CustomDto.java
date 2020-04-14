package com.lietou.dto;

import com.lietou.model.Custom;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class CustomDto extends Custom{
	private String industryLabel;

    private Long industry1Label;

    private Long industry2Label;

    private Long cityLabel;
    
    private Boolean focusFlag;
}
