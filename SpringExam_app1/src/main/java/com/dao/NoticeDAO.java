package com.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.NoticeDTO;
import com.dto.PageDTO;

@Repository("dao")
public class NoticeDAO {
	
	@Autowired
	SqlSessionTemplate session;
	
	public List<NoticeDTO> findAll(){
		return session.selectList("NoticeMapper.findAll");
	}
	
	public int noticeAdd(NoticeDTO dto) {
		return session.insert("NoticeMapper.noticeAdd", dto);
	}
	
	public int noticeUpdate (NoticeDTO dto) {
		return session.update("NoticeMapper.noticeUpdate",dto);
	}

	public int noticeDelete (int no) {
		return session.delete("NoticeMapper.noticeDelete",no);
	}
	
	public NoticeDTO retrieve (int no) {
		return session.selectOne("NoticeMapper.retrieve", no);
	}
	
	public NoticeDTO readcnt (int no) {
		return session.selectOne("NoticeMapper.readcnt", no);
	}
	
	
	public PageDTO list(int curPage) {
		PageDTO pageDTO = new PageDTO();
		int offset=(curPage-1)*pageDTO.getPerPage();
		int limit=pageDTO.getPerPage();
		List<NoticeDTO> list = session.selectList("NoticeMapper.findAll",null,
				new RowBounds(offset, limit));
		
		pageDTO.setList(list);
		pageDTO.setCurPage(curPage);
		int totalCount = session.selectOne("NoticeMapper.totalCount");
		pageDTO.setTotalCount(totalCount);
		
		return pageDTO;
		
	}
	
	
	

}
