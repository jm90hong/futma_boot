package com.futma.futma_boot.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.futma.futma_boot.dao.GameDao;
import com.futma.futma_boot.dao.GameMemberDao;
import com.futma.futma_boot.service.GameMemberService;
import com.futma.futma_boot.service.GameService;
import com.futma.futma_boot.vo.Game;
import com.futma.futma_boot.vo.GameMember;

@Controller
@RequestMapping(value="game_member")
public class GameMemberController {

	
	

	@Autowired
	private GameService gameService;
	
	

	@Autowired
	private GameMemberService gameMemberService;
	
	
	
	
	
	@RequestMapping(value="getCurrentJoinedGameByUserIdx",method= {RequestMethod.GET})
	public @ResponseBody List<Game> getCurrentJoinedGameByUserIdx(
				@RequestParam(value="user_idx") int user_idx,
				@RequestParam(value="ntm") long nowTimeMill
			){
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("user_idx", user_idx);
		map.put("now_time_mill", nowTimeMill);
		
		List<Game> list = gameMemberService.getCurrentJoinedGameByUserIdx(map);
		
		return list;
	}
	
	
	@RequestMapping(value="getByUserIdx",method= {RequestMethod.GET})
	public @ResponseBody List<GameMember> getByUserIdx(
				@RequestParam(value="user_idx") int user_idx
			){
		
		GameMember pm = new GameMember();
		pm.setUser_idx(user_idx);
		
		
		List<GameMember> list = gameMemberService.getByUserIdx(pm);
		
		return list;
	}
	
	
	@RequestMapping(value="getByGameIdx", method=RequestMethod.GET)
	public @ResponseBody List<GameMember> getByGameIdx(
				@RequestParam(value="game_idx") int game_idx
			){
		
		GameMember pm = new GameMember();
		pm.setGame_idx(game_idx);
		
		List<GameMember> list = gameMemberService.getByPlayIdx(pm);
		
		return list;
		
	}
	
	
	
	
	@RequestMapping(value="add", method=RequestMethod.POST)
	public @ResponseBody String add(
				@RequestParam(value="game_idx") long game_idx,
				@RequestParam(value="user_idx") int user_idx
			) {
		
		
		Game g = new Game();
		g.setGame_idx(game_idx);
		Game game = gameService.getByIdx(g);
		
		
		GameMember pm = new GameMember();
		pm.setGame_idx(game_idx);
		pm.setUser_idx(user_idx);
		pm.setPrice(game.getPrice());
		if(game.getPrice()==0) {
			pm.setPay_ny("y");
		}else {
			pm.setPay_ny("n");
		}
		
	
		
		if(game.getNow_player_cnt() < game.getPlayer_cnt()) {
			//set now_player_cnt 1
			game.setNow_player_cnt(1);
			gameMemberService.add(pm,game);
			return "ok";
		}else {
			return "over";
		}
		
		
		
		
		
	}
	
}
