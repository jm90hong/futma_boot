package com.futma.futma_boot.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.futma.futma_boot.vo.Stadium;

@Repository
public class StadiumDao {
	
	
	@Autowired
	SqlSession sqlSession;
	
	public Stadium getByIdx(Stadium stadium) {
		return sqlSession.selectOne("stadium.getByIdx",stadium);
	}
	
	public List<Stadium> search(HashMap<String, Object> map){
		return sqlSession.selectList("stadium.search",map);
	}
}
