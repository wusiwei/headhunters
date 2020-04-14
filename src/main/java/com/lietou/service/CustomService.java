package com.lietou.service;

import com.lietou.model.Remark;
import com.lietou.util.Page;
import com.lietou.util.ResultResponse;
import com.lietou.vo.CustomVo;
import com.lietou.vo.RemarkVo;

public interface CustomService {

	ResultResponse<?> add(CustomVo customVo);

	Page getCustomList(CustomVo queryVO);

	ResultResponse<?> modifyShortName(CustomVo customVo);

	/**
	 * 关注
	 * @param customVo
	 * @return
	 */
	ResultResponse<?> focus(CustomVo customVo);

	/**
	 * 取消关注
	 * @param customVo
	 * @return
	 */
	ResultResponse<?> unFocus(CustomVo customVo);

	ResultResponse<?> getById(CustomVo customVo);

	/**
	 * 添加客户备注
	 * @param remark
	 * @return
	 */
	ResultResponse<?> addRemark(Remark remark);

	/**
	 * 修改客户备注
	 * @param remark
	 * @return
	 */
	ResultResponse<?> modifyRemark(Remark remark);

	/**
	 * 删除客户备注
	 * @param vo
	 * @return
	 */
	ResultResponse<?> deleteRemark(RemarkVo vo);

	/**
	 * 获取客户备注详情
	 * @param vo
	 * @return
	 */
	ResultResponse<?> getRemarkById(RemarkVo vo);

	/**
	 * 根据客户id,获取备注信息
	 * @param vo
	 * @return
	 */
	ResultResponse<?> getAllRemark(RemarkVo vo);

	ResultResponse<?> modify(CustomVo customVo);
}
