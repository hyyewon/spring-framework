package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dao.UserDAO;

public class UserService {
	
	//1.변수 이용하여 주입 (권장 방법)
	@Autowired
	UserDAO dao;
	
	
//	//기본생성자 안만들면 <bean id="service" class="com.service.UserService" /> 코드에서 에러발생
//	public UserService() {
//		// TODO Auto-generated constructor stub
//	}
//
//	//2.생성자 이용하여 주입
//	public UserService(UserDAO dao) {
//		System.out.println("UserService(UserDAO dao)");
//		this.dao = dao;
//	}
//
//	//3.setter메서드 이용하여 주입
//	public void setDao(UserDAO dao) {
//		System.out.println("setDao(UserDAO dao)");
//		this.dao = dao;
//	}
	
	
	//dao를 주입받았으면 호출할 수 있는 메서드
	public List<String> list(){
		return dao.list();
	}	

}
