package com.futma.futma_boot.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.futma.futma_boot.vo.Game;


@Repository
public class GameDao{

	@Autowired
	SqlSession sqlSession;
	
	
	
	public int updateNowPlayerCnt(Game game) {
		return sqlSession.update("game.updateNowPlayerCnt",game);
	}
	
	public List<Game> getCurrentGameByUserIdxWithLimit(HashMap<String, Object> map){
		return sqlSession.selectList("game.getCurrentGameByUserIdxWithLimit",map);
	}
	
	public List<Game> getCurrentGameByUserIdx(HashMap<String, Object> map){
		return sqlSession.selectList("game.getCurrentGameByUserIdx",map);
	}
	
	public List<Game> getByUserIdx(Game game) {
		return sqlSession.selectList("game.getByUserIdx", game);
	}
	
	public Game getByIdx(Game game) {
		return sqlSession.selectOne("game.getByIdx", game);
	}
	
	public List<Game> search(Map<String, Object> map){
		return sqlSession.selectList("game.search", map);
	}
	
	
	public int add(Game game) {
		return sqlSession.insert("game.add",game);
	}
	
}
