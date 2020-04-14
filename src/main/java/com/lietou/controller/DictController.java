package com.lietou.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lietou.service.DictService;
import com.lietou.util.ResultResponse;
import com.lietou.vo.DictVO;

@RestController
@RequestMapping("/dict")
public class DictController {
	
	@Autowired
	private DictService dictService;
	
	@RequestMapping(value="/getBaseTreeByClassify",method={RequestMethod.POST})
	@ResponseBody
	public ResultResponse<?> getBaseTreeByClassify(@RequestBody DictVO queryVO){
		return dictService.getBaseTreeByClassify(queryVO);
	}
	
	@RequestMapping(value="/addBaseDict",method={RequestMethod.POST})
	@ResponseBody
	public ResultResponse<?> addBaseDict(@RequestBody DictVO queryVO){
		return dictService.addBaseDict(queryVO);
	}
	
	@RequestMapping(value="/batchAddChildrenDict",method={RequestMethod.POST})
	@ResponseBody
	public ResultResponse<?> batchAddChildrenDict(@RequestBody DictVO queryVO){
		return dictService.batchAddChildrenDict(queryVO);
	}
	
	@RequestMapping(value="/batchDeleteDict",method={RequestMethod.POST})
	@ResponseBody
	public ResultResponse<?> batchDeleteDict(@RequestBody DictVO queryVO){
		return dictService.batchDeleteDict(queryVO);
	}
	
	@RequestMapping(value="/adjustDIndex",method={RequestMethod.POST})
	@ResponseBody
	public ResultResponse<?> adjustDIndex(@RequestBody DictVO queryVO){
		return dictService.adjustDIndex(queryVO);
	}
	
	@RequestMapping(value="/getProvincesAndCities")
	@ResponseBody
	public ResultResponse<?> getProvincesAndCities(){
		return dictService.getProvincesAndCities();
	}
	
	@RequestMapping(value="/getProvincesAndCitiesArea")
	@ResponseBody
	public ResultResponse<?> getProvincesAndCitiesArea(){
		return dictService.getProvincesAndCitiesArea();
	}
}
