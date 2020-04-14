package com.lietou.service;

import com.lietou.model.User;
import com.lietou.util.ResultResponse;

public interface UserService {

	ResultResponse<?> userLogin(User user);

}
