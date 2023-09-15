package com.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dto.LoginDTO;

@Controller // 이전 서블릿에서 했던 요청처리와 응답처리를 구현
public class TestController {

	// 1.리턴타입 : String
	// 뷰정보O, 모델정보 X
	@RequestMapping("/aaa")
	public String fun() {
		System.out.println("aaa 요청");
		return "hello";
	}

	// 2.리턴타입 : String / 파라미터 : Model, Map, @ModelAttribute(key)LoginDTO
	// 뷰정보O, 모델정보 O
	@RequestMapping("/bbb")
	public String fun2(Model m) {
		m.addAttribute("userid", "홍길동");
		System.out.println("bbb 요청");
		return "hello2";
	}

	// 3.리턴타입 : ModelAndView
	// 뷰정보O, 모델정보 O
	@RequestMapping("/ccc")
	public ModelAndView fun3() {
		System.out.println("ccc 요청");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("hello2"); // view정보
		mav.addObject("userid", "이순신"); // 모델정보
		return mav;
	}

	// 4.리턴타입 : LoginDTO(모델)
	// 뷰정보X, 모델정보 O
	// 뷰정보는 스프링이 유추해서 찾음 (요청맵핑값으로 view처리, ddd.jsp)
	// 404 오류 : [/WEB-INF/views/ddd.jsp]을(를) 찾을 수 없습니다.
	@RequestMapping("/ddd")
	public @ModelAttribute("xyz") LoginDTO fun4() { // ModelAttribute를 주지 않으면 key값은 클래스이름(loginDTO)
		System.out.println("ddd 요청");
		LoginDTO dto = new LoginDTO("hong", "1234");
		return dto;
	}

	// 5.리턴타입 : ArrayList(모델)
	// 뷰정보X, 모델정보 O
	// 뷰정보는 스프링이 유추해서 찾음 (요청맵핑값으로 view처리, eee.jsp)
	@RequestMapping("/eee")
	public @ModelAttribute("kkk") ArrayList<LoginDTO> fun5() { // ModelAttribute를 주지 않으면 key값은 클래스이름(ArrayList)
		System.out.println("eee 요청");
		ArrayList<LoginDTO> list = new ArrayList<LoginDTO>();
		list.add(new LoginDTO("hong1", "1234"));
		list.add(new LoginDTO("hong2", "1234"));
		return list;
	}

	// 6.리턴타입 : void
	// 뷰정보X, 모델정보 X
	// 뷰정보는 스프링이 유추해서 찾음 (요청맵핑값으로 view처리, fff.jsp)
	@RequestMapping("/fff")
	public void fun6() {
		System.out.println("fff 요청");
	}

}
