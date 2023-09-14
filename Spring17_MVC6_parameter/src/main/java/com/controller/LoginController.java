package com.controller;

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
	public String login(@RequestParam Map<String, String> m) {
		//사용자 입력 데이터 얻기
		System.out.println(m); //{userid=홍길동, passwd=1234}
		return "loginForm"; 
	}
	
	@GetMapping("/login5")
	public String login5(LoginDTO dto) {
		//사용자 입력 데이터 얻기
		System.out.println(dto);
		return "loginForm"; 
	}
	
	/*
	 	name값(요청 파라미터명)과 저장할 변수명이 동일하면,
	 	@RequestParam의 value값 생략 가능
	 */
	
	@GetMapping("/login4")
	public String login4(@RequestParam String userid,
						@RequestParam("passwd") String pw) {
		//사용자 입력 데이터 얻기
		System.out.println(userid+" "+pw);
		return "loginForm"; 
	}
	
	/*
	   @RequestParam 사용시 주의점
	   - 존재하지 않는 key의 경우 에러 발생. 따라서 반드시 요청파라미터가 존재해야 한다.
	   - 필수사항을 옵션으로 변경 가능.
	   - required = false 으로 지정해서 예외 대신에 null값으로 받음.
	   	 null값 대신에 기본값으로도 설정 가능 (defaultValue = "기본값")
	 */

	@GetMapping("/login3")
	public String login3(@RequestParam(value = "userid2", required = false, defaultValue = "hello") String id,
						@RequestParam("passwd") String pw) {
		//사용자 입력 데이터 얻기
		System.out.println(id+" "+pw);
		return "loginForm"; 
	}
	
	@GetMapping("/login2")
	public String login2(@RequestParam("userid") String id, @RequestParam("passwd") String pw) {
		//사용자 입력 데이터 얻기
		System.out.println(id+" "+pw);
		return "loginForm"; 
	}
	
	@GetMapping("/login1")
	public String login1(HttpServletRequest request) { //Spring에서는 사용하지 않는 방법
		//사용자 입력 데이터 얻기
		String userid = request.getParameter("userid2");
		String passwd = request.getParameter("passwd");
		System.out.println(userid+" "+passwd); //홍길동 1234
		return "loginForm"; // /WEB-INF/views/loginForm.jsp 로 포워드 요청된다.
	}
	
	@PostMapping("/login") //요청맵핑값은 같지만 Post로 요청했기 때문에 Get으로 요청한 메서드와 구분가능
	public String login1_1(HttpServletRequest request) { //Spring에서는 사용하지 않는 방법
		//사용자 입력 데이터 얻기
		String userid = request.getParameter("userid");
		String passwd = request.getParameter("passwd");
		System.out.println(userid+" "+passwd); //íê¸¸ë 1234 -- 필터 등록 필수
		return "loginForm"; // /WEB-INF/views/loginForm.jsp 로 포워드 요청된다.
	}

}
