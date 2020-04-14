package com.lietou.service;

import com.lietou.util.ResultResponse;
import com.lietou.vo.DictVO;

public interface DictService {

	/**
	 * 根据类别获取基础树结构
	 * @param queryVO
	 * @return
	 */
	ResultResponse<?> getBaseTreeByClassify(DictVO queryVO);

	/**
	 * 新增基础字典数据
	 * @param queryVO
	 * @return
	 */
	ResultResponse<?> addBaseDict(DictVO queryVO);

	/**
	 * 批量新增下级字典数据
	 * @param queryVO
	 * @return
	 */
	ResultResponse<?> batchAddChildrenDict(DictVO queryVO);

	/**
	 * 批量删除字典数据
	 * @param queryVO
	 * @return
	 */
	ResultResponse<?> batchDeleteDict(DictVO queryVO);

	ResultResponse<?> adjustDIndex(DictVO queryVO);

	/**
	 * 获取省市接口
	 * @return
	 */
	ResultResponse<?> getProvincesAndCities();

	/**
	 * 获取省市区接口
	 * @return
	 */
	ResultResponse<?> getProvincesAndCitiesArea();

}
