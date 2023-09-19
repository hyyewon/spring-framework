package com.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dto.LoginDTO;

@Controller //이전 서블릿에서 했던 요청처리와 응답처리를 구현
public class TestController {
	
	@RequestMapping("/main")
	public String main() {
		return "main"; //main.jsp에서 js를 만들어서 java메서드와 연동
	}

	@RequestMapping("/xxx")
	public LoginDTO xxx() {
		
		LoginDTO dto = new LoginDTO();
		dto.setUserid("홍길동");
		dto.setPasswd("1234");
		
		return dto;
	}
	
	@RequestMapping("/yyy")
	// @ResponseBody 없으면 LoginDTO를 모델로 생각함, 있으면 LoginDTO를 모델로 처리하지 않고 JSON으로 응답만 해줌.
	@ResponseBody //LoginDTO ==> JSON
	public LoginDTO yyy() {
		
		LoginDTO dto = new LoginDTO();
		dto.setUserid("홍길동");
		dto.setPasswd("1234");
		
		return dto;
	}
	
	@RequestMapping("/zzz")
	@ResponseBody //ArrayList<LoginDTO> ==> JSON으로 변경
	public ArrayList<LoginDTO> zzz() {
		
		ArrayList<LoginDTO> list = new ArrayList<LoginDTO>();
		list.add(new LoginDTO("aaa1", "1234"));
		list.add(new LoginDTO("aaa2", "1234"));
		list.add(new LoginDTO("aaa3", "1234"));
		return list;
	}
	
	
}
