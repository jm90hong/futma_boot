package com.futma.futma_boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.futma.futma_boot.service.ManagerImgService;
import com.futma.futma_boot.vo.ManagerImg;

@RestController
@RequestMapping(value="mng_img")
public class ManagerImgController {

	
	@Autowired
	ManagerImgService managerImgService;
	
	
	
	@GetMapping("fidnByMngIdx")
	public List<ManagerImg> fidnByMngIdx(
				@RequestParam(value="mng_idx") int mng_idx
			) {
		
		return managerImgService.fidnByMngIdx(mng_idx);
	}
	
	
}
