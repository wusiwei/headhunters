package com.lietou.filter;

import com.lietou.dto.UserDto;

public class ApplicationHelper {
	private static ThreadLocal<UserDto> threadLocal = new ThreadLocal<UserDto>();
	
    public static UserDto getAccount() {
    	UserDto account = threadLocal.get();
        return account;
    }
    
    public static void setAccount(UserDto account){
    	threadLocal.set(account);
    }
    
    public static void remove(){
        threadLocal.remove();
    }
}
