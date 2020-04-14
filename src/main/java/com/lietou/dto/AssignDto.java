package com.lietou.dto;

import java.util.List;

import com.lietou.model.Assign;
import com.lietou.model.AssignDetail;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class AssignDto extends Assign{
	
	private List<AssignDetail> assignDetailList;
	
}
