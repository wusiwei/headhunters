package com.lietou.service.impl;

import java.math.BigDecimal;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lietou.dto.AssignDto;
import com.lietou.dto.InvoiceDto;
import com.lietou.exception.BusinessException;
import com.lietou.mapper.AssignDetailMapper;
import com.lietou.mapper.AssignMapper;
import com.lietou.mapper.InvoiceMapper;
import com.lietou.mapper.InvoiceRecordMapper;
import com.lietou.model.Assign;
import com.lietou.model.AssignDetail;
import com.lietou.model.Invoice;
import com.lietou.model.InvoiceRecord;
import com.lietou.service.InvoiceOperationService;
import com.lietou.util.DateFormatUtil;
import com.lietou.util.ResultResponse;
import com.lietou.vo.AssignVo;
import com.lietou.vo.InvoiceOperationVo;

@Service
public class InvoiceOperationServiceImpl implements InvoiceOperationService{
	
	private static final Logger log = LoggerFactory.getLogger(InvoiceOperationServiceImpl.class);
	
	@Autowired
	private InvoiceMapper invoiceMapper;
	
	@Autowired
	private InvoiceRecordMapper invoiceRecordMapper;
	
	@Autowired
	private AssignMapper assignMapper;
	
	@Autowired
	private AssignDetailMapper assignDetailMapper;
	
	@Override
	@Transactional
	public ResultResponse<?> agree(InvoiceOperationVo vo) throws BusinessException{
		ResultResponse<InvoiceDto> result = new ResultResponse<InvoiceDto>();
		
		Invoice invoice=invoiceMapper.getByIdAndVersion(vo);
		if(invoice == null){
			result.setCode("30201");
			result.setMessage("流程已更新,请刷新");
			return result;
		}
		String nowStr=DateFormatUtil.date2String(new Date(), DateFormatUtil.FORMAT_YYYY_MM_DD_SS_NO_SPACE);
		invoice.setStatus(2);
		invoice.setUpdateTime(nowStr);
		int index=invoiceMapper.invoiceOperation(invoice);
		if(index < 1){
			result.setCode("30201");
			result.setMessage("流程已更新,请刷新");
			return result;
		}
		InvoiceRecord invoiceRecord=new InvoiceRecord();
		invoiceRecord.setCreaterId(vo.getCreaterId());
		invoiceRecord.setCreateTime(nowStr);
		invoiceRecord.setInvoiceId(vo.getInvoiceId());
		invoiceRecord.setRemark("备注:"+vo.getRemark());
		invoiceRecord.setOperationType("agree");
		invoiceRecord.setOperationTypeLabel("审批同意");
		invoiceRecordMapper.insertSelective(invoiceRecord);
		result.setCode("20000");
		result.setMessage("同意");
		return result;
	}
	
	@Override
	@Transactional
	public ResultResponse<?> disAgree(InvoiceOperationVo vo) throws BusinessException{
		ResultResponse<InvoiceDto> result = new ResultResponse<InvoiceDto>();
		Invoice invoice=invoiceMapper.getByIdAndVersion(vo);
		if(invoice == null){
			result.setCode("30201");
			result.setMessage("流程已更新,请刷新");
			return result;
		}
		String nowStr=DateFormatUtil.date2String(new Date(), DateFormatUtil.FORMAT_YYYY_MM_DD_SS_NO_SPACE);
		invoice.setStatus(0);
		invoice.setUpdateTime(nowStr);
		int index=invoiceMapper.invoiceOperation(invoice);
		if(index < 1){
			result.setCode("30201");
			result.setMessage("流程已更新,请刷新");
			return result;
		}
		InvoiceRecord invoiceRecord=new InvoiceRecord();
		invoiceRecord.setCreaterId(vo.getCreaterId());
		invoiceRecord.setCreateTime(nowStr);
		invoiceRecord.setInvoiceId(vo.getInvoiceId());
		invoiceRecord.setRemark("备注:"+vo.getRemark());
		invoiceRecord.setOperationType("disagree");
		invoiceRecord.setOperationTypeLabel("审批不同意");
		invoiceRecordMapper.insertSelective(invoiceRecord);
		result.setCode("20000");
		result.setMessage("不同意");
		return result;
	}
	
