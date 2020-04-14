package com.lietou.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lietou.bo.FavoritesBusinessBo;
import com.lietou.dto.FavoritesDto;
import com.lietou.mapper.FavoritesBusinessMapper;
import com.lietou.mapper.FavoritesMapper;
import com.lietou.mapper.FavoritesShareMapper;
import com.lietou.queryvo.FavoritesQueryVo;
import com.lietou.service.FavoritesService;
import com.lietou.util.DateFormatUtil;
import com.lietou.util.ResultResponse;
import com.lietou.vo.FavoritesVo;

@Service
public class FavoritesServiceImpl implements FavoritesService{
	
	private static final Logger log = LoggerFactory.getLogger(FavoritesServiceImpl.class);
	
	@Autowired
	private FavoritesMapper favoritesMapper;
	
	@Autowired
	private FavoritesBusinessMapper favoritesBusinessMapper;
	
	@Autowired
	private FavoritesShareMapper favoritesShareMapper;
	
	@Override
	@Transactional
	public ResultResponse<?> add(FavoritesVo vo) {
		ResultResponse<Integer> result = new ResultResponse<Integer>();
		if(vo.getParentId() == null){
			vo.setParentId(0L);
		}
		vo.setBusinessCount(0);
		vo.setCreateTime(DateFormatUtil.date2String(new Date(), DateFormatUtil.FORMAT_YYYY_MM_DD_SS_NO_SPACE));
		int a=favoritesMapper.voInsert(vo);
		if(CollectionUtils.isNotEmpty(vo.getShare())){
			favoritesShareMapper.batchAddShare(vo);
		}
		result.setData(a);
		result.setCode("20000");
		result.setMessage("新增成功");
		return result;
	}
	
	@Override
	@Transactional
	public ResultResponse<?> modify(FavoritesVo vo) {
		ResultResponse<Integer> result = new ResultResponse<Integer>();
		if(vo.getParentId() == null){
			vo.setParentId(0L);
		}
		int a=favoritesMapper.voUpdate(vo);
		if(a < 1){
			result.setCode("40101");
			result.setMessage("无权修改收藏夹");
			return result;
		}
		favoritesShareMapper.deleteByFavorites(vo);
		if(CollectionUtils.isNotEmpty(vo.getShare())){
			favoritesShareMapper.batchAddShare(vo);
		}
		result.setData(a);
		result.setCode("20000");
		result.setMessage("修改成功");
		return result;
	}
	
	@Override
	@Transactional
	public ResultResponse<?> deleteById(FavoritesVo vo) {
		ResultResponse<Integer> result = new ResultResponse<Integer>();
		int childrenNum=favoritesMapper.checkHaveChildren(vo.getId());
		if(childrenNum > 0){
			result.setCode("40103");
			result.setMessage("存在子收藏夹,无法删除");
			return result;
		}
		int a=favoritesMapper.deleteMainByFavorites(vo);
		if(a < 1){
			result.setCode("40102");
			result.setMessage("无权删除收藏夹");
			return result;
		}
		favoritesMapper.deleteSubByFavorites(vo);
		result.setData(a);
		result.setCode("20000");
		result.setMessage("删除成功");
		return result;
	}
	
	@Override
	public ResultResponse<?> getUserFavoritesTree(FavoritesQueryVo queryVo) {
		ResultResponse<List<FavoritesDto>> result = new ResultResponse<List<FavoritesDto>>();
		Long[] ids=favoritesShareMapper.getSharedFavoritesIds(queryVo);
		queryVo.setFavoritesIdsStr(StringUtils.join(ids, ","));
		result.setData(favoritesMapper.getUserNoShareDto(queryVo));
		result.setCode("20000");
		result.setMessage("获取成功");
		return result;
	}
	
	@Override
	public ResultResponse<?> getUserFavoritesTreeDetail(FavoritesQueryVo queryVo) {
		ResultResponse<List<FavoritesDto>> result = new ResultResponse<List<FavoritesDto>>();
		Long[] ids=favoritesShareMapper.getSharedFavoritesIds(queryVo);
		queryVo.setFavoritesIdsStr(StringUtils.join(ids, ","));
		result.setData(favoritesMapper.getUserHaveShareDto(queryVo));
		result.setCode("20000");
		result.setMessage("获取成功");
		return result;
	}
	
	@Override
	@Transactional
	public ResultResponse<?> addToFavorites(FavoritesBusinessBo bo) {
		ResultResponse<Integer> result = new ResultResponse<Integer>();
		if(bo.getBusinessIds() == null || bo.getBusinessIds().length < 1 ){
			result.setCode("40201");
			result.setMessage("请选择一条以上数据!");
			return result;
		}
		if(bo.getFavoritesId() == null || StringUtils.isBlank(bo.getBusinessType())){
			result.setCode("40202");
			result.setMessage("请选择加入的收藏夹!");
			return result;
		}
		bo.setCreateTime(DateFormatUtil.date2String(new Date(), DateFormatUtil.FORMAT_YYYY_MM_DD_SS_NO_SPACE));
		int a=favoritesBusinessMapper.batchAddBusiness(bo);
		if(a > 0){
			favoritesMapper.restBusinessCount(bo.getFavoritesId());
			if("talent".equals(bo.getBusinessType())){
				favoritesBusinessMapper.batchRestTalent(bo);
			}
		}
		result.setData(a);
		result.setCode("20000");
		result.setMessage("加入收藏夹成功");
		return result;
	}
	
	@Override
	@Transactional
	public ResultResponse<?> removeFromFavorites(FavoritesBusinessBo bo) {
		ResultResponse<Integer> result = new ResultResponse<Integer>();
		if(bo.getBusinessIds() == null || bo.getBusinessIds().length < 1 ){
			result.setCode("40201");
			result.setMessage("请选择一条以上数据!");
			return result;
		}
		if(bo.getFavoritesId() == null || StringUtils.isBlank(bo.getBusinessType())){
			result.setCode("40203");
			result.setMessage("请选择移出的收藏夹!");
			return result;
		}
		int a=favoritesBusinessMapper.batchAddBusiness(bo);
		if(a > 0){
			favoritesMapper.restBusinessCount(bo.getFavoritesId());
			if("talent".equals(bo.getBusinessType())){
				favoritesBusinessMapper.batchRestTalent(bo);
			}
		}
		result.setData(a);
		result.setCode("20000");
		result.setMessage("移除收藏夹成功");
		return result;
	}
	
}
