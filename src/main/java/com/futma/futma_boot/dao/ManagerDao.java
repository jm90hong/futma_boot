package com.futma.futma_boot.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.futma.futma_boot.vo.Manager;

@Repository
public class ManagerDao{
	@Autowired
	SqlSession sqlSession;
	
	public Manager findByUserIdx(long user_idx) {
		return  sqlSession.selectOne("manager.findByUserIdx",user_idx);
	}
	
	
	public int add(Manager manager) {	
		return sqlSession.insert("manager.add",manager);
	}
	
	public int update(Manager manager) {	
		return sqlSession.update("manager.update",manager);
	}
	
}