	@Override
	@Transactional
	public ResultResponse<?> make(InvoiceOperationVo vo) throws BusinessException{
		ResultResponse<InvoiceDto> result = new ResultResponse<InvoiceDto>();
		Invoice invoice=invoiceMapper.getByIdAndVersion(vo);
		if(invoice == null){
			result.setCode("30201");
			result.setMessage("流程已更新,请刷新");
			return result;
		}
		String nowStr=DateFormatUtil.date2String(new Date(), DateFormatUtil.FORMAT_YYYY_MM_DD_SS_NO_SPACE);
		invoice.setStatus(3);
		invoice.setUpdateTime(nowStr);
		invoice.setCollectionDate(vo.getCollectionDate());
		invoice.setMakeDate(nowStr);
		int index=invoiceMapper.invoiceOperation(invoice);
		if(index < 1){
			result.setCode("30201");
			result.setMessage("流程已更新,请刷新");
			return result;
		}
		InvoiceRecord invoiceRecord=new InvoiceRecord();
		invoiceRecord.setCreaterId(vo.getCreaterId());
		invoiceRecord.setCreateTime(nowStr);
		invoiceRecord.setInvoiceId(vo.getInvoiceId());
		invoiceRecord.setRemark("预计收款时间:"+vo.getCollectionDate()+"  备注:"+vo.getRemark());
		invoiceRecord.setOperationType("make");
		invoiceRecord.setOperationTypeLabel("开出发票");
		invoiceRecordMapper.insertSelective(invoiceRecord);
		result.setCode("20000");
		result.setMessage("开票成功");
		return result;
	}
	
	@Override
	@Transactional
	public ResultResponse<?> charge(InvoiceOperationVo vo) throws BusinessException{
		ResultResponse<InvoiceDto> result = new ResultResponse<InvoiceDto>();
		Invoice invoice=invoiceMapper.getByIdAndVersion(vo);
		if(invoice == null){
			result.setCode("30201");
			result.setMessage("流程已更新,请刷新");
			return result;
		}
		String nowStr=DateFormatUtil.date2String(new Date(), DateFormatUtil.FORMAT_YYYY_MM_DD_SS_NO_SPACE);
		invoice.setStatus(4);
		invoice.setUpdateTime(nowStr);
		invoice.setCharged(vo.getCharged());
		invoice.setLastChargedDate(nowStr);
		int index=invoiceMapper.invoiceOperation(invoice);
		if(index < 1){
			result.setCode("30201");
			result.setMessage("流程已更新,请刷新");
			return result;
		}
		InvoiceRecord invoiceRecord=new InvoiceRecord();
		invoiceRecord.setCreaterId(vo.getCreaterId());
		invoiceRecord.setCreateTime(nowStr);
		invoiceRecord.setInvoiceId(vo.getInvoiceId());
		invoiceRecord.setRemark("收款金额:"+vo.getCharged()+"  备注:"+vo.getRemark());
		invoiceRecord.setOperationType("charge");
		invoiceRecord.setOperationTypeLabel("收到付款");
		invoiceRecordMapper.insertSelective(invoiceRecord);
		result.setCode("20000");
		result.setMessage("收款成功");
		return result;
	}
	
	@Override
	@Transactional
	public ResultResponse<?> refundinvoice(InvoiceOperationVo vo) throws BusinessException{
		ResultResponse<InvoiceDto> result = new ResultResponse<InvoiceDto>();
		Invoice invoice=invoiceMapper.getByIdAndVersion(vo);
		if(invoice == null){
			result.setCode("30201");
			result.setMessage("流程已更新,请刷新");
			return result;
		}
		String nowStr=DateFormatUtil.date2String(new Date(), DateFormatUtil.FORMAT_YYYY_MM_DD_SS_NO_SPACE);
		invoice.setStatus(10);
		invoice.setUpdateTime(nowStr);
		invoice.setCollectionDate("");
		invoice.setMakeDate("");
		int index=invoiceMapper.invoiceOperation(invoice);
		if(index < 1){
			result.setCode("30201");
			result.setMessage("流程已更新,请刷新");
			return result;
		}
		InvoiceRecord invoiceRecord=new InvoiceRecord();
		invoiceRecord.setCreaterId(vo.getCreaterId());
		invoiceRecord.setCreateTime(nowStr);
		invoiceRecord.setInvoiceId(vo.getInvoiceId());
		invoiceRecord.setRemark("备注:"+vo.getRemark());
		invoiceRecord.setOperationType("refundinvoice");
		invoiceRecord.setOperationTypeLabel("退回发票");
		invoiceRecordMapper.insertSelective(invoiceRecord);
		result.setCode("20000");
		result.setMessage("退票成功");
		return result;
	}
	
