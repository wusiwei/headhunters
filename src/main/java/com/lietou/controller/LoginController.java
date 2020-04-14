package com.lietou.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lietou.model.User;
import com.lietou.service.UserService;
import com.lietou.util.ResultResponse;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	
	@ResponseBody
	@RequestMapping(value = "/byPassword")
	public ResultResponse<?> userLogin(@RequestBody User user) {
		return userService.userLogin(user);
	}
}
