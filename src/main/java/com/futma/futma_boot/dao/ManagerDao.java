package com.futma.futma_boot.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.futma.futma_boot.vo.Manager;

@Repository
public class ManagerDao{
	@Autowired
	SqlSession sqlSession;
	
	public int add(Manager manager) {	
		return sqlSession.insert("manager.add",manager);
	}
	
}