	@Override
	@Transactional
	public ResultResponse<?> refundmoney(InvoiceOperationVo vo) throws BusinessException{
		ResultResponse<InvoiceDto> result = new ResultResponse<InvoiceDto>();
		Invoice invoice=invoiceMapper.getByIdAndVersion(vo);
		if(invoice == null){
			result.setCode("30201");
			result.setMessage("流程已更新,请刷新");
			return result;
		}
		int invoiceStatus=invoice.getStatus();
		if(invoiceStatus !=4 || invoiceStatus !=5 || invoiceStatus !=6){
			result.setCode("30202");
			result.setMessage("该状态不支持退款");
			return result;
		}
		String nowStr=DateFormatUtil.date2String(new Date(), DateFormatUtil.FORMAT_YYYY_MM_DD_SS_NO_SPACE);
		
		if("full".equals(vo.getRefundMoneyType())){
			switch (invoiceStatus) {
				case 4: invoice.setStatus(11); break;
				case 5: invoice.setStatus(13); break;
				case 6: invoice.setStatus(15); break;
				default:break;
			}
		}else{
			switch (invoiceStatus) {
				case 4: invoice.setStatus(12); break;
				case 5: invoice.setStatus(14); break;
				case 6: invoice.setStatus(16); break;
				default:break;
			}
		}
		
		invoice.setUpdateTime(nowStr);
		invoice.setRefundMoney(vo.getRefundMoney());
		int index=invoiceMapper.invoiceOperation(invoice);
		if(index < 1){
			result.setCode("30201");
			result.setMessage("流程已更新,请刷新");
			return result;
		}
		InvoiceRecord invoiceRecord=new InvoiceRecord();
		invoiceRecord.setCreaterId(vo.getCreaterId());
		invoiceRecord.setCreateTime(nowStr);
		invoiceRecord.setInvoiceId(vo.getInvoiceId());
		if("full".equals(vo.getRefundMoneyType())){
			invoiceRecord.setOperationType("full_"+invoice.getStatus());
			invoiceRecord.setOperationTypeLabel("全部退款");
		}else{
			invoiceRecord.setOperationType("part"+invoice.getStatus());
			invoiceRecord.setOperationTypeLabel("部分退款");
		}
		invoiceRecord.setRemark("退款金额:"+vo.getRefundMoney()+"备注:"+vo.getRemark());
		invoiceRecordMapper.insertSelective(invoiceRecord);
		result.setCode("20000");
		result.setMessage("退款成功");
		return result;
	}
	
	@Override
	@Transactional
	public ResultResponse<?> assign(InvoiceOperationVo vo) throws BusinessException{
		ResultResponse<InvoiceDto> result = new ResultResponse<InvoiceDto>();
		Invoice invoice=invoiceMapper.getByIdAndVersion(vo);
		if(invoice == null){
			result.setCode("30201");
			result.setMessage("流程已更新,请刷新");
			return result;
		}
		String nowStr=DateFormatUtil.date2String(new Date(), DateFormatUtil.FORMAT_YYYY_MM_DD_SS_NO_SPACE);
		boolean assignFlag=true;
		if(invoice.getAssignId() == null || invoice.getAssignId() == 0){
			assignFlag=false;
			Assign assign=new Assign();
			assign.setCustomerId(invoice.getCustomerId());
			assign.setProjectId(invoice.getProjectId());
			assign.setInvoiceId(invoice.getId());
			assign.setAssignMoney(vo.getAssignMoney());
			assign.setCostType(invoice.getCostType());
			assign.setCreateTime(nowStr);
			assign.setFeeCharge(invoice.getCharged());
			assign.setInvoiceAmount(invoice.getMoney());
			assign.setCreaterId(vo.getCreaterId());
			assign.setcId(vo.getCId());
			assignMapper.insertSelective(assign);
			invoice.setAssignId(assign.getId());
		}else{
			Assign assign=new Assign();
			assign.setId(invoice.getAssignId());
			assign.setAssignMoney(vo.getAssignMoney());
			assignMapper.updateByPrimaryKeySelective(assign);
		}
		
		invoice.setStatus(5);
		invoice.setUpdateTime(nowStr);
		int index=invoiceMapper.invoiceOperation(invoice);
		if(index < 1){
			throw new BusinessException("30201","流程已更新,请刷新");
		}
		vo.setAssignId(invoice.getAssignId());
		vo.setUpdateTime(nowStr);
		StringBuilder remarkBuilder=new StringBuilder("分配业绩:");
		BigDecimal assignMoney=new BigDecimal(vo.getAssignMoney()).divide(new BigDecimal(100));
		for(AssignDetail detail : vo.getAssignDetailList()){
			remarkBuilder.append(detail.getAssignederName()).append(">>提成:");
			detail.setAssignAmount(assignMoney.multiply(new BigDecimal(detail.getAssignPercent())));
			remarkBuilder.append(detail.getAssignAmount());
		}
		if(!assignFlag){
			assignDetailMapper.batchAddAssignDetail(vo);
		}else{
			assignDetailMapper.batchUpdateAssignDetail(vo);
		}
		InvoiceRecord invoiceRecord=new InvoiceRecord();
		invoiceRecord.setCreaterId(vo.getCreaterId());
		invoiceRecord.setCreateTime(nowStr);
		invoiceRecord.setInvoiceId(vo.getInvoiceId());
		invoiceRecord.setRemark(remarkBuilder.toString());
		invoiceRecord.setOperationType("assign");
		invoiceRecord.setOperationTypeLabel("提成分配");
		invoiceRecordMapper.insertSelective(invoiceRecord);
		result.setCode("20000");
		result.setMessage("分配成功");
		return result;
	}
	
