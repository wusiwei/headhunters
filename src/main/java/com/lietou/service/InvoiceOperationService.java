package com.lietou.service;

import com.lietou.exception.BusinessException;
import com.lietou.util.ResultResponse;
import com.lietou.vo.AssignVo;
import com.lietou.vo.InvoiceOperationVo;

/**
 * 发票操作
 * @author wusiwei
 *
 */
public interface InvoiceOperationService {

	/**
	 * 审批同意
	 * @param vo
	 * @return
	 */
	ResultResponse<?> agree(InvoiceOperationVo vo) throws BusinessException;

	/**
	 * 审批不同意
	 * @param vo
	 * @return
	 */
	ResultResponse<?> disAgree(InvoiceOperationVo vo) throws BusinessException;

	/**
	 * 开票
	 * @param vo
	 * @return
	 */
	ResultResponse<?> make(InvoiceOperationVo vo) throws BusinessException;

	/**
	 * 收款
	 * @param vo
	 * @return
	 */
	ResultResponse<?> charge(InvoiceOperationVo vo) throws BusinessException;

	/**
	 * 退票
	 * @param vo
	 * @return
	 */
	ResultResponse<?> refundinvoice(InvoiceOperationVo vo) throws BusinessException;

	/**
	 * 退款
	 * @param vo
	 * @return
	 */
	ResultResponse<?> refundmoney(InvoiceOperationVo vo) throws BusinessException;

	/**
	 * 分配
	 * @param vo
	 * @return
	 */
	ResultResponse<?> assign(InvoiceOperationVo vo) throws BusinessException;

	/**
	 * 发放
	 * @param vo
	 * @return
	 */
	ResultResponse<?> grant(InvoiceOperationVo vo) throws BusinessException;

	/**
	 * 回退
	 * @param vo
	 * @return
	 */
	ResultResponse<?> back(InvoiceOperationVo vo) throws BusinessException;

	/**
	 * 获取业绩分配明细
	 * @param vo
	 * @return
	 */
	ResultResponse<?> getAssignById(AssignVo vo);

	ResultResponse<?> addPerformance(InvoiceOperationVo vo) throws BusinessException;

}
