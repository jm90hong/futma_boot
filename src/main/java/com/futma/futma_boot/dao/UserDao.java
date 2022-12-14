package com.futma.futma_boot.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.futma.futma_boot.vo.User;


@Repository
public class UserDao {
	
	
	@Autowired
	SqlSession sqlSession;
	
	public int updateMngReqState(User user) {
		return sqlSession.update("user.updateMngReqState",user);
	}
	
	
	public int insert (User user) {
		return sqlSession.insert("user.insert",user);
	}
	
	public User getUserByIdAndLoginType (User user) {
		return sqlSession.selectOne("user.getUserByIdAndLoginType",user);
	}
	
	
	public User getUserByNick(User user) {
		return sqlSession.selectOne("user.getUserByNick",user);
	}
	
	public int updateUserNick(User user) {
		return sqlSession.update("user.updateUserNick",user);
	}
	
	
	public int updateImageUrl(User user) {
		return sqlSession.update("user.updateImageUrl",user);
	}
	
}
