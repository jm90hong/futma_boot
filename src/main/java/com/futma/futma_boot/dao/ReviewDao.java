package com.futma.futma_boot.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.futma.futma_boot.vo.Review;

@Repository
public class ReviewDao {
	
	
	@Autowired
	SqlSession sqlSession;
	
	
	public int save(Review rv) {
		return sqlSession.insert("review.save",rv);
	}
	
	
	public List<Review> findByRvUserIdx(HashMap<String, Object> map){
		return sqlSession.selectList("review.findByRvUserIdx",map);
	}
	
	public List<Review> findByWrUserIdx(HashMap<String, Object> map){
		return sqlSession.selectList("review.findByWrUserIdx",map);
	}
	
}
