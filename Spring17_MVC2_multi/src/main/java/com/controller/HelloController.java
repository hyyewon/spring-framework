package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	//요청URL : http://localhost:8090/app/xxx
	@RequestMapping("/xxx")
	public String aaa() {
		System.out.println("HelloController.aaa");
		//forward방식 (url변경 안됨)
		return "/WEB-INF/views/aaa.jsp";
	}
	
}
