package com.service;

import java.util.List;

import com.dto.DeptDTO;

public interface DeptService {

	//목록보기
	public List<DeptDTO> findAll();
	public int deptAdd(DeptDTO dto);
}
