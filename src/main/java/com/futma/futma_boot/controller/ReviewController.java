package com.futma.futma_boot.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.futma.futma_boot.config.MyHttpHeader;
import com.futma.futma_boot.dao.ReviewDao;
import com.futma.futma_boot.service.ReviewService;
import com.futma.futma_boot.vo.Review;

@RestController
@RequestMapping(value="rv")
public class ReviewController {
	
	
	@Autowired
	ReviewService reviewService;
	
	
	
	@PostMapping("save")
	public int save(
			
				@RequestParam(value="wr_uidx") int wr_user_idx,
				@RequestParam(value="rv_uidx") int rv_user_idx,
				@RequestParam(value="content") String content,
				@RequestParam(value="star") int star
			) {
		
		Review rv = new Review();
		rv.setWr_user_idx(wr_user_idx);
		rv.setRv_user_idx(rv_user_idx);
		rv.setContent(content);
		rv.setStar(star);
		
		reviewService.save(rv);
		
		
		
		return rv.getRv_idx();
	}
	
	
	
	
	@PostMapping("updateReply")
	public String updateReply(
				@RequestParam(value="rv_idx") int rv_idx,
				@RequestParam(value="reply") String reply
			) {
		
		
		Review rv = new Review();
		rv.setRv_idx(rv_idx);
		rv.setReply(reply);;
		
		reviewService.updateReply(rv);
		
		
		return "ok";
		
	}	
	
	
	@GetMapping("findByRvUserIdx")
	public List<Review> findByRvUserIdx(
				@RequestParam(value="user_idx") int user_idx,
				@RequestParam(value="start") int start,
				@RequestParam(value="cnt") int cnt
			) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("user_idx", user_idx);		
		map.put("start", start);		
		map.put("cnt", cnt);
		
		return reviewService.findByRvUserIdx(map);
	}
	
	
	
	
	@GetMapping("findByWrUserIdx")
	public List<Review> findByWrUserIdx(
				@RequestParam(value="user_idx") int user_idx,
				@RequestParam(value="start") int start,
				@RequestParam(value="cnt") int cnt
			) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("user_idx", user_idx);		
		map.put("start", start);		
		map.put("cnt", cnt);
		
		
		return reviewService.findByWrUserIdx(map);
	}
	
	
	
}
