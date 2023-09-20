package com.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.dto.MemberDTO;

@Component("xxx")
public class LoginCheckHandlerInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) //Object handler에는 Controller 정보가 저장됨
			throws Exception {
		//Controller 전에 실행되는 메서드
		//기능 : request 이용해서 특별한 작업 수행 ==> 로그인 여부 확인
		System.out.println("LoginCheckHandlerInterceptor.preHandle");
		HttpSession session = request.getSession();
		MemberDTO dto =(MemberDTO) session.getAttribute("login");
		if(dto==null) {
			response.sendRedirect("/shop/LoginUIServlet"); //loginForm.jsp화면으로 넘어감
			return false; //Controller 요청 안됨
		}
		return true; //Controller 요청됨
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//기능 : response 및 ModelAndView 이용해서 특별한 작업 수행 ==> ModelAndView 이용하여 view정보 변경 작업 가능
		System.out.println("LoginCheckHandlerInterceptor.postHandle");
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("LoginCheckHandlerInterceptor.afterCompletion");
	}

	
	
}