	@Override
	@Transactional
	public ResultResponse<?> grant(InvoiceOperationVo vo) throws BusinessException{
		ResultResponse<InvoiceDto> result = new ResultResponse<InvoiceDto>();
		Invoice invoice=invoiceMapper.getByIdAndVersion(vo);
		if(invoice == null){
			result.setCode("30201");
			result.setMessage("流程已更新,请刷新");
			return result;
		}
		String nowStr=DateFormatUtil.date2String(new Date(), DateFormatUtil.FORMAT_YYYY_MM_DD_SS_NO_SPACE);
		invoice.setStatus(6);
		invoice.setUpdateTime(nowStr);
		int index=invoiceMapper.invoiceOperation(invoice);
		if(index < 1){
			result.setCode("30201");
			result.setMessage("流程已更新,请刷新");
			return result;
		}
		
		if(invoice.getAssignId() != null && invoice.getAssignId() != 0){
			AssignVo assignVo=new AssignVo();
			assignVo.setId(invoice.getAssignId());
			assignVo.setSendFlag(true);
			assignMapper.updateSendFlag(assignVo);
		}
		
		InvoiceRecord invoiceRecord=new InvoiceRecord();
		invoiceRecord.setCreaterId(vo.getCreaterId());
		invoiceRecord.setCreateTime(nowStr);
		invoiceRecord.setInvoiceId(vo.getInvoiceId());
		invoiceRecord.setRemark("备注:"+vo.getRemark());
		invoiceRecord.setOperationType("grant");
		invoiceRecord.setOperationTypeLabel("提成发放");
		invoiceRecordMapper.insertSelective(invoiceRecord);
		result.setCode("20000");
		result.setMessage("发放成功");
		return result;
	}
	
	@Override
	@Transactional
	public ResultResponse<?> back(InvoiceOperationVo vo) throws BusinessException{
		ResultResponse<InvoiceDto> result = new ResultResponse<InvoiceDto>();
		Invoice invoice=invoiceMapper.getByIdAndVersion(vo);
		if(invoice == null){
			result.setCode("30201");
			result.setMessage("流程已更新,请刷新");
			return result;
		}
		
		String nowStr=DateFormatUtil.date2String(new Date(), DateFormatUtil.FORMAT_YYYY_MM_DD_SS_NO_SPACE);
		
		InvoiceRecord invoiceRecord=new InvoiceRecord();
		invoice.setUpdateTime(nowStr);
		if(invoice.getStatus() ==2){
			invoice.setStatus(0);
			invoiceRecord.setRemark("备注:"+vo.getRemark());
		}else if(invoice.getStatus() ==3){
			invoice.setStatus(2);
			invoiceRecord.setRemark("流程由待付款回退到申请中;备注:"+vo.getRemark());
		}else if(invoice.getStatus() ==4){
			invoice.setStatus(3);
			invoiceRecord.setRemark("流程由收到付款回退到待付款;备注:"+vo.getRemark());
		}else if(invoice.getStatus() ==5){
			invoice.setStatus(4);
			invoiceRecord.setRemark("流程由分配回退到收到付款;备注:"+vo.getRemark());
		}else if(invoice.getStatus() ==6){
			invoice.setStatus(5);
			invoiceRecord.setRemark("流程由已发放回退到分配;备注:"+vo.getRemark());
			if(invoice.getAssignId() != null && invoice.getAssignId() != 0){
				AssignVo assignVo=new AssignVo();
				assignVo.setId(invoice.getAssignId());
				assignVo.setSendFlag(false);
				assignMapper.updateSendFlag(assignVo);
			}
		}else if(invoice.getStatus() ==10){
			invoice.setStatus(3);
			invoiceRecord.setRemark("流程由退票回退到待付款;备注:"+vo.getRemark());
		}else if(invoice.getStatus() ==11 || invoice.getStatus() == 12 ){
			invoice.setStatus(4);
			invoiceRecord.setRemark("流程由退款回退到收到付款;备注:"+vo.getRemark());
		}else if(invoice.getStatus() ==13 || invoice.getStatus() == 14 ){
			invoice.setStatus(5);
			invoiceRecord.setRemark("流程由退款回退到分配;备注:"+vo.getRemark());
		}else if(invoice.getStatus() ==15 || invoice.getStatus() == 16 ){
			invoice.setStatus(6);
			invoiceRecord.setRemark("流程由退款回退到已发放;备注:"+vo.getRemark());
		}
		
		int index=invoiceMapper.invoiceOperation(invoice);
		if(index < 1){
			result.setCode("30201");
			result.setMessage("流程已更新,请刷新");
			return result;
		}
		
		invoiceRecord.setCreaterId(vo.getCreaterId());
		invoiceRecord.setCreateTime(nowStr);
		invoiceRecord.setInvoiceId(vo.getInvoiceId());
		invoiceRecord.setOperationType("back");
		invoiceRecord.setOperationTypeLabel("流程回退");
		invoiceRecordMapper.insertSelective(invoiceRecord);
		
		result.setCode("20000");
		result.setMessage("回退成功");
		return result;
	}
	
