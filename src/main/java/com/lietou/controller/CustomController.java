package com.lietou.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lietou.dto.UserDto;
import com.lietou.filter.ApplicationHelper;
import com.lietou.model.Remark;
import com.lietou.service.CustomService;
import com.lietou.util.Page;
import com.lietou.util.ResultResponse;
import com.lietou.vo.CustomVo;
import com.lietou.vo.RemarkVo;

@RestController
@RequestMapping("/custom")
public class CustomController {
	
	@Autowired
	private CustomService customService;
	
	@ResponseBody
	@RequestMapping(value = "/add")
	public ResultResponse<?> add(@RequestBody CustomVo customVo) {
		UserDto user =ApplicationHelper.getAccount();
		customVo.setCId(user.getcId());
		customVo.setCreaterId(user.getId());
		return customService.add(customVo);
	}
	
	@ResponseBody
	@RequestMapping(value = "/modify")
	public ResultResponse<?> modify(@RequestBody CustomVo customVo) {
		UserDto user =ApplicationHelper.getAccount();
		customVo.setCId(user.getcId());
		customVo.setCreaterId(user.getId());
		return customService.modify(customVo);
	}
	
	@RequestMapping(value = "/getCustomList")
	@ResponseBody
	public ResultResponse<?> getCustomList(@RequestBody CustomVo queryVo) {
		ResultResponse<Page> result = new ResultResponse<>();
		UserDto user =ApplicationHelper.getAccount();
		queryVo.setCId(user.getcId());
		queryVo.setCreaterId(user.getId());
		result.setData(customService.getCustomList(queryVo));
		result.setCode(ResultResponse.CODE_SUCCESS);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/modifyShortName")
	public ResultResponse<?> modifyShortName(@RequestBody CustomVo customVo) {
		UserDto user =ApplicationHelper.getAccount();
		customVo.setCId(user.getcId());
		return customService.modifyShortName(customVo);
	}
	
	@ResponseBody
	@RequestMapping(value = "/focus")
	public ResultResponse<?> focus(@RequestBody CustomVo customVo) {
		UserDto user =ApplicationHelper.getAccount();
		customVo.setCId(user.getcId());
		customVo.setCreaterId(user.getId());
		return customService.focus(customVo);
	}
	
	@ResponseBody
	@RequestMapping(value = "/unFocus")
	public ResultResponse<?> unFocus(@RequestBody CustomVo customVo) {
		UserDto user =ApplicationHelper.getAccount();
		customVo.setCId(user.getcId());
		customVo.setCreaterId(user.getId());
		return customService.unFocus(customVo);
	}
	
	@ResponseBody
	@RequestMapping(value = "/getById/{id}")
	public ResultResponse<?> getById(@PathVariable Long id) {
		UserDto user =ApplicationHelper.getAccount();
		CustomVo customVo=new CustomVo();
		customVo.setId(id);
		customVo.setCId(user.getcId());
		customVo.setCreaterId(user.getId());
		return customService.getById(customVo);
	}
	
	@ResponseBody
	@RequestMapping(value = "/addRemark")
	public ResultResponse<?> addRemark(@RequestBody Remark remark) {
		UserDto user =ApplicationHelper.getAccount();
		remark.setcId(user.getcId());
		remark.setCreaterId(user.getId());
		return customService.addRemark(remark);
	}
	
	@ResponseBody
	@RequestMapping(value = "/getRemarkById/{id}")
	public ResultResponse<?> getRemarkById(@PathVariable Long id) {
		UserDto user =ApplicationHelper.getAccount();
		RemarkVo  vo=new RemarkVo();
		vo.setId(id);
		vo.setCId(user.getcId());
		return customService.getRemarkById(vo);
	}
	
	@ResponseBody
	@RequestMapping(value = "/modifyRemark")
	public ResultResponse<?> modifyRemark(@RequestBody Remark remark) {
		UserDto user =ApplicationHelper.getAccount();
		remark.setcId(user.getcId());
		remark.setCreaterId(user.getId());
		return customService.modifyRemark(remark);
	}
	
	@ResponseBody
	@RequestMapping(value = "/deleteRemark")
	public ResultResponse<?> deleteRemark(@RequestBody RemarkVo vo) {
		UserDto user =ApplicationHelper.getAccount();
		vo.setCId(user.getcId());
		return customService.deleteRemark(vo);
	}
	
	@ResponseBody
	@RequestMapping(value = "/getAllRemark")
	public ResultResponse<?> getAllRemark(@RequestBody RemarkVo vo) {
		UserDto user =ApplicationHelper.getAccount();
		vo.setCId(user.getcId());
		return customService.getAllRemark(vo);
	}
}
