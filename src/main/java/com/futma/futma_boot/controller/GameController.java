package com.futma.futma_boot.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.futma.futma_boot.config.MyHttpHeader;
import com.futma.futma_boot.service.GameService;
import com.futma.futma_boot.service.ManagerService;
import com.futma.futma_boot.vo.Game;


@RestController
@RequestMapping("game")
public class GameController {
	
	
	
	@Autowired
	private GameService gameService;
	
	@Autowired
	private ManagerService managerService;
	
	
	
	
	@GetMapping("updatePlayerCnt")
	public String updatePlayerCnt(
				@RequestParam(value="game_idx") int game_idx,
				@RequestParam(value="player_cnt") int player_cnt
			) {
		
		
		Game game = new Game();
		game.setGame_idx(game_idx);
		game.setPlayer_cnt(player_cnt);

		Game result = gameService.getByIdx(game);
		if(result.getNow_player_cnt()<=player_cnt) {
			gameService.updatePlayerCnt(game);
			return "ok";
		}else {
			return "over";
		}
	}
	
	
	@GetMapping("getByUserIdxList")
	public List<Game> getByUserIdxList(
				@RequestParam(value="idxs") List<Integer> list,
				@RequestParam(value="ntm", defaultValue="0") long nowTimeMill
			) {
		
		if(list.size()==0) {
			 List<Game> emptyList
	            = Collections.<Game>emptyList();
			 
			 return emptyList;
		}else {
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("user_idx_list", list);
			map.put("ntm",nowTimeMill);
			
			
			List<Game> games = gameService.getByUserIdxList(map);
			
			return games;
		}
		
		
	}
	
	
	//game made by user
	@RequestMapping(value="getCurrentGameByUserIdxWithLimit",method= {RequestMethod.GET})
	public List<Game> getCurrentGameByUserIdxWithLimit(
				@RequestParam(value="user_idx") int user_idx,
				@RequestParam(value="cnt") int cnt
			){
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("user_idx", user_idx);
		map.put("cnt", cnt);
		
		List<Game> list = gameService.getCurrentGameByUserIdxWithLimit(map);
		
		return list;
	}
	
	
	
	@RequestMapping(value="getCurrentGameByUserIdx",method= {RequestMethod.GET})
	public List<Game> getCurrentGameByUserIdx(
				@RequestParam(value="user_idx") int user_idx,
				@RequestParam(value="ntm") long nowTimeMill
			){
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("user_idx", user_idx);
		map.put("now_time_mill", nowTimeMill);
		
		List<Game> list = gameService.getCurrentGameByUserIdx(map);
		
		return list;
	}
	
	
	
	@RequestMapping(value="getByUserIdx",method= {RequestMethod.GET})
	public List<Game> getByUserIdx(
				@RequestParam(value="user_idx") int user_idx
			){
		
		Game game = new Game();
		game.setUser_idx(user_idx);
		
		
		List<Game> list = gameService.getByUserIdx(game);
		
		return list;
	}
	

	@RequestMapping(value="getByIdx",method= {RequestMethod.GET})
	public Game getByIdx(
				@RequestParam(value="game_idx") long game_idx
			){
		
		Game game = new Game();
		game.setGame_idx(game_idx);
		
		
		return gameService.getByIdx(game);
	}
	

	
	@RequestMapping(value="search",method= {RequestMethod.POST})
	public List<Game> search(
				@RequestBody Map<String, Object> map
			) throws Exception{
		
		List<Game> list = gameService.search(map);
		
		return list;
	}
	
	
	@RequestMapping(value="add", method= RequestMethod.POST)
	public String add(
				@RequestParam(value="uidx") long user_idx,
				@RequestParam(value="sidx") long stadium_idx,
				@RequestParam(value="sd") String start_date,
				@RequestParam(value="w") String weekday,
				@RequestParam(value="sh") int start_hr,
				@RequestParam(value="sts") String start_time_str,
				@RequestParam(value="stm") long start_time_mill,
				@RequestParam(value="etm") long end_time_mill,
				@RequestParam(value="hr") int period_hr,
				@RequestParam(value="ntn") int num_to_num,
				@RequestParam(value="hm") int hw_mny_team,
				@RequestParam(value="g") String gender,
				@RequestParam(value="top") String team_or_person,
				@RequestParam(value="fop") String free_or_pay,
				@RequestParam(value="eg") String end_game_ny,
				@RequestParam(value="p") int price,
				@RequestParam(value="c", defaultValue="") String content,
				@RequestParam(value="cnt") int player_cnt,
				@RequestParam(value="pay_link_url", defaultValue="") String pay_link_url
			) {
		
	
		Game game = new Game();
		game.setUser_idx(user_idx);
		game.setStadium_idx(stadium_idx);
		game.setStart_date(start_date);
		game.setWeekday(weekday);
		game.setStart_hr(start_hr);
		game.setStart_time_str(start_time_str);
		game.setEnd_time_mill(end_time_mill);
		game.setStart_time_mill(start_time_mill);
		game.setPeriod_hr(period_hr);
		game.setNum_to_num(num_to_num);
		game.setHw_mny_team(hw_mny_team);
		game.setGender(gender);
		game.setTeam_or_person(team_or_person);
		game.setFree_or_pay(free_or_pay);
		game.setEnd_game_ny(end_game_ny);
		game.setPrice(price);
		game.setContent(content);
		game.setPlayer_cnt(player_cnt);
		game.setPay_link_url(pay_link_url);
		
		
		gameService.add(game);
		
		return MyHttpHeader.SUCCESS;
	}
	
}
