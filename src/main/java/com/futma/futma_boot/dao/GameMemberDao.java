package com.futma.futma_boot.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.futma.futma_boot.vo.Game;
import com.futma.futma_boot.vo.GameMember;



@Repository
public class GameMemberDao {
	
	
	@Autowired
	SqlSession sqlSession;
	
	
	public List<Game> getCurrentJoinedGameByUserIdx(HashMap<String, Object> map){
		return sqlSession.selectList("game_member.getCurrentJoinedGameByUserIdx", map);
	}
	
	public List<GameMember> getByUserIdx(GameMember gm) {
		return sqlSession.selectList("game_member.getByUserIdx", gm);
	}
	
	
	public int add(GameMember gm) {
		return sqlSession.insert("game_member.add",gm);
	}
	
	
	public List<GameMember> getByPlayIdx(GameMember gm){
		return sqlSession.selectList("game_member.getByGameIdx",gm);
	}
	
}
