package com.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dto.LoginDTO;

@Controller //이전 서블릿에서 했던 요청처리와 응답처리를 구현
public class TestController {
	
	@RequestMapping("/main")
	public String main() {
		return "main"; 
	}

	@PostMapping("/yyy")
	public String yyy(@RequestBody LoginDTO dto) {//json으로 넘어오는 데이터가 LoginDTO로 저장됨
		System.out.println(dto);
		return "main";
	}
	
	@PostMapping("/zzz")
	public String zzz(@RequestBody ArrayList<LoginDTO> list) {//json으로 넘어오는 데이터가 LoginDTO로 저장됨
		System.out.println(list);
		return "main";
	}
	
}
