package com.lietou.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lietou.dto.LoginDto;
import com.lietou.mapper.UserMapper;
import com.lietou.model.User;
import com.lietou.service.UserService;
import com.lietou.util.EnAndDeCodeUtils;
import com.lietou.util.ResultResponse;
import com.lietou.util.TokenMgr;

@Service
public class UserServiceImpl implements UserService{
	
	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public ResultResponse<?> userLogin(User user) {
		ResultResponse<LoginDto> result = new ResultResponse<>();
		user.setPassword(EnAndDeCodeUtils.encodeByMd5AndBase64(user.getPassword()));
		LoginDto loginUser=userMapper.getByLoginNameAndPassword(user);
		if(loginUser == null){
			result.setCode("10201");
			result.setMessage("账号密码错误");
			return result;
		}
		if(loginUser.getFreezeFlag()){
			result.setCode("10202");
			result.setMessage("账号已被冻结，请联系管理员");
			return result;
		}
		String jwt=TokenMgr.createJWT(loginUser.getId().toString(), TokenMgr.generalSubject(loginUser), 10*24*60*60*1000);
		loginUser.setJwt(jwt);
		result.setCode("20000");
		result.setMessage("登录成功");
		result.setData(loginUser);
		return result;
	}
}
