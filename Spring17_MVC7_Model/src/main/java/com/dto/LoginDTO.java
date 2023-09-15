package com.dto;


public class LoginDTO {

 	//name값(요청 파라미터명)과 저장할 변수명이 동일하면, 자동 저장
	
	String userid;
	String passwd;
	
	
	public LoginDTO() {}
	public LoginDTO(String userid, String passwd) {
		this.userid = userid;
		this.passwd = passwd;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	@Override
	public String toString() {
		return "LoginDTO [userid=" + userid + ", passwd=" + passwd + "]";
	}
	
	
	
}
