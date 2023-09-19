package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dto.NoticeDTO;
import com.dto.PageDTO;
import com.service.NoticeService;

@Controller
public class NoticeController {
	
	@Autowired
	NoticeService service;
	
	
//	@GetMapping("/list")
//	public String findAll(Model m) {
//		//모델
//		List<NoticeDTO> list = service.findAll();
//		m.addAttribute("list", list);
//		//뷰
//		return "list";  
//	}
	
	@GetMapping("/list")
	public String paging(@RequestParam(defaultValue = "1") String curPage, Model m) {
		if(curPage==null) {
			curPage="1";
		}
		PageDTO pageDTO=service.list(Integer.parseInt(curPage));
		m.addAttribute("pageDTO", pageDTO);
		
		return "list";
		
	}
	
		//부서등록화면
		@GetMapping("/write")
		public String noticeAddForm() {
			return "writeForm";
		}
		
		//삽입하기
		@PostMapping("/noticeAdd")
		public String noticeAdd(NoticeDTO dto) {
			int n = service.noticeAdd(dto);
			return "redirect:list";
		}
		
		//삭제하기
		@GetMapping("/delete")
		public String noticeDelete(@RequestParam int no) {
			int n = service.noticeDelete(no);
			return "redirect:list";
		}
		
		//삭제화면
		@GetMapping("/noticeDeleteForm")
		public String noticeDeleteForm() {
			return "delete";
		}
		
		
		//수정하기
		@PostMapping("/update")
		public String noticeUpdate(NoticeDTO dto) {
			int n = service.noticeUpdate(dto);
			return "redirect:list";
		}
		
		//글자세히보기
		@GetMapping("/retrieve")
		public String retrieve(@RequestParam("no") int no, Model m) {
			NoticeDTO dto = service.retrieve(no);
			NoticeDTO dto2 = service.readcnt(no);
			m.addAttribute("retrieve",dto);
			return "retrieve";
		}
		
		
}
