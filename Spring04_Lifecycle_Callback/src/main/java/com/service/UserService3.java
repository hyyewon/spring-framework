package com.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class UserService3 {

	public UserService3() {
		System.out.println("UserService3 생성자");
	}

	@PostConstruct
	public void xxx() {
		System.out.println("생성자 후 @PostConstruct.xxx");
	}
	
	@PreDestroy
	public void yyy() {
		System.out.println("@PreDestroy.yyy");
	}

	
	
}
