package com.futma.futma_boot.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.futma.futma_boot.vo.UserLike;

@Repository
public class UserLikeDao {
	
	
	@Autowired
	SqlSession sqlSession;
	
	
	public int save(UserLike o) {
		return sqlSession.insert("user_like.save",o);
	}
	
	public List<UserLike> findByFanUserIdx(int fan_user_idx){
		return sqlSession.selectList("user_like.findByFanUserIdx",fan_user_idx);
	}
	
	public int delete(int u_like_idx) {
		return sqlSession.delete("user_like.delete",u_like_idx);
	}
}
