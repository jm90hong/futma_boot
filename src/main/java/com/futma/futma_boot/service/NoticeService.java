package com.futma.futma_boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.futma.futma_boot.dao.NoticeDao;
import com.futma.futma_boot.vo.Notice;

@Service
public class NoticeService {

	
	@Autowired
	NoticeDao noticeDao;
	
	
	
	public int updateViewCnt(Notice notice) {
		return noticeDao.updateViewCnt(notice);
	}
	
	public List<Notice> getAll() {
		return noticeDao.getAll();
	}
	
	public Notice getByIdx(int nt_idx) {
		return noticeDao.getByIdx(nt_idx);
	}
	
	
}
