package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WorldController {

	//요청URL : http://localhost:8090/app/yyy
	@RequestMapping(value = "/yyy")
	public String aaa() { //class가 다르므로 메서드명은 같아도 무관
		System.out.println("WorldController.aaa");
		//forward방식 (url변경 안됨)
		return "/WEB-INF/views/aaa.jsp";
	}
	
}
