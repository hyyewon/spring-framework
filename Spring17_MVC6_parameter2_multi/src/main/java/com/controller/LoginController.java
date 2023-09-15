package com.controller;

import java.util.Arrays;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
	public String login(LoginDTO dto) { //자동으로 LoginDTO dto = new LoginDTO();
		System.out.println(dto);
		return "loginForm"; 
	}
	
	@GetMapping("/login2")
	public String login2(HttpServletRequest request) {
		//사용자 입력 데이터 얻기
		String [] phone = request.getParameterValues("phone");
		String [] email = request.getParameterValues("email");
		
		System.out.println(Arrays.toString(phone)+" "+Arrays.toString(email));
		
		return "loginForm"; 
	}
	
	

}
