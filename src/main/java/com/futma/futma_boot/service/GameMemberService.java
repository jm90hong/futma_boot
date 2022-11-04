package com.futma.futma_boot.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.futma.futma_boot.dao.GameMemberDao;
import com.futma.futma_boot.vo.Game;
import com.futma.futma_boot.vo.GameMember;

@Service
public class GameMemberService {
	@Autowired
	GameMemberDao gameMemberDao;
	
	
	
	public List<Game> getCurrentJoinedGameByUserIdx(HashMap<String, Object> map){
		return gameMemberDao.getCurrentJoinedGameByUserIdx(map);
	}
	
	public List<GameMember> getByUserIdx(GameMember gm) {
		return gameMemberDao.getByUserIdx(gm);
	}
	
	
	public int add(GameMember gm) {
		return gameMemberDao.add(gm);
	}
	
	
	public List<GameMember> getByPlayIdx(GameMember gm){
		return gameMemberDao.getByPlayIdx(gm);
	}
	
}
