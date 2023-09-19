package com.service;

import java.util.List;

import com.dto.NoticeDTO;
import com.dto.PageDTO;

public interface NoticeService {
	
	public List<NoticeDTO> findAll();
	
	public int noticeAdd(NoticeDTO dto);
	
	public int noticeUpdate (NoticeDTO dto);

	public int noticeDelete (int no);
	
	public NoticeDTO retrieve (int no);
	
	public NoticeDTO readcnt (int no);
	
	public PageDTO list(int curPage);

}
