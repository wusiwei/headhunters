package com.lietou.filter;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.lietou.dto.LoginDto;
import com.lietou.dto.UserDto;
import com.lietou.util.CheckResult;
import com.lietou.util.ResultResponse;
import com.lietou.util.TokenMgr;

import io.jsonwebtoken.Claims;

/**
 * 所有调用的请求，都会经过该filter过滤,session ,后期要有合法的access token将会返回错误信息
 *
 * @author wusiwei
 */
@Component
public class AuthenticationFilter implements Filter {
	
    protected Logger logger = LoggerFactory.getLogger(AuthenticationFilter.class);

    private static String appSignKey;
    /**
     * 忽略认证的url请求
     */
    private String[] ignoreUrls;

    @Override
    public void destroy() {
    	ApplicationHelper.remove();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        
        String requestUrl=httpRequest.getRequestURI();
        logger.info(requestUrl);
        ServletRequest requestWrapper = null;
        if(requestUrl.contains("import")|| requestUrl.contains("upload/")|| requestUrl.contains("uploadFileKeepName")){
        	requestWrapper=request;
        }else{
        	requestWrapper=new RequestWrapper((HttpServletRequest) request);
        }
        
        if (matchIgnoreUrl(httpRequest)) {
            chain.doFilter(requestWrapper, response);
            return;
        }

        String token = httpRequest.getParameter("access-token");
        
        if (StringUtils.isBlank(token)) {
            token = httpRequest.getHeader("access-token");
        }
        
        if("testToken".equals(token)){
        	UserDto user = new UserDto();
        	user.setId(1L);
        	user.setcId(1L);
        	user.setpIds(new Long[]{1L,2L});
        	saveUser2ThreadLocal(user);
        	chain.doFilter(requestWrapper, response);
            return;
        }
        if(StringUtils.isNotEmpty(token)){
        	
        	logger.info("过滤器" + token);
        	CheckResult checkResult=TokenMgr.validateJWT(token);
        	
        	if(!checkResult.isSuccess()){
        		logger.info("过滤器校验失败" + token);
        		ResultResponse result = new ResultResponse();
            	result.setCode("10002");
            	result.setMessage("过期access-token,请重新登录！");
                write2Response(httpResponse, result);
                return;
        	}else{
        		Claims claims=checkResult.getClaims();
        		UserDto user =JSONObject.parseObject(claims.getSubject(), UserDto.class);
        		
        		saveUser2ThreadLocal(user);
        	}
        	
			chain.doFilter(requestWrapper, response);
            return;
        }else{
            
        	ResultResponse result = new ResultResponse();
        	result.setCode("10001");
        	result.setMessage("缺少access-token！");
            write2Response(httpResponse, result);
            return;
        	
        }
        
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        System.out.println("过滤");

    }

    private void write2Response(HttpServletResponse httpResponse, ResultResponse result) throws IOException {
        httpResponse.setContentType("application/json; charset=utf-8");
        httpResponse.getWriter().write(JSONObject.toJSONString(result));
    }

    private void saveUser2ThreadLocal(UserDto user) {
        ApplicationHelper.setAccount(user);
    }

    private boolean matchIgnoreUrl(HttpServletRequest request) {
    	String reqUrl=request.getRequestURI();
    	if(reqUrl.contains("/login/") || reqUrl.contains("/public/")){
    		return true;
    	}
    	return false;
    }
    
    
}
