package com.futma.futma_boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.futma.futma_boot.dao.UserLikeDao;
import com.futma.futma_boot.vo.UserLike;

@Service
public class UserLikeService {

	
	@Autowired
	UserLikeDao userLikeDao;
	
	
	public int save(UserLike o) {
		return userLikeDao.save(o);
	}
	
	public List<UserLike> findByFanUserIdx(int fan_user_idx) {
		return userLikeDao.findByFanUserIdx(fan_user_idx);
	}
	
	
	public int delete(int u_like_idx) {
		return  userLikeDao.delete(u_like_idx);
	}
	
}
