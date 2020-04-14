package com.lietou.mapper;

import com.lietou.common.BaseMapper;
import com.lietou.dto.LoginDto;
import com.lietou.model.User;

public interface UserMapper extends BaseMapper<User>{
    
    LoginDto getByLoginNameAndPassword(User record);
}