package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // 이전 서블릿에서 했던 요청처리와 응답처리를 구현
public class TestController {

	// redirect 요청
	@RequestMapping("/aaa")
	public String aaa(Model m) {
		System.out.println("aaa 호출");
		m.addAttribute("userid", "hong"); //request scope는 응답하면서 제거됨(요청하는 순간 이미 브라우저에 응답한 것이므로 데이터 사라짐)
		//서블릿 : response.sendRedirect("xxx");
		return "redirect:xxx"; // http://localhost:8090/app/xxx
	}

	// forward 요청
	@RequestMapping("/bbb")
	public String bbb(Model m) {
		System.out.println("bbb 호출");
		m.addAttribute("userid", "Lee");
		//서블릿 : request.getRequestDispatcher("xxx").forward(request,response)
		return "forward:xxx"; // http://localhost:8090/app/bbb
	}

	@RequestMapping("/xxx")
	public String main() {
		System.out.println("main 호출");
		return "main";
	}

}
