package com.lietou.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lietou.dto.UserDto;
import com.lietou.filter.ApplicationHelper;
import com.lietou.queryvo.OptionsQueryVo;
import com.lietou.service.SelectOptionsService;
import com.lietou.util.ResultResponse;

@RestController
@RequestMapping("/options")
public class SelectOptionsController {
	
	@Autowired
	private SelectOptionsService selectOptionsService;
	
	@RequestMapping(value="/getBase/{optionsType}")
	@ResponseBody
	public ResultResponse<?> getBaseTreeByClassify(@PathVariable String optionsType){
		OptionsQueryVo queryVo=new OptionsQueryVo();
		UserDto user =ApplicationHelper.getAccount();
		queryVo.setCId(user.getcId());
		queryVo.setOptionsType(optionsType);
		return selectOptionsService.getSelectOptions(queryVo);
	}
}
