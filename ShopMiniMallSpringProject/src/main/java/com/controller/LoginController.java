package com.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dto.MemberDTO;
import com.service.MemberService;

@Controller
public class LoginController {
	
	@Autowired
	MemberService service;

	//화면만 보여주는 경우
	//servlet-context.xml에서 해당 메서드를 사용하지 않고 .jsp로 넘어가는 작업 수행 가능
//	@GetMapping("/LoginUIServlet")
//	public String loginUI() {
//		return "loginForm";
//	}
	
	@GetMapping("/LoginServlet")
	public String login(@RequestParam HashMap<String, String> map,
						HttpSession session) {
		MemberDTO dto = service.login(map);
		String nextPage=null;
		if(dto != null) {
			session.setAttribute("login", dto);
			nextPage = "redirect:main"; 
		}else {
			nextPage = "member/loginFail"; // /WEB-INF/views/member/loginFail.jsp
		}
		return nextPage;
	}
	
	@GetMapping("/LogoutServlet")
	public String logout(HttpSession session) {
		session.invalidate(); //무조건 로그인 체크가 된 상태이기 때문에 (intercepter가 처리함)
		return "redirect:main";
	}
	
}
