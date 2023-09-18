package com.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.dto.LoginDTO;

@Component("xxx")
public class MyHandlerInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) //Object handler에는 Controller 정보가 저장됨
			throws Exception {
		//기능 : request 이용해서 특별한 작업 수행 ==> 로그인 여부 확인
		System.out.println("MyHandlerInterceptor.preHandle");
		HttpSession session = request.getSession();
		LoginDTO dto =(LoginDTO) session.getAttribute("login");
		if(dto==null) {
			response.sendRedirect("/app/loginForm"); //절대경로
			return false; //Controller로 안넘어가고 redirect쳐줌
		}
		return true; //true를 줘야 Controller로 넘어감
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//기능 : response 및 ModelAndView 이용해서 특별한 작업 수행 ==> ModelAndView 이용하여 view정보 변경 작업 가능
		System.out.println("MyHandlerInterceptor.postHandle");
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("MyHandlerInterceptor.afterCompletion");
	}

	
	
}
