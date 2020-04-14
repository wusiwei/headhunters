package com.lietou.service;

import com.lietou.model.CustomContact;
import com.lietou.model.CustomContactRecord;
import com.lietou.util.Page;
import com.lietou.util.ResultResponse;
import com.lietou.vo.CustomContactVo;

public interface CustomContactService {

	ResultResponse<?> add(CustomContact customContact);

	ResultResponse<?> modify(CustomContact customContact);

	ResultResponse<?> getById(CustomContactVo customContact);

	Page getList(CustomContactVo queryVO);

	ResultResponse<?> deleteByIds(CustomContactVo vo);

	ResultResponse<?> addContactRecord(CustomContactRecord record);

	ResultResponse<?> modifyContactRecord(CustomContactRecord record);

	ResultResponse<?> getRecordById(Long id);

}
