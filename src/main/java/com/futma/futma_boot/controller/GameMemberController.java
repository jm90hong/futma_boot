package com.futma.futma_boot.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.futma.futma_boot.config.MyHttpHeader;
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
	
	
	
	//game joined by user
	@GetMapping("getCurrentJoinedGameByUserIdxWithLimit")
	public @ResponseBody List<Game> getCurrentJoinedGameByUserIdxWithLimit(
				@RequestParam(value="user_idx") int user_idx,
				@RequestParam(value="cnt") int cnt
				
			){
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("user_idx", user_idx);
		map.put("cnt", cnt);
		
		List<Game> list = gameMemberService.getCurrentJoinedGameByUserIdxWithLimit(map);
		
		return list;
	}
	
	
	
	@GetMapping("getCurrentJoinedGameByUserIdx")
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
	
	
	
	
	
	@GetMapping("getByUserIdx")
	public @ResponseBody List<GameMember> getByUserIdx(
				@RequestParam(value="user_idx") int user_idx
			){
		
		GameMember pm = new GameMember();
		pm.setUser_idx(user_idx);
		
		
		List<GameMember> list = gameMemberService.getByUserIdx(pm);
		
		return list;
	}
	
	@GetMapping("getByGameIdx")
	public @ResponseBody List<GameMember> getByGameIdx(
				@RequestParam(value="game_idx") int game_idx
			){
		
		GameMember pm = new GameMember();
		pm.setGame_idx(game_idx);
		
		List<GameMember> list = gameMemberService.getByGameIdx(pm);
		
		return list;
		
	}
	
	
	@RequestMapping(value="delMember", method=RequestMethod.POST)
	public @ResponseBody String delMember(
				@RequestParam(value="game_mem_idx") int game_mem_idx,
				@RequestParam(value="game_idx") int game_idx
			) {
		
		GameMember gm = new GameMember();
		gm.setGame_mem_idx(game_mem_idx);
		gm.setGame_idx(game_idx);
		
		gameMemberService.delMember(gm);
		
		
		return MyHttpHeader.SUCCESS;
	}
	
	
	
	
	@PostMapping("add")
	public @ResponseBody String add(
				@RequestParam(value="game_idx") long game_idx,
				@RequestParam(value="user_idx") int user_idx,
				@RequestParam(value="name") String name,
				@RequestParam(value="tel") String tel,
				@RequestParam(value="member_cnt") int member_cnt
			) {
		
		
		Game g = new Game();
		g.setGame_idx(game_idx);
		Game game = gameService.getByIdx(g);
		
		
		GameMember pm = new GameMember();
		pm.setGame_idx(game_idx);
		pm.setUser_idx(user_idx);
		pm.setPrice(game.getPrice());
		pm.setU_name(name);
		pm.setTel(tel);
		pm.setMember_cnt(member_cnt);
		
		
		if(game.getPrice()==0) {
			pm.setPay_ny("y");
		}else {
			pm.setPay_ny("n");
		}
		
		
		
		//총 플레이어 수에서 참가하고자 하는 인원수 만큼의 할당량이 있어야 함.
		if(game.getNow_player_cnt() <= game.getPlayer_cnt()-member_cnt) {
			//set now_player_cnt 1
			game.setNow_player_cnt(member_cnt);
			gameMemberService.add(pm,game);
			return MyHttpHeader.SUCCESS;
		}else {
			return "over";
		}
		
	}
	
}
