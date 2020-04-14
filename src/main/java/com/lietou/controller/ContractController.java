package com.lietou.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lietou.dto.UserDto;
import com.lietou.filter.ApplicationHelper;
import com.lietou.model.Contract;
import com.lietou.service.ContractService;
import com.lietou.util.Page;
import com.lietou.util.ResultResponse;
import com.lietou.vo.ContractVo;

@RestController
@RequestMapping("/contract")
public class ContractController {
	@Autowired
	private ContractService contractService;
	
	@ResponseBody
	@RequestMapping(value = "/add")
	public ResultResponse<?> add(@RequestBody Contract contract) {
		UserDto user =ApplicationHelper.getAccount();
		contract.setcId(user.getcId());
		contract.setCreaterId(user.getId());
		return contractService.add(contract);
	}
	
	@RequestMapping(value = "/getList")
	@ResponseBody
	public ResultResponse<?> getList(@RequestBody ContractVo queryVo) {
		ResultResponse<Page> result = new ResultResponse<>();
		UserDto user =ApplicationHelper.getAccount();
		queryVo.setCId(user.getcId());
		result.setData(contractService.getList(queryVo));
		result.setCode(ResultResponse.CODE_SUCCESS);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/modify")
	public ResultResponse<?> modify(@RequestBody Contract contract) {
		return contractService.modify(contract);
	}
	
	@ResponseBody
	@RequestMapping(value = "/getById/{id}")
	public ResultResponse<?> getById(@PathVariable Long id) {
		UserDto user =ApplicationHelper.getAccount();
		ContractVo vo=new ContractVo();
		vo.setId(id);
		vo.setCId(user.getcId());
		return contractService.getById(vo);
	}
	
	@RequestMapping(value = "/deleteByIds")
	@ResponseBody
	public ResultResponse<?> deleteByIds(@RequestBody ContractVo queryVo) {
		UserDto user =ApplicationHelper.getAccount();
		queryVo.setCId(user.getcId());
		return contractService.deleteByIds(queryVo);
	}
}
