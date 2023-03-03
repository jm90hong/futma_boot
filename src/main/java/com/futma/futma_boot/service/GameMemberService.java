package com.futma.futma_boot.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.futma.futma_boot.dao.GameDao;
import com.futma.futma_boot.dao.GameMemberDao;
import com.futma.futma_boot.dao.UserDao;
import com.futma.futma_boot.vo.Game;
import com.futma.futma_boot.vo.GameMember;
import com.futma.futma_boot.vo.User;

@Service
public class GameMemberService {
	@Autowired
	GameMemberDao gameMemberDao;
	
	
	@Autowired
	GameDao gameDao;
	
	@Autowired
	UserDao userDao;
	
	
	
	
	public List<Game> getCurrentJoinedGameByUserIdxWithLimit(HashMap<String, Object> map){
		return gameMemberDao.getCurrentJoinedGameByUserIdxWithLimit(map);
	}
	
	public List<Game> getCurrentJoinedGameByUserIdx(HashMap<String, Object> map){
		return gameMemberDao.getCurrentJoinedGameByUserIdx(map);
	}
	
	public List<GameMember> getByUserIdx(GameMember gm) {
		return gameMemberDao.getByUserIdx(gm);
	}
	
	
	@Transactional
	public int add(GameMember gm, Game g) {
		gameDao.updateNowPlayerCnt(g);
		
		//increase join cnt +1
		User user = new User();
		user.setUser_idx(gm.getUser_idx());
		user.setJoin_cnt(1);
		userDao.addJoinCnt(user);
		
		return gameMemberDao.add(gm);
	}
	
	@Transactional
	public int delMember(GameMember gm) {
		gameMemberDao.delMember(gm);
		
		Game game = new Game();
		game.setGame_idx(gm.getGame_idx());
		game.setNow_player_cnt(-1);
		
		//decrease join cnt -1
		User user = new User();
		user.setUser_idx(gm.getUser_idx());
		user.setJoin_cnt(-1);
		userDao.addJoinCnt(user);
		
		return gameDao.updateNowPlayerCnt(game);
	}
	
	
	
	public List<GameMember> getByGameIdx(GameMember gm){
		return gameMemberDao.getByGameIdx(gm);
	}
	
	
	
}
