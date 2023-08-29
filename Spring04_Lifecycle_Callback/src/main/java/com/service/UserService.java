package com.service;

public class UserService {

	public UserService() {
		System.out.println("UserService 생성자");
	}

	//콜백 메서드 생성
	//init-method="xxx" : 초기화 작업 하고 싶을 때 사용
	public void xxx() {
		System.out.println("생성자 호출후 xxx호출");
	}
	
	//destroy-method="yyy"
	public void yyy() {
		System.out.println("yyy호출");
	}
	
}
