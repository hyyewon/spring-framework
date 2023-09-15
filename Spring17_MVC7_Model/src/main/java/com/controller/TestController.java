package com.controller;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dto.LoginDTO;

@Controller // 이전 서블릿에서 했던 요청처리와 응답처리를 구현
public class TestController {

	// 1.HttpServletRequest . setAttribute
	@RequestMapping("/xxx")
	public String home(HttpServletRequest request) {
		// 모델 저장
		request.setAttribute("userid", "홍길동");
		return "hello"; // forward로 가기 때문에 request scope에 저장한 정보를 jsp에서 얻어올 수 있음
	}

	// 2.Model . addAttribute
	@RequestMapping("/yyy")
	public String yyy(Model m) { // Model m = new Model();
		// 모델 저장
		m.addAttribute("userid", "이순신");
		return "hello"; // forward로 가기 때문에 request scope에 저장한 정보를 jsp에서 얻어올 수 있음
	}

	// 3.Map . put
	@RequestMapping("/zzz")
	public String zzz(Map<String, String> map) { // Map<String, String> m = new HashMap<>();
		// 모델 저장
		map.put("userid", "강감찬");
		return "hello"; // forward로 가기 때문에 request scope에 저장한 정보를 jsp에서 얻어올 수 있음
	}

	// 4.LoginDTO . set메서드 //명시적 key값 지정 방법 : @ModelAttribute("key값")
	@RequestMapping("/aaa")
	public String aaa(@ModelAttribute("login") LoginDTO dto) { 
		// 모델 저장
		dto.setUserid("hong");
		dto.setPasswd("1234");
		return "hello2"; // forward로 가기 때문에 request scope에 저장한 정보를 jsp에서 얻어올 수 있음
	}
	
	// 5.ArrayList . add메서드 //명시적 key값 지정 방법 : @ModelAttribute("key값")
		@RequestMapping("/bbb")
		public String bbb(@ModelAttribute("list") ArrayList<LoginDTO> list) { 
			// 모델 저장
			list.add(new LoginDTO("aa","123"));
			list.add(new LoginDTO("bb","999"));
			return "hello3"; // forward로 가기 때문에 request scope에 저장한 정보를 jsp에서 얻어올 수 있음
		}
		
	//6.ModelAndView . setViewName(view정보) / addObject(model정보)
		@RequestMapping("/ccc")
		public ModelAndView ccc() {
			ModelAndView mav = new ModelAndView(); //리턴해줄 객체 생성
			//뷰 정보(논리적 이름)
			mav.setViewName("hello");
			//모델 정보
			mav.addObject("userid","안중근");
			return mav;
		}

}
