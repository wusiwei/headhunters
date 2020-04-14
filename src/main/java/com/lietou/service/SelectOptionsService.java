package com.lietou.service;

import com.lietou.queryvo.OptionsQueryVo;
import com.lietou.util.ResultResponse;

public interface SelectOptionsService {

	ResultResponse<?> getSelectOptions(OptionsQueryVo queryVo);

}
