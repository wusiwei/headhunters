package com.lietou.service;

import com.lietou.queryvo.TalentQueryVo;
import com.lietou.util.ResultResponse;

public interface TalentAnalyzeService {

	ResultResponse<?> resumeDocAnalyze(TalentQueryVo queryVo);

	ResultResponse<?> resumeHtmAnalyze(TalentQueryVo queryVo);

}
