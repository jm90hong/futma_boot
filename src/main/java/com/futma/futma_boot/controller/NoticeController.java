package com.futma.futma_boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.futma.futma_boot.service.NoticeService;
import com.futma.futma_boot.vo.Notice;

@RestController
@RequestMapping(value="notice")
public class NoticeController {
	
	
	@Autowired
	NoticeService noticeService;
	
	
	//공지 상세 조회
	@GetMapping("getByIdx")
	public Notice getByIdx(@RequestParam(value="nt_idx") int nt_idx) {
		
		return noticeService.getByIdx(nt_idx);
	}
	
	
	//전체 조회
	@GetMapping("all")
	public List<Notice> all() {
		
		return noticeService.getAll();
	}
	
	//조회수 업데이트
	@GetMapping("updateViewCnt")
	public String updateViewCnt(
				@RequestParam(value="nt_idx") int nt_idx,
				@RequestParam(value="cnt") int view_cnt
			) {
		
		Notice notice =  new Notice();
		notice.setNt_idx(nt_idx);
		notice.setView_cnt(view_cnt);
		
		noticeService.updateViewCnt(notice);
		
		return "ok";
	}
	
	
	
}
