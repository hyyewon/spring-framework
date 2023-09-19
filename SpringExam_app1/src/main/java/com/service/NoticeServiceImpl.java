package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.NoticeDAO;
import com.dto.NoticeDTO;
import com.dto.PageDTO;

@Service("service")
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	NoticeDAO dao;

	@Override
	public List<NoticeDTO> findAll() {
		return dao.findAll();
	}

	@Override
	public int noticeAdd(NoticeDTO dto) {
		return dao.noticeAdd(dto);
	}

	@Override
	public int noticeUpdate(NoticeDTO dto) {
		return dao.noticeUpdate(dto);
	}

	@Override
	public int noticeDelete(int no) {
		return dao.noticeDelete(no);
	}

	@Override
	public NoticeDTO retrieve(int no) {
		return dao.retrieve(no);
	}

	@Override
	public NoticeDTO readcnt(int no) {
		return dao.readcnt(no);
	}

	@Override
	public PageDTO list(int curPage) {
		return dao.list(curPage);
	}

}
