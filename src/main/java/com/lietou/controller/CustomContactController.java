package com.lietou.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lietou.dto.UserDto;
import com.lietou.filter.ApplicationHelper;
import com.lietou.model.CustomContact;
import com.lietou.model.CustomContactRecord;
import com.lietou.service.CustomContactService;
import com.lietou.util.Page;
import com.lietou.util.ResultResponse;
import com.lietou.vo.CustomContactVo;

@RestController
@RequestMapping("/customContact")
public class CustomContactController {
	
	@Autowired
	private CustomContactService customContactService;
	
	@ResponseBody
	@RequestMapping(value = "/add")
	public ResultResponse<?> add(@RequestBody CustomContact customContact) {
		UserDto user =ApplicationHelper.getAccount();
		customContact.setcId(user.getcId());
		customContact.setCreaterId(user.getId());
		return customContactService.add(customContact);
	}
	
	@RequestMapping(value = "/getList")
	@ResponseBody
	public ResultResponse<?> getList(@RequestBody CustomContactVo queryVo) {
		ResultResponse<Page> result = new ResultResponse<>();
		UserDto user =ApplicationHelper.getAccount();
		queryVo.setCId(user.getcId());
		result.setData(customContactService.getList(queryVo));
		result.setCode(ResultResponse.CODE_SUCCESS);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/modify")
	public ResultResponse<?> modify(@RequestBody CustomContact customContact) {
		return customContactService.modify(customContact);
	}
	
	@ResponseBody
	@RequestMapping(value = "/getById/{id}")
	public ResultResponse<?> getById(@PathVariable Long id) {
		UserDto user =ApplicationHelper.getAccount();
		CustomContactVo vo=new CustomContactVo();
		vo.setId(id);
		vo.setCId(user.getcId());
		return customContactService.getById(vo);
	}
	
	@RequestMapping(value = "/deleteByIds")
	@ResponseBody
	public ResultResponse<?> deleteByIds(@RequestBody CustomContactVo queryVo) {
		UserDto user =ApplicationHelper.getAccount();
		queryVo.setCId(user.getcId());
		return customContactService.deleteByIds(queryVo);
	}
	
	@ResponseBody
	@RequestMapping(value = "/addRecord")
	public ResultResponse<?> addRecord(@RequestBody CustomContactRecord customContact) {
		UserDto user =ApplicationHelper.getAccount();
		customContact.setCreaterId(user.getId());
		return customContactService.addContactRecord(customContact);
	}
	
	@ResponseBody
	@RequestMapping(value = "/modifyRecord")
	public ResultResponse<?> modifyRecord(@RequestBody CustomContactRecord customContact) {
		UserDto user =ApplicationHelper.getAccount();
		customContact.setCreaterId(user.getId());
		return customContactService.modifyContactRecord(customContact);
	}
	
	@ResponseBody
	@RequestMapping(value = "/getRecordById/{id}")
	public ResultResponse<?> getRecordById(@PathVariable Long id) {
		return customContactService.getRecordById(id);
	}
}
