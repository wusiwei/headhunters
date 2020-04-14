package com.lietou.vo;

import java.util.List;

import com.lietou.model.Talent;
import com.lietou.model.TalentEducation;
import com.lietou.model.TalentExperiences;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class TalentVo extends Talent{
	
	private Long projectId;
	
	private List<TalentEducation> educationList;
	
	private List<TalentExperiences> experiencesList;
}
