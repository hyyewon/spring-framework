package com.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dto.LoginDTO;

@Controller // 이전 서블릿에서 했던 요청처리와 응답처리를 구현
public class LoginController {

	@GetMapping("/loginForm") // 화면을 봐야하기 때문에 GET방식 사용
	public String home() {

		return "loginForm"; // /WEB-INF/views/loginForm.jsp 로 포워드 요청된다.
	}
	
	
	@GetMapping("/login")
	public String login(LoginDTO dto, HttpSession session) {
		//저장된 데이터 이용해서 DB 연동해서 검증했다고 가정
		//세션에 저장
		session.setAttribute("login", dto);
		return "login"; // /WEB-INF/views/login.jsp
	}
	
	@GetMapping("/loginCheck/logout") // 화면을 봐야하기 때문에 GET방식 사용
	public String logout(HttpSession session) {//로그인 체크 여부 확인 위해서 필요
			session.invalidate();
			return "main"; // /WEB-INF/views/main.jsp 로 포워드 요청된다.
		
	}
	
	@GetMapping("/loginCheck/mypage")
	public String mypage() {
		return "main"; 
	}
	

}
