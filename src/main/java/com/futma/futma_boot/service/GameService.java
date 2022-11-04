package com.futma.futma_boot.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.futma.futma_boot.dao.GameDao;
import com.futma.futma_boot.vo.Game;

@Service
public class GameService {
	
	
	@Autowired
	GameDao gameDao;
	

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
	
	
	public int add(Game game) {
		return gameDao.add(game);
	}
	
}
