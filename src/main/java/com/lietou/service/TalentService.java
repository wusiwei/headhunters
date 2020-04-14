package com.lietou.service;

import com.lietou.model.Remark;
import com.lietou.queryvo.TalentQueryVo;
import com.lietou.util.Page;
import com.lietou.util.ResultResponse;
import com.lietou.vo.RemarkVo;
import com.lietou.vo.TalentVo;

public interface TalentService {

	ResultResponse<?> add(TalentVo vo);

	ResultResponse<?> modify(TalentVo vo);

	Page getList(TalentQueryVo queryVO);

	ResultResponse<?> getById(TalentQueryVo vo);

	ResultResponse<?> unFocus(TalentQueryVo queryVo);

	ResultResponse<?> focus(TalentQueryVo queryVo);

	ResultResponse<?> addRemark(Remark remark);

	ResultResponse<?> modifyRemark(Remark remark);

	ResultResponse<?> deleteRemark(RemarkVo vo);

	ResultResponse<?> getRemarkById(RemarkVo vo);

	ResultResponse<?> getAllRemark(RemarkVo vo);

	ResultResponse<?> updateStatus(TalentQueryVo vo);

	ResultResponse<?> updateTags(TalentQueryVo vo);

}
