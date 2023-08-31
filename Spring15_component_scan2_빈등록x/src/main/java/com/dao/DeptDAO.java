package com.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component
@Repository
public class DeptDAO {
	
	public DeptDAO () {
		System.out.println("DeptDAO 생성자");
	}
	
	public List<String> list(){
		return Arrays.asList("홍길동","이순신");
	}

}
