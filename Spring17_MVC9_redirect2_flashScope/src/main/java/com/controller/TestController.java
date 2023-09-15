package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller // 이전 서블릿에서 했던 요청처리와 응답처리를 구현
public class TestController {

	// 이전 redirect 요청
	@RequestMapping("/aaa")
	public String aaa(Model m) {
		System.out.println("aaa 호출");
		m.addAttribute("userid", "hong");
		return "redirect:xxx";
	}

	// flash scope redirect 요청
	@RequestMapping("/bbb")
	public String bbb(RedirectAttributes m) {
		System.out.println("bbb 호출");
		m.addFlashAttribute("userid", "Lee");
		return "redirect:xxx";
	}

	@RequestMapping("/xxx")
	public String main() {
		System.out.println("main 호출");
		return "main";
	}

}
