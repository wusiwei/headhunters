package com.lietou.dto;

import java.util.List;

import com.lietou.model.Talent;
import com.lietou.model.TalentEducation;
import com.lietou.model.TalentExperiences;

import lombok.Data;

@Data
public class TalentDto extends Talent{
	private Boolean focusFlag;
	
	private List<TalentEducation> educationList;
	
	private List<TalentExperiences> experiencesList;
}
