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
import com.lietou.model.Invoice;
import com.lietou.service.InvoiceService;
import com.lietou.util.Page;
import com.lietou.util.ResultResponse;
import com.lietou.vo.ContractVo;
import com.lietou.vo.InvoiceVo;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {
	
	@Autowired
	private InvoiceService invoiceService;
	
	@ResponseBody
	@RequestMapping(value = "/add")
	public ResultResponse<?> add(@RequestBody Invoice record) {
		UserDto user =ApplicationHelper.getAccount();
		record.setcId(user.getcId());
		record.setCreaterId(user.getId());
		return invoiceService.add(record);
	}
	
	@RequestMapping(value = "/getList")
	@ResponseBody
	public ResultResponse<?> getList(@RequestBody InvoiceVo queryVo) {
		ResultResponse<Page> result = new ResultResponse<>();
		UserDto user =ApplicationHelper.getAccount();
		queryVo.setCId(user.getcId());
		result.setData(invoiceService.getList(queryVo));
		result.setCode(ResultResponse.CODE_SUCCESS);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/modify")
	public ResultResponse<?> modify(@RequestBody Invoice record) {
		UserDto user =ApplicationHelper.getAccount();
		record.setcId(user.getcId());
		return invoiceService.modify(record);
	}
	
	@ResponseBody
	@RequestMapping(value = "/getById/{id}")
	public ResultResponse<?> getById(@PathVariable Long id) {
		UserDto user =ApplicationHelper.getAccount();
		InvoiceVo vo=new InvoiceVo();
		vo.setId(id);
		vo.setCId(user.getcId());
		return invoiceService.getById(vo);
	}
}
