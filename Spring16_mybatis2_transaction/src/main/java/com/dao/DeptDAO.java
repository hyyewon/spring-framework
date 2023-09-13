package com.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.DeptDTO;

@Repository("deptDAO") //Component-scan 사용위해 마킹
public class DeptDAO {
	
	@Autowired //SqlSessionTemplate & DeptDAO이 빈으로 등록되었기 때문에 주입받아 사용 가능
	SqlSessionTemplate session; //selectList 등의 메서드 사용가능
	
	//목록보기
	public List<DeptDTO> deptList(){
		return session.selectList("DeptMapper.deptList");
	}
	
	public int deptAdd(DeptDTO dto) {
		return session.insert("DeptMapper.deptAdd", dto);
	}
	
	public int deptUpdate(DeptDTO dto) {
		return session.insert("DeptMapper.deptUpdate", dto);
	}
	
	public int deptDelete(int deptno) {
		return session.insert("DeptMapper.deptDelete", deptno);
	}

}
