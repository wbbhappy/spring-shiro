package com.authc.shiro;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyHandleException implements HandlerExceptionResolver {
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object obj, Exception exception) {
		// 是否是ajax请求
		String requestType = request.getHeader("X-Requested-With");
		if(exception instanceof AuthorizationException) {
		 	response.setStatus(413); //无权限异常
		 	response.addHeader("Error-Json", "{code:413,msg:'nopermission',script:''}");
			response.setContentType("text/html;charset=utf-8");
			if("XMLHttpRequest".equals(requestType)){
				return new ModelAndView();
			}
			return new ModelAndView("redirect:/error.jsp");
		}
		return null;
	}
}
