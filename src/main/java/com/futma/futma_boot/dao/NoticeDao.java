package com.futma.futma_boot.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.futma.futma_boot.vo.Notice;

@Repository
public class NoticeDao {

	
	@Autowired
	SqlSession s;
	
	
	public List<Notice> getAll() {
		return s.selectList("notice.findAll");
	}
	
	public Notice getByIdx(int nt_idx) {
		return s.selectOne("notice.findByNtIdx",nt_idx);
	}
	
	
	
}
