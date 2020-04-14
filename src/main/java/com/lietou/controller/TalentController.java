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
import com.lietou.queryvo.TalentQueryVo;
import com.lietou.service.TalentService;
import com.lietou.util.Page;
import com.lietou.util.ResultResponse;
import com.lietou.vo.RemarkVo;
import com.lietou.vo.TalentVo;

@RestController
@RequestMapping("/talent")
public class TalentController {
	
	@Autowired
	private TalentService talentService;
	
	@ResponseBody
	@RequestMapping(value = "/add")
	public ResultResponse<?> add(@RequestBody TalentVo vo) {
		UserDto user =ApplicationHelper.getAccount();
		vo.setcId(user.getcId());
		vo.setCreaterId(user.getId());
		return talentService.add(vo);
	}
	
	@ResponseBody
	@RequestMapping(value = "/modify")
	public ResultResponse<?> modify(@RequestBody TalentVo vo) {
		UserDto user =ApplicationHelper.getAccount();
		vo.setcId(user.getcId());
		vo.setCreaterId(user.getId());
		return talentService.modify(vo);
	}
	
	@RequestMapping(value = "/getList")
	@ResponseBody
	public ResultResponse<?> getList(@RequestBody TalentQueryVo queryVO) {
		ResultResponse<Page> result = new ResultResponse<>();
		UserDto user =ApplicationHelper.getAccount();
		queryVO.setCId(user.getcId());
		queryVO.setCreaterId(user.getId());
		result.setData(talentService.getList(queryVO));
		result.setCode(ResultResponse.CODE_SUCCESS);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/updateStatus")
	public ResultResponse<?> updateStatus(@RequestBody TalentQueryVo vo) {
		UserDto user =ApplicationHelper.getAccount();
		vo.setCId(user.getcId());
		return talentService.updateStatus(vo);
	}
	
	@ResponseBody
	@RequestMapping(value = "/updateTags")
	public ResultResponse<?> updateTags(@RequestBody TalentQueryVo vo) {
		UserDto user =ApplicationHelper.getAccount();
		vo.setCId(user.getcId());
		return talentService.updateTags(vo);
	}
	
	@ResponseBody
	@RequestMapping(value = "/focus")
	public ResultResponse<?> focus(@RequestBody TalentQueryVo queryVo) {
		UserDto user =ApplicationHelper.getAccount();
		queryVo.setCId(user.getcId());
		queryVo.setCreaterId(user.getId());
		return talentService.focus(queryVo);
	}
	
	@ResponseBody
	@RequestMapping(value = "/unFocus")
	public ResultResponse<?> unFocus(@RequestBody TalentQueryVo queryVo) {
		UserDto user =ApplicationHelper.getAccount();
		queryVo.setCId(user.getcId());
		queryVo.setCreaterId(user.getId());
		return talentService.unFocus(queryVo);
	}
	
	@ResponseBody
	@RequestMapping(value = "/getById/{id}")
	public ResultResponse<?> getById(@PathVariable Long id) {
		UserDto user =ApplicationHelper.getAccount();
		TalentQueryVo queryVo=new TalentQueryVo();
		queryVo.setId(id);
		queryVo.setCId(user.getcId());
		queryVo.setCreaterId(user.getId());
		return talentService.getById(queryVo);
	}
	
	@ResponseBody
	@RequestMapping(value = "/addRemark")
	public ResultResponse<?> addRemark(@RequestBody Remark remark) {
		UserDto user =ApplicationHelper.getAccount();
		remark.setcId(user.getcId());
		remark.setCreaterId(user.getId());
		return talentService.addRemark(remark);
	}
	
	@ResponseBody
	@RequestMapping(value = "/getRemarkById/{id}")
	public ResultResponse<?> getRemarkById(@PathVariable Long id) {
		UserDto user =ApplicationHelper.getAccount();
		RemarkVo  vo=new RemarkVo();
		vo.setId(id);
		vo.setCId(user.getcId());
		return talentService.getRemarkById(vo);
	}
	
	@ResponseBody
	@RequestMapping(value = "/modifyRemark")
	public ResultResponse<?> modifyRemark(@RequestBody Remark remark) {
		UserDto user =ApplicationHelper.getAccount();
		remark.setcId(user.getcId());
		remark.setCreaterId(user.getId());
		return talentService.modifyRemark(remark);
	}
	
	@ResponseBody
	@RequestMapping(value = "/deleteRemark")
	public ResultResponse<?> deleteRemark(@RequestBody RemarkVo vo) {
		UserDto user =ApplicationHelper.getAccount();
		vo.setCId(user.getcId());
		return talentService.deleteRemark(vo);
	}
	
	@ResponseBody
	@RequestMapping(value = "/getAllRemark")
	public ResultResponse<?> getAllRemark(@RequestBody RemarkVo vo) {
		UserDto user =ApplicationHelper.getAccount();
		vo.setCId(user.getcId());
		return talentService.getAllRemark(vo);
	}
}
