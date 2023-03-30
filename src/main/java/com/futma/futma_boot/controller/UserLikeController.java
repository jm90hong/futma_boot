package com.futma.futma_boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.futma.futma_boot.config.MyHttpHeader;
import com.futma.futma_boot.service.UserLikeService;
import com.futma.futma_boot.vo.UserLike;

@RestController
@RequestMapping(value="user_like")
public class UserLikeController {
	
	
	@Autowired
	UserLikeService userLikeService;
	
	
	
	
	
	
	
	
	@PostMapping("del")
	public String del(
				@RequestParam(value="u_like_idx") int u_like_idx
			) {
		userLikeService.delete(u_like_idx);
		return MyHttpHeader.SUCCESS;
	}
	
	
	
	
	
	
	@PostMapping("save")
	public long save(
				@RequestParam(value="s_uidx") int star_user_idx,
				@RequestParam(value="f_uidx") int fan_user_idx
			) {

		
		UserLike userLike = new UserLike();
		userLike.setStar_user_idx(star_user_idx);
		userLike.setFan_user_idx(fan_user_idx);
		
		userLikeService.save(userLike);
		
		return userLike.getU_like_idx();
	}

	
	
	
	@GetMapping("findByFan")
	public List<UserLike> findByFan(
				@RequestParam(value="f_uidx") int fan_user_idx
			) {
		
		return userLikeService.findByFanUserIdx(fan_user_idx);
	}
	
	
}
