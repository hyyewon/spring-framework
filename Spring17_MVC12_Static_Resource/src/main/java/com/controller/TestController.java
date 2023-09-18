package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // 이전 서블릿에서 했던 요청처리와 응답처리를 구현
public class TestController {

	//http://localhost:8090/app/
	@GetMapping("/") 
	public String home() {

		return "main"; 
	}
	

}
