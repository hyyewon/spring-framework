package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //이전 서블릿에서 했던 요청처리와 응답처리를 구현
public class TestController {

	@RequestMapping("/xxx")
	public String home() { //return 타입이 String이면 view 정보를 알려준다.
		System.out.println("TestController.home메서드");
		
		//명시적으로 예외 발생
		if(true)throw new ArithmeticException("error 발생됨."); //0으로 나누면 발생하는 예외
		
		return"hello"; //정상적으로 실행될 시 hello로 감
	}
	
	@RequestMapping(value="/yyy")
	public String main() {
		System.out.println("TestController.main메서드");
		
		//명시적으로 예외 발생
		if(true)throw new NullPointerException("error 발생됨."); 
		
		return"hello"; 
	}
	
	//ArithmeticException와 NullPointerException을 처리해주는 예외 처리 페이지
	@ExceptionHandler({ArithmeticException.class, NullPointerException.class}) 
	public String error() {
		return "error"; //해당 예외 발생시 error로 감
	}
	
}