	@Override
	public ResultResponse<?> getAssignById(AssignVo vo) {
		ResultResponse<AssignDto> result = new ResultResponse<AssignDto>();
		result.setData(assignMapper.getAssignById(vo));
		result.setCode("20000");
		result.setMessage("获取明细成功");
		return result;
	}
	
	@Override
	@Transactional
	public ResultResponse<?> addPerformance(InvoiceOperationVo vo) throws BusinessException{
		ResultResponse<InvoiceDto> result = new ResultResponse<InvoiceDto>();
		Invoice invoice=invoiceMapper.getByIdAndVersion(vo);
		if(invoice == null){
			result.setCode("30204");
			result.setMessage("发票已更新,请刷新");
			return result;
		}
		if(invoice.getPerformanceFlag()){
			result.setCode("30205");
			result.setMessage("业绩已分配,请勿重复新增");
			return result;
		}
		String nowStr=DateFormatUtil.date2String(new Date(), DateFormatUtil.FORMAT_YYYY_MM_DD_SS_NO_SPACE);
		boolean assignFlag=true;
		if(invoice.getAssignId() == null || invoice.getAssignId() == 0){
			assignFlag=false;
			Assign assign=new Assign();
			assign.setCustomerId(invoice.getCustomerId());
			assign.setProjectId(invoice.getProjectId());
			assign.setInvoiceId(invoice.getId());
			assign.setCostType(invoice.getCostType());
			assign.setCreateTime(nowStr);
			assign.setFeeCharge(vo.getFeeCharge());
			assign.setInvoiceAmount(invoice.getMoney());
			assign.setCreaterId(vo.getCreaterId());
			assign.setcId(vo.getCId());
			assignMapper.insertSelective(assign);
			invoice.setAssignId(assign.getId());
		}else{
			Assign assign=new Assign();
			assign.setId(invoice.getAssignId());
			assign.setFeeCharge(vo.getFeeCharge());
			assignMapper.updateByPrimaryKeySelective(assign);
		}
		
		invoice.setUpdateTime(nowStr);
		invoice.setPerformanceFlag(true);
		int index=invoiceMapper.invoiceOperation(invoice);
		if(index < 1){
			throw new BusinessException("30204","发票已更新,请刷新");
		}
		vo.setAssignId(invoice.getAssignId());
		vo.setUpdateTime(nowStr);
		BigDecimal assignMoney=new BigDecimal(vo.getFeeCharge()).divide(new BigDecimal(100));
		for(AssignDetail detail : vo.getAssignDetailList()){
			detail.setPerformanceAmount(assignMoney.multiply(new BigDecimal(detail.getPerformancePercent())));
		}
		if(!assignFlag){
			assignDetailMapper.batchAddPerformance(vo);
		}else{
			assignDetailMapper.batchUpdatePerformance(vo);
		}
		
		result.setCode("20000");
		result.setMessage("新增业绩成功");
		return result;
	}
}
