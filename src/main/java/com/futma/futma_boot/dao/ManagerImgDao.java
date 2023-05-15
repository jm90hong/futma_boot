package com.futma.futma_boot.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.futma.futma_boot.vo.ManagerImg;


@Repository
public class ManagerImgDao{
	@Autowired
	SqlSession sqlSession;
	
	public int delByMngIdx(ManagerImg mi) {
		return sqlSession.delete("manager_img.delByMngIdx",mi);
	}
	
	public int add(ManagerImg mi) {
		return sqlSession.insert("manager_img.add",mi);
	}
	
	public List<ManagerImg> fidnByMngIdx(int mng_idx){
		return sqlSession.selectList("manager_img.fidnByMngIdx",mng_idx);
	}
}
