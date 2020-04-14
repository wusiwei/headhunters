package com.lietou.mapper;

import java.util.List;

import com.lietou.common.BaseMapper;
import com.lietou.model.Contract;
import com.lietou.model.ResetBO;
import com.lietou.vo.ContractVo;

public interface ContractMapper extends BaseMapper<Contract>{
	
	List<Contract> getList(ContractVo vo);
	
	int countList(ContractVo vo);
	
	Contract getById(ContractVo vo);
	
	int deleteByIds(ContractVo vo);
	
	int resetContractCount(ResetBO vo);
}