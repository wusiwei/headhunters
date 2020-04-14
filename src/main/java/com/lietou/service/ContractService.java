package com.lietou.service;

import com.lietou.model.Contract;
import com.lietou.util.Page;
import com.lietou.util.ResultResponse;
import com.lietou.vo.ContractVo;

public interface ContractService {

	ResultResponse<?> add(Contract contract);

	ResultResponse<?> modify(Contract contract);

	Page getList(ContractVo queryVO);

	ResultResponse<?> getById(ContractVo vo);

	ResultResponse<?> deleteByIds(ContractVo vo);

}
