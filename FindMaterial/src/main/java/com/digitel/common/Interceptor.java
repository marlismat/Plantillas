package com.digitel.common;


import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.digitel.security.JwtUtil;

public class Interceptor implements HandlerInterceptor, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8148811813632434546L;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) //cuando lo esta llamando
			throws Exception {

		 //JwtUtil.getAuthentication(request);
		 RechargeProperties.rechargePropertie();
		
			return true;
	
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}//cuando recibe el  llamando

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}//despues que hace el llamado
	
}

