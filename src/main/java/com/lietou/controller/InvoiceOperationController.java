package com.lietou.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lietou.dto.UserDto;
import com.lietou.exception.BusinessException;
import com.lietou.filter.ApplicationHelper;
import com.lietou.model.Contract;
import com.lietou.model.Invoice;
import com.lietou.service.InvoiceOperationService;
import com.lietou.service.InvoiceService;
import com.lietou.util.Page;
import com.lietou.util.ResultResponse;
import com.lietou.vo.AssignVo;
import com.lietou.vo.ContractVo;
import com.lietou.vo.InvoiceOperationVo;
import com.lietou.vo.InvoiceVo;

@RestController
@RequestMapping("/invoice")
public class InvoiceOperationController {
	
	@Autowired
	private InvoiceOperationService invoiceOperationService;
	
	@ResponseBody
	@RequestMapping(value = "/agree")
	public ResultResponse<?> agree(@RequestBody InvoiceOperationVo vo) {
		UserDto user =ApplicationHelper.getAccount();
		vo.setCId(user.getcId());
		vo.setCreaterId(user.getId());
		try {
			return invoiceOperationService.agree(vo);
		} catch (BusinessException e) {
			ResultResponse<?> r=new ResultResponse<Boolean>();
			r.setCode(e.getCode());
			r.setMessage(e.getErrorMsg());
			return r;
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/disAgree")
	public ResultResponse<?> disAgree(@RequestBody InvoiceOperationVo vo) {
		UserDto user =ApplicationHelper.getAccount();
		vo.setCId(user.getcId());
		vo.setCreaterId(user.getId());
		try {
			return invoiceOperationService.disAgree(vo);
		} catch (BusinessException e) {
			ResultResponse<?> r=new ResultResponse<Boolean>();
			r.setCode(e.getCode());
			r.setMessage(e.getErrorMsg());
			return r;
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/make")
	public ResultResponse<?> make(@RequestBody InvoiceOperationVo vo) {
		UserDto user =ApplicationHelper.getAccount();
		vo.setCId(user.getcId());
		vo.setCreaterId(user.getId());
		try {
			return invoiceOperationService.make(vo);
		} catch (BusinessException e) {
			ResultResponse<?> r=new ResultResponse<Boolean>();
			r.setCode(e.getCode());
			r.setMessage(e.getErrorMsg());
			return r;
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/charge")
	public ResultResponse<?> charge(@RequestBody InvoiceOperationVo vo) {
		UserDto user =ApplicationHelper.getAccount();
		vo.setCId(user.getcId());
		vo.setCreaterId(user.getId());
		try {
			return invoiceOperationService.charge(vo);
		} catch (BusinessException e) {
			ResultResponse<?> r=new ResultResponse<Boolean>();
			r.setCode(e.getCode());
			r.setMessage(e.getErrorMsg());
			return r;
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/refundinvoice")
	public ResultResponse<?> refundinvoice(@RequestBody InvoiceOperationVo vo) {
		UserDto user =ApplicationHelper.getAccount();
		vo.setCId(user.getcId());
		vo.setCreaterId(user.getId());
		try {
			return invoiceOperationService.refundinvoice(vo);
		} catch (BusinessException e) {
			ResultResponse<?> r=new ResultResponse<Boolean>();
			r.setCode(e.getCode());
			r.setMessage(e.getErrorMsg());
			return r;
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/refundmoney")
	public ResultResponse<?> refundmoney(@RequestBody InvoiceOperationVo vo) {
		UserDto user =ApplicationHelper.getAccount();
		vo.setCId(user.getcId());
		vo.setCreaterId(user.getId());
		try {
			return invoiceOperationService.refundmoney(vo);
		} catch (BusinessException e) {
			ResultResponse<?> r=new ResultResponse<Boolean>();
			r.setCode(e.getCode());
			r.setMessage(e.getErrorMsg());
			return r;
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/assign")
	public ResultResponse<?> assign(@RequestBody InvoiceOperationVo vo) {
		UserDto user =ApplicationHelper.getAccount();
		vo.setCId(user.getcId());
		vo.setCreaterId(user.getId());
		try {
			return invoiceOperationService.assign(vo);
		} catch (BusinessException e) {
			ResultResponse<?> r=new ResultResponse<Boolean>();
			r.setCode(e.getCode());
			r.setMessage(e.getErrorMsg());
			return r;
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/grant")
	public ResultResponse<?> grant(@RequestBody InvoiceOperationVo vo) {
		UserDto user =ApplicationHelper.getAccount();
		vo.setCId(user.getcId());
		vo.setCreaterId(user.getId());
		try {
			return invoiceOperationService.grant(vo);
		} catch (BusinessException e) {
			ResultResponse<?> r=new ResultResponse<Boolean>();
			r.setCode(e.getCode());
			r.setMessage(e.getErrorMsg());
			return r;
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/back")
	public ResultResponse<?> back(@RequestBody InvoiceOperationVo vo) {
		UserDto user =ApplicationHelper.getAccount();
		vo.setCId(user.getcId());
		vo.setCreaterId(user.getId());
		try {
			return invoiceOperationService.back(vo);
		} catch (BusinessException e) {
			ResultResponse<?> r=new ResultResponse<Boolean>();
			r.setCode(e.getCode());
			r.setMessage(e.getErrorMsg());
			return r;
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/getAssignById/{assignId}")
	public ResultResponse<?> getById(@PathVariable Long assignId) {
		UserDto user =ApplicationHelper.getAccount();
		AssignVo vo=new AssignVo();
		vo.setId(assignId);
		vo.setCId(user.getcId());
		return invoiceOperationService.getAssignById(vo);
	}
	
	@ResponseBody
	@RequestMapping(value = "/addPerformance")
	public ResultResponse<?> addPerformance(@RequestBody InvoiceOperationVo vo) {
		UserDto user =ApplicationHelper.getAccount();
		vo.setCId(user.getcId());
		vo.setCreaterId(user.getId());
		try {
			return  invoiceOperationService.addPerformance(vo);
		} catch (BusinessException e) {
			ResultResponse<?> r=new ResultResponse<Boolean>();
			r.setCode(e.getCode());
			r.setMessage(e.getErrorMsg());
			return r;
		}
	}
}
