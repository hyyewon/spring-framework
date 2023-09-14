package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //이전 서블릿에서 했던 요청처리와 응답처리를 구현
public class TestController {

	//http://localhost:8090/app/xxx
	@RequestMapping("/xxx")
	public String home() { //return 타입이 String이면 view 정보를 알려준다.
		System.out.println("TestController.home메서드");
		
		return"hello"; //논리적이름
	}
	
	//http://localhost:8090/app/yyy
	@RequestMapping(value="/yyy")
	public String main() {
		System.out.println("TestController.main메서드");
		
		return"hello"; //응답처리
	}
	
}
