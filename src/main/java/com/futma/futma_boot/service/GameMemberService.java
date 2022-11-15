package com.futma.futma_boot.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.futma.futma_boot.dao.GameDao;
import com.futma.futma_boot.dao.GameMemberDao;
import com.futma.futma_boot.vo.Game;
import com.futma.futma_boot.vo.GameMember;

@Service
public class GameMemberService {
	@Autowired
	GameMemberDao gameMemberDao;
	
	
	@Autowired
	GameDao gameDao;
	
	
	public List<Game> getCurrentJoinedGameByUserIdx(HashMap<String, Object> map){
		return gameMemberDao.getCurrentJoinedGameByUserIdx(map);
	}
	
	public List<GameMember> getByUserIdx(GameMember gm) {
		return gameMemberDao.getByUserIdx(gm);
	}
	
	
	@Transactional
	public int add(GameMember gm, Game g) {
		gameDao.updateNowPlayerCnt(g);
		return gameMemberDao.add(gm);
	}
	
	
	public List<GameMember> getByPlayIdx(GameMember gm){
		return gameMemberDao.getByPlayIdx(gm);
	}
	
}
