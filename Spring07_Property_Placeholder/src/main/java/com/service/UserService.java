package com.service;

public class UserService {
	
	//jdbc.properties 주입받는 클래스
	String driver;
	String url;
	String userid;
	String passwd;
	
	//setter로 주입
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	//4가지 정보를 출력받기 위해 toString메서드 생성
	@Override
	public String toString() {
		return "UserService [driver=" + driver + ", url=" + url + ", userid=" + userid + ", passwd=" + passwd + "]";
	}
	
	

}
