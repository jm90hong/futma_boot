package com.futma.futma_boot.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.futma.futma_boot.dao.ReviewDao;
import com.futma.futma_boot.dao.UserDao;
import com.futma.futma_boot.vo.Review;
import com.futma.futma_boot.vo.User;

@Service
public class ReviewService {
	
	@Autowired
	ReviewDao reviewDao;
	
	@Autowired
	UserDao userDao;
	
	@Transactional
	public int save(Review rv) {
		
		User user = new User();
		user.setUser_idx(rv.getRv_user_idx());
		User reviewedUser = userDao.getUserByIdx(user);
		
		
		int reviewCnt = reviewedUser.getReview_cnt();
		float totalStar = reviewedUser.getStar_rank();
		int oneStar = rv.getStar();
		
		totalStar = ((totalStar*reviewCnt)+oneStar)/(reviewCnt+1);
		
		
		User newUser = new User();
		float value = (float) ((float) Math.round(totalStar*10)/10.0);
		newUser.setStar_rank(value); 
		newUser.setUser_idx(reviewedUser.getUser_idx());
		
		//리뷰 추가
		userDao.updateWithReview_add(newUser);
		
		return reviewDao.save(rv);
	}
	
	public List<Review> findByRvUserIdx(HashMap<String, Object> map){
		return reviewDao.findByRvUserIdx(map);
	}
	
	public List<Review> findByWrUserIdx(HashMap<String, Object> map){
		return reviewDao.findByWrUserIdx(map);
	}
	
}
