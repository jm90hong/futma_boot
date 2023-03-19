package com.futma.futma_boot.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.futma.futma_boot.dao.GameDao;
import com.futma.futma_boot.dao.UserDao;
import com.futma.futma_boot.vo.Game;
import com.futma.futma_boot.vo.User;

@Service
public class GameService {
	
	
	@Autowired
	GameDao gameDao;
	
	@Autowired
	UserDao userDao;
	
	
	
	public List<Game> getCurrentGameByUserIdxWithLimit(HashMap<String, Object> map) {
		return gameDao.getCurrentGameByUserIdxWithLimit(map);
	}
	
	
	public List<Game> getCurrentGameByUserIdx(HashMap<String, Object> map) {
		return gameDao.getCurrentGameByUserIdx(map);
	}
	
	
	public List<Game> getByUserIdx(Game game) {
		return gameDao.getByUserIdx(game);
	}
	
	
	public Game getByIdx(Game game) {
		return gameDao.getByIdx(game);
	}
	
	public List<Game> search(Map<String, Object> map){
		return gameDao.search(map);
	}
	
	
	@Transactional
	public int add(Game game) {
		
		User user = new User();
		user.setUser_idx(game.getUser_idx());
		user.setMake_cnt(1);
		userDao.addMakeCnt(user);
		
		return gameDao.add(game);
	}
	
}
