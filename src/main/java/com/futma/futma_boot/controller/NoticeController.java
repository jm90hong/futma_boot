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
	
	
	@GetMapping("getByIdx")
	public Notice getByIdx(@RequestParam(value="nt_idx") int nt_idx) {
		
		return noticeService.getByIdx(nt_idx);
	}
	
	@GetMapping("all")
	public List<Notice> all() {
		
		return noticeService.getAll();
	}
	
	
	
	
}
