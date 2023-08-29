package com.service;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;

public class UserService implements MessageSourceAware{

	//1.implements MessageSourceAware
	//2.setMessageSource 재정의
	
	MessageSource ctx; 
	
	@Override
	public void setMessageSource(MessageSource messageSource) {
		//3.자동으로 MessageSource변수에 ApplicaitonContext가 주입됨
		this.ctx = messageSource;

	}

	public void info() {
		String mesg = ctx.getMessage("greeting", null, null, Locale.KOREA);
		System.out.println(mesg);
		String mesg2 = ctx.getMessage("greeting", null, null, Locale.ENGLISH);
		System.out.println(mesg2);
	}
	

}
